package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约事件源DTO DTO数据 
 * 
 */
public class MtApt4EsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
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
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 预约号
	 * @return String
	 */
	public String getAptcode() {
		return ((String) getAttrVal("Aptcode"));
	}
	/**
	 * 预约号
	 * @param Aptcode
	 */
	public void setAptcode(String Aptcode) {
		setAttrVal("Aptcode", Aptcode);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 服务id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 服务
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 预约事件编码
	 * @return String
	 */
	public String getCode_type_apt() {
		return ((String) getAttrVal("Code_type_apt"));
	}
	/**
	 * 预约事件编码
	 * @param Code_type_apt
	 */
	public void setCode_type_apt(String Code_type_apt) {
		setAttrVal("Code_type_apt", Code_type_apt);
	}
	/**
	 * 预约申请单id
	 * @return String
	 */
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}
	/**
	 * 预约申请单id
	 * @param Id_aptappl
	 */
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	/**
	 * 医嘱id集合
	 * @return FArrayList
	 */
	public FArrayList getIdors() {
		return ((FArrayList) getAttrVal("Idors"));
	}
	/**
	 * 医嘱id集合
	 * @param Idors
	 */
	public void setIdors(FArrayList Idors) {
		setAttrVal("Idors", Idors);
	}
}