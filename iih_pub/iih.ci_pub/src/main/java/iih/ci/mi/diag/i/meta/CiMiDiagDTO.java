package iih.ci.mi.diag.i.meta;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床诊断医保校验数据对象
 * @author HUMS
 *
 */
public class CiMiDiagDTO extends BaseDTO{

private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * 诊断id
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * 诊断code
	 * @return String
	 */
	public String getCode_didef() {
		return ((String) getAttrVal("Code_didef"));
	}
	/**
	 * 诊断code
	 * @param Code_didef
	 */
	public void setCode_didef(String Code_didef) {
		setAttrVal("Code_didef", Code_didef);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef
	 */
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	/**
	 * 是否慢病诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}
	/**
	 * 是否慢病诊断
	 * @param Fg_haschronic
	 */
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
		
	/**
	 * 是否行动不便诊断
	 * @return FBoolean
	 */
	public FBoolean getFg_hasmovediff() {
		return ((FBoolean) getAttrVal("Fg_hasmovediff"));
	}
	/**
	 * 是否行动不便诊断
	 * @param Fg_hasmovediff
	 */
	public void setFg_hasmovediff(FBoolean Fg_hasmovediff) {
		setAttrVal("Fg_hasmovediff", Fg_hasmovediff);
	}
	
	/**
	 * 是否特种病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}
	/**
	 * 是否特种病标识
	 * @param Fg_haschronic
	 */
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
}
