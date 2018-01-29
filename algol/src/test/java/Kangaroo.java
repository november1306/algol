
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Math.abs;

public class Kangaroo {

    @DataProvider(name = "kangaroo")
    public static Object[][] kang() {
        return new Object[][]{
                //x1,v1,x2,v2
                 {0, 3, 4, 2, "YES"},
                 {0, 2, 0, 2, "NO"},
                 {14, 4,  98, 2, "YES"}

        };
    }


    @Test(dataProvider = "kangaroo")
    public void kangarooTest(int x1, int v1, int x2, int v2, String expectedResult) {
        Assert.assertEquals(kangaroo(x1, v1, x2, v2), expectedResult);
    }

    private String kangaroo(int x1, int v1, int x2, int v2) {
        String result = "NO";
        if (((x1 - x2) / (v2 - v1) > 0) && ((x1 - x2) % (v2 - v1) == 0)) {
            result = "YES";
        }

        return result;
    }

    @Test
    public void BreakingRecoedsTest () {
    }

    private int[] breakingRecords(int[] score) {

        for (int i: score) {

            
        }
        
        int[] times = new int[2]; 
        return times;
    }



}
