package com.authentication.service.config;

import com.authentication.service.entity.Role;
import com.authentication.service.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * @author Artur Tomeyan
 * @date 03/11/2022
 */
public class UserDetailsImpl implements UserDetails {

    private final transient User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();

        Set<SimpleGrantedAuthority> role = new HashSet<>(Collections.singleton(new SimpleGrantedAuthority(roles.toString())));

//        for (Role role : roles) {
//        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return role;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}