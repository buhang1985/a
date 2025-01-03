package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.event.MakeMtAptCancEvent;
import iih.sc.apt.s.event.MakeOptCancAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.i.IScAptMtDORService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消医技预约BP
 *
 * @author zhengcm
 * @date 2016-12-06 11:04:09
 *
 */
public class CancMtAptBP {

	/**
	 * 取消医技预约
	 *
	 * @param mtAppDTO
	 * @param sd_sctp
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(MtAppDTO mtAppDTO, String sd_sctp) throws BizException {
		ScLogUtil.getInstance().logError("1.【CancMtAptBP_退约,开始】sd_sctp_"+sd_sctp+",患者:"+mtAppDTO.getName_pat()+",手术:"+mtAppDTO.getName_or()+",参数:id_apt_"+mtAppDTO.getId_apt()+",id_apt_appl_"+mtAppDTO.getId_apt_appl()+",id_dep_apply_"+mtAppDTO.getId_dep_apply()+",id_or_"+mtAppDTO.getId_or()+",id_pat_"+mtAppDTO.getId_pat()+",id_sch_"+mtAppDTO.getId_sch());
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
		ScLogUtil.getInstance().logError("2.【CancMtAptBP_退约,处理票号】sd_sctp_"+sd_sctp+",患者:"+mtAppDTO.getName_pat());
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
		if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)){
		// 进行医技预约的取消
		this.cancMtApt(mtAppDTO);
		}else if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT)){
			ScLogUtil.getInstance().logError("3.【CancMtAptBP_进行手术预约的取消,处理票号】sd_sctp_"+sd_sctp+",患者:"+mtAppDTO.getName_pat());
			//进行手术预约的取消
			this.cancOptApt(mtAppDTO);
		}

		// 更新预约申请表
		this.updateAptAppl(mtAppDTO, sd_sctp);

		// 1:手工录入申请单 不走闭环; 2:作废医嘱不走闭环;
		if (!StringUtil.isEmpty(mtAppDTO.getSd_aptmd()) && !EuAptmd.MANUAL.toString().equals(mtAppDTO.getSd_aptmd()) && (!ICiDictCodeConst.SD_SU_CANCEL.equals(mtAppDTO.getOr_status()))) {
			// 医技取消分诊不走闭环
			if ((mtAppDTO.getOr_closed_flag() == null || mtAppDTO.getOr_closed_flag().booleanValue())) {
				//判断住院医嘱且CIOR0281为1医嘱签署不走闭环
				if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(mtAppDTO.getSd_enttp()) && IScDictCodeConst.CI_OR_MT_CFM.equals(ScParamUtils.getCiOrSignCfm(ScContextUtils.getOrgId()))) {

				} else {
					// 医嘱闭环
					if (sd_sctp.equals(IScDictCodeConst.SD_SCTP_MT)) {
						// 43401110=医技预约(中心预约) 功能节点编码
						this.rewriteOrByMt(mtAppDTO);
					}
					else if(sd_sctp.equals(IScDictCodeConst.SD_SCTP_OT))
					{
						//43402640=手术预约(手术室) 功能节点编码
						RewriteOrClosedLoopState.exec(mtAppDTO.getId_or(), mtAppDTO.getDt_effe_or(), "43402640",1);
					}
				}
			}
		}
		ScLogUtil.getInstance().logError("【CancMtAptBP_手术退约,结束】sd_sctp_"+sd_sctp+",患者:"+mtAppDTO.getName_pat()+",手术:"+mtAppDTO.getName_or()+",参数:id_apt_"+mtAppDTO.getId_apt()+",id_apt_appl_"+mtAppDTO.getId_apt_appl()+",id_dep_apply_"+mtAppDTO.getId_dep_apply()+",id_or_"+mtAppDTO.getId_or()+",id_pat_"+mtAppDTO.getId_pat()+",id_sch_"+mtAppDTO.getId_sch());
	}

	/**
	 * 医嘱回环
	 * @param mtAppDTO
	 * @throws BizException
	 */
	private void rewriteOrByMt(MtAppDTO mtAppDTO) throws BizException {
		if (!this.getFgMultor(mtAppDTO)){
			// 非合单
			RewriteOrClosedLoopState.exec(mtAppDTO.getId_or(), mtAppDTO.getDt_effe_or(), "43402610",1);
		} else {
			// 合单
			List<String> orList = this.getIdOrList(mtAppDTO);
			if (orList != null){
				for(String id_or : orList){
					RewriteOrClosedLoopState.exec(id_or, mtAppDTO.getDt_effe_or(), "43402610",1);
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
		ScLogUtil.getInstance().logError("3.【CancMtAptBP_退约,处理票号,退号】id_tick_"+scAptDO.getId_tick()+",患者:"+mtAppDTO.getName_pat());
		IScschMDORService service = ServiceFinder.find(IScschMDORService.class);
		ScSchDO scSchDO = service.findById(scAptDO.getId_sch());
		if(scSchDO.getFg_transed().booleanValue()){
			throw new BizException("相关号位数据转移到sc_tickb表中，无法进行退号处理");
		}
		// 退号
		IScSchOutCmdService schService = ServiceFinder.find(IScSchOutCmdService.class);
		schService.drawbackTick(scAptDO.getId_tick());
		ScLogUtil.getInstance().logError("4.【CancMtAptBP_退约,取消预约记录,开始】AptEP().cancApt_id_tick_"+scAptDO.getId_tick()+",患者:"+mtAppDTO.getName_pat());
			// 取消预约
	  	new AptEP().cancApt(mtAppDTO, scAptDO);
		ScLogUtil.getInstance().logError("5.【CancMtAptBP_退约,取消预约记录,结束】AptEP().cancApt_id_tick_"+scAptDO.getId_tick()+",患者:"+mtAppDTO.getName_pat());
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
	 * 更新医嘱申请单状态
	 *
	 * @param mtAppDTO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateOrderStatus(MtAppDTO mtAppDTO) throws BizException {
		MtAptCiObsOperateBP mtAptCiObsOperateBP = new MtAptCiObsOperateBP();
		if (!this.getFgMultor(mtAppDTO)){
		ScValidator.validateParam("id_or", mtAppDTO.getId_or());
			mtAptCiObsOperateBP.rewriteObsStatus(mtAppDTO.getId_or(), Boolean.FALSE, null);
		} else {
			List<String> orList = this.getIdOrList(mtAppDTO);
			if (orList != null){
				for(String id_or : orList){
					ScValidator.validateParam("id_or", id_or);
					mtAptCiObsOperateBP.rewriteObsStatus(id_or, Boolean.FALSE, null);
				}
			}
		}
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
		//bug:0170002: 【工单】医技预约、手术预约后取消预约时应当清空申请单sc_apt_appl表中的服务和资源
		aptApplDO.setId_scres(null);
		aptApplDO.setId_scsrv(null);
		aptApplDO.setScres_name(null);
		aptApplDO.setScsrv_name(null);
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
	 * 取消医技预约集成平台消息
	 * @param mtAppDTO
	 * @throws BizException
	 */
	private void cancMtApt(MtAppDTO mtAppDTO) throws BizException {
		// 进行取消医技预约的触发
		MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
		apt4EsDTO.setId_apt(mtAppDTO.getId_apt());
		new MakeMtAptCancEvent().invoke(apt4EsDTO);
	}
	/**
	 * 取消手术预约集成平台消息
	 * @param mtAppDTO
	 * @throws BizException
	 */
	private void cancOptApt(MtAppDTO mtAppDTO) throws BizException {
		// 进行取消手术预约的触发
		List<OptApt4OrmDTO> optApt4OrmList = new ArrayList<OptApt4OrmDTO>();
		OptApt4OrmDTO optapt4ormdto = new OptApt4OrmDTO();
		optapt4ormdto.setId_apt(mtAppDTO.getId_apt());
		optApt4OrmList.add(optapt4ormdto);
		new MakeOptCancAptEvent().invoke(optApt4OrmList);
	}

	/**
	 * 检查医嘱申请单是否是合单申请
	 *
	 * @param appDTO
	 * @throws BizException
	 * @author yu.b
	 */
	private Boolean getFgMultor(MtAppDTO appDTO) throws BizException {
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT FG_MULTOR FROM SC_APT_APPL WHERE ID_OR = ? ");
		sqlParam.addParam(appDTO.getId_or());
		String fg_multor = (String) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanHandler(String.class));
		return fg_multor == null ? false : Boolean.parseBoolean(fg_multor);
	}
	/**
	 * 根据申请单ID获取医嘱ID
	 *
	 * @param appDTO
	 * @throws BizException
	 * @author yu.b
	 */
	private List<String> getIdOrList(MtAppDTO appDTO) throws BizException {
		StringBuilder sql = new StringBuilder();
		SqlParam sqlParam = new SqlParam();
		sql.append("SELECT ID_OR FROM SC_APT_APPL_ITM WHERE ID_APTAPPL = ? ");
		sqlParam.addParam(appDTO.getId_apt_appl());
		List<String> orList = (List<String>) new DAFacade().execQuery(sql.toString(), sqlParam,
				new BeanListHandler(String.class));
		return orList;
	}
}
