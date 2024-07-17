package com.polkaswap.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SwapPage {


    SelenideElement
            customizePageSettings = $(byText("Customize page")),
            priceChartSetting = $(byClassName("customise-options")).$(byText("Price chart")),
            routeSetting = $(byClassName("customise-options")).$(byText("Route")),
            transactionsSetting = $(byClassName("customise-options")).$(byText("Transactions")),
            priceChart = $(byClassName("swap-chart-widget")),
            route = $(byClassName("distribution")),
            transactions = $(byClassName("swap-transactions-widget"));
    @Step("Открываем страницу")
    public SwapPage openPage() {
        open("#/swap");
        return this;
    }
    @Step("Открываем настройки кастомизации страницы")
    public SwapPage clickCustomizeSettings() {
        customizePageSettings.click();
        return this;
    }
    @Step("Двигаем ползунок Price Chart")
    public SwapPage clickPriceChartSetting() {
        priceChartSetting.click();
        return this;
    }
    @Step("Двигаем ползунок Route")
    public SwapPage clickRouteSetting() {
        routeSetting.click();
        return this;
    }
    @Step("Двигаем ползунок Transactions")
    public SwapPage clickTransactionSetting() {
        transactionsSetting.click();
        return this;
    }
    @Step("Проверяем, что Price Chart не показывается на странице")
    public SwapPage checkPriceChartInvisible() {
        priceChart.shouldNotBe(Condition.visible);
        return this;
    }
    @Step("Проверяем, что Route не показывается на странице")
    public SwapPage checkRouteInvisible() {
        route.shouldNotBe(Condition.visible);
        return this;
    }
    @Step("Проверяем, что Transactions показывается на странице")
    public SwapPage checkTransactionsVisible() {
        transactions.shouldBe(Condition.visible);
        return this;
    }

}
