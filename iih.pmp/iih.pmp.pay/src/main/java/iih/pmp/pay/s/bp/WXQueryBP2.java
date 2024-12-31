package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.wxvalidate.WXQueryValidateBP;
import xap.mw.core.data.BizException;

public class WXQueryBP2 {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public OrdQryRstDTO[] doBarcodeQuery(OrdReqDTO dto) throws BizException{
		
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		WXQueryValidateBP validatebp=new WXQueryValidateBP();
		OrdDO[] ords= validatebp.getOrdsInfo_new(dto,qrst);
		if(ords==null||ords.length==0||ords.length>1)return null;
		OrdQryRstDTO rst=pmputils.ord2qryrst(ords[0]);
		rst.setTrade_no(qrst.getTrade_no());
		rst.setTradetime(qrst.getTradetime());
		rst.setBiz_status(qrst.getBiz_status());
		rst.setErr_code(qrst.getErr_code());
		rst.setErr_code_des(qrst.getErr_code_des());
		return new OrdQryRstDTO[]{rst};
	}

}
