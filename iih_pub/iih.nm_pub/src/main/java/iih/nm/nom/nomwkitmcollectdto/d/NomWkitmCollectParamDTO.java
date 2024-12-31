package iih.nm.nom.nomwkitmcollectdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理工作量统计参数 DTO数据 
 * 
 */
public class NomWkitmCollectParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 护理工作量统计主键
	 * @return String
	 */
	public String getId_nomwkit_collectp() {
		return ((String) getAttrVal("Id_nomwkit_collectp"));
	}
	/**
	 * 护理工作量统计主键
	 * @param Id_nomwkit_collectp
	 */
	public void setId_nomwkit_collectp(String Id_nomwkit_collectp) {
		setAttrVal("Id_nomwkit_collectp", Id_nomwkit_collectp);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getNomwkit_begindate() {
		return ((FDate) getAttrVal("Nomwkit_begindate"));
	}
	/**
	 * 开始时间
	 * @param Nomwkit_begindate
	 */
	public void setNomwkit_begindate(FDate Nomwkit_begindate) {
		setAttrVal("Nomwkit_begindate", Nomwkit_begindate);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getNomwkit_enddate() {
		return ((FDate) getAttrVal("Nomwkit_enddate"));
	}
	/**
	 * 结束时间
	 * @param Nomwkit_enddate
	 */
	public void setNomwkit_enddate(FDate Nomwkit_enddate) {
		setAttrVal("Nomwkit_enddate", Nomwkit_enddate);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_nur_dep() {
		return ((String) getAttrVal("Id_nur_dep"));
	}
	/**
	 * 护理单元
	 * @param Id_nur_dep
	 */
	public void setId_nur_dep(String Id_nur_dep) {
		setAttrVal("Id_nur_dep", Id_nur_dep);
	}
	/**
	 * 是否合计
	 * @return FBoolean
	 */
	public FBoolean getFg_sum() {
		return ((FBoolean) getAttrVal("Fg_sum"));
	}
	/**
	 * 是否合计
	 * @param Fg_sum
	 */
	public void setFg_sum(FBoolean Fg_sum) {
		setAttrVal("Fg_sum", Fg_sum);
	}
	/**
	 * 合计科室名称
	 * @return String
	 */
	public String getSum_depname() {
		return ((String) getAttrVal("Sum_depname"));
	}
	/**
	 * 合计科室名称
	 * @param Sum_depname
	 */
	public void setSum_depname(String Sum_depname) {
		setAttrVal("Sum_depname", Sum_depname);
	}
	/**
	 * 统计月份
	 * @return FDate
	 */
	public FDate getStatistical_month() {
		return ((FDate) getAttrVal("Statistical_month"));
	}
	/**
	 * 统计月份
	 * @param Statistical_month
	 */
	public void setStatistical_month(FDate Statistical_month) {
		setAttrVal("Statistical_month", Statistical_month);
	}
	/**
	 * 统计状态
	 * @return Integer
	 */
	public Integer getFg_comfirm() {
		return ((Integer) getAttrVal("Fg_comfirm"));
	}
	/**
	 * 统计状态
	 * @param Fg_comfirm
	 */
	public void setFg_comfirm(Integer Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
}