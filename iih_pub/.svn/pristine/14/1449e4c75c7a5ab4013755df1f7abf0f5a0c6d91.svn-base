package iih.mm.pl.traprequest.i;

import iih.mm.pl.dtos.trapreqautocond.d.TrapReqAutoCondDTO;
import iih.mm.pl.traprequest.d.TrapReqItemDO;
import iih.mm.pl.traprequest.d.TrapReqOrderDO;
import iih.mm.pl.traprequest.d.TraprequestAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ITrapRequestService {
	//基数库调拨申请模式_最高库存
	public static final String TYPE_MAXNUM = "1";
	//基数库调拨申请模式_最低库存 (减当前库存)
	public static final String TYPE_MINNUM = "2";
	//基数库调拨申请模式_出库量
	public static final String TYPE_OUTNUM = "3";
	//基数库调拨申请模式_最低库存 (不减当前库存)
	public static final String TYPE_MINNUM_ONLY = "4";
	//基数库调拨申请模式_不计算申请量
	public static final String TYPE_MINNUM_NOCAL = "5";
	
	/**
	 * 初始化调拨单明细信息
	 * @param materialIDList 物品ID列表
	 * @param inWhouseID 转入仓库
	 * @param outWhouseID 转出仓库
	 */
	public TrapReqItemDO[] initTrapReqItemList(String[] materialIDList, String inWhouseID, String outWhouseID) throws BizException;
	
	/**
	 * 初始化调拨单明细信息
	 * @param tapReqItem 调拨申请明细
	 * @param inWhouseID 转入仓库
	 * @param outWhouseID 转出仓库
	 */
	public TrapReqItemDO initTrapReqItemInfo(TrapReqItemDO tapReqItem, String inWhouseID, String outWhouseID, String type) throws BizException;
	/**
	 * 调拨申请单删除
	 * @param ids 申请单主键
	 */
	public void delete(String[] ids) throws BizException;
	
	/**
	 * 调拨申请单提交
	 * @param ids 申请单主键
	 */
	public TraprequestAggDO[] submit(String[] ids) throws BizException;
	
	/**
	 * 调拨申请单取消提交
	 * @param ids 申请单主键
	 */
	public TraprequestAggDO[] cancelSubmit(String[] ids) throws BizException;
	
	/**
	 * 自动生成基数药调拨申请明细
	 * @param initType 基数库调拨申请模式
	 * @param trapReqOrderDO 申请单主信息
	 */
	public TrapReqItemDO[] autoInitTrapReqItem(TrapReqAutoCondDTO condDTO, TrapReqOrderDO trapReqOrderDO) throws BizException;
	
	/**
	 * 根据调拨单更新调拨申请单状态
	 * @param ids 申请单主键
	 */
	public void updateTrapReqOrderStatus(String[] ids, String orderStatus) throws BizException;
	
	/**
	 * 根据查询方案查询调拨申请单分页数据
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 * chma 20181022
	 */
	public PagingRtnData<TraprequestAggDO> findPagingDataByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
}
