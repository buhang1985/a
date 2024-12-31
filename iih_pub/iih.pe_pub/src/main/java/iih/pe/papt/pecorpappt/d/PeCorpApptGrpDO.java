package iih.pe.papt.pecorpappt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pecorpappt.d.desc.PeCorpApptGrpDODesc;
import java.math.BigDecimal;

/**
 * 体检团体预约分组 DO数据 
 * 
 */
public class PeCorpApptGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//团体预约分组主键标识
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	//体检团体预约ID
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	//体检套餐ID
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	//分组名称
	public static final String NAME= "Name";
	//序号
	public static final String SORTNO= "Sortno";
	//性别限制
	public static final String SEXLIMIT= "Sexlimit";
	//婚否限制
	public static final String MARILIMIT= "Marilimit";
	//年龄开始
	public static final String AGE_BEGIN= "Age_begin";
	//年龄截止
	public static final String AGE_END= "Age_end";
	//分组价格
	public static final String PRI_GRP= "Pri_grp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//分组折扣
	public static final String DIS_GRP= "Dis_grp";
	//折后价格
	public static final String DIS_PRI_GRP= "Dis_pri_grp";
	//编码
	public static final String CODE_SET= "Code_set";
	//体检套餐名称
	public static final String NAME_SET= "Name_set";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 团体预约分组主键标识
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}	
	/**
	 * 团体预约分组主键标识
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	/**
	 * 体检团体预约ID
	 * @return String
	 */
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	/**
	 * 体检团体预约ID
	 * @param Id_pecorpappt
	 */
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	/**
	 * 体检套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	/**
	 * 体检套餐ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 分组名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 分组名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 性别限制
	 * @return Integer
	 */
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	/**
	 * 性别限制
	 * @param Sexlimit
	 */
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	/**
	 * 婚否限制
	 * @return Integer
	 */
	public Integer getMarilimit() {
		return ((Integer) getAttrVal("Marilimit"));
	}	
	/**
	 * 婚否限制
	 * @param Marilimit
	 */
	public void setMarilimit(Integer Marilimit) {
		setAttrVal("Marilimit", Marilimit);
	}
	/**
	 * 年龄开始
	 * @return Integer
	 */
	public Integer getAge_begin() {
		return ((Integer) getAttrVal("Age_begin"));
	}	
	/**
	 * 年龄开始
	 * @param Age_begin
	 */
	public void setAge_begin(Integer Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	/**
	 * 年龄截止
	 * @return Integer
	 */
	public Integer getAge_end() {
		return ((Integer) getAttrVal("Age_end"));
	}	
	/**
	 * 年龄截止
	 * @param Age_end
	 */
	public void setAge_end(Integer Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	/**
	 * 分组价格
	 * @return FDouble
	 */
	public FDouble getPri_grp() {
		return ((FDouble) getAttrVal("Pri_grp"));
	}	
	/**
	 * 分组价格
	 * @param Pri_grp
	 */
	public void setPri_grp(FDouble Pri_grp) {
		setAttrVal("Pri_grp", Pri_grp);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 分组折扣
	 * @return FDouble
	 */
	public FDouble getDis_grp() {
		return ((FDouble) getAttrVal("Dis_grp"));
	}	
	/**
	 * 分组折扣
	 * @param Dis_grp
	 */
	public void setDis_grp(FDouble Dis_grp) {
		setAttrVal("Dis_grp", Dis_grp);
	}
	/**
	 * 折后价格
	 * @return FDouble
	 */
	public FDouble getDis_pri_grp() {
		return ((FDouble) getAttrVal("Dis_pri_grp"));
	}	
	/**
	 * 折后价格
	 * @param Dis_pri_grp
	 */
	public void setDis_pri_grp(FDouble Dis_pri_grp) {
		setAttrVal("Dis_pri_grp", Dis_pri_grp);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	/**
	 * 编码
	 * @param Code_set
	 */
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	/**
	 * 体检套餐名称
	 * @return String
	 */
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}	
	/**
	 * 体检套餐名称
	 * @param Name_set
	 */
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
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
		return "Id_pecorpapptgrp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pecorpapptgrp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCorpApptGrpDODesc.class);
	}
	
}