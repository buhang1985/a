package iih.ei.itf.eiitfcateitm.s;

import iih.ei.itf.eiitfcateitm.d.ItfCateItmDTO;
import iih.ei.itf.eiitfcateitm.i.IEiItfCateItmExtCudService;
import iih.ei.itf.eiitfcateitm.i.IEiItfCateItmExtRService;
import iih.ei.itf.eiitfcateitm.s.bp.AddItfBp;
import iih.ei.itf.eiitfcateitm.s.bp.DeleteItfBp;
import iih.ei.itf.eiitfcateitm.s.bp.FindPagingItfByCateBp;
import iih.ei.itf.eiitfcateitm.s.bp.FindPagingItfExcludeCateBp;
import iih.ei.itf.eiitfdo.d.EiItfDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 接口分类项目扩展服务
 * 
 * @author hao_wu 2019-10-23
 *
 */
public class EiItfCateItmExtCrudServiceImpl implements IEiItfCateItmExtCudService, IEiItfCateItmExtRService {

	@Override
	public PagingRtnData<ItfCateItmDTO> findPagingItfByCate(String itfCateId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingItfByCateBp bp = new FindPagingItfByCateBp();
		PagingRtnData<ItfCateItmDTO> result = bp.exec(itfCateId, qryRootNodeDTO, orderStr, pg);
		return result;
	}

	@Override
	public PagingRtnData<EiItfDO> findPagingItfExcludeCate(String itfCateId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		FindPagingItfExcludeCateBp bp = new FindPagingItfExcludeCateBp();
		PagingRtnData<EiItfDO> result = bp.exec(itfCateId, qryRootNodeDTO, orderStr, pg);
		return result;
	}

	@Override
	public void deleteItf(String itfCateId, String[] itfIds) throws BizException {
		DeleteItfBp bp = new DeleteItfBp();
		bp.exec(itfCateId, itfIds);
	}

	@Override
	public void addItf(String itfCateId, String[] itfIds) throws BizException {
		AddItfBp bp = new AddItfBp();
		bp.exec(itfCateId, itfIds);
	}

}
