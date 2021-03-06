package model;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 2 CONSTRUCTOR INVOCATION
 */
public class TestInvokeConstructors {

    @Test
    public void testInvokeConstructor() throws Exception {

        Assert.assertEquals(1, SimpleClass.class.getConstructors().length);

        // get constructor
        Constructor<SimpleClass> constructor = SimpleClass.class.getConstructor();
        // see getConstructors();
        // see getDeclaredConstructors();
        // see getDeclaredConstructor();

        // invoke constructor
        SimpleClass instance = constructor.newInstance();

        Assert.assertNotNull(instance);
        Assert.assertNull(instance.constructorField);

    }

    @Test
    public void testInvokePrivateConstructor() throws Exception {

        Assert.assertEquals(2, SimpleClass.class.getDeclaredConstructors().length); //////bravo mie


        // get constructor
        Constructor<SimpleClass> constructor = SimpleClass.class.getDeclaredConstructor(String.class);

        // make constructor accessible
        constructor.setAccessible(true);

        // invoke constructor
        SimpleClass instance = constructor.newInstance("some constructor set value");

        Assert.assertNotNull(instance);
        Assert.assertEquals("some constructor set value", instance.constructorField);

    }
}
