package ru.yandex.practicum.burgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.yandex.practicum.burgers.pages.MainPage;

public class ConstructorTest extends BaseTest {

    // Тест 1: Переход к разделу Булки

    @Test
    @DisplayName("Check transit to buns section") // имя теста
    @Description("Basic test for constructor on the main page")
    public void checkTransitToBuns() {

        String bunsParentAttribute =
                new MainPage(driver)
                .openMainPage()
                .clickSaucesPointer()
                .clickBunsPointer()
                .getAttributeBunsPointerParent();
        boolean isAttributeContainsCurrent = bunsParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел:", isAttributeContainsCurrent);
    }

    // Тест 2: Переход к разделу Соусы

    @Test
    @DisplayName("Check transit to sauces section") // имя теста
    @Description("Basic test for constructor on the main page")
    public void checkTransitToSauces() {

        String saucesParentAttribute =
                new MainPage(driver)
                        .openMainPage()
                        .clickSaucesPointer()
                        .getAttributeSaucesPointerParent();
        boolean isAttributeContainsCurrent = saucesParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел:", isAttributeContainsCurrent);
    }

    // Тест 3: Переход к разделу Начинки

    @Test
    @DisplayName("Check transit to fillings section") // имя теста
    @Description("Basic test for constructor on the main page")
    public void checkTransitToFillings() {

        String fillingsParentAttribute =
                new MainPage(driver)
                        .openMainPage()
                        .clickFillingsPointer()
                        .getAttributeFillingsPointerParent();
        boolean isAttributeContainsCurrent = fillingsParentAttribute.contains("current");
        Assert.assertTrue("Переход к разделу не произошел:", isAttributeContainsCurrent);
    }
}
