package iih.sfda.aeh.evrptflow.listener.flowconfig;

import iih.sfda.aeh.evrptflow.IAerEvFormInfoCtx;
import iih.sfda.aer.sfdaaerev.d.SfdaAerEvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.wf.af.server.WfFormInfoCtx;

public class SetAerRptCurrhdlUsers {

	protected void exec(String[] userIds, WfFormInfoCtx formCtx) throws BizException {
		if (!isLegal(userIds, formCtx))
			return;

		Dowork(userIds, formCtx);
	}

	private Boolean isLegal(String[] userIds, WfFormInfoCtx formCtx) throws BizException {
		if (userIds == null || userIds.length == 0 || formCtx == null)
			return false;
		return true;
	}

	private void Dowork(String[] userIds, WfFormInfoCtx formCtx) throws BizException {
		String user_ids = "";
		for (String user_id : userIds) {
			user_ids += (StringUtil.isEmptyWithTrim(user_ids) ? "" : ",") + user_id;
		}

		IAerEvFormInfoCtx evFormCxt = (IAerEvFormInfoCtx) formCtx;
		SfdaAerEvDO aerEvDo = (SfdaAerEvDO) evFormCxt.getDataInst();
		aerEvDo.setId_currhdl_user(user_ids);
	}
}
