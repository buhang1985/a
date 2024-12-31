package iih.bd.pp.baseprisrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.baseprisrv.d.desc.PriSrvDODesc;
import java.math.BigDecimal;

/**
 * 基础价格服务 DO数据 
 * 
 */
public class PriSrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务主键标识
	public static final String ID_SRV= "Id_srv";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//服务类型
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//服务分类
	public static final String ID_SRVCA= "Id_srvca";
	//服务编码
	public static final String CODE= "Code";
	//服务名称
	public static final String NAME= "Name";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//简称
	public static final String SHORTNAME= "Shortname";
	//服务描述
	public static final String DES= "Des";
	//医学单位
	public static final String ID_UNIT_MED= "Id_unit_med";
	//定价模式
	public static final String ID_PRIMD= "Id_primd";
	//定价模式编码
	public static final String SD_PRIMD= "Sd_primd";
	//参考价格
	public static final String PRI= "Pri";
	//划价方式
	public static final String EU_BLMD= "Eu_blmd";
	//启用标识
	public static final String FG_ACTIVE= "Fg_active";
	//门诊账单项
	public static final String ID_INCCA_OP= "Id_incca_op";
	//住院账单项
	public static final String ID_INCCA_IP= "Id_incca_ip";
	//收费分类
	public static final String ID_PRITP= "Id_pritp";
	//收费分类编码
	public static final String SD_PRITP= "Sd_pritp";
	//门诊核算体系
	public static final String ID_ACC_OP= "Id_acc_op";
	//住院核算体系
	public static final String ID_ACC_IP= "Id_acc_ip";
	//共用核算体系
	public static final String ID_ACC_SHARE= "Id_acc_share";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//外部标准编码
	public static final String CODE_EXSTD= "Code_exstd";
	//收费依据
	public static final String CHARGE_BASIS= "Charge_basis";
	//客户扩展字段1
	public static final String DEF1= "Def1";
	//客户扩展字段2
	public static final String DEF2= "Def2";
	//客户扩展字段3
	public static final String DEF3= "Def3";
	//客户扩展字段4
	public static final String DEF4= "Def4";
	//客户扩展字段5
	public static final String DEF5= "Def5";
	//客户扩展字段6
	public static final String DEF6= "Def6";
	//客户扩展字段7
	public static final String DEF7= "Def7";
	//客户扩展字段8
	public static final String DEF8= "Def8";
	//客户扩展字段9
	public static final String DEF9= "Def9";
	//客户扩展字段10
	public static final String DEF10= "Def10";
	//服务类型名称
	public static final String NAME_SRVTP= "Name_srvtp";
	//服务分类名称
	public static final String NAME_SRVCA= "Name_srvca";
	//医学单位名称
	public static final String NAME_UNIT_MED= "Name_unit_med";
	//定价模式名称
	public static final String NAME_PRIMD= "Name_primd";
	//门诊票据项目名称
	public static final String NAME_INCCA_OP= "Name_incca_op";
	//住院票据项目名称
	public static final String NAME_INCCA_IP= "Name_incca_ip";
	//收费分类名称
	public static final String NAME_PRITP= "Name_pritp";
	//门诊核算项目名称
	public static final String NAME_ACC_OP= "Name_acc_op";
	//住院核算项目名称
	public static final String NAME_ACC_IP= "Name_acc_ip";
	//共用核算项目名称
	public static final String NAME_ACC_SHARE= "Name_acc_share";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务主键标识
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务主键标识
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 服务编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 服务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 服务描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 服务描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 医学单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	/**
	 * 医学单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 定价模式编码
	 * @return String
	 */
	public String getSd_primd() {
		return ((String) getAttrVal("Sd_primd"));
	}	
	/**
	 * 定价模式编码
	 * @param Sd_primd
	 */
	public void setSd_primd(String Sd_primd) {
		setAttrVal("Sd_primd", Sd_primd);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPri() {
		return ((FDouble) getAttrVal("Pri"));
	}	
	/**
	 * 参考价格
	 * @param Pri
	 */
	public void setPri(FDouble Pri) {
		setAttrVal("Pri", Pri);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}	
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 门诊账单项
	 * @return String
	 */
	public String getId_incca_op() {
		return ((String) getAttrVal("Id_incca_op"));
	}	
	/**
	 * 门诊账单项
	 * @param Id_incca_op
	 */
	public void setId_incca_op(String Id_incca_op) {
		setAttrVal("Id_incca_op", Id_incca_op);
	}
	/**
	 * 住院账单项
	 * @return String
	 */
	public String getId_incca_ip() {
		return ((String) getAttrVal("Id_incca_ip"));
	}	
	/**
	 * 住院账单项
	 * @param Id_incca_ip
	 */
	public void setId_incca_ip(String Id_incca_ip) {
		setAttrVal("Id_incca_ip", Id_incca_ip);
	}
	/**
	 * 收费分类
	 * @return String
	 */
	public String getId_pritp() {
		return ((String) getAttrVal("Id_pritp"));
	}	
	/**
	 * 收费分类
	 * @param Id_pritp
	 */
	public void setId_pritp(String Id_pritp) {
		setAttrVal("Id_pritp", Id_pritp);
	}
	/**
	 * 收费分类编码
	 * @return String
	 */
	public String getSd_pritp() {
		return ((String) getAttrVal("Sd_pritp"));
	}	
	/**
	 * 收费分类编码
	 * @param Sd_pritp
	 */
	public void setSd_pritp(String Sd_pritp) {
		setAttrVal("Sd_pritp", Sd_pritp);
	}
	/**
	 * 门诊核算体系
	 * @return String
	 */
	public String getId_acc_op() {
		return ((String) getAttrVal("Id_acc_op"));
	}	
	/**
	 * 门诊核算体系
	 * @param Id_acc_op
	 */
	public void setId_acc_op(String Id_acc_op) {
		setAttrVal("Id_acc_op", Id_acc_op);
	}
	/**
	 * 住院核算体系
	 * @return String
	 */
	public String getId_acc_ip() {
		return ((String) getAttrVal("Id_acc_ip"));
	}	
	/**
	 * 住院核算体系
	 * @param Id_acc_ip
	 */
	public void setId_acc_ip(String Id_acc_ip) {
		setAttrVal("Id_acc_ip", Id_acc_ip);
	}
	/**
	 * 共用核算体系
	 * @return String
	 */
	public String getId_acc_share() {
		return ((String) getAttrVal("Id_acc_share"));
	}	
	/**
	 * 共用核算体系
	 * @param Id_acc_share
	 */
	public void setId_acc_share(String Id_acc_share) {
		setAttrVal("Id_acc_share", Id_acc_share);
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
	 * 外部标准编码
	 * @return String
	 */
	public String getCode_exstd() {
		return ((String) getAttrVal("Code_exstd"));
	}	
	/**
	 * 外部标准编码
	 * @param Code_exstd
	 */
	public void setCode_exstd(String Code_exstd) {
		setAttrVal("Code_exstd", Code_exstd);
	}
	/**
	 * 收费依据
	 * @return String
	 */
	public String getCharge_basis() {
		return ((String) getAttrVal("Charge_basis"));
	}	
	/**
	 * 收费依据
	 * @param Charge_basis
	 */
	public void setCharge_basis(String Charge_basis) {
		setAttrVal("Charge_basis", Charge_basis);
	}
	/**
	 * 客户扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 客户扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 客户扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 客户扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户扩展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 客户扩展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户扩展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 客户扩展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户扩展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 客户扩展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户扩展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 客户扩展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	/**
	 * 服务类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getName_srvca() {
		return ((String) getAttrVal("Name_srvca"));
	}	
	/**
	 * 服务分类名称
	 * @param Name_srvca
	 */
	public void setName_srvca(String Name_srvca) {
		setAttrVal("Name_srvca", Name_srvca);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}	
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 定价模式名称
	 * @return String
	 */
	public String getName_primd() {
		return ((String) getAttrVal("Name_primd"));
	}	
	/**
	 * 定价模式名称
	 * @param Name_primd
	 */
	public void setName_primd(String Name_primd) {
		setAttrVal("Name_primd", Name_primd);
	}
	/**
	 * 门诊票据项目名称
	 * @return String
	 */
	public String getName_incca_op() {
		return ((String) getAttrVal("Name_incca_op"));
	}	
	/**
	 * 门诊票据项目名称
	 * @param Name_incca_op
	 */
	public void setName_incca_op(String Name_incca_op) {
		setAttrVal("Name_incca_op", Name_incca_op);
	}
	/**
	 * 住院票据项目名称
	 * @return String
	 */
	public String getName_incca_ip() {
		return ((String) getAttrVal("Name_incca_ip"));
	}	
	/**
	 * 住院票据项目名称
	 * @param Name_incca_ip
	 */
	public void setName_incca_ip(String Name_incca_ip) {
		setAttrVal("Name_incca_ip", Name_incca_ip);
	}
	/**
	 * 收费分类名称
	 * @return String
	 */
	public String getName_pritp() {
		return ((String) getAttrVal("Name_pritp"));
	}	
	/**
	 * 收费分类名称
	 * @param Name_pritp
	 */
	public void setName_pritp(String Name_pritp) {
		setAttrVal("Name_pritp", Name_pritp);
	}
	/**
	 * 门诊核算项目名称
	 * @return String
	 */
	public String getName_acc_op() {
		return ((String) getAttrVal("Name_acc_op"));
	}	
	/**
	 * 门诊核算项目名称
	 * @param Name_acc_op
	 */
	public void setName_acc_op(String Name_acc_op) {
		setAttrVal("Name_acc_op", Name_acc_op);
	}
	/**
	 * 住院核算项目名称
	 * @return String
	 */
	public String getName_acc_ip() {
		return ((String) getAttrVal("Name_acc_ip"));
	}	
	/**
	 * 住院核算项目名称
	 * @param Name_acc_ip
	 */
	public void setName_acc_ip(String Name_acc_ip) {
		setAttrVal("Name_acc_ip", Name_acc_ip);
	}
	/**
	 * 共用核算项目名称
	 * @return String
	 */
	public String getName_acc_share() {
		return ((String) getAttrVal("Name_acc_share"));
	}	
	/**
	 * 共用核算项目名称
	 * @param Name_acc_share
	 */
	public void setName_acc_share(String Name_acc_share) {
		setAttrVal("Name_acc_share", Name_acc_share);
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
		return "Id_srv";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PriSrvDODesc.class);
	}
	
}