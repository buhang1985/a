package iih.mm.pl.trapimpl.i;

import iih.mm.pl.trapimpl.d.TrapImplDiffDTO;
import iih.mm.pl.trapimpl.d.TrapImplItemDO;
import iih.mm.pl.trapimpl.d.TrapimplAggDO;
import iih.mm.pl.traprequest.d.TrapReqItemDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ITrapimplService {

	public TrapimplAggDO initTrapImplByPlan(String[] plIdList) throws BizException;
	
	/**
	 * 根据物品ID生成申请单明细
	 * @param materialIDList 物品ID列表
	 * @param inWhouseID 转入仓库
	 * @param outWhouseID 转出仓库
	 */
	public TrapImplItemDO[] initTrapImplItemList(String[] materialIDList, String inWhouseID, String outWhouseID) throws BizException;
	
	/**
	 * 初始化生单明细信息
	 * @param trapImplItemList 调拨单明细
	 * @param outWhouseID 转出仓库
	 */
	public TrapImplItemDO initTrapImplItemInfo(TrapImplItemDO trapImplItem, String inWhouseID, String outWhouseID, String type) throws BizException;
	
	/**
	 * 调拨单删除
	 */
	public void deleteTrapImpl(String[] ids) throws BizException;
	
	/**
	 * 调拨单确认
	 */
	public TrapimplAggDO[] confirmTrapImpl(String[] ids, String sd_su_tr) throws BizException;
	
	/**
	 * 根据查询方案查询调拨申请单分页数据
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 * chma 20181022
	 */
	public PagingRtnData<TrapimplAggDO> findPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;

	/**
	 * 查询申请单和调拨单的差别
	 * @param aggDo
	 * @return
	 */
	public TrapImplDiffDTO[] getDiff(TrapimplAggDO aggDo) throws BizException;
	
	/**
	 * 获取调拨禁用的明细
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public TrapReqItemDO[] checkFgStopTr(String[] ids) throws BizException; 
}
