package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    // ModelView(반환) process(Map<key, value> paramMap.~
    ModelView process(Map<String, String> paramMap);
}
