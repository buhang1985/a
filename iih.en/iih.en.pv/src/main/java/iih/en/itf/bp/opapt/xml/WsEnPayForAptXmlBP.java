package iih.en.itf.bp.opapt.xml;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.util.EnLogUtil;
import iih.en.itf.bean.input.opapt.WsEnParamPayForApt;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultPayForApt;
import iih.en.itf.i.IEnOpAptInnerService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 收取预约费(XML)
 * 
 * @author liubin
 *
 */
public class WsEnPayForAptXmlBP {
	/**
	 * 收取预约费(XML)
	 * 
	 * @param requestXML
	 * @return
	 * @throws BizException
	 */
	public String exec(String requestXML) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：payForApt入参为:" + requestXML);
		BaseWsResult resultbean = null;
		try {
			final WsEnParamPayForApt param = WsXmlUtils.deSerializeBaseDO(requestXML, WsEnParamPayForApt.class);
			resultbean = this.execute(param);
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("方法：payForApt错误", e);
			resultbean = new BaseWsResult();
			resultbean.setException(e);
		}
		String responseXML = WsXmlUtils.serialize(resultbean);
		EnLogUtil.getInstance().logInfo("方法：payForApt出参为:" + responseXML);
		return responseXML;
	}
	/**
	 * 起事务执行
	 * 
	 * @param param
	 * @return
	 */
	private WsEnResult<WsEnResultPayForApt> execute(final WsEnParamPayForApt param){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<WsEnResult<WsEnResultPayForApt>>() {
			@Override
			public WsEnResult<WsEnResultPayForApt> doInTransaction(TransactionStatus arg0) {
				try {
					IEnOpAptInnerService serv = ServiceFinder.find(IEnOpAptInnerService.class);
					return serv.payForApt(param);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage(), e);
				}
			}
		});
	}
}
