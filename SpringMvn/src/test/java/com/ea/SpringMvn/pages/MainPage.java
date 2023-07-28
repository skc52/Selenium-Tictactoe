package com.ea.SpringMvn.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainPage {
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private HomePage homePage;

    @Value("${app.url}")
    private String appUrl;

//    public MainPage(LoginPage loginPage, HomePage homePage) {
//        this.loginPage = loginPage;
//        this.homePage = homePage;
//    }

    @Autowired
    private WebDriver webDriver;

    public void PerformLogin(){
        webDriver.navigate().to(appUrl);
        homePage.ClickLogin();
        try {
            Thread.sleep(3000); // Delay for 3 seconds
        } catch (InterruptedException e) {
            // Handle the exception appropriately
        }
        loginPage.Login("admin", "adminpassword23432");
        loginPage.ClickLogin();
    }
}
