package iih.mp.ne.samsend.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 送检条件查询 DTO数据 
 * 
 */
public class SendConditionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 病区ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 日期
	 * @return FDate
	 */
	public FDate getDt_mp_orplcasta() {
		return ((FDate) getAttrVal("Dt_mp_orplcasta"));
	}
	/**
	 * 日期
	 * @param Dt_mp_orplcasta
	 */
	public void setDt_mp_orplcasta(FDate Dt_mp_orplcasta) {
		setAttrVal("Dt_mp_orplcasta", Dt_mp_orplcasta);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 病区
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 是否打印
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 是否打印
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
}