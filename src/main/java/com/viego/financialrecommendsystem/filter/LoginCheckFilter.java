package com.viego.financialrecommendsystem.filter;

import com.alibaba.druid.support.json.JSONUtils;
import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.common.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查用户是否应完成登录的过滤器
 */
// urlPatterns="/*"表示次拦截器，要眼界所有路径的请求
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径配置器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("拦截到请求：{}",request.getRequestURI());
        /**
         * 1.获取本次请求的URL
         * 2.判断你本次请求是否需要处理
         * 3.如果不需要处理，则直接放行
         * 4.判断登录状态，如果已经登录，则放行
         * 5.如果未登录，则返回未登录的结果
         */
        //1.获取本次请求
        String requestURI = request.getRequestURI();
        String[] urls = {
            "/FinancialRecommend/user/login",
            "/FinancialRecommend/user/logout",
                "/FinancialRecommend/img/**",
        };
        //2.判断本次请求是否需要处理
        boolean check = check(urls, requestURI);
        //3.如果不需要处理，则直接放行
        if (check){
            //匹配成功，不需要不处理直接放行
            log.info("本次请求不需要处理:{}",requestURI);
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //匹配失败，需要法处理，进行拦截
            log.info("本次请求需要处理：{}",request);
            Object uid = request.getSession().getAttribute("UID");
            if (uid != null){
                //用户已经登录直接放行
                log.info("已登录，放行");
                log.info("用户的 UID = {}",uid);
                BaseContext.setCurrentId((Long)uid );
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }else{
                //用户没有登录，通过输出流的燃放时，向前端返回数据
                log.info("用户未登录，向客户端返回NOTLOGIN");
                response.getWriter().write(JSONUtils.toJSONString(AjaxResult.error("NOTLOGIN")));
            }
        }
    }

    /**
     * 封装的静态方法
     * 判断请求是否需要处理
     * @param urls 需要处理的请求的数组
     * @param requestURI 当前请求的URL
     * @return 需要处理 true 不需要处理 false
     */
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match){
                //匹配成功
                return true;
            }
        }
        //匹配失败
        return false;
    }
}
