package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pedietplan.d.desc.PeDietPlanDayDODesc;
import java.math.BigDecimal;

/**
 * 体检每日饮食计划 DO数据 
 * 
 */
public class PeDietPlanDayDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检饮食计划周明细主键标识
	public static final String ID_PEDIETPLANDAY= "Id_pedietplanday";
	//体检饮食计划ID
	public static final String ID_PEDIETPLAN= "Id_pedietplan";
	//年
	public static final String YEAR= "Year";
	//周
	public static final String WEEK= "Week";
	//天
	public static final String DAY= "Day";
	//三餐
	public static final String THREEMEAL= "Threemeal";
	//体检饮食菜单定义ID
	public static final String ID_PEDISHES= "Id_pedishes";
	//食物成份ID
	public static final String ID_PEFOODCOMP= "Id_pefoodcomp";
	//量
	public static final String QTY= "Qty";
	//次序
	public static final String SORTNO= "Sortno";
	//编码
	public static final String CODE_PSN= "Code_psn";
	//名称
	public static final String NAME_PSN= "Name_psn";
	//膳食纤维
	public static final String FIBER= "Fiber";
	//食物名称
	public static final String NAME_DISH= "Name_dish";
	//编码
	public static final String CODE_DISH= "Code_dish";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检饮食计划周明细主键标识
	 * @return String
	 */
	public String getId_pedietplanday() {
		return ((String) getAttrVal("Id_pedietplanday"));
	}	
	/**
	 * 体检饮食计划周明细主键标识
	 * @param Id_pedietplanday
	 */
	public void setId_pedietplanday(String Id_pedietplanday) {
		setAttrVal("Id_pedietplanday", Id_pedietplanday);
	}
	/**
	 * 体检饮食计划ID
	 * @return String
	 */
	public String getId_pedietplan() {
		return ((String) getAttrVal("Id_pedietplan"));
	}	
	/**
	 * 体检饮食计划ID
	 * @param Id_pedietplan
	 */
	public void setId_pedietplan(String Id_pedietplan) {
		setAttrVal("Id_pedietplan", Id_pedietplan);
	}
	/**
	 * 年
	 * @return Integer
	 */
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	/**
	 * 年
	 * @param Year
	 */
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	/**
	 * 周
	 * @return Integer
	 */
	public Integer getWeek() {
		return ((Integer) getAttrVal("Week"));
	}	
	/**
	 * 周
	 * @param Week
	 */
	public void setWeek(Integer Week) {
		setAttrVal("Week", Week);
	}
	/**
	 * 天
	 * @return Integer
	 */
	public Integer getDay() {
		return ((Integer) getAttrVal("Day"));
	}	
	/**
	 * 天
	 * @param Day
	 */
	public void setDay(Integer Day) {
		setAttrVal("Day", Day);
	}
	/**
	 * 三餐
	 * @return Integer
	 */
	public Integer getThreemeal() {
		return ((Integer) getAttrVal("Threemeal"));
	}	
	/**
	 * 三餐
	 * @param Threemeal
	 */
	public void setThreemeal(Integer Threemeal) {
		setAttrVal("Threemeal", Threemeal);
	}
	/**
	 * 体检饮食菜单定义ID
	 * @return String
	 */
	public String getId_pedishes() {
		return ((String) getAttrVal("Id_pedishes"));
	}	
	/**
	 * 体检饮食菜单定义ID
	 * @param Id_pedishes
	 */
	public void setId_pedishes(String Id_pedishes) {
		setAttrVal("Id_pedishes", Id_pedishes);
	}
	/**
	 * 食物成份ID
	 * @return String
	 */
	public String getId_pefoodcomp() {
		return ((String) getAttrVal("Id_pefoodcomp"));
	}	
	/**
	 * 食物成份ID
	 * @param Id_pefoodcomp
	 */
	public void setId_pefoodcomp(String Id_pefoodcomp) {
		setAttrVal("Id_pefoodcomp", Id_pefoodcomp);
	}
	/**
	 * 量
	 * @return FDouble
	 */
	public FDouble getQty() {
		return ((FDouble) getAttrVal("Qty"));
	}	
	/**
	 * 量
	 * @param Qty
	 */
	public void setQty(FDouble Qty) {
		setAttrVal("Qty", Qty);
	}
	/**
	 * 次序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 次序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 名称
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 膳食纤维
	 * @return FDouble
	 */
	public FDouble getFiber() {
		return ((FDouble) getAttrVal("Fiber"));
	}	
	/**
	 * 膳食纤维
	 * @param Fiber
	 */
	public void setFiber(FDouble Fiber) {
		setAttrVal("Fiber", Fiber);
	}
	/**
	 * 食物名称
	 * @return String
	 */
	public String getName_dish() {
		return ((String) getAttrVal("Name_dish"));
	}	
	/**
	 * 食物名称
	 * @param Name_dish
	 */
	public void setName_dish(String Name_dish) {
		setAttrVal("Name_dish", Name_dish);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dish() {
		return ((String) getAttrVal("Code_dish"));
	}	
	/**
	 * 编码
	 * @param Code_dish
	 */
	public void setCode_dish(String Code_dish) {
		setAttrVal("Code_dish", Code_dish);
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
		return "Id_pedietplanday";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pedietplanday";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDietPlanDayDODesc.class);
	}
	
}