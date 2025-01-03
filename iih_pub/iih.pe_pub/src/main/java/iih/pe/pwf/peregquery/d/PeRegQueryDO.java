package iih.pe.pwf.peregquery.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.peregquery.d.desc.PeRegQueryDODesc;
import java.math.BigDecimal;

/**
 * 体检登记名单检索 DO数据 
 * 
 */
public class PeRegQueryDO extends BaseDO {
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
	public static final String ST_GUIDER= "St_guider";
	//条码打印标识
	public static final String ST_BARCODE= "St_barcode";
	//团体预约单ID
	public static final String ID_CORPAPPT= "Id_corpappt";
	//团体分组ID
	public static final String ID_CORPGRP= "Id_corpgrp";
	//多分组编码
	public static final String MULTIGROUP= "Multigroup";
	//单位编码
	public static final String CODE_CORP= "Code_corp";
	//单位名称
	public static final String NAME_CORP= "Name_corp";
	//健康管理师编码
	public static final String CODE_HMER= "Code_hmer";
	//健康管理师姓名
	public static final String NAME_HMER= "Name_hmer";
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
	 * @return Integer
	 */
	public Integer getSt_guider() {
		return ((Integer) getAttrVal("St_guider"));
	}	
	/**
	 * 导引单打印标识
	 * @param St_guider
	 */
	public void setSt_guider(Integer St_guider) {
		setAttrVal("St_guider", St_guider);
	}
	/**
	 * 条码打印标识
	 * @return Integer
	 */
	public Integer getSt_barcode() {
		return ((Integer) getAttrVal("St_barcode"));
	}	
	/**
	 * 条码打印标识
	 * @param St_barcode
	 */
	public void setSt_barcode(Integer St_barcode) {
		setAttrVal("St_barcode", St_barcode);
	}
	/**
	 * 团体预约单ID
	 * @return String
	 */
	public String getId_corpappt() {
		return ((String) getAttrVal("Id_corpappt"));
	}	
	/**
	 * 团体预约单ID
	 * @param Id_corpappt
	 */
	public void setId_corpappt(String Id_corpappt) {
		setAttrVal("Id_corpappt", Id_corpappt);
	}
	/**
	 * 团体分组ID
	 * @return String
	 */
	public String getId_corpgrp() {
		return ((String) getAttrVal("Id_corpgrp"));
	}	
	/**
	 * 团体分组ID
	 * @param Id_corpgrp
	 */
	public void setId_corpgrp(String Id_corpgrp) {
		setAttrVal("Id_corpgrp", Id_corpgrp);
	}
	/**
	 * 多分组编码
	 * @return String
	 */
	public String getMultigroup() {
		return ((String) getAttrVal("Multigroup"));
	}	
	/**
	 * 多分组编码
	 * @param Multigroup
	 */
	public void setMultigroup(String Multigroup) {
		setAttrVal("Multigroup", Multigroup);
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
		return DescManager.getInstance().getDODesc(PeRegQueryDODesc.class);
	}
	
}