package iih.ci.mr.nu.dto.comm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 数据组 DTO数据 
 * 
 */
public class DgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 公共数据组ID
	 * @return String
	 */
	public String getId_dg() {
		return ((String) getAttrVal("Id_dg"));
	}
	/**
	 * 公共数据组ID
	 * @param Id_dg
	 */
	public void setId_dg(String Id_dg) {
		setAttrVal("Id_dg", Id_dg);
	}
	/**
	 * 父级数据组ID
	 * @return String
	 */
	public String getId_mrdg_pat() {
		return ((String) getAttrVal("Id_mrdg_pat"));
	}
	/**
	 * 父级数据组ID
	 * @param Id_mrdg_pat
	 */
	public void setId_mrdg_pat(String Id_mrdg_pat) {
		setAttrVal("Id_mrdg_pat", Id_mrdg_pat);
	}
	/**
	 * 医疗记录id
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 医疗记录id
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 数据组名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 数据组名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * DO全路径
	 * @return String
	 */
	public String getClassname() {
		return ((String) getAttrVal("Classname"));
	}
	/**
	 * DO全路径
	 * @param Classname
	 */
	public void setClassname(String Classname) {
		setAttrVal("Classname", Classname);
	}
	/**
	 * 数据组集合
	 * @return FArrayList
	 */
	public FArrayList getDgs() {
		return ((FArrayList) getAttrVal("Dgs"));
	}
	/**
	 * 数据组集合
	 * @param Dgs
	 */
	public void setDgs(FArrayList Dgs) {
		setAttrVal("Dgs", Dgs);
	}
	/**
	 * 数据元集合
	 * @return FArrayList
	 */
	public FArrayList getDes() {
		return ((FArrayList) getAttrVal("Des"));
	}
	/**
	 * 数据元集合
	 * @param Des
	 */
	public void setDes(FArrayList Des) {
		setAttrVal("Des", Des);
	}
}