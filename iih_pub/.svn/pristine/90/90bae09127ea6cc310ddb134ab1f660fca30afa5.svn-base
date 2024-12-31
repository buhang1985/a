package iih.ci.ord.i.op.tools;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/***
 * 计算总量 总次
 * 
 * @author li_zheng
 *
 */
public interface ICalculateTotal {

	/**
	 * 通过频次和使用天数计算获得总次数
	 * 
	 * @param id_freq
	 * @param use_day
	 * @return
	 * @throws BizException
	 */
	public abstract Integer getTotalTimes(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException;

	/**
	 * 药品领量天数计算，只有药品非草药类才需要计算
	 * 
	 * @param quan_cur
	 *            总量
	 * @param quan_medu
	 *            剂量
	 * @param factor
	 *            基本包装单位和总量单位间的换算系数
	 * @param factor_mb
	 *            医基换算系数
	 * @param id_freq
	 *            频次
	 * @return
	 * @throws BizException
	 */
	public abstract Integer getDaysAvalidate(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException;

	/**
	 * 物品类计算总量(已经知道总次数)
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param fg_pres_outp
	 *            是否出院带药
	 * @param times
	 *            总次数
	 * @param id_mm
	 *            物品id
	 * @param id_unit_sale
	 *            总量单位id
	 * @param quan_medu
	 *            单次剂量
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble getMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException;

	/**
	 * 非物品类型计算总量
	 * 
	 * @param quan_medu
	 *            单次剂量
	 * @param times_cur
	 *            总次数
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble getUnMMQuantum(CiEnContextDTO CiEnContext, TotalParameterDTO totalParameterDTO)
			throws BizException;

}
