package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

/**
 * operdto DTO数据 
 * 
 */
public class MrfpOperDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 * @return String
	 */
	public String getId_opera() {
		return ((String) getAttrVal("Id_opera"));
	}	
	/**
	 * id
	 * @param Id_opera
	 */
	public void setId_opera(String Id_opera) {
		setAttrVal("Id_opera", Id_opera);
	}
	/**
	 * 手术操作编码
	 * @return String
	 */
	public String getCode_oper() {
		return ((String) getAttrVal("Code_oper"));
	}	
	/**
	 * 手术操作编码
	 * @param Code_oper
	 */
	public void setCode_oper(String Code_oper) {
		setAttrVal("Code_oper", Code_oper);
	}
	/**
	 * 手术及操作名称
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 手术及操作名称
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 术者名称
	 * @return String
	 */
	public String getName_shuzhe() {
		return ((String) getAttrVal("Name_shuzhe"));
	}	
	/**
	 * 术者名称
	 * @param Name_shuzhe
	 */
	public void setName_shuzhe(String Name_shuzhe) {
		setAttrVal("Name_shuzhe", Name_shuzhe);
	}
	/**
	 * 第一助手
	 * @return String
	 */
	public String getName_yizhu() {
		return ((String) getAttrVal("Name_yizhu"));
	}	
	/**
	 * 第一助手
	 * @param Name_yizhu
	 */
	public void setName_yizhu(String Name_yizhu) {
		setAttrVal("Name_yizhu", Name_yizhu);
	}
	/**
	 * 第二助手
	 * @return String
	 */
	public String getName_erzhu() {
		return ((String) getAttrVal("Name_erzhu"));
	}	
	/**
	 * 第二助手
	 * @param Name_erzhu
	 */
	public void setName_erzhu(String Name_erzhu) {
		setAttrVal("Name_erzhu", Name_erzhu);
	}
	/**
	 * 麻醉方法名称
	 * @return String
	 */
	public String getName_mazhufangfa() {
		return ((String) getAttrVal("Name_mazhufangfa"));
	}	
	/**
	 * 麻醉方法名称
	 * @param Name_mazhufangfa
	 */
	public void setName_mazhufangfa(String Name_mazhufangfa) {
		setAttrVal("Name_mazhufangfa", Name_mazhufangfa);
	}
	/**
	 * 麻醉医生
	 * @return String
	 */
	public String getNamemazuiyisheng() {
		return ((String) getAttrVal("Namemazuiyisheng"));
	}	
	/**
	 * 麻醉医生
	 * @param Namemazuiyisheng
	 */
	public void setNamemazuiyisheng(String Namemazuiyisheng) {
		setAttrVal("Namemazuiyisheng", Namemazuiyisheng);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getName_lvl() {
		return ((String) getAttrVal("Name_lvl"));
	}	
	/**
	 * 手术级别
	 * @param Name_lvl
	 */
	public void setName_lvl(String Name_lvl) {
		setAttrVal("Name_lvl", Name_lvl);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getCode_lvl() {
		return ((String) getAttrVal("Code_lvl"));
	}	
	/**
	 * 手术级别编码
	 * @param Code_lvl
	 */
	public void setCode_lvl(String Code_lvl) {
		setAttrVal("Code_lvl", Code_lvl);
	}
	/**
	 * 手术切口愈合等级编码
	 * @return String
	 */
	public String getCode_yuhejideng() {
		return ((String) getAttrVal("Code_yuhejideng"));
	}	
	/**
	 * 手术切口愈合等级编码
	 * @param Code_yuhejideng
	 */
	public void setCode_yuhejideng(String Code_yuhejideng) {
		setAttrVal("Code_yuhejideng", Code_yuhejideng);
	}
	/**
	 * 手术切口愈合等级
	 * @return String
	 */
	public String getName_yuhedengji() {
		return ((String) getAttrVal("Name_yuhedengji"));
	}	
	/**
	 * 手术切口愈合等级
	 * @param Name_yuhedengji
	 */
	public void setName_yuhedengji(String Name_yuhedengji) {
		setAttrVal("Name_yuhedengji", Name_yuhedengji);
	}
}