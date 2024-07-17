package com.polkaswap.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Disclaimer {

    SelenideElement
            disclaimerArea = $(byClassName("disclaimer")),
            disclaimerHeaderTitle = $(byClassName("disclaimer__header-title")),
            acceptBtn = $(byClassName("disclaimer__accept-btn")),
            lastDisclaimerWord = $(byClassName("disclaimer__text-fiat"));
    @Step("Проверяем, что дисклеймер отображается")
    public Disclaimer checkDisclaimerExists() {
        new WebDriverWait(getWebDriver(), Duration.ofSeconds(40)).until(ExpectedConditions.visibilityOf(disclaimerArea));
        disclaimerArea.should(exist);
        return this;
    }
    @Step("Проверяем заголовок дисклеймера")
    public Disclaimer checkDisclaimerHeader() {
        disclaimerHeaderTitle.shouldHave(text("Disclaimer"));
        return this;
    }
    @Step("Проверяем, что кнопка неактивна")
    public Disclaimer checkAcceptBtnIsDisabled() {
        acceptBtn.shouldBe(disabled);
        return this;
    }
    @Step("Скроллим до конца")
    public Disclaimer scrollToBottom() {
        actions().click(disclaimerHeaderTitle);
        lastDisclaimerWord.scrollIntoView(true);
        return this;
    }
    @Step("Проверяем, что кнопка активна")
    public Disclaimer checkAcceptBtnIsEnabled() {
        acceptBtn.shouldBe(enabled);
        return this;
    }
    @Step("Нажимаем кнопку")
    public Disclaimer pressAcceptBtn() {
        acceptBtn.click();
        return this;
    }
    @Step("Проверяем, что дисклеймер не отображается")
    public Disclaimer checkDisclaimerNotExist() {
        disclaimerArea.shouldNot(exist);
        return this;
    }
    @Step("Обновляем страницу")
    public Disclaimer refreshPage() {
        Selenide.refresh();
        return this;
    }

}
