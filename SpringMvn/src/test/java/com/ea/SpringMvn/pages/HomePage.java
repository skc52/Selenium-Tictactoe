package com.ea.SpringMvn.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage {

    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void  InitHomePage(){
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public WebElement lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public WebElement lnkEmployeeList;

    public LoginPage ClickLogin(){
        try {
            Thread.sleep(3000); // Delay for 3 seconds
        } catch (InterruptedException e) {
            // Handle the exception appropriately
        }
        lnkLogin.click();
//        System.out.println("Click the home page login");
        return new LoginPage();
    }

    public void ClickEmployeeList(){
        try {
            Thread.sleep(3000); // Delay for 3 seconds
        } catch (InterruptedException e) {
            // Handle the exception appropriately
        }
        lnkEmployeeList.click();
    }
}
