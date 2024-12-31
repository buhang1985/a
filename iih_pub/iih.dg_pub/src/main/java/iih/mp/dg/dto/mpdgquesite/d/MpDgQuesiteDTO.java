package iih.mp.dg.dto.mpdgquesite.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发药窗口 DTO数据 
 * 
 */
public class MpDgQuesiteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 队列站点id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 队列站点id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 是否在该执行点分窗口
	 * @return FBoolean
	 */
	public FBoolean getFg_window() {
		return ((FBoolean) getAttrVal("Fg_window"));
	}
	/**
	 * 是否在该执行点分窗口
	 * @param Fg_window
	 */
	public void setFg_window(FBoolean Fg_window) {
		setAttrVal("Fg_window", Fg_window);
	}
}