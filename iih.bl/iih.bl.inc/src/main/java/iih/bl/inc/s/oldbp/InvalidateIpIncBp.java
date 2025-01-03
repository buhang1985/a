package iih.bl.inc.s.oldbp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.blincoepcanclog.d.BlIncOepCancLogDO;
import iih.bl.inc.s.util.InvoicePrintUtil;
import iih.bl.pay.blrtnreasondto.d.BlRtnReasonDTO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 作废原发票保存新发票票
 * 
 * @date 2018年6月22日
 * @author wq.li
 */
public class InvalidateIpIncBp {
	/**
	 * 作废原发票保存新发票
	 * 
	 * @param incIds
	 * @return
	 * @throws BizException
	 * @date 2018年6月23日
	 * @author wq.li
	 */
	public BlincipAggDO[] exec(String[] incIds) throws BizException {
		if (ArrayUtil.isEmpty(incIds)) {
			throw new BizException("原发票信息为空");
		}
		// 1.准备数据
		// 1.1查询发票信息
		BlincipAggDO[] incIpAggDos = getIncInfo(incIds);

		// 1.2 校验发票状态
		this.validateInc(incIpAggDos);

		// 2.查询发票号，调好等操作
		Entry<String, String[]> printInfo = InvoicePrintUtil.print(IBdPpCodeTypeConst.ID_INHOS_INVOICE,
				incIpAggDos.length, Context.get().getStuffId(), Context.get().getClientHost());
		String codePkg = printInfo.getKey();
		String[] incnos = printInfo.getValue();

		// 3.更新发票数据
		incIpAggDos = this.updateIncData(incIpAggDos, codePkg, incnos);

		return incIpAggDos;
	}
	
	/**
	 * 
	 * @param incIds
	 * @return
	 * @throws BizException
	 */
	public void execReIncIp(String[] incIds) throws BizException{
		if (ArrayUtil.isEmpty(incIds)) {
			throw new BizException("原发票信息为空");
		}

		// 1.1查询发票信息
		BlincipAggDO[] incIpAggDos = getIncInfo(incIds);
		// 1.2 校验发票状态
		this.validateInc(incIpAggDos);
		
		// 3.新增取消发票数据，删除原有数据
		this.updateReIncData(incIpAggDos);
	}
	/**
	 * 更新发票数据
	 * 
	 * @param aggDos
	 * @param codePkg
	 * @param incnos
	 * @return
	 * @throws BizException
	 */
	private BlincipAggDO[] updateIncData(BlincipAggDO[] aggDos, String codePkg, String[] incnos) throws BizException {

		List<BlIncCancDO> cancList = new ArrayList<BlIncCancDO>();
//		List<BlIncOepCancLogDO> logList = new ArrayList<BlIncOepCancLogDO>();

		for (int i = 0; i < aggDos.length; i++) {
			BlincipAggDO aggDO = aggDos[i];
			BlIncIpDO incDO = aggDO.getParentDO();

			// 作废发票数据
			if (incDO != null && !StringUtil.isEmpty(incDO.getIncno())) {
				cancList.add(this.assembleCanc(incDO));
			}

			// 作废发票记录
			// logList.add(this.assembleCancLog(incDO, codePkg, incnos[i]));
			if(StringUtil.isEmpty(incDO.getId_incca())){
				incDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
			}
			incDO.setCode_incpkg(codePkg);
			incDO.setIncno(incnos[i]);
			incDO.setFg_print(FBoolean.TRUE);
			incDO.setTimes_prn(1);
			incDO.setId_emp_inc(Context.get().getStuffId());
			incDO.setId_dep_inc(Context.get().getDeptId());

			incDO.setStatus(DOStatus.UPDATED);
		}

		IBlincipCudService incCudService = ServiceFinder.find(IBlincipCudService.class);
		if (!ListUtil.isEmpty(cancList)) {
			IBlinccancCudService cancCudService = ServiceFinder.find(IBlinccancCudService.class);
			// IBlincoepcanclogCudService logCudService =
			// ServiceFinder.find(IBlincoepcanclogCudService.class);

			// 保存作废票数据
			cancCudService.insert(cancList.toArray(new BlIncCancDO[0]));
		}
		// 保存作废票记录 TODO 住院暂不存作废日志
		// logCudService.insert(logList.toArray(new BlIncOepCancLogDO[0]));

		return incCudService.update(aggDos);
	}

	/**
	 * 处理住院拆票之后，原有票据的相关信息
	 * @param aggDos
	 * @return
	 * @throws BizException
	 */
	private void updateReIncData(BlincipAggDO[] aggDos) throws BizException{
		BlRtnReasonDTO reasonDTO = new BlRtnReasonDTO();
		reasonDTO.setId_udidoc(IBdPpCodeTypeConst.ID_REINC);
		reasonDTO.setCode(IBdPpCodeTypeConst.SD_REINC);
		reasonDTO.setName(IBdPpCodeTypeConst.DES_REINC);
		
		List<BlIncCancDO> cancList = new ArrayList<BlIncCancDO>();
//		List<BlIncOepCancLogDO> logList = new ArrayList<BlIncOepCancLogDO>();

		for (int i = 0; i < aggDos.length; i++) {
			BlincipAggDO aggDO = aggDos[i];
			BlIncIpDO incDO = aggDO.getParentDO();

			// 作废发票数据
			if (incDO != null && !StringUtil.isEmpty(incDO.getIncno())) {
				cancList.add(this.assembleCancReIncWithReason(incDO, reasonDTO));
			}
			
			// 作废发票记录
			// logList.add(this.assembleCancLog(incDO, incDO.getCode_incpkg(), incDO.getIncno()));
			if(StringUtil.isEmpty(incDO.getId_incca())){
				incDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
			}
		}

		IBlincipCudService incCudService = ServiceFinder.find(IBlincipCudService.class);
		if (!ListUtil.isEmpty(cancList)) {
			IBlinccancCudService cancCudService = ServiceFinder.find(IBlinccancCudService.class);
			// IBlincoepcanclogCudService logCudService =
			// ServiceFinder.find(IBlincoepcanclogCudService.class);

			// 保存作废票数据
			cancCudService.insert(cancList.toArray(new BlIncCancDO[0]));
		}
		// 保存作废票记录 TODO 住院暂不存作废日志
		// logCudService.insert(logList.toArray(new BlIncOepCancLogDO[0]));

		incCudService.delete(aggDos);
	}
	/**
	 * 门诊发票作废日志
	 * 
	 * @param incDO
	 * @param codeIncpkgNew
	 * @param incnoNew
	 * @return
	 */
	private BlIncOepCancLogDO assembleCancLog(BlIncIpDO incDO, String codeIncpkgNew, String incnoNew) {
		BlIncOepCancLogDO cancLogDO = new BlIncOepCancLogDO();
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
		cancLogDO.setId_stoep(incDO.getId_stip());
		// cancLogDO.setFg_fundpay(incDO.getFg_fundpay());
		// cancLogDO.setFg_hp_card(incDO.getFg_hp_card());
		cancLogDO.setTimes_prn(incDO.getTimes_prn());
		cancLogDO.setDt_inc(incDO.getDt_inc());
		cancLogDO.setDt_inc_new(AppUtils.getServerDateTime());
		cancLogDO.setStatus(DOStatus.NEW);

		return cancLogDO;
	}

	/**
	 * 组装住院发票数据
	 * 
	 * @param incIpDo
	 * @return
	 * @date 2018年6月23日
	 * @author wq.li
	 */
	private BlIncCancDO assembleCanc(BlIncIpDO incIpDo) {
		BlIncCancDO cancDO = new BlIncCancDO();
		cancDO.setCode_incpkg(incIpDo.getCode_incpkg());
		cancDO.setIncno(incIpDo.getIncno());
		cancDO.setId_emp_canc(Context.get().getStuffId());
		cancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_PRINT_ERROR);
		cancDO.setId_reason_canc(IBdPpCodeTypeConst.ID_PRINT_ERROR);
		cancDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
		cancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_PRINT_ERROR);
		cancDO.setDt_canc(AppUtils.getServerDateTime());
		cancDO.setFg_canc(FBoolean.TRUE);
		cancDO.setFg_canc(FBoolean.FALSE);
		cancDO.setId_cc(null);
		cancDO.setId_grp(Context.get().getGroupId());
		cancDO.setId_org(Context.get().getOrgId());
		cancDO.setStatus(DOStatus.NEW);

		return cancDO;
	}
	
	/**
	 * 组装住院发票取消表，可控制原因
	 * 
	 * @param incIpDo
	 * @param reasonDTO
	 * @return
	 */
	private BlIncCancDO assembleCancReIncWithReason(BlIncIpDO incIpDo, BlRtnReasonDTO reasonDTO) {
		BlIncCancDO cancDO = new BlIncCancDO();
		cancDO.setCode_incpkg(incIpDo.getCode_incpkg());
		cancDO.setIncno(incIpDo.getIncno());
		cancDO.setId_emp_canc(Context.get().getStuffId());
		cancDO.setSd_reason_canc(reasonDTO.getCode());
		cancDO.setId_reason_canc(reasonDTO.getId_udidoc());
		cancDO.setId_incca(IBdPpCodeTypeConst.ID_INHOS_INVOICE);
		cancDO.setDes_reason_canc(reasonDTO.getName());
		cancDO.setDt_canc(AppUtils.getServerDateTime());
		cancDO.setFg_canc(FBoolean.TRUE);
		cancDO.setFg_canc(FBoolean.FALSE);
		cancDO.setId_cc(null);
		cancDO.setId_grp(Context.get().getGroupId());
		cancDO.setId_org(Context.get().getOrgId());
		cancDO.setStatus(DOStatus.NEW);

		return cancDO;
	}

	/**
	 * 校验发票状态
	 * 
	 * @param incIpAggDo
	 * @throws BizException
	 * @date 2018年6月23日
	 * @author wq.li
	 */
	private void validateInc(BlincipAggDO[] incIpAggDo) throws BizException {

		for (BlincipAggDO aggDO : incIpAggDo) {
			if (FBoolean.TRUE.equals(aggDO.getParentDO().getFg_cc_out())) {
				throw new BizException(IBlMsgConst.ERROR_INCOEP_CC_OUT + " 票号:" + aggDO.getParentDO().getIncno());
			}
		}

	}

	/**
	 * 根据发票ID获取发票信息
	 * 
	 * @param incId
	 * @return
	 * @throws BizException
	 * @date 2018年6月23日
	 * @author wq.li
	 */
	private BlincipAggDO[] getIncInfo(String[] incId) throws BizException {
		IBlincipRService incIpService = ServiceFinder.find(IBlincipRService.class);
		BlincipAggDO[] incIpAggDo = incIpService.findByIds(incId, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(incIpAggDo)) {
			throw new BizException(IBlMsgConst.ERROR_INCOEP_NOT_EXIST);
		}
		return incIpAggDo;
	}
}
