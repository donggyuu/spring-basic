package com.example.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO : 여러명의 쿠팡 링크로 return하는데, 각각 method 만드는 방법 말고 중복 줄이기
// TODO : restTemplate의 setHeader를 이용해 referer조작하기

@Controller
@RequestMapping("/affiliate")
public class RedirectController {

    @RequestMapping(method = RequestMethod.GET, value = "/{id:^[0-9]{1,9}$}")
    public String redirectBase(@PathVariable Integer id) {

        System.out.println("input id : " + id);

        // 여러 유저도 사용할 경우 로직(execute later)
        // 1. resttemplate로, 쿠팡 파트너스로 접속
        // 2. if 제3자의 request : 제3자의 url을 붙여서 return
        // 3. else : 나의 url을 붙여서 return

        // TODO : service클래스에 구현
        // TODO : coupang_link는 yml파일에 넣고 Java로 불러와서 비교로 수정
        if (id.equals(1)) {
            // 1에 해당하는 coupang링크로 이동
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

        return "redirect:http://www.naver.com";
    }

}
