package iih.ems.eass.adj.i;



import iih.ems.eass.adj.d.EmsAdjDO;
import xap.mw.core.data.BizException;

public interface IAdjMaintainService {

	
	public EmsAdjDO inDo(String sd_sttp) throws BizException;
	/**
	 * 价值变更单提交
	 * 
	 * @param EmsAdjDO
	 *            主报损单
	 * @throws BizException
	 */
	public EmsAdjDO[] submitMainDO(EmsAdjDO[] AdjDo) throws BizException;


	/**
	 * 价值变更单审核
	 * 
	 * @param EmsAdjDO
	 *            卡价值变更审核通过
	 * @throws BizException
	 */
	public EmsAdjDO auditsubmit(EmsAdjDO AdjDo) throws BizException;

	/**
	 * 价值变更单审核
	 * 
	 * @param EmsAdjDO
	 *            卡价值变更核驳回
	 * @throws BizException
	 */
	public EmsAdjDO auditreject(EmsAdjDO AdjDo) throws BizException;
	//作废
	public EmsAdjDO[] cancellation(EmsAdjDO[] AdjDo) throws BizException;

}
