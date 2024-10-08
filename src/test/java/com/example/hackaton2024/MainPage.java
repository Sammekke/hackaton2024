package com.example.hackaton2024;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    String page_url = "https://hackthefuture.bignited.be/";

    String name = "Herman";
    String age = "88";
    String species = "Undefined";
    String planet = "Planeet Patrick";

    public SelenideElement titleHackaton = $(By.tagName("h1"));
    public SelenideElement buttonGoToTransmission = $("#action-button");
    public SelenideElement body = $(By.tagName("body"));
    public SelenideElement button = $(By.tagName("button"));

    // page information
    public SelenideElement inputName = $("#name");
    public SelenideElement inputAge = $("#age");
    public SelenideElement selectSpecies = $("#species");
    public SelenideElement inputPlanet = $("#planet");
    public SelenideElement dataInput = $(By.className("typing"));

    public SelenideElement continueButton = $("#continue");

    // page collect-code
    public SelenideElement imgHerman = $(By.tagName("img"));
    public SelenideElement divCard = $(By.className("card"));

    //page gate
    public SelenideElement buttonContinue = $(By.className("ski-button"));
    public SelenideElement buttonNumpad = $(By.id("numpad"));

    public SelenideElement getDigitKnop(String digit) {
        return $(By.id(digit));
    }

    public SelenideElement enterButton = $(By.id("enter"));
    public SelenideElement inputFieldName = $(By.id("inputField"));
    public SelenideElement yesLieButton = $(By.cssSelector("p > :nth-child(0)"));
    public SelenideElement yesHelpButton = $(By.cssSelector(".buttons > :nth-child(1)"));
    public SelenideElement scanButton = $(By.cssSelector(".scan-button"));
    public SelenideElement floatingDink = $(By.cssSelector(".floating-cube"));
    public SelenideElement currentdigits = $(By.cssSelector("#current-reading"));
    public SelenideElement wanteddigits = $(By.cssSelector("#wanted-reading"));

    public SelenideElement getUpKnop(int index) {
        int newIndex = index +1;
        return $(By.cssSelector(":nth-child("+newIndex+") > .container-up > .arrow > .material-symbols-outlined"));
    }

    public SelenideElement getDownKnop(int index) {
        int newIndex = index +1;
        return $(By.cssSelector(":nth-child("+newIndex+") > .down > .material-symbols-outlined"));
    }

}
