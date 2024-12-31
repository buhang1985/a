package iih.mkr.std.valdomain.i;

import iih.mkr.std.valdomain.d.ValDomainDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 值域扩展服务接口
 * 
 * @author hao_wu 2019-5-14
 *
 */
public interface IValDomainExtRService {

	/**
	 * 根据数据集分类主键和查询方案查询值域分页数据
	 * 
	 * @param deSetCaId      数据集分类主键
	 * @param qryRootNodeDto 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public PagingRtnData<ValDomainDO> findPagingByDeSetCaIdAndQryNode(String deSetCaId, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg) throws BizException;
}
