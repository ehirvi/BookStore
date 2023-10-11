package hh.sof03.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import hh.sof03.bookstore.webcontrol.UserDetailServiceImpl;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

// import java.util.ArrayList;
// import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers(antMatcher("/css/**")).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formlogin -> formlogin
                .defaultSuccessUrl("/booklist", true)
                .permitAll()
            )
            .logout(logout -> logout
                .permitAll()
            );

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }


    // @Bean
    // public UserDetailsService userDetailsService() {
    //     List<UserDetails> users = new ArrayList<UserDetails>();

    //     PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    //     UserDetails user_1 = User
    //         .withUsername("user")
    //         .password(passwordEncoder.encode("user"))
    //         .roles("USER")
    //         .build();

    //     UserDetails user_2 = User
    //         .withUsername("admin")
    //         .password(passwordEncoder.encode("admin"))
    //         .roles("USER", "ADMIN")
    //         .build();

    //     users.add(user_1);
    //     users.add(user_2);

    //     return new InMemoryUserDetailsManager(users);
    // }
}
