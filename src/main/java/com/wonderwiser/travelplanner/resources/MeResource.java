package com.wonderwiser.travelplanner.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wonderwiser.travelplanner.repositories.UserRepository;

@RestController
public class MeResource {
    private final UserRepository repo;
    public MeResource(UserRepository repo){ this.repo = repo; }

    @GetMapping("/me")
    public ResponseEntity<?> me(jakarta.servlet.http.HttpServletRequest req){
        Long uid = (Long) req.getAttribute("currentUserId");
        if (uid == null) return ResponseEntity.status(401).build();

        return repo.findById(uid)
            .map(u -> {
                var resp = new java.util.HashMap<String,Object>();
                resp.put("id", u.getId());
                resp.put("name", u.getName());   // pode ser null, HashMap aceita
                resp.put("email", u.getEmail()); // idem
                return ResponseEntity.ok(resp);
            })
            .orElse(ResponseEntity.status(401).build());
    }
}