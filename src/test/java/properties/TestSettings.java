package properties;

import models.ParamEducation;
import models.ParamProduct;
import pages.*;

import java.util.List;

public class TestSettings extends TestBegin {

    private StartPage page;
    private MainHeader header;
    private Search search;

    public List<String> getListWhoWeServe(){
        page = new StartPage(driver);
        header = new MainHeader(driver);

        page.goMainPage();
        page.closeModalContent();

        return header.getSubmenuWhoWeServe();
    }

    public boolean isDisplayedCheckarea(String word){
        page = new StartPage(driver);
        search = new Search(driver);

        page.goMainPage();
        page.closeModalContent();

        return search.enterWord(word);
    }

    public List<ParamProduct> getProductList(String word){
        page = new StartPage(driver);
        search = new Search(driver);
        Product product = new Product(driver);

        page.goMainPage();
        page.closeModalContent();

        search.enterWordAndPressButton(word);

        return product.getProductModel();
    }

    public ParamEducation testFour(){
        page = new StartPage(driver);
        header = new MainHeader(driver);
        Education education = new Education(driver);

        page.goMainPage();
        page.closeModalContent();

        header.clickEducationSection();

        return education.getEducationModel();
    }

}
