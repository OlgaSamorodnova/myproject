package com.polkaswap.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class ExplorePage {

    SelenideElement
            syntheticsSwitcher = $(".el-switch__core"),
            tableContent = $(".el-table__body .el-table__row"),
            searchBar = $(".el-input__inner"),
            settingsButton = $(".el-dropdown-selfdefine"),
            changeLanguage = $(byClassName("header-menu__item")).sibling(1),
            languageList = $(byClassName("select-language-list")),
            crossSignInLanguagesList = $(".s-icon-x-16"),
            selectedPage = $(byId("tab-Explore/Tokens"));


    public ExplorePage openPage() {
        open("/explore/tokens");
        return this;
    }

    public ExplorePage clickSwitcher() {
        syntheticsSwitcher.click();
        return this;
    }

    public ExplorePage noSyntheticsInSearchResults(String notSyntheticTokens) {
        tableContent.shouldNotHave(text(notSyntheticTokens));
        return this;
    }

    public ExplorePage searchByQuery(String searchQuery) {
        searchBar.setValue(searchQuery);
        return this;
    }

    public ExplorePage checkSearchResults(String expectedToken) {
        tableContent.shouldHave(text(expectedToken));
        return this;
    }

    public ExplorePage clickSettings() {
        settingsButton.click();
        return this;
    }

    public ExplorePage clickChangeLanguage() {
        changeLanguage.click();
        return this;
    }

    public ExplorePage chooseLanguage(String language) {
        languageList.$(byText(language)).click();
        return this;
    }

    public ExplorePage closeLanguageList() {
        crossSignInLanguagesList.click();
        return this;
    }

    public ExplorePage checkTranslationOfTokensHeader(String expectedText) {
        selectedPage.shouldHave(text(expectedText));
        return this;
    }


}
