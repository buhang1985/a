package iih.ci.ord.s.ems.op.order.copy;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrConsApAuditDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 复制会诊
 * @author Young
 *
 */
public class OrderConsCopyBP extends OrderBaseCopyBP {

	/**
	 * 复制会诊请单
	 * 
	 * @param id_ors
	 */
	@Override
	protected Boolean copyCiorderAppInfo(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		if (CiOrdUtils.isEmpty(mapIdors))
			return false;
		CiorappconsultAggDO[] ciorappconsultAggDOs = getCiorappconsultAggDOs(mapIdors.keySet().toArray(new String[] {}));
		if (CiOrdUtils.isEmpty(ciorappconsultAggDOs))
			return false;
		setCiorappconsultAggDOs(ciorappconsultAggDOs, mapIdors);
		return saveCiorappconsultAggDOs(ciorappconsultAggDOs);
	}
	
	/**
	 * 查询CiorappconsultAggDO
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private CiorappconsultAggDO[] getCiorappconsultAggDOs(String[] idors) throws BizException {
		if (CiOrdUtils.isEmpty(idors))
			return null;
		String strIdors = "";
		for (String id_or : idors) {
			strIdors += ",'" + id_or + "'";
		}
		return CiOrdAppUtils.getOrappconsultQryService().find(
				OrdApConsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
	}
	
	/**
	 * 设置CiorappconsultAggDO
	 * @param ciorappconsultAggDOs
	 * @param mapIdors
	 * @throws BizException
	 */
	private void setCiorappconsultAggDOs(CiorappconsultAggDO[] ciorappconsultAggDOs, Map<String, String> mapIdors) throws BizException {
		if (CiOrdUtils.isEmpty(ciorappconsultAggDOs))
			return;
		for (CiorappconsultAggDO aggDO : ciorappconsultAggDOs) {
			OrdApConsDO ordApConsDO = aggDO.getParentDO();
			ordApConsDO.setId_apcons(null);
			ordApConsDO.setId_or(mapIdors.get(ordApConsDO.getId_or()));
			ordApConsDO.setNo_applyform(this.getApplyNo(ordApConsDO.getId_or()));
			FDateTime dt = new FDateTime();
			ordApConsDO.setDt_ap(dt);
			ordApConsDO.setDt_plan(dt);
			ordApConsDO.setDt_constimelimit(null);
			ordApConsDO.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_DKSYD);
			ordApConsDO.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_DKSYD);
			ordApConsDO.setFg_prn(FBoolean.FALSE);
			ordApConsDO.setCnt_prn(0);
			ordApConsDO.setStatus(DOStatus.NEW);
			if(this.getTeampAggs()!=null && this.getTeampAggs().containsKey(ordApConsDO.getId_or())){
				ordApConsDO.setFg_urgent(this.getTeampAggs().get(ordApConsDO.getId_or()).getParentDO().getFg_urgent());
			}
			CiordInviteConsDO[] ciordInviteConsDOs = aggDO.getCiordInviteConsDO();
			if (CiOrdUtils.isEmpty(ciordInviteConsDOs))
				continue;
			for (CiordInviteConsDO ciordInviteConsDO : ciordInviteConsDOs) {
				ciordInviteConsDO.setId_invitecons(null);
				ciordInviteConsDO.setDt_response(null);
				ciordInviteConsDO.setId_emp_response(null);
				ciordInviteConsDO.setFg_response(FBoolean.FALSE);
				ciordInviteConsDO.setFg_join_cons(FBoolean.FALSE);
				ciordInviteConsDO.setJudgcons(null);
				ciordInviteConsDO.setStatus(DOStatus.NEW);
			}

			//清空会诊审批记录
			aggDO.setOrConsApAuditDO(null);
		}
	}
	
	/**
	 * 保存CiorappconsultAggDO
	 * @param ciorappconsultAggDOs
	 * @return
	 * @throws BizException
	 */
	private Boolean saveCiorappconsultAggDOs(CiorappconsultAggDO[] ciorappconsultAggDOs) throws BizException {
		if (CiOrdUtils.isEmpty(ciorappconsultAggDOs))
			return false;
		ciorappconsultAggDOs = CiOrdAppUtils.getOrappconsultService().save(ciorappconsultAggDOs);
		return !CiOrdUtils.isEmpty(ciorappconsultAggDOs);
	}

	@Override
	protected String getApplyNo() throws BizException {
		return CiOrdUtils.getApplyNo(IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS);
	}
	
}
