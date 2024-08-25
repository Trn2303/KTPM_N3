
package thanhtoan;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Btl_pass {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

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

             //Điền thông tin thanh toán
            WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_address_full_name")));
            nameField.sendKeys("thuy hoai");
            TimeUnit.SECONDS.sleep(2);

            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout_user_email")));
            emailField.sendKeys("thanhthanh@");
            TimeUnit.SECONDS.sleep(2);

            WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_address_phone")));
            phoneField.sendKeys("0368479525");
            TimeUnit.SECONDS.sleep(2);
            
            // Nhập địa chỉ
            WebElement addressField = wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_address_address1")));
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

            // Nhấn nút thanh toán
            //để trống trường bắt buộc
            WebElement thanhToan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form_next_step\"]/button")));

//            //Nhập thông tin hợp lệ
//            WebElement thanhToan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout_complete\"]/button")));
            thanhToan.click();
            TimeUnit.SECONDS.sleep(5);
            
            try {
                // Kiểm tra thông báo lỗi cho các trường bắt buộc
                boolean hasError = false;

                // nhóm lỗi để trống
                String[] errorXPaths = {
                    "/html/body/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[1]/p", // Tên
                    "/html/body/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/p", // Số điện thoại
                    "//*[@id=\"form_update_location_customer_shipping\"]/div[2]/p", // Địa chỉ
                    "//*[@id=\"form_update_location_customer_shipping\"]/div[3]/p", // Tỉnh
                    "//*[@id=\"form_update_location_customer_shipping\"]/div[4]/p", // Quận
                    "//*[@id=\"form_update_location_customer_shipping\"]/div[5]/p" // Xã
                };

                // Kiểm tra từng thông báo lỗi
                for (String xpath : errorXPaths) {
                    try {
                        WebElement errorElement = driver.findElement(By.xpath(xpath));
                        if (errorElement.isDisplayed()) {
                            System.out.println("Vui long nhạp cac truong bat buoc!!");
                            hasError = true;
                            break; // Dừng kiểm tra nếu đã phát hiện lỗi
                        }
                    } catch (Exception e) {
                        // Lỗi khi không tìm thấy phần tử không cần xử lý
                    }
                }

                // Kiểm tra lỗi email không đúng định dạng
                if (!hasError) {
                    try {
                        WebElement emailError = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[2]/p"));
                        if (emailError.isDisplayed()) {
                            System.out.println("Email khong dung dinh dang!!");
                            hasError = true;
                        }
                    } catch (Exception e) {
                        // Lỗi khi không tìm thấy phần tử không cần xử lý
                    }
                }

                // Kiểm tra thông báo thanh toán thành công nếu không có lỗi
                if (!hasError) {
                    try {
                        WebElement thongBaoThanhCong = driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[2]/div/div[1]/div/div/h2"));
                        if (thongBaoThanhCong.isDisplayed()) {
                            System.out.println("Thanh toan thanh cong!!!");
                        } else {
                            System.out.println("Thanh toan khong thanh cong!!!!!");
                        }
                    } catch (Exception ex) {
                        System.out.println("Co loi xay ra!");
                        ex.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}