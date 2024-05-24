package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 데이터 전달할 파라미터 지정
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 2. 데이터가 있는 객체를 저장하기 위한 객체 생성 및 save 메서드 실행
        Member member = new Member(username, age);
        memberRepository.save(member);

        // 3. 저장된 파라미터를 view 에 전달하기 위해 ModelAvnView 를 통해 실행
        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member);
        return mv;

    }
}
