package iih.ci.ord.s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.founder.xap.runtime.msys.ModuleContext;
import com.founder.xap.runtime.msys.ModuleContextAware;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.ortpl.d.SrvortplitemAggDO;
import iih.ci.ord.cfg.dto.validatecondition.d.MedSrvValidateConditionDTO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciordems.d.AddFeeDTO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.confirm.OrConfirmRstDTO;
import iih.ci.ord.dto.confirm.OrConfirmVerifyParamDTO;
import iih.ci.ord.dto.d.CiOrdModifyEndTimeDTO;
import iih.ci.ord.dto.d.ImplVtDTO;
import iih.ci.ord.dto.d.OrSuModRtnInfoDTO;
import iih.ci.ord.dto.ems.EmsDrugCreateParamDTO;
import iih.ci.ord.dto.orsrvadd.d.OrSrvAddDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.SrvSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrSrvDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.dto.reportstatus.d.ReportStatusDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.idvproperty.d.IdVProperty;
import iih.ci.ord.nursorder.NursOrderControlBP;
import iih.ci.ord.nursorder.NursOrderDeleteBP;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOPAgainPresBP;
import iih.ci.ord.s.bp.CiOrderFeeDeleteBP;
import iih.ci.ord.s.bp.CiOrderFeeSaveBP;
import iih.ci.ord.s.bp.CiOrderUpdateHpCiDiBP;
import iih.ci.ord.s.bp.GetCiOderBlSrvBP;
import iih.ci.ord.s.bp.GetOpPreCalcFeeRstBP;
import iih.ci.ord.s.bp.GetOrderBP;
import iih.ci.ord.s.bp.GetPrintChargesDetailsBP;
import iih.ci.ord.s.bp.ImplVtBP;
import iih.ci.ord.s.bp.OrTplItemSaveBP;
import iih.ci.ord.s.bp.OrdRevokeBP;
import iih.ci.ord.s.bp.RelDeleteOrderBP;
import iih.ci.ord.s.bp.RevertCancelBP;
import iih.ci.ord.s.bp.RevertStopBP;
import iih.ci.ord.s.bp.SaveAgainSugBP;
import iih.ci.ord.s.bp.SaveCheckPatInfoBP;
import iih.ci.ord.s.bp.SaveCompleteConsultAggDOBP;
import iih.ci.ord.s.bp.SaveHealthCheckReportBP;
import iih.ci.ord.s.bp.SaveOrAppConsultAggDOBP;
import iih.ci.ord.s.bp.TLGetOrderBP;
import iih.ci.ord.s.bp.UpateCiOrderEndTimeBP;
import iih.ci.ord.s.bp.UpdateCiOrSrvDtLastBlBP;
import iih.ci.ord.s.bp.UpdateCiOrdePropertyBP;
import iih.ci.ord.s.bp.UpdateCiOrderSortnoBP;
import iih.ci.ord.s.bp.UpdateOrdMpInfoBP;
import iih.ci.ord.s.bp.UpdateOrdStatusInfo0BP;
import iih.ci.ord.s.bp.UpdateOrderSdMpBP;
import iih.ci.ord.s.bp.setOrcontentSkinTestBP;
import iih.ci.ord.s.bp.setOrderRefundBillCancelReserveBP;
import iih.ci.ord.s.bp.setPresWIndowNoBP;
import iih.ci.ord.s.bp.ems.GetBtlabRtnBP;
import iih.ci.ord.s.bp.ems.save.ip.CiOrDeleteBP;
import iih.ci.ord.s.bp.ems.save.ip.CiOrEmsSaveBP;
import iih.ci.ord.s.bp.ems.save.op.AgainSaveOrderBP;
import iih.ci.ord.s.bp.examine.UpdateOrderExamineBP;
import iih.ci.ord.s.bp.ordbttest.GetBtTestInfoBp;
import iih.ci.ord.s.bp.ordbttest.OrdBtTestSaveBp;
import iih.ci.ord.s.bp.order.cancel.CiOrderCancelBP;
import iih.ci.ord.s.bp.order.check.OrConfirmVerifyAction;
import iih.ci.ord.s.bp.order.sign.gj.CiOrderSignBP;
import iih.ci.ord.s.bp.order.stop.CiOrderStopBP;
import iih.ci.ord.s.bp.ordfeebill.OrdFeeBillHandleBP;
import iih.ci.ord.s.bp.orsms.lis.mergetube.SampcolOrdersBP;
import iih.ci.ord.s.bp.orsrvsplit.IpDrugDispenseAppSaveBP;
import iih.ci.ord.s.bp.quantum.CalDtEffeBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.reportstatus.UpdateReportStatusBp;
import iih.ci.ord.s.bp.updatestatus.UpdateOrsrvStatusBp;
import iih.ci.ord.s.ems.mdsstation.order.MdsStationCancelAction;
import iih.ci.ord.s.ems.mdsstation.order.MdsStationSignAction;
import xap.mw.basic.storage.StorageService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FBinary;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Level;
import xap.mw.log.logging.internal.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.rbac.userpassword.i.IUserPasswordManage;
import xap.sys.permfw.user.d.UserDO;
/**
 * 医嘱的修改保存删除类（自定义）
 * 
 * @ClassName: CiOrdMaintainServiceImpl
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年5月21日 下午5:43:34
 * @Package iih.ci.ord.s Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
@Service(serviceInterfaces = { ICiOrdMaintainService.class }, binding = Binding.JSONRPC)
public class CiOrdMaintainServiceImpl implements ICiOrdMaintainService, ModuleContextAware {

	private ModuleContext moduleContext;
	private Logger logger;

	/*
	 * @Override public void updateOrdMpInfo(DispenseDTO[] preses) throws
	 * BizException { UpdateOrdMpInfoBP bp=new UpdateOrdMpInfoBP();
	 * bp.updateOrdMpInfo(preses); }
	 */

	/**
	 * 费用回写医嘱项目的状态
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean UpdateOrdChargeRelInfo2(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl,Integer BLCGCANCEL) throws BizException {
		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
//		 return bp.UpdateOrdChargeRelInfo(orsrvids,id_su_bl, sd_su_bl);
		return bp.old_WriteBackCiOrSrvInfo(orsrvids, id_su_bl, sd_su_bl, dt_last_bl,BLCGCANCEL);
	}
 
	/**
	 * 费用回写医嘱项目的状态
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	@Deprecated
	public FBoolean UpdateOrdChargeRelInfo(String[] orsrvids, String id_su_bl, String sd_su_bl, FDateTime dt_last_bl) throws BizException {
		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
		// return bp.UpdateOrdChargeRelInfo(orsrvids,id_su_bl, sd_su_bl);
		return bp.WriteBackCiOrSrvInfo(orsrvids, id_su_bl, sd_su_bl, dt_last_bl);
	}
	/**
	 * 
	 */
	@Override
	@Deprecated
	public CiorderAggDO[] SaveEmsHeadDO(EmsHeadDO emsHeadDO, String type) throws BizException {
		// //System.out.println
		// System.out.println(emsHeadDO.getEmsapobs());
		// SetEmsBP bp = new SetEmsBP();
		// return bp.Save(emsHeadDO, type);
		return null;
	}
	
	public CiEmsSrvDTO[] saveOrdFeeBill(CiEmsSrvDTO[] szSrv,CiEnContextDTO ctx)throws BizException{
		
		OrdFeeBillHandleBP bp = new OrdFeeBillHandleBP();
		
		return bp.save(szSrv,ctx);
	}

	/**
	 * 医嘱执行时补录医嘱服务项目
	 * 
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdSrvDO[] insertOrSrvDataWhenPerform(OrSrvAddDTO[] addDTOs) throws BizException {

		if (ArrayUtil.isEmpty(addDTOs))
			return null;

		UpdateOrdMpInfoBP bp = new UpdateOrdMpInfoBP();
		return bp.insertOrSrvDataWhenPerform(addDTOs);

	}

	/**
	 * 住院摆药请领存盘 cn_cgex_ip_save
	 * 
	 * @param param
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	@Override
	public Integer ipDrugDispenseAppSave(OrSrvSplitParamDTO param, boolean isCharged) throws BizException {
		IpDrugDispenseAppSaveBP bp = new IpDrugDispenseAppSaveBP();
		return bp.exec(param, isCharged);
	}

	/*
	 * @Override public OrSuModRtnInfoDTO[] updateOrdStatusInfo(String[] id_ors,
	 * FDateTime dt_end, String sd_su_or) throws BizException {
	 * UpdateOrdStatusInfoBP bp=new UpdateOrdStatusInfoBP(); return
	 * bp.exec(id_ors, dt_end, sd_su_or); }
	 */
	/**
	 * 更新临床医嘱状态及相关信息 签署 核对（无补录） 作废 核对作废 停止 核对停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @param sd_su_or
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrSuModRtnInfoDTO[] updateOrdStatusInfo(IdVProperty[] id_ors, FDateTime dt_end, String sd_su_or) throws BizException {
		UpdateOrdStatusInfo0BP bp = new UpdateOrdStatusInfo0BP();
		return bp.exec(id_ors, dt_end, sd_su_or);
	}

	/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	@Override
	public CiOrderDO SaveCiEmsDTO(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", CiEnContext);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		iih.ci.ord.s.bp.ems.save.op.CiOrEmsSaveBP bp = new iih.ci.ord.s.bp.ems.save.op.CiOrEmsSaveBP();
		CiorderAggDO agg = bp.exec(ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
	/*	if(agg != null &&  agg.getParentDO().getSd_srvtp() !=IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI &&  agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
			getSaveAutoApt4C(agg.getParentDO());
		}*/
		 return agg.getParentDO();
		//return Medicalinfo(agg,CiEnContext);
	}

		/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	@Override
	public EmsRstDTO SaveCiEmsDTO_new(CiEmsDTO ciEmsDTO,CiEnContextDTO CiEnContext) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", CiEnContext);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		iih.ci.ord.s.bp.ems.save.op.CiOrEmsSaveBP bp = new iih.ci.ord.s.bp.ems.save.op.CiOrEmsSaveBP();
		EmsRstDTO rst = bp.exec2(ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
	/*	if(agg != null &&  agg.getParentDO().getSd_srvtp() !=IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI &&  agg.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){
			getSaveAutoApt4C(agg.getParentDO());
		}*/
		 return rst;
		//return Medicalinfo(agg,CiEnContext);
	}
	
	/*private void getSaveAutoApt4C(CiOrderDO ciorderDO)throws BizException{
	    String  risapp = SysParamUtils.getSysParam().getSYS_PARAM_IsOpenRisApt4IIH().getOrgParam();
		if(new FBoolean(risapp).booleanValue()){ 
		    ISc4CiCmdService outcmdService = ServiceFinder.find(ISc4CiCmdService.class);
			if(outcmdService==null) throw new BizException("预约的 ISc4CiCmdService 为空！");
			String param = getRisAppParam(ciorderDO);
			if("02".equals(param) ){  // 00 不预约 01 弹出预约 02 自动预约
				MtAptParamDTO paramDTO = new MtAptParamDTO();
				paramDTO.setId_or(ciorderDO.getId_or());
				paramDTO.setId_srv(ciorderDO.getId_srv());
				paramDTO.setDt_effe_or(ciorderDO.getDt_effe());
				paramDTO.setName_or(ciorderDO.getName_or());
				paramDTO.setD_begin(ciorderDO.getDt_effe().getDate());
				paramDTO.setId_ent(ciorderDO.getId_en());
				paramDTO.setId_dep_mp(ciorderDO.getId_dep_mp());
				paramDTO.setId_emp_appl(ciorderDO.getId_emp_or());
				paramDTO.setFg_urgent(ciorderDO.getFg_urgent());
				paramDTO.setApplyno(ciorderDO.getApplyno());
				paramDTO.setId_pat(ciorderDO.getId_pat());
				paramDTO.setCode_scchl("02");
				paramDTO.setContent_or(ciorderDO.getContent_or());
				paramDTO.setId_dep_apply(ciorderDO.getId_dep_or());
				paramDTO.setId_entp(ciorderDO.getId_entp());
				paramDTO.setSc_mt_mode(IScDictCodeConst.CI_AUTO_SC_APT_MODE);
				outcmdService.saveApt4Ci(paramDTO);
			}
		}
	 }
	 private String getRisAppParam(CiOrderDO ciorderDO)throws BizException{
		 StringBuffer sbuilder  = new StringBuffer();
	     CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
         sbuilder.append(" Id_user='");
         sbuilder.append(context.getId_user());
         sbuilder.append("' and Id_group='");
         if(!StringUtils.isBlank(context.getId_org())){
        	 sbuilder.append(context.getId_org()); 
         }else{
        	 sbuilder.append(context.getId_grp());
         }
         sbuilder.append("' and Pageid='");
         sbuilder.append("xap.rui.Control.XapBaseControl.UserIndividualSetting");
         sbuilder.append("' and Propertyname='");
         sbuilder.append("461005");
         sbuilder.append("'");
		 IUserindividualRService   userindividualservice = ServiceFinder.find(IUserindividualRService.class);
		 UserIndividualPropertyDO[]  userIndividual = userindividualservice.find(sbuilder.toString(), "", FBoolean.FALSE);
		 if(userIndividual != null && userIndividual.length >0){
			String value =  userIndividual[0].getValue();
			if(value != null && value.indexOf(":") >0){
				return value.substring(value.indexOf(":")+1);
			}
		 }
		 return "";	
	 }*/
	
	/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] SaveCiEmsDTO_TL(CiEmsDTO ciEmsDTO,CiEnContextDTO ctx) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", ctx);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		CiOrEmsSaveBP bp = new CiOrEmsSaveBP();
		CiorderAggDO[] aggs = bp.exec(ctx, ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		List<CiOrderDO> orders = new ArrayList<CiOrderDO>();
		for(CiorderAggDO agg : aggs){
			orders.add(agg.getParentDO());
		}
		return orders.toArray(new CiOrderDO[0]);
//		CiOrderDO[] orders = new CiOrderDO[1];
//		orders[0] = aggs.getParentDO();		
//		 return orders;
//		//return Medicalinfo(agg,CiEnContext);
	}
	 
	
		/**
	 * 医嘱保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	@Override
	public EmsRstDTO[] SaveCiEmsDTO_TL_new(CiEmsDTO ciEmsDTO,CiEnContextDTO ctx) throws BizException {
		//CiEnContextDTO 存放在上下文信息中
		Context.get().setAttribute("CiEnContextDTO", ctx);
		long startTIme = System.currentTimeMillis();
		logger.info("SaveCiEmsDTO  医嘱开始  .." + System.currentTimeMillis() + "毫秒");
		CiOrEmsSaveBP bp = new CiOrEmsSaveBP();
		EmsRstDTO[] rst = bp.exec2(ctx, ciEmsDTO);
		logger.info("SaveCiEmsDTO 结束 耗时  .." + (System.currentTimeMillis() - startTIme) + "毫秒");

		return rst;
//		CiOrderDO[] orders = new CiOrderDO[1];
//		orders[0] = aggs.getParentDO();		
//		 return orders;
//		//return Medicalinfo(agg,CiEnContext);
	}
	
	/**
	 * 医嘱保存提示信息后保存
	 * 
	 * @param ciEmsDTO
	 * @return CiOrderDO
	 * @throws BizException
	 */
	public  CiOrderDO SaveCiEmsDTO2(CiOrderDO orderDO,CiEnContextDTO CiEnContext) throws BizException{
		
		return null;
	}

	
	/**
	 * 删除医嘱 和相关的信息
	 * 
	 * @param id_orders
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean relDeleteOrder(String[] id_orders) throws BizException {
		RelDeleteOrderBP bp = new RelDeleteOrderBP();
		return bp.RelDeleteOrder(id_orders);
	}

	/**
	 * 临床医嘱的签署（Step0） 医嘱开始签署时使用
	 * 
	 * @param id_ors
	 *            医嘱id集合
	 * @param ciEnContextDTO
	 *            就诊上下文环境
	 * @return
	 * @throws BizException
	 */
	 @Override
	 @Deprecated
	public ValidateRtnInfoDTO ciOrderSign_TL(String[] id_ors, CiEnContextDTO ciEnContextDTO,boolean fgUseEr,OrderOperateDTO arg) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBP bp = new iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBP();
		return bp.exec(id_ors, ciEnContextDTO,fgUseEr,arg);
	}
	@Override
	public ValidateRtnInfoDTO ciOrderSign(String[] id_ors, CiEnContextDTO ciEnContextDTO) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		iih.ci.ord.s.bp.order.sign.gj.CiOrderSignBP bp = new iih.ci.ord.s.bp.order.sign.gj.CiOrderSignBP();
		return bp.exec(id_ors, ciEnContextDTO);
	}

	/**
	 * 
	 * @param map
	 *            医嘱信息
	 * @param Code_entp
	 *            就诊类型
	 * @return
	 */
	@Override
	public ValidateRtnInfoDTO CiOrderSignMedicalInsurance(FMap2 map, String Code_entp) throws BizException {
		CiOrderSignBP bp = new CiOrderSignBP();
		return bp.CiorderSignMedicalInsurance(map, Code_entp);
	}

	/**
	 * 临床医嘱的签署（Step1） 医嘱签署互斥停嘱互动提示后，继续时调用该服务 code_entp 就诊类型
	 * 
	 * @param map
	 * @return
	 * @throws BizException
	 */
	@Override
	public ValidateRtnInfoDTO ciOrderSignStep1(FMap2 map, String Code_entp,CiEnContextDTO ctx) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ctx);
		if(CiOrdUtils.PROJECT_GJ.equals(CiOrdUtils.getProjectIdentity(ctx.getCode_entp()))){
			iih.ci.ord.s.bp.order.sign.gj.CiOrderSignStep1BP bp = new iih.ci.ord.s.bp.order.sign.gj.CiOrderSignStep1BP();
			return bp.exec(map, Code_entp);
		}else{
			iih.ci.ord.s.bp.order.sign.tl.CiOrderSignStep1BP bp = new iih.ci.ord.s.bp.order.sign.tl.CiOrderSignStep1BP();
			return bp.exec(map, Code_entp);
		}
		
		
	}

	/**
	 * 临床医嘱的停止
	 * 
	 * @param id_ors
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderStop(String[] id_ors, FDateTime dt_end) throws BizException {
		CiOrderStopBP bp = new CiOrderStopBP();
		return bp.exec(id_ors, dt_end);
	}

	/**
	 * 临床医嘱的签署撤回
	 * 
	 * @param ids
	 *            门诊时为id_en 住院时为id_ors
	 * @param sd_entp
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderSignBack(String[] ids, String sd_entp) throws BizException {
		
		if(CiOrdUtils.PROJECT_GJ.equals(CiOrdUtils.getProjectIdentity(sd_entp))){
			iih.ci.ord.s.bp.order.sign.gj.CiOrderSignBackBP bp = new iih.ci.ord.s.bp.order.sign.gj.CiOrderSignBackBP();
			return bp.exec(ids, sd_entp);
		}else{			
			iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBackBP bp = new iih.ci.ord.s.bp.order.sign.tl.CiOrderSignBackBP();
			return bp.exec(ids, sd_entp);	
		}
	}

	/**
	 * 临床医嘱的核对（签署后的）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCheck(String[] id_ors) throws BizException {
		
		iih.ci.ord.s.bp.order.check.gj.CiOrderCheckBP bp = new iih.ci.ord.s.bp.order.check.gj.CiOrderCheckBP();
		return bp.exec(id_ors);
	}

	/**
	 * 临床医嘱的作废（已核对未执行）
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCancel(String[] id_ors) throws BizException {
		
		CiOrderCancelBP bp = new CiOrderCancelBP();
		return bp.exec(id_ors);
	}

	/**
	 * 临床医嘱的作废核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderCancChk(String[] id_ors) throws BizException {
		
		if(CiOrdUtils.PROJECT_GJ.equals(CiOrdUtils.getProjectIdentity())){
			iih.ci.ord.s.bp.order.check.gj.CiOrderCancChkBP bp = new iih.ci.ord.s.bp.order.check.gj.CiOrderCancChkBP();
			return bp.exec(id_ors);	
		}else{
			iih.ci.ord.s.bp.order.check.tl.CiOrderCancChkBP bp = new iih.ci.ord.s.bp.order.check.tl.CiOrderCancChkBP();
			return bp.exec(id_ors);
		}
		
	}

	/**
	 * 临床医嘱的停止核对
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] ciOrderStopChk(String[] id_ors) throws BizException {
		
		if(CiOrdUtils.PROJECT_GJ.equals(CiOrdUtils.getProjectIdentity())){
			iih.ci.ord.s.bp.order.check.gj.CiOrderStopChkBP bp = new iih.ci.ord.s.bp.order.check.gj.CiOrderStopChkBP();
			return bp.exec(id_ors);	
		}else{
			iih.ci.ord.s.bp.order.check.gj.CiOrderStopChkBP bp = new iih.ci.ord.s.bp.order.check.gj.CiOrderStopChkBP();
			return bp.exec(id_ors);	
		}
	}

	/**
	 * 皮试结果写回到医嘱内容中
	 * 
	 * @param id_or
	 * @param skinTest
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO setOrcontentSkinTest(String id_or, String skinTest) throws BizException {
		setOrcontentSkinTestBP bp = new setOrcontentSkinTestBP();
		return bp.exec(id_or, skinTest);
	}

	/**
	 * 停止 签署 作废 状态的核对
	 */
	@Override
	public CiOrderDO[] CiOrderSCSCheck(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors) throws BizException {

		iih.ci.ord.s.bp.order.check.gj.CiOrderSCSCheckBP bp = new iih.ci.ord.s.bp.order.check.gj.CiOrderSCSCheckBP();
		return bp.exec(id_sign_ors, id_canc_ors, id_stop_ors);
	}
	
	/**
	 * 停止 签署 作废 状态的核对(铜陵用)
	 */
	@Override
	public CiOrderDO[] CiOrderSCSCheck_TL(String[] id_sign_ors, String[] id_canc_ors, String[] id_stop_ors,String id_emp_second_chk,FDateTime dt_chk_stop) throws BizException {

		iih.ci.ord.s.bp.order.check.tl.CiOrderSCSCheckBP bp = new iih.ci.ord.s.bp.order.check.tl.CiOrderSCSCheckBP();
		return bp.exec(id_sign_ors, id_canc_ors, id_stop_ors,id_emp_second_chk, dt_chk_stop);
	}

	/**
	 * 医嘱确认物品补录保存
	 */
	@Override
	public AddFeeDTO[] CiOrderFeeSave(String id_or, AddFeeDTO[] drugs, Integer sourcein) throws BizException {

		CiOrderFeeSaveBP bp = new CiOrderFeeSaveBP();
		return bp.exe(id_or, drugs, sourcein);
	}

	/**
	 * 医嘱模板保存
	 * 
	 * @param aggdos
	 * @throws BizException
	 */
	@Override
	public void SaveOrTplItem(SrvortplitemAggDO[] aggdos) throws BizException {
		OrTplItemSaveBP bp = new OrTplItemSaveBP();
		bp.exec(aggdos);
	}

	/**
	 * 暂时不用 执行拆分回写医嘱项目最新生成时间
	 * 
	 * @param Id_ors
	 *            医嘱ID
	 * @param Dt_last_bl
	 *            时间
	 * @throws BizException
	 */
	@Override
	public String UpdateCiOrSrvDtLastBl(OrSplitDTO[] orSplit, SrvSplitDTO[] srvSplit) throws BizException {

		if (orSplit == null || orSplit == null)
			throw new BizException("执行拆分回写医嘱项目参数为空！");
		UpdateCiOrSrvDtLastBlBP bp = new UpdateCiOrSrvDtLastBlBP();
		return bp.exe(orSplit, srvSplit);
	}

	/**
	 * 保存会诊信息和会诊状态
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @param consultType
	 *            类型 0 应答，1 科室审批，2 医务审批
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiorappconsultAggDO[] SaveOrAppConsultAggDO(CiorappconsultAggDO[] aggdos, String consultType) throws BizException {
		if (aggdos == null)
			return null;
		SaveOrAppConsultAggDOBP bp = new SaveOrAppConsultAggDOBP();
		return bp.exe(aggdos, consultType);
	}

	/**
	 * 执行回写医嘱状态
	 * 
	 * @param id_ors
	 *            医嘱id_ors
	 * @param sd_mptp
	 *            执行状态 1 执行 2 不执行
	 * @param dt_last_mp
	 *            执行时间
	 * @param dt_last_cg
	 *            费用时间
	 * @return
	 * @throws BizException
	 */
	@Override
	public String UpdateOrderSdMp(WriteBackOrDTO[] paramDTOS) throws BizException {
		UpdateOrderSdMpBP bp = new UpdateOrderSdMpBP();
		return bp.exe(paramDTOS);
	}

	/**
	 * 医嘱项目执行状态回写
	 * 
	 * @param parmDTOS
	 * @throws BizException
	 */
	public CiorderAggDO[] UpdateOrderSrvSdMp(WriteBackOrSrvDTO[] paramDTOS) throws BizException {
		UpdateOrsrvStatusBp bp = new UpdateOrsrvStatusBp();

		return bp.exec(paramDTOS);
	}

	/**
	 * 完成会诊
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiorappconsultAggDO SaveCompleteConsultAggDO(CiorappconsultAggDO[] aggdos) throws BizException {
		if (aggdos == null || aggdos.length == 0)
			throw new BizException("没有会诊信息");

		SaveCompleteConsultAggDOBP bp = new SaveCompleteConsultAggDOBP();
		return bp.exe(aggdos);
	}
	
	/**
	 * 完成会诊状态撤回到科室审批 6状态
	 * 
	 * @param aggs
	 *            会诊的记录信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdApConsDO revokeAggDo(OrdApConsDO aggdos) throws BizException {
		if (aggdos == null )
			throw new BizException("没有会诊信息");

		SaveCompleteConsultAggDOBP bp = new SaveCompleteConsultAggDOBP();
		return bp.exe1(aggdos);
	}

	@Override
	public void CiOrderFeeDelete(AddFeeDTO fee) throws BizException {

		CiOrderFeeDeleteBP bp = new CiOrderFeeDeleteBP();
		bp.exe(fee);
	}

	/**
	 * 备血信息查询
	 */
	@Override
	public CiordrptbttestAggDO findApbt(String no_applyForm) throws BizException {
		
		GetBtTestInfoBp bp=new GetBtTestInfoBp();
		
		return bp.exec(no_applyForm);
	}

	/**
	 * 保存、更新备血申请的可用血余量
	 * 
	 */
	@Override
	public CiordrptbttestAggDO saveApbt(CiordrptbttestAggDO aggDO, FBoolean fg_submit) throws BizException {

		OrdBtTestSaveBp bp = new OrdBtTestSaveBp();

		return bp.exec(aggDO, FBoolean.TRUE.equals(fg_submit));
	}

	public CiOrderDO[] saveHealthCheckReport(OrdSrvDO[] orsrvdos, String[] id_ors) throws BizException {
		SaveHealthCheckReportBP bp = new SaveHealthCheckReportBP();
		return bp.exec(orsrvdos, id_ors);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.founder.xap.runtime.msys.ModuleContextAware#setModuleContext(com.
	 * founder.xap.runtime.msys.ModuleContext)
	 */
	@Override
	public void setModuleContext(ModuleContext arg0) {

		this.moduleContext = arg0;
		this.logger = this.moduleContext.getLogger("CI_ORDER.DEBUG");
		this.moduleContext.setLogLevel("CI_ORDER.DEBUG", Level.INFO);
		CiOrdUtils.setLogger(this.logger);
	}

	/**
	 * 更新报告装填和医嘱的结果（检查检验）
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public void UpdateReportAndOrderState(ReportStatusDTO[] params) throws BizException {

		UpdateReportStatusBp bp = new UpdateReportStatusBp();

		bp.exec(params);
	}

	/**
	 * 保存径内径外医嘱报告
	 */
	public void saveCporCheckReport(CiOrderDO[] ciOrderDOs, String[] id_ors) throws BizException {
		if (!CiOrdUtils.isEmpty(id_ors)) {
			this.relDeleteOrder(id_ors);
		}
		if (!CiOrdUtils.isEmpty(ciOrderDOs)) {
			String[] idOrsMod = new String[ciOrderDOs.length];
			int i = 0;
			for (CiOrderDO ciOrdDO : ciOrderDOs) {
				idOrsMod[i++] = ciOrdDO.getId_or();
			}
			CiOrderDO[] orderDODatas = CiOrdAppUtils.getCiorderMDORService().findByBIds(idOrsMod, FBoolean.FALSE);
			for (CiOrderDO ciOrdDo : orderDODatas) {
				for (CiOrderDO ordo : ciOrderDOs) {
					if (ordo.getId_or().equals(ciOrdDo.getId_or())) {
						ciOrdDo.setEu_uncporjudge(ordo.getEu_uncporjudge());
						ciOrdDo.setReason_uncporuse(ordo.getReason_uncporuse());
						ciOrdDo.setNote_or(ordo.getNote_or());
						ciOrdDo.setStatus(DOStatus.UPDATED);
					}
				}
			}
			CiOrdAppUtils.getOrService().save(orderDODatas);
		}
	}

	@Override
	public void updateCiOrderBhpjudgerst(CiEnContextDTO contextDTO) throws BizException {

		CiOrderUpdateHpCiDiBP bp = new CiOrderUpdateHpCiDiBP(contextDTO);
		bp.execUpdateOrds();
	}

	/***
	 * 毒麻药品签署时保存核对的患者信息
	 * 
	 * @param checkPatInfoSrvs
	 * @param agentInfo
	 * @throws BizException
	 */
	@Override
	public void saveCheckPatInfo(FArrayList checkPatInfoSrvs, OrSrvAgentInfoDO agentInfo) throws BizException {
		SaveCheckPatInfoBP bp = new SaveCheckPatInfoBP();
		bp.exec(checkPatInfoSrvs, agentInfo);
	}
	@Override
	public Integer getTotalTimes(FDateTime dt_effe,String id_freq, int use_day) throws BizException {
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getTotalTimes(dt_effe,id_freq, use_day);
	}
	@Override
	public FDouble getMMQuantum(String code_entp, FBoolean fg_pres_outp, int times, String id_mm, String id_unit_sale,
			FDouble quan_medu) throws BizException {
		CalQuantumBP bp = new CalQuantumBP();
		return bp.getMMQuantum(code_entp, fg_pres_outp, times, id_mm, id_unit_sale, quan_medu);
	}

	/**
     * 根据费用id_srv返回费用备注
     * @param idsrvs
     * @return
     * @throws BizException
     */
	@Override
	public FMap getCiOrderBlSrvDesByIdsrvs(String[] idsrvs) throws BizException {
		GetCiOderBlSrvBP bp=new GetCiOderBlSrvBP();
		return bp.getCiordBlSrvByIdsrvs(idsrvs);
	}

	/**
     * 根据医嘱id_or返回费用备注
     * @param idors
     * @return
     * @throws BizException
     */
	@Override
	public FMap getCiOrderBlSrvDesByIdors(String[] idors) throws BizException {
		GetCiOderBlSrvBP bp=new GetCiOderBlSrvBP();
		return bp.getCiordBlSrvByIdors(idors);
	}
	 /**
     * 重新分方
     * @param id_ent
     * @param sd_entp
     * @return
     * @throws BizException
     */
	@Override
	public CiOrderDO[] CiOPAgainPres(String id_en, String id_dep_sign, String sd_entp, CiEnContextDTO ctx)
			throws BizException {
		if (id_en == null || sd_entp == null)
			return null;
		Context.get().setAttribute("CiEnContextDTO", ctx);
		CiOPAgainPresBP bp = new CiOPAgainPresBP();
		return bp.exec(ctx, id_dep_sign, sd_entp );
	}
	
	/**
     * 记账时 回写处方的窗口号
     * @param map<id_pres,winNo> key 处方号，values 是窗口号
     * @throws BizException
     */
	@Override
    public void setPresWindowNo(Map<String,String> map)throws BizException{
		setPresWIndowNoBP bp = new setPresWIndowNoBP();
		bp.exec(map);
	}
	
	
	/**
	 * 医生站记账
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param AcctountType 记账类型
	 * @param id_psndoc 当前操作人id
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String orderKeepAccounts(String id_ent, String code_entp, String acctountType,String id_psndoc) throws BizException {

		GetOpPreCalcFeeRstBP bp = new GetOpPreCalcFeeRstBP();
		return bp.exec(id_ent, code_entp, acctountType,id_psndoc);
	}

	/**
	 * 医生站销账
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @param AcctountType 记账类型
	 * @DmEnumDesc(name="预交金记账",description="预交金记账") public static final String CG_PREPAY="1"; //预交金记账
	 * @DmEnumDesc(name="高端商保记账",description="高端商保记账") public static final String CG_HPCG="2"; //高端商保记账
	 * 
	 * @return
	 * @throws BizException
	 */
	@Override
	public String cancelOrderAccounting(String id_ent, String code_entp, String id_psndoc) throws BizException {

		// 当前登录医生id		
		String msg = CiOrdAppUtils.getIBLOrderAppendBillService().setRefundBillForCi_ByIdent(id_ent, code_entp, id_psndoc);
		return msg;
	}
	
	
	/**
	 * 高端商保销账
	 * @param idOrs
	 * @param id_psndoc
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	@Override
	public String setOrderRefundBillCancelReserve(String[] idOrs,String id_psndoc,CiEnContextDTO ciEnContextDTO)throws BizException{
		 if(idOrs == null || idOrs.length==0 ||id_psndoc== null || ciEnContextDTO== null)throw new BizException("parammeter is null");
		setOrderRefundBillCancelReserveBP bp = new setOrderRefundBillCancelReserveBP();
		return bp.setOrderRefundBillCancelReserve(idOrs, id_psndoc, ciEnContextDTO);
	}
	/**
	 * 获得打印单费用明细
	 * @param print_no
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrintDetailsSrv(String[] print_no,String id_ent)
			throws BizException {
		if(print_no == null || print_no.length==0 )throw new BizException("parammeter is null");
		GetPrintChargesDetailsBP bp =new GetPrintChargesDetailsBP();
		return bp.exe(print_no,id_ent);
	}
	/**
	 * 生命体征预置数据导入
	 * @param vt
	 * @return
	 * @throws BizException
	 */
	public boolean importVt(ImplVtDTO vt) throws BizException{
		ImplVtBP bp = new ImplVtBP();
		bp.exec(vt);
		return true;
	}

	@Override
	public FArrayList checkBdSrvInfo(MedSrvValidateConditionDTO args) throws BizException {
		FMap2 variableValueMap = new FMap2();
		StringBuilder sb = new StringBuilder();
		sb.append(" Id_grp = '").append(args.getId_grp()).append("' ");
		sb.append(" and Id_org = '").append(args.getId_org()).append("' ");
		
		variableValueMap.put("id_grp", args.getId_grp());
		variableValueMap.put("id_org", args.getId_org());
		
		if (null!= args.getSd_srvtp() && !args.getSd_srvtp().isEmpty()){
			String strSdSrvtp = args.getSd_srvtp().replace(",", "','");
			strSdSrvtp = "'" +strSdSrvtp+"'";
			sb.append(" and substr(Sd_srvtp,0,2) in (").append(strSdSrvtp).append(") ");
		}
		variableValueMap.put("where", sb.toString());
		if (args.getFg_update() != null && FBoolean.TRUE.equals(args.getFg_update())){
			variableValueMap.put("IsUpdateDB", "1");
		}
		else{
			variableValueMap.put("IsUpdateDB", "0");
		}
		if(FBoolean.TRUE.equals(args.getFg_active())){
			
			variableValueMap.put("IsActive", "1");
		}
		else{
			variableValueMap.put("IsActive", "0");
		}		
		
		ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
		String taskId =api.submitTask0("BDSrvInfoCheckTask_Param", CiOrdAppUtils.getServerDateTime().addSeconds(3), variableValueMap);
		//BackgroundWorkUtil.createBgWorkByAlertTypeCode("BDSrvInfoCheckTask_Param", variableValueMap, );

		return null;
	}

	public String refreshCheckBdSrvInfo(MedSrvValidateConditionDTO args) throws BizException {
		String path = "M00/00/01/wKhJD1k3hWuEdFQMAAAAAE-tP7s5815157";
		StorageService ss = ServiceFinder.find(StorageService.class);
		FBinary rst = ss.read(path);
		String report = "";
		try {
			report = convertStreamToString(rst.getBody());
		} catch (IOException e) {
			throw new BizException(e.getMessage());
		}
		return report;
	}
	
	private String convertStreamToString(InputStream is) {      
        /*  
          * To convert the InputStream to String we use the BufferedReader.readLine()  
          * method. We iterate until the BufferedReader return null which means  
          * there's no more data to read. Each line will appended to a StringBuilder  
          * and returned as String.  
          */     
         BufferedReader reader = new BufferedReader(new InputStreamReader(is));      
         StringBuilder sb = new StringBuilder();      
     
         String line = null;      
        try {      
            while ((line = reader.readLine()) != null) {      
                 sb.append(line + "\n");      
             }      
         } catch (IOException e) {      
             e.printStackTrace();      
         } finally {      
            try {      
                 is.close();      
             } catch (IOException e) {      
                 e.printStackTrace();      
             }      
         }      
     
        return sb.toString();      
     }
	 
	 /**
	 * 修改医嘱的停止时间
	 */
	public CiOrdModifyEndTimeDTO updateCiOrdDtEnd(CiOrdModifyEndTimeDTO ciOrdModifyEndTimeDTO) 
	{
		UpateCiOrderEndTimeBP bp = new UpateCiOrderEndTimeBP();
		return bp.exec(ciOrdModifyEndTimeDTO);
	}
	/**
	 * 校验人员和密码
	 */
	public FBoolean validatePsndocPassword(String id_psndoc,String password) throws BizException{
		IUserPasswordManage manage = ServiceFinder.find(IUserPasswordManage.class);
		List<UserDO> list = (List<UserDO>)new DAFacade().findByAttrValString(UserDO.class, UserDO.ID_PSN, id_psndoc, new String[]{UserDO.ID_USER});
		if(CiOrdUtils.isEmpty(list))
			return FBoolean.FALSE;
		for(UserDO user:list){
			if(manage.checkUserPassWord(user.getId_user(), password)){
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}

	@Override
	public FDateTime getDtEffe(String id_freq) throws BizException {
		CalDtEffeBP bp = new CalDtEffeBP();
		return bp.GetDtEffe(id_freq);
	}
	
	
	@Override
	public FBoolean updateCiOrderSortno(FMap idOrMap) throws BizException{
		
		UpdateCiOrderSortnoBP bp = new UpdateCiOrderSortnoBP();
		return bp.exec(idOrMap);
	}
	
	@Override
	public FBoolean updateCiOrderFgPrn(String id_or, FBoolean fg_prn) throws BizException{
		
		UpdateCiOrdePropertyBP bp =new UpdateCiOrdePropertyBP();
		return bp.updateCiOrderFgPrn(id_or,fg_prn);
	}
	
	@Override
	public Integer getDaysAvalidate(String sd_mupakgu,FDouble quan_cur,FDouble quan_medu,FDouble factor,FDouble factor_mb,String id_freq) throws BizException {
		GetTotalTimesBP bp = new GetTotalTimesBP();
		return bp.getDaysAvalidate(sd_mupakgu,quan_cur, quan_medu,factor,factor_mb, id_freq);
	}
	 

    /**
     * 保存时提示信息再次保存 TODO 临时方案，
     *  emstype  医疗单类型
     *   cienConttextDTO 上下文信息
     *   return CiOrderDO
     */
	@Override
    public CiorderAggDO AgainSaveOrder(String emstype,CiEnContextDTO ciEnContextDTO)throws BizException{
		Context.get().setAttribute("CiEnContextDTO", ciEnContextDTO);
		AgainSaveOrderBP bp = new AgainSaveOrderBP();
		return bp.exec();
	}
	
	/**
	 * 本次就诊下 自费未结算的医嘱
	 */
	public FBoolean getEffective(CiEnContextDTO ctx)throws BizException{
		CiOrderUpdateHpCiDiBP bp = new CiOrderUpdateHpCiDiBP(ctx);
		return bp.getEffectiveOrder(ctx.getId_en());
	}

	@Override
	public OrderRstDTO ordRevoke(IdVProperty[] id_ors, FArrayList reactOrds, CiEnContextDTO ciEnContext, FDateTime dt_end,
			String sd_su_or, OrderOperateDTO arg) throws BizException {
		OrdRevokeBP bp = new OrdRevokeBP();
		return bp.ordRevoke(id_ors, reactOrds, ciEnContext,dt_end, sd_su_or, arg);
	}
    @Override
	public FArrayList getBtlabRtnFromIE(CiEnContextDTO CiEnContext, FArrayList btviewitem) throws BizException {
		GetBtlabRtnBP bp = new GetBtlabRtnBP();
		return bp.exec(CiEnContext, btviewitem);
	}
    @Override
	public FBoolean FgSelfpay(String[] id_ors, CiEnContextDTO ctx,FBoolean fg_selfpay) throws BizException {
		if (CiOrdUtils.isEmpty(id_ors)) return FBoolean.FALSE;
		ICiorderRService iordsrvdorservice = ServiceFinder.find(ICiorderRService.class);
		CiorderAggDO[] aggs = iordsrvdorservice.findByIds(id_ors, FBoolean.FALSE);
		
		String sqlQry = "select s.id_orsrv,s.id_srv,m.id_mm from ci_order o ,ci_or_srv s,ci_or_srv_mm m where o.id_or = s.id_or and s.fg_bl='Y' and s.id_orsrv = m.id_orsrv(+) and o.id_or in (%s)";
		
		StringBuffer idOrBuffer = new StringBuffer();
		SqlParam param = new SqlParam();

		for(CiorderAggDO agg : aggs){
			
			CiOrderDO order = agg.getParentDO();
			param.addParam(order.getId_or());
			idOrBuffer.append(",?");
		}
		
		DAFacade da = new DAFacade();
		
		List<OrdSrvDO> ordSrvList = (List<OrdSrvDO>) da.execQuery(String.format(sqlQry, idOrBuffer.substring(1)), param, new BeanListHandler(OrdSrvDO.class));
		List<String> idSrvList = new ArrayList<String>();
		List<String> idMmList = new ArrayList<String>();
		Map<String,String> idOrsrvMap = new HashMap<String,String>();
		
		for(OrdSrvDO ordSrv : ordSrvList){
			
			idOrsrvMap.put(ordSrv.getId_orsrv(),
					ordSrv.getId_srv() + (StringUtils.isEmpty(ordSrv.getId_mm()) ? "" : ordSrv.getId_mm()));
			
			if(StringUtils.isNotEmpty(ordSrv.getId_mm())){
				idMmList.add(ordSrv.getId_mm());
			}else{
				idSrvList.add(ordSrv.getId_srv());
			}
		}
		
		Map<String, HPSrvorcaDO> hpSrvorcaMap = CiOrdUtils.getHPSrvorcaMap(ctx.getId_hp(),idSrvList,idMmList);
		
		for(CiorderAggDO agg:aggs){
			
			CiOrderDO orderdo = agg.getParentDO();
			orderdo.setStatus(DOStatus.UPDATED);
			OrdSrvDO[] ordsrvs = agg.getOrdSrvDO();
			
			for (OrdSrvDO ordSrv : ordsrvs) {
				
				if(!FBoolean.TRUE.equals(ordSrv.getFg_bl())){
					continue;
				}
				
				HPSrvorcaDO hpSrvorca = hpSrvorcaMap.get(idOrsrvMap.get(ordSrv.getId_orsrv()));
				if(hpSrvorca == null || StringUtils.isEmpty(hpSrvorca.getId_hpsrvtp()) || StringUtils.isEmpty(hpSrvorca.getSd_hpsrvtp())){
					ordSrv.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
					ordSrv.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
				}else{
					ordSrv.setId_hpsrvtp(hpSrvorca.getId_hpsrvtp());
					ordSrv.setSd_hpsrvtp(hpSrvorca.getSd_hpsrvtp());
				}
				
				if(IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(ordSrv.getSd_hpsrvtp())){
					ordSrv.setFg_selfpay(FBoolean.TRUE);
				}else{
					ordSrv.setFg_selfpay(fg_selfpay);	
				}
				
				
				ordSrv.setStatus(DOStatus.UPDATED);
			}
		}
		CiOrdUtils.SetFgOrHpOfCiOrder(aggs);
		ICiorderCudService iordsrvdocudservice = ServiceFinder.find(ICiorderCudService.class);
		iordsrvdocudservice.save(aggs);
		return FBoolean.TRUE;
	}

	@Override
	public String revertStop(String[] id_ors) throws BizException {
		RevertStopBP bp = new RevertStopBP();
		return bp.exec(id_ors);
	}

	@Override
	public EmsRstDTO[] saveNursOrders(CiEnContextDTO ctx, CiOrderDO[] orders) throws BizException {
		Context.get().setAttribute("CiEnContextDTO", ctx);
		NursOrderControlBP bp = new NursOrderControlBP();
		return bp.exec(ctx, orders);
	}
    public boolean deleteNursOrders(String[] id_ors) throws BizException{
    	NursOrderDeleteBP bp = new NursOrderDeleteBP();
    	return bp.delete(id_ors);
    }

	@Override
	public boolean saveAgainSug(OrdApOpAgainDO dataSource) throws BizException {
		SaveAgainSugBP bp = new SaveAgainSugBP();
		return bp.exec(dataSource);
	}

	@Override
	public String revertCancel(String[] id_ors) throws BizException {
		RevertCancelBP bp = new RevertCancelBP();
		return bp.exec(id_ors);
	}
	 /**
     *  药品医嘱的审核信息
     * @param id_ors
     * @param id_emp_verify_pharm
     * @param eu_verify_pharm
     * @param des_verify_pharm
     * @throws BizException
     */
	@Override
    public   void  updateOrderExamine(String[] id_ors,String id_emp_verify_pharm,
    		Integer eu_verify_pharm,String des_verify_pharm) throws BizException{
		 UpdateOrderExamineBP bp = new UpdateOrderExamineBP();
		 bp.updateOrderExamine(id_ors, id_emp_verify_pharm, eu_verify_pharm, des_verify_pharm);
	}

	@Override
	public void forceDelOrders(String[] id_ors) throws BizException {
		CiOrDeleteBP ciOrDeleteBP = new CiOrDeleteBP();
		ciOrDeleteBP.forceDelete(id_ors);
	}

	@Override
	public EmsOrDrug[] creatDrugItems(EmsDrugCreateParamDTO source, CiEnContextDTO contextdto) throws BizException {
		GetOrderBP bp = new TLGetOrderBP();
		return bp.exec(source,contextdto);
	}

	@Override
	public CiOrderDO[] sampcolOrders(String[] idors) throws BizException {
		SampcolOrdersBP bp = new SampcolOrdersBP();
		return bp .exec(idors);
	}

	@Override
	public ValidateRtnInfoDTO SignOrdersMds(String[] id_ors, CiEnContextDTO ciEnContextDTO, boolean fgUseEr,
			OrderOperateDTO arg) throws BizException {
		MdsStationSignAction action = new MdsStationSignAction();
		return action.sign(id_ors, ciEnContextDTO, fgUseEr, arg);
	}

	@Override
	public OrderRstDTO CancelOrdersMds(OrderOperateDTO operateDTO) throws BizException {
		MdsStationCancelAction action = new MdsStationCancelAction();
		return action.cancel(operateDTO);
	}

	@Override
	public OrConfirmRstDTO ordConfirmVerify(OrConfirmVerifyParamDTO verifyParam) throws BizException {
		OrConfirmVerifyAction action = new OrConfirmVerifyAction(verifyParam);
		return action.exec();
	}
	
}
