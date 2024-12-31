package iih.en.que.s;

import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.que.i.IEnQueCmdService;
import iih.en.que.i.IEnQueQryService;
import xap.lui.system.keepalive.ContextVO;
import xap.lui.system.keepalive.IClientTimeoutListener;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;

public class ClientTimeout4OpSiteListener implements IClientTimeoutListener{
	/**
	 * 节点FuncCode
	 */
	@Override
	public String getFuncCode() {
		return "461005";
	}
	@Override
	public void processClientTimeout(String arg0, ContextVO ctx) {
		try {
			Context.get().setGroupId(ctx.getGroupId());
			Context.get().setOrgId(ctx.getOrgId());
			IEnQueQryService qryServ = ServiceFinder.find(IEnQueQryService.class);
			QueSiteDO site = qryServ.getQueSiteByPc(arg0);
			if(site != null && site.getEu_pause()!=null && !site.getEu_pause().equals(PauseEnum.OFFLINE)){
				IEnQueCmdService cmdServ = ServiceFinder.find(IEnQueCmdService.class);
				cmdServ.logoutOpSite(site.getId_quesite(), null);
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
}
