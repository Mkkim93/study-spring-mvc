package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    // render 라는 메서드를 통해 서블릿에서 view 로 가는 로직을 하나의 메서드로 정의하였다 (코드의 단편화)
    public void render(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        modelToRequestAttribute(model, request); // 변수명 key, value 를 아래 로직에서 반복하면서 담는다. (Attribute() 가 담는거니까)
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        /**
         * 1. model 에 있는 데이터를 다 꺼낸다.
         * 2. map 의 loop 를 돌린다.
         * 3. render() 메서드의 modelToRequestAttribute(model, request) 에서 key, value 의 값을 모두 담는다.
         * */
        model.forEach((key, value)-> request.setAttribute(key, value));
    }
}
