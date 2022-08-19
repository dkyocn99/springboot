package com.cos.blog.controller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserApiController {

//@Autowired 대신에 아래와 같이
    private final UserService userService;
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {

        log.info("UserApiController: save 호출됨");
        //System.out.println("UserApiController: save 호출됨");
        //실제로 DB에 insert를 하고 아래에서 return
        user.setRole(RoleType.USER);
        userService.join(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //java오브젝트를 json으로 변환해서 리턴(jackson)
    }
}
