package iih.nmr.pkuf.dto.batchentry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理文书分类数据集 DTO数据 
 * 
 */
public class NurCaItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_caitm() {
		return ((String) getAttrVal("Id_caitm"));
	}
	/**
	 * 主键
	 * @param Id_caitm
	 */
	public void setId_caitm(String Id_caitm) {
		setAttrVal("Id_caitm", Id_caitm);
	}
	/**
	 * 护理分类数据集名字
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 护理分类数据集名字
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 护理分类数据集编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 护理分类数据集编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 护理分类数据集父级节点
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 护理分类数据集父级节点
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 阶级标识
	 * @return String
	 */
	public String getAlevel() {
		return ((String) getAttrVal("Alevel"));
	}
	/**
	 * 阶级标识
	 * @param Alevel
	 */
	public void setAlevel(String Alevel) {
		setAttrVal("Alevel", Alevel);
	}
}