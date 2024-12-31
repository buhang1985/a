package iih.bd.pp.srvmpayratio.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.srvmpayratio.d.desc.SrvMPayRatioDODesc;
import java.math.BigDecimal;

/**
 * 医保计划_服务多支付比例 DO数据 
 * 
 */
public class SrvMPayRatioDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//服务多支付比例主键
	public static final String ID_HPSRVMPAYRATIO= "Id_hpsrvmpayratio";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//服务项目
	public static final String ID_SRV= "Id_srv";
	//物品
	public static final String ID_MM= "Id_mm";
	//多支付比例
	public static final String ID_HPMPAYRATIODF= "Id_hpmpayratiodf";
	//上传医保编码
	public static final String CODE= "Code";
	//备注
	public static final String NOTE= "Note";
	//所属就诊标志_门诊
	public static final String FG_ENTP_OP= "Fg_entp_op";
	//急诊流水标志
	public static final String FG_ENTP_ER= "Fg_entp_er";
	//急诊抢救标志
	public static final String FG_USE_ER1= "Fg_use_er1";
	//急诊留观标志
	public static final String FG_USE_ER2= "Fg_use_er2";
	//所属就诊标志_住院
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	//所属就诊标志_体检
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	//所属就诊标志_家庭病床
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//可使用标识_预住院
	public static final String FG_USE_PIP= "Fg_use_pip";
	//医保计划名称
	public static final String HP_NAME= "Hp_name";
	//医保计划编码
	public static final String HP_CODE= "Hp_code";
	//医疗服务名称
	public static final String SRV_NAME= "Srv_name";
	//医疗服务编码
	public static final String SRV_CODE= "Srv_code";
	//医疗服务物品标识
	public static final String SRV_FG_MM= "Srv_fg_mm";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//多支付段名称
	public static final String MPAYRATIO_NAME= "Mpayratio_name";
	//多支付段编码
	public static final String MPAYRATIO_CODE= "Mpayratio_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 服务多支付比例主键
	 * @return String
	 */
	public String getId_hpsrvmpayratio() {
		return ((String) getAttrVal("Id_hpsrvmpayratio"));
	}	
	/**
	 * 服务多支付比例主键
	 * @param Id_hpsrvmpayratio
	 */
	public void setId_hpsrvmpayratio(String Id_hpsrvmpayratio) {
		setAttrVal("Id_hpsrvmpayratio", Id_hpsrvmpayratio);
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
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 多支付比例
	 * @return String
	 */
	public String getId_hpmpayratiodf() {
		return ((String) getAttrVal("Id_hpmpayratiodf"));
	}	
	/**
	 * 多支付比例
	 * @param Id_hpmpayratiodf
	 */
	public void setId_hpmpayratiodf(String Id_hpmpayratiodf) {
		setAttrVal("Id_hpmpayratiodf", Id_hpmpayratiodf);
	}
	/**
	 * 上传医保编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 上传医保编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 所属就诊标志_门诊
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	/**
	 * 所属就诊标志_门诊
	 * @param Fg_entp_op
	 */
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	/**
	 * 急诊流水标志
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	/**
	 * 急诊流水标志
	 * @param Fg_entp_er
	 */
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	/**
	 * 急诊抢救标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	/**
	 * 急诊抢救标志
	 * @param Fg_use_er1
	 */
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	/**
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_use_er2
	 */
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	/**
	 * 所属就诊标志_住院
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	/**
	 * 所属就诊标志_住院
	 * @param Fg_entp_ip
	 */
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	/**
	 * 所属就诊标志_体检
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	/**
	 * 所属就诊标志_体检
	 * @param Fg_entp_pe
	 */
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	/**
	 * 所属就诊标志_家庭病床
	 * @return FBoolean
	 */
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	/**
	 * 所属就诊标志_家庭病床
	 * @param Fg_entp_fm
	 */
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
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
	 * 可使用标识_预住院
	 * @return FBoolean
	 */
	public FBoolean getFg_use_pip() {
		return ((FBoolean) getAttrVal("Fg_use_pip"));
	}	
	/**
	 * 可使用标识_预住院
	 * @param Fg_use_pip
	 */
	public void setFg_use_pip(FBoolean Fg_use_pip) {
		setAttrVal("Fg_use_pip", Fg_use_pip);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	/**
	 * 医保计划名称
	 * @param Hp_name
	 */
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	/**
	 * 医保计划编码
	 * @param Hp_code
	 */
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 医疗服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 医疗服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	/**
	 * 医疗服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * 医疗服务物品标识
	 * @return FBoolean
	 */
	public FBoolean getSrv_fg_mm() {
		return ((FBoolean) getAttrVal("Srv_fg_mm"));
	}	
	/**
	 * 医疗服务物品标识
	 * @param Srv_fg_mm
	 */
	public void setSrv_fg_mm(FBoolean Srv_fg_mm) {
		setAttrVal("Srv_fg_mm", Srv_fg_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	/**
	 * 物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 多支付段名称
	 * @return String
	 */
	public String getMpayratio_name() {
		return ((String) getAttrVal("Mpayratio_name"));
	}	
	/**
	 * 多支付段名称
	 * @param Mpayratio_name
	 */
	public void setMpayratio_name(String Mpayratio_name) {
		setAttrVal("Mpayratio_name", Mpayratio_name);
	}
	/**
	 * 多支付段编码
	 * @return String
	 */
	public String getMpayratio_code() {
		return ((String) getAttrVal("Mpayratio_code"));
	}	
	/**
	 * 多支付段编码
	 * @param Mpayratio_code
	 */
	public void setMpayratio_code(String Mpayratio_code) {
		setAttrVal("Mpayratio_code", Mpayratio_code);
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
		return "Id_hpsrvmpayratio";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_SRV_MPAYRATIO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvMPayRatioDODesc.class);
	}
	
}