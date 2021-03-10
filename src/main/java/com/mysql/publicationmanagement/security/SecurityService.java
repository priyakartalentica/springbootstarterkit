package com.mysql.publicationmanagement.security;

//import com.springboot.security.models.AuthenticationRequest;
//import com.springboot.security.models.AuthenticationResponse;
//import com.springboot.security.util.JwtUtil;
import com.mysql.publicationmanagement.security.models.AuthenticationRequest;
import com.mysql.publicationmanagement.security.models.AuthenticationResponse;
import com.mysql.publicationmanagement.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    //@GetMapping
//    @RequestMapping("/hello")
 /*   public String helloworld(){
        return "Hello World";
    }
*/

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
       try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
       }catch (BadCredentialsException e){
           throw new Exception("Incorrect Username or Password.", e);
       }

       final UserDetails userDetails=
               userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
       final String jwt=jwtTokenUtil.generateToken(userDetails);
       return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
