package com.xxy.controller;

        import com.xxy.entity.model.JsonResponse;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/doLogin")
    public JsonResponse doLogin(String username, String password){

        return new JsonResponse(true, "登录成功");
    }
}
