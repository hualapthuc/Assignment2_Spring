package com.example.assignment2_spring.service.impl;

import com.example.assignment2_spring.entity.ContentEntity;
import com.example.assignment2_spring.entity.MemberEntity;
import com.example.assignment2_spring.repository.ContentRepository;
import com.example.assignment2_spring.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;
    @Override
    public List<ContentEntity> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public void createContent(ContentEntity content) {
       contentRepository.save(content);
    }

    @Override
    public void deleteContent(Integer id) {
        contentRepository.deleteById(id);
    }

    @Override
    public void editContent(ContentEntity content) {
          contentRepository.save(content);
    }

    @Override
    public ContentEntity getContentById(int id) {
        return contentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("content not found"));
    }
    @Override
    public List<ContentEntity> getByKeyword(String keyword) {
        return contentRepository.findByKeyword(keyword);
    }

    @Override
    public Page<ContentEntity> getAllContents(Pageable pageable) {
        return contentRepository.findAll(pageable);
    }

    @Override
    public Page<ContentEntity> findByMemberEntity(MemberEntity memberEntity, Pageable pageable) {
        return contentRepository.findByMemberEntity(memberEntity, pageable);
    }

    @Override
    public Page<ContentEntity> getPaginatedContents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createDate").descending());
        return contentRepository.findAll(pageable);
    }

    @Override
    public List<ContentEntity> getMemberContentPaged(int memberId, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("createDate").descending());
        Page<ContentEntity> contentPage = contentRepository.findByMemberId(memberId, pageable);

        return contentPage.getContent();
    }

    @Override
    public int getTotalPagesForMemberContent(int memberId, int pageSize) {
        Pageable pageable = PageRequest.of(0, pageSize);
        Page<ContentEntity> contentPage = contentRepository.findByMemberId(memberId, pageable);

        return contentPage.getTotalPages();
    }

    @Override
    public List<ContentEntity> findByMemberEntity(MemberEntity memberEntity) {
        return contentRepository.findByMemberEntity(memberEntity);
    }


}
