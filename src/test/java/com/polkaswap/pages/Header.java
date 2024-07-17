package com.polkaswap.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;


public class Header {

    SelenideElement
            marketingCard = $(byClassName("marketing-card")),
            buyTokensButton = $(byClassName("app-controls-fiat-btn")),
            connectAccountButton = $(byClassName("account-control")),
            settingsButton = $(byClassName("settings-control"));

    @Step("Проверяем наличие кнопки карточки маркетинга")
    public Header checkMarketingCardExists() {
        marketingCard.should(exist);
        return this;
    }
    @Step("Проверяем наличие кнопки Купить токены")
    public Header checkBuyTokensButtonExists() {
        buyTokensButton.should(exist);
        return this;
    }
    @Step("Проверяем наличие кнопки подключения аккаунта")
    public Header checkConnectAccountButtonExists() {
        connectAccountButton.should(exist);
        return this;
    }
    @Step("Проверяем наличие кнопки настроек")
    public Header checkSettingsButtonExists() {
        settingsButton.should(exist);
        return this;
    }

}
