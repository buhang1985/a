package iih.bd.pp.medinsursrvfacrec.s;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsursrvfacrec.d.MedInsurSrvFacRecDO;
import iih.bd.pp.medinsursrvfacrec.i.IMedinsursrvfacrecExtCudService;
import iih.bd.pp.medinsursrvfacrec.i.IMedinsursrvfacrecExtRService;
import iih.bd.pp.medinsursrvfacrec.s.bp.FindSrvFacPagingByQCondAndDownIdBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保服务设施记录扩展服务
 * 
 * @author hao_wu
 *
 */
public class MedinsursrvfacrecExtCudServiceImpl implements IMedinsursrvfacrecExtCudService, IMedinsursrvfacrecExtRService {

	@Override
	public PagingRtnData<MedInsurSrvFacRecDO> FindPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException {
		FindSrvFacPagingByQCondAndDownIdBp bp = new FindSrvFacPagingByQCondAndDownIdBp();
		PagingRtnData<MedInsurSrvFacRecDO> result = bp.exec(qryRootNodeDto, fileDownRec, orderPart, pg);
		return result;
	}
}
