package com.example.hackaton2024;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

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
}
