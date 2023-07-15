package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;

public interface MemberService {
    public void register(MemberEntity memberEntity);
    public MemberEntity login(Login login);
    public void deleteMember(int id);
    public void updateMember(MemberEntity memberEntity);
    public MemberEntity getMemberById(int id);
}
