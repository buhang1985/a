package iih.mm.st.bdwhmmcacontainmm.i;

import iih.mm.st.bdwhmmcacontainmm.d.BdWhMmcaContainMmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:IBdwhmmcacontainmmCrudService <br/>  
 * Function: 仓库分类下包含物品服务接口 <br/>  
 * Date:     2019年4月16日 下午2:00:12 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public interface IBdwhmmcacontainmmCrudService {
	
	/**
	 * findPagingDataByQCond:仓库分类下包含药品结存根据分页信息及查询与分组条件获得分页数据<br/>  
	 * @author zmyang  
	 * @param pgInfo
	 * @param qryRootNodeDto
	 * @param wherePart
	 * @param orderPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	public abstract PagingRtnData<BdWhMmcaContainMmDTO> findPagingDataByQCond(PaginationInfo pgInfo, QryRootNodeDTO qryRootNodeDto, String wherePart, String orderPart) throws BizException;
}
  
