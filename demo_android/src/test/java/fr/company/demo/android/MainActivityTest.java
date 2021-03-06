package fr.company.demo.android;



import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import fr.company.demo.android.activity.MainActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldHaveHappySmiles() throws Exception {
        String appName = new MainActivity().getResources().getString(R.string.app_name);
        assertThat (appName, not(equalTo("MyActivity")));
    }
}