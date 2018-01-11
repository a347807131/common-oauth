package top.catarina.oauth.model;


import top.catarina.oauth.config.OAuthTypes;

import java.io.Serializable;

/**
 * 对第三方认证后返回的信息封装后的实体类
 */
public class OAuthUser implements Serializable {

	private Serializable id;
	private OAuthTypes oAuthType;
	private String oAuthId;

	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	public OAuthTypes getoAuthType() {
		return oAuthType;
	}

	public void setoAuthType(OAuthTypes oAuthType) {
		this.oAuthType = oAuthType;
	}

	public String getoAuthId() {
		return oAuthId;
	}

	public void setoAuthId(String oAuthId) {
		this.oAuthId = oAuthId;
	}
}
