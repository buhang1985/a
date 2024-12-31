package iih.sfda.aeh.evrptflow.listener.flowconfig;

import iih.sfda.adbd.i.IAdbdQueryService;
import iih.sfda.adbd.i.ISfdaAdbdLogService;
import iih.sfda.aeh.evrptflow.FlowProdefConst;
import iih.sfda.aeh.evrptflow.IAerEvFormInfoCtx;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class AffairsDeptActorListener extends SetAerRptCurrhdlUsers implements IActorListener {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx formInfoCtx) throws Exception {
		if (!(formInfoCtx instanceof IAerEvFormInfoCtx)) {
			return null;
		}
		SfdaAerEvDO sfdaAerEvDO = (SfdaAerEvDO) ((IAerEvFormInfoCtx) formInfoCtx).getDataInst();
		String[] actors = getUserIds(FlowProdefConst.AER_EV_AFFAIRS_FULL_CLASS, sfdaAerEvDO.getId_dep_occur());
		this.exec(actors, formInfoCtx);
		return actors;
	}

	private String[] getUserIds(String fullClass, String id_dep) throws BizException {
		IAdbdQueryService r_srv = ServiceFinder.find(IAdbdQueryService.class);
		ISfdaAdbdLogService sfdaLog = ServiceFinder.find(ISfdaAdbdLogService.class);
		String[] psnDocIds = r_srv.getConfigItmPsnByClassAndDep(fullClass, id_dep);
		String msg = String.format("当事科室节点：计算流程审批人员{个数：%s}", psnDocIds == null || psnDocIds.length == 0 ? "0" : psnDocIds.length);
		sfdaLog.log(msg, Level.INFO);
		if (psnDocIds != null && psnDocIds.length > 0) {
			IUserRService user_rsrv = ServiceFinder.find(IUserRService.class);
			UserDO[] userDos = user_rsrv.findByAttrValStrings("Id_psn", psnDocIds);
			msg = String.format("当事科室节点：计算流程审批用户{个数：%s}", psnDocIds == null || psnDocIds.length == 0 ? "0" : psnDocIds.length);
			sfdaLog.log(msg, Level.INFO);
			if (userDos != null && userDos.length > 0) {
				List<String> userIdList = new ArrayList<String>();
				for (UserDO user : userDos) {
					userIdList.add(user.getId_user());
				}
				return userIdList.toArray(new String[userIdList.size()]);
			}
		}
		return null;
	}
}
