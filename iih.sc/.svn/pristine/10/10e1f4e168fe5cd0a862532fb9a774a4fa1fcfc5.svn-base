package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.i.IEnOutCmdService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.event.MakeMtAptCancEvent;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScAptMtDORService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消医技预约BP
 * 
 * @author zhengcm
 * @date 2016-12-06 11:04:09
 *
 */
public class ForceCancAptBP {

	/**
	 * 取消医技预约
	 *
	 * @param mtAppDTO
	 * @param sd_sctp
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(MtAppDTO mtAppDTO, String sd_sctp) throws BizException {
		if (mtAppDTO == null) {
			return;
		}
		FBoolean fg_auto_cfm = mtAppDTO.getFg_auto_cfm() == null?FBoolean.FALSE:mtAppDTO.getFg_auto_cfm();
		if(fg_auto_cfm.booleanValue()){
			this.cancAptCfm(mtAppDTO.getId_apt());
		}
		// 检查参数
		ScValidator.validateParam("id_apt", mtAppDTO.getId_apt());

		// 获取预约信息
		ScAptDO scAptDO = new AptEP().getById(mtAppDTO.getId_apt());

		// 验证预约信息
		//分诊时预约的  不进行校验
		if(mtAppDTO.getOr_closed_flag() == null || mtAppDTO.getOr_closed_flag().booleanValue())
		{
			this.validateApt(scAptDO,mtAppDTO.getFg_change_apt());
		}
		// 处理票号
		this.processTick(mtAppDTO, scAptDO);
		// 手工录入申请单 和chis 不更新医嘱装态
		if (EuAptmd.APPL.toString().equals(mtAppDTO.getSd_aptmd())) {
		// 更新医嘱申请单状态
			if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
			this.updateOrderStatus(mtAppDTO);
		} else {
			// 回写手术申请单状态
			this.rewriteOptAppStatus(mtAppDTO);
		}
		}
		// 进行医技预约的取消
		this.cancMtApt(mtAppDTO);

		// 更新预约申请表
		this.updateAptAppl(mtAppDTO, sd_sctp);

		// 1:手工录入申请单 不走闭环
		if (!EuAptmd.MANUAL.toString().equals(mtAppDTO.getSd_aptmd())) {
			// 医技取消分诊不走闭环
			if (mtAppDTO.getOr_closed_flag() == null || mtAppDTO.getOr_closed_flag().booleanValue()) {
				// 医嘱闭环
				if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
					// 43401110=医技预约(中心预约) 功能节点编码
					RewriteOrClosedLoopState.exec(mtAppDTO.getId_or(), mtAppDTO.getDt_effe_or(), "43402610",1);
				}
				else if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT))
				{
					//43402640=手术预约(手术室) 功能节点编码
					RewriteOrClosedLoopState.exec(mtAppDTO.getId_or(), mtAppDTO.getDt_effe_or(), "43402640",1);
				}
			}
		}
		
		
	}

	/**
	 * 处理票号
	 * 
	 * @param mtAppDTO
	 * @param scAptDO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void processTick(MtAppDTO mtAppDTO, ScAptDO scAptDO) throws BizException {
		// if (scAptDO.getFg_payment() == FBoolean.TRUE) {
		// ScValidator.validateParam("id_ent", mtAppDTO.getId_ent());
			// 如果已经结算，直接走退号逻辑,需退钱
		// IEnOutCmdService entService =
		// ServiceFinder.find(IEnOutCmdService.class);
		// OpAptDTO aptDTO = new OpAptDTO();
		// aptDTO.setId_apt(mtAppDTO.getId_apt());
		// aptDTO.setId_ent(mtAppDTO.getId_ent());
		// entService.cancEnt(aptDTO);
		// } else {
		// 退号
		IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
		schService.drawbackTick(scAptDO.getId_tick());
		// 取消预约
	  	new AptEP().cancApt(mtAppDTO, scAptDO);
		// }
	}

	/**
	 * 验证预约信息
	 * 
	 * @param scAptDO
	 * @throws BizException
	 */
	private void validateApt(ScAptDO scAptDO, FBoolean fg_change_apt) throws BizException {
		if (scAptDO == null) {
			throw new BizException(IScMsgConst.SC_APT_NOT_EXIST);
		}
		// 校验预约状态
		if (IScDictCodeConst.SD_APTSTATUS_FINISH.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_CANCEL_STATE);
		} else if (IScDictCodeConst.SD_APTSTATUS_CANCEL.equals(scAptDO.getSd_status())) {
			throw new BizException(IScMsgConst.SC_APT_OP_HAS_CANCELED);
		}
		if (scAptDO.getSd_sctp().equals(IScDictCodeConst.SD_SCTP_MT)) {
			// 校验是否医技确认,确认后的预约,不能直接退约
			IScAptMtDORService mtService = ServiceFinder.find(IScAptMtDORService.class);
			ScAptMtDO mtDO = mtService.find(String.format(" id_apt = '%s' ", scAptDO.getId_apt()), "",
					FBoolean.FALSE)[0];
			if (mtDO.getFg_aptcfm().booleanValue()) {
				if (fg_change_apt != null && FBoolean.TRUE.equals(fg_change_apt)) {
					throw new BizException("改约失败:预约已确认,不能退约!");
				} else {
					throw new BizException("预约已确认,不能退约!");
				}
			}
		}
	}

	/**
	 * 更新医嘱状态
	 *
	 * @param mtAppDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateOrderStatus(MtAppDTO mtAppDTO) throws BizException {
		ScValidator.validateParam("id_or", mtAppDTO.getId_or());
		new MtAptCiObsOperateBP().rewriteObsStatus(mtAppDTO.getId_or(), Boolean.FALSE, null);
	}

	/**
	 * 回写手术申请单状态
	 * 
	 * @author zhengcm
	 *
	 * @param appDTO
	 * @throws BizException
	 */
	private void rewriteOptAppStatus(MtAppDTO appDTO) throws BizException {
		new OptAptCiObsOperateBP().rewriteCancApt(appDTO.getId_or());
	}

	/**
	 * 更新预约申请
	 *
	 * @author zhengcm
	 * 
	 * @param appDTO
	 * @throws BizException
	 */
	private void updateAptAppl(MtAppDTO appDTO, String sd_sctp) throws BizException {
		MtAptEP mtAptEP = new MtAptEP();
		// 未确认的申请单不取消
		ScAptApplDO aptApplDO = mtAptEP.getAptApplById(appDTO.getId_apt_appl());
		if (null == aptApplDO || null == aptApplDO.getFg_comfirm() || !aptApplDO.getFg_comfirm().booleanValue()) {
			return;
		}
		aptApplDO.setStatus(DOStatus.UPDATED);
		aptApplDO.setFg_comfirm(FBoolean.FALSE);
		if (!sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)) {
			aptApplDO.setId_emp_canc(ScContextUtils.getPsnId());
			aptApplDO.setDt_canc(ScAppUtils.getServerDateTime());
		}
		// 更新预约申请
		mtAptEP.saveAptAppl(new ScAptApplDO[] { aptApplDO });
	}

	/**
	 * 取消医技预约确认
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	private void cancAptCfm(String id_apt) throws BizException {
		AptEP aptep = new AptEP();
		ScAptMtDO[] aptmts = aptep.getAptMtByWhere("id_apt = '" + id_apt + "'");
		if (!ArrayUtil.isEmpty(aptmts)) {
			ScAptMtDO aptmt = aptmts[0];
			if (aptmt.getFg_aptcfm() == null ? false : aptmt.getFg_aptcfm().booleanValue()) {
				aptmt.setStatus(DOStatus.UPDATED);
				aptmt.setDt_apt_cfm(null);
				aptmt.setId_emp_cfm(null);
				aptmt.setFg_aptcfm(FBoolean.FALSE);
				aptep.save(aptmt);
			}
		}
	}


	/**
	 * 取消医技预约
	 * @param aptAggDO
	 * @throws BizException
	 */
	private void cancMtApt(MtAppDTO mtAppDTO) throws BizException {
		// 进行取消医技预约的触发
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_apt(mtAppDTO.getId_apt());
		new MakeMtAptCancEvent().invoke(apt4EsDTO);
	}
}
