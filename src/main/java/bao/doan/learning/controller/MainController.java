package bao.doan.learning.controller;

import bao.doan.learning.config.TemperatureConfig;
import bao.doan.learning.model.AcmeProperties;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Extension;
import io.swagger.annotations.ExtensionProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@Slf4j
public class MainController {

    @Autowired
    AcmeProperties acmeProperties;

    @Autowired
    TemperatureConfig temperatureConfig;

    @Autowired
    MessageSource messageSource;

    @GetMapping(path = "/main/security")
    @ApiOperation(
            value = "Get security enable or not",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/test"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })

    public boolean getSecurity(){
        return acmeProperties.isEnabled();
    }

    @GetMapping(path = "/main/security/detail")
    @ApiOperation(
            value = "Get security",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/test"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })

    public AcmeProperties.Security getSecurityDetail(){
        return acmeProperties.getSecurity();
    }

    @GetMapping(path = "/main/unit")
    @ApiOperation(
                       value = "Get temperature unit",
            code = 200,
            extensions = {
                    @Extension(name = "external", properties = {
                            @ExtensionProperty(name = "context", value = "/test"),
                            @ExtensionProperty(name = "isPublished", value = "true")
                    })
            })

    public String getAppUnit(){
        return temperatureConfig.getUnit();
    }

    @GetMapping("/main/greeting")
    public String getGreeting(Locale locale){
        return messageSource.getMessage("title.greeting", null, locale);
    }

}
