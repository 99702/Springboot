# Security

##  Authentication
Verify the Identity of who is  trying to access particular resource.
    Common way to authenticate users is by requiring the user to enter a username and password.
    Once authentication is performed we know the identity and can perform authorization.

#### Authentication-mechanism:
<div class="sectionbody">
<div class="ulist">
<ul>
<li>
<p><a href="passwords/index.html#servlet-authentication-unpwd" class="xref page">Username and Password</a> - how to authenticate with a username/password</p>
</li>
<li>
<p><a href="../oauth2/login/index.html#oauth2login" class="xref page">OAuth 2.0 Login</a> - OAuth 2.0 Log In with OpenID Connect and non-standard OAuth 2.0 Login (i.e. GitHub)</p>
</li>
<li>
<p><a href="../saml2/index.html#servlet-saml2" class="xref page">SAML 2.0 Login</a> - SAML 2.0 Log In</p>
</li>
<li>
<p><a href="cas.html#servlet-cas" class="xref page">Central Authentication Server (CAS)</a> - Central Authentication Server (CAS) Support</p>
</li>
<li>
<p><a href="rememberme.html#servlet-rememberme" class="xref page">Remember Me</a> - how to remember a user past session expiration</p>
</li>
<li>
<p><a href="jaas.html#servlet-jaas" class="xref page">JAAS Authentication</a> - authenticate with JAAS</p>
</li>
<li>
<p><a href="openid.html#servlet-openid" class="xref page">OpenID</a> - OpenID Authentication (not to be confused with OpenID Connect)</p>
</li>
<li>
<p><a href="preauth.html#servlet-preauth" class="xref page">Pre-Authentication Scenarios</a> - authenticate with an external mechanism such as <a href="https://www.siteminder.com/">SiteMinder</a> or Java EE security but still use Spring Security for authorization and protection against common exploits.</p>
</li>
<li>
<p><a href="x509.html#servlet-x509" class="xref page">X509 Authentication</a> - X509 Authentication</p>
</li>
</ul>
</div>
</div>
</div>

#### Authorization
Only Authenticated users are authorized to access the API Write endpoints.

##### Authorization-header
A request type header that used to contains the credentials information to authenticate a user through a server 
APIs use authorization to ensure that client requests access data securely. 
authenticating the sender of a request , verifying that they have permission to access or manipulate the relevant data. 
If you're building an API, you can choose from a variety of auth models. If you're integrating a third-party API, the required authorization will be specified by the API provider.

List Of Authorization Headers:
1. Basic Auth
2. Bearer Token
3. API key
4. Digest Auth
5. OAuth 2.0
6. Hawk Authentication
7. AWS Signature
<hr/>


1. Basic Auth

The client sends HTTP requests with the Authorization header that contains the word Basic, followed by a space and a base64-encoded(non-encrypted) string username: password.

<img src="https://reqbin.com/static/img/article/authentication.png"/>

For example,
Authorization: Basic AXVubzpwQDU1dzByYM==




2. Bearer Token (Token authentication)
Involves security tokens called bearer tokens. Gives access to anyone who has the token.
Access API also provide authentication + authorization (who is accessing that resource).
`Authorization: Bearer xxx99x90x902n3bxwwa`

<img src="https://docs.oracle.com/cd/E82085_01/160030/JOS%20Implementation%20Guide/Output/img/oauth2-caseflow.png"/>

<div class="sect1">
<h2 id="oauth2resourceserver-jwt-architecture"><a class="anchor" href="#oauth2resourceserver-jwt-architecture"></a>How JWT Authentication Works</h2>
<div class="sectionbody">
<div class="paragraph">
<p>Next, let???s see the architectural components that Spring Security uses to support <a href="https://tools.ietf.org/html/rfc7519">JWT</a> Authentication in servlet-based applications, like the one we just saw.</p>
</div>
<div class="paragraph">
<p><a href="https://docs.spring.io/spring-security/site/docs/5.7.2/api/org/springframework/security/oauth2/server/resource/authentication/JwtAuthenticationProvider.html"><code>JwtAuthenticationProvider</code></a> is an <a href="../../authentication/architecture.html#servlet-authentication-authenticationprovider" class="xref page"><code>AuthenticationProvider</code></a> implementation that leverages a <a href="#oauth2resourceserver-jwt-decoder"><code>JwtDecoder</code></a> and <a href="#oauth2resourceserver-jwt-authorization-extraction"><code>JwtAuthenticationConverter</code></a> to authenticate a JWT.</p>
</div>
<div class="paragraph">
<p>Let???s take a look at how <code>JwtAuthenticationProvider</code> works within Spring Security.
The figure explains details of how the <a href="../../authentication/architecture.html#servlet-authentication-authenticationmanager" class="xref page"><code>AuthenticationManager</code></a> in figures from <a href="#oauth2resourceserver-authentication-bearertokenauthenticationfilter">Reading the Bearer Token</a> works.</p>
</div>
<div class="imageblock">
<div class="content">
<img src="https://docs.spring.io/spring-security/reference/_images/servlet/oauth2/jwtauthenticationprovider.png" alt="jwtauthenticationprovider">
</div>
<div class="title">Figure 1. <code>JwtAuthenticationProvider</code> Usage</div>
</div>
<div class="paragraph">
<p><span class="image"><img src="https://docs.spring.io/spring-security/reference/_images/icons/number_1.png" alt="number 1"></span> The authentication <code>Filter</code> from <a href="#oauth2resourceserver-authentication-bearertokenauthenticationfilter">Reading the Bearer Token</a> passes a <code>BearerTokenAuthenticationToken</code> to the <code>AuthenticationManager</code> which is implemented by <a href="../../authentication/architecture.html#servlet-authentication-providermanager" class="xref page"><code>ProviderManager</code></a>.</p>
</div>
<div class="paragraph">
<p><span class="image"><img src="https://docs.spring.io/spring-security/reference/_images/icons/number_2.png" alt="number 2"></span> The <code>ProviderManager</code> is configured to use an <a href="../../authentication/architecture.html#servlet-authentication-authenticationprovider" class="xref page">AuthenticationProvider</a> of type <code>JwtAuthenticationProvider</code>.</p>
</div>
<div id="oauth2resourceserver-jwt-architecture-jwtdecoder" class="paragraph">
<p><span class="image"><img src="https://docs.spring.io/spring-security/reference/_images/icons/number_3.png" alt="number 3"></span> <code>JwtAuthenticationProvider</code> decodes, verifies, and validates the <code>Jwt</code> using a <a href="#oauth2resourceserver-jwt-decoder"><code>JwtDecoder</code></a>.</p>
</div>
<div id="oauth2resourceserver-jwt-architecture-jwtauthenticationconverter" class="paragraph">
<p><span class="image"><img src="https://docs.spring.io/spring-security/reference/_images/icons/number_4.png" alt="number 4"></span> <code>JwtAuthenticationProvider</code> then uses the <a href="#oauth2resourceserver-jwt-authorization-extraction"><code>JwtAuthenticationConverter</code></a> to convert the <code>Jwt</code> into a <code>Collection</code> of granted authorities.</p>
</div>
<div class="paragraph">
<p><span class="image"><img src="https://docs.spring.io/spring-security/reference/_images/icons/number_5.png" alt="number 5"></span> When authentication is successful, the <a href="../../authentication/architecture.html#servlet-authentication-authentication" class="xref page"><code>Authentication</code></a> that is returned is of type <code>JwtAuthenticationToken</code> and has a principal that is the <code>Jwt</code> returned by the configured <code>JwtDecoder</code>.
Ultimately, the returned <code>JwtAuthenticationToken</code> will be set on the <a href="../../authentication/architecture.html#servlet-authentication-securitycontextholder" class="xref page"><code>SecurityContextHolder</code></a> by the authentication <code>Filter</code>.</p>
</div>
</div>
</div>

https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html

3. API Key
API key is a token that a client provides when making API calls.
The key in the query string:

`GET /endpoint?api_key=abcdefgh123456789`
or as a request header:

`X-API-Key: abcdefgh123456789`

















































References
https://www.loginradius.com/blog/engineering/everything-you-want-to-know-about-authorization-headers/

https://docs.spring.io/spring-security/reference/servlet/authentication/index.html#servlet-authentication-mechanisms

https://www.toptal.com/spring/spring-security-tutorial
