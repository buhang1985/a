package iih.ci.ord.s.bp.event;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrSignCancelListener;
import iih.ci.ord.s.bp.iemsg.GetIEMsgOpInfo4CancStpBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpCancleMsgInfo4Pharm8idenBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4LisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4PBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4TreatNBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4UBtBP;
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
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 门诊医嘱作废事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrCancelEvent4IeBP extends AbstractOrSignCancelListener {

	@Override
	protected void doYourActionAfterOrSignCancel(CiOrderDO[] ors) throws BizException {
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
		//设置就诊号
		htors8ieevent.put(ICiIEEventConst.EVENT_IE_ID_ENT, ors[0].getId_en());
		
		// 发布IE门诊医嘱撤销事件
		fireEvent4Ie(htors8ieevent);

	}

	/**
	 * 医嘱数据分组组织
	 * 
	 * @param htors8ieevent
	 * @param ors
	 * @return
	 */
	public int orGrpHandle4IeEvent(Hashtable<String, String> htors8ieevent, CiOrderDO[] ors) {
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
		String id_or = "";
		if (iscancStp) {
			ieeventtype = ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP;
			
		} else {
			ieeventtype = CiOrdUtils.getIeOpCancEventTypeStr(or.getSd_srvtp());
			id_or = ICiIEEventConst.EVENT_IE_ID_OR;
		}

		orGrpHandle4IeEvent(ht, or, ieeventtype,id_or);
	}

	/**
	 * 医嘱数据组织
	 * 
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String, String> ht, CiOrderDO or, String ieeventtype,String id_or) {
		// 有效性校验
		if (CiOrdUtils.isEmpty(ieeventtype))
			return;
		if (ht.containsKey(ieeventtype)) {
			String ors = ht.get(ieeventtype) + CiOrdUtils.COMMA_STR + or.getId_or();
			ht.put(ieeventtype, ors);
		} else {
			ht.put(ieeventtype, or.getId_or());
		}
		// 有效性校验
		if (CiOrdUtils.isEmpty(id_or))
			return;
		if (ht.containsKey(id_or)) {
			String ors = ht.get(id_or) + CiOrdUtils.COMMA_STR + or.getId_or();
			ht.put(id_or, ors);
		} else {
			ht.put(id_or, or.getId_or());
		}
	}

	/**
	 * 
	 * @param htors8ieevent
	 * @throws BizException
	 */
	public void fireEvent4Ie(Hashtable<String, String> htors8ieevent) throws BizException {
		
		// 有效性验证
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;

		// 集成平台药品医嘱消息体数据生成并触发相应事件
		fireEvent4Pharm(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG);

		// 集成平台检查申请消息体数据生成并触发相应事件
		fireEvent4Ris(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_RIS);

		// 集成平台检验申请消息体数据生成并触发相应事件
		fireEvent4Lis(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_LIS);

		// 集成平台手术申请消息体数据生成并触发相应事件
		fireEvent4Op(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_CANC_STOP);
		//fireEvent4Ie(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_OP);
		// 集成平台备血消息体数据生成并触发相应事件
		fireEvent4PBt(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_PBT);

		// 集成平台用血消息体数据生成并触发相应事件
		fireEvent4UBt(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_UBT);

		// 集成平台治疗消息体数据生成并触发相应事件(BS303)
		fireEvent4Treat(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT);

	}

	/**
	 * 事件发送 药品医嘱
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Pharm(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		
		// 生成集成平台药品医嘱服务数据信息
//		GetIEOpMsgInfo4Pharm8idorBP bp = new GetIEOpMsgInfo4Pharm8idorBP();
		//2017-08-02 16:05:08 by yzh 原来签署时签署哪个传哪个 现在通过就诊查询就诊下所有药品处方传过去
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrCancelEvent4IeBP]药品医嘱撤回集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpCancleMsgInfo4Pharm8idenBP bp = new GetIEOpCancleMsgInfo4Pharm8idenBP();
		String id_wc_ors=htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_WC);
		String id_herb_ors=htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_HERB);
		String iden=htors8ieevent.get(ICiIEEventConst.EVENT_IE_ID_ENT);
		BaseDTO[] msgdos = bp.exec(id_wc_ors, id_herb_ors,iden);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpPharmOrEnDTO endo=(IEOpPharmOrEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",null,"0");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("new");
			mbx.setPatientCode(endo.getPatientid());
			if (endo.getTimes() == null || endo.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(endo.getTimes()));
			}
			mbx.setEnNO(endo.getP_bar_code());
			mbx.setApplyUnitId(endo.getApplydeptcode());// 第四位申请科室遍码
			//费用状态  
			FMap2 params = new FMap2();
			String id_ors = null;
			if (!CiOrdUtils.isEmpty(id_wc_ors)) {
				id_ors = id_wc_ors;
			} else {
				id_ors = id_herb_ors;
			}
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			mbx.setExtendSubId("0");
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊药品医嘱 【撤回】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("药品医嘱撤回集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
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
		//GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrCancelEvent4IeBP]检查撤回集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4RisNoAcountBP bp = new GetIEOpMsgInfo4RisNoAcountBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威 武威撤回时为具体医嘱分类
		String isWuWei="";
		String iemsgca_code="099";
		try {
			isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
			OrdBizLogger.info(null, "检查撤回isWuWei1:"+isWuWei);
		} catch (Exception e) {
			OrdBizLogger.info(null, "异常："+e);
			isWuWei="0";//出异常 默认不是武威
		}
		OrdBizLogger.info(null, "检查撤回isWuWei2:"+isWuWei);
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			if(isWuWei.equals("1")) {//武威
				iemsgca_code=ierisordto.getIemsgca_code();
			}
			OrdBizLogger.info(null, "iemsgca_code"+iemsgca_code);
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ierisordto.getSqd_deptcode(),iemsgca_code);
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("delete");
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
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊检查 【撤回】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			System.out.println("消息头:"+userobj.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("门诊检查撤回集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 检验申请
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		//GetIEOpMsgInfo4LisBP bp = new GetIEOpMsgInfo4LisBP();
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrCancelEvent4IeBP]检验撤回集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4LisNoAcountBP bp = new GetIEOpMsgInfo4LisNoAcountBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威  武威撤回时为具体医嘱分类
		String isWuWei="";
		String iemsgca_code="099";
		try {
			isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
		} catch (Exception e) {
			isWuWei="0";//出异常 默认不是武威
		}
		System.out.println("检验撤回isWuWei:"+isWuWei);
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			if(isWuWei.equals("1")) {//武威
				iemsgca_code=ielisordto.getIemsgca_code();
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),iemsgca_code);
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("delete");
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
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
		//	DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),ielisordto.getOrder_type());
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊检验 【撤回】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("门诊检验撤回集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	//	CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, msgdos);
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
		OrdBizLogger.info(ctx, "[FireOpOrCancelEvent4IeBP]手术撤回集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEMsgOpInfo4CancStpBP bp=new GetIEMsgOpInfo4CancStpBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpOrCancStpEnDTO ieusedto =(IEOpOrCancStpEnDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ieusedto.getExec_unit(),ieusedto.getIemsgca_code());//消息分发规则：门诊手术医嘱小分类					
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("cancel");
			mbx.setPatientCode(ieusedto.getPatient_id());
			if (ieusedto.getTimes() == null || ieusedto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ieusedto.getTimes()));
			}
			mbx.setEnNO(ieusedto.getVisitordno());
			mbx.setExtendSubId("0");// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			IEOpOrCancStpDTO ieOpOrCancStpDTO=null;
			if(!CiOrdUtils.isEmpty(ieusedto.getId_ieorcancstps())) {
				ieOpOrCancStpDTO=(IEOpOrCancStpDTO)ieusedto.getId_ieorcancstps().get(0);
				mbx.setApplyUnitId(ieOpOrCancStpDTO.getApply_code());// 第四位申请科室遍码
				mbx.setOrderNO(ieOpOrCancStpDTO.getOrder_id());
			}
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊手术 【撤回】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("门诊手术撤回集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 备血
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4PBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		GetIEOpMsgInfo4PBtBP bp = new GetIEOpMsgInfo4PBtBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		for (BaseDTO baseDTO : msgdos) {
			//获取执行科室
			IEOpBtOrEnDTO iebtdto =(IEOpBtOrEnDTO) baseDTO;	
			@SuppressWarnings("unused")
			String iemsgcaString=iebtdto.getIemsgca_code();
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,iebtdto.getExec_code(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("delete");
			mbx.setPatientCode(iebtdto.getPatientid());
			if (iebtdto.getTimes() == null || iebtdto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iebtdto.getTimes()));
			}
			mbx.setEnNO(iebtdto.getPbarcode());
			mbx.setApplyNO(iebtdto.getApplyno());
			mbx.setOrderNO(iebtdto.getYz_no());
			mbx.setExtendSubId(iebtdto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebtdto.getApplydept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", iebtdto.getJztype());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			// 触发事件
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "门诊备血撤回每次发送数据："+baseDTO.serializeJson());
		}
		
	}

	/**
	 * 事件发送 用血
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4UBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		GetIEOpMsgInfo4UBtBP bp = new GetIEOpMsgInfo4UBtBP();
		BaseDTO[] msgdos = bp.exec(htors8ieevent.get(ieEventType));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		for (BaseDTO baseDTO : msgdos) {
			//获取执行科室
			IEOpBtUseOrDTO iebudto =(IEOpBtUseOrDTO) baseDTO;
			@SuppressWarnings("unused")
			String iemsgcaString=iebudto.getIemsgca_code();
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(baseDTO, BusiType.MZ,iebudto.getExec_code(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("delete");
			mbx.setPatientCode(iebudto.getPatient_id());
			if (iebudto.getTimes() == null || iebudto.getTimes().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(iebudto.getTimes()));
			}
			mbx.setEnNO(iebudto.getP_bar_code());
			mbx.setApplyNO(iebudto.getUse_sn());
			mbx.setOrderNO(iebudto.getYz_no());
			mbx.setExtendSubId(iebudto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebudto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
	        params.put("VISIT_TYPE", iebudto.getVisit_type());// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "门诊用血撤回每次发送数据："+baseDTO.serializeJson());
		}
	}

	/**
	 * 事件发送 治疗(BS303)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Treat(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台药品医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrCancelEvent4IeBP]治疗撤回集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4TreatNBP bp = new GetIEOpMsgInfo4TreatNBP();
		String idors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(idors, FBoolean.FALSE);
		
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpTreatOrEnDTO ielisdto =(IEOpTreatOrEnDTO) d;
			IEOpTreatOrDTO ielisordto=(IEOpTreatOrDTO) (ielisdto.getIetreators()).get(0);			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisordto.getExec_sn(),"099");
			MsgObj mbx=new MsgObj();
			mbx.setInteractionCode("delete");
			mbx.setPatientCode(ielisdto.getPatient_id());
			if (ielisdto.getAdmiss_times() == null || ielisdto.getAdmiss_times().equals("")) {
				mbx.setEntimes(0);
			}else{
				mbx.setEntimes(Integer.parseInt(ielisdto.getAdmiss_times()));
			}
			mbx.setEnNO(ielisdto.getP_bar_code());
			mbx.setOrderNO(ielisordto.getYz_no());
			mbx.setExtendSubId(ielisordto.getPayflag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(ielisdto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(idors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });	
			OrdBizLogger.info(null, "+++++++++++++++++门诊治疗 【撤回】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("门诊治疗撤回集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

}
