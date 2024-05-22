package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req,
                        HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream();
        // 여기에서 선언된 messageBody 가 API 서버에서 POST 로 요청한 데이터가 된다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);// 문자를 반환할떄의 encoding 규격

        System.out.println("messageBody = " + messageBody);

        resp.getWriter().write("ok");
    }
}
