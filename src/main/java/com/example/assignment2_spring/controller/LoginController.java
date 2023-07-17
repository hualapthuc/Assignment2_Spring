package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.service.ContentService;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
@SessionAttributes("member")
public class LoginController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private ContentService contentService;
    @ModelAttribute("member")
    public MemberEntity memberEntity() {
        return new MemberEntity();
    }
    @GetMapping("")
    public String showLogin(Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("listContent",contentService.getAllContent());
        return "/user/login";
    }
    @PostMapping("")
    public String doLogin(@Valid Login login, BindingResult br, Model model) {
        if(br.hasErrors()) {
            return "user/login";
        }

        MemberEntity memberEntity = memberService.login(login);
        if(memberEntity == null) {
            model.addAttribute("error", "Incorrect Username or Password");
            return "user/login";
        }
        model.addAttribute("member", memberEntity);
        return "redirect:/login/view-content";
    }
    @GetMapping("/view-content")
    public  String contentList(Model model, @ModelAttribute("member") MemberEntity member) {
        model.addAttribute("listContent",contentService.getAllContent());
        model.addAttribute("listContent1",contentService.getByUsername(member.getUserName()));
        model.getAttribute("member");
        return "content/view-content";
    }
    @GetMapping("/form-content")
    public String createContent(Model model) {
        model.addAttribute("contents",new ContentEntity());
        model.getAttribute("member");
        return "content/form-content";
    }
    @PostMapping("/save-content")
    public  String saveContent(@ModelAttribute ContentEntity content) {
        contentService.createContent(content);
        return "redirect:/login/view-content";
    }
    @GetMapping("/content/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("contents", content);
        model.getAttribute("member");
        return "content/edit-content";
    }
    @PostMapping ("/update-content")
    public String updateContent(@ModelAttribute("contents") ContentEntity content) {
        contentService.editContent(content);
        return "redirect:/login/view-content";
    }
    @GetMapping("/content/delete/{id}")
    public String deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return "redirect:/login/view-content";
    }
    @GetMapping("/search")
    public String SearchContentEntity(@ModelAttribute("member") MemberEntity member, Model model, String keyword) {
        if(keyword!=null) {
            List<ContentEntity> list = contentService.getByKeyword(keyword);
            model.addAttribute("listContent1", list);
        }else {
            List<ContentEntity> list = contentService.getByUsername(member.getUserName());
            model.addAttribute("listContent1", list);}
        return "content/view-content";
    }
    @GetMapping("/member/edit-profile")
    public String editProfile(Model model, @ModelAttribute("member") MemberEntity member) {
        model.addAttribute("member1", memberService.getMemberById(member.getId()));
        return "member/edit-profile";
    }
    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberEntity member) {
        memberService.editMember(member);
        return "redirect:/login/member/view-profile";
    }
    @GetMapping("/member/change-password")
    public String changPassword(Model model) {
        return "member/change-password";
    }
    @PostMapping("/member/updatePassword")
    public String updatePassword(@RequestParam("newPassword") String newPassword,
                                 @RequestParam("id") int id) {
        memberService.updatePassword(newPassword, id);
        return "redirect:/login";
    }
    @GetMapping("/member/view-profile")
    public String viewProfile(Model model, @ModelAttribute("member") MemberEntity member) {
        model.addAttribute("member1", memberService.getMemberById(member.getId()));
        return "member/view-profile";
    }

}
