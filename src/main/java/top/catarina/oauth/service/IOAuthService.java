package top.catarina.oauth.service;


import org.scribe.model.*;
import top.catarina.oauth.api.IApi;
import top.catarina.oauth.config.IOauthConfig;

/**
 * The main Scribe object.
 *
 * A facade responsible for the retrieval of request and access tokens and for the signing of HTTP requests.
 *
 * @author Pablo Fernandez
 */
public interface IOAuthService
{
	/**
	 * Retrieve the request token.
	 *
	 * @return request token
	 */
	public Token getRequestToken();

	/**
	 * Retrieve the access token
	 *
	 * @param requestToken request token (obtained previously)
	 * @param verifier verifier code
	 * @return access token
	 */
	public Token getAccessToken(Token requestToken, Verifier verifier);

	/**
	 * Signs am OAuth request
	 *
	 * @param accessToken access token (obtained previously)
	 * @param request request to sign
	 */
	public void signRequest(Token accessToken, OAuthRequest request);

	/**
	 * Returns the OAuth version of the service.
	 *
	 * @return oauth version as string
	 */
	public String getVersion();

	/**
	 * Returns the URL where you should redirect your users to authenticate
	 * your application.
	 *
	 *  requestToken the request token you need to authorize
	 * @return the URL where you should redirect your users
	 */
	public String getAuthorizationUrl();

	/**
	 * 返回第三方服务器传回的json格式资源字符串
	 * @param code 用于交换accessToken的票据
	 * @return
	 */
	public Response getJsonResult(String code);

	/**
	 * 获取相关配置
	 * @return
	 */
	public IOauthConfig getConfig();

	/**
	 * 获取相关api
	 * @return
	 */
	public IApi getApi();
}
