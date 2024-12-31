package iih.mm.st.stockin.purchasereturn.i;

import iih.mm.st.stockin.d.StockInDO;
import iih.mm.st.stockin.d.StockinAggDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 采购退货单查询查询服务
 * 
 * @author hao_wu 2018-10-30
 *
 */
public interface IPurchaseReturnRService {

	/**
	 * 根据查询方案查询当前科室下的采购退货单分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<StockInDO> findPagingByQCondAndOwerDep(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;
	
	/**
	 * 生单时查询采购入库的入库单
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<StockInDO> findPagingWithCreate(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException;
	
	/**
	 * 选择生单后根据物品信息查询结存信息
	 * @param stockinAggDo
	 * @return
	 * @throws BizException
	 */
	public abstract StockinAggDO findBlByMm(StockinAggDO stockinAggDo) throws BizException;
}
