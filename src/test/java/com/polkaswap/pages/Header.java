package com.polkaswap.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;


public class Header {

    SelenideElement
            marketingCard = $(byClassName("marketing-card")),
            buyTokensButton = $(byClassName("app-controls-fiat-btn")),
            connectAccountButton = $(byClassName("account-control")),
            settingsButton = $(byClassName("settings-control"));


    public Header checkMarketingCardExists() {
        marketingCard.should(exist);
        return this;
    }

    public Header checkBuyTokensButtonExists() {
        buyTokensButton.should(exist);
        return this;
    }

    public Header checkConnectAccountButtonExists() {
        connectAccountButton.should(exist);
        return this;
    }

    public Header checkSettingsButtonExists() {
        settingsButton.should(exist);
        return this;
    }

}
