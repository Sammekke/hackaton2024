package com.example.hackaton2024;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.interactions.Actions;

import java.sql.Array;
import java.time.Duration;

import java.sql.Array;

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
        Thread.sleep(20000);
        // wereld bol klikken
        mainPage.body.click();
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();

        // naam en dergelijke invullen
        mainPage.inputName.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.inputName.type(mainPage.name);
        mainPage.inputAge.type(mainPage.age);
        mainPage.selectSpecies.selectOption(mainPage.species);
        mainPage.inputPlanet.type(mainPage.planet);
        mainPage.inputPlanet.pressEnter();

        mainPage.dataInput.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.dataInput.shouldHave(text(mainPage.name));
        mainPage.dataInput.shouldHave(text(mainPage.age));
        mainPage.dataInput.shouldHave(text(mainPage.species));
        mainPage.dataInput.shouldHave(text(mainPage.planet));
        mainPage.continueButton.should(Condition.visible, Duration.ofSeconds(50));
        mainPage.continueButton.click();

        mainPage.imgHerman.should(Condition.visible, Duration.ofSeconds(50));

        WebDriver driver = WebDriverRunner.getWebDriver();
        new Actions(driver).moveToElement(mainPage.imgHerman, 24, 78).click().build().perform();

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
        for (int i = 0; i <codeArray.length ; i++) {
            mainPage.getDigitKnop(String.valueOf(codeArray[i])).click();
        }
        mainPage.enterButton.click();
        Thread.sleep(10000);
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
