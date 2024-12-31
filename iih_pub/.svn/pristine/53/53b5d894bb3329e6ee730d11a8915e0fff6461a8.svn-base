package iih.bl.pay.ip.i;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import xap.mw.core.data.BizException;


/** 住院收付款相关接口
 * @author yangyang
 * @Date 2017-10-20
 */
public interface IIpSettlementService {
	
	/** 发票补打
	 * @param strCodeSt 结算流水号
	 * @param operatorInfoDto 操作人员信息
	 * @return 发票信息
	 * @throws BizException
	 */
	BlStIpPayInvoceInfoDTO doReprintInc(String strCodeSt, OperatorInfoDTO operatorInfoDto) throws BizException;

	/**
	 * @return
	 * @throws BizException
	 */
	BlStIpPayInvoceInfoDTO doIpSelfPay() throws BizException;
}

