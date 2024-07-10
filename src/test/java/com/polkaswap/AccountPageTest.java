package com.polkaswap;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.polkaswap.helpers.Attach;
import com.polkaswap.pages.AccountPage;
import com.polkaswap.pages.Disclaimer;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class AccountPageTest {
    AccountPage accountPage = new AccountPage();
    Disclaimer disclaimer = new Disclaimer();

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
    @Tag("polkaswapAccountTest")
    @Story("Проверка начального состояния страницы")
    @DisplayName("Проверка состояния страницы без авторизации и установленных расширений")
    void initialStateOfAccountPageCheck() {
        Allure.step("Открываем страницу", () ->
                accountPage.openPage());
        Allure.step("Проверяем название кнопки Connect Account", () ->
                accountPage.checkAccountControlTitle());
        Allure.step("Проверяем текст на странице", () ->
                accountPage.checkWalletConnectionText());
        Allure.step("Проверяем наличие кнопки Google", () ->
                accountPage.checkGooglebutton());
        Allure.step("Проверяем наличие кнопки Google", () ->
                accountPage.checkGooglebutton());
        Allure.step("Проверяем наличие кнопок расширений", () -> {
            accountPage.checkGooglebutton();
            accountPage.checkFearlessbutton();
            accountPage.checkPolkadotbutton();
            accountPage.checkSubWalletbutton();
            accountPage.checkTalismanbutton();
        });
        Allure.step("Проверяем работу кнопки Learn More", () -> {
            accountPage.pressLearnMoreBtn();
            accountPage.checkAboutText();
        });

    }


    @Test
    @Tag("polkaswapDisclaimerTest")
    @Story("Проверка дисклеймера")
    @DisplayName("Проверка отображения дисклеймера и работы кнопки")
    void disclaimerCheck() {
        Allure.step("Открываем страницу", () ->
                accountPage.openPage());
        Allure.step("Проверяем, что дисклеймер отображается", () ->
                disclaimer.checkDisclaimerExists());
        Allure.step("Проверяем, что кнопка неактивна", () ->
                disclaimer.checkDisclaimerHeader());
        Allure.step("Проверяем, что кнопка неактивна", () ->
                disclaimer.checkAcceptBtnIsDisabled());
        Allure.step("Скроллим до конца", () ->
                disclaimer.scrollToBottom());
        Allure.step("Проверяем, что кнопка активна", () ->
                disclaimer.checkAcceptBtnIsEnabled());
        Allure.step("Нажимаем кнопку", () ->
                disclaimer.pressAcceptBtn());
        Allure.step("Проверяем, что дисклеймер не отображается", () ->
                disclaimer.checkDisclaimerNotExist());
        Allure.step("Обновляем страницу", () ->
                disclaimer.refreshPage());
        Allure.step("Проверяем, что дисклеймер не отображается", () ->
                disclaimer.checkDisclaimerNotExist());
    }


}
