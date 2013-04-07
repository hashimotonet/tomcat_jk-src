package tomcat_jk.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tomcat_jk.beans.Customer;

public class RecordSet {
	List<Customer> list;
	
	public RecordSet() {
		list = Collections.synchronizedList(new LinkedList<Customer>());
	}
	
	public Iterator<Customer> iterator() {
		return this.list.iterator();
	}
	
	public void addCustomer(Customer customer) {
		this.list.add(customer);
	}
	
	public int size() {
		return this.list.size();
	}
	
	public List getList() {
		return this.list;
	}
	
	public String toString() {
		return list.toString();
	}
}
