package iih.bl.pay.ip.s;

import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.i.IBlPayCmdService;
import iih.bl.pay.ip.i.IIpSettlementService;
import iih.bl.pay.ip.s.bp.IpIncRePrintBp;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 住院结算相关接口实现类
 * @author yangyang
 * @Date 2017-10-20
 */
@Service(serviceInterfaces = { IIpSettlementService.class }, binding = Binding.JSONRPC)
public class IpSettlementServiceImpl implements IIpSettlementService {

	@Override
	public BlStIpPayInvoceInfoDTO doIpSelfPay() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/** 发票补打
	 * @param strCodeSt 结算流水号
	 * @param operatorInfoDto 操作人员信息
	 * @return 发票信息
	 * @throws BizException
	 */
	@Override
	public BlStIpPayInvoceInfoDTO doReprintInc(String strCodeSt,
			OperatorInfoDTO operatorInfoDto) throws BizException {
		IpIncRePrintBp handlerBp=new IpIncRePrintBp();
		return handlerBp.exec(strCodeSt, operatorInfoDto);
	}

}
