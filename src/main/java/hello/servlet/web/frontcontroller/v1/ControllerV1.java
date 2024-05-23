package hello.servlet.web.frontcontroller.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {

    // 해당 인터페이스를 구현하면 실제 컨트롤러에서는 process 만 호출하면 res, req 모두 사용 가능 = 코드 최적화, 로직의 일관성
    void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
