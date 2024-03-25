package com.genshin.genshinrolls.entity.Player;

import com.genshin.genshinrolls.enums.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class PlayerEntity implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private int rollsWithoutRarityFive;
    private int rollsWithoutRarityFour;
    private HeroGuaranteeType heroGuaranteeType;
    private WeaponGuaranteeType weaponGuaranteeType;
    private Long chosenWeaponId; //one-to-one
    private int rollsWithoutRarityFiveWeaponBanner;
    private int rollsWithoutRarityFourWeaponBanner;
    private String password;
    private String role;

//    public PlayerEntity(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return name;
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

