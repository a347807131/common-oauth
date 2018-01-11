package top.catarina;

import org.junit.Test;

public class TestApi {
	@Test
	public void test(){
		String className = this.getClass().getSimpleName();
		String apiType = className.toLowerCase();
		if(apiType.endsWith("api")){
			System.out.println(apiType.substring(0,apiType.indexOf("api")));
		}
	}
}
