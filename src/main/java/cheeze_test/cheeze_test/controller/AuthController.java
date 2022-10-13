package cheeze_test.cheeze_test.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import cheeze_test.cheeze_test.Model.Role;
import cheeze_test.cheeze_test.Model.RoleName;
import cheeze_test.cheeze_test.Model.User;
import cheeze_test.cheeze_test.Repository.RoleRepository;
import cheeze_test.cheeze_test.Repository.UserRepository;
import cheeze_test.cheeze_test.exception.AppException;
import cheeze_test.cheeze_test.payload.ApiResponse;
import cheeze_test.cheeze_test.payload.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    //회원가입 컨트롤러
    @PostMapping("/signup")
    //ResponseEntity란?
    //HttpRequest에 대한 응답 데이터를 포함하는 클래스
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        //만약 UserRepository에 Nickname이 존재한다면
        if(userRepository.existsByNickname(signUpRequest.getNickname())) {
            return new ResponseEntity(new ApiResponse(false, "Nickname is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        //만약 UserRepository에 Email이 존재한다면
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        //사용자 계정 생성하기
        User user = new User(signUpRequest.getEmail(), signUpRequest.getNickname(), signUpRequest.getPassword(), signUpRequest.getIntro());

        //passwordEncoder = 스프링시큐리티, 비밀번호 보안을 위해 사용
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set"));

        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{Nickname}")
                .buildAndExpand(result.getNickname()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully!"));
    }
}


