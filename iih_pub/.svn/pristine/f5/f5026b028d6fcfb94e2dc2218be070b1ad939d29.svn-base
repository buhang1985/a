package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvOpDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务手术属性 DO数据 
 * 
 */
public class MedSrvOpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗服务手术主键标识
	public static final String ID_SRVSUG= "Id_srvsug";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//手术级别
	public static final String ID_OPCLASS= "Id_opclass";
	//手术级别编码
	public static final String SD_OPCLASS= "Sd_opclass";
	//切口等级
	public static final String ID_INCITP= "Id_incitp";
	//切口等级编码
	public static final String SD_INCITP= "Sd_incitp";
	//手术
	public static final String ID_DIAG_OP= "Id_diag_op";
	//手术编码
	public static final String OPCODE= "Opcode";
	//麻醉方法
	public static final String SD_ANAE= "Sd_anae";
	//手术部位
	public static final String SD_BODY= "Sd_body";
	//手术体位
	public static final String SD_POS= "Sd_pos";
	//介入物编码
	public static final String PDCODE= "Pdcode";
	//介入物名称
	public static final String PDNAME= "Pdname";
	//引流标识
	public static final String FG_DRAINAGE= "Fg_drainage";
	//医疗服务项目
	public static final String ID_SRV= "Id_srv";
	//关联标准诊断
	public static final String ID_DIDEF= "Id_didef";
	//新开手术标识
	public static final String FG_NEW_SUG= "Fg_new_sug";
	//名称
	public static final String NAME_OPCLASS= "Name_opclass";
	//切口等级名称
	public static final String NAME_INCITP= "Name_incitp";
	//诊断名称
	public static final String DOP_NAME= "Dop_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//诊断名称
	public static final String NAME_DI= "Name_di";
	//诊断编码
	public static final String CODE_DI= "Code_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗服务手术主键标识
	 * @return String
	 */
	public String getId_srvsug() {
		return ((String) getAttrVal("Id_srvsug"));
	}	
	/**
	 * 医疗服务手术主键标识
	 * @param Id_srvsug
	 */
	public void setId_srvsug(String Id_srvsug) {
		setAttrVal("Id_srvsug", Id_srvsug);
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
	 * 手术级别
	 * @return String
	 */
	public String getId_opclass() {
		return ((String) getAttrVal("Id_opclass"));
	}	
	/**
	 * 手术级别
	 * @param Id_opclass
	 */
	public void setId_opclass(String Id_opclass) {
		setAttrVal("Id_opclass", Id_opclass);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_opclass() {
		return ((String) getAttrVal("Sd_opclass"));
	}	
	/**
	 * 手术级别编码
	 * @param Sd_opclass
	 */
	public void setSd_opclass(String Sd_opclass) {
		setAttrVal("Sd_opclass", Sd_opclass);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}	
	/**
	 * 切口等级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}	
	/**
	 * 切口等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 手术
	 * @return String
	 */
	public String getId_diag_op() {
		return ((String) getAttrVal("Id_diag_op"));
	}	
	/**
	 * 手术
	 * @param Id_diag_op
	 */
	public void setId_diag_op(String Id_diag_op) {
		setAttrVal("Id_diag_op", Id_diag_op);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getOpcode() {
		return ((String) getAttrVal("Opcode"));
	}	
	/**
	 * 手术编码
	 * @param Opcode
	 */
	public void setOpcode(String Opcode) {
		setAttrVal("Opcode", Opcode);
	}
	/**
	 * 麻醉方法
	 * @return String
	 */
	public String getSd_anae() {
		return ((String) getAttrVal("Sd_anae"));
	}	
	/**
	 * 麻醉方法
	 * @param Sd_anae
	 */
	public void setSd_anae(String Sd_anae) {
		setAttrVal("Sd_anae", Sd_anae);
	}
	/**
	 * 手术部位
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}	
	/**
	 * 手术部位
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 手术体位
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}	
	/**
	 * 手术体位
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 介入物编码
	 * @return String
	 */
	public String getPdcode() {
		return ((String) getAttrVal("Pdcode"));
	}	
	/**
	 * 介入物编码
	 * @param Pdcode
	 */
	public void setPdcode(String Pdcode) {
		setAttrVal("Pdcode", Pdcode);
	}
	/**
	 * 介入物名称
	 * @return String
	 */
	public String getPdname() {
		return ((String) getAttrVal("Pdname"));
	}	
	/**
	 * 介入物名称
	 * @param Pdname
	 */
	public void setPdname(String Pdname) {
		setAttrVal("Pdname", Pdname);
	}
	/**
	 * 引流标识
	 * @return String
	 */
	public String getFg_drainage() {
		return ((String) getAttrVal("Fg_drainage"));
	}	
	/**
	 * 引流标识
	 * @param Fg_drainage
	 */
	public void setFg_drainage(String Fg_drainage) {
		setAttrVal("Fg_drainage", Fg_drainage);
	}
	/**
	 * 医疗服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 关联标准诊断
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	/**
	 * 关联标准诊断
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 新开手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}	
	/**
	 * 新开手术标识
	 * @param Fg_new_sug
	 */
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_opclass() {
		return ((String) getAttrVal("Name_opclass"));
	}	
	/**
	 * 名称
	 * @param Name_opclass
	 */
	public void setName_opclass(String Name_opclass) {
		setAttrVal("Name_opclass", Name_opclass);
	}
	/**
	 * 切口等级名称
	 * @return String
	 */
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}	
	/**
	 * 切口等级名称
	 * @param Name_incitp
	 */
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDop_name() {
		return ((String) getAttrVal("Dop_name"));
	}	
	/**
	 * 诊断名称
	 * @param Dop_name
	 */
	public void setDop_name(String Dop_name) {
		setAttrVal("Dop_name", Dop_name);
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
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
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
		return "Id_srvsug";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_sug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvOpDODesc.class);
	}
	
}