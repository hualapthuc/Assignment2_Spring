package com.example.assignment2_spring.service;

import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.model.Login;
import com.example.assignment2_spring.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface MemberService {
    void register(Register register);
    MemberEntity login(Login login);
    List<MemberEntity> getAll();
    void deleteMember(int id);
    void editMember(MemberEntity memberEntity);
    MemberEntity getMemberById(int id);
    MemberEntity updatePassword(String password, int id);
    MemberEntity findByUsername(String username);
    MemberEntity findByEmail(String email);
}
