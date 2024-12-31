package iih.pmp.pay.task;

import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.utils.ContextUtils;
import iih.pmp.param.IPmpPayParamCodeConst;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.utils.PmpTaskLogUtils;
import iih.pmp.utils.PmpPayParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 
 * 批量对账后台任务
 * 
 * @author hao_wu
 * @date 2020年4月20日
 *
 */
public class BatchBillCheckTask implements IBackgroundWorkPlugin {

	/**
	 * 对账开始日期
	 */
	private FDate beginDate;
	/**
	 * 对账结束日期
	 */
	private FDate endDate;

	@Override
	public PreAlertObject executeTask(BgWorkingContext context) throws BizException {

		PmpTaskLogUtils.info("批量对账后台任务开始执行,参数:%s。", context.getKeyMap());

		init(context);

		PmpTaskLogUtils.info("批量对账后台任务初始化结束。");

		billCheck();

		return new PreAlertObject();
	}

	/**
	 * 对账
	 * 
	 * @throws BizException
	 */
	private void billCheck() throws BizException {
		String channelCode = PmpPayParamUtils.getBillCheckTaskChannelCode();
		if (StringUtils.isBlank(channelCode)) {
			String msg = String.format("对账渠道编码为空，请设置对账渠道编码，参数编码:%s。", IPmpPayParamCodeConst.PMP_PAY_CHANNELCODE);
			throw new BizException(msg);
		}

		PmpTaskLogUtils.info("批量对账后台任务，渠道编码：%s。", channelCode);

		for (FDate date = this.beginDate.getDateAfter(0); !date.after(this.endDate); date = date.getDateAfter(1)) {
			FDate billCheckDate = date.getDateAfter(0);
			try {
				billCheck(billCheckDate, channelCode);
			} catch (Exception e) {
				PmpTaskLogUtils.logExAndTitle(e, "对账异常，对账日期：%s,渠道编码：%s。", billCheckDate, channelCode);
			}

		}
	}

	/**
	 * 指定日期对账
	 * 
	 * @param billCheckDate 对账日期
	 * @param channelCode   渠道编码
	 * @throws BizException
	 */
	private void billCheck(FDate billCheckDate, String channelCode) throws BizException {

		PmpTaskLogUtils.info("批量对账后台任务，指定日期对账开始，渠道编码：%s，对账日期:%s。", channelCode, billCheckDate);

		FDateTime billCheckDateTime = new FDateTime(billCheckDate, new FTime("00:00:00"));

		IPmpPayOperatorService opservice = ServiceFinder.find(IPmpPayOperatorService.class);

		// 下载对账单
		BillCheckExceptionDO trade = new BillCheckExceptionDO();
		trade.setSd_chl(channelCode);
		trade.setDt_req(billCheckDateTime);

		PmpTaskLogUtils.info("批量对账后台任务，开始下载对账单，参数:%s。", trade);
		opservice.billCheck(trade);
		PmpTaskLogUtils.info("批量对账后台任务，下载对账单完成。");

		PmpTaskLogUtils.info("批量对账后台任务，开始生成对账异常数据，参数:%s。", trade);
		// 生成对账异常数据
		opservice.getBillCheckRstExp(trade);
		PmpTaskLogUtils.info("批量对账后台任务，生成对账异常数据完成。");

		// 生成对账结果数据
		BillQryReqDTO req = new BillQryReqDTO();
		req.setBill_type(trade.getBill_type());
		req.setDt_bill(billCheckDate);
		req.setSd_chl(trade.getSd_chl());

		PmpTaskLogUtils.info("批量对账后台任务，开始生成对账结果数据，参数:%s。", req);
		BillCheckRstDO[] billCheckRstDOs = opservice.getBillCheckRst(new BillQryReqDTO[] { req });
		PmpTaskLogUtils.info("批量对账后台任务，生成对账结果数据完成,对账结果条数:%s。",
				billCheckRstDOs == null ? "null" : billCheckRstDOs.length);
	}

	/**
	 * 初始化数据
	 * 
	 * @param context
	 * @throws BizException
	 */
	private void init(BgWorkingContext context) throws BizException {
		LinkedHashMap<String, Object> paramMap = context.getKeyMap();
		if (paramMap != null) {
			String execPsnId = (String) paramMap.get(IBatchBillCheckTaskParamCodeConst.EXECPSNID);
			if (StringUtils.isBlank(execPsnId)) {
				throw new BizException("执行人主键不允许为空，请配置执行人主键。");
			}

			ContextUtils.initContextByPsnId(execPsnId);

			String beginDateString = (String) paramMap.get(IBatchBillCheckTaskParamCodeConst.BEGINDATE);
			this.beginDate = new FDate(beginDateString);

			String endDateString = (String) paramMap.get(IBatchBillCheckTaskParamCodeConst.ENDDATE);
			this.endDate = new FDate(endDateString);
		}

		FDate yesterday = AppUtils.getServerDate().getDateAfter(1);

		if (this.beginDate == null) {
			this.beginDate = yesterday;
		}
		if (this.endDate == null) {
			this.beginDate = yesterday;
		}
	}
}
