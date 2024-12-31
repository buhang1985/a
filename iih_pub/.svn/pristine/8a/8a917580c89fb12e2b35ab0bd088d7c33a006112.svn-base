package iih.nm.nhr.nmnhrschedrp.i;

import iih.nm.com.i.INmComQueryService;
import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class NhrSchedRpActorListener implements IActorListener {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx FormInfo) throws BizException {
		if (!(FormInfo instanceof IBaseFormInfoCxt))
			return null;
		NhrSchedRpDO schedRpDo = (NhrSchedRpDO) ((IBaseFormInfoCxt) FormInfo).getDataInst();
		if (schedRpDo == null)
			return null;
		INmComQueryService com_qry_srv = ServiceFinder.find(INmComQueryService.class);
		String[] userIds = com_qry_srv.getCurrDepNurse(schedRpDo.getId_dep_apy());
		return userIds;
	}
}
