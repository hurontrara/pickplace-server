//package com.server.pickplace.auth.controller;
//
//import com.server.pickplace.auth.dto.JwtRequestDto;
//import com.server.pickplace.auth.dto.MemberSignupRequestDto;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String login(@RequestBody JwtRequestDto request) {
//        return "login";
//    }
//
//    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String signup(@RequestBody MemberSignupRequestDto request) {
//        return "signup";
//    }
//}
