package iih.nm.nhr.nmnhrschedlv.i;

import iih.nm.com.i.INmComQueryService;
import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class NhrSchedLvActorListener implements IActorListener {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx FormInfo) throws BizException {
		if (!(FormInfo instanceof IBaseFormInfoCxt))
			return null;
		NmNhrSchedLvDO schedLvDo = (NmNhrSchedLvDO) ((IBaseFormInfoCxt) FormInfo).getDataInst();
		if (schedLvDo == null)
			return null;
		INmComQueryService com_qry_srv = ServiceFinder.find(INmComQueryService.class);
		String[] userIds = com_qry_srv.getCurrDepNurse(schedLvDo.getId_dep_apy());
		return userIds;
	}
}
