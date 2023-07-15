package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.model.Register;
import com.example.assignment2_spring.repository.MemberRepository;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void register(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void updateMember(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
    }

    @Override
    public MemberEntity getMemberById(int id) {
        return memberRepository.getById(id);
    }

    @Override
    public MemberEntity login(Login login) {
        return memberRepository.findMemberEntitiesByUserNameAndPassword(login.getUsername(), login.getPassword());
    }
}
