package com.example.hackaton2024;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    String page_url = "https://hackthefuture.bignited.be/";

    public SelenideElement titleHackaton = $(By.tagName("h1"));
    public SelenideElement buttonGoToTransmission = $("#action-button");
}
