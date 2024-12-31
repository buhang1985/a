package iih.ei.std.d.v1.en.cancipinfos.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退院患者列表入参 DTO数据 
 * 
 */
public class CancIpInfosParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间点
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_canc() {
		return ((FDateTime) getAttrVal("Dt_begin_canc"));
	}	
	/**
	 * 开始时间点
	 * @param Dt_begin_canc
	 */
	public void setDt_begin_canc(FDateTime Dt_begin_canc) {
		setAttrVal("Dt_begin_canc", Dt_begin_canc);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}