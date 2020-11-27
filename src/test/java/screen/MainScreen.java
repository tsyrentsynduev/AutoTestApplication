package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainScreen extends Phone {
    //Кнопка "Поиск"
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Search\"]")
    private MobileElement searchButton;
    //Верхняя строка
    @AndroidFindBy(id = "co.fun.testgiphy:id/tbFragmentTrending")
    private MobileElement upperBar;
    //Главное поле
    @AndroidFindBy(id = "co.fun.testgiphy:id/rvFragmentTrending")
    private MobileElement mainField;
    //Название приложения
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Giphy']")
    private MobileElement titleApp;

    public MainScreen(AppiumDriver driver) {
        super(driver);
    }

    public Boolean searchButtonisDisplayed() {
        return searchButton.isDisplayed();
    }

    public Boolean upperBarisDisplayed() {
        return upperBar.isDisplayed();
    }

    public Boolean mainFieldisDisplayed() {
        return mainField.isDisplayed();
    }

    public Boolean titleAppisDisplayed() {
        return titleApp.isDisplayed();
    }

    public void clickOnSearch() {
        searchButton.click();
    }

    public void scrollDown() {
        verticalSwipeByPercentages(0.9, 0.35, 0.4);
    }

    public void clickOnImage(int index) {
        getElementFromList(index, "android.widget.ImageView").click();
    }

    public Boolean checkImage(int index) {
        return getElementFromList(index, "android.widget.ImageView").isDisplayed();
    }
}
