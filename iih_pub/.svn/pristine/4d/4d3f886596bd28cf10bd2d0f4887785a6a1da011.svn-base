package iih.bd.srv.diagcate.i;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.DiagCateDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 疾病诊断分类项目扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IDiCateItemDOExtRService {

	/**
	 * 根据查询方案和疾病诊断分类查询疾病诊断分类下项目分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param diagCateDO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DiCateItemDO> FindPageingByQCondAndCate(QryRootNodeDTO qryRootNodeDTO,
			DiagCateDO diagCateDO, PaginationInfo pg) throws BizException;

}
