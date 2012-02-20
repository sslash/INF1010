

public interface PriorityList {

	/**
	 * Returns the first element in the list,
	 * making the list a priority list (since the 
	 * list is sorted). The element that is returned is also
	 * to be removed from the list.
	 * 
	 * 
	 */
	public IfiPerson get();


	/**
	 * Insert IfiPerson in sorted order
	 * 
	 * @param p the new element to insert
	 */
	public void add(IfiPerson p);
	
	
	/**
	 * Get an IfiPerson with the given name.
	 * It should not delete this person from the list
	 * 
	 * @param name		of the person
	 * @return		The IFiPerson instance, null if not found
	 */
	public IfiPerson getByName(String name);
	
	
	/** 
	 * Return the list, as an array
	 * @return
	 */
	public IfiPerson [] toArray();
	
	
	/**
	 * Get the IfiPerson that has the lowest base priority
	 * 
	 * 
	 * @return
	 */
	public IfiPerson getNodeWithLowestBaseProperty();
}
