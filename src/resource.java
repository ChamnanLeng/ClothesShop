import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class resource {
	////////////////////////////////////////////////////////////////////////////////////////////color
	public static String highLightColor="#2fdab8";
	public static String buttonCliked="#ffb300";
	public static String buttonHover="#25a58c";
	public static String textColor="#786e81";
	public static String textColorSecondary="#dbdbdb";
	public static String backColor="#786e81";
	public static String lightBack="#e9e4ef";
	////////////////////////////////////////////////////////////////////////////////////////////label
	//normal label
	public static JLabel lblAppInfo, lblTitle, lblSubTitle, lblImgSlide,  lblCode,lblPrice;
	//menu
	public static JLabel lblMenuShirt, lblMenuTShirt, lblMenuShoes, lblMenuTrousers;
	
	//button shop and buy
	public static JLabel lblShop1=new Shop.myLabel(185, 210, 106, 30, "BUY NOW", "#ffffff", resource.highLightColor,
	true, true, true, "MoolBoran (Headings CS)", 14);
	public static JLabel lblShop2=new Shop.myLabel(185, 210, 106, 30, "BUY NOW", "#ffffff", resource.highLightColor,
	true, true, true, "MoolBoran (Headings CS)", 14);
	public static JLabel lblShop3=new Shop.myLabel(185, 210, 106, 30, "BUY NOW", "#ffffff", resource.highLightColor,
	true, true, true, "MoolBoran (Headings CS)", 14);
	//card
	public static JLabel lblImg1=new Shop.myLabel(0, 0, 170, 240, "", "#ffffff", "#ffffff", false, false, false, "", 0);
	public static JLabel lblImg2=new Shop.myLabel(0, 0, 170, 240, "", "#ffffff", "#ffffff", false, false, false, "", 0);
	public static JLabel lblImg3=new Shop.myLabel(0, 0, 170, 240, "", "#ffffff", "#ffffff", false, false, false, "", 0);
	
	public static JLabel lblPrintCode1=new Shop.myLabel(240, 20, 60, 20, "", resource.textColor, "#ffffff", true, false, false, "MoolBoran (Headings CS)", 14);
	public static JLabel lblPrintCode2=new Shop.myLabel(240, 20, 60, 20, "", resource.textColor, "#ffffff", true, false, false, "MoolBoran (Headings CS)", 14);
	public static JLabel lblPrintCode3=new Shop.myLabel(240, 20, 60, 20, "", resource.textColor, "#ffffff", true, false, false, "MoolBoran (Headings CS)", 14);
	
	public static JLabel lblPrintPrice1=new Shop.myLabel(240, 50, 60, 20, "$", resource.highLightColor,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	public static JLabel lblPrintPrice2=new Shop.myLabel(240, 50, 60, 20, "$", resource.highLightColor,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	public static JLabel lblPrintPrice3=new Shop.myLabel(240, 50, 60, 20, "$", resource.highLightColor,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	
	public static JLabel lblPrintChange1=new Shop.myLabel(240,138,60,20,"$0.00", resource.buttonCliked,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	public static JLabel lblPrintChange2=new Shop.myLabel(240,138,60,20,"$0.00", resource.buttonCliked,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	public static JLabel lblPrintChange3=new Shop.myLabel(240,138,60,20,"$0.00", resource.buttonCliked,"#ffffff", 
	true, false, false, "MoolBoran (Headings CS)", 18);
	
	public static JLabel lblAmount, lblChange, lblSize;
	
	
	///////////////////////////////////////////////////////////////////////////////////////////panel
	public static JPanel panelImg;	
	public static JPanel panelPay=new Shop.myPanel(100,225,745,250,"#000000");
	public static JPanel panelWorkSpaceHeader=new Shop.myPanel(35,15,875,330,"#ffffff");
	public static JPanel panelWorkSpace=new Shop.myPanel(0, 350, 945, 322, lightBack);
	public static JPanel panelBack=new Shop.myPanel(0,0,945,225,resource.backColor);
	public static JPanel panelHeader=new Shop.myPanel(0, 0, 905, 110, "#ffffff");
	public static JPanel panelSlide=new Shop.myPanel(0, 110, 905, 220, resource.textColorSecondary);
	public static JPanel panelTitleBorder=new Shop.myPanel(87,70,700,1,resource.textColorSecondary);
	public static JPanel panelMenu=new Shop.myPanel(182,75,510,30,"#ffffff");
	public static JPanel panelTitle=new Shop.myPanel(367,7,200,40,resource.highLightColor);
	public static JPanel panelAbout=new Shop.myPanel(0,292,945,30,resource.backColor);
	public static JPanel panelAboutBorder=new Shop.myPanel(322,5,300,1,resource.textColorSecondary);
	public static JPanel panelCard;
	
	//edited ta vea
	// ta vea ta K'nan
}
