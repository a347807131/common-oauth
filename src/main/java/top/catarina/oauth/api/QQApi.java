package top.catarina.oauth.api;

import top.catarina.oauth.config.IOauthConfig;

public class QQApi extends ApiAssembler{

	private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s";
	private static final String ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&state=%s";
	private static final String PROTECTED_RESOURCE_URL = "https://graph.qq.com/user/get_user_info";

	@Override
	public String getAccessTokenUrlFormat() {
		return null;
	}

	@Override
	public String getAuthUrlFormat() {
		return null;
	}

	@Override
	public String getResourceUrl() {
		return null;
	}
}
