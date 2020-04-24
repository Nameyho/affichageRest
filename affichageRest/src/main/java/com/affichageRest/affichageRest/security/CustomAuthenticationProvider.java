package com.affichageRest.affichageRest.security;

import com.affichageRest.affichageRest.model.User;
import com.affichageRest.affichageRest.services.UserService;
import com.affichageRest.affichageRest.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user= new User();


            user= userService.findByUsername(name);


        System.out.println(name + "auth"  +password);
        System.out.println(user.getUsername() + "user" +user.getPassword());
        System.out.println("bad password");
        if(user==null){
            System.out.println("user null");
            throw new BadCredentialsException("1000");
        }

        if (!(password.equals(user.getPassword()))) {
            System.out.println(name + "auth"  +password);
            System.out.println(user.getUsername() + "user" +user.getPassword());
            System.out.println("bad password");
            throw new BadCredentialsException("1000");
        }

      /*  if (!(bCryptPasswordEncoder.encode(password)
                == user.getPassword())) {

            throw new BadCredentialsException("1000");
        }*/
            return new UsernamePasswordAuthenticationToken(
                    name, password);

    }


    @Override
    public boolean supports(Class<?> authentication) {
         return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
}
}