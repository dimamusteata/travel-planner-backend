package com.wonderwiser.travelplanner.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonderwiser.travelplanner.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/auth")
public class DevAuthController {
  private final UserRepository repo; private final DevSessionService sessions;
  public DevAuthController(UserRepository r, DevSessionService s){ this.repo=r; this.sessions=s; }

  public record LoginReq(String email,String password){}
  public record TokenRes(String token){}

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginReq r){
    var u = repo.findByEmail(r.email());
    if (u.isPresent() && u.get().getPassword().equals(r.password())) { 
      String token = sessions.createToken(u.get().getId());
      return ResponseEntity.ok(new TokenRes(token));
    }
    return ResponseEntity.status(401).build();
  }
}