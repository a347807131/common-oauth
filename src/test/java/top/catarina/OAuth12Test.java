package top.catarina;

import org.junit.Test;
import top.catarina.oauth.api.GithubApi;
import top.catarina.oauth.config.Config;
import top.catarina.oauth.config.OAuthTypes;
import top.catarina.oauth.service.IOAuthService;
import top.catarina.oauth.service.impl.Github2ServiceImpl;

public class OAuth12Test {
	@Test
	public void configTest(){
		Config config = new Config(OAuthTypes.GITHUB.getText());
		String url = config.getCallbackUrl();
		System.out.println(url);
	}
	@Test
	public void testApi(){
		GithubApi api = new GithubApi();
		String callbackUrl = api.getCallbackUrl();
		System.out.println(api.getResourceUrl());
	}
	@Test
	public void apiTest2(){
		IOAuthService service = new GithubApi().createService();
		String url = service.getAuthorizationUrl();
		System.out.println(url);
		//https://github.com/login/oauth/authorize?client_id=a703c4738c4619d071fe&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Foauth%2Fgithub%2Fcallback&state=1h8k68be244kxdeb2k91sdfasdfads230f40817feeekjm
	}
	@Test
	public void test3(){
		Github2ServiceImpl service = new Github2ServiceImpl();
		String url = service.getApi().getAuthUrl();
		System.out.println(url);
	}
}
