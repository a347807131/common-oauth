package top.catarina.oauth.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.model.Verb;
import top.catarina.oauth.config.IOauthConfig;
import top.catarina.oauth.service.IOAuthService;

/**
 * @author Civin
 * 对Api进行修改 添加根据adaptor直接返回OAuthService的方法
 */
public interface IApi{

	/**
	 * 获取带有用于获取资源的资源服务器地址
	 * @return
	 */
	String getAccessTokenEndpoint();

	/**
	 * Returns the access token extractor.
	 *
	 * @return access token extractor
	 */
	AccessTokenExtractor getAccessTokenExtractor();
	/**
	 * Returns the verb for the access token endpoint (defaults to GET)
	 *
	 * @return access token endpoint verb
	 */
	Verb getAccessTokenVerb();

	/**
	 * 返回服务器回调地址
	 * @return
	 */
	String getCallbackUrl();

	String getAuthUrl();

	/**
	 * 获取用于获取资源的资源服务器地址
	 * @return
	 */
	String getResourceUrl();

	/**
	 * 创建OauthService
	 * @return
	 */
	IOAuthService createService();

	/**
	 * 合并api及其config
	 * 用于获得相关config
	 * @return
	 */
	public IOauthConfig getConfig();
}
