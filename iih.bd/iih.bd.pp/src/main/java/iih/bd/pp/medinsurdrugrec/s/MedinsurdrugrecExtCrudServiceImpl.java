package iih.bd.pp.medinsurdrugrec.s;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdrugrec.d.MedInsurDrugRecDO;
import iih.bd.pp.medinsurdrugrec.i.IMedinsurdrugrecExtCudService;
import iih.bd.pp.medinsurdrugrec.i.IMedinsurdrugrecExtRService;
import iih.bd.pp.medinsurdrugrec.s.bp.FindDrugPagingByQCondAndDownIdBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保药品记录扩展服务
 * 
 * @author hao_wu
 *
 */
public class MedinsurdrugrecExtCrudServiceImpl implements IMedinsurdrugrecExtCudService, IMedinsurdrugrecExtRService {

	@Override
	public PagingRtnData<MedInsurDrugRecDO> FindPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException {
		FindDrugPagingByQCondAndDownIdBp bp = new FindDrugPagingByQCondAndDownIdBp();
		PagingRtnData<MedInsurDrugRecDO> result = bp.exec(qryRootNodeDto, fileDownRec, orderPart, pg);
		return result;
	}

}
