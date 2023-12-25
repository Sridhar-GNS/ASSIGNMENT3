package com.example.assignment3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User implements UserDetails {
    @Id
    int user_id;

    String name;

    String password;


    String user_secret;

    Boolean user_status;

    Boolean user_enrolled;

    Boolean user_enrollapproved;

    Double user_latitude;

    Double user_longitude;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", user_secret='" + user_secret + '\'' +
                ", user_status=" + user_status +
                ", user_enrolled=" + user_enrolled +
                ", user_enrollapproved=" + user_enrollapproved +
                ", user_latitude=" + user_latitude +
                ", user_longitude=" + user_longitude +
                ", wallet=" + wallet +
                ", role=" + role +
                '}';
    }

    @Enumerated(EnumType.STRING)
    Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
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
