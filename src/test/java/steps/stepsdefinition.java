package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Given("Открылся экран поиска")
    public void goToSearchScreen() throws Exception {
        mainScreen.login();
        Thread.sleep(6000);
        Assert.assertTrue(searchScreen.searchToolBarIsDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(searchScreen.upperBarIsDisplayed());
        Assert.assertTrue(searchScreen.mainFieldIsDisplayed());
    }

    @Given("Открыт экран поиска")
    public void checkSearchScreen() throws Exception {
        Assert.assertTrue(searchScreen.searchToolBarIsDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(searchScreen.upperBarIsDisplayed());
        Assert.assertTrue(searchScreen.mainFieldIsDisplayed());
    }

    @When("Я ввел пробел в поисковую строку")
    public void insertSpace() throws InterruptedException {
        searchScreen.sendTextSearch("      ");
    }

    @When("Я ввел значение <test> в поисковую строку")
    public void insertText() throws InterruptedException {
        searchScreen.sendTextSearch("test");
        searchScreen.clearText();
    }

    @When("Я ввел очень длинное значение в поисковую строку")
    public void insertLongText() throws InterruptedException {
        searchScreen.sendTextSearch("abcdefghijklmnopqrstuvwxyz");
    }

    @When("Я ввел спец символы в поисковую строку")
    public void insertSymbols() throws InterruptedException {
        searchScreen.sendTextSearch("----__)()");
    }

    @When("Я нажал на кнопку <Назад>")
    public void clickOnReturnButton() {
        searchScreen.clickOnReturnButton();
    }

    @When("Я нажал на аппаратную кнопку <Назад>")
    public void clickOnPhoneReturnButton() {
        driver.navigate().back();
    }

    @When("Я проверяю отображение элементов главного экрана")
    public void checkScreen() throws Exception {
        Thread.sleep(10000);
        mainScreen.searchButtonisDisplayed();
        Assert.assertTrue(mainScreen.upperBarisDisplayed());
        Assert.assertTrue(mainScreen.mainFieldisDisplayed());
        Assert.assertTrue(mainScreen.titleAppisDisplayed());
    }

    @Then("Нет результатов поиска")
    public void assertIsEmpty() {
        Assert.assertTrue(searchScreen.emptyResultField());
        searchScreen.clearText();
    }

    @Then("Произошел переход на главный экран")
    public void assertTransition() throws Exception {
        Thread.sleep(6000);
        mainScreen.searchButtonisDisplayed();
        Assert.assertTrue(mainScreen.upperBarisDisplayed());
        Assert.assertTrue(mainScreen.mainFieldisDisplayed());
        Assert.assertTrue(mainScreen.titleAppisDisplayed());
    }

}
