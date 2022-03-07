package com.uniovi.notaneitor.pageobjects;

import com.uniovi.notaneitor.util.SeleniumUtils;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PO_PrivateView extends PO_NavView {

    static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp, String scorep) {
        //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
        SeleniumUtils.waitSeconds(driver, 5);
        //Seleccionamos el alumnos userOrder
        new Select(driver.findElement(By.id("user"))).selectByIndex(userOrder);
        //Rellenemos el campo de descripción
        WebElement description = driver.findElement(By.name("description"));
        description.clear();
        description.sendKeys(descriptionp);
        WebElement score = driver.findElement(By.name("score"));
        score.click();
        score.clear();
        score.sendKeys(scorep);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    static public void clickAndFill(WebDriver driver, String user) {
        PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
        //Rellenamos el formulario
        PO_LoginView.fillLoginForm(driver, user, "123456");
    }

    static public void checkLogout(WebDriver driver) {
        String loginText = PO_HomeView.getP().getString("signup.message", PO_Properties.getSPANISH());
        PO_PrivateView.clickOption(driver, "logout", "text", loginText);
    }

    public static void checkTextAndClickMark(WebDriver driver, String checkText, int i) {
        List<WebElement> elements = PO_View.checkElementBy(driver, "free", checkText);
        elements.get(i).click();
    }

    public static void marksMenu(WebDriver driver) {
        checkTextAndClickMark(driver, "//li[contains(@id, 'marks-menu')]/a", 0);
    }

    public static void addMark(WebDriver driver) {
        checkTextAndClickMark(driver, "//a[contains(@href, 'mark/add')]", 0);
    }

    public static void listMarks(WebDriver driver) {
        checkTextAndClickMark(driver, "//a[contains(@href, 'mark/list')]", 0);
    }

    public static void pageLink(WebDriver driver) {
        checkTextAndClickMark(driver, "//a[contains(@class, 'page-link')]", 3);
    }
}
