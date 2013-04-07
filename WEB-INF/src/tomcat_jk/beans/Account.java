/**
 * 
 */
package tomcat_jk.beans;

import java.io.Serializable;

/**
 * @author Osamu Hashimoto
 *
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 0L;

	/**
	 * 
	 */
	public Account() {}

	private String account_id;
	private String account_pwd;
	private Integer web_account_level;
	
	public String getAccount_id() {
		return account_id;
	}
	
	public void setAccount_id(String account_id) {
		this.account_id = account_id;
	}
	
	public String getAccount_pwd() {
		return account_pwd;
	}
	
	public void setAccount_pwd(String account_pwd) {
		this.account_pwd = account_pwd;
	}
	
	public Integer getWeb_account_level() {
		return web_account_level;
	}
	
	public void setWeb_account_level(Integer web_account_level) {
		this.web_account_level = web_account_level;
	}
}
