package bao.doan.learning.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class TemperatureConfig {

    @Value("${app.unit}")
    private String unit;
}
