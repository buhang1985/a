package iih.mm.bl.blreserve.i;

import iih.mm.itf.materialreserve.d.ReserveCondDTO;
import iih.mm.itf.materialreserve.d.ReserveDetailDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface IStockBlReserveService {
	
	/**
	 * 预留明细查询
	 */
	public PagingRtnData<ReserveDetailDTO> getReserveDetailInfo(PaginationInfo pg, ReserveCondDTO condDTO, String orderByPart) throws BizException;
	
	/**
	 * 取消预留信息
	 */
	public void releaseReserve(String[] id_orsrvs) throws BizException;
	
	/**
	 * 重新预留
	 */
	public void cancelRelease(String[] id_orsrvs) throws BizException;
	
	/**
	 * 数据修复
	 */
	public void repairData(String[] id_orsrvs) throws BizException;
}
