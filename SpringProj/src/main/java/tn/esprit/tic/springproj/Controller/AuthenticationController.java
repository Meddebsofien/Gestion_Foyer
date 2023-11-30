package tn.esprit.tic.springproj.Controller;


import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tic.springproj.Models.AuthenticationRequest;
import tn.esprit.tic.springproj.Models.AuthenticationResponse;
import tn.esprit.tic.springproj.Models.RegisterRequest;
import tn.esprit.tic.springproj.Models.User;
import tn.esprit.tic.springproj.services.AuthenticationService;

import java.io.IOException;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor

public class AuthenticationController {

  private final AuthenticationService service;
private AuthenticationManager authenticationManager;

  @GetMapping("/profil")
  public Authentication authentication(Authentication authentication){
    return authentication;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

//  @PostMapping("/refresh-token")
//  public void refreshToken(
//      HttpServletRequest request,
//      HttpServletResponse response
//  ) throws IOException {
//    service.refreshToken(request, response);
//  }
 @PostMapping("/login")
  public Map<String,String> login(String email , String password){
    Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
   Instant instant =Instant.now();
   Jwts 


  }

}
