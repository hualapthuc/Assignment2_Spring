package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.MemberEntity;

public interface MemberService {
    public void addMember(MemberEntity memberEntity);
    public void deleteMember(int id);
    public void updateMember(MemberEntity memberEntity);
    public MemberEntity getMemberById(int id);
}
