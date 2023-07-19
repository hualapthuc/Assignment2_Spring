package com.example.assignment2_spring.controller;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.service.ContentService;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
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
    public String showLogin(Model model, HttpServletRequest request, @PageableDefault(size = 6) Pageable pageable) {
        List<ContentEntity> list = contentService.getAllContent();
        //độ dài phần tử mỗi trang
        int pageSize = pageable.getPageSize();
        //số trang hiện tại
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<ContentEntity> pageContentList;
        //kiem tra  list hiện tại có ít hơn trang bắt đầu{có có 10 phan tu}
        if (list.size() < startItem) {
            pageContentList = Collections.emptyList();
        } else {
            //truong hop list đủ phần tử
            //tinh chỉ số cuối cùng của phần tử trên trang hiện tại k vượt quá kích thước của danh sách ban đầu
            int toIndex = Math.min(startItem + pageSize, list.size());
            //lay một phần của danh sách ban đầu từ startItem đến toIndex roi gan cho pageContentList
            pageContentList = list.subList(startItem, toIndex);
        }

        Page<ContentEntity> pageContent = new PageImpl<>(pageContentList, pageable, list.size());

        model.addAttribute("page", pageContent);
        model.addAttribute("listContent1", pageContentList);
        request.getAttribute("success");
        model.addAttribute("login", new Login());
        model.addAttribute("listContent",contentService.getAllContent());
        return "/user/login";
    }
    @PostMapping("")
    public String doLogin(@Valid Login login, BindingResult br, Model model, HttpServletRequest request) {
        if(br.hasErrors()) {
            return "user/login";
        }

        MemberEntity memberEntity = memberService.login(login);
        if(memberEntity == null) {
            model.addAttribute("error", "Incorrect Username or Password");
            return "user/login";
        }
        model.addAttribute("member", memberEntity);
        request.setAttribute("success", "Login successfully!!");
        return "redirect:/login/view-content";
    }
    @GetMapping("/view-content")
    public  String contentList(Model model) {
        MemberEntity member = (MemberEntity) model.getAttribute("member");
        model.addAttribute("listContent",contentService.getAllContent());
        model.addAttribute("listContent1",contentService.getByUsername(member.getUserName()));
        model.getAttribute("member");
        return "content/view-content";
    }
    @GetMapping("/form-content")
    public String createContent(Model model) {
        model.addAttribute("contents",new ContentEntity());
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
    @GetMapping("/content/view/{id}")
    public String showViewContent(@PathVariable("id") Integer id, Model model) {
        ContentEntity content = contentService.getContentById(id);
        model.addAttribute("contents", content);
        model.getAttribute("member");
        return "content/content";
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
    public String SearchContentEntity(ContentEntity content, Model model, String keyword) {
        if(keyword!=null) {
            MemberEntity member = (MemberEntity) model.getAttribute("member");
            List<ContentEntity> list = contentService.getByKeyword(keyword, member.getUserName());
            model.addAttribute("listContent1", list);
        }else {
            List<ContentEntity> list = contentService.getAllContent();
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
//    @GetMapping("/view-content")
//    public String getContents(@RequestParam(defaultValue = "0") int page, Model model) {
//        MemberEntity member = (MemberEntity) model.getAttribute("member");
//        if (member != null) {
//            List<ContentEntity> contentList = member.getContentEntityList();
//            model.addAttribute("listContent", contentList);
//        }
//        else {
//            return "redirect:/register";
//        }
//        Page<ContentEntity> contentPage;
//        if (member != null) {
//            member = memberService.register(member);
//            contentPage = contentService.findByMemberEntity(member, PageRequest.of(page, 5));
//        } else {
//            contentPage = contentService.getAllContent(PageRequest.of(page, 5));
//        }
//        model.addAttribute("contents", contentPage.getContent());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", contentPage.getTotalPages());
//        return "content/view-content";
//    }
}
