package testSuite;

import models.ParamEducation;
import models.ParamProduct;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import properties.TestSettings;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


public class TestRuns {

    TestSettings settings = new TestSettings();

    @BeforeEach
    public void testStart() {
        settings.start();
    }

    @DisplayName("1 Check the list in the drop-down submenu in \"WhoWeServe\"")
    @Test
    public void oneCheckWhoWeServeTest() {
        String [] checkItem = new String[]{"Students", "Instructors", "Book Authors", "Professionals",
                "Researchers", "Institutions", "Librarians", "Corporations", "Societies",
                "Journal Editors", /*"Bookstores",*/ "Government"}; // закоментирован раздел не указанный в ТЗ
        // тест продет успешно если раскоментировать Bookstores

        List<String> result = settings.getListWhoWeServe();

        assertThat(result, hasSize(11));
        assertThat(result, contains(checkItem));
    }

    @DisplayName("2 Checking the display of a scope with related content")
    @Test
    public void twoСheckSearchFunctionalityTest() {

        assertThat(settings.isDisplayedCheckarea("Java"), is(equalTo(true)));
    }

    @DisplayName("3 Сhecking found products")
    @Test
    public void threeСheckProductsTest(){
        List<ParamProduct> listProducts = settings.getProductList("Java");

        assertThat(listProducts, hasSize(10));
        for (ParamProduct paramProduct : listProducts) {
            assertThat(paramProduct.getName(), containsString("Java"));
            assertThat(paramProduct.getCoupleButton(), anyOf(hasEntry("PRINT", "ADD TO CART"),
                    hasEntry("E-BOOK", "ADD TO CART"),
                    hasEntry("O-BOOK", "VIEW ON WILEY ONLINE LIBRARY")/*,
                    hasEntry("PRINT", "Product not available\n" +
                    "for purchase")*/));
            // тест продет успешно если раскоментировать
            // закоментирован пара кнопок не указанный в ТЗ

        }
    }

    @DisplayName("4 checking the \"Education\" section")
    @Test
    public void fourEducationSection(){
        String [] checkItem = new String[]{"Information & Library Science", "Education & Public Policy",
                "K-12 General", "Higher Education General", "Vocational Technology",
                "Conflict Resolution & Mediation (School settings)", "Curriculum Tools- General",
                "Special Educational Needs", "Theory of Education", "Education Special Topics",
                "Educational Research & Statistics", "Literacy & Reading", "Classroom Management"};

        ParamEducation p = settings.testFour();

        assertThat(p.getIsHeaderVisible(), equalTo(true));
        assertThat(p.getListSubject(), hasSize(13));
        assertThat(p.getListSubject(), contains(checkItem));
    }

    @AfterEach
    public void testStop(){
        settings.stop();
    }
}