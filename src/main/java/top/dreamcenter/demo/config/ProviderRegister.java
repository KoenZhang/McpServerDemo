package top.dreamcenter.demo.config;

import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.dreamcenter.demo.service.WeatherService;

@Configuration
public class ProviderRegister {

    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        return MethodToolCallbackProvider
                .builder()
                .toolObjects(weatherService)
                .build();
    }


}
