package org.web.bankingapp.security;

import org.web.bankingapp.security.model.JwtAuthenticationResponse;
import org.web.bankingapp.security.model.SignInRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse authenticate(SignInRequest request);
}
