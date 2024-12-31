package iih.bl.inc.s.bp.inc.util;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊作废票数据组装工具类
 * @author ly 2018/04/12
 *
 */
public class IncCancAssembleUtil {

	/**
	 * 组装作废发票数据--重打
	 * @param incDO
	 * @return
	 */
	public static BlIncCancDO assemble(BlIncOepDO incDO){
		BlIncCancDO cancDO = new BlIncCancDO();
		cancDO.setCode_incpkg(incDO.getCode_incpkg());
		cancDO.setIncno(incDO.getIncno());
		cancDO.setId_emp_canc(Context.get().getStuffId());
		cancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_PRINT_ERROR);
		cancDO.setId_reason_canc(IBdPpCodeTypeConst.ID_PRINT_ERROR);
		cancDO.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
		cancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_PRINT_ERROR);
		cancDO.setDt_canc(AppUtils.getServerDateTime());
		cancDO.setFg_canc(FBoolean.TRUE);
		cancDO.setId_cc(null);
		cancDO.setId_grp(Context.get().getGroupId());
		cancDO.setId_org(Context.get().getOrgId());
		cancDO.setEu_printmd(incDO.getEu_printmd());
		cancDO.setStatus(DOStatus.NEW);
		
		return cancDO;
	}
	
	public static BlIncCancDO assembleWithReason(BlIncOepDO incDO, BlRtnReasonDTO reasonDTO){
		BlIncCancDO cancDO = new BlIncCancDO();
		cancDO.setCode_incpkg(incDO.getCode_incpkg());
		cancDO.setIncno(incDO.getIncno());
		cancDO.setId_emp_canc(Context.get().getStuffId());
		cancDO.setSd_reason_canc(reasonDTO.getId_udidoc());
		cancDO.setId_reason_canc(reasonDTO.getCode());
		cancDO.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
		cancDO.setDes_reason_canc(reasonDTO.getName());
		cancDO.setDt_canc(AppUtils.getServerDateTime());
		cancDO.setFg_canc(FBoolean.TRUE);
		cancDO.setId_cc(null);
		cancDO.setId_grp(Context.get().getGroupId());
		cancDO.setId_org(Context.get().getOrgId());
		cancDO.setEu_printmd(incDO.getEu_printmd());
		cancDO.setStatus(DOStatus.NEW);
		
		return cancDO;
	}
}
