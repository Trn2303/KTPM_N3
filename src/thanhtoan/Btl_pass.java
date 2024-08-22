
package thanhtoan;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Btl_pass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\DowloadApp\\autoTest\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  // Tăng thời gian đợi

        try {
            driver.get("https://pgmgolf.vn/");
            driver.manage().window().setSize(new org.openqa.selenium.Dimension(1552, 832));

            // Thêm sản phẩm vào giỏ hàng và tiến hành thanh toán
            wait.until(ExpectedConditions.elementToBeClickable(By.id("1025518958-tab1"))).click();
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("AddToCart"))).click();
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btnProceedCheckout"))).click();
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".content:nth-child(7)"))).click();
            TimeUnit.SECONDS.sleep(2);

            driver.findElement(By.id("billing_address_full_name")).sendKeys("Thuy Mai");

            driver.findElement(By.id("checkout_user_email")).sendKeys("thanhthanh@gmail.com");
            driver.findElement(By.id("billing_address_phone")).sendKeys("0368479525");

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".section-customer-information > .fieldset"))).click();

            // Nhập địa chỉ
            WebElement addressField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("billing_address_address1")));
            addressField.sendKeys("nghe thanh");
            TimeUnit.SECONDS.sleep(2);

            // Chọn tỉnh/thành phố
            WebElement provinceField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form_update_location_customer_shipping\"]/div[3]")));
            provinceField.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement provinceOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_shipping_province\"]/option[3]")));
            provinceOption.click();
            TimeUnit.SECONDS.sleep(2);

            // Chọn quận/huyện
            WebElement districtField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_shipping_district\"]")));
            districtField.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement districtOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_shipping_district\"]/option[10]")));
            districtOption.click();
            TimeUnit.SECONDS.sleep(2);

            // Chọn phường/xã
            WebElement wardField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_shipping_ward\"]")));
            wardField.click();
            TimeUnit.SECONDS.sleep(2);
            WebElement wardOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customer_shipping_ward\"]/option[11]")));
            wardOption.click();
            TimeUnit.SECONDS.sleep(2);

            // Chọn phương thức thanh toán
            WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"section-payment-method\"]/div[3]/div/div[3]/label")));
            paymentMethod.click();
            TimeUnit.SECONDS.sleep(2);

            WebElement thanhToan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout_complete\"]/button")));
            thanhToan.click();
            TimeUnit.SECONDS.sleep(2);

            String thongBaoThanhCong =  driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/div[1]/div/div/h2")).getText();
            System.out.println(thongBaoThanhCong);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
