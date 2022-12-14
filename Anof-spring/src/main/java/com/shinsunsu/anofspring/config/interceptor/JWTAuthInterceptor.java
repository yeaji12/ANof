package com.shinsunsu.anofspring.config.interceptor;

import com.shinsunsu.anofspring.config.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JWTAuthInterceptor implements HandlerInterceptor {

    private final JwtTokenProvider jwtTokenProvider;

    //컨트롤러 실행 전 수행 (true -> 컨트롤러로 진입, false -> 진입 X)
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String token = jwtTokenProvider.resolveToken(request);

//        // 테스트 위해 임시로 주석 처리
//        if (!jwtTokenProvider.validateToken(token)) {
//            throw new Exception("유효하지 않은 X-AUTH-TOKEN");
//        }

        return true;
    }
}