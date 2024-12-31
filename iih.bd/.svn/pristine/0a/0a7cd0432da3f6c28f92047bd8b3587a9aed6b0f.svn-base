package iih.bd.pp.medinsurtreatrec.s;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecExtCudService;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecExtRService;
import iih.bd.pp.medinsurtreatrec.s.bp.FindTreatPagingByQCondAndDownIdBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保诊疗记录扩展服务
 * 
 * @author hao_wu
 *
 */
public class MedinsurtreatrecExtCrudServiceImpl
		implements IMedinsurtreatrecExtCudService, IMedinsurtreatrecExtRService {

	@Override
	public PagingRtnData<MedInsurTreatRecDO> FindPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException {
		FindTreatPagingByQCondAndDownIdBp bp = new FindTreatPagingByQCondAndDownIdBp();
		PagingRtnData<MedInsurTreatRecDO> result = bp.exec(qryRootNodeDto, fileDownRec, orderPart, pg);
		return result;
	}
}
