package s22;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class themVaoGioHang {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://pgmgolf.vn/");
		driver.manage().window().maximize();

		
		// Dang nhap
//		WebElement dangNhap = driver.findElement(By.linkText("Đăng nhập"));
//		dangNhap.click();
//		driver.findElement(By.id("CustomerEmail")).sendKeys("minh@gmail.com");
//		driver.findElement(By.id("CustomerPassword")).sendKeys("abc123xyz");
//		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//1. Xem san pham trong gio hang (test 2 & 3)
//		WebElement gioHang = driver.findElement(By.className("desktop-cart-wrapper"));
//		gioHang.click();
//		Thread.sleep(2000);
//		String count = driver.findElement(By.className("hd-cart-count")).getText();
//		Thread.sleep(2000);
//		System.out.println("Gio hang co: " + count + " san pham");
		
		//Test 4: Thêm sản phẩm vào giỏ hàng trực tiếp từ trang chủ
//	    {
//	      WebElement element = driver.findElement(By.xpath("//*[@id=\"1025514235-tab1\"]"));
//	      Actions actions = new Actions(driver);
//	      actions.moveToElement(element).perform();
//	    }
//	    try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//	    
//	    driver.findElement(By.xpath("//*[@id=\"collection1\"]/div[1]/div[1]/div/div[1]/div[2]/div/button[2]")).click();
//	    try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//	    
//	    String text_t4 = driver.findElement(By.xpath("//*[@id=\"modalAddComplete\"]/div/div/div/h2")).getText();
//	    System.out.println(text_t4);
	  
		//Test5,6,7,8: Thêm sản phẩm vào giỏ hàng từ xem nhanh
//		{
//		      WebElement element = driver.findElement(By.xpath("//*[@id=\"1025514235-tab1\"]"));
//		      Actions actions = new Actions(driver);
//		      actions.moveToElement(element).perform();
//		    }
//			Thread.sleep(2000);
//			
//		    driver.findElement(By.xpath("//*[@id=\"collection1\"]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();		  
//	        Thread.sleep(2000);
//	        
//	        WebElement input6 = driver.findElement(By.xpath("//*[@id=\"form-quick-view\"]/div[2]/div[4]/div/input"));
//		    input6.clear();
//		    input6.sendKeys("-10");		    
//		    Thread.sleep(3000);
//		    
//		    WebElement input7 = driver.findElement(By.xpath("//*[@id=\"form-quick-view\"]/div[2]/div[4]/div/input"));
//		    input7.clear();
//		    input7.sendKeys("9");		    
//		    Thread.sleep(3000);
//		    
//		    driver.findElement(By.xpath("//*[@id=\"variant-swatch-0-quickview\"]/div[2]/div[2]/label")).click();
//		    Thread.sleep(3000);
//		    
//		    driver.findElement(By.xpath("//*[@id=\"AddToCardQuickView\"]")).click();
//		    try {
//	            Thread.sleep(3000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    String text_t5 = driver.findElement(By.xpath("//*[@id=\"modalAddComplete\"]/div/div/div/h2")).getText();
//		    System.out.println(text_t5);
		
		//Test 6
//		{
//		      WebElement element = driver.findElement(By.xpath("//*[@id=\"1025514235-tab1\"]"));
//		      Actions actions = new Actions(driver);
//		      actions.moveToElement(element).perform();
//		    }
//		    try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    driver.findElement(By.xpath("//*[@id=\"collection1\"]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
//		    try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    WebElement inputField = driver.findElement(By.xpath("//*[@id=\"form-quick-view\"]/div[2]/div[4]/div/input"));
//		    inputField.clear();
//		    inputField.sendKeys("-1");
//		    try {
//	            Thread.sleep(3000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    driver.findElement(By.xpath("//*[@id=\"AddToCardQuickView\"]")).click();
//		    try {
//	            Thread.sleep(3000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    String text_t6 = driver.findElement(By.xpath("//*[@id=\"modalAddComplete\"]/div/div/div/h2")).getText();
//		    System.out.println(text_t6);
			
		// Test 7
//		{
//		      WebElement element = driver.findElement(By.xpath("//*[@id=\"1025514235-tab1\"]"));
//		      Actions actions = new Actions(driver);
//		      actions.moveToElement(element).perform();
//		    }
//		    try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    driver.findElement(By.xpath("//*[@id=\"collection1\"]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
//		    try {
//	            Thread.sleep(2000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    WebElement inputField = driver.findElement(By.xpath("//*[@id=\"form-quick-view\"]/div[2]/div[4]/div/input"));
//		    inputField.clear();
//		    inputField.sendKeys("999999");
//		    try {
//	            Thread.sleep(3000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    driver.findElement(By.xpath("//*[@id=\"AddToCardQuickView\"]")).click();
//		    try {
//	            Thread.sleep(3000);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//		    
//		    String text_t7 = driver.findElement(By.xpath("//*[@id=\"modalAddComplete\"]/div/div/div/h2")).getText();
//		    System.out.println(text_t7);
		    
		// Test 8
//		    {
//			      WebElement element = driver.findElement(By.xpath("//*[@id=\"1025514235-tab1\"]"));
//			      Actions actions = new Actions(driver);
//			      actions.moveToElement(element).perform();
//			    }
//			    try {
//		            Thread.sleep(2000);
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
//			    
//			    driver.findElement(By.xpath("//*[@id=\"collection1\"]/div[1]/div[1]/div/div[1]/div[2]/div/button[1]")).click();
//			    try {
//		            Thread.sleep(2000);
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
//			    
//			    driver.findElement(By.xpath("//*[@id=\"variant-swatch-0-quickview\"]/div[2]/div[2]/label")).click();
//			    
//			    try {
//		            Thread.sleep(3000);
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
//			    
//			    driver.findElement(By.xpath("//*[@id=\"AddToCardQuickView\"]")).click();
//			    try {
//		            Thread.sleep(3000);
//		        } catch (InterruptedException e) {
//		            e.printStackTrace();
//		        }
//			    
//			    String text_t8 = driver.findElement(By.xpath("//*[@id=\"modalAddComplete\"]/div/div/div/h2")).getText();
//			    System.out.println(text_t8);
		
		//Test 9,10,11,12
		driver.findElement(By.id("1025514235-tab1")).click();
		
		WebElement input10 = driver.findElement(By.xpath("//*[@id=\"Quantity\"]"));
		input10.clear();
		input10.sendKeys("-10");
	    TimeUnit.SECONDS.sleep(2);
	    
	    WebElement input11 = driver.findElement(By.xpath("//*[@id=\"Quantity\"]"));
	    input11.clear();
	    input11.sendKeys("9");
	    TimeUnit.SECONDS.sleep(2);
	    
	    driver.findElement(By.xpath("//*[@id=\"variant-swatch-0\"]/div[2]/div[2]/label")).click();
	    TimeUnit.SECONDS.sleep(2);
	    
		driver.findElement(By.id("AddToCart")).click();
        TimeUnit.SECONDS.sleep(2);

		driver.findElement(By.linkText("Tiếp tục mua hàng")).click();
		WebElement gioHang = driver.findElement(By.className("desktop-cart-wrapper"));
		gioHang.click();
		String count = driver.findElement(By.className("hd-cart-count")).getText();
		System.out.println("Gio hang co: " + count + " san pham");
		
		//Test 10
//		driver.findElement(By.id("1025588711-tab1")).click();
//		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"Quantity\"]"));
//	    inputField.clear();
//	    inputField.sendKeys("-1");
//	    try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		
//		driver.findElement(By.id("AddToCart")).click();
//		try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		driver.findElement(By.linkText("Tiếp tục mua hàng")).click();
//		WebElement gioHang = driver.findElement(By.className("desktop-cart-wrapper"));
//		gioHang.click();
//		String count = driver.findElement(By.className("hd-cart-count")).getText();
//		System.out.println("Gio hang co: " + count + " san pham");
		
		//Test 11
//		driver.findElement(By.id("1025588711-tab1")).click();
//		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"Quantity\"]"));
//	    inputField.clear();
//	    inputField.sendKeys("999999");
//	    try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		
//		driver.findElement(By.id("AddToCart")).click();
//		try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		driver.findElement(By.linkText("Tiếp tục mua hàng")).click();
//		WebElement gioHang = driver.findElement(By.className("desktop-cart-wrapper"));
//		gioHang.click();
//		String count = driver.findElement(By.className("hd-cart-count")).getText();
//		System.out.println("Gio hang co: " + count + " san pham");
		
		//Test 12
//		driver.findElement(By.id("1025514235-tab1")).click();
//		driver.findElement(By.xpath("//*[@id=\"variant-swatch-0\"]/div[2]/div[2]/label")).click();
//	    try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		
//		driver.findElement(By.id("AddToCart")).click();
//		try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//		driver.findElement(By.linkText("Tiếp tục mua hàng")).click();
//		WebElement gioHang = driver.findElement(By.className("desktop-cart-wrapper"));
//		gioHang.click();
//		String count = driver.findElement(By.className("hd-cart-count")).getText();
//		System.out.println("Gio hang co: " + count + " san pham");		
//		
//		//Test 13: Tang so luong cua san pham trong gio hang
		TimeUnit.SECONDS.sleep(2);
		driver.findElement(By.cssSelector("a[href='/cart']")).click();
		
		String soluongtruoc = driver.findElement(By.cssSelector("#updates_")).getAttribute("value");
		System.out.println("So luong: " + soluongtruoc);
		int sltruoc = Integer.parseInt(soluongtruoc.replaceAll("[^\\d.]", ""));
		
		TimeUnit.SECONDS.sleep(2);
		
		driver.findElement(By.cssSelector(".cart__row:nth-child(1) .js-qty__adjust--plus")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div/form[1]/div/div[2]/button[1]")).click();
		
		TimeUnit.SECONDS.sleep(2);
		
		String giaban = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div/form[1]/table/tbody/tr[1]/td[3]/span")).getText();
		System.out.println("Gia ban: " + giaban);
		int gban = Integer.parseInt(giaban.replaceAll("[^\\d.]", ""));
		
		String soluongsau = driver.findElement(By.cssSelector("#updates_")).getAttribute("value");
		System.out.println("So luong sau tang: " + soluongsau);
		int slsau = Integer.parseInt(soluongsau.replaceAll("[^\\d.]", ""));
		
		String tongtien = driver.findElement(By.cssSelector("#page-wrapper > div > div > form.cart.table-wrap.medium--hide.small--hide > table > tbody > tr:nth-child(1) > td.cart-product-price.text-right > span")).getText();
		System.out.println("Tong tien: " + tongtien);
		int ttien = Integer.parseInt(tongtien.replaceAll("[^\\d.]", ""));
		
		if(gban*slsau != ttien) {
			System.out.println("Test fail");
		}
		else {
			System.out.println("Test true");
		}
		
		
		//Test 14. Giam so luong cua san pham trong gio hang
		System.out.println("\nGiam so luong");	
		//driver.findElement(By.cssSelector("a[href='/cart']")).click();
		
		soluongtruoc = driver.findElement(By.cssSelector("#updates_")).getAttribute("value");
		System.out.println("So luong: " + soluongtruoc);
		sltruoc = Integer.parseInt(soluongtruoc.replaceAll("[^\\d.]", ""));
		
		if(sltruoc <= 1) {
			System.out.println("Tối thiểu là 1, không thể giảm ít hơn!");
		}
		TimeUnit.SECONDS.sleep(2);
		
		driver.findElement(By.cssSelector(".cart__row:nth-child(1) .js-qty__adjust--minus")).click();
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div/form[1]/div/div[2]/button[1]")).click();
		try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		soluongsau = driver.findElement(By.cssSelector("#updates_")).getAttribute("value");
		System.out.println("So luong sau giam: " + soluongsau);
		slsau = Integer.parseInt(soluongsau.replaceAll("[^\\d.]", ""));
		
		tongtien = driver.findElement(By.cssSelector("#page-wrapper > div > div > form.cart.table-wrap.medium--hide.small--hide > table > tbody > tr:nth-child(1) > td.cart-product-price.text-right > span")).getText();
		System.out.println("Tong tien: " + tongtien);
		ttien = Integer.parseInt(tongtien.replaceAll("[^\\d.]", ""));
		
		if(gban*slsau != ttien) {
			System.out.println("Test false");
		}
		else {
			System.out.println("Test true");
		}
		
		
		//Test 15. Xoa san pham khoi gio hang
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div/form[1]/table/tbody/tr/td[2]/a[2]/small")).click();
		
		try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        
//        
		driver.close();
	}
}
