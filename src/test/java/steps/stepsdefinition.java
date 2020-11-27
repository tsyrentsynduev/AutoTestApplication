package steps;

import io.appium.java_client.appmanagement.ApplicationState;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import test.GifAppTest;

public class stepsdefinition extends GifAppTest {
    @Before
    public void initialisation() throws Exception {
        GifAppTest.beforeStart();
    }

    @After
    public void tearDown() throws Exception {
        stopAppium();
    }

    @Given("Открылось приложение")
    public void openApplication() throws Exception {
        setUp();
    }

    @When("Проверить отображение элементов домашнего экрана")
    public void checkScreen() {
        mainScreen.searchButtonisDisplayed();
        Assert.assertTrue(mainScreen.upperBarisDisplayed());
        Assert.assertTrue(mainScreen.mainFieldisDisplayed());
        Assert.assertTrue(mainScreen.titleAppisDisplayed());
    }

    @And("Нажать на гифку - проверить, что мы остались на домашнем экране")
    public void clickOnGifAndCheckHScreen() {
        mainScreen.clickOnImage(0);
        mainScreen.searchButtonisDisplayed();
        Assert.assertTrue(mainScreen.upperBarisDisplayed());
        Assert.assertTrue(mainScreen.mainFieldisDisplayed());
        Assert.assertTrue(mainScreen.titleAppisDisplayed());
    }

    @And("Прокрутить домашний экран вниз - проверить, что подгружаются новые гифки")
    public void swipeDownHScreenCheckGif() {
        mainScreen.scrollDown();
        Assert.assertTrue(mainScreen.checkImage(0));
        Assert.assertTrue(mainScreen.checkImage(1));
    }

    @Given("Нажать на поиск - проверить отображение элементов на экране поиска")
    public void goToSearchScreen() throws Exception {
        mainScreen.clickOnSearch();
        Thread.sleep(500);
        Assert.assertTrue(searchScreen.searchToolBarIsDisplayed());
        Assert.assertTrue(searchScreen.upperBarIsDisplayed());
        Assert.assertTrue(searchScreen.mainFieldIsDisplayed());
    }

    @When("Выполнить поиск по пробелам")
    public void insertSpace() throws InterruptedException {
        searchScreen.sendTextSearch("      ");
    }

    @When("Выполнить поиск по значению test")
    public void insertText() throws InterruptedException {
        searchScreen.sendTextSearch("test");
        searchScreen.clearText();
    }

    @Then("В результатах поиска отображаются гифки")
    public void checkImageAfterSearch() {
        Assert.assertTrue(mainScreen.checkImage(0));
        Assert.assertTrue(mainScreen.checkImage(1));
    }

    @And("Прокрутить экран поиска вниз - проверить, что подгружаются новые гифки")
    public void swipeDownSScreenCheckGif() {
        searchScreen.scrollDown();
        Assert.assertTrue(searchScreen.checkImage(0));
        Assert.assertTrue(searchScreen.checkImage(1));
    }

    @And("Нажать на гифку - проверить, что мы остались на экране поиска")
    public void clickOnGifAndCheckSScreen() {
        searchScreen.clickOnImage(0);
        Assert.assertTrue(searchScreen.searchToolBarIsDisplayed());
        Assert.assertTrue(searchScreen.upperBarIsDisplayed());
        Assert.assertTrue(searchScreen.mainFieldIsDisplayed());
    }

    @When("Выполнить поиск по очень длинному значению")
    public void insertLongText() throws InterruptedException {
        searchScreen.sendTextSearch("abcdefghijklmnopqrstuvwxyz");
    }

    @When("Выполнить поиск по спец символам")
    public void insertSymbols() throws InterruptedException {
        searchScreen.sendTextSearch("----__)()");
    }

    @Given("Кликнуть на поле ввода в строке поиска - проверить отображение клавиатуры")
    public void clickOnSearchAndCheckKeyboard() {
        searchScreen.clickOnSearch();
        Assert.assertTrue(searchScreen.checkKeyboardOpen());
    }

    @When("Нажать на экране поиска кнопку <Назад> в шапке")
    public void clickOnReturnButton() {
        searchScreen.clickOnReturnButton();
    }

    @Then("Проверить, что мы вернулись на домашний экран")
    public void assertTransition() throws Exception {
        Thread.sleep(500);
        mainScreen.searchButtonisDisplayed();
        Assert.assertTrue(mainScreen.upperBarisDisplayed());
        Assert.assertTrue(mainScreen.mainFieldisDisplayed());
        Assert.assertTrue(mainScreen.titleAppisDisplayed());
    }

    @When("Нажать на аппаратную кнопку <Назад>")
    public void clickOnPhoneReturnButton() {
        driver.navigate().back();
    }

    @Then("Нет результатов поиска")
    public void assertIsEmpty() {
        Assert.assertTrue(searchScreen.emptyResultField());
        searchScreen.clearText();
    }

    @Then("Проверить, что приложение закрылось")
    public void checkAppisClosed() {
        ApplicationState state = driver.queryAppState("co.fun.testgiphy");
        Assert.assertEquals(state, ApplicationState.RUNNING_IN_FOREGROUND);
    }

}
