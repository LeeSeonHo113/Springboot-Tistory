package site.metacoding.blogv3.config.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import site.metacoding.blogv3.domain.user.User;

@Data
@RequiredArgsConstructor
public class LoginUser implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 아래 기술들은 return이 true일때만 정상적으로 로그인이 된다.
    @Override
    public boolean isAccountNonExpired() { // 계정이 만료되지 않았는가?
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정이 잠기지 않았는가?
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 변경한지 오래되지 않았는가?
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정이 활성화 되어있는가?
        return true;
    }
}