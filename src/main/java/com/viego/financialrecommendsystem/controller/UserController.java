package com.viego.financialrecommendsystem.controller;

import com.viego.financialrecommendsystem.common.AjaxResult;
import com.viego.financialrecommendsystem.entity.AccessRecord;
import com.viego.financialrecommendsystem.entity.User;
import com.viego.financialrecommendsystem.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
public class UserController {

    @Resource
    IUserService userService;

    /**
     * 用户登录的接口
     * 测试通过
     * @param user 用户实体类
     * @return user 对应的 json 数据
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user , HttpServletRequest request){
        log.info("正在尝试登录......");
        User login_user = userService.login(user);
        if (login_user != null){
            HttpSession session = request.getSession();
            session.setAttribute("UID",login_user.getUserId());
//            log.info("登录成功！UID = {}",BaseContext.getCurrentId());
            log.info("登录成功！UID = {}",login_user.getUserId());
            System.out.println(request.getSession().getAttribute("UID"));
            return AjaxResult.success("登录成功",login_user);
        }else{
            return AjaxResult.error("登录失败，用户名或密码错误");
        }
    }

    /**
     * 用户退出登录
     * @param request HttpServletRequest
     * @return string
     */
    @GetMapping("/logout")
    public AjaxResult logout(HttpServletRequest request){
        log.info("UID={}的用户正在退出登录.....",request.getSession().getAttribute("UID"));
        request.getSession().removeAttribute("UID");
        log.info("退出成功");
        return AjaxResult.success("退出成功");
    }

    /**
     * 根据用户的uid资产
     * @param userId 用户的 id
     * @return 用户的资产
     */
    @PostMapping("/assets")
    public AjaxResult assets(@RequestBody String userId){
        // TODO For input string: "1="
        userId = userId.substring(0,userId.length()-1);
        log.info("正在获取资产 UID = {}",userId);
        Integer assets = userService.getassets(Long.parseLong(userId));
        return AjaxResult.success("查询成功",assets);
    }

    /**
     * 添加访问记录对象，并不是每一次都添加
     * 当 Product.vue 组件被销毁的时候，我们再进行添加
     * @param record 访问记录对象
     * @return true 添加成功 false 添加失败
     */
    @PostMapping("/record")
    public AjaxResult record(@RequestBody List<AccessRecord> record){
        //每一次访问产品，都添加一次访问记录，以此来记录用户对产品的偏好
        boolean flag = userService.addRecord(record);
        if (flag){
            //添加成功
            return AjaxResult.success("添加成功");
        }else{
            return AjaxResult.error("添加失败");
        }
    }

}
