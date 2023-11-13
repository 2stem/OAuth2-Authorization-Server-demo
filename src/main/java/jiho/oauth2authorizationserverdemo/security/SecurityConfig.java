package jiho.oauth2authorizationserverdemo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configurers.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator;
import org.springframework.security.oauth2.server.authorization.web.authentication.ClientSecretBasicAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final RegisteredClientRepository registeredClientRepository;
    private final OAuth2AuthorizationService authorizationService;
    private final OAuth2AuthorizationConsentService authorizationConsentService;
    private final AuthorizationServerSettings authorizationServerSettings;
//    private final OAuth2TokenGenerator tokenGenerator;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        var oAuth2AuthorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer();
        http.apply(oAuth2AuthorizationServerConfigurer);

        oAuth2AuthorizationServerConfigurer
                .registeredClientRepository(registeredClientRepository)
                .authorizationService(authorizationService) // 일단 default setting (InMemoryAuthorizationService)
//                .authorizationConsentService(authorizationConsentService)
//                .authorizationServerSettings(authorizationServerSettings)
//                .tokenGenerator(tokenGenerator)
                .clientAuthentication(clientAuthentication -> {
                    // Client Authentication accepts only HTTP BASIC
                    clientAuthentication.authenticationConverter(new ClientSecretBasicAuthenticationConverter());
                })
//                .authorizationEndpoint(Customizer.withDefaults())
//                .deviceAuthorizationEndpoint(Customizer.withDefaults())
//                .deviceVerificationEndpoint(Customizer.withDefaults())
//                .tokenEndpoint(Customizer.withDefaults())
//                .tokenIntrospectionEndpoint(Customizer.withDefaults())
//                .tokenRevocationEndpoint(Customizer.withDefaults())
//                .authorizationServerMetadataEndpoint(Customizer.withDefaults())
//                .oidc(oidc -> oidc
//                        .providerConfigurationEndpoint(providerConfigurationEndpoint -> {
//                        })
//                        .logoutEndpoint(logoutEndpoint -> {
//                        })
//                        .userInfoEndpoint(userInfoEndpoint -> {
//                        })
//                        .clientRegistrationEndpoint(clientRegistrationEndpoint -> {
//                        })
//                );
        ;

        return http.build();
    }
}
