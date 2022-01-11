package com.github.agem20.Credit_System_TQI.services;

import com.github.agem20.Credit_System_TQI.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service("userDetailsService")
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private ClientesService clientesService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Cliente> cliente = clientesService.findByEmail(email);

        if(cliente.isPresent()){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(cliente.get().getRole());
            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(authority);
            User user = new User(cliente.get().getEmail(), cliente.get().getSenha(), authorities);
            return user;
        }

        return null;
    }
}