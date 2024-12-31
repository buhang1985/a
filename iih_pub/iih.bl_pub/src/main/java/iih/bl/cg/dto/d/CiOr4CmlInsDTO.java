package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊处方信息表 DTO数据 
 * 
 */
public class CiOr4CmlInsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊号
	 * @return String
	 */
	public String getVisit_no() {
		return ((String) getAttrVal("Visit_no"));
	}
	/**
	 * 就诊号
	 * @param Visit_no
	 */
	public void setVisit_no(String Visit_no) {
		setAttrVal("Visit_no", Visit_no);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPid() {
		return ((String) getAttrVal("Pid"));
	}
	/**
	 * 患者ID
	 * @param Pid
	 */
	public void setPid(String Pid) {
		setAttrVal("Pid", Pid);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getRecipeno() {
		return ((String) getAttrVal("Recipeno"));
	}
	/**
	 * 处方号
	 * @param Recipeno
	 */
	public void setRecipeno(String Recipeno) {
		setAttrVal("Recipeno", Recipeno);
	}
	/**
	 * 处方类别
	 * @return String
	 */
	public String getRecipe_cat() {
		return ((String) getAttrVal("Recipe_cat"));
	}
	/**
	 * 处方类别
	 * @param Recipe_cat
	 */
	public void setRecipe_cat(String Recipe_cat) {
		setAttrVal("Recipe_cat", Recipe_cat);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getRecipetype() {
		return ((String) getAttrVal("Recipetype"));
	}
	/**
	 * 处方类型
	 * @param Recipetype
	 */
	public void setRecipetype(String Recipetype) {
		setAttrVal("Recipetype", Recipetype);
	}
	/**
	 * 开方医生
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 开方医生
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 开方医生姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 开方医生姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 处方时间
	 * @return String
	 */
	public String getRecipedate() {
		return ((String) getAttrVal("Recipedate"));
	}
	/**
	 * 处方时间
	 * @param Recipedate
	 */
	public void setRecipedate(String Recipedate) {
		setAttrVal("Recipedate", Recipedate);
	}
	/**
	 * his交易流水号
	 * @return String
	 */
	public String getHistradeno() {
		return ((String) getAttrVal("Histradeno"));
	}
	/**
	 * his交易流水号
	 * @param Histradeno
	 */
	public void setHistradeno(String Histradeno) {
		setAttrVal("Histradeno", Histradeno);
	}
}