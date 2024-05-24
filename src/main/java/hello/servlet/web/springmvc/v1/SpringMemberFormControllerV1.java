package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // @Controller : 스프링이 자동으로 SpringMemberFormControllerV1 을 스프링 빈에 등록
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") // 요청 정보 매핑 (해당 url 이 요청되면 아래의 process() 메서드가 실행된다)
    public ModelAndView process() {

        System.out.println("SpringMemberFormControllerV1.process");

        return new ModelAndView("new-form");
    }
}
