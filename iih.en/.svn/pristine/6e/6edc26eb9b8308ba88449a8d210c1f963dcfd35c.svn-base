package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.sc.apt.i.IScAptOutCmdService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 对已收费预约取号
 * 
 * @author liubin
 *
 */
public class CfmPaidAptNewBP {
	/**
	 * 对已收费预约取号
	 * 
	 * @param aptId
	 * @param oprCode
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String exec(final String aptId, final String oprCode) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：CfmPaidAptNewBP参数为:aptId:"+aptId+";oprCode:"+oprCode);
		new SetPsnDocContextBP().exec(oprCode);
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
							IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
							serv.takeApptNoForAptNew(aptId, oprCode);
						} catch (BizException e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
		return null;
	}
}
