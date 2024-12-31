package iih.bd.fc.orpltp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.orpltp.d.desc.OrpltpStaDODesc;
import java.math.BigDecimal;

/**
 * 医嘱执行闭环类型状态 DO数据 
 * 
 */
public class OrpltpStaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱执行闭环类型状态ID
	public static final String ID_ORPLTPSTA= "Id_orpltpsta";
	//医嘱执行闭环类型ID
	public static final String ID_ORPLTP= "Id_orpltp";
	//序号
	public static final String SORTNO= "Sortno";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//状态编码
	public static final String CODE= "Code";
	//状态名称
	public static final String NAME= "Name";
	//上一级状态id
	public static final String ID_PRE= "Id_pre";
	//下一级状态id
	public static final String ID_NEXT= "Id_next";
	//医嘱本次执行可取消标志
	public static final String FG_CANCELABLE= "Fg_cancelable";
	//需患者参与标志
	public static final String FG_NEEDPAT= "Fg_needpat";
	//可退费标志
	public static final String FG_FEERTNABLE= "Fg_feertnable";
	//执行标识 
	public static final String FG_MP= "Fg_mp";
	//PDA执行标记
	public static final String FG_PDAMP= "Fg_pdamp";
	//正状态标识
	public static final String FG_FORWARD= "Fg_forward";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//系统标志
	public static final String FG_SYS= "Fg_sys";
	//是否更新
	public static final String FG_UPDATE= "Fg_update";
	//是否异常
	public static final String FG_ERROR= "Fg_error";
	//是否记账标志
	public static final String FG_CHARGE= "Fg_charge";
	//上级
	public static final String ID_PAR= "Id_par";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//PDA执行标记枚举
	public static final String EU_PDAMP= "Eu_pdamp";
	//关联关系
	public static final String ID_CL= "Id_cl";
	//医嘱执行闭环类型名称
	public static final String NAME_ORPLTP= "Name_orpltp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱执行闭环类型状态ID
	 * @return String
	 */
	public String getId_orpltpsta() {
		return ((String) getAttrVal("Id_orpltpsta"));
	}	
	/**
	 * 医嘱执行闭环类型状态ID
	 * @param Id_orpltpsta
	 */
	public void setId_orpltpsta(String Id_orpltpsta) {
		setAttrVal("Id_orpltpsta", Id_orpltpsta);
	}
	/**
	 * 医嘱执行闭环类型ID
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型ID
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
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
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 状态编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 状态名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 状态名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 上一级状态id
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}	
	/**
	 * 上一级状态id
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
	}
	/**
	 * 下一级状态id
	 * @return String
	 */
	public String getId_next() {
		return ((String) getAttrVal("Id_next"));
	}	
	/**
	 * 下一级状态id
	 * @param Id_next
	 */
	public void setId_next(String Id_next) {
		setAttrVal("Id_next", Id_next);
	}
	/**
	 * 医嘱本次执行可取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cancelable() {
		return ((FBoolean) getAttrVal("Fg_cancelable"));
	}	
	/**
	 * 医嘱本次执行可取消标志
	 * @param Fg_cancelable
	 */
	public void setFg_cancelable(FBoolean Fg_cancelable) {
		setAttrVal("Fg_cancelable", Fg_cancelable);
	}
	/**
	 * 需患者参与标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needpat() {
		return ((FBoolean) getAttrVal("Fg_needpat"));
	}	
	/**
	 * 需患者参与标志
	 * @param Fg_needpat
	 */
	public void setFg_needpat(FBoolean Fg_needpat) {
		setAttrVal("Fg_needpat", Fg_needpat);
	}
	/**
	 * 可退费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_feertnable() {
		return ((FBoolean) getAttrVal("Fg_feertnable"));
	}	
	/**
	 * 可退费标志
	 * @param Fg_feertnable
	 */
	public void setFg_feertnable(FBoolean Fg_feertnable) {
		setAttrVal("Fg_feertnable", Fg_feertnable);
	}
	/**
	 * 执行标识 
	 * @return FBoolean
	 */
	public FBoolean getFg_mp() {
		return ((FBoolean) getAttrVal("Fg_mp"));
	}	
	/**
	 * 执行标识 
	 * @param Fg_mp
	 */
	public void setFg_mp(FBoolean Fg_mp) {
		setAttrVal("Fg_mp", Fg_mp);
	}
	/**
	 * PDA执行标记
	 * @return FBoolean
	 */
	public FBoolean getFg_pdamp() {
		return ((FBoolean) getAttrVal("Fg_pdamp"));
	}	
	/**
	 * PDA执行标记
	 * @param Fg_pdamp
	 */
	public void setFg_pdamp(FBoolean Fg_pdamp) {
		setAttrVal("Fg_pdamp", Fg_pdamp);
	}
	/**
	 * 正状态标识
	 * @return FBoolean
	 */
	public FBoolean getFg_forward() {
		return ((FBoolean) getAttrVal("Fg_forward"));
	}	
	/**
	 * 正状态标识
	 * @param Fg_forward
	 */
	public void setFg_forward(FBoolean Fg_forward) {
		setAttrVal("Fg_forward", Fg_forward);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 系统标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	/**
	 * 系统标志
	 * @param Fg_sys
	 */
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
	}
	/**
	 * 是否更新
	 * @return FBoolean
	 */
	public FBoolean getFg_update() {
		return ((FBoolean) getAttrVal("Fg_update"));
	}	
	/**
	 * 是否更新
	 * @param Fg_update
	 */
	public void setFg_update(FBoolean Fg_update) {
		setAttrVal("Fg_update", Fg_update);
	}
	/**
	 * 是否异常
	 * @return FBoolean
	 */
	public FBoolean getFg_error() {
		return ((FBoolean) getAttrVal("Fg_error"));
	}	
	/**
	 * 是否异常
	 * @param Fg_error
	 */
	public void setFg_error(FBoolean Fg_error) {
		setAttrVal("Fg_error", Fg_error);
	}
	/**
	 * 是否记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}	
	/**
	 * 是否记账标志
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 上级
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 上级
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
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
	 * PDA执行标记枚举
	 * @return Integer
	 */
	public Integer getEu_pdamp() {
		return ((Integer) getAttrVal("Eu_pdamp"));
	}	
	/**
	 * PDA执行标记枚举
	 * @param Eu_pdamp
	 */
	public void setEu_pdamp(Integer Eu_pdamp) {
		setAttrVal("Eu_pdamp", Eu_pdamp);
	}
	/**
	 * 关联关系
	 * @return String
	 */
	public String getId_cl() {
		return ((String) getAttrVal("Id_cl"));
	}	
	/**
	 * 关联关系
	 * @param Id_cl
	 */
	public void setId_cl(String Id_cl) {
		setAttrVal("Id_cl", Id_cl);
	}
	/**
	 * 医嘱执行闭环类型名称
	 * @return String
	 */
	public String getName_orpltp() {
		return ((String) getAttrVal("Name_orpltp"));
	}	
	/**
	 * 医嘱执行闭环类型名称
	 * @param Name_orpltp
	 */
	public void setName_orpltp(String Name_orpltp) {
		setAttrVal("Name_orpltp", Name_orpltp);
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
		return "Id_orpltpsta";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_ORPLTPSTA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrpltpStaDODesc.class);
	}
	
}