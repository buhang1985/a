package iih.ei.std.d.v1.mp.updatestatus.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本维度修改医嘱状态入参 DTO数据 
 * 
 */
public class UpLabStatusParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本维度修改医嘱状态
	 * @return String
	 */
	public FArrayList getUplabstatus() {
		return ((FArrayList) getAttrVal("Uplabstatus"));
	}	
	/**
	 * 标本维度修改医嘱状态
	 * @param Uplabstatus
	 */
	public void setUplabstatus(FArrayList Uplabstatus) {
		setAttrVal("Uplabstatus", Uplabstatus);
	}
}