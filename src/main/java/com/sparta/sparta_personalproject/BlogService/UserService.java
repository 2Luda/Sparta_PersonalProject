package com.sparta.sparta_personalproject.BlogService;

import com.sparta.sparta_personalproject.BlogDto.LoginRequestDto;
import com.sparta.sparta_personalproject.BlogDto.SignupRequestDto;
import com.sparta.sparta_personalproject.BlogEntity.Blog;
import com.sparta.sparta_personalproject.BlogEntity.User;
import com.sparta.sparta_personalproject.BlogEntity.UserRoleEnum;
import com.sparta.sparta_personalproject.BlogRepository.UserRepository;
import com.sparta.sparta_personalproject.Jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    public final JwtUtil jwtUtil;
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";

    @Transactional
    // 회원가입 서비스
    public void signup(SignupRequestDto signupRequestDto) {
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();

        boolean checkValueCondition = true;
        String pattern = "^[a-zA-Z0-9]*$";
        if(!(Pattern.matches(pattern,username) && username.length() >= 4 && username.length() <= 10)){
            System.out.println("닉네임이 잘못되었습니다.");
            checkValueCondition = false;
        }
        else if (!(Pattern.matches(pattern,password)) && password.length() >= 8 && password.length() <= 15){
            System.out.println("비밀번호가 잘못되었습니다.");
            checkValueCondition = false;
        }

        // 회원 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if(found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");

        }

//        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if(signupRequestDto.isAdmin()) {
            if(!signupRequestDto.getAdminToKen().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }
        if(checkValueCondition){
            User user = new User(username,password,role);
            userRepository.save(user);
            System.out.println("회원가입을 하셨습니다.");
        } else {
            System.exit(0);
        }
    }
    // 로그인 서비스
    @Transactional(readOnly = true)
    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if(!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("패스워드가 일치하지 않습니다.");
        }
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUsername(), user.getRole()));
        System.out.println("로그인 완료");
    }

}
