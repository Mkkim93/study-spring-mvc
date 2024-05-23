package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV2 {

    // MyView 를 받아서 process 메서드를 외부에서 생성하면 myView 내부에 있는 render() 를 사용할 수 있다.
    MyView process(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException;
}
