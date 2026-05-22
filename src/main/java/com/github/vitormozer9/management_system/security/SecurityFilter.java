package com.github.vitormozer9.management_system.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.github.vitormozer9.management_system.providers.JWTprovider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private JWTprovider jwTprovider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain)
            throws ServletException, IOException {
        //SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        if(request.getRequestURI().startsWith("/company")) {
            if (header != null) {
            var subjectToken = this.jwTprovider.validateToken(header);

            if(subjectToken.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            request.setAttribute("company_id", subjectToken);
            UsernamePasswordAuthenticationToken auth = 
            new UsernamePasswordAuthenticationToken(subjectToken, null , Collections.emptyList());

            //Injetando Auth no Spring Security | para todas as requisições o Spring ter as infos do usuário
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        }
            
        filterChain.doFilter(request, response);
    }
    
}
