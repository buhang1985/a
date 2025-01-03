package iih.mm.qy.stockblinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.qy.stockblinfo.d.desc.StockBlQueryViewDesc;
import java.math.BigDecimal;

/**
 * 物品结存信息查询 DO数据 
 * 
 */
public class StockBlQueryView extends BaseDO {
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
	//货位
	public static final String ID_LOC= "Id_loc";
	//医疗服务
	public static final String ID_SRV= "Id_srv";
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
	//换算系数
	public static final String FACTOR= "Factor";
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
	//最低存储
	public static final String LOWNUM= "Lownum";
	//最高存储
	public static final String MAXNUM= "Maxnum";
	//警告标识
	public static final String SD_WARN= "Sd_warn";
	//0库存标识
	public static final String FG_ZERO= "Fg_zero";
	//毒麻标识
	public static final String FG_POIS= "Fg_pois";
	//停开标识
	public static final String FG_OUT= "Fg_out";
	//预留标识
	public static final String FG_RESERVE= "Fg_reserve";
	//停用标识
	public static final String FG_STOP= "Fg_stop";
	//调价停用标识
	public static final String FG_STOP_CHGPRI= "Fg_stop_chgpri";
	//成本金额
	public static final String AMT_COST= "Amt_cost";
	//零售金额
	public static final String AMT_SA= "Amt_sa";
	//数量合计
	public static final String QUAN_SUM= "Quan_sum";
	//合计金额_成本
	public static final String AMT_SUM= "Amt_sum";
	//合计金额_售价
	public static final String AMT_SUM_SA= "Amt_sum_sa";
	//数量合计_当前页
	public static final String QUAN_SUM_CURPAGE= "Quan_sum_curpage";
	//合计金额_成本_当前页
	public static final String AMT_SUM_CURPAGE= "Amt_sum_curpage";
	//合计金额_售价_当前页
	public static final String AMT_SUM_SA_CURPAGE= "Amt_sum_sa_curpage";
	//基本药物范围
	public static final String SD_BASEDRUGRANGE= "Sd_basedrugrange";
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
	//货位编码
	public static final String LOC_CODE= "Loc_code";
	//货位名称
	public static final String LOC_NAME= "Loc_name";
	//服务名称
	public static final String SRV_NAME= "Srv_name";
	//医疗物品类型名称
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
	 * 货位
	 * @return String
	 */
	public String getId_loc() {
		return ((String) getAttrVal("Id_loc"));
	}	
	/**
	 * 货位
	 * @param Id_loc
	 */
	public void setId_loc(String Id_loc) {
		setAttrVal("Id_loc", Id_loc);
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
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
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
	 * 最低存储
	 * @return FDouble
	 */
	public FDouble getLownum() {
		return ((FDouble) getAttrVal("Lownum"));
	}	
	/**
	 * 最低存储
	 * @param Lownum
	 */
	public void setLownum(FDouble Lownum) {
		setAttrVal("Lownum", Lownum);
	}
	/**
	 * 最高存储
	 * @return FDouble
	 */
	public FDouble getMaxnum() {
		return ((FDouble) getAttrVal("Maxnum"));
	}	
	/**
	 * 最高存储
	 * @param Maxnum
	 */
	public void setMaxnum(FDouble Maxnum) {
		setAttrVal("Maxnum", Maxnum);
	}
	/**
	 * 警告标识
	 * @return String
	 */
	public String getSd_warn() {
		return ((String) getAttrVal("Sd_warn"));
	}	
	/**
	 * 警告标识
	 * @param Sd_warn
	 */
	public void setSd_warn(String Sd_warn) {
		setAttrVal("Sd_warn", Sd_warn);
	}
	/**
	 * 0库存标识
	 * @return String
	 */
	public String getFg_zero() {
		return ((String) getAttrVal("Fg_zero"));
	}	
	/**
	 * 0库存标识
	 * @param Fg_zero
	 */
	public void setFg_zero(String Fg_zero) {
		setAttrVal("Fg_zero", Fg_zero);
	}
	/**
	 * 毒麻标识
	 * @return String
	 */
	public String getFg_pois() {
		return ((String) getAttrVal("Fg_pois"));
	}	
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(String Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
	}
	/**
	 * 停开标识
	 * @return String
	 */
	public String getFg_out() {
		return ((String) getAttrVal("Fg_out"));
	}	
	/**
	 * 停开标识
	 * @param Fg_out
	 */
	public void setFg_out(String Fg_out) {
		setAttrVal("Fg_out", Fg_out);
	}
	/**
	 * 预留标识
	 * @return FBoolean
	 */
	public FBoolean getFg_reserve() {
		return ((FBoolean) getAttrVal("Fg_reserve"));
	}	
	/**
	 * 预留标识
	 * @param Fg_reserve
	 */
	public void setFg_reserve(FBoolean Fg_reserve) {
		setAttrVal("Fg_reserve", Fg_reserve);
	}
	/**
	 * 停用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	/**
	 * 停用标识
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 调价停用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_stop_chgpri() {
		return ((FBoolean) getAttrVal("Fg_stop_chgpri"));
	}	
	/**
	 * 调价停用标识
	 * @param Fg_stop_chgpri
	 */
	public void setFg_stop_chgpri(FBoolean Fg_stop_chgpri) {
		setAttrVal("Fg_stop_chgpri", Fg_stop_chgpri);
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
	 * 零售金额
	 * @return FDouble
	 */
	public FDouble getAmt_sa() {
		return ((FDouble) getAttrVal("Amt_sa"));
	}	
	/**
	 * 零售金额
	 * @param Amt_sa
	 */
	public void setAmt_sa(FDouble Amt_sa) {
		setAttrVal("Amt_sa", Amt_sa);
	}
	/**
	 * 数量合计
	 * @return FDouble
	 */
	public FDouble getQuan_sum() {
		return ((FDouble) getAttrVal("Quan_sum"));
	}	
	/**
	 * 数量合计
	 * @param Quan_sum
	 */
	public void setQuan_sum(FDouble Quan_sum) {
		setAttrVal("Quan_sum", Quan_sum);
	}
	/**
	 * 合计金额_成本
	 * @return FDouble
	 */
	public FDouble getAmt_sum() {
		return ((FDouble) getAttrVal("Amt_sum"));
	}	
	/**
	 * 合计金额_成本
	 * @param Amt_sum
	 */
	public void setAmt_sum(FDouble Amt_sum) {
		setAttrVal("Amt_sum", Amt_sum);
	}
	/**
	 * 合计金额_售价
	 * @return FDouble
	 */
	public FDouble getAmt_sum_sa() {
		return ((FDouble) getAttrVal("Amt_sum_sa"));
	}	
	/**
	 * 合计金额_售价
	 * @param Amt_sum_sa
	 */
	public void setAmt_sum_sa(FDouble Amt_sum_sa) {
		setAttrVal("Amt_sum_sa", Amt_sum_sa);
	}
	/**
	 * 数量合计_当前页
	 * @return FDouble
	 */
	public FDouble getQuan_sum_curpage() {
		return ((FDouble) getAttrVal("Quan_sum_curpage"));
	}	
	/**
	 * 数量合计_当前页
	 * @param Quan_sum_curpage
	 */
	public void setQuan_sum_curpage(FDouble Quan_sum_curpage) {
		setAttrVal("Quan_sum_curpage", Quan_sum_curpage);
	}
	/**
	 * 合计金额_成本_当前页
	 * @return FDouble
	 */
	public FDouble getAmt_sum_curpage() {
		return ((FDouble) getAttrVal("Amt_sum_curpage"));
	}	
	/**
	 * 合计金额_成本_当前页
	 * @param Amt_sum_curpage
	 */
	public void setAmt_sum_curpage(FDouble Amt_sum_curpage) {
		setAttrVal("Amt_sum_curpage", Amt_sum_curpage);
	}
	/**
	 * 合计金额_售价_当前页
	 * @return FDouble
	 */
	public FDouble getAmt_sum_sa_curpage() {
		return ((FDouble) getAttrVal("Amt_sum_sa_curpage"));
	}	
	/**
	 * 合计金额_售价_当前页
	 * @param Amt_sum_sa_curpage
	 */
	public void setAmt_sum_sa_curpage(FDouble Amt_sum_sa_curpage) {
		setAttrVal("Amt_sum_sa_curpage", Amt_sum_sa_curpage);
	}
	/**
	 * 基本药物范围
	 * @return String
	 */
	public String getSd_basedrugrange() {
		return ((String) getAttrVal("Sd_basedrugrange"));
	}	
	/**
	 * 基本药物范围
	 * @param Sd_basedrugrange
	 */
	public void setSd_basedrugrange(String Sd_basedrugrange) {
		setAttrVal("Sd_basedrugrange", Sd_basedrugrange);
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
	 * 货位编码
	 * @return String
	 */
	public String getLoc_code() {
		return ((String) getAttrVal("Loc_code"));
	}	
	/**
	 * 货位编码
	 * @param Loc_code
	 */
	public void setLoc_code(String Loc_code) {
		setAttrVal("Loc_code", Loc_code);
	}
	/**
	 * 货位名称
	 * @return String
	 */
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}	
	/**
	 * 货位名称
	 * @param Loc_name
	 */
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
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
	 * 医疗物品类型名称
	 * @return String
	 */
	public String getMmtp_name() {
		return ((String) getAttrVal("Mmtp_name"));
	}	
	/**
	 * 医疗物品类型名称
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
		return "V_MM_BL_QUERY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockBlQueryViewDesc.class);
	}
	
}