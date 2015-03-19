package id.co.pegadaian.simulator;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableAutoConfiguration
@ComponentScan
public class App extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).run(args);
    }

    @EnableWebSecurity
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class KonfigurasiSpringSecurity extends WebSecurityConfigurerAdapter {

        @Autowired
        private DataSource dataSource;

        private static final String SQL_LOGIN = "select username, password, true as enabled from s_user where username = ?";
        private static final String SQL_PERMISSION = "select u.username, p.name as authority "
                + "from s_user u  inner join s_user_permission up on u.id = up.id_user "
                + "inner join s_permission p on p.id = up.id_permission "
                + "where u.username = ?";

        @Override
        @Bean
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/inquiry/kesehatan/**").hasRole("BPJS_INQUIRY")
                    .antMatchers("/payment/kesehatan/**").hasRole("BPJS_PAYMENT")
                    .anyRequest().fullyAuthenticated()
                    .and().httpBasic();
        }

        
        
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery(SQL_LOGIN)
                    .authoritiesByUsernameQuery(SQL_PERMISSION);
        }

    }
}
