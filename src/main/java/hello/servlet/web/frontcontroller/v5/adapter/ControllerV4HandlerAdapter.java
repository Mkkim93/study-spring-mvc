package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4); // handler 가 넘어오는게 ConV3 가 맞으면 V3를 리턴한다.
    }

    @Override // supports instanceof 가 ControllerV3 이면 현재 메서드 handle() 가 실행 된다.
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException, ServletException {

        ControllerV4 controller = (ControllerV4) handler; // handler 를 ControllerV3 형식으로 호출 한다.

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        String viewName = controller.process(paramMap, model);

        // v4 로 변환되는 시점
        ModelView mv = new ModelView(viewName);

        mv.setModel(model);

        return mv;
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
