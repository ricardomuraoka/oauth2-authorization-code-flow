package pr.pucbr.oauth2.oauth2authorizationcodeflow.oauth;


import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class Oauth {
    private final OAuth2AuthorizedClientService authorizedClientService;

    public Oauth(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }
    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("‘Login’ realizado com sucesso!");
    }



    @GetMapping("/callback")
    public ResponseEntity<String> callback(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());

        String code = authorizedClient.getRefreshToken().getTokenValue();

        return ResponseEntity.ok(code);
    }

    @GetMapping("/token")
    public ResponseEntity<String> token(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());

        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();

        return ResponseEntity.ok(accessToken.getTokenValue());
    }
}
