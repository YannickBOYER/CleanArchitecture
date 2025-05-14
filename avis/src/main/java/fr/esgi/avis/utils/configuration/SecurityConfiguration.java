package fr.esgi.avis.utils.configuration;

import fr.esgi.avis.utils.handler.LoginFailureHandler;
import fr.esgi.avis.utils.handler.LoginSuccessHandler;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**", "/api/**")
                ).headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(login -> login
                        .successHandler(new LoginSuccessHandler())
                        .failureHandler(new LoginFailureHandler()))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll())
                .authorizeHttpRequests(request ->
                            request.requestMatchers("/h2-console/**").permitAll()

                                    .requestMatchers("/jeux").hasAnyRole("JOUEUR", "MODERATEUR")
                                    .requestMatchers("/jeux/{id}/avis").hasAnyRole("JOUEUR", "MODERATEUR")

                                    .requestMatchers("/jeux/create").hasAnyRole("MODERATEUR")
                                    .requestMatchers("/jeux/{id}/avis/create").hasAnyRole("JOUEUR")

                                    .requestMatchers("/api/**").permitAll()
                        );
        return http.build();
    }
}
