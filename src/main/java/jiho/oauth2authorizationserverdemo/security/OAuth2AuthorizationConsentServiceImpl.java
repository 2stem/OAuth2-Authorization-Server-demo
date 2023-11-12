package jiho.oauth2authorizationserverdemo.security;

import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.stereotype.Service;

@Service
public class OAuth2AuthorizationConsentServiceImpl implements OAuth2AuthorizationConsentService {
    @Override
    public void save(OAuth2AuthorizationConsent authorizationConsent) {

    }

    @Override
    public void remove(OAuth2AuthorizationConsent authorizationConsent) {

    }

    @Override
    public OAuth2AuthorizationConsent findById(String registeredClientId, String principalName) {
        return null;
    }
}
