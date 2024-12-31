package iih.mp.dg.opdrugmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opdrugmp.d.desc.OpDrugExeItemDODesc;
import java.math.BigDecimal;

/**
 * 门诊药品执行明细 DO数据 
 * 
 */
public class OpDrugExeItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//门诊药品执行明细主键
	public static final String ID_DGOPDT= "Id_dgopdt";
	//门诊药品执行
	public static final String ID_DGOP= "Id_dgop";
	//药品服务
	public static final String ID_ORSRV= "Id_orsrv";
	//药品物品
	public static final String ID_MM= "Id_mm";
	//执行付数
	public static final String QUAN_PAIR_MP= "Quan_pair_mp";
	//执行数量
	public static final String QUAN_MP= "Quan_mp";
	//已退数量
	public static final String QUAN_BK= "Quan_bk";
	//单位_当前包装
	public static final String ID_PKGU_CUR= "Id_pkgu_cur";
	//单价_当前包装
	public static final String PRICE_PKGU_CUR= "Price_pkgu_cur";
	//应收金额
	public static final String AMT_DUE= "Amt_due";
	//实收金额
	public static final String AMT_REAL= "Amt_real";
	//实际执行窗口
	public static final String ID_QUESITE_ACT= "Id_quesite_act";
	//退费标志
	public static final String FG_BKFEE= "Fg_bkfee";
	//唯一码
	public static final String ONLYCODE= "Onlycode";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//批号描述
	public static final String DES_BAT= "Des_bat";
	//已退付数
	public static final String QUAN_PAIR_BK= "Quan_pair_bk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 门诊药品执行明细主键
	 * @return String
	 */
	public String getId_dgopdt() {
		return ((String) getAttrVal("Id_dgopdt"));
	}	
	/**
	 * 门诊药品执行明细主键
	 * @param Id_dgopdt
	 */
	public void setId_dgopdt(String Id_dgopdt) {
		setAttrVal("Id_dgopdt", Id_dgopdt);
	}
	/**
	 * 门诊药品执行
	 * @return String
	 */
	public String getId_dgop() {
		return ((String) getAttrVal("Id_dgop"));
	}	
	/**
	 * 门诊药品执行
	 * @param Id_dgop
	 */
	public void setId_dgop(String Id_dgop) {
		setAttrVal("Id_dgop", Id_dgop);
	}
	/**
	 * 药品服务
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 药品服务
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 药品物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 药品物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 执行付数
	 * @return Integer
	 */
	public Integer getQuan_pair_mp() {
		return ((Integer) getAttrVal("Quan_pair_mp"));
	}	
	/**
	 * 执行付数
	 * @param Quan_pair_mp
	 */
	public void setQuan_pair_mp(Integer Quan_pair_mp) {
		setAttrVal("Quan_pair_mp", Quan_pair_mp);
	}
	/**
	 * 执行数量
	 * @return FDouble
	 */
	public FDouble getQuan_mp() {
		return ((FDouble) getAttrVal("Quan_mp"));
	}	
	/**
	 * 执行数量
	 * @param Quan_mp
	 */
	public void setQuan_mp(FDouble Quan_mp) {
		setAttrVal("Quan_mp", Quan_mp);
	}
	/**
	 * 已退数量
	 * @return FDouble
	 */
	public FDouble getQuan_bk() {
		return ((FDouble) getAttrVal("Quan_bk"));
	}	
	/**
	 * 已退数量
	 * @param Quan_bk
	 */
	public void setQuan_bk(FDouble Quan_bk) {
		setAttrVal("Quan_bk", Quan_bk);
	}
	/**
	 * 单位_当前包装
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}	
	/**
	 * 单位_当前包装
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 单价_当前包装
	 * @return FDouble
	 */
	public FDouble getPrice_pkgu_cur() {
		return ((FDouble) getAttrVal("Price_pkgu_cur"));
	}	
	/**
	 * 单价_当前包装
	 * @param Price_pkgu_cur
	 */
	public void setPrice_pkgu_cur(FDouble Price_pkgu_cur) {
		setAttrVal("Price_pkgu_cur", Price_pkgu_cur);
	}
	/**
	 * 应收金额
	 * @return FDouble
	 */
	public FDouble getAmt_due() {
		return ((FDouble) getAttrVal("Amt_due"));
	}	
	/**
	 * 应收金额
	 * @param Amt_due
	 */
	public void setAmt_due(FDouble Amt_due) {
		setAttrVal("Amt_due", Amt_due);
	}
	/**
	 * 实收金额
	 * @return FDouble
	 */
	public FDouble getAmt_real() {
		return ((FDouble) getAttrVal("Amt_real"));
	}	
	/**
	 * 实收金额
	 * @param Amt_real
	 */
	public void setAmt_real(FDouble Amt_real) {
		setAttrVal("Amt_real", Amt_real);
	}
	/**
	 * 实际执行窗口
	 * @return String
	 */
	public String getId_quesite_act() {
		return ((String) getAttrVal("Id_quesite_act"));
	}	
	/**
	 * 实际执行窗口
	 * @param Id_quesite_act
	 */
	public void setId_quesite_act(String Id_quesite_act) {
		setAttrVal("Id_quesite_act", Id_quesite_act);
	}
	/**
	 * 退费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bkfee() {
		return ((FBoolean) getAttrVal("Fg_bkfee"));
	}	
	/**
	 * 退费标志
	 * @param Fg_bkfee
	 */
	public void setFg_bkfee(FBoolean Fg_bkfee) {
		setAttrVal("Fg_bkfee", Fg_bkfee);
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
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 批号描述
	 * @return String
	 */
	public String getDes_bat() {
		return ((String) getAttrVal("Des_bat"));
	}	
	/**
	 * 批号描述
	 * @param Des_bat
	 */
	public void setDes_bat(String Des_bat) {
		setAttrVal("Des_bat", Des_bat);
	}
	/**
	 * 已退付数
	 * @return Integer
	 */
	public Integer getQuan_pair_bk() {
		return ((Integer) getAttrVal("Quan_pair_bk"));
	}	
	/**
	 * 已退付数
	 * @param Quan_pair_bk
	 */
	public void setQuan_pair_bk(Integer Quan_pair_bk) {
		setAttrVal("Quan_pair_bk", Quan_pair_bk);
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
		return "Id_dgopdt";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_op_dt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpDrugExeItemDODesc.class);
	}
	
}