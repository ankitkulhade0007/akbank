SpringBootWebSecurityConfiguration{
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)
}



UsernamePasswordAuthenticationFilter -> this filter is used when you do form login authentication
BasicAuthenticationFilter -> This filter is used when you do basic authentication. in this way the authentication username and pwd set into 
request header .WHere Header key will be Authorization. and userName and pwd will be encoded by a Base64 encoder.
Or whatever encoder was use will be the prefix as the value of the Authorication key. that implementation you can see
Authentication authRequest = this.authenticationConverter.convert(request);


User login details get saved into two place 
1. Inmemory - new InMemoryUserDetailsManager(user, admin);. for that you need to create teh bean of pwd encoder
2. database




