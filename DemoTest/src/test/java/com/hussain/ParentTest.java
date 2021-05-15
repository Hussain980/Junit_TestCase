package com.hussain;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ParentTest {

	@Test(timeout=1000)
	public void testSum() {
		assertEquals(2, new Parent().sum(1, 1));
	}

	// test case for private method
	
	@Test
	public void testMultiply() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = Parent.class.getDeclaredMethod("multiply", Integer.class, Integer.class);
		method.setAccessible(true);
		Parent parent = new Parent();
		int multi = (Integer) method.invoke(parent, 2, 2);
		assertEquals(4, multi);

	}

}
