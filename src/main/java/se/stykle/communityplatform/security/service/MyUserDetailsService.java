package se.stykle.communityplatform.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.stykle.communityplatform.security.model.Users;
import se.stykle.communityplatform.security.model.UserPrincipal;
import se.stykle.communityplatform.security.repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);

        if (user == null){
            System.out.println("User Not Found");

            throw new UsernameNotFoundException("User not Found");
        }
        return new UserPrincipal(user);
    }
}
