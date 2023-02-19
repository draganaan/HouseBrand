package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProviderTest
{
    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {
                {"username1"}, {"password1"},
                {"username2"}, {"password2"},
                {"username3"}, {"password3"}
        };
    }

    @Test (dataProvider = "data-provider")
    public void testLogin (String username, String password) {
        System.out.println("Passed Parameters Is : " + username + "and" + password);
    }
}

