package com.polkaswap;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.polkaswap.helpers.Attach;
import com.polkaswap.pages.SwapPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class SwapPageTest {
    SwapPage swapPage = new SwapPage();

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Settings");
        Configuration.baseUrl = "https://polkaswap.io/#";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }


    @Test
    @Tag("polkaswapSwapTest")
    @Story("Проверка начального состояния страницы")
    @DisplayName("Проверка состояния страницы без авторизации и установленных расширений")
    void initialStateOfAccountPageCheck() {
        Allure.step("Открываем страницу", () ->
                swapPage.openPage());
        Allure.step("Открываем настройки кастомизации страницы", () ->
                swapPage.clickCustomizeSettings());
        Allure.step("Двигаем ползунок Price Chart", () ->
                swapPage.clickPriceChartSetting());
        Allure.step("Двигаем ползунок Route", () ->
                swapPage.clickRouteSetting());
        Allure.step("Двигаем ползунок Transactions", () ->
                swapPage.clickTransactionSetting());
        Allure.step("Проверяем, что Price Chart не показывается на странице", () ->
                swapPage.checkPriceChartInvisible());
        Allure.step("Проверяем, что Route не показывается на странице", () ->
                swapPage.checkRouteInvisible());
        Allure.step("Проверяем, что Transactions показывается на странице", () ->
                swapPage.checkTransactionsVisible());
    }
}


