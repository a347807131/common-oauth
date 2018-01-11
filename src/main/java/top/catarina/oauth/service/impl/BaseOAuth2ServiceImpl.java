package top.catarina.oauth.service.impl;

import org.scribe.model.*;
import top.catarina.oauth.config.IOauthConfig;
import top.catarina.oauth.api.IApi;
import top.catarina.oauth.service.IOAuthService;

public class BaseOAuth2ServiceImpl implements IOAuthService {
	private static final String VERSION = "2.0";

	private final IApi api;
	private final IOauthConfig config;

	/**
	 * Default constructor
	 *
	 * @param api    OAuth2.0 api information
	 */
	public BaseOAuth2ServiceImpl(IApi api) {
		this.api = api;
		this.config = api.getConfig();
	}

	@Override
	public Token getRequestToken() {
		throw new UnsupportedOperationException("Unsupported operation, please use 'getAuthorizationUrl' and redirect your users there");
	}

	@Override
	public Token getAccessToken(Token requestToken, Verifier verifier) {
		OAuthRequest request = new OAuthRequest(api.getAccessTokenVerb(), api.getAccessTokenEndpoint());
		request.addQuerystringParameter(OAuthConstants.CLIENT_ID, config.getClienId());
		request.addQuerystringParameter(OAuthConstants.CLIENT_SECRET, config.getClientSecret());
		request.addQuerystringParameter(OAuthConstants.CODE, verifier.getValue());
		request.addQuerystringParameter(OAuthConstants.REDIRECT_URI, api.getCallbackUrl());
		if (config.getScope() != null) request.addQuerystringParameter(OAuthConstants.SCOPE, config.getScope());
		Response response = request.send();
		return api.getAccessTokenExtractor().extract(response.getBody());

	}

	@Override
	public void signRequest(Token accessToken, OAuthRequest request) {
		request.addQuerystringParameter(OAuthConstants.ACCESS_TOKEN, accessToken.getToken());
	}

	@Override
	public String getVersion() {
		return VERSION;
	}

	@Override
	public String getAuthorizationUrl() {
		return api.getAuthUrl();
	}

	/**
	 * 在第三方认证服务器回调后拿到code用于获取资源信息
	 * @param code 用于交换accessToken的票据
	 * @return
	 */
	@Override
	public Response getJsonResult(String code) {
		Token accessToken = getAccessToken(null, new Verifier(code));
		OAuthRequest oAuthRequest = new OAuthRequest(Verb.GET, api.getResourceUrl());
		signRequest(accessToken, oAuthRequest);
		Response oAuthResponse = oAuthRequest.send();
		return oAuthResponse;
	}

	@Override
	public IOauthConfig getConfig() {
		return config;
	}

	@Override
	public IApi getApi() {
		return api;
	}
}
