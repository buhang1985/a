package iih.sfda.aeh.evrptflow.listener.flowconfig;

import iih.sfda.adbd.i.ISfdaAdbdLogService;
import xap.mw.core.data.Context;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class CommitActorListener extends SetAerRptCurrhdlUsers implements IActorListener {

	@Override
	public String[] getActors(WfFormInfoCtx wfFormInfoCtx) throws Exception {
		String curr_user = Context.get().getUserId();
		ISfdaAdbdLogService sfdaLog = ServiceFinder.find(ISfdaAdbdLogService.class);
		String msg = String.format("事件提交节点：提交人用户id：%s}", curr_user);
		sfdaLog.log(msg, Level.INFO);
		String[] users = new String[] { curr_user };
		this.exec(users, wfFormInfoCtx);
		return users;
	}

}
