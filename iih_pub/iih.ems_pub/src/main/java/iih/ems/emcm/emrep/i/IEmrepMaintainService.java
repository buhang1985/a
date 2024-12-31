package iih.ems.emcm.emrep.i;


import iih.ems.emcm.emrep.d.EmsRepairDO;
import xap.mw.core.data.BizException;

public interface IEmrepMaintainService {

	
	public EmsRepairDO inDo(String sd_sttp) throws BizException;
	/**
	 * 报损单提交
	 * 
	 * @param mcDamageOutDo
	 *            主报损单
	 * @throws BizException
	 */
	public EmsRepairDO[] submitMainDO(EmsRepairDO[] EmsRepairDo) throws BizException;


	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核通过
	 * @throws BizException
	 */
	public EmsRepairDO auditsubmit(EmsRepairDO EmsRepairDo) throws BizException;

	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核驳回
	 * @throws BizException
	 */
	public EmsRepairDO auditreject(EmsRepairDO EmsRepairDo) throws BizException;
	//确认
	public EmsRepairDO[] confirm(EmsRepairDO[] EmsRepairDo) throws BizException;

}
