package ru.yandex.practicum.burgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    // Локатор поля Имя
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    // Локатор поля Email
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    // Локатор поля Пароль
    private By passwordInput = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    // Локатор кнопки Зарегистрироваться
    private By registrationButton = By.xpath("//*[@id=\"root\"]/div/main/div/form/button");

    // Локатор кнопки Войти
    private By enterButton = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");

    // Локатор надписи Некорректный пароль

    private By incorrectPasswordTitle = By.xpath("//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    // Конструктор класса
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод перехода на страницу регистрации
    public RegistrationPage openRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        return this;
    }

    // Метод заполнения поля Имя
    public RegistrationPage setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    // Метод заполнения поля Email
    public RegistrationPage setEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    // Метод заполнения поля Password
    public RegistrationPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    // Метод клика по кнопке Зарегистрироваться
    public RegistrationPage clickRegistrationButton() {
        driver.findElement(registrationButton).click();
        return this;
    }

    // Метод клика по кнопке Войти
    public RegistrationPage clickEnterButton() {
        driver.findElement(enterButton).click();
        return this;
    }

    // Метод проверки отображения надписи Некорректный пароль
    public boolean isIncorrectPasswordTitleDisplayed() {
        return driver.findElement(incorrectPasswordTitle).isDisplayed();
    }
}
