package com.example.hackaton2024;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    String page_url = "https://hackthefuture.bignited.be/";

    String name = "Herman";
    String age = "88";
    String species = "Undefined";
    String planet = "Planeet Patrick";

    public SelenideElement titleHackaton = $(By.tagName("h1"));
    public SelenideElement buttonGoToTransmission = $("#action-button");
    public SelenideElement body = $(By.tagName("body"));

    // page information
    public SelenideElement inputName = $("#name");
    public SelenideElement inputAge = $("#age");
    public SelenideElement selectSpecies = $("#species");
    public SelenideElement inputPlanet = $("#planet");
    public SelenideElement dataInput = $(By.className("typing"));

    public SelenideElement continueButton = $("#continue");

    // page collect-code
    public SelenideElement imgHerman = $(By.tagName("img"));


}
