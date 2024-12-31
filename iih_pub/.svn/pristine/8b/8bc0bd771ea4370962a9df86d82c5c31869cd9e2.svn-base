package iih.ems.eass.emshift.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.eass.emshift.d.desc.EmsEmShiftItmDODesc;
import java.math.BigDecimal;

/**
 * 保管变更细目 DO数据 
 * 
 */
public class EmsEmShiftItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//变更细目主键
	public static final String ID_SFTITM= "Id_sftitm";
	//变更单主键
	public static final String ID_SFT= "Id_sft";
	//卡片流水号
	public static final String ID_CARD= "Id_card";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//卡片名称
	public static final String CARD_NAME= "Card_name";
	//设备基本信息主键
	public static final String ID_EM= "Id_em";
	//原保管等级
	public static final String ID_LEVEL_OLD= "Id_level_old";
	//原保管科室
	public static final String ID_DEPT_OLD= "Id_dept_old";
	//原保管人
	public static final String ID_EMP_OLD= "Id_emp_old";
	//原领用日期
	public static final String DT_GET_OLD= "Dt_get_old";
	//是否含有附件
	public static final String FG_ANNEX= "Fg_annex";
	//是否是设备附件
	public static final String FG_PART= "Fg_part";
	//设备附件对应的主设备
	public static final String ID_PARENT_CARD= "Id_parent_card";
	//备注
	public static final String REMARK= "Remark";
	//原保管等级编码
	public static final String SD_LEVEL_OLD= "Sd_level_old";
	//原使用科室
	public static final String ID_STOR_OLD= "Id_stor_old";
	//设备编码
	public static final String CODE_EM= "Code_em";
	//设备名称
	public static final String NAME_EM= "Name_em";
	//名称
	public static final String NAME_LEVEL_OLD= "Name_level_old";
	//名称
	public static final String NAME_DEPT_OLD= "Name_dept_old";
	//姓名
	public static final String NAME_EMP_OLD= "Name_emp_old";
	//卡片编号
	public static final String CARD_NO_PARENT= "Card_no_parent";
	//卡片名称
	public static final String NAME_PARENT= "Name_parent";
	//名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 变更细目主键
	 * @return String
	 */
	public String getId_sftitm() {
		return ((String) getAttrVal("Id_sftitm"));
	}	
	/**
	 * 变更细目主键
	 * @param Id_sftitm
	 */
	public void setId_sftitm(String Id_sftitm) {
		setAttrVal("Id_sftitm", Id_sftitm);
	}
	/**
	 * 变更单主键
	 * @return String
	 */
	public String getId_sft() {
		return ((String) getAttrVal("Id_sft"));
	}	
	/**
	 * 变更单主键
	 * @param Id_sft
	 */
	public void setId_sft(String Id_sft) {
		setAttrVal("Id_sft", Id_sft);
	}
	/**
	 * 卡片流水号
	 * @return String
	 */
	public String getId_card() {
		return ((String) getAttrVal("Id_card"));
	}	
	/**
	 * 卡片流水号
	 * @param Id_card
	 */
	public void setId_card(String Id_card) {
		setAttrVal("Id_card", Id_card);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getCard_name() {
		return ((String) getAttrVal("Card_name"));
	}	
	/**
	 * 卡片名称
	 * @param Card_name
	 */
	public void setCard_name(String Card_name) {
		setAttrVal("Card_name", Card_name);
	}
	/**
	 * 设备基本信息主键
	 * @return String
	 */
	public String getId_em() {
		return ((String) getAttrVal("Id_em"));
	}	
	/**
	 * 设备基本信息主键
	 * @param Id_em
	 */
	public void setId_em(String Id_em) {
		setAttrVal("Id_em", Id_em);
	}
	/**
	 * 原保管等级
	 * @return String
	 */
	public String getId_level_old() {
		return ((String) getAttrVal("Id_level_old"));
	}	
	/**
	 * 原保管等级
	 * @param Id_level_old
	 */
	public void setId_level_old(String Id_level_old) {
		setAttrVal("Id_level_old", Id_level_old);
	}
	/**
	 * 原保管科室
	 * @return String
	 */
	public String getId_dept_old() {
		return ((String) getAttrVal("Id_dept_old"));
	}	
	/**
	 * 原保管科室
	 * @param Id_dept_old
	 */
	public void setId_dept_old(String Id_dept_old) {
		setAttrVal("Id_dept_old", Id_dept_old);
	}
	/**
	 * 原保管人
	 * @return String
	 */
	public String getId_emp_old() {
		return ((String) getAttrVal("Id_emp_old"));
	}	
	/**
	 * 原保管人
	 * @param Id_emp_old
	 */
	public void setId_emp_old(String Id_emp_old) {
		setAttrVal("Id_emp_old", Id_emp_old);
	}
	/**
	 * 原领用日期
	 * @return FDate
	 */
	public FDate getDt_get_old() {
		return ((FDate) getAttrVal("Dt_get_old"));
	}	
	/**
	 * 原领用日期
	 * @param Dt_get_old
	 */
	public void setDt_get_old(FDate Dt_get_old) {
		setAttrVal("Dt_get_old", Dt_get_old);
	}
	/**
	 * 是否含有附件
	 * @return FBoolean
	 */
	public FBoolean getFg_annex() {
		return ((FBoolean) getAttrVal("Fg_annex"));
	}	
	/**
	 * 是否含有附件
	 * @param Fg_annex
	 */
	public void setFg_annex(FBoolean Fg_annex) {
		setAttrVal("Fg_annex", Fg_annex);
	}
	/**
	 * 是否是设备附件
	 * @return FBoolean
	 */
	public FBoolean getFg_part() {
		return ((FBoolean) getAttrVal("Fg_part"));
	}	
	/**
	 * 是否是设备附件
	 * @param Fg_part
	 */
	public void setFg_part(FBoolean Fg_part) {
		setAttrVal("Fg_part", Fg_part);
	}
	/**
	 * 设备附件对应的主设备
	 * @return String
	 */
	public String getId_parent_card() {
		return ((String) getAttrVal("Id_parent_card"));
	}	
	/**
	 * 设备附件对应的主设备
	 * @param Id_parent_card
	 */
	public void setId_parent_card(String Id_parent_card) {
		setAttrVal("Id_parent_card", Id_parent_card);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 原保管等级编码
	 * @return String
	 */
	public String getSd_level_old() {
		return ((String) getAttrVal("Sd_level_old"));
	}	
	/**
	 * 原保管等级编码
	 * @param Sd_level_old
	 */
	public void setSd_level_old(String Sd_level_old) {
		setAttrVal("Sd_level_old", Sd_level_old);
	}
	/**
	 * 原使用科室
	 * @return String
	 */
	public String getId_stor_old() {
		return ((String) getAttrVal("Id_stor_old"));
	}	
	/**
	 * 原使用科室
	 * @param Id_stor_old
	 */
	public void setId_stor_old(String Id_stor_old) {
		setAttrVal("Id_stor_old", Id_stor_old);
	}
	/**
	 * 设备编码
	 * @return String
	 */
	public String getCode_em() {
		return ((String) getAttrVal("Code_em"));
	}	
	/**
	 * 设备编码
	 * @param Code_em
	 */
	public void setCode_em(String Code_em) {
		setAttrVal("Code_em", Code_em);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	public String getName_em() {
		return ((String) getAttrVal("Name_em"));
	}	
	/**
	 * 设备名称
	 * @param Name_em
	 */
	public void setName_em(String Name_em) {
		setAttrVal("Name_em", Name_em);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_level_old() {
		return ((String) getAttrVal("Name_level_old"));
	}	
	/**
	 * 名称
	 * @param Name_level_old
	 */
	public void setName_level_old(String Name_level_old) {
		setAttrVal("Name_level_old", Name_level_old);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept_old() {
		return ((String) getAttrVal("Name_dept_old"));
	}	
	/**
	 * 名称
	 * @param Name_dept_old
	 */
	public void setName_dept_old(String Name_dept_old) {
		setAttrVal("Name_dept_old", Name_dept_old);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_old() {
		return ((String) getAttrVal("Name_emp_old"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_old
	 */
	public void setName_emp_old(String Name_emp_old) {
		setAttrVal("Name_emp_old", Name_emp_old);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no_parent() {
		return ((String) getAttrVal("Card_no_parent"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no_parent
	 */
	public void setCard_no_parent(String Card_no_parent) {
		setAttrVal("Card_no_parent", Card_no_parent);
	}
	/**
	 * 卡片名称
	 * @return String
	 */
	public String getName_parent() {
		return ((String) getAttrVal("Name_parent"));
	}	
	/**
	 * 卡片名称
	 * @param Name_parent
	 */
	public void setName_parent(String Name_parent) {
		setAttrVal("Name_parent", Name_parent);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_sftitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_sft_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsEmShiftItmDODesc.class);
	}
	
}