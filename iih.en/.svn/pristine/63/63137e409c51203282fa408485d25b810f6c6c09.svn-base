package iih.en.itf.bp.opapt.xml;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.itf.bean.input.opapt.WsEnParamMakeApt;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultMakeApt;
import iih.en.itf.i.IEnOpAptInnerService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约门诊号(XML)
 * 
 * @author liubin
 *
 */
public class WsEnMakeAptXmlBP {
	/**
	 * 预约门诊号(XML)
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String exec(String requestXML) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：makeApt入参为:" + requestXML);
		WsEnResult<WsEnResultMakeApt> resultbean = null;
		try {
			final WsEnParamMakeApt param = WsXmlUtils.deSerializeBaseDO(requestXML, WsEnParamMakeApt.class);
			resultbean = this.execute(param);
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("方法：makeApt错误", e);
			resultbean =new  WsEnResult<WsEnResultMakeApt>();
			resultbean.setException(e);
		}
		String responseXML = WsXmlUtils.serialize(resultbean);
		EnLogUtil.getInstance().logInfo("方法：makeApt出参为:" + responseXML);
		return responseXML;
	}
	/**
	 * 起事务执行
	 * 
	 * @param param
	 * @return
	 */
	private WsEnResult<WsEnResultMakeApt> execute(final WsEnParamMakeApt param){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<WsEnResult<WsEnResultMakeApt>>() {
			@Override
			public WsEnResult<WsEnResultMakeApt> doInTransaction(TransactionStatus arg0) {
				try {
					IEnOpAptInnerService serv = ServiceFinder.find(IEnOpAptInnerService.class);
					return serv.makeApt(param);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage(), e);
				}
			}
		});
	}
}
