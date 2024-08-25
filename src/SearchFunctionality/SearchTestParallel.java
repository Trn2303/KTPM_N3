package SearchFunctionality;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class SearchTestParallel {

    WebDriver driver;
    
    @Parameters({"browserName", "browserVersion", "osVersion"})

    @BeforeMethod
    public void setup(Method method, @Optional("Chrome") String browserName, @Optional("124") String browserVersion, @Optional("Windows 11") String osVersion) throws MalformedURLException {
    	boolean useLambdaTest = method.getName().startsWith("lambdaTest");
    	System.out.println(browserName);
    	System.out.println(browserVersion);
    	System.out.println(osVersion);
        if (useLambdaTest) {
            // Cấu hình cho LambdaTest 
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "thanhthanh342012");
            ltOptions.put("accessKey", "5NyEs70pIUkjeGoYT4jCWQJ2N4Mqr3wEeflYBzJ5UJZNzVbuU5");
            ltOptions.put("resolution", "1920x1080");
            ltOptions.put("build", "SearchFunc");
            ltOptions.put("project", "SearchFunc");
            ltOptions.put("selenium_version", "4.23.0");
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-testNG");       
            
        	if(browserName.equalsIgnoreCase("Chrome")) {
        		ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("osVersion");
                browserOptions.setBrowserVersion("browserVersion");
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
        	}
        	else if (browserName.equalsIgnoreCase("Edge")) {
        		EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("osVersion");
                browserOptions.setBrowserVersion("browserVersion");
                browserOptions.setCapability("LT:Options", ltOptions);
                driver = new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), browserOptions);
        	}

        } else {
            // Sử dụng ChromeDriver
            System.setProperty("webdriver.chrome.driver", "D:\\java\\chromedriver-win64\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        
        driver.get("https://pgmgolf.vn/"); 
    }
    
    @Test
    public void lambdaTestVerifySearchIconPresence() {
        WebElement searchIcon = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]/a/div[1]")); 

        // Kiểm tra biểu tượng tìm kiếm có hiển thị không
        Assert.assertTrue(searchIcon.isDisplayed(), "Biểu tượng tìm kiếm không hiển thị");

        // Kiểm tra vị trí của biểu tượng tìm kiếm 
        int iconX = searchIcon.getLocation().getX();
        int iconY = searchIcon.getLocation().getY();
        Assert.assertEquals(iconX, 1415, "Vị trí ngang của biểu tìm kiếm không đúng.");
        Assert.assertEquals(iconY, 66, "Vị trí dọc của biểu tìm kiếm không đúng.");
    }
    
//    @Test
//    public void lambdaTestVerifySearchFieldPosition() throws InterruptedException {
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext")); 
//        
//        // Kiểm tra trường tìm kiếm có hiển thị không
//        Assert.assertTrue(searchField.isDisplayed(), "Trường tìm kiếm không hiển thị trên trang chủ.");
//        Thread.sleep(2000);
//
//        // Kiểm tra vị trí, kích thước của trường tìm kiếm
//        int fieldX = searchField.getLocation().getX();
//        int fieldY = searchField.getLocation().getY();
//        Dimension fieldExpectedSize = new Dimension(450, 42);
//        Dimension fieldSize = searchField.getSize();
//        
//        Assert.assertEquals(fieldX, 1048, "Vị trí ngang của trường tìm kiếm không đúng.");
//        Assert.assertEquals(fieldY, 163, "Vị trí dọc của trường tìm kiếm không đúng.");
//        Assert.assertEquals(fieldSize, fieldExpectedSize, "Kích thước của trường tìm kiếm không đúng.");
//        
//        // Kiểm tra khả năng nhập liệu
//        String testInput = "giày golf";
//        searchField.clear();
//        searchField.sendKeys(testInput);
//        Assert.assertEquals(searchField.getAttribute("value"), testInput, "Dữ liệu nhập vào trường tìm kiếm không chính xác.");
//    }
//  
//    @Test
//    public void searchSpecificProduct() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa "Túi"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys("Túi");
//        Thread.sleep(1000);
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        
//        // Kiểm tra kết quả tìm kiếm có liên quan với từ khóa
//        WebElement result = driver.findElement(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]"));
//        Assert.assertTrue(result.getText().toUpperCase().contains("Túi".toUpperCase()), "Không hiển thị kết quả tìm kiếm liên quan.");
//    }

//    @Test
//    public void searchWithSpecialCharacters() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa "@$#]]"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys("@$#]]");
//        Thread.sleep(1000);
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        
//        // Kiểm tra thông báo được đưa ra
//        WebElement noResultMessage = driver.findElement(By.xpath("//*[@id=\"collection-wrapper\"]/div/h1")); 
//        Assert.assertEquals(noResultMessage.getText().replaceAll("\\s", " ").toUpperCase(), ("Không tìm thấy kết quả tìm kiếm phù hợp cho:\r\n"
//        		+ "Tất cả sản phẩm / Từ khóa: @$#]]").replaceAll("\\s", " ").toUpperCase(), "Xử lý ký tự đặc biệt trong tìm kiếm không chính xác.");
//    }
//
//    @Test
//    public void searchWithNonExistentKeyword() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa "abcdxua"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys("abcdxua");
//        Thread.sleep(3000);
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        
//        // Kiểm tra thông báo đưa ra
//        WebElement noResultMessage = driver.findElement(By.xpath("//*[contains(text(), 'Không tìm thấy kết quả tìm kiếm phù hợp cho:')]")); 
//        Assert.assertEquals(noResultMessage.getText().replaceAll("\\s", "").toUpperCase(), ("Không tìm thấy kết quả tìm kiếm phù hợp cho:\r\n"
//        		+ "Tất cả sản phẩm / Từ khóa: abcdxua").replaceAll("\\s", "").toUpperCase(), "Hệ thống không xử lý đúng khi không có sản phẩm nào khớp từ khóa.");
//    }
//
//    @Test
//    public void searchWithEmptyInput() throws InterruptedException {
//    	// Thực hiện tìm kiếm với đầu vào rỗng
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        Thread.sleep(2000);
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        // Kiểm tra kết quả hiển thị
//        List<WebElement> allProductsList = driver.findElements(By.cssSelector(".product--loop"));
//        Assert.assertTrue(allProductsList.isEmpty(), "Hệ thống không xử lý đúng khi đầu vào tìm kiếm rỗng.");
//    }
//
//    @Test
//    public void searchWithLeadingWhitespace() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa có chứa ký tự khoảng trắng ở trước
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys("  găng tay");
//        Thread.sleep(3000);
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        // Kiểm tra kết quả hiển thị 
//        WebElement result = driver.findElement(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]"));
//        Assert.assertTrue(result.getText().toUpperCase().contains("găng tay".toUpperCase()), "Hệ thống không xử lý đúng ký tự khoảng trắng trước từ khóa.");
//    }
//
//    @Test
//    public void searchWithUpperCaseKeyword() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa là chữ in hoa
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        Thread.sleep(3000);
//        searchField.sendKeys("BÓNG GOLF");
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        // Kiểm tra kết quả hiển thị 
//        WebElement result = driver.findElement(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]"));
//        Assert.assertTrue(result.getText().toUpperCase().contains("bóng golf".toUpperCase()), "Hệ thống không phân biệt chữ in hoa và chữ thường đúng cách.");
//    }
//
//    @Test
//    public void searchWithoutAccents() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa tiếng Việt không dấu
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        Thread.sleep(3000);
//        searchField.sendKeys("bo gay tap");
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        
//        // Kiểm tra kết quả tìm kiếm hiển thị
//        WebElement result = driver.findElement(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]"));
//        Assert.assertTrue(result.getText().toUpperCase().contains("bộ gậy tập".toUpperCase()), "Kết quả tìm kiếm cho từ khóa tiếng Việt không dấu không chính xác.");
//    }
//
//    @Test
//    public void verifySearchSuggestions() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa "gậy golf"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.click();
//        searchField.clear();
//        searchField.sendKeys("gậy golf");
//        Thread.sleep(1000);
//        
//        // Kiểm tra gợi ý hiển thị
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement suggestionList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]/div/div/div")));
//        Assert.assertTrue(suggestionList.isDisplayed(), "Gợi ý tìm kiếm không hiển thị.");
//        Assert.assertTrue(suggestionList.getText().toUpperCase().contains("gậy golf".toUpperCase()), "Không hiển thị gợi ý tìm kiếm liên quan.");
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void verifyKeywordLengthHandling() throws InterruptedException {
//    	// Thực hiện tìm kiếm với từ khóa dài
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.clear();
//        Thread.sleep(3000);
//        searchField.sendKeys("BỘ GẬY GOLF NAM RIO 2016 III - PGM MTG040 - 12 CLUBS");
//        driver.findElement(By.id("searchsubmit")).click();
//        Thread.sleep(3000);
//        // Kiểm tra kết quả tìm kiếm hiển thị
//        WebElement result = driver.findElement(By.cssSelector("#collection-wrapper > div > div.grid-uniform.product-loop.md-mg-left-15"));
//        Assert.assertTrue(result.isDisplayed(), "Hệ thống không xử lý đúng từ khóa quá dài.");
//    }
//
//    @Test
//    public void checkPaginationInSearchResults() throws InterruptedException {
//        // Thực hiện tìm kiếm với từ khóa "gậy golf"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.clear();
//        searchField.sendKeys("gậy golf");
//        driver.findElement(By.id("searchsubmit")).click();
//
//        // Chờ cho kết quả và phân trang xuất hiện
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement pagination = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pagination")));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", pagination);
//        Thread.sleep(3000);
//
//        // Kiểm tra hiển thị phân trang
//        List<WebElement> pages = pagination.findElements(By.tagName("a"));
//        Assert.assertTrue(pages.size() > 1, "Phân trang không hiển thị đúng khi có nhiều kết quả tìm kiếm.");
//        
//        // Kiểm tra khả năng chuyển trang
//        pages.get(0).click(); 
//        js.executeScript("window.scrollBy(0, 2000);");
//        Thread.sleep(3000);
//        WebElement activePage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pagination- > span.page.current")));
//        Assert.assertEquals(activePage.getText(), "2", "Không chuyển sang trang 2 khi nhấp vào phân trang.");
//    }
//    
//    @Test
//    public void lambdaTestVerifySearchResultLayout() {
//    	// Thực hiện tìm kiếm với từ khóa "gậy golf"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.clear();
//        searchField.sendKeys("gậy golf");
//        driver.findElement(By.id("searchsubmit")).click();
//
//        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]")); 
//
//        // Kiểm tra có kết quả tìm kiếm hay không
//        Assert.assertTrue(elements.size() > 0, "Không có kết quả nào được hiển thị.");
//
//        for (WebElement result : elements) {
//            // Kiểm tra từng kết quả có hiển thị không
//            Assert.assertTrue(result.isDisplayed(), "Kết quả tìm kiếm không hiển thị.");
//
//            // Kiểm tra layout của mỗi kết quả
//            WebElement image = result.findElement(By.cssSelector(".product-img"));
//            WebElement info = result.findElement(By.cssSelector(".product-info"));
//            WebElement list_variants = result.findElement(By.cssSelector(".list-variants-img"));
//
//            Assert.assertTrue(image.isDisplayed(), "Hình ảnh không hiển thị đúng.");
//            Assert.assertTrue(info.isDisplayed(), "Thông tin sản phẩm không hiển thị đúng.");
//            Assert.assertTrue(list_variants.isDisplayed(), "Danh sách phân loại không hiển thị đúng.");
//        }
//        
//        for (WebElement element : elements) {
//            for (WebElement otherElement : elements) {
//                if (element.equals(otherElement)) continue;
//
//                // Lấy tọa độ và kích thước của phần tử đầu tiên
//                int elementX = element.getLocation().getX();
//                int elementW = elementX + element.getSize().getWidth();
//                int elementY = element.getLocation().getY();
//                int elementH = elementY + element.getSize().getHeight();
//
//                // Lấy tọa độ và kích thước của phần tử thứ hai
//                int otherX = otherElement.getLocation().getX();
//                int otherW = otherX + otherElement.getSize().getWidth();
//                int otherY = otherElement.getLocation().getY();
//                int otherH = otherY + otherElement.getSize().getHeight();
//
//                // Kiểm tra sự chồng chéo
//                boolean isOverlapping = !(elementW < otherX || elementX > otherW || elementH < otherY || elementY > otherH);
//                Assert.assertFalse(isOverlapping, "Phần tử bị chồng lên nhau.");
//            }
//        }
//
//        // Kiểm tra layout tổng thể
//        WebElement resultsContainer = driver.findElement(By.cssSelector("#other-sections-wrapper > div > div")); 
//        Assert.assertTrue(resultsContainer.isDisplayed(), "Layout của kết quả tìm kiếm bị vỡ.");
//    }
//    
//    @Test
//    public void viewProductDetailAfterSearch() {
//        // Thực hiện tìm kiếm với từ khóa "gậy golf"
//    	driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div[2]/div/div/div/div[2]/div/ul/li[11]")).click();
//        WebElement searchField = driver.findElement(By.id("searchtext"));
//        searchField.clear();
//        searchField.sendKeys("gậy golf");
//        driver.findElement(By.id("searchsubmit")).click();
//
//        // Chờ và tìm sản phẩm đầu tiên trong kết quả tìm kiếm
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collection-wrapper\"]/div/div[2]/div[1]/div/div[2]/div[1]")));	
//        String productName = firstProduct.getText();
//        firstProduct.click();
//
//        // Kiểm tra hệ thống chuyển hướng đến trang chi tiết sản phẩm
//        WebElement productDetail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-wrapper\"]/div/div/div/div[1]")));
//        Assert.assertTrue(productDetail.isDisplayed(), "Không chuyển hướng đến trang chi tiết sản phẩm");
//        
//        // Kiểm tra chi tiết sản phẩm hiển thị có đúng sản phẩm được chọn
//        String productDetailName = driver.findElement(By.xpath("//*[@id=\"product-wrapper\"]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div/div[1]/h1")).getText();
//        Assert.assertTrue(productDetailName.toUpperCase().contains(productName.toUpperCase()), "Không hiển thị đúng sản phẩm.");
//    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
