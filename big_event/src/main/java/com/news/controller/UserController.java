package com.news.controller;

import com.news.pojo.Result;
import com.news.pojo.User;
import com.news.service.UserService;
import com.news.utils.JwtUtil;
import com.news.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public Result addUser(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        User user =  userService.findByUserName(username);
        if(user == null){
            userService.addUser(username,password);
            return Result.success();
        }else{
            return Result.error("該用戶名: "+username+"已存在");
        }
    }
    @PostMapping("/login")
    public Result<String> login(String username,String password){
        User user = userService.findByUserName(username);
        if(user == null){
            return Result.error("該用戶不存在");
        }
        if(user.getPassword().equals(password)){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
            String token = JwtUtil.getToken(claims);
            return Result.success(token);
        }else{
            return Result.error("密碼錯誤");
        }
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(){
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String)map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
