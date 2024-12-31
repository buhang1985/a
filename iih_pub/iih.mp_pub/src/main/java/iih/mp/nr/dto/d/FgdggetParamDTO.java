package iih.mp.nr.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * DG域执行计划项目摆药标识变更 DTO数据 
 * 
 */
public class FgdggetParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行记录子表ID
	 * @return String
	 */
	public String getId_or_pr_srv() {
		return ((String) getAttrVal("Id_or_pr_srv"));
	}
	/**
	 * 执行记录子表ID
	 * @param Id_or_pr_srv
	 */
	public void setId_or_pr_srv(String Id_or_pr_srv) {
		setAttrVal("Id_or_pr_srv", Id_or_pr_srv);
	}
	/**
	 * 摆药获取标志
	 * @return FBoolean
	 */
	public FBoolean getFg_dg_get() {
		return ((FBoolean) getAttrVal("Fg_dg_get"));
	}
	/**
	 * 摆药获取标志
	 * @param Fg_dg_get
	 */
	public void setFg_dg_get(FBoolean Fg_dg_get) {
		setAttrVal("Fg_dg_get", Fg_dg_get);
	}
}