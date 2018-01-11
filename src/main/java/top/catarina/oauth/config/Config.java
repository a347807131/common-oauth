package top.catarina.oauth.config;

import org.apache.log4j.Logger;
import top.catarina.utils.PropertiesLoader;

/**
 * 用于生成相应的OAuthConfig
 */
public class Config implements IOauthConfig{

	private static Logger logger = Logger.getLogger(Config.class);
	public static final String CALLBACK_URL_FORMAT = "%s/oauth/%s/callback";
	private static final PropertiesLoader loader = new PropertiesLoader("oauth.properties");

	private String state;
	private String host;
	private String clienId;
	private String clientSecret;
	private String oAuthType;
	private String scope;

	private Config(){}

	public Config(String oAuthType) {
		logger.info(this.getClass() + "开始载入"+oAuthType+"相关配置信息");
		this.oAuthType=oAuthType;
		state = loader.getProperty("oauth.state");
		host = loader.getProperty("oauth.host");
		clienId = loader.getProperty("oauth." + oAuthType + ".id");
		clientSecret = loader.getProperty("oauth." + oAuthType + ".secret");
		scope=loader.getProperty("oauth." + oAuthType+".scope",null);
		logger.info(this.getClass() + "配置文件载入完毕");
	}

	@Override
	public String getState() {
		return state;
	}

	@Override
	public String getClienId() {
		return clienId;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public String getHost() {
		return host;
	}

	@Override
	public String getScope() {
		return scope;
	}

	@Override
	public String getCallbackUrl() {
		return String.format(CALLBACK_URL_FORMAT, host,oAuthType);
	}
}
