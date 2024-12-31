package iih.pmp.pay.custom.bp;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;

public class PmpQueryBP {

	/**
	 * 支付查询接口
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public OrdDO[] doBarcodeQuery(OrdReqDTO dto) throws BizException {
		OrdQryRstDTO qrst = new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		PmpQueryValidateBP validatebp = new PmpQueryValidateBP(pay,dataconvert);
		return validatebp.getOrdsInfo_new(dto, qrst);
	}

}
