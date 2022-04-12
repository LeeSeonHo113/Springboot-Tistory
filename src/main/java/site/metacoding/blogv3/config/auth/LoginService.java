package site.metacoding.blogv3.config.auth;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv3.domain.user.User;
import site.metacoding.blogv3.domain.user.UserRepository;

// IoC 컨테이너에서 UserDetailsService타입을 찾아서 메서드를 호출해준다.
@RequiredArgsConstructor
@Service
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username : " + username);
        System.out.println("DB에 확인 들어간다.");

        Optional<User> userOp = userRepository.findByUsername(username);

        if (userOp.isPresent()) {
            return new LoginUser(userOp.get());
            // } else {
            // throw new CustomException("유저네임이 없습니다.");
        }
        return null;
    }
}