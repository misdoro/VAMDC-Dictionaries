package org.vamdc.dictionary;

/**
 * Interface for Restrictable and Requestable enum dictionary
 * 
 */
public interface Keyword {
	/**
	 * @return the keyword name, as defined in the standards dictionary
	 */
	public String name();
	/**
	 * @return a short description of the keyword
	 */
	public String getInfo();
	/**
	 * @return Full description of the keyword
	 */
	public String getDescription();
	/**
	 * @return standard units, as they should be used in the Restrictable keyword.
	 */
	public String getUnits();
	/**
	 * 
	 * @return one of the DataType enum (Integer,Double, String), corresponding to the keyword datatype
	 */
	public DataType getDataType();
	
}
