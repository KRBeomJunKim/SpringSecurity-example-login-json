package com.example.springbootsecurityjsonexample.security.filter;

import com.example.springbootsecurityjsonexample.security.exception.IllegalRequestJsonLogin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    protected JsonUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/api/login"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!isJsonPostRequest(request)) {
            throw new IllegalRequestJsonLogin("Authentication Request must have Json Header and POST method");
        }



        return null;
    }

    private boolean isJsonPostRequest(HttpServletRequest request) {
        return request.getHeader(HttpHeaders.CONTENT_TYPE).equals(MediaType.APPLICATION_JSON_VALUE)
                && request.getMethod().equals(HttpMethod.POST.name());
    }
}
