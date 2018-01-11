package top.catarina.oauth.api;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.TokenExtractor20Impl;
import org.scribe.model.Verb;
import org.scribe.utils.OAuthEncoder;
import top.catarina.oauth.config.Config;
import top.catarina.oauth.config.IOauthConfig;
import top.catarina.oauth.config.OAuthTypes;
import top.catarina.oauth.service.IOAuthService;
import top.catarina.oauth.service.impl.BaseOAuth2ServiceImpl;

/**
 * 第三方api装配器器
 * @author Civin
 * @apiNote 被配置的api必须以***Api的形式命名，且实现iapi接口。
 */
public abstract class ApiAssembler implements IApi {

	private IOauthConfig config = setConfig();

	/**
	 * 设置相关配置
	 * @return
	 */
	private IOauthConfig setConfig() {
		String className = this.getClass().getSimpleName();
		String apiType = className.toLowerCase();
		if(apiType.endsWith("api")){
			String api = apiType.substring(0, apiType.indexOf("api")).toUpperCase();
			return new Config(OAuthTypes.valueOf(api).getText());
		}
		throw new RuntimeException("设置Config出错，请检查OauthTypes配置。");
	}
	@Override
	public IOauthConfig getConfig(){
		return config;
	}

	/**
	 * 获取用于用去token凭证的认证服务器地址
	 *
	 * @return
	 */
	public abstract String getAccessTokenUrlFormat();

	/**
	 * 获取资源认证服务器认证地址
	 * @return
	 */
	public abstract String getAuthUrlFormat();

	public abstract String getResourceUrl();

	/**
	 * 获取带有scope域参数的认证服务器认证地址
	 *
	 * @return
	 */
	public String getScopedAuthUrlFormat() {
		return getAuthUrlFormat() + "&scope=%s";
	}

	@Override
	public String getAuthUrl() {
		if (config.getScope() != null) {
			return String.format(getAuthUrlFormat(), config.getClienId(), OAuthEncoder.encode(config.getCallbackUrl()),
					config.getState(), OAuthEncoder.encode(config.getScope()));
		} else {
			return String.format(getAuthUrlFormat(), config.getClienId(), OAuthEncoder.encode(config.getCallbackUrl()), config.getState());
		}
	}

	@Override
	public String getAccessTokenEndpoint() {
		return String.format(getAccessTokenUrlFormat(), config.getState());
	}

	@Override
	public IOAuthService createService() {
		try {
			return new BaseOAuth2ServiceImpl(this);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public AccessTokenExtractor getAccessTokenExtractor() {
		return new TokenExtractor20Impl();
	}

	@Override
	public Verb getAccessTokenVerb() {
		return Verb.GET;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return
	 */
	@Override
	public String getCallbackUrl() {
		return config.getCallbackUrl();
	}
}
