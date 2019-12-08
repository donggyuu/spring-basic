package com.example.restfulapi.service;

import com.example.restfulapi.entity.Essay;

public interface EssayService {

    Iterable<Essay> findAllEssayList();

    Essay createOneEssay(Essay essay);

    Essay readOneEssayById(long essayId);

    Essay updateOneEssayById(long essayId, Essay updateEssay);

    void deleteOneEssayById(long essayId);

}