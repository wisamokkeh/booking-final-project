package Core;

public class Constans {

	//hotel pathes
	public static final String URL = "https://www.booking.com/";
	public static String search = "ss";
	public static String checkinDateClick = "//*[contains(@class, 'xp__dates-inner xp__dates__checkin')]";
	public static String btnClickDate = "//*[contains(@class, 'js-sb-submit-text ')]";
	public static String btnClearCity = "//*[@id=\"frm\"]/div[1]/div[1]/div[1]/div[1]/button";
	public static String address = "//*[@data-testid=\"address\"]";
	public static String price = "//span[@data-testid=\"price-and-discounted-price\"]";
	public static String priceFilter = "//input[@name=\"pri=1\"]";
	public static String firstResult = "//*[@data-testid=\"title\"]/..";
	public static String hotelName = "//h2[contains(@class, 'd2fee87262 pp-header__title')]";
	public static String hotelRate = "//div[contains(@class, 'b5cd09854e f0d4d6a2f5 e46e88563a')]";
	public static String hotelLocation = "//*[@id=\"showMap2\"]/span[1]";
	
	
	//Attractions pathis
	public static final String URLAtt = "https://www.booking.com/attractions";
	public static String cityAtt = "query";
	public static String attDateClick = "//*[contains(@class, 'css-1naf36h')]";
	public static String attBtnClickDate = "//*[contains(@class, 'fc63351294 a822bdf511 d4b6b7a9e7 cfb238afa1 f4605622ad css-14gytlh')]";
	public static String attFirstResult = "//ul[1][contains(@class,'css-17fljn7')]/li[2]";
	public static String attFirstResultPage = "//*[@class=\"css-1qm1lh\"]//a[1]";
	public static String attprice = "//*[@class=\"ac78a73c96\"]";
	public static String attName = "//*[@class=\"css-1hp67ie\"]";
	public static String attRate = "//*[@class=\"a0c113411d css-1baulvz\"]";
	public static String attLocation = "//*[@class=\"f660aace8b\"][1]";
	public static String attPriceFilter = "//input[@id=\"__bui-21\"]";

	
	//services
	public static String servicePage = "//*[@id=\"b2indexPage\"]//*[@data-bui-component=\"Tooltip\"]";
	public static String contWithoutSignIn = "//*[@class=\"fc63351294 a822bdf511 e3c025e003 cfb238afa1 af18dbd5a4 e1b7cfea84 eea9808e9c\"]";

	public static String confirmation = "confirmationNumber";
	public static String pinNum = "pinCode";
	public static String nextBtn = "//*[@class=\"a1b3f50dcd b2fe1a41c3 bdf0df2d01 a198893f50\"]//button";

	
}
