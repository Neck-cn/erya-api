//package common.controller;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.NoHandlerFoundException;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//public class DefaultController {
//
//    @RequestMapping("/error")
//    public void error(HttpServletRequest request) throws NoHandlerFoundException {
//        throw new NoHandlerFoundException(request.getMethod(),request.getRequestURI(),new HttpHeaders());
//    }
//}