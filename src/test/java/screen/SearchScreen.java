package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchScreen extends Phone {
    //Строка поиска
    @AndroidFindBy(id = "co.fun.testgiphy:id/etSearchToolbar")
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
        Thread.sleep(500);
        searchToolBar.setValue(text);
        driver.hideKeyboard();
    }

    public void clickOnSearch() {
        searchToolBar.click();
    }

    public Boolean checkKeyboardOpen() {
        try {
            driver.hideKeyboard();
        } catch (Exception ex) {
        }
        return true;

    }

    public void clearText() {
        searchToolBar.clear();
    }

    public void clickOnReturnButton() {
        returnButton.click();
    }

    public void clickOnImage(int index) {
        getElementFromList(index, "android.widget.ImageView").click();
    }

    public Boolean checkImage(int index) {
        return getElementFromList(index, "android.widget.ImageView").isDisplayed();
    }

    public void scrollDown() {
        verticalSwipeByPercentages(0.9, 0.35, 0.4);
    }
}
