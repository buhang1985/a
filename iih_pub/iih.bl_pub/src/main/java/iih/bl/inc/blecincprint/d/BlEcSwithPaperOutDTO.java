package iih.bl.inc.blecincprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 换开纸质票据出参 DTO数据 
 * 
 */
public class BlEcSwithPaperOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 纸质票据id
	 * @return String
	 */
	public String getId_incpaper() {
		return ((String) getAttrVal("Id_incpaper"));
	}
	/**
	 * 纸质票据id
	 * @param Id_incpaper
	 */
	public void setId_incpaper(String Id_incpaper) {
		setAttrVal("Id_incpaper", Id_incpaper);
	}
	/**
	 * 纸质票据号
	 * @return String
	 */
	public String getPincno() {
		return ((String) getAttrVal("Pincno"));
	}
	/**
	 * 纸质票据号
	 * @param Pincno
	 */
	public void setPincno(String Pincno) {
		setAttrVal("Pincno", Pincno);
	}
	/**
	 * 纸质票据代码
	 * @return String
	 */
	public String getPinc_code() {
		return ((String) getAttrVal("Pinc_code"));
	}
	/**
	 * 纸质票据代码
	 * @param Pinc_code
	 */
	public void setPinc_code(String Pinc_code) {
		setAttrVal("Pinc_code", Pinc_code);
	}
	/**
	 * 错误信息
	 * @return String
	 */
	public String getErrormsg() {
		return ((String) getAttrVal("Errormsg"));
	}
	/**
	 * 错误信息
	 * @param Errormsg
	 */
	public void setErrormsg(String Errormsg) {
		setAttrVal("Errormsg", Errormsg);
	}
}