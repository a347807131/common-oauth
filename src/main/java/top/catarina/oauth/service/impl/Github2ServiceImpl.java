package top.catarina.oauth.service.impl;

import top.catarina.oauth.api.GithubApi;

/**
 * github第三方认证实现
 */
public class Github2ServiceImpl extends BaseOAuth2ServiceImpl {
	/**
	 * Default constructor
	 */
	public Github2ServiceImpl() {
		super(new GithubApi());
	}
}
