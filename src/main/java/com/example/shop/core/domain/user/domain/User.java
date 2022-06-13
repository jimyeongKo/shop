package com.example.shop.core.domain.user.domain;

import com.example.shop.core.domain.user.dto.UserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    //유저 아이디
    @Column(nullable = false, unique = true)
    private String userId;

    //유저 비밀번호
    @Column(nullable = false)
    private String password;

    //유저 이름
    @Column(nullable = false)
    private String userName;

    //생년월일 0000-00-00
    private String birth;

    @Column(nullable = false, unique = true)
    //핸드폰 번호
    private String phoneNum;

    //등급 -실버 -골드 -플레티넘 -귀하신분
    private String memberShip;

    //포인트
    private Integer point;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private final List<String> roles = new ArrayList<>();

    public static User create(UserRequest request, String encodePassword) {
        return User.builder()
                .userId(request.getUserId())
                .password(encodePassword)
                .userName(request.getUserName())
                .birth(request.getBirth())
                .phoneNum(request.getPhoneNum())
                .memberShip("silver")
                .point(0)
                .roles(Collections.singletonList("ROLE_USER"))
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
