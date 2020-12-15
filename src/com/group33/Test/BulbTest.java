package com.group33.Test;

/**
 * Creat Junit test and test if the Bulb number is correct
 */

import com.group33.models.trafficlight.Bulb;
import com.group33.models.trafficlight.Light;
import org.junit.Assert;
import org.junit.Test;
public class BulbTest {
    @Test
    public void checkBulbTest(){

        Bulb[] lights = new Light().getLights();
        int length = lights.length;
        Assert.assertEquals(3,length);

    }

}
