package iih.ci.ord.s.bp.event;

import java.util.Hashtable;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpBtOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpBtUseOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrDTO;
import iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO;
import iih.ci.ord.iemsg.d.IEOperationInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrSignListener;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4LisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4OpBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4PBtBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4Pharm8idenBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisNoAcountBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4TreatNBP;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4UBtBP;
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
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 门诊医嘱签署事件侦听并进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrSignEvent4IeBP extends AbstractOrSignListener {

	@SuppressWarnings("unused")
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
       //设置就诊号
		htors8ieevent.put(ICiIEEventConst.EVENT_IE_ID_ENT, ors[0].getId_en());
		// 发布IE门诊医嘱开立事件   htors8ieevent的结构是[('iden',id_en),('iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO',id_or='','','')]
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
			ieeventtype = CiOrdUtils.getIeOpEventTypeStr(or.getSd_srvtp());
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
	protected void fireEvent4Ie(Hashtable<String, String> htors8ieevent) throws BizException {
		
		// 有效性验证
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;
		// 集成平台药品医嘱消息体数据生成并触发相应事件
		fireEvent4Pharm(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG);

		// 集成平台检查申请消息体数据生成并触发相应事件(BS002)
		fireEvent4Ris(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_RIS);

		// 集成平台检验申请消息体数据生成并触发相应事件(BS006)
		fireEvent4Lis(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_LIS);

		// 集成平台手术申请消息体数据生成并触发相应事件(BS007)
		fireEvent4Op(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_OP);

		// 集成平台备血消息体数据生成并触发相应事件(BS008-输血申请)
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
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]药品医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4Pharm8idenBP bp = new GetIEOpMsgInfo4Pharm8idenBP();
		String idors =  htors8ieevent.get(ICiIEEventConst.EVENT_IE_ID_OR);
		String id_wc_ors = htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_WC);
		String id_herb_ors = htors8ieevent.get(ICiIEEventConst.EVENT_IE_CIOR_OP_DRUG_HERB);
		String iden = htors8ieevent.get(ICiIEEventConst.EVENT_IE_ID_ENT);
		BaseDTO[] msgdos = bp.exec(id_wc_ors,id_herb_ors ,iden);
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]药品医嘱签署集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
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
			//收费状态标识
			String id_ors = null;
			if (!CiOrdUtils.isEmpty(id_wc_ors)) {
				id_ors = id_wc_ors;
			} else {
				id_ors = id_herb_ors;
			}
			mbx.setApplyUnitId(endo.getApplydeptcode());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
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
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			
		}
		OrdBizLogger.info(ctx, String.format("药品医嘱签署集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}
	/**
	 * 事件发送 检查申请 (BS002)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Ris(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检查医嘱服务数据信息
		// 就诊上下文
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]检查医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4RisNoAcountBP bp = new GetIEOpMsgInfo4RisNoAcountBP();
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors);
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]检查医嘱签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		// 触发事件
		//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威
		String isWuWei="";
		try {
			isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
		} catch (Exception e) {
			isWuWei="0";//出异常 默认不是武威
		}
		System.out.println("检查签署isWuWei:"+isWuWei);
	    String isFourString="";
	    String iemsgca_code="099";
		if(isWuWei.equals("1")) {//代表武威
			try {
				isFourString=ParamsetQryUtil.getParaString(ctx.getId_org(), "BLCG0002");
			} catch (Exception e) {
				isFourString="1";//出异常 默认不执行记账
			}
		}
		System.out.println("检查签署isFourString:"+isFourString);
		int i=1;
		for (BaseDTO d : msgdos) {
			//消息头格式:49101588-X:BS008:01:0:1010000:S001:099:01001
			//消息头的第一位内容为机构编码（49101588-X)，第二位服务名称(BS001),
			//第三位域ID，第四位申请科室遍码，第五位执行科室编码，第六位消息发送者ID,第七位消息分类，第八位收费标志位(0表示未收费，1表示收费)
			//1,2,6应该是集成组负责赋值
			//获取执行科室
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) d;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			if(isFourString.equals("4")) {//执行记账
				iemsgca_code=ierisordto.getIemsgca_code();
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ierisordto.getSqd_deptcode(),iemsgca_code);//(业务对象,域id,第五位执行科室编码,填写正确的医嘱小分类（第七位消息分类))
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
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊检查【签署】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			System.out.println("消息头:"+userobj.serializeJson());
			i++;
			
		}
		OrdBizLogger.info(ctx, String.format("检查医嘱签署集中平台事件完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 检验申请(BS006)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4Lis(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台检验医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]检验医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4LisNoAcountBP bp = new GetIEOpMsgInfo4LisNoAcountBP();
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors);
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]检验医嘱签署集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		// 触发事件
		//武威特有逻辑 0代表不是武威 1代表武威 默认不是武威
		String isWuWei="";
		try {
			isWuWei=ParamsetQryUtil.getParaString(Context.get().getOrgId(), "CIOR0501");
		} catch (Exception e) {
			isWuWei="0";//出异常 默认不是武威
		}
		System.out.println("检验签署isWuWei:"+isWuWei);
	    String isFourString="";
	    String iemsgca_code="099";
		if(isWuWei.equals("1")) {//代表武威
			try {
				isFourString=ParamsetQryUtil.getParaString(ctx.getId_org(), "BLCG0002");
			} catch (Exception e) {
				isFourString="1";//出异常 默认不执行记账
			}
		}
		System.out.println("检验签署isFourString:"+isFourString);
		int i=1;
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpLisOrEnDTO ielisdto =(IEOpLisOrEnDTO) d;
			IEOpLisOrDTO ielisordto=(IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto=(IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			if(isFourString.equals("4")) {//执行记账
				iemsgca_code=ielisordto.getIemsgca_code();
			}
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",ielisitemdto.getExec_code(),iemsgca_code);
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
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });
			OrdBizLogger.info(null, "+++++++++++++++++门诊检验【签署】发送次数+++++++++++++++++："+i+"次, "+d.serializeJson());
			i++;
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]检验医嘱签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 手术申请(BS007)
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
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors);
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
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);// 就诊类别，通过Map传递
			userobj.setMsgObj(mbx);
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj } );
			
		}
		
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]手术医嘱签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 备血(BS008-输血申请)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4PBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]备血医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		// 生成集成平台备血医嘱服务数据信息
		GetIEOpMsgInfo4PBtBP bp = new GetIEOpMsgInfo4PBtBP();
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;

		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtOrEnDTO iebtdto =(IEOpBtOrEnDTO) d;			
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",iebtdto.getExec_code(),"099");
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
			mbx.setExtendSubId(iebtdto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebtdto.getApplydept());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]备血签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 用血
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	private void fireEvent4UBt(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]用血医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		// 生成集成平台用血医嘱服务数据信息
		GetIEOpMsgInfo4UBtBP bp = new GetIEOpMsgInfo4UBtBP();
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors);
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
		for (BaseDTO d : msgdos) {
			//获取执行科室
			IEOpBtUseOrDTO iebudto =(IEOpBtUseOrDTO) d;
			DomainBusinessUserObj userobj = new DomainBusinessUserObj(d, "01",iebudto.getExec_code(),"099");
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
			mbx.setExtendSubId(iebudto.getPay_flag());// 扩展码-第八位收费标志位(0表示未收费，1表示收费)
			mbx.setApplyUnitId(iebudto.getApply_code());// 第四位申请科室遍码
			FMap2 params = new FMap2();
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]用血签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

	/**
	 * 事件发送 治疗(BS303)
	 * 
	 * @param htors8ieevent
	 * @param ieEventType
	 * @throws BizException
	 */
	protected void fireEvent4Treat(Hashtable<String, String> htors8ieevent, String ieEventType) throws BizException {
		// 生成集成平台治疗医嘱服务数据信息
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		OrdBizLogger.info(ctx, "[FireOpOrSignEvent4IeBP]治疗医嘱签署集成平台事件逻辑开始");
		long startTime = System.currentTimeMillis();
		GetIEOpMsgInfo4TreatNBP bp = new GetIEOpMsgInfo4TreatNBP();
		String id_ors=htors8ieevent.get(ieEventType);
		BaseDTO[] msgdos = bp.exec(id_ors, FBoolean.FALSE);
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]治疗医嘱签署集成平台事件,业务数据准备完毕,耗时:%s(ms)",System.currentTimeMillis()-startTime));
		if (CiOrdUtils.isEmpty(msgdos))
			return;
		
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
			String codeEntp=GetPayFlagHelper.getCodeEntp(id_ors);
	        params.put("VISIT_TYPE", (StringUtils.isEmpty(codeEntp))?"01":codeEntp);// 第三位域ID（就诊类别）
	        mbx.setExtras(params);
			userobj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(ieEventType, IEventType.TYPE_UPDATE_AFTER, new BaseDTO[] { userobj });				
		}
		OrdBizLogger.info(ctx, String.format("[FireOpOrSignEvent4IeBP]治疗医嘱签署集中平台数据处理完成,耗时:%s(ms)",System.currentTimeMillis()-startTime));
	}

}
