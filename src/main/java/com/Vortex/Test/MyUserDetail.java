package com.Vortex.Test;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetail implements UserDetails {
    private String myUserName;
    private String myUserPassword;

    public MyUserDetail(String st) {
        this.myUserName = st;
        this.myUserPassword = st;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // returning empty permissions for the user
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return myUserPassword;
    }

    @Override
    public String getUsername() {
        return myUserName;
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
