package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class SamsungTvVerification extends CommonMethods {

    @Test
    public void itemDescriptionVerification() {
        click(amazonPage.navigationMenu);
        CommonMethods.selectValueFromDropDown(amazonPage.menuList, "TV, Appliances, Electronics");
        CommonMethods.selectValueFromDropDown(amazonPage.tvAudioMenuList, "Televisions");
        click(amazonPage.samsungCheckBox);
        click(amazonPage.sortByBtn);
        CommonMethods.selectValueFromDropDown(amazonPage.sortByDropdownValuesList, "Price: High to Low");
        CommonMethods.selectSecondLargestValue(amazonPage.allPricesList);
        CommonMethods.switchToAnotherWindow();
        Assert.assertEquals(amazonPage.aboutItemText.getText(), "About this item");
        CommonMethods.extractTextFromItemDescription(amazonPage.textLinksList);
    }
}
