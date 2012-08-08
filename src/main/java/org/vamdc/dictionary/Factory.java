package org.vamdc.dictionary;

import org.vamdc.dictionary.requestableLogic.*;

public class Factory {

	public static RequestableLogic getRequestableLogic(){
		return new RequestableLogicImpl();
	}
	
}
