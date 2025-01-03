package iih.bl.cc.s.bp;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.cc.blcc.i.IBlccCudService;
import iih.bl.cc.ep.CcElecIncEP;
import iih.bl.cc.ep.CcIncEP;
import iih.bl.cc.ep.CcPmEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class DoCancelCheckoutBP {
	public BlccAggDO[] exec(String id_user, String id_org, BlccAggDO[] blccAggDOArr) throws BizException{
		if(blccAggDOArr == null){
			return null;
		}
		for(BlccAggDO blccAggDO : blccAggDOArr){
			StringBuilder sqlStr = new StringBuilder();
			sqlStr.append(" a0.id_cc = '").append(blccAggDO.getParentDO().getId_cc()).append("'");
			String sd_cctp=blccAggDO.getParentDO().getSd_cctp();
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
				//1.修改结算表(BL_ST_OEP)中结账标志为未结账
				UpdateBlStOepForCancelBP updateBlStOepForCancelBP = new UpdateBlStOepForCancelBP();
				updateBlStOepForCancelBP.exec(sqlStr.toString(), blccAggDO);
				
				//2.修改结算收付款表(BL_PAY_PAT_OEP)中结账标志为未结账
				CcPmEP ccPmEP= new CcPmEP();
				ccPmEP.updatePayPatOepDOForCancel(sqlStr.toString(), blccAggDO);
			}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp)||IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
				//1.修改结算表(BL_ST_IP)中结账标志为未结账
				UpdateBlStIpForCancelBP updateBlStIpForCancelBP= new UpdateBlStIpForCancelBP();
				updateBlStIpForCancelBP.exec(sqlStr.toString());

				//2.修改结算收付款表(BL_PAY_PAT_IP)中结账标志为未结账
				CcPmEP ccPmEP= new CcPmEP();
				ccPmEP.updatePayPatIpDOForCanecl(sqlStr.toString());
			}
			
			//3.修改预交金表(BL_PREPAY_PAT)中结账标志为未结账
			UpdatePrePayPatForCancelBP updatePrePayPatForCancelBP= new UpdatePrePayPatForCancelBP();
			updatePrePayPatForCancelBP.exec(sqlStr.toString());
			
			//4.修改预交金_预交金票据(BL_PREPAY_PAT_RCPT)中的结账标志为未结账 by lim 2018-06-19 新加
			UpdatePrePayPatRcptForCancelBP updatePrePayPatRcptForCancelBP= new UpdatePrePayPatRcptForCancelBP();
			updatePrePayPatRcptForCancelBP.exec(sqlStr.toString());
			
			//5.修改门诊/住院发票表（BL_INC_OEP/BL_INC_IP）中结账标志为未结账----新加
			CcIncEP ccIncEP= new CcIncEP();
			if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）				
				ccIncEP.updateIncOepInfosForCancel(blccAggDO);
			}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
				ccIncEP.updateIncIpInfosForCancel(blccAggDO);
			}
			
			//6.修改电子发票信息（bl_inc_oep_paper）
			CcElecIncEP ccElecIncEP= new CcElecIncEP();
			if (IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)) {// 门诊（患者）
				ccElecIncEP.updateElecIncOepInfosForCancel(blccAggDO);
			}
			
			//7.修改空白作废票据表(BL_INC_CANC)中结账标志为未结账
			ccIncEP.updateIncCancOepInfosForCancel(sqlStr.toString());
			
			//8.修改专用款表结账标志
			UpdatePaySpclForCancelBP updatePaySpclForCancelBP= new UpdatePaySpclForCancelBP();
			updatePaySpclForCancelBP.exec(sqlStr.toString());
			
			blccAggDO.getParentDO().setFg_canc(FBoolean.TRUE);
			blccAggDO.getParentDO().setDt_canc(new FDateTime());
			blccAggDO.getParentDO().setStatus(DOStatus.UPDATED);
		}
		//设置取消结账标志为已取消
		IBlccCudService blccService = ServiceFinder.find(IBlccCudService.class);
		blccAggDOArr = blccService.save(blccAggDOArr);
		
		//发送事件
		//this.invokeDelEvent(blccAggDOArr[0]);
		
		return blccAggDOArr;
	}
}
