package com.cos.blog.test;


import org.springframework.web.bind.annotation.*;

//사용자가 요청 -> 응답(html파일)
//@Controller

//사용자가 요청-> 응답(Data)
@RestController
public class HttpControllerTest {

    //http://localhost:8080/http/get?id=1&username=ssar&password=1234&email=ssar@nate.com
    //인터넷 브라우저 요청은 get만 된다.
    //http://localhost:8080/http/get
    //select
    @GetMapping("/http/get")
    public String getTest(Member member) {

        return "get요청: "+member.getId()+","+member.getUsername()+","+member.getPassword()+","+member.getEmail();
    }

    //MessageConverter(스프링부트)
    //appllication/json
    //insert
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member member) {

        return "post요청: "+member.getId()+","+member.getUsername()+","+member.getPassword()+","+member.getEmail();
    }

//    @PostMapping("/http/post")//text/plan
//    public String postTest(@RequestBody String text) {
//
//        return "post요청: "+text;
//    }

    //update
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member member) {

        return "put요청: "+member.getId()+","+member.getUsername()+","+member.getPassword()+","+member.getEmail();
    }

    //delete
    @DeleteMapping("/http/delete")
    public String deleteTest(@RequestBody Member member) {

        return "delete요청: "+member.getId()+","+member.getUsername()+","+member.getPassword()+","+member.getEmail();
    }
}
