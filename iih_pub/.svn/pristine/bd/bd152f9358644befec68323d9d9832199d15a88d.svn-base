package iih.nm.nqm.nqmimprovl.i;

import iih.nm.com.i.INmComQueryService;
import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nbd.nbddepca.d.NbdDepDO;
import iih.nm.nbd.nbddepca.i.INbdDepDORService;
import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class INqmImprovSubmitActorListener implements IActorListener{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx FormInfo) throws BizException {
		if (!(FormInfo instanceof IBaseFormInfoCxt))
			return null;
		NqmImprovDO improvDO = (NqmImprovDO) ((IBaseFormInfoCxt) FormInfo).getDataInst();
		if (improvDO == null)
			return null;
		INmComQueryService com_qry_srv = ServiceFinder.find(INmComQueryService.class);
		String[] userIds = com_qry_srv.getCurrDepNurse(improvDO.getId_dep());
		return userIds;
	}
}
