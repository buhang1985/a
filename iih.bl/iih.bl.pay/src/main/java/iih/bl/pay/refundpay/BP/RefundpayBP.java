package iih.bl.pay.refundpay.BP;

import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.blprepayrefund.d.BlPrepayRefundDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.pay.prepayrefund.d.BlPrepayPatRefundDO;
import iih.bl.pay.prepayrefund.i.IPrepayrefundCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 收退住院预交金--强制退费
 * @author houll
 *
 */
public class RefundpayBP {
	public void savePrepay(BlPrepayRefundDTO refundDTO,BlPrepayRDTO dto, BlPrepaySetDTO setDto) throws BizException {
		
		BlPrepayPatRefundDO  refundDO=new BlPrepayPatRefundDO();
		if(refundDTO==null)
		{
			throw new BizException("传入参数为空");
		}
		refundDO.setId_grp(Context.get().getGroupId());
		refundDO.setId_org(Context.get().getOrgId());
		refundDO.setId_emp_pay(refundDTO.getId_emp_author());//授权人ID
		refundDO.setId_reason(refundDTO.getId_reason());//原因
        refundDO.setNote(refundDTO.getNote());//备注
        refundDO.setSd_reason(refundDTO.getSd_reason());
        refundDO.setId_paypat(refundDTO.getId_paypat());//预交金记录ID
        refundDO.setDt_pay(BlFlowContextUtil.getNowTime());
        refundDO.setId_dep_pay(Context.get().getDeptId());
       
        
        IPrepayrefundCudService payService = ServiceFinder.find(IPrepayrefundCudService.class);
		refundDO.setStatus(DOStatus.NEW);
		payService.insert(new BlPrepayPatRefundDO[]{refundDO});
		
		//调用退费现有逻辑
		IBlPrepayCmdService prepayService =ServiceFinder.find(IBlPrepayCmdService.class);
		prepayService.refund(dto, setDto);
						
	}
}

