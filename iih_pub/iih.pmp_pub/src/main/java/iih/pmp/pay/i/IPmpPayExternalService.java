package iih.pmp.pay.i;

import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import xap.mw.core.data.BizException;

public interface IPmpPayExternalService {
		
	/**
	 *    退款交易生成+退款（后台退款调用） 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO refund(OrdReqDTO dto) throws BizException;
	/**
	 * 交易生成+条码支付（暂时无用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO doBarcodePay(OrdReqDTO dto) throws BizException;
	/**
	 * 交易生成+扫码支付（暂时无用）
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	OrdRstDTO doQrcodePay(OrdReqDTO dto) throws BizException;
	/**
	 * 订单撤回
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	 OrdQryRstDTO ReverseOrd(OrdReqDTO dto) throws BizException;
	 
	 /**
	  * 撤回订单查询
	  * @param dto
	  * @return
	  * @throws BizException
	  */
	 OrdQryRstDTO ReverseQueryOrd(OrdReqDTO dto) throws BizException;

}
