package iih.ci.ord.i.base;

import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗单驱动信息
 * @author wangqingzhu
 *
 */
public class EmsDriverInfo extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 医疗单 ID
	 * 
	 * @return String
	 */
	public String getId_ems() {
		return ((String) getAttrVal("Id_ems"));
	}

	/**
	 * 医疗单 ID
	 * 
	 * @param Id_ems
	 */
	public void setId_ems(String Id_ems) {
		setAttrVal("Id_ems", Id_ems);
	}
	/**
	 * 医疗单 驱动
	 * 
	 * @return String
	 */
	public String getJsonDriver() {
		return ((String) getAttrVal("JsonDriver"));
	}

	/**
	 * 医疗单Dll
	 * 
	 * @param JsonDriver
	 */
	public void setJsonDriver(String JsonDriver) {
		setAttrVal("JsonDriver", JsonDriver);
	}
	
	/**
	 * 医疗单 模式
	 * 
	 * @return String
	 */
	public FBoolean getFg_quickwflow() {
		return ((FBoolean) getAttrVal("Fg_quickwflow"));
	}

	/**
	 * 医疗单 模式
	 * 
	 * @param Fg_quickwflow
	 */
	public void setFg_quickwflow(FBoolean Fg_quickwflow) {
		setAttrVal("Fg_quickwflow", Fg_quickwflow);
	}
	
	/**
	 * 医疗单前台驱动
	 * @return String
	 */
	public String getEmsFrontDriver() {
		return ((String) getAttrVal("EmsFrontDriver"));
	}
	/**
	 * 医疗单前台驱动
	 * @param EmsFrontDriver
	 */
	public void setEmsFrontDriver(String EmsFrontDriver) {
		setAttrVal("EmsFrontDriver", EmsFrontDriver);
	}
	
	/**
	 * 医疗单后台驱动
	 * 
	 * @return String
	 */
	public String getEmsBackendDriver() {
		return ((String) getAttrVal("EmsBackendDriver"));
	}

	/**
	 * 医疗单后台驱动
	 * 
	 * @param EmsBackendDriver
	 */
	public void setEmsBackendDriver(String EmsBackendDriver) {
		setAttrVal("EmsBackendDriver", EmsBackendDriver);
	}
	
	/**
	 * 医疗单Dll
	 * 
	 * @return String
	 */
	public String getDll() {
		return ((String) getAttrVal("Dll"));
	}

	/**
	 * 医疗单Dll
	 * 
	 * @param Dll
	 */
	public void setDll(String Dll) {
		setAttrVal("Dll", Dll);
	}
	
	/**
	 * 医疗单Dll
	 * 
	 * @return String
	 */
	public String getJar() {
		return ((String) getAttrVal("Jar"));
	}

	/**
	 * 医疗单Dll
	 * 
	 * @param Jar
	 */
	public void setJar(String Jar) {
		setAttrVal("Jar", Jar);
	}
}
