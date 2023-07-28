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
public class LoginPage {
    @Autowired
    private WebDriver webDriver;

    @PostConstruct
    public void InitLoginPage(){
        PageFactory.initElements(webDriver, this);
    }
    @FindBy(how = How.NAME, using = "UserName")
    public WebElement txtUserName;
    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;
    @FindBy(how = How.CSS, using = ".btn-default")
    public WebElement btnLogin;

    public void Login(String username, String password){
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
//        System.out.println("username and password" +username + "----" + password);
    }

    public HomePage ClickLogin(){
        btnLogin.click();
        return new HomePage();
    }


}
