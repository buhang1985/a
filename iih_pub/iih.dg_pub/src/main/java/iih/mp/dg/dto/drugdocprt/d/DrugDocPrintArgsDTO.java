package iih.mp.dg.dto.drugdocprt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药单打印参数DTO DTO数据 
 * 
 */
public class DrugDocPrintArgsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药单主键
	 * @return String
	 */
	public String getId_drugdoc() {
		return ((String) getAttrVal("Id_drugdoc"));
	}
	/**
	 * 药单主键
	 * @param Id_drugdoc
	 */
	public void setId_drugdoc(String Id_drugdoc) {
		setAttrVal("Id_drugdoc", Id_drugdoc);
	}
	/**
	 * 场景编码
	 * @return String
	 */
	public String getSd_scenes() {
		return ((String) getAttrVal("Sd_scenes"));
	}
	/**
	 * 场景编码
	 * @param Sd_scenes
	 */
	public void setSd_scenes(String Sd_scenes) {
		setAttrVal("Sd_scenes", Sd_scenes);
	}
}