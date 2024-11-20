package vn.herta.repository;

	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;

	import vn.herta.springboot3.entity.UserInfo;

	public class UserInfoRepository implements UserDetailsService {

	    @Autowired
	    UserInfoRepository repository;

	    public UserInfoRepository(UserInfoRepository userInfoRepository) {
	        this.repository = userInfoRepository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Optional<UserInfo> userInfo = repository.findByName(username);
	        return userInfo.map(UserInfoUserDetails::new)
	                .orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	    }
	}



