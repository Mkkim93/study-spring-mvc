package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;


public class MemberFormControllerV4 implements ControllerV4 {

    @Override // view 를 model 객체로 넘겨야 하기 때문에 Map<> model 선언
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        return "new-form";
    }
}
