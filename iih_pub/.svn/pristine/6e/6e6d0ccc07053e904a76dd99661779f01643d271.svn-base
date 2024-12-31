package iih.pe.pip.peipregquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pip.peipregquery.d.desc.PeIpRegQueryDODesc;
import java.math.BigDecimal;

/**
 * 住院体检名单列表查询 DO数据 
 * 
 */
public class PeIpRegQueryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检登记检索主键标识
	public static final String ID_PEREGQUERY= "Id_peregquery";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//结束日期
	public static final String DT_END= "Dt_end";
	//过滤分类
	public static final String FILTERCA= "Filterca";
	//团体
	public static final String ID_CORP= "Id_corp";
	//客户编码
	public static final String CODE= "Code";
	//姓名
	public static final String NAME= "Name";
	//体检唯一号
	public static final String PE_CODE= "Pe_code";
	//证件号码
	public static final String IDCODE= "Idcode";
	//拼音缩写
	public static final String PYCODE= "Pycode";
	//移动电话
	public static final String MOB= "Mob";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//卡类型
	public static final String CARDTP= "Cardtp";
	//卡号
	public static final String CARDNO= "Cardno";
	//打印导引单
	public static final String FG_PRTGUIDE= "Fg_prtguide";
	//打印条码
	public static final String FG_PRTBARCODE= "Fg_prtbarcode";
	//连续录入
	public static final String FG_CONTINPUT= "Fg_continput";
	//自动新建
	public static final String FG_NEW= "Fg_new";
	//人数
	public static final String PSN_COUNT= "Psn_count";
	//用餐状态
	public static final String ST_DINING= "St_dining";
	//总检状态过滤
	public static final String FILTEROVAL= "Filteroval";
	//阳性追踪状态过滤
	public static final String FILTERTRACK= "Filtertrack";
	//健康管理预约状态过滤
	public static final String FILTERHM= "Filterhm";
	//健康管理师
	public static final String HMER= "Hmer";
	//导引单打印标识
	public static final String FG_GUIDERPRINT= "Fg_guiderprint";
	//条码打印标识
	public static final String FG_BARCODEPRINT= "Fg_barcodeprint";
	//付款客户
	public static final String ID_CUST= "Id_cust";
	//团检记录
	public static final String ID_PECMPY= "Id_pecmpy";
	//入院病区
	public static final String ID_DEP_NURADM= "Id_dep_nuradm";
	//入院科室
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	//健康管理师编码
	public static final String CODE_HMER= "Code_hmer";
	//健康管理师姓名
	public static final String NAME_HMER= "Name_hmer";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//客户名称
	public static final String NAME_CUST= "Name_cust";
	//团检编码
	public static final String NO_CONTRACT= "No_contract";
	//体检次数
	public static final String TIMES_PE= "Times_pe";
	//团检状态
	public static final String EU_STATUS= "Eu_status";
	//编码
	public static final String CODE_NURADM= "Code_nuradm";
	//名称
	public static final String NAME_NURADM= "Name_nuradm";
	//编码
	public static final String CODE_PHYADM= "Code_phyadm";
	//名称
	public static final String NAME_PHYADM= "Name_phyadm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检登记检索主键标识
	 * @return String
	 */
	public String getId_peregquery() {
		return ((String) getAttrVal("Id_peregquery"));
	}	
	/**
	 * 体检登记检索主键标识
	 * @param Id_peregquery
	 */
	public void setId_peregquery(String Id_peregquery) {
		setAttrVal("Id_peregquery", Id_peregquery);
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
	 * 开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 过滤分类
	 * @return Integer
	 */
	public Integer getFilterca() {
		return ((Integer) getAttrVal("Filterca"));
	}	
	/**
	 * 过滤分类
	 * @param Filterca
	 */
	public void setFilterca(Integer Filterca) {
		setAttrVal("Filterca", Filterca);
	}
	/**
	 * 团体
	 * @return String
	 */
	public String getId_corp() {
		return ((String) getAttrVal("Id_corp"));
	}	
	/**
	 * 团体
	 * @param Id_corp
	 */
	public void setId_corp(String Id_corp) {
		setAttrVal("Id_corp", Id_corp);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 客户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 体检唯一号
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一号
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 拼音缩写
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音缩写
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 卡类型
	 * @return Integer
	 */
	public Integer getCardtp() {
		return ((Integer) getAttrVal("Cardtp"));
	}	
	/**
	 * 卡类型
	 * @param Cardtp
	 */
	public void setCardtp(Integer Cardtp) {
		setAttrVal("Cardtp", Cardtp);
	}
	/**
	 * 卡号
	 * @return String
	 */
	public String getCardno() {
		return ((String) getAttrVal("Cardno"));
	}	
	/**
	 * 卡号
	 * @param Cardno
	 */
	public void setCardno(String Cardno) {
		setAttrVal("Cardno", Cardno);
	}
	/**
	 * 打印导引单
	 * @return FBoolean
	 */
	public FBoolean getFg_prtguide() {
		return ((FBoolean) getAttrVal("Fg_prtguide"));
	}	
	/**
	 * 打印导引单
	 * @param Fg_prtguide
	 */
	public void setFg_prtguide(FBoolean Fg_prtguide) {
		setAttrVal("Fg_prtguide", Fg_prtguide);
	}
	/**
	 * 打印条码
	 * @return FBoolean
	 */
	public FBoolean getFg_prtbarcode() {
		return ((FBoolean) getAttrVal("Fg_prtbarcode"));
	}	
	/**
	 * 打印条码
	 * @param Fg_prtbarcode
	 */
	public void setFg_prtbarcode(FBoolean Fg_prtbarcode) {
		setAttrVal("Fg_prtbarcode", Fg_prtbarcode);
	}
	/**
	 * 连续录入
	 * @return FBoolean
	 */
	public FBoolean getFg_continput() {
		return ((FBoolean) getAttrVal("Fg_continput"));
	}	
	/**
	 * 连续录入
	 * @param Fg_continput
	 */
	public void setFg_continput(FBoolean Fg_continput) {
		setAttrVal("Fg_continput", Fg_continput);
	}
	/**
	 * 自动新建
	 * @return FBoolean
	 */
	public FBoolean getFg_new() {
		return ((FBoolean) getAttrVal("Fg_new"));
	}	
	/**
	 * 自动新建
	 * @param Fg_new
	 */
	public void setFg_new(FBoolean Fg_new) {
		setAttrVal("Fg_new", Fg_new);
	}
	/**
	 * 人数
	 * @return Integer
	 */
	public Integer getPsn_count() {
		return ((Integer) getAttrVal("Psn_count"));
	}	
	/**
	 * 人数
	 * @param Psn_count
	 */
	public void setPsn_count(Integer Psn_count) {
		setAttrVal("Psn_count", Psn_count);
	}
	/**
	 * 用餐状态
	 * @return Integer
	 */
	public Integer getSt_dining() {
		return ((Integer) getAttrVal("St_dining"));
	}	
	/**
	 * 用餐状态
	 * @param St_dining
	 */
	public void setSt_dining(Integer St_dining) {
		setAttrVal("St_dining", St_dining);
	}
	/**
	 * 总检状态过滤
	 * @return Integer
	 */
	public Integer getFilteroval() {
		return ((Integer) getAttrVal("Filteroval"));
	}	
	/**
	 * 总检状态过滤
	 * @param Filteroval
	 */
	public void setFilteroval(Integer Filteroval) {
		setAttrVal("Filteroval", Filteroval);
	}
	/**
	 * 阳性追踪状态过滤
	 * @return Integer
	 */
	public Integer getFiltertrack() {
		return ((Integer) getAttrVal("Filtertrack"));
	}	
	/**
	 * 阳性追踪状态过滤
	 * @param Filtertrack
	 */
	public void setFiltertrack(Integer Filtertrack) {
		setAttrVal("Filtertrack", Filtertrack);
	}
	/**
	 * 健康管理预约状态过滤
	 * @return Integer
	 */
	public Integer getFilterhm() {
		return ((Integer) getAttrVal("Filterhm"));
	}	
	/**
	 * 健康管理预约状态过滤
	 * @param Filterhm
	 */
	public void setFilterhm(Integer Filterhm) {
		setAttrVal("Filterhm", Filterhm);
	}
	/**
	 * 健康管理师
	 * @return String
	 */
	public String getHmer() {
		return ((String) getAttrVal("Hmer"));
	}	
	/**
	 * 健康管理师
	 * @param Hmer
	 */
	public void setHmer(String Hmer) {
		setAttrVal("Hmer", Hmer);
	}
	/**
	 * 导引单打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_guiderprint() {
		return ((FBoolean) getAttrVal("Fg_guiderprint"));
	}	
	/**
	 * 导引单打印标识
	 * @param Fg_guiderprint
	 */
	public void setFg_guiderprint(FBoolean Fg_guiderprint) {
		setAttrVal("Fg_guiderprint", Fg_guiderprint);
	}
	/**
	 * 条码打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_barcodeprint() {
		return ((FBoolean) getAttrVal("Fg_barcodeprint"));
	}	
	/**
	 * 条码打印标识
	 * @param Fg_barcodeprint
	 */
	public void setFg_barcodeprint(FBoolean Fg_barcodeprint) {
		setAttrVal("Fg_barcodeprint", Fg_barcodeprint);
	}
	/**
	 * 付款客户
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	/**
	 * 付款客户
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 团检记录
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	/**
	 * 团检记录
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	/**
	 * 入院病区
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	/**
	 * 入院科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCode_corp() {
		return ((String) getAttrVal("Code_corp"));
	}	
	/**
	 * 单位编码
	 * @param Code_corp
	 */
	public void setCode_corp(String Code_corp) {
		setAttrVal("Code_corp", Code_corp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}	
	/**
	 * 单位名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 健康管理师编码
	 * @return String
	 */
	public String getCode_hmer() {
		return ((String) getAttrVal("Code_hmer"));
	}	
	/**
	 * 健康管理师编码
	 * @param Code_hmer
	 */
	public void setCode_hmer(String Code_hmer) {
		setAttrVal("Code_hmer", Code_hmer);
	}
	/**
	 * 健康管理师姓名
	 * @return String
	 */
	public String getName_hmer() {
		return ((String) getAttrVal("Name_hmer"));
	}	
	/**
	 * 健康管理师姓名
	 * @param Name_hmer
	 */
	public void setName_hmer(String Name_hmer) {
		setAttrVal("Name_hmer", Name_hmer);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}	
	/**
	 * 客户编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 客户名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}	
	/**
	 * 客户名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 团检编码
	 * @return String
	 */
	public String getNo_contract() {
		return ((String) getAttrVal("No_contract"));
	}	
	/**
	 * 团检编码
	 * @param No_contract
	 */
	public void setNo_contract(String No_contract) {
		setAttrVal("No_contract", No_contract);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getTimes_pe() {
		return ((Integer) getAttrVal("Times_pe"));
	}	
	/**
	 * 体检次数
	 * @param Times_pe
	 */
	public void setTimes_pe(Integer Times_pe) {
		setAttrVal("Times_pe", Times_pe);
	}
	/**
	 * 团检状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}	
	/**
	 * 团检状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nuradm() {
		return ((String) getAttrVal("Code_nuradm"));
	}	
	/**
	 * 编码
	 * @param Code_nuradm
	 */
	public void setCode_nuradm(String Code_nuradm) {
		setAttrVal("Code_nuradm", Code_nuradm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nuradm() {
		return ((String) getAttrVal("Name_nuradm"));
	}	
	/**
	 * 名称
	 * @param Name_nuradm
	 */
	public void setName_nuradm(String Name_nuradm) {
		setAttrVal("Name_nuradm", Name_nuradm);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_phyadm() {
		return ((String) getAttrVal("Code_phyadm"));
	}	
	/**
	 * 编码
	 * @param Code_phyadm
	 */
	public void setCode_phyadm(String Code_phyadm) {
		setAttrVal("Code_phyadm", Code_phyadm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_phyadm() {
		return ((String) getAttrVal("Name_phyadm"));
	}	
	/**
	 * 名称
	 * @param Name_phyadm
	 */
	public void setName_phyadm(String Name_phyadm) {
		setAttrVal("Name_phyadm", Name_phyadm);
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
		return "Id_peregquery";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeIpRegQueryDODesc.class);
	}
	
}