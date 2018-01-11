package top.catarina.oauth.config;

public interface IOauthConfig {

	 String getState();

	 String getClienId();

	 String getClientSecret();

	 String getHost();

	 String getScope();

	/**
	 * 返回
	 * @return
	 */
	String getCallbackUrl();
}
