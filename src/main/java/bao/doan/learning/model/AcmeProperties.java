package bao.doan.learning.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.List;

@ConstructorBinding
@ConfigurationProperties("acme")
@AllArgsConstructor
public class AcmeProperties {
    @Getter
    private final boolean enabled;
    @Getter
    private final InetAddress remoteAddress;
    @Getter
    private final Security security;


    public static class Security {
        @Getter
        private final String username;
        @Getter
        private final String password;
        @Getter
        private final List<String> roles;

        public Security(String username, String password,
                        @DefaultValue("USER") List<String> roles) {
            this.username = username;
            this.password = password;
            this.roles = roles;
        }

    }
}
