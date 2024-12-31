package iih.ci.ord.i.common;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.emsqry.d.EmsFunclassKVDTO;
import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗单驱动信息
 * 
 * @author wangqingzhu
 *
 */
public class EmsDriverInfo extends BaseXapJsonSerialization {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmsDriverInfo() {
	}

	public EmsDriverInfo(EmsFunclassKVDTO kv) {
		copyValues(kv);
	}

	public EmsDriverInfo(SrvMatchEmsRstDTO rst) throws BizException {

		this.setId_ems(rst.getId_ems());
		this.setFg_quickwflow(rst.getFg_quickwflow());
		this.setJsonDriver(rst.getFuncclassstr());
		this.copyValues(parseJsonDriver(rst.getFuncclassstr()));

	}

	private void copyValues(EmsFunclassKVDTO kv) {
		this.setDll(kv.getDll());
		this.setEmsFrontDriver(kv.getClasspath_dll());
		this.setJar(kv.getJar());
		this.setEmsBackendDriver(kv.getClasspath_jar());
		this.setTmpl_Classpath_jar(kv.getTmpl_Classpath_jar());
		this.setEu_execmode(kv.getEu_execmode());
	}

	/**
	 * 驱动信息转化为对象 @param jsonDriver @return @throws BizException @throws
	 */
	public EmsFunclassKVDTO parseJsonDriver(String jsonDriver) throws BizException {
		String utf8Str;
		try {
			utf8Str = new String(xap.mw.core.base64.Base64.decode(jsonDriver.getBytes("UTF-8")), "utf-8");
			EmsFunclassKVDTO funclassDTO = new EmsFunclassKVDTO();
			funclassDTO.deSerializeJson(utf8Str);
			return funclassDTO;
		} catch (UnsupportedEncodingException e) {
			throw new BizException(e.getMessage());
		}

	}
	
	public boolean isValid(){
		return (!StringUtils.isEmpty(getDll()))
				&& !StringUtils.isEmpty(getEmsFrontDriver())
				&& !StringUtils.isEmpty(getJar())
				&& !StringUtils.isEmpty(getEmsBackendDriver());
	}

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
	 * 
	 * @return String
	 */
	public String getEmsFrontDriver() {
		return ((String) getAttrVal("EmsFrontDriver"));
	}

	/**
	 * 医疗单前台驱动
	 * 
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

	/**
	 * 医疗单操作模式
	 * 
	 * @return
	 */
	public Integer getEu_execmode() {
		return ((Integer) getAttrVal("Eu_execmode"));
	}

	/**
	 * 医疗单操作模式
	 * 
	 * @param Eu_execmode
	 */
	public void setEu_execmode(Integer Eu_execmode) {
		setAttrVal("Eu_execmode", Eu_execmode);
	}

	/**
	 * 模版后台驱动
	 * 
	 * @return String
	 */
	public String getTmpl_Classpath_jar() {
		return ((String) getAttrVal("Tmpl_Classpath_jar"));
	}

	/**
	 * 模版后台驱动
	 * 
	 * @param Tmpl_Classpath_jar
	 */
	public void setTmpl_Classpath_jar(String Tmpl_Classpath_jar) {
		setAttrVal("Tmpl_Classpath_jar", Tmpl_Classpath_jar);
	}
}
