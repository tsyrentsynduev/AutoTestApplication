package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainScreen extends Phone {
    //Кнопка "Поиск"
    @AndroidFindBy(id = "co.fun.testgiphy:id/menu_trending_search")
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

    private void clickOnSearch() {
        searchButton.click();
    }

    public void login() throws Exception {
        clickOnSearch();
    }
}
