package com.some.boardproject.controller;

import com.some.boardproject.dto.ResponseDTO;
import com.some.boardproject.dto.UserDTO;
import com.some.boardproject.entity.User;
import com.some.boardproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class HomeController {


    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("/")
    public String home() {


        return "inc/home";
    }

//    @GetMapping("/test")
//    public String test(Model model, HttpServletRequest request) {
//        model.addAttribute("name", "jhkim");
//        model.addAttribute("addr", "Seoul");
//
//        model.addAttribute("list", Arrays.asList("kor", "usa", "china", "japan", "england"));
//        model.addAttribute("cno", "111");
//
//        model.addAttribute("member", new Member("test", 33));
//
//        //
//        request.setAttribute("pnum", 1212);
//
//        HttpSession session = request.getSession();
//        session.setAttribute("id", "jhkim");
//
//        ServletContext application = session.getServletContext();
//        application.setAttribute("email", "test@gmail.com");
//
//        return "test";
//    }

    @GetMapping("/login/register")
    public String register() {

        return "/login/register";
    }

    @GetMapping("/login/adminRegister")
    public String adminRegister() {

        return "/login/adminRegister";
    }

    // 회원가입
    @PostMapping("/login/register")
    public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO) {
//        userService.insertUser(user);
//        return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원 가입 성공 완료!!");

        User user = modelMapper.map(userDTO, User.class);
        System.out.println("user.getUserId = " + user.getUserId());

        // 아이디 중복체크
        User findUser = userService.getUser(user.getUserId());
        System.out.println("findUser.getId() = " + findUser.getUserId());

        if (findUser.getUserId() == null){
            userService.insertUser(user);

            return new ResponseDTO<>(HttpStatus.OK.value(),user.getUserName()+"님 회원가입 성공했습니다!!");
        }else {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUserName()+"님은 이미 회원이십니다");
        }
    }

    // 관리자 회원가입
    @PostMapping("/login/adminRegister")
    public @ResponseBody ResponseDTO<?> insertAdmin(@Valid @RequestBody UserDTO userDTO) {
//        userService.insertUser(user);
//        return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "님 회원 가입 성공 완료!!");

        User user = modelMapper.map(userDTO, User.class);
        System.out.println("user.getId() = " + user.getUserId());

        // 아이디 중복체크
        User findUser = userService.getUser(user.getUserId());
        System.out.println("findUser.getId() = " + findUser.getUserId());

        if (findUser.getUserId() == null){
            userService.insertAdmin(user);

            return new ResponseDTO<>(HttpStatus.OK.value(),user.getUserName()+"님 회원가입 성공했습니다!!");
        }else {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUserName()+"님은 이미 회원이십니다");
        }
    }

    @GetMapping("/login/login")
    public String login() {

        return "/login/login";
    }

    // 로그인 인증 처리
    @PostMapping("/login/login")
    public @ResponseBody ResponseDTO<?> login(@RequestBody User user
            , HttpSession session) {
        User findUser = userService.getUser(user.getUserId());

        // 검색결과 유무와 사용자가 입력한 비밀번호 검증
        if (findUser.getUserId() == null) {
            return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),
                    "아이디가 존재하지 않습니다!!");
        } else {
            // 비번 검증
            if (user.getUserPw().equals(findUser.getUserPw())) {
                session.setAttribute("principal", findUser);


                return new ResponseDTO<>(HttpStatus.OK.value(), findUser.getUserName() +
                        "님 로그인 성공했습니다!!");
            } else {
                return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),
                        "비밀번호 오류");
            }
        }
    }

    // 로그아웃
    @GetMapping("/login/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
