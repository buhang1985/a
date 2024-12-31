package iih.nm.nhr.nhroverwork.i;

import iih.nm.com.i.INmComQueryService;
import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nhr.nhroverwork.d.NhrOverWorkDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class NhrOverWorkActorListener implements IActorListener {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx FormInfo) throws BizException {
		if (!(FormInfo instanceof IBaseFormInfoCxt))
			return null;
		NhrOverWorkDO overWorkDo = (NhrOverWorkDO) ((IBaseFormInfoCxt) FormInfo).getDataInst();
		if (overWorkDo == null)
			return null;
		INmComQueryService com_qry_srv = ServiceFinder.find(INmComQueryService.class);
		String[] userIds = com_qry_srv.getCurrDepNurse(overWorkDo.getId_dep());
		return userIds;
	}
}
