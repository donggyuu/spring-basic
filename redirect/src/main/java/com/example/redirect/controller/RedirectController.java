package com.example.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/affiliate")
public class RedirectController {

    @RequestMapping(method = RequestMethod.GET, value = "/{id:^[0-9]{1,9}$}")
    public String redirectBase(@PathVariable Integer id) {

        // TODO : yml파일에서 읽어오도록 수정
        // if(yml파일의 첫번호일치):
        //     해당 번호의 link를 return값으로 가져옴


        // https://blog.naver.com/donggyu_rhee/222202900755
        if (id.equals(1)) {
            // 에어팟 프로
            return "redirect:https://coupa.ng/bR2NW3";
        } else if (id.equals(2)) {
            // 닌텐도 에어팟 케이스
            return "redirect:https://coupa.ng/bR9hes";
        } else if (id.equals(3)){
            // m1맥북에어
            return "redirect:https://coupa.ng/bRNfDB";
        } else if (id.equals(4)) {
            // 매직키보드2
            return "redirect:https://coupa.ng/bR2Nyh";
        }

        if (id.equals(10)) {
            // https://blog.naver.com/donggyu_rhee/222325525021
            // 아이패드 에어4
            return "redirect:https://coupa.ng/b0Nps6";
        } else if (id.equals(11)) {
            // https://blog.naver.com/donggyu_rhee/222260561439
            // 레노버 e14
            return "redirect:https://coupa.ng/b0NqHx";
        }

        // default
        return "redirect:http://www.naver.com";
    }


}
