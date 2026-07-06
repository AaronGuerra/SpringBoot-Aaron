package com.example.tiendaonline.security;


import com.example.tiendaonline.model.ClienteModel;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
public class ClienteDetails implements UserDetails {

    private final ClienteModel clienteMod;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(
                "ROLE_" + clienteMod.getRol().name()
        ));
    }

    @Override
    public String getUsername() {
        return clienteMod.getCorreo();
    }

    @Override
    public String getPassword() {
        return clienteMod.getPassword();
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
