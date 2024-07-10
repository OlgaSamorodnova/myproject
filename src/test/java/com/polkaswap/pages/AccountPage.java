package com.polkaswap.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class AccountPage {

    SelenideElement
            accountControlTitle = $(byClassName("account-control-title")),
            walletConnectionText = $(byClassName("wallet-connection-text")),
            connectionList = $(byClassName("wallet-connection")),
            learnMorebtn = $(byClassName("learn-more-btn")),
            textInAboutDialog = $(byText("Polkaswap is built on top of the SORA Network, and the SORA token (XOR) is used for gas/fees and liquidity provision on Polkaswap. SORA Network allows for reduced fees, faster transactions and simpler consensus finalization and is focused on delivering interoperability across other blockchain ecosystems like Ethereum."));

    public AccountPage openPage() {
        open("/wallet");
        return this;
    }

    public AccountPage checkAccountControlTitle() {
        accountControlTitle.shouldHave(text("Connect account"));
        return this;
    }

    public AccountPage checkWalletConnectionText() {
        walletConnectionText.shouldHave(text("In order to manage assets and sign transactions on SORA, an account must be connected. SORA accounts can be created and connected using our integrated wallets or browser extensions."));
        return this;
    }

    public AccountPage checkGooglebutton() {
        connectionList.shouldHave(text("Google"));
        return this;
    }

    public AccountPage checkFearlessbutton() {
        connectionList.shouldHave(text("Fearless Wallet"));
        return this;
    }

    public AccountPage checkPolkadotbutton() {
        connectionList.shouldHave(text("Polkadot{.js}"));
        return this;
    }

    public AccountPage checkSubWalletbutton() {
        connectionList.shouldHave(text("SubWallet"));
        return this;
    }

    public AccountPage checkTalismanbutton() {
        connectionList.shouldHave(text("Talisman"));
        return this;
    }

    public AccountPage pressLearnMoreBtn() {
        learnMorebtn.click();
        return this;
    }

    public AccountPage checkAboutText() {
        textInAboutDialog.exists();
        return this;
    }

}
