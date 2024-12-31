package iih.en.itf.bp.opapt.xml;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.en.comm.util.EnLogUtil;
import iih.en.itf.bean.input.opapt.WsEnParamRegPricing;
import iih.en.itf.bean.output.WsEnResult;
import iih.en.itf.bean.output.opapt.WsEnResultRegPricing;
import iih.en.itf.i.IEnOpAptInnerService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 挂号划价(XML)
 * 
 * @author liubin
 *
 */
public class WsEnRegPricingXmlBP {
	/**
	 * 挂号划价(XML)
	 * 
	 * @param requestXML
	 * @return
	 * @throws BizException
	 */
	public String exec(String requestXML) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：regPricing入参为:" + requestXML);
		BaseWsResult resultbean = null;
		try {
			final WsEnParamRegPricing param = WsXmlUtils.deSerializeBaseDO(requestXML, WsEnParamRegPricing.class);
			resultbean = this.execute(param);
		} catch (Exception e) {
			EnLogUtil.getInstance().logError("方法：regPricing错误", e);
			resultbean = new BaseWsResult();
			resultbean.setException(e);
		}
		String responseXML = WsXmlUtils.serialize(resultbean);
		EnLogUtil.getInstance().logInfo("方法：regPricing出参为:" + responseXML);
		return responseXML;
	}
	/**
	 * 起事务执行
	 * 
	 * @param param
	 * @return
	 */
	private WsEnResult<WsEnResultRegPricing> execute(final WsEnParamRegPricing param){
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<WsEnResult<WsEnResultRegPricing>>() {
			@Override
			public WsEnResult<WsEnResultRegPricing> doInTransaction(TransactionStatus arg0) {
				try {
					IEnOpAptInnerService serv = ServiceFinder.find(IEnOpAptInnerService.class);
					return serv.regPricing(param);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage(), e);
				}
			}
		});
	}
}
