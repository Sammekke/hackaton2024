package com.example.hackaton2024;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.*;
import com.sun.tools.javac.Main;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;
import java.sql.Array;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open(mainPage.page_url);
    }

    @Test
    public void fullTestRun() throws InterruptedException {
        mainPage.titleHackaton.shouldHave(text("Hackathon \n 2024"));
        mainPage.buttonGoToTransmission.click();
        Thread.sleep(5000);
        // wereld bol klikken
        mainPage.body.click();
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();

        // naam en dergelijke invullen
        mainPage.inputName.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.inputName.sendKeys(mainPage.name);
        mainPage.inputAge.sendKeys(mainPage.age);
        mainPage.selectSpecies.selectOption(mainPage.species);
        mainPage.inputPlanet.sendKeys(mainPage.planet);
        mainPage.inputPlanet.pressEnter();

        mainPage.dataInput.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.dataInput.shouldHave(text(mainPage.name));
        mainPage.dataInput.shouldHave(text(mainPage.age));
        mainPage.dataInput.shouldHave(text(mainPage.species));
        mainPage.dataInput.shouldHave(text(mainPage.planet));
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();

        mainPage.imgHerman.should(Condition.visible, Duration.ofSeconds(50));

        Selenide.actions().moveToElement(mainPage.imgHerman, 24, 78).click().build().perform();

        String code = localStorage().getItem("code");
        System.out.println(code);
        mainPage.body.click();
        mainPage.buttonContinue.click();
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();
        mainPage.buttonNumpad.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.buttonNumpad.click();
        Thread.sleep(2000);
        char[] codeArray = code.toCharArray();
        for (int i = 0; i < codeArray.length; i++) {
            mainPage.getDigitKnop(String.valueOf(codeArray[i])).click();
        }
        mainPage.enterButton.click();
        Thread.sleep(2000);
        mainPage.body.sendKeys(Keys.ARROW_UP);
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();
        mainPage.inputFieldName.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.inputFieldName.sendKeys(mainPage.name + Keys.ENTER);
        //lie question is weg
        Thread.sleep(1000);
        mainPage.inputFieldName.sendKeys(mainPage.planet + Keys.ENTER);
        mainPage.yesHelpButton.pressEnter();
        Thread.sleep(1000);
        mainPage.yesHelpButton.pressEnter();
        Thread.sleep(1000);
        mainPage.button.pressEnter();
        Thread.sleep(1000);
        mainPage.button.pressEnter();
        Thread.sleep(1000);
        mainPage.button.pressEnter();
        Thread.sleep(1000);
        mainPage.yesHelpButton.pressEnter();
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();
        Thread.sleep(1000);
        mainPage.floatingDink.click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        Actions actions = new Actions(driver);
        actions.clickAndHold(mainPage.scanButton).pause(7000).release().build().perform();
        mainPage.continueButton.click();
        Thread.sleep(1000);
        String currentDigits = mainPage.currentdigits.getText();
        String wantedDigits = mainPage.wanteddigits.getText();
        char[] currentArray = currentDigits.toCharArray();
        char[] wantedArray = wantedDigits.toCharArray();
        for (int i = 0; i < currentArray.length; i++) {
            int total = (int) currentArray[i] - (int) wantedArray[i];
            if (total < 0) {
                for (int j = 0; j < Math.abs(total); j++) {
                    System.out.println("up");
                    mainPage.getUpKnop(i).click();
                }
            }
            if (total>0){
                for (int j = 0; j < Math.abs(total); j++) {
                    System.out.println("down");
                    mainPage.getDownKnop(i).click();
                }
            }
        }
        mainPage.body.pressEnter();
        Thread.sleep(10000);
    }

    private void offsetCalculationAndClickElement(SelenideElement element) {
        int offsety = (element.getRect().height / 2) + 24;
        int offsetx = (element.getRect().width / 2) + 12;
        System.out.println("height " + offsety + "width: " + offsetx);
        element.click(ClickOptions.withOffset(offsety, offsetx));
    }

    @Test
    public void shouldHaveCorrectTitle() {
        mainPage.titleHackaton.shouldHave(text("Hackathon \n 2024"));
    }

    @Test
    public void shouldClickButtonToTransmission() {
        mainPage.buttonGoToTransmission.click();
    }

    @Test
    public void shouldInputCorrectValues() throws InterruptedException {
        open(mainPage.page_url + "information");

        mainPage.inputName.type(mainPage.name);
        mainPage.inputAge.type(mainPage.age);
        mainPage.selectSpecies.selectOption(mainPage.species);
        mainPage.inputPlanet.type(mainPage.planet);
        mainPage.inputPlanet.pressEnter();

        Thread.sleep(1000);
        mainPage.dataInput.shouldHave(text(mainPage.name));
        mainPage.dataInput.shouldHave(text(mainPage.age));
        mainPage.dataInput.shouldHave(text(mainPage.species));
        mainPage.dataInput.shouldHave(text(mainPage.planet));
        Thread.sleep(1000);
    }

    @Test
    public void shouldClickGlobe() throws InterruptedException {
        mainPage.buttonGoToTransmission.click();
        Thread.sleep(20000);
        mainPage.body.click();
        Thread.sleep(10000);
    }

    @Test
    public void shouldClickOnYellowCard() throws InterruptedException {
        open(mainPage.page_url + "collect-code");

        WebDriver driver = WebDriverRunner.getWebDriver();
        new Actions(driver).moveToElement(mainPage.imgHerman, 24, 78).click().build().perform();

        String code = localStorage().getItem("code");
        System.out.println(code);
        Thread.sleep(2000);

        mainPage.divCard.click();
        Thread.sleep(2000);

        mainPage.buttonContinue.click();
        Thread.sleep(10000000);

        mainPage.buttonNumpad.click();
        Thread.sleep(10000000);
    }
}
