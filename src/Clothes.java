import java.awt.image.BufferedImage;

public class Clothes {
	private String code;
	private Double price;
	private BufferedImage img;
	public Clothes(){
		this.code="unknow";
		this.price=0.00;
		this.img=null;
	}
	public Clothes(String code, Double price, BufferedImage img){
		this.code=code;
		this.price=price;
		this.img=img;
	}
	public String GetCode(){
		return code;
	}
	public Double GetPrice(){
		return price;
	}
	public BufferedImage GetImg(){
		return img;
	}
}
