package iih.pmp.pay.cmbc.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;

public class CmbcQueryBP2 {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
public OrdQryRstDTO[] doBarcodeQuery(OrdReqDTO dto) throws BizException{
		
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		CmbcQueryValidateBP validatebp=new CmbcQueryValidateBP();
		OrdDO[] ords= validatebp.getOrdsInfo_new(dto,qrst);
		if(ords==null||ords.length==0||ords.length>1)return null;
		OrdQryRstDTO rst=pmputils.ord2qryrst(ords[0]);
		pmputils.OrdQryRstcopy(qrst, rst);		
		return new OrdQryRstDTO[]{rst};
	}

}
