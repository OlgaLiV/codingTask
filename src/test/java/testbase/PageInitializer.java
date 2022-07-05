package testbase;

import pages.pages.AmazonPage;

public class PageInitializer extends BaseClass {
	protected static AmazonPage amazonPage;

	public static void initializePageObjects() {

		amazonPage = new AmazonPage();
	}

}
