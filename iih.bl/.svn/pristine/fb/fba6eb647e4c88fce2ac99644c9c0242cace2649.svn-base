package iih.bl.pay.blprepay.ep;

import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blprepaypatpmamtoep.d.BlPrepayPatPmamtOepDO;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepCudService;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 修改患者预交金收退款总额表
 * @author li_pengying
 *
 */
public class BlPreayPMamtOepDOEp {
	
	/**
	 * 修改患者预交金收退款总额表
	 * @param id_pat 患者ID
	 * @param direct 收退款方向
	 * @param amt 收退款金额
	 * @param id_pm 收付款方式ID
	 * @param sd_pm 收付款方式编码
	 * @throws BizException 
	 * */
	public void updateBlPayMamtOepInfo(String id_pat,Integer direct,FDouble amt,String id_pm,String sd_pm) throws BizException{
		IBlprepaypatpmamtoepRService rservice = ServiceFinder.find(IBlprepaypatpmamtoepRService.class);
		IBlprepaypatpmamtoepCudService cservice = ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
		StringBuffer sql = new StringBuffer();
		sql.append(" a0.id_pat = '").append(id_pat).append("' and a0.id_pm = '").append(id_pm).append("' ");
		BlPrepayPatPmamtOepDO[] payArr = rservice.find(sql.toString(), null, FBoolean.FALSE);
		BlPrepayPatPmamtOepDO blPayOepDO = null;
		if(payArr == null || payArr.length == 0){
			blPayOepDO = new BlPrepayPatPmamtOepDO();
			blPayOepDO.setId_org(Context.get().getOrgId());
			blPayOepDO.setId_grp(Context.get().getGroupId());
			blPayOepDO.setId_pat(id_pat);
			blPayOepDO.setId_pm(id_pm);
			blPayOepDO.setSd_pm(sd_pm);
			if(BookRtnDirectEnum.CHARGE == direct){
				blPayOepDO.setAmt_in(amt);
				blPayOepDO.setAmt_out(new FDouble(0));
			}else{
				blPayOepDO.setAmt_in(new FDouble(0));
				blPayOepDO.setAmt_out(amt);
			}
			blPayOepDO.setStatus(DOStatus.NEW);
		}else{
			blPayOepDO = payArr[0];
			if(BookRtnDirectEnum.CHARGE == direct){
				blPayOepDO.setAmt_in(blPayOepDO.getAmt_in().add(amt));
			}else{
				blPayOepDO.setAmt_out(blPayOepDO.getAmt_out().add(amt));
			}
			blPayOepDO.setStatus(DOStatus.UPDATED);
		}
		cservice.save(new BlPrepayPatPmamtOepDO[]{blPayOepDO});
	}
}
