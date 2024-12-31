package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.pmp.pay.billcheckrst.d.BillCheckRstDO;
import iih.pmp.pay.ordqryrstdto.d.BillQryReqDTO;
import iih.pmp.pay.ordqryrstdto.d.CmbcBillTypeEnum;
import iih.pmp.pay.udi.PmpPayConst;
import xap.mw.core.data.BizException;

public class CmbcBillFeeQryBP {
	public BillCheckRstDO[] exec(BillQryReqDTO[] dtos) throws BizException {
		if(dtos==null||dtos.length==0)return null;
		List<BillQryReqDTO> wxparam=new ArrayList<>();
		List<BillQryReqDTO>zfbparam=new ArrayList<>();
		List<BillCheckRstDO> rstlist=new ArrayList<>();
		for (BillQryReqDTO b : dtos) {
			if(!PmpPayConst.CMBC_CHANNEL_CODE.equals(b.getSd_chl()))continue;
			if(CmbcBillTypeEnum.WX.equals(b.getBill_type())) {
				wxparam.add(b);
			}else if(CmbcBillTypeEnum.ZFB.equals(b.getBill_type())) {
				zfbparam.add(b);
			}
		}
		if(wxparam.size()>0) {
			BillCheckRstDO[] rst=new CmbcBillFeeQryExcutorBP().exec(wxparam.toArray(new BillQryReqDTO[0]),CmbcBillTypeEnum.WX);
			if(rst!=null&&rst.length>0) {
				rstlist.addAll(Arrays.asList(rst));
			}
		}
		if(zfbparam.size()>0) {
			BillCheckRstDO[] rst=new CmbcBillFeeQryExcutorBP().exec(zfbparam.toArray(new BillQryReqDTO[0]),CmbcBillTypeEnum.ZFB);
            if(rst!=null&&rst.length>0) {
            	rstlist.addAll(Arrays.asList(rst));
			}
		}
		return rstlist.toArray(new BillCheckRstDO[0]);
	}

}
