package com.polkaswap.tests;


import com.polkaswap.pages.ExplorePage;
import com.polkaswap.pages.Header;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ExplorePageTest extends TestBase {
    private final ExplorePage explorePage = new ExplorePage();
    private final Header header = new Header();

    @ValueSource(strings = {
            "xor", "val", "pswap"
    })
    @ParameterizedTest(name = "При переключении ползунка 'Show only synthetic tokens' в результатах не отображается токен {0}")
    @Tag("polkaswapExploreTest")
    @Story("Списки токенов на странице Explore")
    @Feature("Explore")
    @DisplayName("Проверяем, что фильтрация по синтетическим токенам работает")
    void noSyntheticsInSearchResults(String notSyntheticTokens) {
        explorePage.openPage();
        explorePage.clickSwitcher();
        Allure.step("Проверяем, что в результатах нет токена {}", () ->
                explorePage.noSyntheticsInSearchResults(notSyntheticTokens));
        explorePage.clickSwitcher();
    }

    @CsvFileSource(resources = "/test_data/SearchResultsShouldContainExpectedTokenName.csv")
    @ParameterizedTest(name = "При поиске по слову {0} выдает результат с текстом {1}")
    @Tag("polkaswapExploreTest")
    @Story("Списки токенов на странице Explore")
    @Feature("Explore")
    @DisplayName("Проверяем работу поисковой строки")
    void searchResultsShouldContainExpectedTokenName(String searchQuery, String expectedToken) {
        explorePage.openPage();
        Allure.step("Вводим поисковый запрос {0}", () -> explorePage.searchByQuery(searchQuery));
        Allure.step("Проверяем, что в результатах есть токен {1}", () -> explorePage.checkSearchResults(expectedToken));
    }

    @CsvSource({"English,Tokens",
            "Armenian,Նշաններ",
            "Dutch,Tokens",
            "French,Jetons"
    })
    @ParameterizedTest(name = "При установленном языке {0} текст заголовка - {1} ")
    @Tag("polkaswapExploreTest")
    @Story("Перевод страницы Explore")
    @Feature("Languages")
    @DisplayName("Проверяем перевод заголовка при переключении языка")
    void checkTranslationOfHeader(String language, String expectedText) {
        explorePage.openPage();
        explorePage.clickSettings();
        explorePage.clickChangeLanguage();
        Allure.step("Выбираем язык {0}", () -> explorePage.chooseLanguage(language));
        explorePage.closeLanguageList();
        Allure.step("Проверяем, что заголовок выбранного раздела - {1}", () -> explorePage.checkTranslationOfTokensHeader(expectedText));
    }

    @Test
    @Tag("headerExploreTest")
    @Story("Header на странице Explore")
    @Feature("Header")
    @DisplayName("Проверяем, что header на странице Explore отображается верно")
    void checkHeaderExplorePage() {
        explorePage.openPage();
        header.checkBuyTokensButtonExists();
        header.checkMarketingCardExists();
        header.checkConnectAccountButtonExists();
        header.checkSettingsButtonExists();
    }
}