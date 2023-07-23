package br.com.diegosst.archetype.config;
import br.com.diegosst.archetype.mapper.BaseEntityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {
    @Bean
    public BaseEntityMapper baseEntityMapper() {
        return BaseEntityMapper.INSTANCE;
    }
}