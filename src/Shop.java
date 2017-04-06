import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.*;

public class Shop extends JFrame implements MouseListener{
	Timer timer;
	Double amount,price,change;
	int id=0;
	JTextField txtAmount1=new myTextField();
	JTextField txtAmount2=new myTextField();
	JTextField txtAmount3=new myTextField();
	JComboBox<String> cbSize1=new myCombobox();
	JComboBox<String> cbSize2=new myCombobox();
	JComboBox<String> cbSize3=new myCombobox();
	
	BufferedImage img1,img2,img3;
	BufferedImage[] imageSlideList={
			img1=ImageIO.read(getClass().getResource("slide_1.jpg")),
			img2=ImageIO.read(getClass().getResource("slide_2.jpg")),
			img3=ImageIO.read(getClass().getResource("slide_3.jpg"))
	};
	
	BufferedImage imgShirt1,imgShirt2,imgShirt3;
	BufferedImage[] imageShirtList={
			imgShirt1=ImageIO.read(getClass().getResource("shirt_1.jpg")),
			imgShirt2=ImageIO.read(getClass().getResource("shirt_2.jpg")),
			imgShirt3=ImageIO.read(getClass().getResource("shirt_3.jpg"))
	};
	
	BufferedImage imgTShirt1,imgTShirt2,imgTShirt3;
	BufferedImage[] imageTShirtList={
			imgTShirt1=ImageIO.read(getClass().getResource("tshirt_1.jpg")),
			imgTShirt2=ImageIO.read(getClass().getResource("tshirt_2.jpg")),
			imgTShirt3=ImageIO.read(getClass().getResource("tshirt_3.jpg"))
	};
	
	BufferedImage imgTrousers1,imgTrousers2,imgTrousers3;
	BufferedImage[] imageTrousersList={
			imgTrousers1=ImageIO.read(getClass().getResource("trousers_1.jpg")),
			imgTrousers2=ImageIO.read(getClass().getResource("trousers_2.jpg")),
			imgTrousers3=ImageIO.read(getClass().getResource("trousers_3.jpg"))
	};
	
	BufferedImage imgTop1,imgTop2,imgTop3;
	BufferedImage[] imageTopList={
			imgShirt1=ImageIO.read(getClass().getResource("top_1.jpg")),
			imgShirt2=ImageIO.read(getClass().getResource("top_2.jpg")),
			imgShirt3=ImageIO.read(getClass().getResource("top_3.jpg"))
	};
	
	static int clicked=1, slideCount=0;
	//Shirt 
	Clothes[] obj1=new Clothes[]{
			new Clothes("SH001",25.00,imageShirtList[0]),
			new Clothes("SH002",16.00,imageShirtList[1]),
			new Clothes("SH003",21.50,imageShirtList[2])
	};
	//T-Shirt
		Clothes[] obj2=new Clothes[]{
				new Clothes("TS001",9.50,imageTShirtList[0]),
				new Clothes("TS002",11.00,imageTShirtList[1]),
				new Clothes("TS003",7.50,imageTShirtList[2])
		};
	//trouser
	Clothes[] obj3=new Clothes[]{
			new Clothes("TR001",9.50,imageTrousersList[0]),
			new Clothes("TR002",10.00,imageTrousersList[1]),
			new Clothes("TR003",8.50,imageTrousersList[2])
	};
	//top
	Clothes[] obj4=new Clothes[]{
			new Clothes("TP001",20.00,imageTopList[0]),
			new Clothes("TP002",11.40,imageTopList[1]),
			new Clothes("TP003",10.50,imageTopList[2])
	};
	
	public Shop() throws IOException{
		
		setSize(950,700);
		setTitle("Mr's Clothes");
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode(resource.lightBack));
		SlideShow();
		//shirtCard
		myCard(10, 20, 301, 250, txtAmount1,resource.lblShop1,resource.lblImg1,
				resource.lblPrintCode1,resource.lblPrintPrice1,resource.lblPrintChange1,cbSize1);
		myCard(321,20,301,250, txtAmount2,resource.lblShop2,resource.lblImg2,
				resource.lblPrintCode2,resource.lblPrintPrice2,resource.lblPrintChange2,cbSize2);
		myCard(632,20,301,250, txtAmount3,resource.lblShop3,resource.lblImg3,
				resource.lblPrintCode3,resource.lblPrintPrice3,resource.lblPrintChange3,cbSize3);
		ShirtInfo();
		
		//slide show images
		resource.lblImgSlide=new JLabel();
		resource.lblImgSlide.setBounds(0,0,905,220);
		resource.lblImgSlide.setIcon(new ImageIcon(resizeImg(img1, 905, 220)));
		
		//main panel
		add(resource.panelTitle);
		add(resource.panelWorkSpace);
		add(resource.panelWorkSpaceHeader);
		add(resource.panelBack);
		
		//add
		resource.panelTitle.add(resource.lblTitle);
		resource.panelHeader.add(resource.lblSubTitle);
		resource.panelHeader.add(resource.panelTitleBorder);
		resource.panelHeader.add(resource.panelMenu);
		resource.panelMenu.add(resource.lblMenuShirt);
		resource.panelMenu.add(resource.lblMenuTShirt);
		resource.panelMenu.add(resource.lblMenuTrousers);
		resource.panelMenu.add(resource.lblMenuShoes);
		resource.panelWorkSpaceHeader.add(resource.panelSlide);
		resource.panelWorkSpaceHeader.add(resource.panelHeader);
		resource.panelWorkSpace.add(resource.panelAbout);
		resource.panelWorkSpace.add(resource.panelCard);
		resource.panelAbout.add(resource.lblAppInfo);
		resource.panelSlide.add(resource.lblImgSlide);
		
		//mouseListener
		resource.lblMenuShirt.addMouseListener(this);
		resource.lblMenuTShirt.addMouseListener(this);
		resource.lblMenuTrousers.addMouseListener(this);
		resource.lblMenuShoes.addMouseListener(this);
		
		
		setVisible(true);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////shirt information
	public void ShirtInfo(){
		txtAmount1.setText("");
		txtAmount2.setText("");
		txtAmount3.setText("");
		cbSize1.setSelectedIndex(0);
		cbSize2.setSelectedIndex(0);
		cbSize3.setSelectedIndex(0);
		
		resource.lblImg1.setIcon(new ImageIcon(resizeImg(obj1[0].GetImg(),170,240)));
		resource.lblPrintCode1.setText(""+obj1[0].GetCode());
		resource.lblPrintPrice1.setText("$"+obj1[0].GetPrice());
		
		resource.lblImg2.setIcon(new ImageIcon(resizeImg(obj1[1].GetImg(),170,240)));
		resource.lblPrintCode2.setText(""+obj1[1].GetCode());
		resource.lblPrintPrice2.setText("$"+obj1[1].GetPrice());
		
		resource.lblImg3.setIcon(new ImageIcon(resizeImg(obj1[2].GetImg(),170,240)));
		resource.lblPrintCode3.setText(""+obj1[2].GetCode());
		resource.lblPrintPrice3.setText("$"+obj1[2].GetPrice());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////T-Shirt information
	public void TShirtInfo(){
		txtAmount1.setText("");
		txtAmount2.setText("");
		txtAmount3.setText("");
		cbSize1.setSelectedIndex(0);
		cbSize2.setSelectedIndex(0);
		cbSize3.setSelectedIndex(0);
		
		resource.lblImg1.setIcon(new ImageIcon(resizeImg(obj2[0].GetImg(),170,240)));
		resource.lblPrintCode1.setText(""+obj2[0].GetCode());
		resource.lblPrintPrice1.setText("$"+obj2[0].GetPrice());
		
		resource.lblImg2.setIcon(new ImageIcon(resizeImg(obj2[1].GetImg(),170,240)));
		resource.lblPrintCode2.setText(""+obj1[1].GetCode());
		resource.lblPrintPrice2.setText("$"+obj1[1].GetPrice());
		
		resource.lblImg3.setIcon(new ImageIcon(resizeImg(obj2[2].GetImg(),170,240)));
		resource.lblPrintCode3.setText(""+obj2[2].GetCode());
		resource.lblPrintPrice3.setText("$"+obj2[2].GetPrice());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////Trousers information
	public void TrousersInfo(){
		txtAmount1.setText("");
		txtAmount2.setText("");
		txtAmount3.setText("");
		cbSize1.setSelectedIndex(0);
		cbSize2.setSelectedIndex(0);
		cbSize3.setSelectedIndex(0);
		
		resource.lblImg1.setIcon(new ImageIcon(resizeImg(obj3[0].GetImg(),170,240)));
		resource.lblPrintCode1.setText(""+obj3[0].GetCode());
		resource.lblPrintPrice1.setText("$"+obj3[0].GetPrice());
		
		resource.lblImg2.setIcon(new ImageIcon(resizeImg(obj3[1].GetImg(),170,240)));
		resource.lblPrintCode2.setText(""+obj3[1].GetCode());
		resource.lblPrintPrice2.setText("$"+obj3[1].GetPrice());
		
		resource.lblImg3.setIcon(new ImageIcon(resizeImg(obj3[2].GetImg(),170,240)));
		resource.lblPrintCode3.setText(""+obj3[2].GetCode());
		resource.lblPrintPrice3.setText("$"+obj3[2].GetPrice());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////Top information
	public void TopInfo(){
		txtAmount1.setText("");
		txtAmount2.setText("");
		txtAmount3.setText("");
		cbSize1.setSelectedIndex(0);
		cbSize2.setSelectedIndex(0);
		cbSize3.setSelectedIndex(0);
		
		resource.lblImg1.setIcon(new ImageIcon(resizeImg(obj4[0].GetImg(),170,240)));
		resource.lblPrintCode1.setText(""+obj4[0].GetCode());
		resource.lblPrintPrice1.setText("$"+obj4[0].GetPrice());
		
		resource.lblImg2.setIcon(new ImageIcon(resizeImg(obj4[1].GetImg(),170,240)));
		resource.lblPrintCode2.setText(""+obj4[1].GetCode());
		resource.lblPrintPrice2.setText("$"+obj4[1].GetPrice());
		
		resource.lblImg3.setIcon(new ImageIcon(resizeImg(obj4[2].GetImg(),170,240)));
		resource.lblPrintCode3.setText(""+obj4[2].GetCode());
		resource.lblPrintPrice3.setText("$"+obj4[2].GetPrice());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////my card
	public void myCard(int x,int y,int w,int h, JTextField amount,JLabel lblBtnShop,JLabel img,JLabel code,JLabel price,JLabel change, JComboBox<String> cbSize){
		resource.panelCard=new myPanel(x, y, w, h, "#eceff1");
		resource.panelImg=new myPanel(5,5,170,240,"#fafafa");
		lblBtnShop.addMouseListener(this);
		resource.lblCode=new myLabel(185, 20, 40, 20, "Code", resource.textColor, "#ffffff", false, false, false, "MoolBoran (Headings CS)", 14);
		resource.lblPrice=new myLabel(185, 50, 40, 20, "Price", resource.textColor, "#ffffff", false, false, false, "MoolBoran (Headings CS)", 14);
		resource.lblSize=new myLabel(185, 80, 40, 20, "Size", resource.textColor, "#ffffff", 
				false, false, false, "MoolBoran (Headings CS)", 14);
		resource.lblAmount=new myLabel(185, 110, 50, 20, "Amount", resource.textColor, "#ffffff", 
				false, false, false, "MoolBoran (Headings CS)", 14);
		resource.lblChange=new myLabel(185, 140, 50, 20, "Change", resource.textColor, "#ffffff", 
				false, false, false, "MoolBoran (Headings CS)", 14);
		
		resource.panelImg.add(img);
		resource.panelCard.add(lblBtnShop);
		resource.panelCard.add(resource.panelImg);
		resource.panelCard.add(resource.lblCode);
		resource.panelCard.add(code);
		resource.panelCard.add(resource.lblPrice);
		resource.panelCard.add(price);
		resource.panelCard.add(resource.lblSize);
		resource.panelCard.add(resource.lblAmount);
		resource.panelCard.add(resource.lblChange);
		resource.panelCard.add(amount);
		resource.panelCard.add(cbSize);
		resource.panelCard.add(change);
		resource.panelWorkSpace.add(resource.panelCard);
	}
	
	//l/////////////////////////////////////////////////////////////////////////////////////////my TextField
	public static class myTextField extends JTextField{
		public myTextField(){
			setText("");
			setBorder(null);
			setHorizontalAlignment(JTextField.RIGHT);
			setBounds(240, 108, 55, 25);
			setForeground(Color.decode(resource.textColor));
			setFont(new Font("MoolBoran (Headings CS)", Font.BOLD, 15));
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////myComboBox
	public static class myCombobox extends JComboBox<String>{
		public myCombobox(){
			setBounds(240, 80, 55, 20);
			setEditable(false);
			setBorder(null);
			setForeground(Color.decode(resource.textColor));
			setFont(new Font("MoolBoran (Headings CS)", Font.BOLD, 14));
			setBackground(Color.decode("#ffffff"));
			addItem("  S");
			addItem("  M");
			addItem("  L");
			addItem("  XL");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////my Panel
	public static class myPanel extends JPanel{
		public myPanel(int x,int y,int w,int h,String color){
			setBounds(x,y,w,h);
			setBackground(Color.decode(color));
			setLayout(null);
			resource.lblAppInfo=new myLabel(300, 5, 350, 20, "Copy right 2017,All rights reserved. <SLS 18th Group3>", "#bdbdbd","#ffffff", 
					false, true, false, "Segoe UI", 12);
			resource.lblTitle=new myLabel(0, 5, 200, 30, "Mr's Clothes", "#ffffff", "#ffffff",false, true, false, "ANDERSON", 22);
			resource.lblSubTitle=new myLabel(287, 40, 300, 20, "Man Clothes Shop", resource.textColorSecondary, "#ffffff", false, true, false, "ANDERSON", 12);
			resource.lblMenuShirt=new myLabel(0, 0, 60, 30, "SHIRT", resource.highLightColor, "#ffffff", true, true, true, "MoolBoran (Headings CS)", 15);
			resource.lblMenuTShirt=new myLabel(130, 0, 75, 30, "T-SHIRT", resource.textColor, "#ffffff", true, true, true, "MoolBoran (Headings CS)", 15);
			resource.lblMenuTrousers=new myLabel(275, 0, 100, 30, "TROUSERS", resource.textColor, "#ffffff", true, true, true, "MoolBoran (Headings CS)", 15);
			resource.lblMenuShoes=new myLabel(445, 0, 65  , 30, "TOP",resource.textColor, "#ffffff", true, true, true, "MoolBoran (Headings CS)", 15);
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////my label
	public static class myLabel extends JLabel{
		public myLabel(int x,int y,int w,int h,String text,String color, String foreground,boolean bold,Boolean center,boolean background,String font, int fsize){
			setBounds(x,y,w,h);
			setText(text);
			setForeground(Color.decode(color));
			setBackground(Color.decode(foreground));
			if(background==true) setOpaque(true);
			if(background==false) setOpaque(false);
			if(bold==true) setFont(new Font(font,Font.BOLD,fsize));
			if(bold==false) setFont(new Font(font,0,fsize));
			if(center==true){
				setHorizontalAlignment(JLabel.CENTER);
				setVerticalAlignment(JLabel.CENTER);
			} 
			if(center==false){
				setVerticalAlignment(JLabel.CENTER);
			}
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////slide show images
	public void SlideShow(){
		timer=new Timer(4000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				resource.lblImgSlide.setIcon(new ImageIcon(resizeImg(imageSlideList[slideCount], 905,220)));
				slideCount++;
				if(slideCount>=imageSlideList.length) slideCount=0;
			}
		});
		timer.start();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////images
	public static BufferedImage resizeImg(BufferedImage img, int newW, int newH)
	{
		int w = img.getWidth();
		int h = img.getHeight();
		BufferedImage dimg = new BufferedImage(newW, newH, img.getType());
		Graphics2D g = dimg.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
		g.dispose();
		return dimg; }
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////when a button cliked
		public void ButtonClicked(int id){
			switch(id){
			case 0: ShirtInfo(); break;
			case 1: TShirtInfo(); break;
			case 2: TrousersInfo(); break;
			case 3: TopInfo(); break;
			case 4:
				amount=Double.parseDouble(txtAmount1.getText());
				if(clicked==1) price=obj1[0].GetPrice();
				if(clicked==2) price=obj2[0].GetPrice();
				if(clicked==3) price=obj3[0].GetPrice();
				if(clicked==4) price=obj4[0].GetPrice();
				if(amount>=price){
					change=amount-price;
					resource.lblPrintChange1.setText("$"+change);
				}else if(amount<price)
					JOptionPane.showMessageDialog(null, "Invalid Amount","Warnning",JOptionPane.PLAIN_MESSAGE);
				break;
			case 5:
				amount=Double.parseDouble(txtAmount2.getText());
				if(clicked==1) price=obj1[1].GetPrice();
				if(clicked==2) price=obj2[1].GetPrice();
				if(clicked==3) price=obj3[1].GetPrice();
				if(clicked==4) price=obj4[1].GetPrice();
				if(amount>=price){
					change=amount-price;
					resource.lblPrintChange2.setText("$"+change);
				}else JOptionPane.showMessageDialog(null, "Invalid Amount","Warnning",JOptionPane.PLAIN_MESSAGE);
				break;
			case 6:
				amount=Double.parseDouble(txtAmount3.getText());
				if(clicked==1) price=obj1[2].GetPrice();
				if(clicked==2) price=obj2[2].GetPrice();
				if(clicked==3) price=obj3[2].GetPrice();
				if(clicked==4) price=obj4[2].GetPrice();
				if(amount>=price){
					change=amount-price;
					resource.lblPrintChange3.setText("$"+change);
				}else JOptionPane.showMessageDialog(null, "Invalid Amount","Warnning",JOptionPane.PLAIN_MESSAGE);
				break;
			}
		}
	
	///////////////////////////////////////////////////////////////////////////////////////mouse listener
	@Override
	public void mouseClicked(MouseEvent e) {
		
		//menu
		if(e.getSource().equals(resource.lblMenuShirt)) id=0;
		if(e.getSource().equals(resource.lblMenuTShirt)) id=1;
		if(e.getSource().equals(resource.lblMenuTrousers)) id=2;
		if(e.getSource().equals(resource.lblMenuShoes)) id=3;
		//shop now
		if(e.getSource().equals(resource.lblShop1)) id=4;
		if(e.getSource().equals(resource.lblShop2)) id=5;
		if(e.getSource().equals(resource.lblShop3)) id=6;
		
		switch (id) {
		case 0:
			clicked=1;
			System.out.println("Hello");
			resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			///show shirt information
			ButtonClicked(id);
			
			break;
		case 1:
			clicked=2;
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
			//t-shirt
			ButtonClicked(id);
			
			break;
		case 2: 
			clicked=3;
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
			//trousers
			ButtonClicked(id);
			
			break;
		case 3: 
			clicked=4;
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
			//top
			ButtonClicked(id);
			break;
			
		//shop now action
		case 4:
			resource.lblShop1.setBackground(Color.decode(resource.buttonCliked));
			ButtonClicked(id);
//			System.out.println("Hiii Hello Reach");
			break;
		case 5:
			resource.lblShop2.setBackground(Color.decode(resource.buttonCliked));
			ButtonClicked(id);
			break;
		case 6:
			resource.lblShop3.setBackground(Color.decode(resource.buttonCliked));
			ButtonClicked(id);
			break;
		default:
			break;
		}

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		int id=0;
		if(e.getSource().equals(resource.lblMenuShirt)) id=0;
		if(e.getSource().equals(resource.lblMenuTShirt)) id=1;
		if(e.getSource().equals(resource.lblMenuTrousers)) id=2;
		if(e.getSource().equals(resource.lblMenuShoes)) id=3;
		//shop now
				if(e.getSource().equals(resource.lblShop1)) id=4;
				if(e.getSource().equals(resource.lblShop2)) id=5;
				if(e.getSource().equals(resource.lblShop3)) id=6;
		
		switch(id){
		case 0:
			resource.lblMenuShirt.setForeground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode(resource.highLightColor));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
//			if(clicked==1) lblMenuShirt.setForeground(Color.decode("#00bfa5"));
			if(clicked==2) resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
			if(clicked==3) resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
			if(clicked==4) resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
			break;
		case 1:
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode(resource.highLightColor));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
			if(clicked==1) resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
//			if(clicked==2) lblMenuTShirt.setForeground(Color.decode("#00bfa5"));
			if(clicked==3) resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
			if(clicked==4) resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
			break;
			
		case 2:
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode(resource.highLightColor));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			
			if(clicked==1) resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
			if(clicked==2) resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
//			if(clicked==2) lblMenuTrousers.setForeground(Color.decode("#00bfa5"));
			if(clicked==4) resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
			break;
		case 3:
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode("#ffffff"));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode(resource.highLightColor));
			
			if(clicked==1) resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
			if(clicked==2) resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
			if(clicked==3) resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
//			if(clicked==4) lblMenuShoes.setForeground(Color.decode("#00bfa5"));
			break;
			//shop now action
			case 4:
				resource.lblShop1.setBackground(Color.decode(resource.buttonHover));
				break;
			case 5:
				resource.lblShop2.setBackground(Color.decode(resource.buttonHover));
				break;
			case 6:
				resource.lblShop3.setBackground(Color.decode(resource.buttonHover));
				break;
		}
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
	
		resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
		resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
		resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
		resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
		
		resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
		resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
		resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
		resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
		
		//shop now
		resource.lblShop1.setBackground(Color.decode(resource.highLightColor));
		resource.lblShop2.setBackground(Color.decode(resource.highLightColor));
		resource.lblShop3.setBackground(Color.decode(resource.highLightColor));
		
		if(clicked==1) resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
		if(clicked==2) resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
		if(clicked==3) resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
		if(clicked==4) resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
		 
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//empty
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		int id=0;
		if(e.getSource().equals(resource.lblMenuShirt)) id=0;
		if(e.getSource().equals(resource.lblMenuTShirt)) id=1;
		if(e.getSource().equals(resource.lblMenuTrousers)) id=2;
		if(e.getSource().equals(resource.lblMenuShoes)) id=3;
		
		switch (id) {
		case 0:
			resource.lblMenuShirt.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			break;
		case 1:
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			break;
		case 2: 
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.highLightColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.textColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			break;
		case 3: 
			resource.lblMenuShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTShirt.setForeground(Color.decode(resource.textColor));
			resource.lblMenuTrousers.setForeground(Color.decode(resource.textColor));
			resource.lblMenuShoes.setForeground(Color.decode(resource.highLightColor));
			
			resource.lblMenuShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTShirt.setBackground(Color.decode("#ffffff"));
			resource.lblMenuTrousers.setBackground(Color.decode("#ffffff"));
			resource.lblMenuShoes.setBackground(Color.decode("#ffffff"));
			break;
		default:
			break;
		}
		
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////main
	public static void main(String[] args) throws IOException{
	new Shop();
	}
}
