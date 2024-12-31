package iih.nmr.pkuf.childinout.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.childinout.d.desc.ChildInoutDODesc;
import java.math.BigDecimal;

/**
 * 儿童医院护理记录单出入量总结 DO数据 
 * 
 */
public class ChildInoutDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出入量统计ID
	public static final String ID_CHILDINOUT= "Id_childinout";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//入量名称
	public static final String NAME_IN= "Name_in";
	//出量名称
	public static final String NAME_OUT= "Name_out";
	//统计类型ID
	public static final String ID_IOTYPE= "Id_iotype";
	//统计类型SD
	public static final String SD_IOTYPE= "Sd_iotype";
	//统计开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//统计结束时间
	public static final String DT_END= "Dt_end";
	//入量总量
	public static final String NUM_IN= "Num_in";
	//出量总量
	public static final String NUM_OUT= "Num_out";
	//签名
	public static final String ID_NUR= "Id_nur";
	//备注
	public static final String NOTE= "Note";
	//dt_create
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//统计类型
	public static final String NAME_IOTYPE= "Name_iotype";
	//人员信息姓名
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出入量统计ID
	 * @return String
	 */
	public String getId_childinout() {
		return ((String) getAttrVal("Id_childinout"));
	}	
	/**
	 * 出入量统计ID
	 * @param Id_childinout
	 */
	public void setId_childinout(String Id_childinout) {
		setAttrVal("Id_childinout", Id_childinout);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 入量名称
	 * @return String
	 */
	public String getName_in() {
		return ((String) getAttrVal("Name_in"));
	}	
	/**
	 * 入量名称
	 * @param Name_in
	 */
	public void setName_in(String Name_in) {
		setAttrVal("Name_in", Name_in);
	}
	/**
	 * 出量名称
	 * @return String
	 */
	public String getName_out() {
		return ((String) getAttrVal("Name_out"));
	}	
	/**
	 * 出量名称
	 * @param Name_out
	 */
	public void setName_out(String Name_out) {
		setAttrVal("Name_out", Name_out);
	}
	/**
	 * 统计类型ID
	 * @return String
	 */
	public String getId_iotype() {
		return ((String) getAttrVal("Id_iotype"));
	}	
	/**
	 * 统计类型ID
	 * @param Id_iotype
	 */
	public void setId_iotype(String Id_iotype) {
		setAttrVal("Id_iotype", Id_iotype);
	}
	/**
	 * 统计类型SD
	 * @return String
	 */
	public String getSd_iotype() {
		return ((String) getAttrVal("Sd_iotype"));
	}	
	/**
	 * 统计类型SD
	 * @param Sd_iotype
	 */
	public void setSd_iotype(String Sd_iotype) {
		setAttrVal("Sd_iotype", Sd_iotype);
	}
	/**
	 * 统计开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 统计开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 统计结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 统计结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 入量总量
	 * @return FDouble
	 */
	public FDouble getNum_in() {
		return ((FDouble) getAttrVal("Num_in"));
	}	
	/**
	 * 入量总量
	 * @param Num_in
	 */
	public void setNum_in(FDouble Num_in) {
		setAttrVal("Num_in", Num_in);
	}
	/**
	 * 出量总量
	 * @return FDouble
	 */
	public FDouble getNum_out() {
		return ((FDouble) getAttrVal("Num_out"));
	}	
	/**
	 * 出量总量
	 * @param Num_out
	 */
	public void setNum_out(FDouble Num_out) {
		setAttrVal("Num_out", Num_out);
	}
	/**
	 * 签名
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 签名
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	 * dt_create
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * dt_create
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 统计类型
	 * @return String
	 */
	public String getName_iotype() {
		return ((String) getAttrVal("Name_iotype"));
	}	
	/**
	 * 统计类型
	 * @param Name_iotype
	 */
	public void setName_iotype(String Name_iotype) {
		setAttrVal("Name_iotype", Name_iotype);
	}
	/**
	 * 人员信息姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员信息姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_childinout";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_CHILDINOUT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildInoutDODesc.class);
	}
	
}