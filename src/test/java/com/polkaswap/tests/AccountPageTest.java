package com.polkaswap.tests;


import com.polkaswap.pages.AccountPage;
import com.polkaswap.pages.Disclaimer;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class AccountPageTest extends TestBase {
    AccountPage accountPage = new AccountPage();
    Disclaimer disclaimer = new Disclaimer();

    @Test
    @Tag("polkaswapAccountTest")
    @Story("Проверка начального состояния страницы Account")
    @Feature("Account tests")
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
    @Story("Проверка дисклеймера на странице Account")
    @Feature("Disclaimer tests")
    @DisplayName("Проверка отображения дисклеймера на странице Account")
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
