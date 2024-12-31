package iih.mm.qy.validperiod.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.validperiod.d.desc.ValidPeriodViewDesc;
import java.math.BigDecimal;

/**
 * 有效期查询 DO数据 
 * 
 */
public class ValidPeriodView extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结存主键
	public static final String ID_BL= "Id_bl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库
	public static final String ID_WH= "Id_wh";
	//物品
	public static final String ID_MM= "Id_mm";
	//物品医疗类型
	public static final String ID_MMTP= "Id_mmtp";
	//物品分类
	public static final String ID_MMCA= "Id_mmca";
	//生产厂家
	public static final String ID_SUP= "Id_sup";
	//批次
	public static final String BATCH= "Batch";
	//失效期
	public static final String DATE_EXPI= "Date_expi";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//基本包装单位
	public static final String ID_UNIT_PKGBASE= "Id_unit_pkgbase";
	//实际包装单位
	public static final String ID_UNIT_PKGACT= "Id_unit_pkgact";
	//进价_基本单位
	public static final String PRI_BASE= "Pri_base";
	//进价_实际单位
	public static final String PRI_ACT= "Pri_act";
	//售价_基本单位
	public static final String PRI_SA_BASE= "Pri_sa_base";
	//售价_实际单位
	public static final String PRI_SA= "Pri_sa";
	//现存量_基本单位
	public static final String QUAN_STOCK= "Quan_stock";
	//现存量_实际单位
	public static final String QUAN_STOCKACT= "Quan_stockact";
	//预留数量_基本单位
	public static final String QUAN_RESERVE= "Quan_reserve";
	//预留数量_实际单位
	public static final String QUAN_RESERVEACT= "Quan_reserveact";
	//可用数量_基本单位
	public static final String QUAN_USABLE= "Quan_usable";
	//可用数量_实际单位
	public static final String QUAN_USABLEACT= "Quan_usableact";
	//成本金额
	public static final String AMT_COST= "Amt_cost";
	//距离失效天数
	public static final String INVALID_DT= "Invalid_dt";
	//打印名
	public static final String PRINTNAME= "Printname";
	//通用名
	public static final String SRV_NAME= "Srv_name";
	//机构名称
	public static final String ORG_NAME= "Org_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	//物品规格
	public static final String MM_SPEC= "Mm_spec";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//医疗物品类型名
	public static final String MMTP_NAME= "Mmtp_name";
	//物品分类名
	public static final String MMCA_NAME= "Mmca_name";
	//生产厂商名
	public static final String SUP_NAME= "Sup_name";
	//包装单位名称
	public static final String PKGBASE_NAME= "Pkgbase_name";
	//包装单位名称
	public static final String PKGACT_NAME= "Pkgact_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结存主键
	 * @return String
	 */
	public String getId_bl() {
		return ((String) getAttrVal("Id_bl"));
	}	
	/**
	 * 结存主键
	 * @param Id_bl
	 */
	public void setId_bl(String Id_bl) {
		setAttrVal("Id_bl", Id_bl);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
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
	 * 物品医疗类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	/**
	 * 物品医疗类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品分类
	 * @return String
	 */
	public String getId_mmca() {
		return ((String) getAttrVal("Id_mmca"));
	}	
	/**
	 * 物品分类
	 * @param Id_mmca
	 */
	public void setId_mmca(String Id_mmca) {
		setAttrVal("Id_mmca", Id_mmca);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	/**
	 * 生产厂家
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 批次
	 * @return String
	 */
	public String getBatch() {
		return ((String) getAttrVal("Batch"));
	}	
	/**
	 * 批次
	 * @param Batch
	 */
	public void setBatch(String Batch) {
		setAttrVal("Batch", Batch);
	}
	/**
	 * 失效期
	 * @return FDate
	 */
	public FDate getDate_expi() {
		return ((FDate) getAttrVal("Date_expi"));
	}	
	/**
	 * 失效期
	 * @param Date_expi
	 */
	public void setDate_expi(FDate Date_expi) {
		setAttrVal("Date_expi", Date_expi);
	}
	/**
	 * 唯一码
	 * @return String
	 */
	public String getOnlycode() {
		return ((String) getAttrVal("Onlycode"));
	}	
	/**
	 * 唯一码
	 * @param Onlycode
	 */
	public void setOnlycode(String Onlycode) {
		setAttrVal("Onlycode", Onlycode);
	}
	/**
	 * 基本包装单位
	 * @return String
	 */
	public String getId_unit_pkgbase() {
		return ((String) getAttrVal("Id_unit_pkgbase"));
	}	
	/**
	 * 基本包装单位
	 * @param Id_unit_pkgbase
	 */
	public void setId_unit_pkgbase(String Id_unit_pkgbase) {
		setAttrVal("Id_unit_pkgbase", Id_unit_pkgbase);
	}
	/**
	 * 实际包装单位
	 * @return String
	 */
	public String getId_unit_pkgact() {
		return ((String) getAttrVal("Id_unit_pkgact"));
	}	
	/**
	 * 实际包装单位
	 * @param Id_unit_pkgact
	 */
	public void setId_unit_pkgact(String Id_unit_pkgact) {
		setAttrVal("Id_unit_pkgact", Id_unit_pkgact);
	}
	/**
	 * 进价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_base() {
		return ((FDouble) getAttrVal("Pri_base"));
	}	
	/**
	 * 进价_基本单位
	 * @param Pri_base
	 */
	public void setPri_base(FDouble Pri_base) {
		setAttrVal("Pri_base", Pri_base);
	}
	/**
	 * 进价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_act() {
		return ((FDouble) getAttrVal("Pri_act"));
	}	
	/**
	 * 进价_实际单位
	 * @param Pri_act
	 */
	public void setPri_act(FDouble Pri_act) {
		setAttrVal("Pri_act", Pri_act);
	}
	/**
	 * 售价_基本单位
	 * @return FDouble
	 */
	public FDouble getPri_sa_base() {
		return ((FDouble) getAttrVal("Pri_sa_base"));
	}	
	/**
	 * 售价_基本单位
	 * @param Pri_sa_base
	 */
	public void setPri_sa_base(FDouble Pri_sa_base) {
		setAttrVal("Pri_sa_base", Pri_sa_base);
	}
	/**
	 * 售价_实际单位
	 * @return FDouble
	 */
	public FDouble getPri_sa() {
		return ((FDouble) getAttrVal("Pri_sa"));
	}	
	/**
	 * 售价_实际单位
	 * @param Pri_sa
	 */
	public void setPri_sa(FDouble Pri_sa) {
		setAttrVal("Pri_sa", Pri_sa);
	}
	/**
	 * 现存量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}	
	/**
	 * 现存量_基本单位
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 现存量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_stockact() {
		return ((FDouble) getAttrVal("Quan_stockact"));
	}	
	/**
	 * 现存量_实际单位
	 * @param Quan_stockact
	 */
	public void setQuan_stockact(FDouble Quan_stockact) {
		setAttrVal("Quan_stockact", Quan_stockact);
	}
	/**
	 * 预留数量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_reserve() {
		return ((FDouble) getAttrVal("Quan_reserve"));
	}	
	/**
	 * 预留数量_基本单位
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(FDouble Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 预留数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_reserveact() {
		return ((FDouble) getAttrVal("Quan_reserveact"));
	}	
	/**
	 * 预留数量_实际单位
	 * @param Quan_reserveact
	 */
	public void setQuan_reserveact(FDouble Quan_reserveact) {
		setAttrVal("Quan_reserveact", Quan_reserveact);
	}
	/**
	 * 可用数量_基本单位
	 * @return FDouble
	 */
	public FDouble getQuan_usable() {
		return ((FDouble) getAttrVal("Quan_usable"));
	}	
	/**
	 * 可用数量_基本单位
	 * @param Quan_usable
	 */
	public void setQuan_usable(FDouble Quan_usable) {
		setAttrVal("Quan_usable", Quan_usable);
	}
	/**
	 * 可用数量_实际单位
	 * @return FDouble
	 */
	public FDouble getQuan_usableact() {
		return ((FDouble) getAttrVal("Quan_usableact"));
	}	
	/**
	 * 可用数量_实际单位
	 * @param Quan_usableact
	 */
	public void setQuan_usableact(FDouble Quan_usableact) {
		setAttrVal("Quan_usableact", Quan_usableact);
	}
	/**
	 * 成本金额
	 * @return FDouble
	 */
	public FDouble getAmt_cost() {
		return ((FDouble) getAttrVal("Amt_cost"));
	}	
	/**
	 * 成本金额
	 * @param Amt_cost
	 */
	public void setAmt_cost(FDouble Amt_cost) {
		setAttrVal("Amt_cost", Amt_cost);
	}
	/**
	 * 距离失效天数
	 * @return Integer
	 */
	public Integer getInvalid_dt() {
		return ((Integer) getAttrVal("Invalid_dt"));
	}	
	/**
	 * 距离失效天数
	 * @param Invalid_dt
	 */
	public void setInvalid_dt(Integer Invalid_dt) {
		setAttrVal("Invalid_dt", Invalid_dt);
	}
	/**
	 * 打印名
	 * @return String
	 */
	public String getPrintname() {
		return ((String) getAttrVal("Printname"));
	}	
	/**
	 * 打印名
	 * @param Printname
	 */
	public void setPrintname(String Printname) {
		setAttrVal("Printname", Printname);
	}
	/**
	 * 通用名
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	/**
	 * 通用名
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * 机构名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 机构名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
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
	 * 物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	/**
	 * 物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
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
	 * 医疗物品类型名
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	/**
	 * 医疗物品类型名
	 * @param Mmtp_name
	 */
	public void setMmtp_name(String Mmtp_name) {
		setAttrVal("Mmtp_name", Mmtp_name);
	}
	/**
	 * 物品分类名
	 * @return String
	 */
	public String getMmca_name() {
		return ((String) getAttrVal("Mmca_name"));
	}	
	/**
	 * 物品分类名
	 * @param Mmca_name
	 */
	public void setMmca_name(String Mmca_name) {
		setAttrVal("Mmca_name", Mmca_name);
	}
	/**
	 * 生产厂商名
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	/**
	 * 生产厂商名
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getPkgbase_name() {
		return ((String) getAttrVal("Pkgbase_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Pkgbase_name
	 */
	public void setPkgbase_name(String Pkgbase_name) {
		setAttrVal("Pkgbase_name", Pkgbase_name);
	}
	/**
	 * 包装单位名称
	 * @return String
	 */
	public String getPkgact_name() {
		return ((String) getAttrVal("Pkgact_name"));
	}	
	/**
	 * 包装单位名称
	 * @param Pkgact_name
	 */
	public void setPkgact_name(String Pkgact_name) {
		setAttrVal("Pkgact_name", Pkgact_name);
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
		return "Id_bl";
	}
	
	@Override
	public String getTableName() {	  
		return "V_MM_VALIDPERIOD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ValidPeriodViewDesc.class);
	}
	
}