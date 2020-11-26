package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchScreen extends Phone {
    //Строка поиска
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Search']")
    private MobileElement searchToolBar;

    //Верхнее поле
    @AndroidFindBy(id = "co.fun.testgiphy:id/tbFragmentSearch")
    private MobileElement upperBar;

    //Главное поле
    @AndroidFindBy(id = "co.fun.testgiphy:id/rvFragmentSearch")
    private MobileElement mainField;

    //Пустое поле
    @AndroidFindBy(id = "co.fun.testgiphy:id/tvEmptyListVH")
    private MobileElement emptyField;

    //Кнопка "Назад"
    @AndroidFindBy(className = "android.widget.ImageButton")
    private MobileElement returnButton;

    public SearchScreen(AppiumDriver driver) {
        super(driver);
    }

    public Boolean searchToolBarIsDisplayed() {
        return searchToolBar.isDisplayed();
    }

    public Boolean upperBarIsDisplayed() {
        return upperBar.isDisplayed();
    }

    public Boolean mainFieldIsDisplayed() {
        return mainField.isDisplayed();
    }

    public Boolean emptyResultField() {
        return emptyField.isDisplayed();
    }

    public void sendTextSearch(String text) throws InterruptedException {
        searchToolBar.click();
        Thread.sleep(2000);
        searchToolBar.setValue(text);
        driver.hideKeyboard();
    }

    public void clearText() {
        searchToolBar.clear();
    }

    public void clickOnReturnButton() {
        returnButton.click();
    }


}
