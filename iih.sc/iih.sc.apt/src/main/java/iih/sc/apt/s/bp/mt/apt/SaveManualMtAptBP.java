package iih.sc.apt.s.bp.mt.apt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.out.i.ISc4OutThirdCmdService;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.mt.GetMtResBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDORService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.i.IScheduleSrvRelDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医技预约信息(增加对手术预约的支持)
 * 
 * @author yzh
 *
 */
public class SaveManualMtAptBP {

	/**
	 * 保存医技预约信息
	 * @author yzh
	 * @param resDTO
	 * @param appDTO
	 * @param sd_sctp
	 * @throws BizException
	 */
	public MtResDTO exec(MtResDTO resDTO, MtAppDTO appDTO, String sd_sctp) throws BizException {
		if (null == appDTO) {
			return resDTO;
		}

		// 1、检查同一患者同一号源同一日期同一午别是否存在预约
		// new AptCheckBP().exec(appDTO.getId_pat(), resDTO.getId_sch());

		if (StringUtil.isEmptyWithTrim(appDTO.getId_pat())) {
			throw new BizException("预约患者为空，请检查！");
		}

		//预约逻辑
		ISc4OutThirdCmdService outThirdCmdService = ServiceFinder.find(ISc4OutThirdCmdService.class);
		FMap result = outThirdCmdService.saveMtAptPub(resDTO, appDTO, sd_sctp, FBoolean.FALSE);
		FBoolean isSuc = (FBoolean)result.get("isSuc");
		resDTO = (MtResDTO)result.get("result");
		if (!isSuc.booleanValue()) {
			return resDTO;
		}
	
		if (EuAptmd.APPL.equals(appDTO.getSd_aptmd())) {
		// 16、 回写医嘱闭环状态
		if(appDTO.getOr_closed_flag() == null || appDTO.getOr_closed_flag().booleanValue())
		{
			RewriteOrClosedLoopState.exec(appDTO.getId_or(), appDTO.getDt_effe_or(), "43401110",0);// 43401110=医技预约(中心预约) 功能节点编码
		}
		}
		// 17、返回最新的数据
		MtResDTO mtRes = new GetMtResBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl(),FBoolean.FALSE,null);
		// 18、 处理结果
		this.handleResDTO(resDTO, appDTO,mtRes);
		this.handleAutoPrnPho(mtRes, resDTO.getId_scca(), resDTO.getId_dep(),resDTO.getFg_needcfm(),appDTO);
		this.duplicateExclDate(mtRes);
		return mtRes;
	}
	
	/**
	 * 去除排斥日期中重复的数据
	 * @param resDTO
	 */
	@SuppressWarnings("unchecked")
	private void duplicateExclDate(MtResDTO resDTO){
		FArrayList exclMust = resDTO.getDays_excl_must();
		FArrayList exclTimes = resDTO.getDays_excl_times();
		FArrayList togetherMust = resDTO.getDays_together_must();
		FArrayList exclHint = resDTO.getDays_excl_hint();
		FArrayList togetherHint = resDTO.getDays_together_hint();
		// 1.排斥禁止
		if(!ListUtil.isEmpty(exclMust)){
			FArrayList exclMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclMust);
			exclMustTemp.addAll(setData);
			resDTO.setDays_excl_must(exclMustTemp);
		}
		// 2.次数限制
		if (!ListUtil.isEmpty(exclTimes)) {
			FArrayList exclTimesTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclTimes);
			exclTimesTemp.addAll(setData);
			resDTO.setDays_excl_times(exclTimesTemp);
		}
		//3.并行禁止
		if(!ListUtil.isEmpty(togetherMust)){
			FArrayList togetherMustTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherMust);
			togetherMustTemp.addAll(setData);
			resDTO.setDays_together_must(togetherMustTemp);
		}
		// 4.排斥提示
		if(!ListUtil.isEmpty(exclHint)){
			FArrayList exclHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(exclHint);
			exclHintTemp.addAll(setData);
			resDTO.setDays_excl_hint(exclHintTemp);
		}
		// 5.并行提示
		if(!ListUtil.isEmpty(togetherHint)){
			FArrayList togetherHintTemp = new FArrayList();
			Set<FMap> setData = new HashSet<FMap>();
			setData.addAll(togetherHint);
			togetherHintTemp.addAll(setData);
			resDTO.setDays_together_hint(togetherHintTemp);
		}
	}
	

	/**
	 * 补全返回接口所需信息
	 * @author yzh
	 * @param src
	 * @param appDTO
	 * @param aptAggDO
	 * @param scAptApplDO
	 * @param tickDO
	 * @param planDO
	 * @param resDTO
	 */
	private void handleResDTO(MtResDTO src,MtAppDTO appDTO,MtResDTO resDTO){
		String id_entp = appDTO.getId_enttp();
		if (resDTO.getFg_setentp() != null && resDTO.getFg_setentp().booleanValue()) {
			if (IScDictCodeConst.SD_TICKMD_TIME.equals(src.getSd_tickmd())) {
				
			}else{
			if (IScDictCodeConst.ID_SCTP_OP.equals(id_entp)) {
				int op_apt_num = src.getOp_apt_num()==null?0:src.getOp_apt_num();
				resDTO.setOp_apt_num(op_apt_num-1);//门诊剩余就诊
				resDTO.setIp_apt_num(src.getIp_apt_num());//住院剩余就诊数
			}else if(IScDictCodeConst.ID_SCTP_IP.equals(id_entp)){
				int ip_apt_num = src.getIp_apt_num()==null?0:src.getIp_apt_num();
					resDTO.setIp_apt_num(ip_apt_num-1);//住院剩余就诊
					resDTO.setOp_apt_num(src.getOp_apt_num());//门诊剩余就诊数
				}
			}
		}else{
			if (IScDictCodeConst.SD_TICKMD_TIME.equals(src.getSd_tickmd())) {
				int spent_time = src.getSpend_time() == null ? 0 : src.getSpend_time();
				if (IScDictCodeConst.ID_SCTP_OP.equals(id_entp)) {
					int op_apt_num = src.getOp_apt_num()==null?0:src.getOp_apt_num();
					resDTO.setOp_apt_num(op_apt_num-spent_time);//门诊剩余就诊
					resDTO.setIp_apt_num(src.getIp_apt_num());//住院剩余就诊数
				}else if(IScDictCodeConst.ID_SCTP_IP.equals(id_entp)){
					int ip_apt_num = src.getIp_apt_num()==null?0:src.getIp_apt_num();
					resDTO.setIp_apt_num(ip_apt_num-spent_time);//住院剩余就诊
					resDTO.setOp_apt_num(src.getOp_apt_num());//门诊剩余就诊数
				}else{
					int op_apt_num = src.getOp_apt_num()==null?0:src.getOp_apt_num();
					int ip_apt_num = src.getIp_apt_num()==null?0:src.getIp_apt_num();
					resDTO.setOp_apt_num(op_apt_num-spent_time);//门诊剩余就诊
					resDTO.setIp_apt_num(ip_apt_num-spent_time);//门诊剩余就诊
				}
			}else{
				int op_apt_num = src.getOp_apt_num()==null?0:src.getOp_apt_num();
				int ip_apt_num = src.getIp_apt_num()==null?0:src.getIp_apt_num();
				resDTO.setOp_apt_num(op_apt_num-1);//门诊剩余就诊
				resDTO.setIp_apt_num(ip_apt_num-1);//门诊剩余就诊
			}
			
		}
		resDTO.setId_aptappl(src.getId_aptappl());
		resDTO.setId_apt_mt(src.getId_apt_mt());
		resDTO.setQueno(src.getQueno());
		resDTO.setId_ticks(src.getId_ticks());
		resDTO.setId_srv(appDTO.getId_srv());
		resDTO.setId_dep(appDTO.getId_dep_mp());
		resDTO.setId_scca(src.getId_scca());
		resDTO.setId_scsrv(src.getId_scsrv());
		resDTO.setId_apt(src.getId_apt());
		resDTO.setId_pat(appDTO.getId_pat());
		resDTO.setId_dep(src.getId_dep());
		resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
		resDTO.setDays_excl_must(src.getDays_excl_must());
		resDTO.setDays_excl_hint(src.getDays_excl_hint());
		resDTO.setDays_together_must(src.getDays_together_must());
		resDTO.setDays_together_hint(src.getDays_together_hint());
		resDTO.setDays_excl_times(src.getDays_excl_times());
		resDTO.setSrvlot(src.getSrvlot());
		resDTO.setFg_auto_pho(src.getFg_auto_pho());
		resDTO.setFg_auto_prn(src.getFg_auto_prn());
		resDTO.setFg_auto_prn_bar(src.getFg_auto_prn_bar());
		resDTO.setSrvlot_min(src.getSrvlot_min());
		resDTO.setApt_time(src.getApt_time());
	}
	
	/**
	 * 处理返回结果是否自动打印 和 自动拍照
	 * @author yzh
	 * @param resDTO
	 * @param id_scca
	 * @param id_dep
	 * @param fg_needcfm  是否需要确认,需要确认的项目在医技预约确认页面进行打印和拍照
	 * @throws BizException 
	 */
	private void handleAutoPrnPho(MtResDTO resDTO,String id_scca,String id_dep,FBoolean fg_needcfm,MtAppDTO appDTO) throws BizException{
		if(fg_needcfm.booleanValue())
		{
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());// 检查费用参数
			if(appDTO.getFg_auto_cfm()!= null && appDTO.getFg_auto_cfm().booleanValue() && ((chkFee && appDTO.getFg_bl().booleanValue()) || !chkFee)) return;
			resDTO.setFg_auto_pho(FBoolean.FALSE);
			resDTO.setFg_auto_prn(FBoolean.FALSE);
			resDTO.setFg_auto_prn_bar(FBoolean.FALSE);
			return;
		}
		IScdeptparamMDORService iscdeptparammdorservice = ServiceFinder.find(IScdeptparamMDORService.class);
		StringBuffer condtion = new StringBuffer();
		condtion.append("id_dep ='").append(id_dep).append("' and id_scca='").append(id_scca).append("'");
		ScDeptParamDO[] scDepParams = iscdeptparammdorservice.find(condtion.toString(), null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(scDepParams)){
			resDTO.setFg_auto_pho(FBoolean.FALSE);
			resDTO.setFg_auto_prn(FBoolean.FALSE);
			resDTO.setFg_auto_prn_bar(FBoolean.FALSE);
		}else{
			resDTO.setFg_auto_pho(scDepParams[0].getFg_auto_pho());
			resDTO.setFg_auto_prn(scDepParams[0].getFg_auto_prn());
			resDTO.setFg_auto_prn_bar(scDepParams[0].getFg_auto_prn_bar());
		}
	}
}
