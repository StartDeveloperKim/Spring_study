package jpabook.jpashop.controller;

import jpabook.jpashop.controller.form.MemberForm;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createFrom(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Validated MemberForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/createMemberForm";
        }

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member();
        member.setName(form.getName());
        member.setAddress(address);

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        /*
        * 위에서는 member Entity 객체를 바로 넘겨주고 있다. 하지만 이는 옳바르지 못하다.
        * 지금의 경우에는 객체의 단순하고 노출되도 괜찮은 내용만 있기에 바로 넘기지만 비밀번호같이
        * 노출되서는 안되는 내용이 포함되면 이를 배제하고 DTO를 사용하여 넘기는 것이 옳다.
        * 특히 API를 개발할 때는 더욱더 DTO를 통해 넘기는 것이 옳다. Entity를 변경하면 API 스펙이
        * 달라지기 떄문이다.
        * */
        return "members/memberList";
    }
}
