package iih.mm.qy.stockblinfo.i;

import iih.mm.qy.stockblinfo.d.StockBlQueryView;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:IStockblinfoeExtService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Date:     2019年7月2日 下午5:31:43 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public interface IStockblinfoExtService {

	/**
	 * ipFindByPageInfo:历史结存信息查询. <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param orderByPart
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	public abstract PagingRtnData<StockBlQueryView> getHistoryMmBlBak(PaginationInfo pg, String orderByPart,QryRootNodeDTO qryRootNodeDTO) throws BizException;
}
  
