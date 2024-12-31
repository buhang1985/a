package iih.ci.mi.ord.i.meta;

import xap.mw.core.data.BaseDTO;

/**
 * 前后台医保数据交互对象，医嘱服务项目信息
 * @author HUMS
 *
 */
public class OrdSrvMiRstDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 *医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	
	/**
	 * 医保目录ID
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录ID
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	
	/**
	 * 医保目录SD
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录SD
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	
	/**
	 * 医保目录名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保目录名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 医嘱医保判断方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		return ((String) getAttrVal("Eu_hpjudge"));
	}
	/**
	 * 医嘱医保判断方式
	 * @param Eu_orhp
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	/**
	 * 服务项目医保判断结果
	 * @return String
	 */
	public String getEu_orsrvhp() {
		return ((String) getAttrVal("Eu_orsrvhp"));
	}
	/**
	 * 服务项目医保判断结果
	 * @param Eu_orsrvhp
	 */
	public void setEu_orsrvhp(String Eu_orsrvhp) {
		setAttrVal("Eu_orsrvhp", Eu_orsrvhp);
	}
}
