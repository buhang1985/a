package iih.ems.eass.scrap.i;



import iih.ems.eass.scrap.d.EmsScrapDO;
import xap.mw.core.data.BizException;

public interface IScrapMaintainService {

	
	public EmsScrapDO inDo(String sd_sttp) throws BizException;
	/**
	 * 报损单提交
	 * 
	 * @param mcDamageOutDo
	 *            主报损单
	 * @throws BizException
	 */
	public EmsScrapDO[] submitMainDO(EmsScrapDO[] EmsUpkeepDo) throws BizException;


	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核通过
	 * @throws BizException
	 */
	public EmsScrapDO auditsubmit(EmsScrapDO EmsUpkeepDo) throws BizException;

	/**
	 * 报损单审核
	 * 
	 * @param DmoutAggDO
	 *            卡报损单审核驳回
	 * @throws BizException
	 */
	public EmsScrapDO auditreject(EmsScrapDO EmsUpkeepDo) throws BizException;
	//作废
	public EmsScrapDO[] cancellation(EmsScrapDO[] EmsUpkeepDo) throws BizException;

}
