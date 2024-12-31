package iih.ems.emcm.upkeep.i;



import iih.ems.emcm.upkeep.d.EmsUpkeepDO;
import xap.mw.core.data.BizException;

public interface IUpkeepMaintainService {

	
	public EmsUpkeepDO inDo(String sd_sttp) throws BizException;
	/**
	 * 报损单提交
	 * 
	 * @param mcDamageOutDo
	 *            主报损单
	 * @throws BizException
	 */
	public EmsUpkeepDO[] submitMainDO(EmsUpkeepDO[] EmsUpkeepDo) throws BizException;


	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核通过
	 * @throws BizException
	 */
	public EmsUpkeepDO auditsubmit(EmsUpkeepDO EmsUpkeepDo) throws BizException;

	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核驳回
	 * @throws BizException
	 */
	public EmsUpkeepDO auditreject(EmsUpkeepDO EmsUpkeepDo) throws BizException;
	//作废
	public EmsUpkeepDO[] cancellation(EmsUpkeepDO[] EmsUpkeepDo) throws BizException;

}
