    package com.example.qu.config;

    import com.example.qu.constant.PathConstant;
    import org.springframework.context.annotation.Bean;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;


    @EnableWebSecurity
    public class WebSecurityConfig {
        private static final String[] WHITE_LIST_URLS = {
                PathConstant.REGISTER_USER,
                PathConstant.ALL_USER,
                PathConstant.SINGLE_USER,
                PathConstant.LOGIN_USER,
                PathConstant.SEARCH_USER,

        };


        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .cors()
                    .and()
                    .csrf()
                    .disable()
                    .authorizeHttpRequests()
                    .antMatchers(WHITE_LIST_URLS).permitAll()
                    .antMatchers("/api/**").authenticated();
            return http.build();
        }
    }
