package org.http4k.security.oauth.server

import org.http4k.core.Request
import org.http4k.core.Response
import org.junit.jupiter.api.Assertions.fail

class InMemoryOAuthRequestPersistence : OAuthRequestPersistence {
    private var internalRequest: AuthorizationRequest? = null

    override fun store(authorizationRequest: AuthorizationRequest, response: Response) =
        response.also {
            this.internalRequest = authorizationRequest
        }

    override fun retrieve(request: Request): AuthorizationRequest {
        TODO("not implemented")
    }

    override fun clear(authorizationRequest: AuthorizationRequest, response: Response): Response {
        TODO("not implemented")
    }

    val authorizationRequest: AuthorizationRequest get() = internalRequest ?: fail("No authorizationRequest persisted")
}