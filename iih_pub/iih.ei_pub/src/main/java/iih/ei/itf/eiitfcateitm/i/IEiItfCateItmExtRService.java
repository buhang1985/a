package iih.ei.itf.eiitfcateitm.i;

import iih.ei.itf.eiitfcateitm.d.ItfCateItmDTO;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 接口分类项目扩展服务接口
 * 
 * @author hao_wu 2019-10-23
 *
 */
public interface IEiItfCateItmExtRService {

	/**
	 * 查询分类下接口分页信息
	 * 
	 * @param itfCateId      接口分类主键
	 * @param qryRootNodeDTO 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<ItfCateItmDTO> findPagingItfByCate(String itfCateId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;

	/**
	 * 查询不在分类下的接口分页信息
	 * 
	 * @param itfCateId      接口分类主键
	 * @param qryRootNodeDTO 查询方案
	 * @param orderStr       排序语句
	 * @param pg             分页信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<EiItfDO> findPagingItfExcludeCate(String itfCateId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException;
}
