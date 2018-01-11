package top.catarina.oauth.api;

public class GithubApi extends ApiAssembler {

	private static final String AUTHORIZE_URL = "https://github.com/login/oauth/authorize?client_id=%s&redirect_uri=%s&state=%s";
	private static final String ACCESS_TOKEN_URL = "https://github.com/login/oauth/access_token?state=%s";
	private static final String RESOURCE_URL = "https://api.github.com/user";

	@Override
	public String getAccessTokenUrlFormat() {
		return ACCESS_TOKEN_URL;
	}

	@Override
	public String getAuthUrlFormat() {
		return AUTHORIZE_URL;
	}

	@Override
	public String getResourceUrl() {
		return RESOURCE_URL;
	}
}
