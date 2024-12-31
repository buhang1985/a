package iih.bl.cg.bp.oep;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;

/**
 * 费用减免处理
 * @author ly 2018/04/11
 *
 */
public class OpFreeAmtHandleBP {

	/**
	 * 费用减免处理
	 * @param cgAggDos
	 * @param payAggDos
	 * @throws BizException
	 */
	public void exec(String stId, BlcgoepAggDO[] cgAggDos, BlpaypatoepAggDO payAggDos) throws BizException {
	
		int euFreemd = -1000;
		FDouble amtFree = FDouble.ZERO_DBL;
		FBoolean bHaveHpFree= FBoolean.FALSE;//是否包含医保自付减免方式
		FBoolean bHavePatFree= FBoolean.FALSE;//是否包含项目减免方式
		for (BlPayItmPatOepDO patItmDO : payAggDos.getBlPayItmPatOepDO()) {
			
			if (IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(patItmDO.getSd_pm())) {
				euFreemd = BlFreeMdEnum.AMT_FREE_MD;
				amtFree = amtFree.add(patItmDO.getAmt().multiply(patItmDO.getEu_direct()));
			} else if (IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION.equals(patItmDO.getSd_pm())) {
				euFreemd = BlFreeMdEnum.ITM_FREE_MD;
				bHavePatFree=FBoolean.TRUE;
				break;
			}else if (IBdPripmCodeConst.CODE_HP_SELF_FREE.equals(patItmDO.getSd_pm())) {
				euFreemd = BlFreeMdEnum.HP_SELF_FREE;
				bHaveHpFree=FBoolean.TRUE;
				break;
			}
		}
		
		if(euFreemd == -1000)
			return;
		if(FBoolean.TRUE.equals(bHaveHpFree) && (FBoolean.TRUE.equals(bHavePatFree))){
			euFreemd=BlFreeMdEnum.ITM_AND_HP_SELF;
		}
		IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
		if(euFreemd == BlFreeMdEnum.AMT_FREE_MD){
			
			if(amtFree.compareTo(payAggDos.getParentDO().getAmt()) > 0){
				amtFree = payAggDos.getParentDO().getAmt();
			}
			
			incService.calReduceOpAmt(stId, amtFree);
			
		}else{
			List<BlCgItmOepDO> cgItmList = new ArrayList<BlCgItmOepDO>();
			for (BlcgoepAggDO aggDO : cgAggDos) {
				for (BlCgItmOepDO cgItmDO : aggDO.getBlCgItmOepDO()) {
					if(FBoolean.TRUE.equals(cgItmDO.getFg_free())){
						cgItmList.add(cgItmDO);
					}
				}
			}
			
			incService.calReduceOpItm(stId, cgItmList.toArray(new BlCgItmOepDO[0]));
		}
	}
}
