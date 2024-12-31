package iih.ems.einv.eminsp.i;

import iih.ems.einv.eminsp.d.EminspAggDO;
import iih.ems.einv.eminsp.d.EmsInspDO;
import xap.mw.core.data.BizException;

public interface IEminspMaintainService {

	/**
	 * 初始化报损单
	 * 
	 * @param sd_sttp
	 *            库存交易类型
	 * @throws BizException
	 */
	public EminspAggDO initAggDo(String sd_sttp) throws BizException;

	/**
	 * 报损单提交
	 * 
	 * @param mcDamageOutDo
	 *            主报损单
	 * @throws BizException
	 */
	public EmsInspDO[] submitMainDO(EmsInspDO[] mcDamageOutDo) throws BizException;

	/**
	 * 卡报损单提交
	 * 
	 * @param dmOutAggDO
	 *            卡报损单
	 * @throws BizException
	 */
	public EminspAggDO submitAggDO(EminspAggDO dmOutAggDO) throws BizException;

	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核通过
	 * @throws BizException
	 */
	public EminspAggDO auditsubmit(EminspAggDO dmOutAggDO) throws BizException;

	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核驳回
	 * @throws BizException
	 */
	public EminspAggDO auditreject(EminspAggDO dmOutAggDO) throws BizException;

}
