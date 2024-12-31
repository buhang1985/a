package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pedietplan.d.desc.PeDietDivideDODesc;
import java.math.BigDecimal;

/**
 * 体检三餐分配比例 DO数据 
 * 
 */
public class PeDietDivideDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检三餐分配比例主键标识
	public static final String ID_PEDIETDIVIDE= "Id_pedietdivide";
	//体检饮食计划ID
	public static final String ID_PEDIETPLAN= "Id_pedietplan";
	//三餐
	public static final String THREEMEAL= "Threemeal";
	//能量
	public static final String ENERGY= "Energy";
	//蛋白质
	public static final String PROTEIN= "Protein";
	//脂肪
	public static final String FAT= "Fat";
	//碳水化合物
	public static final String CARBOHYDRATE= "Carbohydrate";
	//主食
	public static final String STAPLEFOOD= "Staplefood";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检三餐分配比例主键标识
	 * @return String
	 */
	public String getId_pedietdivide() {
		return ((String) getAttrVal("Id_pedietdivide"));
	}	
	/**
	 * 体检三餐分配比例主键标识
	 * @param Id_pedietdivide
	 */
	public void setId_pedietdivide(String Id_pedietdivide) {
		setAttrVal("Id_pedietdivide", Id_pedietdivide);
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
	 * 能量
	 * @return FDouble
	 */
	public FDouble getEnergy() {
		return ((FDouble) getAttrVal("Energy"));
	}	
	/**
	 * 能量
	 * @param Energy
	 */
	public void setEnergy(FDouble Energy) {
		setAttrVal("Energy", Energy);
	}
	/**
	 * 蛋白质
	 * @return FDouble
	 */
	public FDouble getProtein() {
		return ((FDouble) getAttrVal("Protein"));
	}	
	/**
	 * 蛋白质
	 * @param Protein
	 */
	public void setProtein(FDouble Protein) {
		setAttrVal("Protein", Protein);
	}
	/**
	 * 脂肪
	 * @return FDouble
	 */
	public FDouble getFat() {
		return ((FDouble) getAttrVal("Fat"));
	}	
	/**
	 * 脂肪
	 * @param Fat
	 */
	public void setFat(FDouble Fat) {
		setAttrVal("Fat", Fat);
	}
	/**
	 * 碳水化合物
	 * @return FDouble
	 */
	public FDouble getCarbohydrate() {
		return ((FDouble) getAttrVal("Carbohydrate"));
	}	
	/**
	 * 碳水化合物
	 * @param Carbohydrate
	 */
	public void setCarbohydrate(FDouble Carbohydrate) {
		setAttrVal("Carbohydrate", Carbohydrate);
	}
	/**
	 * 主食
	 * @return FDouble
	 */
	public FDouble getStaplefood() {
		return ((FDouble) getAttrVal("Staplefood"));
	}	
	/**
	 * 主食
	 * @param Staplefood
	 */
	public void setStaplefood(FDouble Staplefood) {
		setAttrVal("Staplefood", Staplefood);
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
		return "Id_pedietdivide";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pedietdivide";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDietDivideDODesc.class);
	}
	
}