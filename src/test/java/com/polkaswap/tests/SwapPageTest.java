package com.polkaswap.tests;


import com.polkaswap.pages.SwapPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


public class SwapPageTest extends TestBase {
    private final SwapPage swapPage = new SwapPage();

    @Test
    @Tag("polkaswapSwapTest")
    @Story("Проверка кастомизации страницы Swap")
    @Feature("Swap")
    @DisplayName("Проверка изменения внешнего вида страницы Swap при переключении ползунков кастомизации")
    void initialStateOfSwapPageCheck() {
        swapPage.openPage();
        swapPage.clickCustomizeSettings();
        swapPage.clickPriceChartSetting();
        swapPage.clickRouteSetting();
        swapPage.clickTransactionSetting();
        swapPage.checkPriceChartInvisible();
        swapPage.checkRouteInvisible();
        swapPage.checkTransactionsVisible();
    }
}


