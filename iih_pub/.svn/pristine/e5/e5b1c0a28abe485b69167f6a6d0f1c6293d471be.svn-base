package iih.ci.ord.i.meta;

import iih.ci.ord.i.common.b.BaseCiDTO;
import xap.mw.coreitf.d.FDateTime;

public class OrderOperateDTO extends BaseCiDTO {
	/**
	 * 完全复制
	 */
	public static final String FULLCOPY = "0";
	/**
	 * 复制开立
	 */
	public static final String COPYOPEN = "1";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 功能操作码 0,完全复制用于门诊撤回作废逻辑中的复制;1，复制开立
	 * @return
	 */
	public String getFuncCode(){
		return ((String) getAttrVal("FuncCode"));
	}
	/**
	 * 功能操作码
	 * @param FuncCode
	 */
	public void setFuncCode(String FuncCode){
		setAttrVal("FuncCode", FuncCode);
	}
	
    /**
     *医嘱的开始时间
     * @param Dt_effe
     */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	
	/**
	 * 医嘱的开始时间
	 * @return
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
		}
	
}
