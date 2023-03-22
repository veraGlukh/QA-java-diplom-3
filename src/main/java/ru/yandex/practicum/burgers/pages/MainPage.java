package ru.yandex.practicum.burgers.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    // Локатор для кнопки Войти в аккаунт
    private By enterAccountButton = By.xpath("//*[@id=\"root\"]/div/main/section[2]/div/button");

    // Локатор для кнопки Личный кабинет
    private By personalAccountButton = By.xpath("//*[@id=\"root\"]/div/header/nav/a/p");

    // Локатор для надписи Соберите бургер
    private By setBuggerTitle = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1");

    // Локаторы для указателя Булки в Конструкторе,
    private By bunsPointer = By.xpath(".//span[text()='Булки']");
    private By bunsPointerParent = By.xpath(".//span[text()='Булки']/parent::div");

    // Локаторы для указателя Соусы в Конструкторе
    private By saucesPointer = By.xpath(".//span[text()='Соусы']");
    private By saucesPointerParent = By.xpath(".//span[text()='Соусы']/parent::div");

    // Локаторы для указателя Начинки в Конструкторе
    private By fillingsPointer = By.xpath(".//span[text()='Начинки']/parent::div");
    private By fillingsPointerParent = By.xpath(".//span[text()='Начинки']/parent::div");

    // Конструктор класса
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод перехода на главную страницу тестового стенда
    public MainPage openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        return this;
    }

    // Метод клика по кнопке Личный кабинет
    public MainPage clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
        return this;
    }

    // Метод клика по кнопке Войти в аккаунт
    public MainPage clickEnterAccountButton() {
        driver.findElement(enterAccountButton).click();
        return this;
    }

    // Метод проверки отображения надписи Соберите бургер
    public boolean isSetBuggerTitleDisplayed() {
        return driver.findElement(setBuggerTitle).isDisplayed();
    }

    // Метод клика по указателю Булки
    public MainPage clickBunsPointer() {
        driver.findElement(bunsPointer).click();
        return this;
    }

    // Метод получения атрибута родителя указателя Булки
    public String getAttributeBunsPointerParent() {
        return driver.findElement(bunsPointerParent).getAttribute("class");
    }

    // Метод клика по указателю Соусы
    public MainPage clickSaucesPointer() {
        driver.findElement(saucesPointer).click();
        return this;
    }

    // Метод получения атрибута родителя указателя Соусы
    public String getAttributeSaucesPointerParent() {
        return driver.findElement(saucesPointerParent).getAttribute("class");
    }

    // Метод клика по указателю Начинки
    public MainPage clickFillingsPointer() {
        driver.findElement(saucesPointer).click();
        return this;
    }

    // Метод получения атрибута родителя указателя Начинки
    public String getAttributeFillingsPointerParent() {
        return driver.findElement(saucesPointerParent).getAttribute("class");
    }
}
