package org.vamdc.dictionary;

import java.util.Collection;

/**
 * Interface of a Class for verifying relations between Requestable keywords. 
 *
 */
public interface RequestableLogic {

	/**
	 * Check if the keyword is present in the collection of askedKeys
	 * @param askedKeys collection of Requestable
	 * @param keyword keyword to check
	 * @return true if keyword is present in the askedKeys, enabled by any present keyword, or if askedKeys is empty. 
	 */
	public boolean isEnabled(Collection<Requestable> askedKeys,
			Requestable keyword);

	/**
	 * Clean up collection of keys, taking relations into account
	 * @param asked collection of Requestable
	 * @return new collection of Requestable, equivalent to input collection in terms of reaction to isEnabled();
	 */
	public Collection<Requestable> normalizeKeys(
			Collection<Requestable> asked);

	/**
	 * Enable a key in the asked collection
	 * @param asked collection where key should be enabled
	 * @param keyword Requestable to enable 
	 * @return new normalized collection with enabled keyword
	 */
	public Collection<Requestable> enableKey(
			Collection<Requestable> asked, Requestable keyword);

	/**
	 * Disable  a key in the asked collection
	 * @param asked collection where key should be disabled. Empty equals to all enabled.
	 * @param keyword Requestable to disable
	 * @return new normalized collection with the keyword disabled
	 */
	public Collection<Requestable> disableKey(
			Collection<Requestable> asked, Requestable keyword);
	
	/**
	 * Get logic child elements of the key
	 * @param key parent Requestable
	 * @return all child keywords
	 */
	public Collection<Requestable> getLogicChildren(Requestable key);

}