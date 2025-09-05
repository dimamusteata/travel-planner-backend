package com.wonderwiser.travelplanner.auth;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

@Service
public class DevSessionService {
  private final Map<String, Long> sessions = new ConcurrentHashMap<>();
  public String createToken(Long userId){ String t = UUID.randomUUID().toString(); sessions.put(t, userId); return t; }
  public Long resolve(String token){ return sessions.get(token); }
}