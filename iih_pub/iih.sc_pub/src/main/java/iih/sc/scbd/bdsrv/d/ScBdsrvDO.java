package iih.sc.scbd.bdsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.scbd.bdsrv.d.desc.ScBdsrvDODesc;
import java.math.BigDecimal;

/**
 * 排班计划_医疗服务 DO数据
 * 
 */
public class ScBdsrvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//sc医疗服务id
	public static final String ID_SCBDSRV= "Id_scbdsrv";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医疗服务id
	public static final String ID_SRV= "Id_srv";
	//排班分类
	public static final String ID_SCCA= "Id_scca";
	//时长
	public static final String SRVSLOT= "Srvslot";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//需确认标志
	public static final String FG_NEEDCFM= "Fg_needcfm";
	//门诊是否自动预约
	public static final String FG_AUTOAPT_OP= "Fg_autoapt_op";
	//住院是否自动预约
	public static final String FG_AUTOAPT_IP= "Fg_autoapt_ip";
	//诊疗项目有效期
	public static final String NUM_DAYS_VALID= "Num_days_valid";
	//参考价格
	public static final String PRI= "Pri";
	//服务编码
	public static final String CODE_SRV= "Code_srv";
	//服务名称
	public static final String NAME_SRV= "Name_srv";
	//排班分类编码
	public static final String CODE_SCCA= "Code_scca";
	//排班分类名称
	public static final String NAME_SCCA= "Name_scca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";

	/**
	 * sc医疗服务id
	 * @return String
	 */
	public String getId_scbdsrv() {
		return ((String) getAttrVal("Id_scbdsrv"));
	}
	/**
	 * sc医疗服务id
	 * @param Id_scbdsrv
	 */
	public void setId_scbdsrv(String Id_scbdsrv) {
		setAttrVal("Id_scbdsrv", Id_scbdsrv);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 排班分类
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}
	/**
	 * 排班分类
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 时长
	 * @return Integer
	 */
	public Integer getSrvslot() {
		return ((Integer) getAttrVal("Srvslot"));
	}
	/**
	 * 时长
	 * @param Srvslot
	 */
	public void setSrvslot(Integer Srvslot) {
		setAttrVal("Srvslot", Srvslot);
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
	 * 需确认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needcfm() {
		return ((FBoolean) getAttrVal("Fg_needcfm"));
	}
	/**
	 * 需确认标志
	 * @param Fg_needcfm
	 */
	public void setFg_needcfm(FBoolean Fg_needcfm) {
		setAttrVal("Fg_needcfm", Fg_needcfm);
	}
	/**
	 * 门诊是否自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_autoapt_op() {
		return ((FBoolean) getAttrVal("Fg_autoapt_op"));
	}
	/**
	 * 门诊是否自动预约
	 * @param Fg_autoapt_op
	 */
	public void setFg_autoapt_op(FBoolean Fg_autoapt_op) {
		setAttrVal("Fg_autoapt_op", Fg_autoapt_op);
	}
	/**
	 * 住院是否自动预约
	 * @return FBoolean
	 */
	public FBoolean getFg_autoapt_ip() {
		return ((FBoolean) getAttrVal("Fg_autoapt_ip"));
	}
	/**
	 * 住院是否自动预约
	 * @param Fg_autoapt_ip
	 */
	public void setFg_autoapt_ip(FBoolean Fg_autoapt_ip) {
		setAttrVal("Fg_autoapt_ip", Fg_autoapt_ip);
	}
	/**
	 * 诊疗项目有效期
	 * @return Integer
	 */
	public Integer getNum_days_valid() {
		return ((Integer) getAttrVal("Num_days_valid"));
	}
	/**
	 * 诊疗项目有效期
	 * @param Num_days_valid
	 */
	public void setNum_days_valid(Integer Num_days_valid) {
		setAttrVal("Num_days_valid", Num_days_valid);
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
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 排班分类编码
	 * @return String
	 */
	public String getCode_scca() {
		return ((String) getAttrVal("Code_scca"));
	}
	/**
	 * 排班分类编码
	 * @param Code_scca
	 */
	public void setCode_scca(String Code_scca) {
		setAttrVal("Code_scca", Code_scca);
	}
	/**
	 * 排班分类名称
	 * @return String
	 */
	public String getName_scca() {
		return ((String) getAttrVal("Name_scca"));
	}
	/**
	 * 排班分类名称
	 * @param Name_scca
	 */
	public void setName_scca(String Name_scca) {
		setAttrVal("Name_scca", Name_scca);
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
		return "Id_scbdsrv";
	}

	@Override
	public String getTableName() {
		return "sc_bdsrv";
	}

	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScBdsrvDODesc.class);
	}

}
