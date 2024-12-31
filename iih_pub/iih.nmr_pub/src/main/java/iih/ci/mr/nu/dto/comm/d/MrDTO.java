package iih.ci.mr.nu.dto.comm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 数据元同步模板XML结构根节点 DTO数据 
 * 
 */
public class MrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 全类名
	 * @return String
	 */
	public String getFullclassname() {
		return ((String) getAttrVal("Fullclassname"));
	}
	/**
	 * 全类名
	 * @param Fullclassname
	 */
	public void setFullclassname(String Fullclassname) {
		setAttrVal("Fullclassname", Fullclassname);
	}
	/**
	 * 医疗记录自定义分类ID
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}
	/**
	 * 医疗记录自定义分类ID
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 文书ID
	 * @return String
	 */
	public String getId_nu() {
		return ((String) getAttrVal("Id_nu"));
	}
	/**
	 * 文书ID
	 * @param Id_nu
	 */
	public void setId_nu(String Id_nu) {
		setAttrVal("Id_nu", Id_nu);
	}
	/**
	 * 医疗记录模板ID
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 医疗记录模板ID
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 医疗记录类型ID
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 医疗记录类型ID
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
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
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就急诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就急诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 文书名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}