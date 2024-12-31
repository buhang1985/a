package iih.nm.nqm.nqmimprovl.i;

import iih.nm.com.i.flow.IBaseFormInfoCxt;
import iih.nm.nqm.nqmimprovl.d.NqmImprovDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class INqmImprovMendActorLister implements IActorListener{

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx FormInfo) throws BizException {
		if (!(FormInfo instanceof IBaseFormInfoCxt))
			return null;
		NqmImprovDO improvDO = (NqmImprovDO) ((IBaseFormInfoCxt) FormInfo).getDataInst();
		if (improvDO == null)
			return null;
		String[] userIds = new String[]{improvDO.getCreatedby()};
		return userIds;
	}
}
