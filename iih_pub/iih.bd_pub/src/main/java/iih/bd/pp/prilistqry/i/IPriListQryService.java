package iih.bd.pp.prilistqry.i;

import iih.bd.pp.dto.d.PricelistqrySrvDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 价表查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IPriListQryService {

	/**
	 * 根据查询方案查询价表分页数据
	 * 
	 * @param qryRootNodeDTO
	 *            查询方案
	 * @param orderPart
	 *            排序片段
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<PricelistqrySrvDTO> FindPagingByQcond(QryRootNodeDTO qryRootNodeDTO, String orderPart,
			PaginationInfo pg) throws BizException;

}
