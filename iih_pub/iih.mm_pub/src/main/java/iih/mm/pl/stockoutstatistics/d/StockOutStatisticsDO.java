package iih.mm.pl.stockoutstatistics.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.pl.stockoutstatistics.d.desc.StockOutStatisticsDODesc;
import java.math.BigDecimal;

/**
 * 出库统计表 DO数据 
 * 
 */
public class StockOutStatisticsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//出库汇总表主键
	public static final String ID_STAT_OUT= "Id_stat_out";
	//机构
	public static final String ID_ORG= "Id_org";
	//仓库
	public static final String ID_WH= "Id_wh";
	//物品id
	public static final String ID_MM= "Id_mm";
	//1天销量
	public static final String QUAN_1DAY= "Quan_1day";
	//2天销量
	public static final String QUAN_2DAY= "Quan_2day";
	//3天销量
	public static final String QUAN_3DAY= "Quan_3day";
	//4天销量
	public static final String QUAN_4DAY= "Quan_4day";
	//5天销量
	public static final String QUAN_5DAY= "Quan_5day";
	//6天销量
	public static final String QUAN_6DAY= "Quan_6day";
	//7天销量
	public static final String QUAN_7DAY= "Quan_7day";
	//14天销量
	public static final String QUAN_14DAY= "Quan_14day";
	//21天销量
	public static final String QUAN_21DAY= "Quan_21day";
	//28天销量
	public static final String QUAN_28DAY= "Quan_28day";
	//90天销量
	public static final String QUAN_90DAY= "Quan_90day";
	//60天销量
	public static final String QUAN_60DAY= "Quan_60day";
	//30天销量
	public static final String QUAN_30DAY= "Quan_30day";
	//本月销量
	public static final String QUAN_CURMON= "Quan_curmon";
	//上月销量
	public static final String QUAN_2NDMON= "Quan_2ndmon";
	//上上月销量
	public static final String QUAN_3RDMON= "Quan_3rdmon";
	//7天发药
	public static final String QUAN_7DAY_DISP= "Quan_7day_disp";
	//14天发药
	public static final String QUAN_14DAY_DISP= "Quan_14day_disp";
	//统计时间
	public static final String DT_STAT= "Dt_stat";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//仓库编码
	public static final String WH_CODE= "Wh_code";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//物品编码
	public static final String MM_CODE= "Mm_code";
	//物品名称
	public static final String MM_NAME= "Mm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 出库汇总表主键
	 * @return String
	 */
	public String getId_stat_out() {
		return ((String) getAttrVal("Id_stat_out"));
	}	
	/**
	 * 出库汇总表主键
	 * @param Id_stat_out
	 */
	public void setId_stat_out(String Id_stat_out) {
		setAttrVal("Id_stat_out", Id_stat_out);
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
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 1天销量
	 * @return FDouble
	 */
	public FDouble getQuan_1day() {
		return ((FDouble) getAttrVal("Quan_1day"));
	}	
	/**
	 * 1天销量
	 * @param Quan_1day
	 */
	public void setQuan_1day(FDouble Quan_1day) {
		setAttrVal("Quan_1day", Quan_1day);
	}
	/**
	 * 2天销量
	 * @return FDouble
	 */
	public FDouble getQuan_2day() {
		return ((FDouble) getAttrVal("Quan_2day"));
	}	
	/**
	 * 2天销量
	 * @param Quan_2day
	 */
	public void setQuan_2day(FDouble Quan_2day) {
		setAttrVal("Quan_2day", Quan_2day);
	}
	/**
	 * 3天销量
	 * @return FDouble
	 */
	public FDouble getQuan_3day() {
		return ((FDouble) getAttrVal("Quan_3day"));
	}	
	/**
	 * 3天销量
	 * @param Quan_3day
	 */
	public void setQuan_3day(FDouble Quan_3day) {
		setAttrVal("Quan_3day", Quan_3day);
	}
	/**
	 * 4天销量
	 * @return FDouble
	 */
	public FDouble getQuan_4day() {
		return ((FDouble) getAttrVal("Quan_4day"));
	}	
	/**
	 * 4天销量
	 * @param Quan_4day
	 */
	public void setQuan_4day(FDouble Quan_4day) {
		setAttrVal("Quan_4day", Quan_4day);
	}
	/**
	 * 5天销量
	 * @return FDouble
	 */
	public FDouble getQuan_5day() {
		return ((FDouble) getAttrVal("Quan_5day"));
	}	
	/**
	 * 5天销量
	 * @param Quan_5day
	 */
	public void setQuan_5day(FDouble Quan_5day) {
		setAttrVal("Quan_5day", Quan_5day);
	}
	/**
	 * 6天销量
	 * @return FDouble
	 */
	public FDouble getQuan_6day() {
		return ((FDouble) getAttrVal("Quan_6day"));
	}	
	/**
	 * 6天销量
	 * @param Quan_6day
	 */
	public void setQuan_6day(FDouble Quan_6day) {
		setAttrVal("Quan_6day", Quan_6day);
	}
	/**
	 * 7天销量
	 * @return FDouble
	 */
	public FDouble getQuan_7day() {
		return ((FDouble) getAttrVal("Quan_7day"));
	}	
	/**
	 * 7天销量
	 * @param Quan_7day
	 */
	public void setQuan_7day(FDouble Quan_7day) {
		setAttrVal("Quan_7day", Quan_7day);
	}
	/**
	 * 14天销量
	 * @return FDouble
	 */
	public FDouble getQuan_14day() {
		return ((FDouble) getAttrVal("Quan_14day"));
	}	
	/**
	 * 14天销量
	 * @param Quan_14day
	 */
	public void setQuan_14day(FDouble Quan_14day) {
		setAttrVal("Quan_14day", Quan_14day);
	}
	/**
	 * 21天销量
	 * @return FDouble
	 */
	public FDouble getQuan_21day() {
		return ((FDouble) getAttrVal("Quan_21day"));
	}	
	/**
	 * 21天销量
	 * @param Quan_21day
	 */
	public void setQuan_21day(FDouble Quan_21day) {
		setAttrVal("Quan_21day", Quan_21day);
	}
	/**
	 * 28天销量
	 * @return FDouble
	 */
	public FDouble getQuan_28day() {
		return ((FDouble) getAttrVal("Quan_28day"));
	}	
	/**
	 * 28天销量
	 * @param Quan_28day
	 */
	public void setQuan_28day(FDouble Quan_28day) {
		setAttrVal("Quan_28day", Quan_28day);
	}
	/**
	 * 90天销量
	 * @return FDouble
	 */
	public FDouble getQuan_90day() {
		return ((FDouble) getAttrVal("Quan_90day"));
	}	
	/**
	 * 90天销量
	 * @param Quan_90day
	 */
	public void setQuan_90day(FDouble Quan_90day) {
		setAttrVal("Quan_90day", Quan_90day);
	}
	/**
	 * 60天销量
	 * @return FDouble
	 */
	public FDouble getQuan_60day() {
		return ((FDouble) getAttrVal("Quan_60day"));
	}	
	/**
	 * 60天销量
	 * @param Quan_60day
	 */
	public void setQuan_60day(FDouble Quan_60day) {
		setAttrVal("Quan_60day", Quan_60day);
	}
	/**
	 * 30天销量
	 * @return FDouble
	 */
	public FDouble getQuan_30day() {
		return ((FDouble) getAttrVal("Quan_30day"));
	}	
	/**
	 * 30天销量
	 * @param Quan_30day
	 */
	public void setQuan_30day(FDouble Quan_30day) {
		setAttrVal("Quan_30day", Quan_30day);
	}
	/**
	 * 本月销量
	 * @return FDouble
	 */
	public FDouble getQuan_curmon() {
		return ((FDouble) getAttrVal("Quan_curmon"));
	}	
	/**
	 * 本月销量
	 * @param Quan_curmon
	 */
	public void setQuan_curmon(FDouble Quan_curmon) {
		setAttrVal("Quan_curmon", Quan_curmon);
	}
	/**
	 * 上月销量
	 * @return FDouble
	 */
	public FDouble getQuan_2ndmon() {
		return ((FDouble) getAttrVal("Quan_2ndmon"));
	}	
	/**
	 * 上月销量
	 * @param Quan_2ndmon
	 */
	public void setQuan_2ndmon(FDouble Quan_2ndmon) {
		setAttrVal("Quan_2ndmon", Quan_2ndmon);
	}
	/**
	 * 上上月销量
	 * @return FDouble
	 */
	public FDouble getQuan_3rdmon() {
		return ((FDouble) getAttrVal("Quan_3rdmon"));
	}	
	/**
	 * 上上月销量
	 * @param Quan_3rdmon
	 */
	public void setQuan_3rdmon(FDouble Quan_3rdmon) {
		setAttrVal("Quan_3rdmon", Quan_3rdmon);
	}
	/**
	 * 7天发药
	 * @return FDouble
	 */
	public FDouble getQuan_7day_disp() {
		return ((FDouble) getAttrVal("Quan_7day_disp"));
	}	
	/**
	 * 7天发药
	 * @param Quan_7day_disp
	 */
	public void setQuan_7day_disp(FDouble Quan_7day_disp) {
		setAttrVal("Quan_7day_disp", Quan_7day_disp);
	}
	/**
	 * 14天发药
	 * @return FDouble
	 */
	public FDouble getQuan_14day_disp() {
		return ((FDouble) getAttrVal("Quan_14day_disp"));
	}	
	/**
	 * 14天发药
	 * @param Quan_14day_disp
	 */
	public void setQuan_14day_disp(FDouble Quan_14day_disp) {
		setAttrVal("Quan_14day_disp", Quan_14day_disp);
	}
	/**
	 * 统计时间
	 * @return FDateTime
	 */
	public FDateTime getDt_stat() {
		return ((FDateTime) getAttrVal("Dt_stat"));
	}	
	/**
	 * 统计时间
	 * @param Dt_stat
	 */
	public void setDt_stat(FDateTime Dt_stat) {
		setAttrVal("Dt_stat", Dt_stat);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 仓库编码
	 * @return String
	 */
	public String getWh_code() {
		return ((String) getAttrVal("Wh_code"));
	}	
	/**
	 * 仓库编码
	 * @param Wh_code
	 */
	public void setWh_code(String Wh_code) {
		setAttrVal("Wh_code", Wh_code);
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
		return "Id_stat_out";
	}
	
	@Override
	public String getTableName() {	  
		return "mm_stat_out";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockOutStatisticsDODesc.class);
	}
	
}