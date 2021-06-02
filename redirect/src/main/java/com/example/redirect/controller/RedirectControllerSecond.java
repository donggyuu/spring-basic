package com.example.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pikachu")
public class RedirectControllerSecond {

    @RequestMapping(method = RequestMethod.GET, value = "/{id:^[0-9]{1,9}$}")
    public String redirectBase(@PathVariable Integer id) {

        // https://blog.naver.com/donggyu_rhee/222157621026
        if (id.equals(1)) {
            // 킨들
            return "redirect:https://coupa.ng/b0NY0e";
        } else if (id.equals(2)) {
            // 아이패드 미니5
            return "redirect:https://coupa.ng/b0NY3R";
        } else if (id.equals(3)){
            // https://blog.naver.com/donggyu_rhee/222155250162
            // Cinnamon Toast Crunch Cereal
            return "redirect:https://coupa.ng/b0NY9X";
        } else if (id.equals(4)) {
            // Honey Nut Cheerios
            return "redirect:https://coupa.ng/b0NZeE";
        } else if (id.equals(5)) {
            // Flipz White Fudge Pretzels
            return "redirect:https://coupa.ng/b0NZnu";
        } else if (id.equals(6)) {
            // https://blog.naver.com/donggyu_rhee/222153737537
            // 학교에서 알려주지 않는 17가지 실무 개발 기술
            return "redirect:https://coupa.ng/b0NZuI";
        } else if (id.equals(7)) {
            // https://blog.naver.com/donggyu_rhee/222151430934
            // k380
            return "redirect:https://coupa.ng/b0NZU8";
        }

        // default
        return "redirect:http://www.naver.com";
    }


}
