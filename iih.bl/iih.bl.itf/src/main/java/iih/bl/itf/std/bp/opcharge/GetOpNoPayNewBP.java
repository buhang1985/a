package iih.bl.itf.std.bp.opcharge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.charge.WsParamGetCostBill;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.charge.WsResultInfoOpGetNoPay;
import iih.bl.itf.std.bean.output.charge.WsResultOpGetPay;
import iih.bl.itf.std.bean.output.charge.sub.WsResultEntInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultItem;
import iih.bl.itf.std.bean.output.charge.sub.WsResultPeInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultPresInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.bp.validator.WsParamPayQryValidator;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.bl.st.i.IBlOepChargeQryService;
import iih.bl.st.i.IBlStQryService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊自助支付待缴查询新(跟旧的相比换了预划价接口)
 * 
 * @author shaokx 2019/07/17
 *
 */
public class GetOpNoPayNewBP extends BlItfBaseBP<WsParamGetCostBill,WsResultOpGetPay>{

	@Override
	protected String getBusiness() {
		// TODO Auto-generated method stub
		return "门诊自助支付待缴查询";
	}

	/**
	 */
	@Override
	protected void checkParam(WsParamGetCostBill param) throws BizException {
		WsParamPayQryValidator validator = new WsParamPayQryValidator();
		validator.validate(param);
	}

	/**
	 * 主逻辑
	 */
	@Override
	protected WsResultOpGetPay doWork(WsParamGetCostBill param) throws BizException {
		WsParamBillPatInfo paramInfo = param.getPatInfo();// 入参patinfo节点
		
		if(IBlWsConst.ENTP_PE.equals(paramInfo.getEntpCode())){
			//体检调入
			WsResultOpGetPay peRlt = this.peCallIn(paramInfo);
			return peRlt;
		}
		
		Integer callInDays = BlParams.BLSTOEP0004();//调入天数
		if(callInDays == null){
			throw new BizException("请维护参数BLSTOEP0004的值");
		}
		FDate endDate = AppUtils.getServerDate();//获取服务器时间
		FDate startDate = endDate.getDateBefore(callInDays);//开始时间，按照自然天算
//		FDate startDate = new FDate(paramInfo.getStartDate());
//		FDate endDate = new FDate(paramInfo.getEndDate());
		// 患者主键
		String patId = this.findPat(param);

		// 门诊调入(默认时间费用)接口，返回数组应该是按照明细级别的
		IBlOepChargeQryService oepChargeQryService = ServiceFinder.find(IBlOepChargeQryService.class);
		//BlOepChargeInputDTO[] oepChargeInputDTOs = oepChargeQryService.findOepCostInfoPeriod(patId, startDate, endDate);
		BlOepChargeCommonCondDTO condDto = new BlOepChargeCommonCondDTO();
		condDto.setId_pat(patId);
		condDto.setDt_begin(startDate);
		condDto.setDt_end(endDate);
		condDto.setFg_qrysusp(FBoolean.TRUE);
		BlOepChargeInputDTO[] oepChargeInputDTOs = oepChargeQryService.findOepCostInfoCond(condDto);

		
		if (ArrayUtil.isEmpty(oepChargeInputDTOs)) {
			throw new BizException("该患者没有需要调入的项目");
		}

		for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
			itm.setCode_bill(StringUtil.isEmpty(itm.getApplyno())
					? (StringUtil.isEmpty(itm.getPres_code())
							? (StringUtil.isEmpty(itm.getCode_or()) ? null : itm.getCode_or()) : itm.getPres_code())
					: itm.getApplyno());
			
			if(StringUtil.isEmpty(itm.getCode_bill()) && !StringUtil.isEmpty(itm.getCode_cg())){
				itm.setCode_bill(itm.getCode_cg());
			}
			
			if (StringUtil.isEmpty(itm.getCode_bill())) {
				throw new BizException("门诊调入结果：医疗单编码为空");
			}
		}

		// 组织预划价入参
		BlOepChargePricingDTO[] preChargeInput = this.getPreChargeInput(oepChargeInputDTOs);
		// 调用预划价接口
		IBlOepChargeCmdService blservice = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlOepChargePricingRltDTO[] outChargeDTOs = blservice.prePricing(preChargeInput,null);
		// 把预划价后产生的价格赋值给调入后的结果中（用id_orsrv进行匹配）
		this.setOepCallInPrice(oepChargeInputDTOs, outChargeDTOs);

		// 获得所有就诊信息集合
		List<WsResultEntInfo> oepEntList = this.getOepEntList(oepChargeInputDTOs, paramInfo,patId);// OEPEntList节点

		WsResultOpGetPay rlt = new WsResultOpGetPay();
		WsResultMsg rltMsg = new WsResultMsg();// 0成功，1失败
		WsResultInfoOpGetNoPay rltInfo = new WsResultInfoOpGetNoPay();// resultinfo节点

		rltInfo.setOepEntList(oepEntList);
		rlt.setRltInfo(rltInfo);

		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		rlt.setRltMsg(rltMsg);
		return rlt;
	}

	/**
	 * 体检调入
	 * @throws BizException 
	 */
	private WsResultOpGetPay peCallIn(WsParamBillPatInfo paramInfo) throws BizException{
		
		//获取患者id
		String patId = this.findPePat(paramInfo);
		
		//调用体检调入后台接口
		IBlStQryService blPeService = ServiceFinder.find(IBlStQryService.class);
		BlOepChargeInputDTO[] peChargeInputDTOs = blPeService.findPeSrvInfoByIdPatAndPecode(patId,paramInfo.getPeCode());
		
		if(ArrayUtil.isEmpty(peChargeInputDTOs)){
			WsResultOpGetPay rlt = new WsResultOpGetPay();
			WsResultMsg rltMsg = new WsResultMsg();// 0成功，1失败
			rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
			rltMsg.setMessage("成功");
			rlt.setRltMsg(rltMsg);
			return rlt;
		}

		//体检信息集合
		List<WsResultPeInfo> peInfoList = new ArrayList<WsResultPeInfo>();
		FDouble amt = FDouble.ZERO_DBL;//体检总金额
		
		for (BlOepChargeInputDTO itm : peChargeInputDTOs) {
			amt = amt.add(itm.getPrice_ratio().multiply(itm.getQuan()));
			WsResultPeInfo peInfo = new WsResultPeInfo();
			peInfo.setSrvCode(itm.getCode_srv());
			peInfo.setOrName(itm.getName_or());
			peInfo.setSrvName(itm.getName_srv());
			peInfo.setPrice(BlAmtConverUtil.toXmlString(itm.getPrice_ratio()));
			peInfo.setQuan(itm.getQuan() != null ? itm.getQuan().toString() : "");
			peInfo.setSrvuName(itm.getSrvu_name());
			peInfo.setOrDepName(itm.getName_dep_or());
			peInfo.setMpDepName(itm.getName_dep_mp());
			peInfo.setPatCaName(itm.getId_paticate_name());
			peInfo.setPriCaName(itm.getId_pripat_name());
			peInfo.setPeSrvId(itm.getId_pesrv());
			peInfoList.add(peInfo);
		}
		
		//出参赋值
		WsResultOpGetPay rlt = new WsResultOpGetPay();
		
		WsResultMsg rltMsg = new WsResultMsg();// 0成功，1失败
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltMsg.setMessage("成功");
		
		WsResultInfoOpGetNoPay rltInfo = new WsResultInfoOpGetNoPay();// resultinfo节点
		rltInfo.setAmt(BlAmtConverUtil.toXmlString(amt));
		rltInfo.setPeInfoList(peInfoList);
		
		rlt.setRltMsg(rltMsg);
		rlt.setRltInfo(rltInfo);
		
		return rlt;
	}

	/**
	 * 查询体检患者id_pat
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPePat(WsParamBillPatInfo paramInfo) throws BizException {
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getPatCode());
		condDto.setId_code(paramInfo.getSdCode());
		condDto.setCard_code(paramInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("体检自助支付待缴查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}
	
	/**
	 * 把预划价后产生的价格赋值给调入后的结果中（用id_orsrv进行匹配）
	 */
	private void setOepCallInPrice(BlOepChargeInputDTO[] oepChargeInputDTOs,
			BlOepChargePricingRltDTO[] outChargeDTOs ) {
		for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
			for (BlOepChargePricingRltDTO itmChild : outChargeDTOs) {
				
				if(StringUtil.isEmpty(itm.getId_orsrv())){
					if(itm.getId_srv().equals(itmChild.getId_srv()) && itm.getQuan().equals(itmChild.getQuan())){
						itm.setPrice_ratio(itmChild.getPrice_ratio());
						itm.setAmt_hp(itmChild.getAmt_hp());
						itm.setAmt(itmChild.getAmt());
						itm.setAmt_pat(itmChild.getAmt_pat());
						itm.setAmt_ratio(itmChild.getAmt_ratio());
						itm.setAmt_std(itmChild.getAmt_std());
						break;
					}
				}else if (itm.getId_orsrv().equals(itmChild.getId_orsrv())) {
					itm.setPrice_ratio(itmChild.getPrice_ratio());
					itm.setAmt_hp(itmChild.getAmt_hp());
					itm.setAmt(itmChild.getAmt());
					itm.setAmt_pat(itmChild.getAmt_pat());
					itm.setAmt_ratio(itmChild.getAmt_ratio());
					itm.setAmt_std(itmChild.getAmt_std());
					break;
				}
			}
		}
	}

	/**
	 * 获得预划价入参
	 */
	private BlOepChargePricingDTO[] getPreChargeInput(BlOepChargeInputDTO[] oepChargeInputDTOs) {
		List<BlOepChargePricingDTO> blOrderAppendDTOs = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
			BlOepChargePricingDTO blOrderAppendDTO = new BlOepChargePricingDTO();
			blOrderAppendDTO.setId_cgitmoep(itm.getId_cgitmoep());
			blOrderAppendDTO.setId_pat(itm.getId_pat());
			blOrderAppendDTO.setId_ent(itm.getId_ent());
			blOrderAppendDTO.setId_or(itm.getId_or());
			blOrderAppendDTO.setId_orsrv(itm.getId_orsrv());
			blOrderAppendDTO.setId_srv(itm.getId_srv());
			blOrderAppendDTO.setId_mm(itm.getId_mm());
			blOrderAppendDTO.setSrvu(itm.getSrvu());
			blOrderAppendDTO.setId_pripat(itm.getId_pripat());
			blOrderAppendDTO.setId_paticate(itm.getId_paticate());
			blOrderAppendDTO.setEu_direct(itm.getEu_direct());
			blOrderAppendDTO.setQuan(itm.getQuan());
			blOrderAppendDTO.setPrice(itm.getPrice_std());
			blOrderAppendDTO.setId_dep_or(itm.getId_dep_or());
			blOrderAppendDTO.setId_emp_or(itm.getId_emp_or());
			blOrderAppendDTO.setId_dep_mp(itm.getId_dep_mp());
			blOrderAppendDTO.setEu_srctp(itm.getEu_srctp());
			blOrderAppendDTO.setFg_mm(itm.getFg_mm());
			blOrderAppendDTO.setPrice_ratio(itm.getPrice_ratio());
			blOrderAppendDTO.setRatio_pripat(itm.getRatio_pripat());
			blOrderAppendDTO.setSrcfunc_des(itm.getSrcfunc_des());
			//blOrderAppendDTO.setOnly_code();//唯一码
			//blOrderAppendDTO.setBatch();//批次
			blOrderAppendDTO.setId_dep_wh(itm.getId_dep_wh());
			blOrderAppendDTO.setFg_addfee(itm.getFg_addfee());
			blOrderAppendDTO.setPecode(itm.getPe_code());
			blOrderAppendDTO.setDt_or(itm.getDt_or());
			blOrderAppendDTO.setFg_or(itm.getFg_or());
			//blOrderAppendDTO.setSv_or();//医嘱sv
			
			blOrderAppendDTOs.add(blOrderAppendDTO);
		}
		return blOrderAppendDTOs.toArray(new BlOepChargePricingDTO[0]);
	}

	/**
	 * 获得所有就诊信息集合
	 * 
	 * @throws BizException
	 */
	private List<WsResultEntInfo> getOepEntList(BlOepChargeInputDTO[] oepChargeInputDTOs, WsParamBillPatInfo paramInfo,String patId)
			throws BizException {
		// 调入明细按照就诊分组
		Map<String, List<BlOepChargeInputDTO>> map = new HashMap<String, List<BlOepChargeInputDTO>>();// key为就诊id,value为该就诊下的明细集合
		// 如果就诊次数为空的话查出该患者所有就诊信息，如果有值的话，查出该次就诊对应的信息
		if (!StringUtil.isEmpty(paramInfo.getEnTimes())) {
			String entId = this.findEntInfo(patId, paramInfo.getEnTimes());//获得患者该次就诊的就诊id
			List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
			for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
				if(entId.equals(itm.getId_ent())){
					itmList.add(itm);
				}
			}
			
			//有个特殊情况，一个患者有多条已签署的就诊记录，这个患者再挂个号，医生不接诊，入参里传入该次就诊，那么接口会报空指针
			if(ListUtil.isEmpty(itmList)){
				return new ArrayList<WsResultEntInfo>();
			}
			
			map.put(entId, itmList);
		} else {
			for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
				if (map.containsKey(itm.getId_ent())) {
					map.get(itm.getId_ent()).add(itm);
				} else {
					List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
					itmList.add(itm);
					map.put(itm.getId_ent(), itmList);
				}
			}
		}

		List<WsResultEntInfo> oepEntList = new ArrayList<WsResultEntInfo>();// 所有就诊信息集合
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		IOutpatientRService oepAttrService = ServiceFinder.find(IOutpatientRService.class);
		IDeptbRService depQryService = ServiceFinder.find(IDeptbRService.class);
		// 按就诊进行分组
		for (String itm : map.keySet()) {
			WsResultEntInfo entInfo = new WsResultEntInfo();
			PatiVisitDO[] entDO = entService.findByAttrValString("Id_ent", itm);// 就诊DO
			if (ArrayUtil.isEmpty(entDO)) {
				throw new BizException("就诊信息不存在");
			}
			OutpatientDO[] opAttrDO = oepAttrService.findByAttrValString("Id_ent", itm);// 门诊属性DO
			List<BlOepChargeInputDTO> entItmList = map.get(itm);// 一次就诊下所有明细
			FDouble amtRatio = FDouble.ZERO_DBL;// 本次就诊总费用
			for (BlOepChargeInputDTO itmChild : entItmList) {
				amtRatio = amtRatio.add(itmChild.getAmt_ratio());
			}

			entInfo.setEntCode(entDO[0].getCode());
			entInfo.setEnTimes(opAttrDO[0].getTimes_op().toString());
			entInfo.setEntTp(IEnDictCodeConst.SD_ENTP_OUTPATIENT);
			entInfo.setPatType(ListUtil.isEmpty(entItmList) ? "" : entItmList.get(0).getId_paticate_name());// 患者类型
			entInfo.setEntAmout(BlAmtConverUtil.toXmlString(amtRatio));// 本次就诊总费用
			entInfo.setEntTime(entDO[0].getDt_acpt().toString());// 接诊时间
			entInfo.setNote("");

			// 按医疗单进行分组（药品的走处方，非药品的按照医嘱走）
			Map<String, List<BlOepChargeInputDTO>> applyMap = new HashMap<String, List<BlOepChargeInputDTO>>();// key为医疗单编码(药品的医疗单编码为就诊编码-处方号，其他为医疗单编码)，value为该医疗单下的项目集合
			for (BlOepChargeInputDTO itmChild2 : entItmList) {
				if (!StringUtil.isEmpty(itmChild2.getId_pres())) {
					if (applyMap.containsKey(entDO[0].getCode() + "-" + itmChild2.getCode_bill())) {
						applyMap.get(entDO[0].getCode() + "-" + itmChild2.getCode_bill()).add(itmChild2);
					} else {
						List<BlOepChargeInputDTO> applyItmList = new ArrayList<BlOepChargeInputDTO>();
						applyItmList.add(itmChild2);
						applyMap.put(entDO[0].getCode() + "-" + itmChild2.getCode_bill(), applyItmList);
					}
				} else {
					if (applyMap.containsKey(itmChild2.getCode_bill())) {
						applyMap.get(itmChild2.getCode_bill()).add(itmChild2);
					} else {
						List<BlOepChargeInputDTO> applyItmList = new ArrayList<BlOepChargeInputDTO>();
						applyItmList.add(itmChild2);
						applyMap.put(itmChild2.getCode_bill(), applyItmList);
					}
				}
			}

			// 给医疗单赋值
			List<WsResultPresInfo> applyList = new ArrayList<WsResultPresInfo>();// 医疗单集合
			ICiorderMDORService ciOrderRService = ServiceFinder.find(ICiorderMDORService.class);
			for (String itmChild3 : applyMap.keySet()) {
				// 一个医疗单下所有明细
				List<BlOepChargeInputDTO> applyItmList = applyMap.get(itmChild3);
				
				//获取医嘱信息list，并且去重
				List<BlOepChargeInputDTO> orInfoList = new ArrayList();
				Set<String> set = new HashSet();
				for (BlOepChargeInputDTO itm0 : applyItmList) {
					if(set.add(itm0.getId_or())){
						orInfoList.add(itm0);
					}
				}
				
				String orId = "";
				String orName = "";
				String dtEffe = "";
				for (int i = 0; i < orInfoList.size(); i++) {
					if(i == orInfoList.size() - 1){
						if(orInfoList.get(i).getId_or() != null){
							orId = orId + orInfoList.get(i).getId_or();
						}
						if(orInfoList.get(i).getName_or() != null){
							orName = orName + orInfoList.get(i).getName_or();
						}
						if(orInfoList.get(i).getDt_or() != null){
							dtEffe = dtEffe + orInfoList.get(i).getDt_or().toString();
						}
					}else{
						if(orInfoList.get(i).getId_or() != null){
							orId = orId + orInfoList.get(i).getId_or() + "|";
						}
						if(orInfoList.get(i).getName_or() != null){
							orName = orName + orInfoList.get(i).getName_or() + "|";
						}
						if(orInfoList.get(i).getDt_or() != null){
							dtEffe = dtEffe + orInfoList.get(i).getDt_or().toString() + "|";
						}
					}
				}

				// 获得开立科室和开立医生
				DeptBDO depDO = depQryService.findById(applyItmList.get(0).getId_dep_or());
				PsnDocDO psnDocDO = BlBaseInfoUtils.getPsnDocDO(applyItmList.get(0).getId_emp_or());

				WsResultPresInfo presInfo = new WsResultPresInfo();
				presInfo.setApplyCode(itmChild3);
				presInfo.setApplyTpCode(applyItmList.get(0) == null ? "" : (applyItmList.get(0).getSd_srvtp() == null ? "" : applyItmList.get(0).getSd_srvtp().substring(0,2)));
				presInfo.setOrId(orId);//医嘱主键
				presInfo.setOrName(orName);//医嘱名称
				presInfo.setDtEffe(dtEffe);//医嘱生效日期
				presInfo.setDeptId(depDO == null ? "" : depDO.getCode());
				presInfo.setDeptName(depDO == null ? "" : depDO.getName());
				presInfo.setDoctorId(psnDocDO == null ? "" : psnDocDO.getCode());
				presInfo.setDoctorName(psnDocDO == null ? "" : psnDocDO.getName());
				FDouble applyAmtRatio = FDouble.ZERO_DBL;// 一个医疗单总费用
				for (BlOepChargeInputDTO itmChild4 : applyItmList) {
					applyAmtRatio = applyAmtRatio.add(itmChild4.getAmt_ratio());
				}
				presInfo.setPresAmt(BlAmtConverUtil.toXmlString(applyAmtRatio));

				List<WsResultItem> outApplyItmList = new ArrayList<WsResultItem>();
				IMeterialMDORService bdMMService = ServiceFinder.find(IMeterialMDORService.class);
				// 给医疗单明细赋值
				for (BlOepChargeInputDTO itmChild5 : applyItmList) {
					WsResultItem applyItm = new WsResultItem();
					applyItm.setSrvCode(itmChild5.getCode_srv());
					applyItm.setSrvName(itmChild5.getName_srv());
					applyItm.setUnit(itmChild5.getSrvu_name());
					if (itmChild5.getFg_mm().booleanValue()) {
						MeterialDO bdMMDO = bdMMService.findById(itmChild5.getId_mm());
						applyItm.setSepcification(bdMMDO.getSpec());
					} else {
						applyItm.setSepcification("");// 规格
					}
					applyItm.setPrice(BlAmtConverUtil.toXmlString(itmChild5.getPrice_ratio()));
					applyItm.setQuan(itmChild5.getQuan().toString());
					// applyItm.setInccacode(itmChild5);//账单项编码
					// applyItm.setInccaItm();//账单项名称
					applyItm.setDeptId((depQryService.findById(itmChild5.getId_dep_mp())).getCode());// 执行科室编码
					applyItm.setDeptName(itmChild5.getName_dep_mp());
					// applyItm.setMpStaus();//执行状态 N 未执行;Y 已执行
					// applyItm.setStStaus();//结算状态 N未结算；Y已结算
					// applyItm.setDeptLocation();//执行位置
					applyItm.setAmt(BlAmtConverUtil.toXmlString(itmChild5.getAmt_ratio()));
					if(itmChild5.getDt_or() != null){
						applyItm.setOrTime(itmChild5.getDt_or().toString());// 开单时间
					}
					
					//给医嘱明细增加医嘱信息
					applyItm.setOrId(itmChild5.getId_or());//医嘱主键
					applyItm.setOrName(itmChild5.getName_or());

					outApplyItmList.add(applyItm);
				}

				presInfo.setPresItem(outApplyItmList);
				applyList.add(presInfo);
			}
			entInfo.setEntPresList(applyList);
			oepEntList.add(entInfo);
		}
		return oepEntList;
	}

	/**
	 * 查询患者id_pat
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(WsParamGetCostBill param) throws BizException {
		WsParamBillPatInfo paramInfo = param.getPatInfo();// 入参patinfo节点
		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getPatCode());
		condDto.setId_code(paramInfo.getSdCode());
		condDto.setCard_code(paramInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊自助支付待缴查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO().getId_pat();
	}

	/**
	 * 根据人员id和就诊次数查询就诊信息
	 * 
	 * @param patId
	 * @param enTimes
	 * @return
	 * @throws BizException
	 */
	private String findEntInfo(String patId, String enTimes) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ent.id_ent from  ");
		sql.append(" en_ent ent ");
		sql.append(" INNER join en_ent_op entop on ent.id_ent = entop.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" and entop.times_op = ? ");

		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(enTimes);

		String entId = (String) new DAFacade().execQuery(sql.toString(), param,new ColumnHandler());
 
		if (StringUtil.isEmpty(entId)) {
			throw new BizException("门诊自助支付待缴查询：未查询患者该次就诊数据");
		}

		return entId;
	}

	/**
	 * 根据患者id查询到患者当前的就诊次数
	 * 
	 * @return
	 * @throws DAException
	 */
	private String getTimesOp(String id_pat) throws BizException {
		if (StringUtil.isEmpty(id_pat)) {
			throw new BizException("患者id为空");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select entop.times_op ");
		sql.append(" from en_ent ent ");
		sql.append(" inner join en_ent_op entop ");
		sql.append(" on ent.id_ent = entop.id_ent ");
		sql.append(" where ent.id_pat = ? ");
		sql.append(" order by entop.dt_entry desc ");

		SqlParam param = new SqlParam();
		param.addParam(id_pat);

		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(OutpatientDO.class));

		if (list == null || list.size() == 0) {
			throw new BizException("门诊自助支付待缴查询：未查询到该患者的当前就诊次数");
		}
		return list.get(0).getTimes_op().toString();
	}
}
