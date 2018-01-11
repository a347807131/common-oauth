package top.catarina.oauth.config;

public enum OAuthTypes {
	GITHUB("github"),
	QQ("qq"),
	WECHAT("wechat");

	private String text;

	private OAuthTypes(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
