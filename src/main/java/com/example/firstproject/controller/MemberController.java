package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage() {return "members/new";}

    @PostMapping("/join")
    public String join(MemberForm form) {
        System.out.println(form.toString()); // form이 제대로 넘어왔는지 확인
        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        System.out.println(member.toString()); //--- ➊ DTO가 엔티티로 잘 변환되는지 확인 출력
        // 2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString()); //----- ➋ member가 DB에 잘 저장되는지 확인 출력
        return "";
    }
}

