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
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {


        String name = authentication.getName();
        String password = authentication.getCredentials().toString()+"";

        System.out.println(name);
        System.out.println(password);


        User user= userService.findByUsername(name);



        if(user==null){
            throw new BadCredentialsException("1000");
        }

        if (!(password.equals(user.getPassword()))) {



            System.out.println("mauvais mot de passe");
            throw new BadCredentialsException("1000");
        }

      /*  if (!(bCryptPasswordEncoder.encode(password)
                == user.getPassword())) {

            throw new BadCredentialsException("1000");
        }*/
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