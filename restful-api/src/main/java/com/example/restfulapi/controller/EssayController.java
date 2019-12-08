package com.example.restfulapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulapi.entity.Essay;
import com.example.restfulapi.service.EssayService;

@RestController
@RequestMapping("/essay")
public class EssayController {

    private EssayService essayService;

    @Autowired
    public EssayController(EssayService essayService){
        this.essayService = essayService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Essay> findAllEssayList() {
        return essayService.findAllEssayList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Essay createOneEssay(@RequestBody Essay essay) {
        return essayService.createOneEssay(essay);
    }

    @RequestMapping(value = "/{essayId}", method = RequestMethod.GET)
    public Essay readOneEssayById(@PathVariable(value="essayId") long essayId) {
        return essayService.readOneEssayById(essayId);
    }

    @RequestMapping(value = "/{essayId}", method = RequestMethod.PUT)
    public Essay updateOneEssayById(
            @PathVariable(value="essayId") long essayId,
            @RequestBody Essay updateEssay) {
        return essayService.updateOneEssayById(essayId, updateEssay);
    }

    @RequestMapping(value = "/{essayId}", method = RequestMethod.DELETE)
    public void deleteOneEssayById(@PathVariable(value="essayId") int essayId) {
        essayService.deleteOneEssayById(essayId);
    }

}