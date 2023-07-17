package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.model.Register;
import com.example.assignment2_spring.repository.MemberRepository;
import com.example.assignment2_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public List<MemberEntity> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public void register(Register register) {
        MemberEntity member = new MemberEntity();
        member.setFirstName(register.getFirstName());
        member.setLastName(register.getLastName());
        member.setUserName(register.getUsername());
        member.setEmail(register.getEmail());
        member.setPhone(register.getPhone());
        member.setPassword(register.getPassword());
        memberRepository.save(member);
    }

    @Override
    public void deleteMember(int id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void editMember(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
    }

    @Override
    public MemberEntity getMemberById(int id) {
        return memberRepository.getById(id);
    }

    @Override
    public MemberEntity updatePassword(String password, int id) {
        return memberRepository.updateMemberEntityByPasswordAfter(password, id);
    }

    @Override
    public MemberEntity isUsernameExist(Register register) {
        return memberRepository.findMemberEntityByUsername(register.getUsername());
    }


    @Override
    public MemberEntity login(Login login) {
        return memberRepository.findMemberEntityByUserNameAndPassword(login.getUsername(), login.getPassword());
    }
}
