package org.vamdc.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRequestable {
	
	@Test
	public void testRequestableFromIgnoreCase(){
		Requestable key = Requestable.valueOfIgnoreCase("atOmS");
		assertEquals (key,Requestable.Atoms);
		System.out.println(key.name());
	}
}
