package com.heartsignal.dev.oauth;

import com.heartsignal.dev.exception.custom.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        log.info("request.getRequestURI() = {} ", request.getRequestURI());

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");


        String jsonResponse = String.format("{\"error\": \"%s\"}", ErrorCode.NOT_LOGIN_USER.getCode());

        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();

        log.error("error = {}", ErrorCode.NOT_LOGIN_USER.getCode());
    }
}

