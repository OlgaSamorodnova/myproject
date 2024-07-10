package com.polkaswap;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.polkaswap.helpers.Attach;
import com.polkaswap.pages.ExplorePage;
import com.polkaswap.pages.Header;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;


public class ExplorePageTest {
    ExplorePage explorePage = new ExplorePage();
    Header header = new Header();

    @BeforeAll
    static void beforeAll() {
        System.out.println("#### Settings");
        Configuration.baseUrl = "https://polkaswap.io/#";
        Configuration.browserSize = "2560x2048";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @ValueSource(strings =  {
            "xor", "val", "pswap"
    })
    @ParameterizedTest(name = "При переключении ползунка 'Show only synthetic tokens' в результатах не отображается токен {0}")
    @Tag("polkaswapExploreTest")
    @Story("Списки токенов на странице Explore")
    @DisplayName("Проверяем, что фильтрация по синтетическим токенам работает")
    void noSyntheticsInSearchResults(String notSyntheticTokens) {
        step("Открываем страницу", () ->
                explorePage.openPage());
        step("Передвигаем ползунок 'Show only synthetic tokens'", () ->
                explorePage.clickSwitcher());
        step("Проверяем, что в результатах нет токена {}", () ->
                explorePage.noSyntheticsInSearchResults(notSyntheticTokens));
        step("Возвращаем ползунок 'Show only synthetic tokens' в начальное состояние", () ->
                explorePage.clickSwitcher());
    }

    @CsvFileSource(resources = "/test_data/SearchResultsShouldContainExpectedTokenName.csv")
    @ParameterizedTest(name = "При поиске по слову {0} выдает результат с текстом {1}")
    @Tag("polkaswapExploreTest")
    @Story("Списки токенов на странице Explore")
    @DisplayName("Проверяем работу поисковой строки")
    void searchResultsShouldContainExpectedTokenName(String searchQuery, String expectedToken) {
        step("Открываем страницу", () ->
                explorePage.openPage());
        step("Вводим поисковый запрос {0}", () ->
                explorePage.searchByQuery(searchQuery));
        step("Проверяем, что в результатах есть токен {1}", () ->
                explorePage.checkSearchResults(expectedToken));
    }
    @CsvSource({"English,Tokens",
            "Armenian,Նշաններ",
            "Dutch,Tokens",
            "French,Jetons"
    })
    @ParameterizedTest(name = "При установленном языке {0} текст заголовка - {1} ")
    @Tag("polkaswapExploreTest")
    @Story("Переводы")
    @DisplayName("Проверяем перевод заголовка при переключении языка")
    void checkTranslationOfHeader(String language, String expectedText) {
        step("Открываем страницу", () ->
                explorePage.openPage());
        step("Кликаем настройки", () ->
                explorePage.clickSettings());
        step("Выбираем пункт 'Изменить язык'", () ->
                explorePage.clickChangeLanguage());
        step("Выбираем язык {0}", () ->
                explorePage.chooseLanguage(language));
        step("Закрываем меню языков", () ->
                explorePage.closeLanguageList());
        step("Проверяем, что заголовок выбранного раздела - {1}", () ->
                explorePage.checkTranslationOfTokensHeader(expectedText));    }


    @Test
    @Tag("headerExploreTest")
    @Story("Header")
    @DisplayName("Проверяем, что header отображается верно")
    void checkHeaderExplorePage() {
        step("Открываем страницу", () ->
                explorePage.openPage());
        step("Проверяем наличие кнопки Купить токены", () ->
                header.checkBuyTokensButtonExists());
        step("Проверяем наличие кнопки карточки маркетинга", () ->
                header.checkMarketingCardExists());
        step("Проверяем наличие кнопки подключения аккаунта", () ->
                header.checkConnectAccountButtonExists());
        step("Проверяем наличие кнопки настроек", () ->
                header.checkSettingsButtonExists());}
}