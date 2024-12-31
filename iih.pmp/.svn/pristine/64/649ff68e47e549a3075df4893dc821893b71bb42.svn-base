package iih.pmp.pay.task;

import iih.bd.base.utils.AppUtils;
import iih.bd.utils.ContextUtils;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 对账后台任务</br>
 * 如果包含微信对账，任务执行时间需在10:00之后
 * 
 * @author hao_wu
 * @date 2020-4-16
 */
public class ReconciliationTask implements IBackgroundWorkPlugin {
	private static String PMP_CHANNELCODE="pmp_channelcode";
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		InitContext(arg0);
		IPmpPayOperatorService opservice = ServiceFinder.find(IPmpPayOperatorService.class);
		PreAlertObject obj = new PreAlertObject();
		BillCheckExceptionDO trade = new BillCheckExceptionDO();
		trade.setSd_chl(ParamsetQryUtil.getParaString(Context.get().getOrgId(), PMP_CHANNELCODE));
		trade.setDt_req(AppUtils.getServerDateTime().getDateTimeBefore(1));
		opservice.billCheck(trade);
		opservice.getBillCheckRstExp(trade);
		BillQryReqDTO req = new BillQryReqDTO();
		req.setBill_type(trade.getBill_type());
		req.setDt_bill(AppUtils.getServerDate().getDateBefore(1));
		req.setSd_chl(trade.getSd_chl());
		opservice.getBillCheckRst(new BillQryReqDTO[] { req });

		return obj;
	}
	
	private void InitContext(BgWorkingContext bgwContext) throws BizException {
		ContextUtils.initContextByPsnId((String) bgwContext.getKeyMap().get("id_psn"));
	}

}
