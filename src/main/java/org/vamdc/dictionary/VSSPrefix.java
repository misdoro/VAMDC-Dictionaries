package org.vamdc.dictionary;

/**
 * Prefixes valid in VSS2, some of them may have trailing digit
 *
 */
public enum VSSPrefix {

	UPPER(false),
	LOWER(false),
	REACTANT(true),
	PRODUCT(true),
	TARGET(false),
	COLLIDER(false),
	
	;
	
	private boolean hasIndex;
	
	VSSPrefix(boolean hasIndex){
		this.hasIndex=hasIndex;
	}
	
	/**
	 * @return true if prefix must have an index attached to it.
	 */
	public boolean hasIndex(){
		return hasIndex;
	}
	
}
