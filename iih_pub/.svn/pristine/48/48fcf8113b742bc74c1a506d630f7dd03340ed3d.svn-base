package iih.mc.qy.mcstockoutqrydto.i;

import iih.mc.qy.mcstockoutqrydto.d.McStockOutQryDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 耗材出库查询服务
 * @author chma
 *
 */
public interface IMcStockOutQryDTORService {

	/**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<McStockOutQryDTO> findByPageInfo(String wherePart,String orderByPart,PaginationInfo pg) throws BizException;
	
	/**
	 * 根据查询模板条件、分页信息查询分页数据集合
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<McStockOutQryDTO> findMcStockOutQryByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO,String orderStr,PaginationInfo pg) throws BizException;
	
}
