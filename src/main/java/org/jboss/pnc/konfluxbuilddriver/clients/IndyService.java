package org.jboss.pnc.konfluxbuilddriver.clients;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.pnc.api.indy.dto.IndyTokenRequestDTO;
import org.jboss.pnc.api.indy.dto.IndyTokenResponseDTO;

/**
 * Indy service representing the Indy server. It uses Quarkus magical rest client to generate the client implementation
 */
@RegisterRestClient(configKey = "indy-service")
public interface IndyService {

    /**
     * Ask Indy to give us the token that we will use for Maven communication with Indy, in the builder pod for the
     * particular
     * buildId
     *
     * @param indyTokenRequestDTO the DTO to send to Indy
     * @param accessToken accessToken required to send data. Note that it should include "Bearer <token>"
     * @return Token DTO
     */
    @Path("/api/security/auth/token")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    IndyTokenResponseDTO getAuthToken(
            IndyTokenRequestDTO indyTokenRequestDTO,
            @HeaderParam("Authorization") String accessToken);
}
