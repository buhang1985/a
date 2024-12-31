package iih.en.pv.s.bp.op.ws;

import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.sc.apt.i.IScAptOutCmdService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约付费
 * @author 
 *
 */
public class PayForAptBP {
	/**
	 * 付费
	 * @param patCode 患者编码
	 * @param patType 患者类型
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param regDate 挂号日期
	 * @param dayslotType 午别类型
	 * @param seqNo 顺序号
	 * @param orderNo 第三方订单号
	 * @param payType 支付方式（微信，支付宝等）
	 * @param accNo 账号
	 * @param money 金额
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ResultBean exec(final String patCode,final String patType,final String deptCode,final String doctorCode,final String regDate,final String dayslotType,final String seqNo,final String orderNo,final String payType,final String accNo,final String money,final String oprCode) throws BizException{
		ResultBean resultDto = new ResultBean();
		resultDto.setFlag("0");
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
						IScAptOutCmdService service = ServiceFinder.find(IScAptOutCmdService.class);
						String errorMsg = service.payForApt(patCode,patType, deptCode, doctorCode, regDate, dayslotType, seqNo, orderNo, payType, accNo, money, oprCode);
						} catch (BizException e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			resultDto.setFlag("1");
			resultDto.setMsg(ex.getMessage());
		}
		return resultDto;
	}
	
	
}
