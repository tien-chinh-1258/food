
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserInfoService userDetailsService(PasswordEncoder encoder) {
        UserInfoUserDetails admin = User.withUsername("chinh")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();

        UserInfoUserDetails user = User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();

        return new UserInfoService(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
