package iih.bd.srv.medsrv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medsrv.d.desc.MedSrvLisDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务检验属性 DO数据 
 * 
 */
public class MedSrvLisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验属性主键标识
	public static final String ID_SRVLAB= "Id_srvlab";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//标本类型
	public static final String ID_SAMPTP= "Id_samptp";
	//标本类型编码
	public static final String SD_SAMPTP= "Sd_samptp";
	//标本需求量
	public static final String QUAN= "Quan";
	//标本需求量单位
	public static final String ID_UNIT_QUAN= "Id_unit_quan";
	//采集方法
	public static final String ID_COLLTP= "Id_colltp";
	//采集方法编码
	public static final String SD_COLLTP= "Sd_colltp";
	//标本说明
	public static final String DES_LABSAMP= "Des_labsamp";
	//检验分组
	public static final String ID_LABGROUP= "Id_labgroup";
	//检验分组编码
	public static final String SD_LABGROUP= "Sd_labgroup";
	//标准上限
	public static final String STD_HI= "Std_hi";
	//标准下限
	public static final String STD_LO= "Std_lo";
	//上下限单位
	public static final String ID_UNIT_NUIT= "Id_unit_nuit";
	//注意事项
	public static final String NOTE= "Note";
	//医疗服务项目
	public static final String ID_SRV= "Id_srv";
	//检验结果值类型
	public static final String ID_RESTRPTLABTP= "Id_restrptlabtp";
	//检验结果值类型编码
	public static final String SD_RESTRPTLABTP= "Sd_restrptlabtp";
	//检验结果值域
	public static final String VAL_RESTRPTLAB= "Val_restrptlab";
	//容器类型
	public static final String ID_CONTP= "Id_contp";
	//容器类型编码
	public static final String SD_CONTP= "Sd_contp";
	//标本采集时间
	public static final String ID_SAMPCOLTIME= "Id_sampcoltime";
	//标本采集时长
	public static final String LEN_SAMPCOLTIME= "Len_sampcoltime";
	//时长单位
	public static final String ID_UNIT_SAMPCOLTIME= "Id_unit_sampcoltime";
	//标本采集时间类型
	public static final String ID_SAMPCOLLECTTIMETP= "Id_sampcollecttimetp";
	//标本采集时间类型编码
	public static final String SD_SAMPCOLLECTTIMETP= "Sd_sampcollecttimetp";
	//适用性别
	public static final String FIT_SEX= "Fit_sex";
	//编码
	public static final String SAMPTP_CODE= "Samptp_code";
	//名称
	public static final String SAMPTP_NAME= "Samptp_name";
	//需求量单位编码
	public static final String QUNITCODE= "Qunitcode";
	//需求量单位名称
	public static final String QUNITNAME= "Qunitname";
	//编码
	public static final String COLLTP_CODE= "Colltp_code";
	//名称
	public static final String COLLTP_NAME= "Colltp_name";
	//编码
	public static final String GRO_CODE= "Gro_code";
	//名称
	public static final String GRO_NAME= "Gro_name";
	//上下限单位名称
	public static final String NUIT_NAME= "Nuit_name";
	//上下限单位编码
	public static final String NUIT_CODE= "Nuit_code";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//检验结果类型编码
	public static final String CODE_LISRSTTP= "Code_lisrsttp";
	//检验结果类型名称
	public static final String NAME_LISRSTTP= "Name_lisrsttp";
	//容器类型
	public static final String NAME_CONTP= "Name_contp";
	//标本采集时间名称
	public static final String NAME_SAMPCOLTIME= "Name_sampcoltime";
	//标本采集时间类型
	public static final String IDSAMPCOLLECTTIMETP= "Idsampcollecttimetp";
	//标本采集时间类型编码
	public static final String SDSAMPCOLLECTTIMETP= "Sdsampcollecttimetp";
	//时长单位
	public static final String ID_UNITTIME= "Id_unittime";
	//时长
	public static final String LENTIME= "Lentime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检验属性主键标识
	 * @return String
	 */
	public String getId_srvlab() {
		return ((String) getAttrVal("Id_srvlab"));
	}	
	/**
	 * 检验属性主键标识
	 * @param Id_srvlab
	 */
	public void setId_srvlab(String Id_srvlab) {
		setAttrVal("Id_srvlab", Id_srvlab);
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
	 * 标本类型
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}	
	/**
	 * 标本类型
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}	
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本需求量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	/**
	 * 标本需求量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 标本需求量单位
	 * @return String
	 */
	public String getId_unit_quan() {
		return ((String) getAttrVal("Id_unit_quan"));
	}	
	/**
	 * 标本需求量单位
	 * @param Id_unit_quan
	 */
	public void setId_unit_quan(String Id_unit_quan) {
		setAttrVal("Id_unit_quan", Id_unit_quan);
	}
	/**
	 * 采集方法
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}	
	/**
	 * 采集方法
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}
	/**
	 * 采集方法编码
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}	
	/**
	 * 采集方法编码
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}	
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 检验分组
	 * @return String
	 */
	public String getId_labgroup() {
		return ((String) getAttrVal("Id_labgroup"));
	}	
	/**
	 * 检验分组
	 * @param Id_labgroup
	 */
	public void setId_labgroup(String Id_labgroup) {
		setAttrVal("Id_labgroup", Id_labgroup);
	}
	/**
	 * 检验分组编码
	 * @return String
	 */
	public String getSd_labgroup() {
		return ((String) getAttrVal("Sd_labgroup"));
	}	
	/**
	 * 检验分组编码
	 * @param Sd_labgroup
	 */
	public void setSd_labgroup(String Sd_labgroup) {
		setAttrVal("Sd_labgroup", Sd_labgroup);
	}
	/**
	 * 标准上限
	 * @return FDouble
	 */
	public FDouble getStd_hi() {
		return ((FDouble) getAttrVal("Std_hi"));
	}	
	/**
	 * 标准上限
	 * @param Std_hi
	 */
	public void setStd_hi(FDouble Std_hi) {
		setAttrVal("Std_hi", Std_hi);
	}
	/**
	 * 标准下限
	 * @return FDouble
	 */
	public FDouble getStd_lo() {
		return ((FDouble) getAttrVal("Std_lo"));
	}	
	/**
	 * 标准下限
	 * @param Std_lo
	 */
	public void setStd_lo(FDouble Std_lo) {
		setAttrVal("Std_lo", Std_lo);
	}
	/**
	 * 上下限单位
	 * @return String
	 */
	public String getId_unit_nuit() {
		return ((String) getAttrVal("Id_unit_nuit"));
	}	
	/**
	 * 上下限单位
	 * @param Id_unit_nuit
	 */
	public void setId_unit_nuit(String Id_unit_nuit) {
		setAttrVal("Id_unit_nuit", Id_unit_nuit);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 注意事项
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 检验结果值类型
	 * @return String
	 */
	public String getId_restrptlabtp() {
		return ((String) getAttrVal("Id_restrptlabtp"));
	}	
	/**
	 * 检验结果值类型
	 * @param Id_restrptlabtp
	 */
	public void setId_restrptlabtp(String Id_restrptlabtp) {
		setAttrVal("Id_restrptlabtp", Id_restrptlabtp);
	}
	/**
	 * 检验结果值类型编码
	 * @return String
	 */
	public String getSd_restrptlabtp() {
		return ((String) getAttrVal("Sd_restrptlabtp"));
	}	
	/**
	 * 检验结果值类型编码
	 * @param Sd_restrptlabtp
	 */
	public void setSd_restrptlabtp(String Sd_restrptlabtp) {
		setAttrVal("Sd_restrptlabtp", Sd_restrptlabtp);
	}
	/**
	 * 检验结果值域
	 * @return String
	 */
	public String getVal_restrptlab() {
		return ((String) getAttrVal("Val_restrptlab"));
	}	
	/**
	 * 检验结果值域
	 * @param Val_restrptlab
	 */
	public void setVal_restrptlab(String Val_restrptlab) {
		setAttrVal("Val_restrptlab", Val_restrptlab);
	}
	/**
	 * 容器类型
	 * @return String
	 */
	public String getId_contp() {
		return ((String) getAttrVal("Id_contp"));
	}	
	/**
	 * 容器类型
	 * @param Id_contp
	 */
	public void setId_contp(String Id_contp) {
		setAttrVal("Id_contp", Id_contp);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getSd_contp() {
		return ((String) getAttrVal("Sd_contp"));
	}	
	/**
	 * 容器类型编码
	 * @param Sd_contp
	 */
	public void setSd_contp(String Sd_contp) {
		setAttrVal("Sd_contp", Sd_contp);
	}
	/**
	 * 标本采集时间
	 * @return String
	 */
	public String getId_sampcoltime() {
		return ((String) getAttrVal("Id_sampcoltime"));
	}	
	/**
	 * 标本采集时间
	 * @param Id_sampcoltime
	 */
	public void setId_sampcoltime(String Id_sampcoltime) {
		setAttrVal("Id_sampcoltime", Id_sampcoltime);
	}
	/**
	 * 标本采集时长
	 * @return FDouble
	 */
	public FDouble getLen_sampcoltime() {
		return ((FDouble) getAttrVal("Len_sampcoltime"));
	}	
	/**
	 * 标本采集时长
	 * @param Len_sampcoltime
	 */
	public void setLen_sampcoltime(FDouble Len_sampcoltime) {
		setAttrVal("Len_sampcoltime", Len_sampcoltime);
	}
	/**
	 * 时长单位
	 * @return String
	 */
	public String getId_unit_sampcoltime() {
		return ((String) getAttrVal("Id_unit_sampcoltime"));
	}	
	/**
	 * 时长单位
	 * @param Id_unit_sampcoltime
	 */
	public void setId_unit_sampcoltime(String Id_unit_sampcoltime) {
		setAttrVal("Id_unit_sampcoltime", Id_unit_sampcoltime);
	}
	/**
	 * 标本采集时间类型
	 * @return String
	 */
	public String getId_sampcollecttimetp() {
		return ((String) getAttrVal("Id_sampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型
	 * @param Id_sampcollecttimetp
	 */
	public void setId_sampcollecttimetp(String Id_sampcollecttimetp) {
		setAttrVal("Id_sampcollecttimetp", Id_sampcollecttimetp);
	}
	/**
	 * 标本采集时间类型编码
	 * @return String
	 */
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型编码
	 * @param Sd_sampcollecttimetp
	 */
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
	}
	/**
	 * 适用性别
	 * @return Integer
	 */
	public Integer getFit_sex() {
		return ((Integer) getAttrVal("Fit_sex"));
	}	
	/**
	 * 适用性别
	 * @param Fit_sex
	 */
	public void setFit_sex(Integer Fit_sex) {
		setAttrVal("Fit_sex", Fit_sex);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSamptp_code() {
		return ((String) getAttrVal("Samptp_code"));
	}	
	/**
	 * 编码
	 * @param Samptp_code
	 */
	public void setSamptp_code(String Samptp_code) {
		setAttrVal("Samptp_code", Samptp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSamptp_name() {
		return ((String) getAttrVal("Samptp_name"));
	}	
	/**
	 * 名称
	 * @param Samptp_name
	 */
	public void setSamptp_name(String Samptp_name) {
		setAttrVal("Samptp_name", Samptp_name);
	}
	/**
	 * 需求量单位编码
	 * @return String
	 */
	public String getQunitcode() {
		return ((String) getAttrVal("Qunitcode"));
	}	
	/**
	 * 需求量单位编码
	 * @param Qunitcode
	 */
	public void setQunitcode(String Qunitcode) {
		setAttrVal("Qunitcode", Qunitcode);
	}
	/**
	 * 需求量单位名称
	 * @return String
	 */
	public String getQunitname() {
		return ((String) getAttrVal("Qunitname"));
	}	
	/**
	 * 需求量单位名称
	 * @param Qunitname
	 */
	public void setQunitname(String Qunitname) {
		setAttrVal("Qunitname", Qunitname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getColltp_code() {
		return ((String) getAttrVal("Colltp_code"));
	}	
	/**
	 * 编码
	 * @param Colltp_code
	 */
	public void setColltp_code(String Colltp_code) {
		setAttrVal("Colltp_code", Colltp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getColltp_name() {
		return ((String) getAttrVal("Colltp_name"));
	}	
	/**
	 * 名称
	 * @param Colltp_name
	 */
	public void setColltp_name(String Colltp_name) {
		setAttrVal("Colltp_name", Colltp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGro_code() {
		return ((String) getAttrVal("Gro_code"));
	}	
	/**
	 * 编码
	 * @param Gro_code
	 */
	public void setGro_code(String Gro_code) {
		setAttrVal("Gro_code", Gro_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGro_name() {
		return ((String) getAttrVal("Gro_name"));
	}	
	/**
	 * 名称
	 * @param Gro_name
	 */
	public void setGro_name(String Gro_name) {
		setAttrVal("Gro_name", Gro_name);
	}
	/**
	 * 上下限单位名称
	 * @return String
	 */
	public String getNuit_name() {
		return ((String) getAttrVal("Nuit_name"));
	}	
	/**
	 * 上下限单位名称
	 * @param Nuit_name
	 */
	public void setNuit_name(String Nuit_name) {
		setAttrVal("Nuit_name", Nuit_name);
	}
	/**
	 * 上下限单位编码
	 * @return String
	 */
	public String getNuit_code() {
		return ((String) getAttrVal("Nuit_code"));
	}	
	/**
	 * 上下限单位编码
	 * @param Nuit_code
	 */
	public void setNuit_code(String Nuit_code) {
		setAttrVal("Nuit_code", Nuit_code);
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
	 * 检验结果类型编码
	 * @return String
	 */
	public String getCode_lisrsttp() {
		return ((String) getAttrVal("Code_lisrsttp"));
	}	
	/**
	 * 检验结果类型编码
	 * @param Code_lisrsttp
	 */
	public void setCode_lisrsttp(String Code_lisrsttp) {
		setAttrVal("Code_lisrsttp", Code_lisrsttp);
	}
	/**
	 * 检验结果类型名称
	 * @return String
	 */
	public String getName_lisrsttp() {
		return ((String) getAttrVal("Name_lisrsttp"));
	}	
	/**
	 * 检验结果类型名称
	 * @param Name_lisrsttp
	 */
	public void setName_lisrsttp(String Name_lisrsttp) {
		setAttrVal("Name_lisrsttp", Name_lisrsttp);
	}
	/**
	 * 容器类型
	 * @return String
	 */
	public String getName_contp() {
		return ((String) getAttrVal("Name_contp"));
	}	
	/**
	 * 容器类型
	 * @param Name_contp
	 */
	public void setName_contp(String Name_contp) {
		setAttrVal("Name_contp", Name_contp);
	}
	/**
	 * 标本采集时间名称
	 * @return String
	 */
	public String getName_sampcoltime() {
		return ((String) getAttrVal("Name_sampcoltime"));
	}	
	/**
	 * 标本采集时间名称
	 * @param Name_sampcoltime
	 */
	public void setName_sampcoltime(String Name_sampcoltime) {
		setAttrVal("Name_sampcoltime", Name_sampcoltime);
	}
	/**
	 * 标本采集时间类型
	 * @return String
	 */
	public String getIdsampcollecttimetp() {
		return ((String) getAttrVal("Idsampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型
	 * @param Idsampcollecttimetp
	 */
	public void setIdsampcollecttimetp(String Idsampcollecttimetp) {
		setAttrVal("Idsampcollecttimetp", Idsampcollecttimetp);
	}
	/**
	 * 标本采集时间类型编码
	 * @return String
	 */
	public String getSdsampcollecttimetp() {
		return ((String) getAttrVal("Sdsampcollecttimetp"));
	}	
	/**
	 * 标本采集时间类型编码
	 * @param Sdsampcollecttimetp
	 */
	public void setSdsampcollecttimetp(String Sdsampcollecttimetp) {
		setAttrVal("Sdsampcollecttimetp", Sdsampcollecttimetp);
	}
	/**
	 * 时长单位
	 * @return String
	 */
	public String getId_unittime() {
		return ((String) getAttrVal("Id_unittime"));
	}	
	/**
	 * 时长单位
	 * @param Id_unittime
	 */
	public void setId_unittime(String Id_unittime) {
		setAttrVal("Id_unittime", Id_unittime);
	}
	/**
	 * 时长
	 * @return FDouble
	 */
	public FDouble getLentime() {
		return ((FDouble) getAttrVal("Lentime"));
	}	
	/**
	 * 时长
	 * @param Lentime
	 */
	public void setLentime(FDouble Lentime) {
		setAttrVal("Lentime", Lentime);
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
		return "Id_srvlab";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_lab";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedSrvLisDODesc.class);
	}
	
}