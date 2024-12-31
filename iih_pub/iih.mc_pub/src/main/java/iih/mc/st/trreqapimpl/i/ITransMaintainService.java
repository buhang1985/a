package iih.mc.st.trreqapimpl.i;

import iih.mc.bl.stockbl.d.McStockBlDO;
import iih.mc.pl.trrequestap.d.McTrReqApOrderDO;
import iih.mc.st.trreqapimpl.d.McTrReqApImplDO;
import iih.mc.st.trreqapimpl.d.McTrReqApImplItemDO;
import iih.mc.st.trreqapimpl.d.TrreqapimplAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface ITransMaintainService {
	
	/**
	 * 初始化调拨单
	 * @throws BizException
	 */
	public TrreqapimplAggDO initAggDo() throws BizException;
	
	/**
	 * 初始化调拨单明细
	 * @param transOrderDO 调拨单
	 * @param transItemDO 调拨单明细
	 * @throws BizException
	 */
	public McTrReqApImplItemDO initTransItemInfo(McTrReqApImplDO transOrderDO, McTrReqApImplItemDO transItemDO) throws BizException;
	
	/**
	 * 根据所选结存初始化调拨明细信息(批次修改用)
	 * @param stockBlDO 结存信息
	 * @param transItemDO 调拨单明细
	 * @throws BizException
	 */
	public McTrReqApImplItemDO initTransItemByStockbl(McStockBlDO stockBlDO, McTrReqApImplItemDO transItemDO) throws BizException;
	
	/**
	 * 根据调拨申请单生成调拨单
	 * @param trreqOrderDOS 调拨申请单
	 * @throws BizException
	 */
	public TrreqapimplAggDO initTransOrderByTrreqOrder(McTrReqApOrderDO[] trreqOrderDOS) throws BizException;
	
	/**
	 * 调拨单提交
	 * @param transOrderDOS 调拨单
	 * @throws BizException
	 */
	public void submitMainDO(McTrReqApImplDO[] transOrderDOS) throws BizException;
	
	/**
	 * 调拨单提交
	 * @param transAggDO 调拨单
	 * @throws BizException
	 */
	public TrreqapimplAggDO submitAggDO(TrreqapimplAggDO transAggDO) throws BizException;
	
	/**
	 * 耗材调拨单查询
	 * @param qryRootNodeDto
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<McTrReqApImplDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) throws BizException;
}
