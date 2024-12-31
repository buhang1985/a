package iih.ci.ord.cior.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;

import java.math.BigDecimal;

/**
 * 排斥扩展医嘱与排斥停止医嘱 DTO数据 
 * 
 */
public class ReactExtOrsAndStopOrsDO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排斥类型
	 * @return String
	 */
	public String getSd_reacttp() {
		return ((String) getAttrVal("Sd_reacttp"));
	}
	/**
	 * 排斥类型
	 * @param Sd_reacttp
	 */
	public void setSd_reacttp(String Sd_reacttp) {
		setAttrVal("Sd_reacttp", Sd_reacttp);
	}
	
	/**
	 * 排斥医嘱
	 * @return CiorderAggDO
	 */
	public CiorderAggDO getReactextdo() {
		return ((CiorderAggDO) getAttrVal("Reactextdo"));
	}
	/**
	 * 排斥医嘱
	 * @param Reactextdo
	 */
	public void setReactextdo(CiorderAggDO Reactextdo) {
		setAttrVal("Reactextdo", Reactextdo);
	}
	/**
	 * 关联要停止的医嘱
	 * @return CiOrderDO[]
	 */
	public CiOrderDO[] getStopordos() {
		return ((CiOrderDO[]) getAttrVal("Stopordos"));
	}
	/**
	 * 关联要停止的医嘱
	 * @param Stopordos
	 */
	public void setStopordos(CiOrderDO[] Stopordos) {
		setAttrVal("Stopordos", Stopordos);
	}
//	/**
//	 * 排斥医嘱的开立时间
//	 * @return
//	 */
//	public FDateTime getDt_effe(){
//		return ((FDateTime) getAttrVal("Dt_effe"));
//	}
//	/**
//	 * 排斥医嘱的开立时间
//	 * @param Dt_effe
//	 */
//	public void setDt_effe(FDateTime Dt_effe) {
//		setAttrVal("Dt_effe", Dt_effe);
//	}
	/**
	 * 提示信息
	 * @return String
	 */
	public String getTipMsg() {
		return ((String) getAttrVal("TipMsg"));
	}
	/**
	 * 提示信息
	 * @param Sd_reacttp
	 */
	public void setTipMsg(String TipMsg) {
		setAttrVal("TipMsg", TipMsg);
	}
	/**
	 * 排斥扩展医嘱聚集数据(旧医生站）
	 * @return FArrayList
	 */
	public FArrayList getReactextdos() {
		return ((FArrayList) getAttrVal("Reactextdos"));
	}
	/**
	 * 排斥扩展医嘱聚集数据(旧医生站)
	 * @param Reactextdos
	 */
	public void setReactextdos(FArrayList Reactextdos) {
		setAttrVal("Reactextdos", Reactextdos);
	}
	/**
	 * 关联要停止的医嘱(旧医生站)
	 * @return FArrayList
	 */
	public FArrayList getStopords() {
		return ((FArrayList) getAttrVal("Stopords"));
	}
	/**
	 * 关联要停止的医嘱(旧医生站)
	 * @param Stopordos
	 */
	public void setStopords(FArrayList Stopords) {
		setAttrVal("Stopords", Stopords);
	}
}