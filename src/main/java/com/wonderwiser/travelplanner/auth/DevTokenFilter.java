package com.wonderwiser.travelplanner.auth;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.wonderwiser.travelplanner.repositories.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class DevTokenFilter extends OncePerRequestFilter {
  private final DevSessionService sessions; private final UserRepository repo;
  public DevTokenFilter(DevSessionService s, UserRepository r){ this.sessions=s; this.repo=r; }

  @Override protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
      throws ServletException, IOException {
    String t = req.getHeader("X-Auth-Token");
    if (t != null) {
      Long userId = sessions.resolve(t);
      if (userId != null) req.setAttribute("currentUserId", userId);
    }
    chain.doFilter(req, res);
  }
}