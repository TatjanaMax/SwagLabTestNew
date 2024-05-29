package swag.lab.test.shopping_bag;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_object.checkout.PLPageObject;
import swag.lab.test.fun.CartFun;
import swag.lab.test.fun.LoginPageFun;
import swag.lab.test.fun.PDPFun;
import swag.lab.test.fun.PLPFun;
import swag.lab.test.utility.BeforeAll;

public class ShoppingBagTest extends BeforeAll {

        @Test
        public void shoppingBagTest() throws InterruptedException {

        //Valid Log In
        LoginPageFun.logInValidAccount(driver,wait);
        //Click on First Product from PLP
        PLPFun.clickOnFirst(driver,wait);
        //Get name of Product
            PDPFun.getNameOfProduct(driver,wait);
            Thread.sleep(2000);
            PDPFun.addProductToBag(driver,wait);
            CartFun.goToCart(driver,wait);
            CartFun.checkProductNameInCart(driver,wait);



            //Check Name

            
            Assert.assertEquals(PLPageObject.productName,PLPageObject.textProductCheck);







    }

}
