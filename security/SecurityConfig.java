package projekt.projekt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder encoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/zgloszenie/wycen","/zgloszenie/wszystkie","/zgloszenie/nowe").hasAuthority("admin")
                .antMatchers("/zgloszenie/dodaj","/opinie/dodaj","/zgloszenie/moje","/zgloszenie/edytuj/*").hasAuthority("user")
                .antMatchers("/zgloszenie/zaakceptuj/**", "/zgloszenie/odrzuc/**", "/kontakt").hasAnyAuthority("user","admin")
                .antMatchers("/","/opinie/lista_opinii","/register", "/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login")
                .and()
                .logout()
                .logoutSuccessUrl("/wylogowano")
                .and().csrf().disable();

    }
    }

