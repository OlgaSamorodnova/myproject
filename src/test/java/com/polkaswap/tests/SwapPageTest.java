package com.polkaswap.tests;


import com.polkaswap.pages.SwapPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


public class SwapPageTest extends TestBase {
    SwapPage swapPage = new SwapPage();

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


