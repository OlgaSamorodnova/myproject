package com.polkaswap.tests;


import com.polkaswap.pages.AccountPage;
import com.polkaswap.pages.Disclaimer;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class AccountPageTest extends TestBase {
    private final AccountPage accountPage = new AccountPage();
    private final Disclaimer disclaimer = new Disclaimer();

    @Test
    @Tag("polkaswapAccountTest")
    @Story("Проверка начального состояния страницы Account")
    @Feature("Account tests")
    @DisplayName("Проверка состояния страницы без авторизации и установленных расширений")
    void initialStateOfAccountPageCheck() {
        accountPage.openPage();
        accountPage.checkAccountControlTitle();
        accountPage.checkWalletConnectionText();
        Allure.step("Проверяем наличие кнопок расширений", () -> {
            accountPage.checkGoogleButton();
            accountPage.checkFearlessButton();
            accountPage.checkPolkadotButton();
            accountPage.checkSubWalletButton();
            accountPage.checkTalismanButton();
        });
        Allure.step("Проверяем работу кнопки Learn More", () -> {
            accountPage.pressLearnMoreButton();
            accountPage.checkAboutText();
        });

    }

    @Test
    @Tag("polkaswapDisclaimerTest")
    @Story("Проверка дисклеймера на странице Account")
    @Feature("Disclaimer tests")
    @DisplayName("Проверка отображения дисклеймера на странице Account")
    void disclaimerCheck() {
        accountPage.openPage();
        disclaimer.checkDisclaimerExists();
        disclaimer.checkDisclaimerHeader();
        disclaimer.checkAcceptBtnIsDisabled();
        disclaimer.scrollToBottom();
        disclaimer.checkAcceptBtnIsEnabled();
        disclaimer.pressAcceptBtn();
        disclaimer.checkDisclaimerNotExist();
        disclaimer.refreshPage();
        disclaimer.checkDisclaimerNotExist();
    }
}
