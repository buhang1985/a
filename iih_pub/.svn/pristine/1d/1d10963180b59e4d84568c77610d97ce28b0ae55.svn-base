package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvVtDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务生命体征属性 DO数据 
 * 
 */
public class MedSrvVtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务生命体征属性主键标识
	public static final String ID_SRVVT= "Id_srvvt";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
	//公共数据元
	public static final String ID_DE= "Id_de";
	//数据类型
	public static final String ID_DEDATATP= "Id_dedatatp";
	//数据类型编码
	public static final String SD_DEDATATP= "Sd_dedatatp";
	//数据元值域编码
	public static final String VALDOMAINCODE= "Valdomaincode";
	//最大值
	public static final String DEVALMAX= "Devalmax";
	//最小值
	public static final String DEVALMIN= "Devalmin";
	//单位
	public static final String ID_UNIT= "Id_unit";
	//启用部位
	public static final String FG_POS= "Fg_pos";
	//部位分类
	public static final String ID_VT_POS_CA= "Id_vt_pos_ca";
	//部位分类编码
	public static final String SD_VT_POS_CA= "Sd_vt_pos_ca";
	//默认部位
	public static final String ID_VT_POS_DEF= "Id_vt_pos_def";
	//默认部位编码
	public static final String SD_VT_POS_DEF= "Sd_vt_pos_def";
	//启用辅助措施
	public static final String FG_AUX= "Fg_aux";
	//辅助措施分类
	public static final String ID_VT_AUX_CA= "Id_vt_aux_ca";
	//辅助措施分类编码
	public static final String SD_VT_AUX_CA= "Sd_vt_aux_ca";
	//值个数
	public static final String VALCOUNT= "Valcount";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//服务编码
	public static final String SRV_CODE= "Srv_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//公共数据元名称
	public static final String NAME_DE= "Name_de";
	//名称
	public static final String NAME_DEDATATP= "Name_dedatatp";
	//计量单位名称
	public static final String NAME_UNIT_VT= "Name_unit_vt";
	//名称
	public static final String NAME_VT_POS_CA= "Name_vt_pos_ca";
	//名称
	public static final String NAME_VT_POS_DEF= "Name_vt_pos_def";
	//名称
	public static final String NAME_VT_AUX_CA= "Name_vt_aux_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务生命体征属性主键标识
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}	
	/**
	 * 服务生命体征属性主键标识
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 公共数据元
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 公共数据元
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getId_dedatatp() {
		return ((String) getAttrVal("Id_dedatatp"));
	}	
	/**
	 * 数据类型
	 * @param Id_dedatatp
	 */
	public void setId_dedatatp(String Id_dedatatp) {
		setAttrVal("Id_dedatatp", Id_dedatatp);
	}
	/**
	 * 数据类型编码
	 * @return String
	 */
	public String getSd_dedatatp() {
		return ((String) getAttrVal("Sd_dedatatp"));
	}	
	/**
	 * 数据类型编码
	 * @param Sd_dedatatp
	 */
	public void setSd_dedatatp(String Sd_dedatatp) {
		setAttrVal("Sd_dedatatp", Sd_dedatatp);
	}
	/**
	 * 数据元值域编码
	 * @return String
	 */
	public String getValdomaincode() {
		return ((String) getAttrVal("Valdomaincode"));
	}	
	/**
	 * 数据元值域编码
	 * @param Valdomaincode
	 */
	public void setValdomaincode(String Valdomaincode) {
		setAttrVal("Valdomaincode", Valdomaincode);
	}
	/**
	 * 最大值
	 * @return FDouble
	 */
	public FDouble getDevalmax() {
		return ((FDouble) getAttrVal("Devalmax"));
	}	
	/**
	 * 最大值
	 * @param Devalmax
	 */
	public void setDevalmax(FDouble Devalmax) {
		setAttrVal("Devalmax", Devalmax);
	}
	/**
	 * 最小值
	 * @return FDouble
	 */
	public FDouble getDevalmin() {
		return ((FDouble) getAttrVal("Devalmin"));
	}	
	/**
	 * 最小值
	 * @param Devalmin
	 */
	public void setDevalmin(FDouble Devalmin) {
		setAttrVal("Devalmin", Devalmin);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	/**
	 * 单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 启用部位
	 * @return FBoolean
	 */
	public FBoolean getFg_pos() {
		return ((FBoolean) getAttrVal("Fg_pos"));
	}	
	/**
	 * 启用部位
	 * @param Fg_pos
	 */
	public void setFg_pos(FBoolean Fg_pos) {
		setAttrVal("Fg_pos", Fg_pos);
	}
	/**
	 * 部位分类
	 * @return String
	 */
	public String getId_vt_pos_ca() {
		return ((String) getAttrVal("Id_vt_pos_ca"));
	}	
	/**
	 * 部位分类
	 * @param Id_vt_pos_ca
	 */
	public void setId_vt_pos_ca(String Id_vt_pos_ca) {
		setAttrVal("Id_vt_pos_ca", Id_vt_pos_ca);
	}
	/**
	 * 部位分类编码
	 * @return String
	 */
	public String getSd_vt_pos_ca() {
		return ((String) getAttrVal("Sd_vt_pos_ca"));
	}	
	/**
	 * 部位分类编码
	 * @param Sd_vt_pos_ca
	 */
	public void setSd_vt_pos_ca(String Sd_vt_pos_ca) {
		setAttrVal("Sd_vt_pos_ca", Sd_vt_pos_ca);
	}
	/**
	 * 默认部位
	 * @return String
	 */
	public String getId_vt_pos_def() {
		return ((String) getAttrVal("Id_vt_pos_def"));
	}	
	/**
	 * 默认部位
	 * @param Id_vt_pos_def
	 */
	public void setId_vt_pos_def(String Id_vt_pos_def) {
		setAttrVal("Id_vt_pos_def", Id_vt_pos_def);
	}
	/**
	 * 默认部位编码
	 * @return String
	 */
	public String getSd_vt_pos_def() {
		return ((String) getAttrVal("Sd_vt_pos_def"));
	}	
	/**
	 * 默认部位编码
	 * @param Sd_vt_pos_def
	 */
	public void setSd_vt_pos_def(String Sd_vt_pos_def) {
		setAttrVal("Sd_vt_pos_def", Sd_vt_pos_def);
	}
	/**
	 * 启用辅助措施
	 * @return FBoolean
	 */
	public FBoolean getFg_aux() {
		return ((FBoolean) getAttrVal("Fg_aux"));
	}	
	/**
	 * 启用辅助措施
	 * @param Fg_aux
	 */
	public void setFg_aux(FBoolean Fg_aux) {
		setAttrVal("Fg_aux", Fg_aux);
	}
	/**
	 * 辅助措施分类
	 * @return String
	 */
	public String getId_vt_aux_ca() {
		return ((String) getAttrVal("Id_vt_aux_ca"));
	}	
	/**
	 * 辅助措施分类
	 * @param Id_vt_aux_ca
	 */
	public void setId_vt_aux_ca(String Id_vt_aux_ca) {
		setAttrVal("Id_vt_aux_ca", Id_vt_aux_ca);
	}
	/**
	 * 辅助措施分类编码
	 * @return String
	 */
	public String getSd_vt_aux_ca() {
		return ((String) getAttrVal("Sd_vt_aux_ca"));
	}	
	/**
	 * 辅助措施分类编码
	 * @param Sd_vt_aux_ca
	 */
	public void setSd_vt_aux_ca(String Sd_vt_aux_ca) {
		setAttrVal("Sd_vt_aux_ca", Sd_vt_aux_ca);
	}
	/**
	 * 值个数
	 * @return Integer
	 */
	public Integer getValcount() {
		return ((Integer) getAttrVal("Valcount"));
	}	
	/**
	 * 值个数
	 * @param Valcount
	 */
	public void setValcount(Integer Valcount) {
		setAttrVal("Valcount", Valcount);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 公共数据元名称
	 * @return String
	 */
	public String getName_de() {
		return ((String) getAttrVal("Name_de"));
	}	
	/**
	 * 公共数据元名称
	 * @param Name_de
	 */
	public void setName_de(String Name_de) {
		setAttrVal("Name_de", Name_de);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dedatatp() {
		return ((String) getAttrVal("Name_dedatatp"));
	}	
	/**
	 * 名称
	 * @param Name_dedatatp
	 */
	public void setName_dedatatp(String Name_dedatatp) {
		setAttrVal("Name_dedatatp", Name_dedatatp);
	}
	/**
	 * 计量单位名称
	 * @return String
	 */
	public String getName_unit_vt() {
		return ((String) getAttrVal("Name_unit_vt"));
	}	
	/**
	 * 计量单位名称
	 * @param Name_unit_vt
	 */
	public void setName_unit_vt(String Name_unit_vt) {
		setAttrVal("Name_unit_vt", Name_unit_vt);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_vt_pos_ca() {
		return ((String) getAttrVal("Name_vt_pos_ca"));
	}	
	/**
	 * 名称
	 * @param Name_vt_pos_ca
	 */
	public void setName_vt_pos_ca(String Name_vt_pos_ca) {
		setAttrVal("Name_vt_pos_ca", Name_vt_pos_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_vt_pos_def() {
		return ((String) getAttrVal("Name_vt_pos_def"));
	}	
	/**
	 * 名称
	 * @param Name_vt_pos_def
	 */
	public void setName_vt_pos_def(String Name_vt_pos_def) {
		setAttrVal("Name_vt_pos_def", Name_vt_pos_def);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_vt_aux_ca() {
		return ((String) getAttrVal("Name_vt_aux_ca"));
	}	
	/**
	 * 名称
	 * @param Name_vt_aux_ca
	 */
	public void setName_vt_aux_ca(String Name_vt_aux_ca) {
		setAttrVal("Name_vt_aux_ca", Name_vt_aux_ca);
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
		return "Id_srvvt";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_vt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvVtDODesc.class);
	}
	
}