package iih.bd.srv.diagcate.s;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.i.IDiCateItemDOExtCudService;
import iih.bd.srv.diagcate.i.IDiCateItemDOExtRService;
import iih.bd.srv.diagcate.s.bp.FindPageingByQCondAndCateBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 疾病诊断分类项目扩展服务
 * 
 * @author hao_wu
 *
 */
public class DiCateItemDOExtCrudServiceImpl implements IDiCateItemDOExtCudService, IDiCateItemDOExtRService {

	@Override
	public PagingRtnData<DiCateItemDO> FindPageingByQCondAndCate(QryRootNodeDTO qryRootNodeDTO, DiagCateDO diagCateDO,
			PaginationInfo pg) throws BizException {
		FindPageingByQCondAndCateBp bp = new FindPageingByQCondAndCateBp();
		PagingRtnData<DiCateItemDO> rtn = bp.exec(qryRootNodeDTO, diagCateDO, pg);
		return rtn;
	}

}
