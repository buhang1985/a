package iih.pmp.pay.cmbc.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import xap.mw.core.data.BizException;

public class CmbcQueryBP {
	
	/**
	 * 支付查询接口
	 * @param dto
	 * @throws BizException 
	 */
	public OrdDO[] doBarcodeQuery(OrdReqDTO dto) throws BizException{
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		CmbcQueryValidateBP validatebp=new CmbcQueryValidateBP();
		return validatebp.getOrdsInfo_new2(dto,qrst);
	}


}
