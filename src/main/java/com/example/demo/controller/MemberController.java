package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    //회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberDto memberDto) {

        System.out.println("MemberController.save");
        System.out.println("memberDto = " + memberDto);
        service.save(memberDto);

        return "login";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDto memberDTO, HttpSession session) {
        MemberDto loginResult = service.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }

    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDto> memberDtoList = service.findAll();
        //어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("memberList", memberDtoList);
        return "list";
    }

    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model) {
        MemberDto memberDto = service.findbyId(id);
        model.addAttribute("member", memberDto);
        return "detail";
    }


    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model) {
        String myEmail = (String) session.getAttribute("loginEmail");
        MemberDto memberDto = service.updateForm(myEmail);
        model.addAttribute("updateMember", memberDto);
        return "update";
    }

    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberDto memberDto) {
        service.update(memberDto);
        return "redirect:/member/" + memberDto.getId();
    }

    @GetMapping("/member/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/member/";
    }


    @GetMapping("/member/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }


    @PostMapping("/member/email-check")
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        System.out.println("memberEmail = " + memberEmail);
        String checkResult = service.emailCheck(memberEmail);
        return checkResult;
    }
}
