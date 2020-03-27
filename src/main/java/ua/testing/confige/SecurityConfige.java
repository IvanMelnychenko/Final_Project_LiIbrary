package ua.testing.confige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ua.testing.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfige extends WebSecurityConfigurerAdapter {

  private AuthenticationSuccessHandler authenticationSuccessHandler;
  private UserDetailsServiceImpl userDetailsServiceImpl;

  public SecurityConfige(AuthenticationSuccessHandler authenticationSuccessHandler,
      UserDetailsServiceImpl userDetailsServiceImpl) {
    this.authenticationSuccessHandler = authenticationSuccessHandler;
    this.userDetailsServiceImpl = userDetailsServiceImpl;
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return PasswordCoder.ENCODER.getEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.
        authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasRole("USER")
        .antMatchers("/", "register").hasRole("ANONYMOUS")
        .antMatchers("**").permitAll()
        .and()
        .formLogin().loginPage("/").successHandler(authenticationSuccessHandler)
        .and()
        .headers().frameOptions().disable()
        .and()
        .csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .userDetailsService(userDetailsServiceImpl)
        .passwordEncoder(getPasswordEncoder());
  }
}
