package iih.sc.apt.s.bp.mt.apt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtApt4EsDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.out.i.ISc4OutThirdCmdService;
import iih.sc.apt.s.bp.RewriteOrClosedLoopState;
import iih.sc.apt.s.bp.mt.CancMtAptBP;
import iih.sc.apt.s.bp.mt.GetMtResBP;
import iih.sc.apt.s.bp.mt.MtAptCiObsOperateBP;
import iih.sc.apt.s.bp.mt.apt.validate.ValSchSrvBP;
import iih.sc.apt.s.bp.opt.OptAptCiObsOperateBP;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.apt.s.event.MakeMtAptEvent;
import iih.sc.apt.scapt.d.AptOthDO;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScAptMtDO;
import iih.sc.apt.scapt.d.ScAptOptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IAptothCudService;
import iih.sc.apt.scapt.i.IScaptRService;
import iih.sc.apt.scaptappl.d.EuAptmd;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.desc.ScAptApplDODesc;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.i.IScdeptparamMDORService;
import iih.sc.scbd.scheduleres.d.ScheduleResDO;
import iih.sc.scbd.scheduleres.i.IScheduleresRService;
import iih.sc.sch.dto.d.SchTickMdTimeDTO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技预约改约操作
 * 
 * @author yzh
 *
 */
public class ChangeManualMtAptBP {

	/**
	 * 医技预约改约操作
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
		
		// 先退约 再预约 
		new CancMtAptBP().exec(appDTO, IScDictCodeConst.SD_SCTP_MT);

		//预约逻辑
		ISc4OutThirdCmdService outThirdCmdService = ServiceFinder.find(ISc4OutThirdCmdService.class);
		FMap result = outThirdCmdService.saveMtAptPub(resDTO, appDTO, sd_sctp, FBoolean.FALSE);
		FBoolean isSuc = (FBoolean)result.get("isSuc");
		resDTO = (MtResDTO)result.get("result");
		if (!isSuc.booleanValue()) {
			return resDTO;
		}
			if (IScDictCodeConst.SD_SYS_FROM_IIH.equals(appDTO.getSd_sys_from()) && EuAptmd.APPL.equals(appDTO.getSd_aptmd())) {
		RewriteOrClosedLoopState.exec(appDTO.getId_or(), appDTO.getDt_plan(), "43402610",0);// 43401110=医技预约(中心预约) 功能节点编码
			}
		
		// 17、返回最新的数据
		MtResDTO mtRes = new GetMtResBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl(),FBoolean.FALSE,null);
		// 18、 处理结果
		this.handleResDTO(resDTO, appDTO,mtRes);
		this.handleAutoPrnPho(mtRes, resDTO,appDTO);
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
	 * 初始化
	 * @param resDTO
	 */
	private void handleResDTO(MtResDTO src,MtAppDTO appDTO,MtResDTO resDTO){
		if (resDTO.getFg_setentp() != null && resDTO.getFg_setentp().booleanValue()) {
			String id_entp = appDTO.getId_enttp();
			if (IScDictCodeConst.ID_SCTP_OP.equals(id_entp)) {
				int op_apt_num = src.getOp_apt_num()==null?0:src.getOp_apt_num();
				resDTO.setOp_apt_num(op_apt_num-1);//门诊剩余就诊
				resDTO.setIp_apt_num(src.getIp_apt_num());//住院剩余就诊数
			}else if(IScDictCodeConst.ID_SCTP_IP.equals(id_entp)){
				int ip_apt_num = src.getIp_apt_num()==null?0:src.getIp_apt_num();
				resDTO.setIp_apt_num(ip_apt_num-1);//门诊剩余就诊
				resDTO.setOp_apt_num(src.getOp_apt_num());//住院剩余就诊数
			}
		}
		resDTO.setFg_setentp(src.getFg_setentp());//是否设置就诊类型
		resDTO.setId_aptappl(src.getId_aptappl());
		resDTO.setId_apt(src.getId_apt());
		resDTO.setId_pat(appDTO.getId_pat());
		resDTO.setId_dep(src.getId_dep());
		resDTO.setId_dep(appDTO.getId_dep_mp());
		resDTO.setId_srv(appDTO.getId_srv());
		resDTO.setId_scca(src.getId_scca());
		resDTO.setId_scsrv(src.getId_scsrv());
		resDTO.setFg_stop_daysmsgs(FBoolean.FALSE);
		resDTO.setDays_excl_must(src.getDays_excl_must());
		resDTO.setDays_excl_hint(src.getDays_excl_hint());
		resDTO.setDays_together_must(src.getDays_together_must());
		resDTO.setDays_together_hint(src.getDays_together_hint());
		resDTO.setDays_excl_times(src.getDays_excl_times());
		resDTO.setApt_time(src.getApt_time());
		resDTO.setId_apt_mt(src.getId_apt_mt());
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
	private void handleAutoPrnPho(MtResDTO resDTO,MtResDTO src,MtAppDTO appDTO) throws BizException{
		if(src.getFg_needcfm().booleanValue())
		{
			Boolean chkFee = ScParamUtils.getScAptMtChkFee(appDTO.getId_dep_mp());// 检查费用参数
			if(appDTO.getFg_auto_cfm()!= null && appDTO.getFg_auto_cfm().booleanValue() && ((chkFee && appDTO.getFg_bl().booleanValue()) || !chkFee)){
				resDTO.setFg_auto_pho(src.getFg_auto_pho());
				resDTO.setFg_auto_prn(src.getFg_auto_prn());
				resDTO.setFg_auto_prn_bar(src.getFg_auto_prn_bar());
				return;
			}
			resDTO.setFg_auto_pho(FBoolean.FALSE);
			resDTO.setFg_auto_prn(FBoolean.FALSE);
			resDTO.setFg_auto_prn_bar(FBoolean.FALSE);
			return;
		}
		IScdeptparamMDORService iscdeptparammdorservice = ServiceFinder.find(IScdeptparamMDORService.class);
		StringBuffer condtion = new StringBuffer();
		condtion.append("id_dep ='").append(src.getId_dep()).append("' and id_scca='").append(src.getId_scca()).append("'");
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
