package com.example.restfulapi.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfulapi.entity.Essay;
import com.example.restfulapi.repository.AuthorRepository;
import com.example.restfulapi.repository.EssayRepository;

@Service
public class EssayServiceImpl implements EssayService {

    private AuthorRepository authorRepository;
    private EssayRepository essayRepository;

    @Autowired
    public EssayServiceImpl(
            AuthorRepository authorRepository, EssayRepository essayRepository) {
        this.authorRepository = authorRepository;
        this.essayRepository = essayRepository;
    }


    @Override
    public Iterable<Essay> findAllEssayList() {
        return essayRepository.findAll();
    }

    @Override
    public Essay readOneEssayById(long essayId) {
        return essayRepository.findById(essayId).orElse(null);
    }

    @Override
    @Transactional
    public Essay createOneEssay(Essay essay) {

        // save the new author
        authorRepository.save(essay.getAuthor());

        return essayRepository.save(essay);
    }

    @Override
    public void deleteOneEssayById(long essayId) {
        essayRepository.deleteById(essayId);
    }

    @Override
    public Essay updateOneEssayById(long id, Essay updateEssay) {

        Essay essay = essayRepository.findById(id).orElse(null);

        if ( updateEssay.getTitle() != null) {
            essay.setTitle(updateEssay.getTitle());
        }

        return essayRepository.save(essay);
    }

}
