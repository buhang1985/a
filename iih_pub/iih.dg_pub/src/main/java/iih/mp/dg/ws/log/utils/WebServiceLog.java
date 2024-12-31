package iih.mp.dg.ws.log.utils;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.base.utils.AppUtils;
import iih.mp.dg.i.IMpDgLogService;
import iih.mp.dg.webservicereissue.d.WebServiceReissueDO;
import iih.mp.dg.webservicereissue.i.IWebservicereissueCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础WebService调用Log工具类
 * 
 * @author hao_wu 2018-7-30
 *
 */
public class WebServiceLog {

	/**
	 * 日志写数据库服务
	 */
	private IWebservicereissueCudService _webservicereissueCudService;

	/**
	 * 写日志服务
	 */
	private IMpDgLogService _mpDgLogService;

	/**
	 * 接口全类名
	 */
	private String _interfaceFullName;
	/**
	 * 上下文Key
	 */
	private String _contextKey;

	public WebServiceLog(String interfaceFullName) {
		this(interfaceFullName, "WsLog");
	}

	public WebServiceLog(String interfaceFullName, String contextKey) {
		this._interfaceFullName = interfaceFullName;
		this._contextKey = contextKey;

		this._webservicereissueCudService = ServiceFinder.find(IWebservicereissueCudService.class);
		this._mpDgLogService = ServiceFinder.find(IMpDgLogService.class);
	}

	/**
	 * 获取上下文标识
	 * 
	 * @return
	 */
	protected String getContextKey() {
		return this._contextKey;
	}

	/**
	 * 添加WebService调用入参日志
	 * 
	 * @param contextKey
	 * @param interfaceFullName
	 * @param paramXml
	 * @throws BizException
	 */
	public void begin(final String paramXml) {

		final String contextKey = getContextKey();
		final String interfaceFullName = this._interfaceFullName;

		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						WebServiceReissueDO webServiceReissueDO = new WebServiceReissueDO();
						webServiceReissueDO.setId_grp(Context.get().getGroupId());
						webServiceReissueDO.setId_org(Context.get().getOrgId());
						webServiceReissueDO.setSer_interface(interfaceFullName);
						webServiceReissueDO.setCall_time(AppUtils.getServerDateTime());
						webServiceReissueDO.setCall_content(paramXml);

						WebServiceReissueDO[] result = _webservicereissueCudService
								.insert(new WebServiceReissueDO[] { webServiceReissueDO });
						Context.get().setAttribute(contextKey, result[0]);
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
					return null;
				}
			});
		} catch (Exception e) {
			writeLog(e.getMessage());
		}
	}

	/**
	 * 更新WebService调用结果Log
	 * 
	 * @param contextKey
	 * @param resultXml
	 * @throws BizException
	 */
	public void end(final String resultXml) {

		final String contextKey = getContextKey();

		final WebServiceReissueDO webServiceReissueDO = (WebServiceReissueDO) Context.get().getAttribute(contextKey);
		if (webServiceReissueDO == null) {
			return;
		}

		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						webServiceReissueDO.setReturn_time(AppUtils.getServerDateTime());
						webServiceReissueDO.setReturn_content(resultXml);

						_webservicereissueCudService.update(new WebServiceReissueDO[] { webServiceReissueDO });
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
					return null;
				}
			});
		} catch (Exception e) {
			writeLog(e.getMessage());
		}
	}

	/**
	 * 更新WebService调用结果Log
	 * 
	 * @param e
	 */
	public void end(Exception e) {
		this.end(ExceptionUtils.getFullStackTrace(e));
	}

	/**
	 * 写日志
	 * 
	 * @param log
	 */
	private void writeLog(String log) {
		_mpDgLogService.log(log, Level.INFO);
	}
}
