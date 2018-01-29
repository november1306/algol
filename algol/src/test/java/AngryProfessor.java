import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
    https://docs.google.com/document/d/1cLQgFHuceNrjYODGKMRZ0gvwILPiwkqQSkxfrHKExPc/edit
 */

public class AngryProfessor {

    @DataProvider(name = "students")
    public static Object[][] stud() {
        return new Object[][]{
                {3, new int[]{-1, -3, 4, 2}, "YES"},
                {2, new int[]{0, -1, 2, 1}, "NO"}
        };
    }

    @Test(dataProvider = "students")
    public void test(int threshold, int[] timeArrival, String expectedResult) {
        Assert.assertEquals(angryProfessor(threshold, timeArrival), expectedResult);
    }


    private String angryProfessor(int k, int[] a) {
        String canceled = "NO";
        int inTime = 0;
        for (int i : a)
            if (i <= 0) inTime++;
        if (inTime < k)
            canceled = "YES";

        return canceled;
    }

}
