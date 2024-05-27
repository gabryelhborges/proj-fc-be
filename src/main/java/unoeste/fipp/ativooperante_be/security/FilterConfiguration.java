package unoeste.fipp.ativooperante_be.security;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Essa anotacao define queessa classe é um filtro
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<AccessFilter> registrationBean(){
        // registrando o filtro
        FilterRegistrationBean<AccessFilter> register = new FilterRegistrationBean<>();
        register.setFilter(new AccessFilter());
        // definindo as URLs para aplicar o filtro
        register.addUrlPatterns("/apis/adm/*");
        register.addUrlPatterns("/apis/cidadao/*");
        return register;
    }
}

/*
caminho: http://localhost:8080/apis/logar

{
    "email":"gab@gmail.com", "senha":123, "nivel":1
}
 */