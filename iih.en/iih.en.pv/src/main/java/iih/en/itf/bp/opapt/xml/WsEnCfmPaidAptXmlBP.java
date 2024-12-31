package iih.en.itf.bp.opapt.xml;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.itf.bean.input.opapt.WsEnParamCfmPaidApt;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultCfmPaidApt;
import iih.en.itf.i.IEnOpAptInnerService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 已收费预约取号(XML)
 * 
 * @author liubin
 *
 */
public class WsEnCfmPaidAptXmlBP {
	/**
	 * 预约门诊号(XML)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String exec(String requestXML) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：cfmPaidApt入参为:" + requestXML);
		WsEnResult<WsEnResultCfmPaidApt> resultbean = null;
		try {
			final WsEnParamCfmPaidApt param = WsXmlUtils.deSerializeBaseDO(requestXML, WsEnParamCfmPaidApt.class);
			resultbean = this.execute(param);
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("方法：cfmPaidApt错误", e);
			resultbean =new  WsEnResult<WsEnResultCfmPaidApt>();
			resultbean.setException(e);
		}
		String responseXML = WsXmlUtils.serialize(resultbean);
		EnLogUtil.getInstance().logInfo("方法：cfmPaidApt出参为:" + responseXML);
		return responseXML;
	}
	/**
	 * 起事务执行
	 * 
	 * @param param
	 * @return
	 */
	private WsEnResult<WsEnResultCfmPaidApt> execute(final WsEnParamCfmPaidApt param){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<WsEnResult<WsEnResultCfmPaidApt>>() {
			@Override
			public WsEnResult<WsEnResultCfmPaidApt> doInTransaction(TransactionStatus arg0) {
				try {
					IEnOpAptInnerService serv = ServiceFinder.find(IEnOpAptInnerService.class);
					return serv.cfmPaidApt(param);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage(), e);
				}
			}
		});
	}
}
