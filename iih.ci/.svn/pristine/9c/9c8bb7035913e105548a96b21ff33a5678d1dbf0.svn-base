package iih.ci.ord.s.bp.event;

import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IENsOrDTO;
import iih.ci.ord.iemsg.d.IENsOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.iemsg.d.IEOpConsulationDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOthOrDTO;
import iih.ci.ord.iemsg.d.IEOthOrEnDTO;
import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEIpMsgInfo4OpBP;
import iih.ci.ord.s.bp.iemsg.GetIEIpMsgInfo4PBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEIpMsgInfo4RisBP;
import iih.ci.ord.s.bp.iemsg.GetIEIpMsgInfo4TreatBP;
import iih.ci.ord.s.bp.iemsg.GetIEIpMsgInfo4UBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4CancStpBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4ConBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4LisNewBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4NsBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4OthBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4PharmBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4TranDepsBP;
import iih.ci.ord.s.bp.iemsg.GetIEMsgNsConfirmBP;
import iih.ci.ord.s.bp.iemsg.GetPayFlagHelper;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.ip.cfg.XipCfg;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 发送医嘱护士核对确认事件操作BP
 * （集成平台事件）
 */
public class FireOrNsCheckEvent4IeBP {
	/**
	 * 发送医嘱护士核对确认事件
	 * 含：签署核对、作废核对、停止核对
	 * （集成平台事件）
	 * @param htors8ieevent  按集成平台事件类型粒度组织的医嘱数据
	 * @throws BizException
	 */
	public void exec(Hashtable<String,String> htors8ieevent,String id_or) throws BizException{
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		//if(true)return;   //暂时先不处理，等调整时在处理，现在报错
		if(CiOrdUtils.isEmpty(htors8ieevent))return;
		
		Map<String,Object> confirminfo=getIEMsgNsConfirmInfo(id_or);
		
		//集成平台药品医嘱消息体数据生成并触发相应事件
		fireEvent4Pharm(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG,confirminfo);
		
		//集成平台检查申请消息体数据生成并触发相应事件(BS002)
		fireEvent4Ris(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_RIS);
		
		//集成平台检验申请消息体数据生成并触发相应事件(BS006)
		fireEvent4Lis(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_LIS);
		
		//集成平台手术申请消息体数据生成并触发相应事件(BS007)
		fireEvent4Op(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OP,confirminfo);
		
		//集成平台会诊申请消息体数据生成并触发相应事件(BS318)
		fireEvent4Con(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CON,confirminfo);
		
		//集成平台备血消息体数据生成并触发相应事件(BS008-输血申请)
		fireEvent4PBt(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_PBT,confirminfo);
		
		//集成平台用血消息体数据生成并触发相应事件
		fireEvent4UBt(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_UBT,confirminfo);
		
		//集成平台出院消息体数据生成并触发相应事件
		//fireEvent4Out(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OUT);
		
		//集成平台护理消息体数据生成并触发相应事件(BS304)
		fireEvent4Ns(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_NS,confirminfo);
		
		//集成平台治疗消息体数据生成并触发相应事件(BS303)
		fireEvent4Treat(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TREAT);
		
		//集成平台转科消息体数据生成并触发相应事件
	//	fireEvent4TranDep(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_TRANDEP,confirminfo);
		
		//集成平台其它医嘱消息体数据生成并触发相应事件(BS305)
		fireEvent4Oth(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_OTH);
		
		//集成平台作废与停止消息体数据生成并触发相应事件(BS005-02)
		fireEvent4CancStp(htors8ieevent,ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CANC_STOP,id_or);
	}
	
	/**
	 * BS005： 医嘱撤销和停止服务</br>
	 * 医嘱停止、作废核对触发事件
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4CancStp(Hashtable<String,String> htors8ieevent,String ieEventType,String id_or) throws BizException{
		
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]医嘱撤销和停止服务集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		//生成集成平台住院作废核对或停核医嘱服务数据信息
		GetIEMsgInfo4CancStpBP bp=new GetIEMsgInfo4CancStpBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos=bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]医嘱撤销和停止服务集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
	//	CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		String type=id_or.substring(0, 1);
		String operate_code = "cancel";
		 if(type.equals("2")){
			operate_code = "stop";
		}
		for (BaseDTO d : msgdos) {
			
			IEOrCancStpEnDTO ieusedto =(IEOrCancStpEnDTO) d;
			IEOrCancStpDTO ieOrCancStpDTO=null;
			String iemsgca_codeString="";
			MsgObj mbx=new MsgObj();
			if(!CiOrdUtils.isEmpty(ieusedto.getId_ieorcancstps())) {
				ieOrCancStpDTO=(IEOrCancStpDTO)ieusedto.getId_ieorcancstps().get(0);
				mbx.setOrderNO(ieOrCancStpDTO.getOrderno());
				mbx.setSpecimenNO(ieOrCancStpDTO.getBbno());
				iemsgca_codeString=ieOrCancStpDTO.getIemsgca_code();
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieusedto.getExec_dept_code(),iemsgca_codeString);
			
			mbx.setInteractionCode(operate_code);
			mbx.setPatientCode(ieusedto.getPatientid());
			if (ieusedto.getAdmiss_times() == null || ieusedto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieusedto.getAdmiss_times()));
			}
			mbx.setEnNO(ieusedto.getVisit_sort_no());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ieusedto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
		//	DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]医嘱撤销和停止服务集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送
	 * 转科
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4TranDep(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4TranDepsBP bp=new GetIEMsgInfo4TranDepsBP();
		BaseDTO[] msgdos=bp.exec(htors8ieevent.get(ieEventType),confirminfo);
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
		CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
	}
	
	/**
	 * 事件发送(BS303)
	 * 治疗
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Treat(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		
		// 生成集成平台治疗医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]治疗医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEIpMsgInfo4TreatBP bp = new GetIEIpMsgInfo4TreatBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors,FBoolean.FALSE);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]治疗医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) d;
			IEOpTreatOrDTO ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ielisordto.getExec_sn(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ielisdto.getPatient_id());
			if (ielisdto.getAdmiss_times() == null || ielisdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ielisdto.getAdmiss_times()));
			}
			mbx.setOrderNO(ielisordto.getYz_no());
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setExtendSubId(ielisordto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]治疗医嘱签署确认集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送(BS305)
	 * 其它
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Oth(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		
		//生成集成平台其他医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]其他医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEMsgInfo4OthBP bp=new GetIEMsgInfo4OthBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos=bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]其他医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(msgdos))return;
		
		for (Object object : msgdos) {
			IEOthOrEnDTO ieothorendto = (IEOthOrEnDTO)object;
			IEOthOrDTO ieothordto = (IEOthOrDTO)(ieothorendto.getIeothors()).get(0);
			DomainBusinessUserObj buo = new DomainBusinessUserObj(object, BusiType.ZY,ieothordto.getExe_dept_code(), ieothordto.getSd_iemsgca());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieothorendto.getPatientid());
			if (ieothorendto.getAdmiss_times() == null || ieothorendto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieothorendto.getAdmiss_times()));
			}
			mbx.setOrderNO(ieothordto.getYz_code());
			mbx.setEnNO(ieothorendto.getPatientseqnum());
			mbx.setExtendSubId(ieothordto.getFybj_code());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ieothordto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			buo.setMsgObj(mbx);	
			//触发事件
			CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,new BaseDTO[] { buo });
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]其他医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送
	 * 护理(BS304)
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ns(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		
		//生成集成平台护理医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]护理医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEMsgInfo4NsBP bp=new GetIEMsgInfo4NsBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos=bp.exec(idors,confirminfo);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]护理医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(msgdos))return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IENsOrEnDTO iensdto=(IENsOrEnDTO) d;
			IENsOrDTO iensordto=(IENsOrDTO) (iensdto.getId_iensors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",iensordto.getExe_dept_code(),iensordto.getSd_iemsgca());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(iensdto.getPatientid());
			if (iensdto.getAdmiss_times() == null || iensdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iensdto.getAdmiss_times()));
			}
			mbx.setOrderNO(iensordto.getOrder_code());
			mbx.setEnNO(iensdto.getPatientseqnum());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iensdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]护理医嘱签署集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));

	}
	
	/**
	 * 事件发送
	 * 用血
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4UBt(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		
		// 生成集成平台用血医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]用血医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEIpMsgInfo4UBtBP bp = new GetIEIpMsgInfo4UBtBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]用血医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtUseOrDTO iebudto =(IEOpBtUseOrDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",iebudto.getExec_code(),iebudto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(iebudto.getPatient_id());
			if (iebudto.getTimes() == null || iebudto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iebudto.getTimes()));
			}
			mbx.setEnNO(iebudto.getP_bar_code());
			mbx.setApplyNO(iebudto.getUse_sn());
			mbx.setOrderNO(iebudto.getYz_no());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebudto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]用血医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送(BS008-输血申请)
	 * 备血
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4PBt(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		
		// 生成集成平台备血医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]备血医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEIpMsgInfo4PBtBP bp = new GetIEIpMsgInfo4PBtBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]备血医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtOrEnDTO iebtdto =(IEOpBtOrEnDTO) d;			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",iebtdto.getExec_code(),iebtdto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(iebtdto.getPatientid());
			if (iebtdto.getTimes() == null || iebtdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iebtdto.getTimes()));
			}
			mbx.setEnNO(iebtdto.getPbarcode());
			mbx.setApplyNO(iebtdto.getApplyno());
			mbx.setOrderNO(iebtdto.getYz_no());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebtdto.getApplydept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]备血医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送
	 * 会诊申请(BS318)
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Con(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]会诊申请医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		//生成集成平台会诊服务数据信息
		GetIEMsgInfo4ConBP bp=new GetIEMsgInfo4ConBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos=bp.exec(idors,confirminfo);
		if(CiOrdUtils.isEmpty(msgdos)) {
			return;
		}
		//触发事件
		//CiOrdUtils.fireEvent(ieEventType,IEventType.TYPE_UPDATE_AFTER,msgdos);
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpConsulationDTO ieopdto =(IEOpConsulationDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieopdto.getExecdept(),ieopdto.getSertypecode());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieopdto.getPatientlid());
			if (CiOrdUtils.isEmpty(ieopdto.getVisittimes())) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(ieopdto.getVisittimes());
			}
			mbx.setEnNO(ieopdto.getVisitno());
			mbx.setApplyNO(ieopdto.getRequestno());
			mbx.setOrderNO(ieopdto.getOrderlid());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ieopdto.getOrderdept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]会诊申请签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送(BS007)
	 * 手术申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Op(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
	
		// 生成集成平台手术医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]手术医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		//GetIEOpMsgInfo4OpBP bp1 = new GetIEOpMsgInfo4OpBP();
		String id_en = (String) confirminfo.get("id_iepharmoren");
		GetIEIpMsgInfo4OpBP bp = new GetIEIpMsgInfo4OpBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors, id_en);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]手术医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpOpOrEnDTO ieopdto =(IEOpOpOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ieopdto.getExec_code(),ieopdto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ieopdto.getPatient_id());
			if (ieopdto.getAdmit_times() == null || ieopdto.getAdmit_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieopdto.getAdmit_times()));
			}
			mbx.setEnNO(ieopdto.getP_bar_code());
			mbx.setApplyNO(ieopdto.getOp_record_id());
			mbx.setOrderNO(ieopdto.getYz_no());
			if(!CiOrdUtils.isEmpty(ieopdto.getIesugorders())) {
				IEOperationInfoDTO infoDto = (IEOperationInfoDTO)ieopdto.getIesugorders().get(0);
				mbx.setExtendSubId(infoDto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			mbx.setApplyUnitId(ieopdto.getDept_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]手术医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	
	/**
	 * 事件发送(BS006)
	 * 检验申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		
		// 生成集成平台检验医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]检验医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEMsgInfo4LisNewBP bp = new GetIEMsgInfo4LisNewBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检验医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ielisitemdto.getExec_code(),ielisordto.getIemsgca_code());
			//DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ielisitemdto.getExec_code(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ielisdto.getPatient_id());
			if (ielisdto.getTimes() == null || ielisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ielisdto.getTimes()));
			}
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setApplyNO(ielisordto.getJy_applyserial1());
			mbx.setOrderNO(ielisitemdto.getYz_no());
			mbx.setSpecimenNO(ielisitemdto.getSample_id());
			mbx.setExtendSubId(ielisitemdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检验医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	
	/**
	 * 事件发送(BS002)
	 * 检查申请
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ris(Hashtable<String,String> htors8ieevent,String ieEventType) throws BizException{
		
		// 生成集成平台检查医嘱服务数据信息
		// 就诊上下文
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEIpMsgInfo4RisBP bp = new GetIEIpMsgInfo4RisBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos)) {
			OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台事件,没有查到业务数据，返回"));
			return;
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台事件,准备组装消息内容"));
		// 触发事件
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",ierisordto.getSqd_deptcode(),ierisordto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ierisdto.getPatient_id());
			if (ierisdto.getTimes() == null || ierisdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ierisdto.getTimes()));
			}
			mbx.setEnNO(ierisdto.getP_bar_code());
			mbx.setApplyNO(ierisordto.getApply_serial());
			mbx.setSpecimenNO(ierisordto.getSamp_bar_code());
			if(!CiOrdUtils.isEmpty(ierisordto.getId_ierisoritms())) {
				IEOpRisOrItmDTO itmDto = (IEOpRisOrItmDTO)ierisordto.getId_ierisoritms().get(0);
				mbx.setExtendSubId(itmDto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			}
			mbx.setApplyUnitId(ierisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台事件,准备组装消息完毕，发送消息"));
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++住院检查【签署】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			System.out.println("消息头:"+userobj.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]检查医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));

	}
	
	/**
	 * 事件发送
	 * 药品医嘱
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Pharm(Hashtable<String,String> htors8ieevent,String ieEventType,Map<String,Object> confirminfo) throws BizException{
		
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOrNsCheckEvent4IeBP]药品医嘱签署确认集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		//生成集成平台药品医嘱服务数据信息
		GetIEMsgInfo4PharmBP bp= new GetIEMsgInfo4PharmBP();
		String id_wc_ors = htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_WC);
		String id_herb_ors = htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_NSCHK_DRUG_HERB);
		IEPharmOrEnDTO[] msgdos = bp.exec(id_wc_ors,id_herb_ors,confirminfo);
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]药品医嘱签署确认集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if(CiOrdUtils.isEmpty(msgdos))return;

		//触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室（就诊科室）
			IEPharmOrEnDTO endo=(IEPharmOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "02",endo.getDeptcode(),"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(endo.getPatientid());
			if (endo.getAdmiss_times() == null || endo.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(endo.getAdmiss_times()));
			}
			//收费状态标识
			String id_ors = null;
			if (!CiOrdUtils.isEmpty(id_wc_ors)) {
				id_ors = id_wc_ors;
			} else {
				id_ors = id_herb_ors;
			}
			String oneIdOr=id_ors.split(CiOrdUtils.COMMA_STR)[0];
			if(StringUtils.isNotEmpty(oneIdOr)) {
				OrdSrvDO[] ordSrvDOs;
				try {
					ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.ID_OR, oneIdOr);
					if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
						mbx.setExtendSubId(ordSrvDOs[0].getSd_su_bl());
					}
				} catch (BizException e) {
					mbx.setExtendSubId("");
					e.printStackTrace();
				}
			}
			mbx.setEnNO(endo.getPatientseqnum());
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"03":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("[FireOrNsCheckEvent4IeBP]药品医嘱签署确认集成平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		
	}
	
	/**
	 * 确认数据信息
	 * 患者、就诊、确认
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private Map<String,Object> getIEMsgNsConfirmInfo(String id_or) throws BizException{
		GetIEMsgNsConfirmBP bp=new GetIEMsgNsConfirmBP();
		return bp.exec(id_or);
	}

}
