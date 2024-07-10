package com.polkaswap.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


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


    public SwapPage openPage() {
        open("/swap");
        return this;
    }

    public SwapPage clickCustomizeSettings() {
        customizePageSettings.click();
        return this;
    }

    public SwapPage clickPriceChartSetting() {
        priceChartSetting.click();
        return this;
    }

    public SwapPage clickRouteSetting() {
        routeSetting.click();
        return this;
    }

    public SwapPage clickTransactionSetting() {
        transactionsSetting.click();
        return this;
    }

    public SwapPage checkPriceChartInvisible() {
        priceChart.shouldNotBe(Condition.visible);
        return this;
    }

    public SwapPage checkRouteInvisible() {
        route.shouldNotBe(Condition.visible);
        return this;
    }

    public SwapPage checkTransactionsVisible() {
        transactions.shouldBe(Condition.visible);
        return this;
    }


}
