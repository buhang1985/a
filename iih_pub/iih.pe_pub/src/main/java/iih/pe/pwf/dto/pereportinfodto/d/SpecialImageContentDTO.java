package iih.pe.pwf.dto.pereportinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专科检查图像信息 DTO数据 
 * 
 */
public class SpecialImageContentDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 专科编码
	 * @return String
	 */
	public String getSpecialinfocode() {
		return ((String) getAttrVal("Specialinfocode"));
	}
	/**
	 * 专科编码
	 * @param Specialinfocode
	 */
	public void setSpecialinfocode(String Specialinfocode) {
		setAttrVal("Specialinfocode", Specialinfocode);
	}
	/**
	 * 影像信息
	 * @return String
	 */
	public String getImagecontent() {
		return ((String) getAttrVal("Imagecontent"));
	}
	/**
	 * 影像信息
	 * @param Imagecontent
	 */
	public void setImagecontent(String Imagecontent) {
		setAttrVal("Imagecontent", Imagecontent);
	}
	/**
	 * 影像格式
	 * @return String
	 */
	public String getImageformat() {
		return ((String) getAttrVal("Imageformat"));
	}
	/**
	 * 影像格式
	 * @param Imageformat
	 */
	public void setImageformat(String Imageformat) {
		setAttrVal("Imageformat", Imageformat);
	}
	/**
	 * 提示信息
	 * @return String
	 */
	public String getImagememo() {
		return ((String) getAttrVal("Imagememo"));
	}
	/**
	 * 提示信息
	 * @param Imagememo
	 */
	public void setImagememo(String Imagememo) {
		setAttrVal("Imagememo", Imagememo);
	}
}