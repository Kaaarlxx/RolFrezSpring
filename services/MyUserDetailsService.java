package projekt.projekt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import projekt.projekt.models.User;
import projekt.projekt.security.MyUserDetails;


import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = service.findByEmail(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found:" + username));

        return user.map(MyUserDetails::new).get();
    }
}
