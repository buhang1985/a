package iih.ci.ord.s.ems.ip.base;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.mi.meta.OrdHpRstDTO;
import iih.ci.ord.i.mi.meta.OrdHpVerifyRstDTO;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSaveBP.EmsSaveRstInfo;
import xap.mw.core.data.FArrayList;

/**
 * 构造适应症校验数据
 * 
 * @author HUMS
 *
 */
public class OrdHpIndicRstBP {

	public OrdHpRstDTO getOrdHpRst(EmsSaveRstInfo emsSaveRstInfo) {

		OrdHpRstDTO ordHpRst = new OrdHpRstDTO();
		FArrayList ordHpValidateRstList = new FArrayList();

		CiOrderDO[] orders = emsSaveRstInfo.szOrderInfo;
		OrdSrvDO[] ordSrvs = emsSaveRstInfo.szOrderSrvInfo;
		for (CiOrderDO order : orders) {

			OrdHpVerifyRstDTO ordHpVerifyRst = new OrdHpVerifyRstDTO();
			ordHpVerifyRst.setId_or(order.getId_or());
			ordHpVerifyRst.setCode_or(order.getCode_or());
			ordHpVerifyRst.setName_or(order.getName_or());
			ordHpVerifyRst.setId_pat(order.getId_pat());
			ordHpVerifyRst.setName_pat(order.getPat_name());
			ordHpVerifyRst.setId_en(order.getId_en());
			ordHpVerifyRst.setEu_hpindicjudge(order.getEu_hpindicjudge());
			ordHpVerifyRst.setFg_orhp(order.getFg_orhp());
			ordHpVerifyRst.setSd_srvtp(order.getSd_srvtp());
			ordHpVerifyRst.setName_srvtp(order.getSrvtp_name());
			
			for(OrdSrvDO ordSrv : ordSrvs){
				if((ordSrv.getEu_hpindicjudge() == null || HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()))){
					ordHpValidateRstList.add(ordHpVerifyRst);
					break;
				}
			}
		}
		
		ordHpRst.setOrdHpVerifyRstList(ordHpValidateRstList);

		return ordHpRst;
	}
}
