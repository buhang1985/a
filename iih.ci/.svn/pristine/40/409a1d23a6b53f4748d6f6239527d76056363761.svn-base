package iih.ci.mrm.s.mrfpmanage;

import iih.ci.mrfp.cimrfpquickfinddo.d.CiMrFpQuickFindDO;
import iih.ci.mrm.i.mrfpmanage.IMrfpManageMainService;
import iih.ci.mrm.s.mrfpmanage.bp.MrfpManageQryBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

@Service(serviceInterfaces = { IMrfpManageMainService.class }, binding = Binding.JSONRPC)
public class MrfpManageMainServiceImpl extends PagingServiceImpl<CiMrFpQuickFindDO> implements IMrfpManageMainService {
	
	@Override
	public PagingRtnData<CiMrFpQuickFindDO> getMrfpSearchList(QryRootNodeDTO qRNode, PaginationInfo pInfo) throws BizException {
		MrfpManageQryBP mrfpManageQryBp = new MrfpManageQryBP();
		return mrfpManageQryBp.getMrfpSearchList(qRNode, pInfo);
	}

}
