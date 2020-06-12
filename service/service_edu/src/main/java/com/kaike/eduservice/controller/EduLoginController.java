package com.kaike.eduservice.controller;

import com.kaike.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduLoginController {

    // login
    @PostMapping("login")
    public R login(){
        return R.ok().data("token","admin");
    }


    // info
    @GetMapping("info")
    public R info() {
        return R.ok().data("roles", "[admin]").data("name", "admin")
                .data("avatar", "https://p.ssl.qhimg.com/t013a0ad444a9ee4ec7.png");
    }
}
