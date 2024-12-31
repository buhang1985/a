package iih.bl.inc.s.bp.opinc.util;

import iih.bd.base.utils.AppUtils;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;

/**
 * 门诊发票作废日志数据组装工具类
 * @author ly 2018/06/22
 *
 */
public class OpIncCancLogAssembleUtil {

	/**
	 * 门诊发票作废日志
	 * @param incDO
	 * @param codeIncpkgNew
	 * @param incnoNew 
	 * @return
	 */
	public static BlIncOepCancLogDO assemble(BlIncOepDO incDO,String codeIncpkgNew,String incnoNew){
		BlIncOepCancLogDO cancLogDO =  new BlIncOepCancLogDO();
		cancLogDO.setId_org(Context.get().getOrgId());
		cancLogDO.setId_grp(Context.get().getGroupId());
		cancLogDO.setId_pat(incDO.getId_pat());
		cancLogDO.setId_entp(incDO.getId_enttp());
		cancLogDO.setEu_direct(incDO.getEu_direct());
		cancLogDO.setId_incca(incDO.getId_incca());
		cancLogDO.setCode_incpkg(incDO.getCode_incpkg());
		cancLogDO.setIncno(incDO.getIncno());
		cancLogDO.setCode_incpkg_new(codeIncpkgNew);
		cancLogDO.setIncno_new(incnoNew);
		cancLogDO.setEu_freemd(incDO.getEu_freemd());
		cancLogDO.setAmt_free(incDO.getAmt_free());
		cancLogDO.setAmt(incDO.getAmt());
		cancLogDO.setAmt_pat(incDO.getAmt_pat());
		cancLogDO.setNote(incDO.getNote());
		cancLogDO.setId_emp_inc(incDO.getId_emp_inc());
		cancLogDO.setId_dep_inc(incDO.getId_dep_inc());
		cancLogDO.setId_emp_inc_new(Context.get().getStuffId());
		cancLogDO.setId_dep_inc_new(Context.get().getDeptId());
		cancLogDO.setId_stoep(incDO.getId_stoep());
		cancLogDO.setFg_fundpay(incDO.getFg_fundpay());
		cancLogDO.setFg_hp_card(incDO.getFg_hp_card());
		cancLogDO.setTimes_prn(incDO.getTimes_prn());
		cancLogDO.setDt_inc(incDO.getDt_inc());
		cancLogDO.setDt_inc_new(AppUtils.getServerDateTime());
		cancLogDO.setEu_printmd(incDO.getEu_printmd());
		cancLogDO.setStatus(DOStatus.NEW);
		
		return cancLogDO;
	}
}
