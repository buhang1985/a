package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.util.wxvalidate.WXPayValidateBP;
import iih.pmp.pay.util.wxvalidate.WXQueryValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDate;

public class WXQueryBP {
	
	/**
	 * 支付查询接口
	 * @param dto
	 * @throws BizException 
	 */
	public OrdDO[] doBarcodeQuery(OrdReqDTO dto) throws BizException{
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		WXQueryValidateBP validatebp=new WXQueryValidateBP();
		return validatebp.getOrdsInfo_new(dto,qrst);
	}


}
