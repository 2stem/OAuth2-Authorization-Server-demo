package jiho.oauth2authorizationserverdemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;

@Configuration
public class AuthorizationServerConfig {
    @Bean
    AuthorizationServerSettings authorizationServerSettings() {
        return AuthorizationServerSettings.builder()
                .issuer("http://localhost:9000")
                .authorizationEndpoint("/oauth2/v1/authorize")
                .deviceAuthorizationEndpoint("/oauth2/v1/device_authorization")
                .deviceVerificationEndpoint("/oauth2/v1/device_verification")
                .tokenEndpoint("/oauth2/v1/token")
                .tokenIntrospectionEndpoint("/oauth2/v1/introspect")
                .tokenRevocationEndpoint("/oauth2/v1/revoke")
                .jwkSetEndpoint("/oauth2/v1/jwks")
                .oidcLogoutEndpoint("/connect/v1/logout")
                .oidcUserInfoEndpoint("/connect/v1/userinfo")
                .oidcClientRegistrationEndpoint("/connect/v1/register")
                .build();
    }
}
