package iih.bl.pay.s.bp.util;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 预交金票据打印数据组装类
 * @author ly 2018/06/21
 *
 */
public class PrepayReceiptAssembleUtil {

	/**
	 * 数据组装
	 * @param prepayDO 预交金数据
	 * @param codeIncpkg 票据包
	 * @param incno 当前票据号
	 * @param printTimes 打印次数
	 * @param idReprintRes 重打原因
	 * @return
	 * @throws BizException
	 */
	public static BlPrepayPatRcptDO assemble(BlPrePayPatDO prepayDO,String codeIncpkg,String incno,Integer printTimes,String idReprintRes) throws BizException {
		
		BlPrepayPatRcptDO rcptDO = new BlPrepayPatRcptDO();
		rcptDO.setStatus(DOStatus.NEW);
		rcptDO.setId_paypat(prepayDO.getId_paypat());
		rcptDO.setId_org(Context.get().getOrgId());
		rcptDO.setId_grp(Context.get().getGroupId());
		rcptDO.setId_pat(prepayDO.getId_pat());
		rcptDO.setId_ent(prepayDO.getId_ent());
		rcptDO.setId_entp(prepayDO.getId_enttp());
		rcptDO.setCode_entp(prepayDO.getCode_enttp());
		rcptDO.setId_incca(prepayDO.getId_incca());
		rcptDO.setCode_incpkg(codeIncpkg);
		rcptDO.setCode_rep(incno);
		rcptDO.setDt_receipt(BlFlowContextUtil.getNowTime());
		rcptDO.setId_emp_rcpt(StringUtils.isNotEmpty(prepayDO.getId_emp_pay()) ? prepayDO.getId_emp_pay() : Context.get().getStuffId());
		rcptDO.setId_emp_grp(Context.get().getGroupId());
		rcptDO.setId_emp_org(Context.get().getOrgId());
		rcptDO.setPrint_times(printTimes);
		rcptDO.setFg_rep_return(FBoolean.FALSE);
		rcptDO.setFg_cc_rcpt(FBoolean.FALSE);
		
		if(!StringUtil.isEmpty(idReprintRes)){
			UdidocDO docDO = BlCodeUtils.getUdiDocById(idReprintRes);
			rcptDO.setId_res_reprint(idReprintRes);
			if(docDO != null){
				rcptDO.setSd_res_reprint(docDO.getCode());
			}
		}
		
		return rcptDO;
	}

	/**
	 * 红冲原票据
	 * @param oldRcptDO
	 * @return
	 * @throws BizException
	 */
	public static BlPrepayPatRcptDO reserveRcpt(BlPrepayPatRcptDO oldRcptDO,String note) throws BizException {
		//增加判断是否为null（门诊不打票）  by lim 2018-08-02
		if(oldRcptDO==null){
			return null;
		}
		BlPrepayPatRcptDO rcptDO = (BlPrepayPatRcptDO)oldRcptDO.clone();
		rcptDO.setId_paypat_rcpt(null);
		rcptDO.setId_paypat(null);
		rcptDO.setDt_receipt(null);
		rcptDO.setId_emp_rcpt(null);
		rcptDO.setId_emp_grp(null);
		rcptDO.setId_emp_org(null);
		rcptDO.setFg_rep_return(FBoolean.FALSE);
		rcptDO.setId_rep_lost(null);
		rcptDO.setSd_rep_lost(null);
		rcptDO.setDt_return(BlFlowContextUtil.getNowTime());
		rcptDO.setId_emp_return(Context.get().getStuffId());
		rcptDO.setFg_cc_rcpt(FBoolean.FALSE);
		rcptDO.setId_cc(null);
		rcptDO.setNote(note);
		rcptDO.setId_res_reprint(null);
		rcptDO.setSd_res_reprint(null);
		
		rcptDO.setStatus(DOStatus.NEW);
		return rcptDO;
	}

	/**
	 * 还原票据
	 * @param oldRcptDO
	 * @return
	 * @throws BizException
	 */
	public static BlPrepayPatRcptDO restoreRcpt(BlPrepayPatRcptDO oldRcptDO) throws BizException {
		BlPrepayPatRcptDO rcptDO = (BlPrepayPatRcptDO)oldRcptDO.clone();
		rcptDO.setId_paypat_rcpt(null);
		rcptDO.setId_paypat(null);
		rcptDO.setFg_rep_return(FBoolean.FALSE);
		rcptDO.setId_cc(null);
		rcptDO.setFg_cc_rcpt(FBoolean.FALSE);
		rcptDO.setDt_return(null);
		rcptDO.setId_emp_return(null);
		
		rcptDO.setStatus(DOStatus.NEW);
		return rcptDO;
	}
	
	/**
	 * 组织作废空白票数据
	 * @param lastRcptDO
	 * @return
	 * @throws BizException
	 * @author LIM 2018-07-28
	 */
	public static BlIncCancDO assembleCancInc(BlPrepayPatRcptDO lastRcptDO) throws BizException {
		BlIncCancDO blIncCancDO= new BlIncCancDO();
		blIncCancDO.setCode_incpkg(lastRcptDO.getCode_incpkg());
		blIncCancDO.setIncno(lastRcptDO.getCode_rep());
		blIncCancDO.setId_emp_canc(Context.get().getStuffId());
		blIncCancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
		blIncCancDO.setId_reason_canc(IBdPpCodeTypeConst.ID_OTHER);
		blIncCancDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_DEPOSIT);
		blIncCancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_OTHER);
		blIncCancDO.setDt_canc(BlFlowContextUtil.getNowTime());
		blIncCancDO.setFg_canc(FBoolean.TRUE);
		blIncCancDO.setId_grp(Context.get().getGroupId());
		blIncCancDO.setId_org(Context.get().getOrgId());
		blIncCancDO.setStatus(DOStatus.NEW);
		return blIncCancDO;
		
	}
}
