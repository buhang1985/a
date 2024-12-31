package iih.ci.ord.s.bp.event;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
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
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4LisBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4OpBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4TreatNBP;
import iih.ci.ord.s.bp.iemsg.GetPayFlagHelper;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.ip.cfg.XipCfg;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 门诊医嘱签署事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrLisAndRisAfterFeeEvent4IeBP extends AbstractOpOrLisAndRisFeeAfterListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 空判断
		if (CiOrdUtils.isEmpty(ors))
			return;
		Hashtable<String, String> htors8ieevent = new Hashtable<String, String>(); // 参数定义

		// 医嘱数据分组组织
		int signcnt = orGrpHandle4IeEvent(htors8ieevent, ors);
		if (signcnt == 0)
			return;

		// 发布IE门诊医嘱开立事件
		fireEvent4Ie(htors8ieevent);

	}

	/**
	 * 医嘱数据分组组织
	 * 
	 * @param htors8ieevent
	 * @param ors
	 * @return
	 */
	private int orGrpHandle4IeEvent(Hashtable<String, String> htors8ieevent, CiOrderDO[] ors) {
		// 参数
		int iN = ors.length;
		int count = 0;

		// 遍历
		for (int i = 0; i < iN; i++) {
			if (!CiOrdUtils.isOpWf(ors[i].getCode_entp()))
				continue;
			count++;
			// 获得分组数据
			orGrpHandle4IeEvent(htors8ieevent, ors[i], false);
		}

		return count;
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, boolean iscancStp) {
		String ieeventtype = "";
		if (iscancStp) {
			ieeventtype = ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP;
		} else {
			ieeventtype = CiOrdUtils.getIeOpEventTypeStr(or.getSd_srvtp());
		}
		orGrpHandle4IeEvent(ht, or, ieeventtype);
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, String ieeventtype) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(ieeventtype))
			return;
		if (ht.containsKey(ieeventtype)) {
			String ors = ht.get(ieeventtype) + CiOrdUtils.COMMA_STR + or.getId_or();
			ht.put(ieeventtype, ors);
		} else {
			ht.put(ieeventtype, or.getId_or());
		}
	}

	/**
	 * 
	 * @param htors8ieevent
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String, String> htors8ieevent) throws BizException {

		// 有效性验证
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;

		// 集成平台检查申请消息体数据生成并触发相应事件
		fireEvent4Ris(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_RIS);

		// 集成平台检验申请消息体数据生成并触发相应事件
		fireEvent4Lis(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_LIS);
		
		// 集成平台手术申请消息体数据生成并触发相应事件
		fireEvent4Op(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_OP);
		
		//集成平台治疗(诊疗)收费触发相应时间(BS303)
		fireEvent4Treat(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT);
	}

	/**
	 * 事件发送 检查申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ris(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检查医嘱服务数据信息
//		GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
//		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
//		if (CiOrdUtils.isEmpty(msgdos))
//			return;
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrLisAndRisAfterFeeEvent4IeBP]检查-收费-集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		// 生成集成平台检查医嘱服务数据信息
		GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ierisordto.getSqd_deptcode(),ierisordto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(ierisdto.getPatient_id());
			if (StringUtils.isBlank(ierisdto.getTimes())) {
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
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊检查-收费-发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			System.out.println("消息头:"+userobj.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("检查-收费-集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		// 触发事件
//		CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, msgdos);
	}

	/**
	 * 事件发送 检验申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检验申请服务数据信息
		GetIEOpMsgInfo4LisBP bp = new GetIEOpMsgInfo4LisBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			IEOpLisOrEnDTO ielisdto = (IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto = (IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto = (IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getIemsgca_code());
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setExtendSubId(ielisitemdto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_unit());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });

		}

	}

	/**
	 * 事件发送 手术申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Op(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台手术医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]药品医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4OpBP bp = new GetIEOpMsgInfo4OpBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]手术医嘱签署集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpOpOrEnDTO ieopdto =(IEOpOpOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ieopdto.getExec_code(),ieopdto.getIemsgca_code());
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
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj } );
			
		}
		
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]手术医嘱签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	/**
	 * 集成平台治疗(诊疗)收费触发相应时间(BS303)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Treat(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		
		GetIEOpMsgInfo4TreatNBP bp = new GetIEOpMsgInfo4TreatNBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors, FBoolean.TRUE);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) d;
			IEOpTreatOrDTO ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisordto.getExec_sn(),"099");
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
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });		
		}
	}


}
