package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;

import java.util.List;

public interface MemberService {
    void register(MemberEntity memberEntity);
    MemberEntity login(Login login);
    List<MemberEntity> getAll();
    void deleteMember(int id);
    void editMember(MemberEntity memberEntity);
    MemberEntity getMemberById(int id);
}
