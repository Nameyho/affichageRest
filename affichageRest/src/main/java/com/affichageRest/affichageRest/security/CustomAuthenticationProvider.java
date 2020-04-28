package com.affichageRest.affichageRest.security;

import com.affichageRest.affichageRest.model.User;
import com.affichageRest.affichageRest.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceImpl userService;



    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {


        String name = authentication.getName();

        String password = authentication.getCredentials().toString();

        System.out.println(name);
        System.out.println(password);


        User user= userService.findByUsername(name);


BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


        if(user==null){
            throw new BadCredentialsException("1000");
        }

 String test = bCryptPasswordEncoder.encode("test");

        System.out.println(user.getPassword());
        System.out.println(password);
        System.out.println(bCryptPasswordEncoder.matches("test",test));

       if (!(bCryptPasswordEncoder.matches(password,user.getPassword()))) {

           System.out.println("mauvais mdp");

            throw new BadCredentialsException("1000");
        }
            return new UsernamePasswordAuthenticationToken(name, password,new ArrayList<>());

    }



    @Override
    public boolean supports(Class<?> authentication) {
         return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
}

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}