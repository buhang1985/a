package iih.ei.std.s.v1.bp.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.CollectionUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.comm.IBlFlowKeyConst;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.params.BlParams;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.bl.st.i.IBlOepChargeQryService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.bl.oppricingdto.d.EntInfo;
import iih.ei.std.d.v1.bl.oppricingdto.d.HpInfo;
import iih.ei.std.d.v1.bl.oppricingdto.d.OpPricingParamDTO;
import iih.ei.std.d.v1.bl.oppricingdto.d.OpPricingResultDTO;
import iih.ei.std.d.v1.bl.oppricingdto.d.PresInfo;
import iih.ei.std.d.v1.bl.oppricingdto.d.PresItm;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfOutParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 门诊划价(带事务)
 * 
 * @author shaokx
 * @date: 2019.10.12
 */
public class OpPricingBP extends IIHServiceBaseBP<OpPricingParamDTO, OpPricingResultDTO> {

	@Override
	protected void checkParam(OpPricingParamDTO param) throws BizException {

		if (param == null) {
			throw new BizException("入参为空");
		}

		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("入参就诊类型为空");
		}

		if (!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())) {
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("入参关键信息全为空:患者编码,就诊卡号,身份证号");
		}

		FArrayList arr = param.getEntinfo();

		if (CollectionUtils.isEmpty(arr)) {
			throw new BizException("入参就诊信息为空");
		}

		for (Object itm : arr) {
			EntInfo entinfo = (EntInfo) itm;
			if (StringUtil.isEmpty(entinfo.getCode_ent())) {
				throw new BizException("入参就诊编码为空");
			}
			
			FArrayList arr1 = entinfo.getPresinfo();
			if (CollectionUtils.isEmpty(arr1)) {
				throw new BizException("入参就诊申请单信息为空");
			}
			
			for (Object itm1 : arr1) {
				PresInfo presInfo = (PresInfo) itm1;
				if (StringUtil.isEmpty(presInfo.getCode_apply())) {
					throw new BizException("入参就诊申请单明细为空");
				}
			}
		}
		
		if(!StringUtil.isEmpty(param.getCode_opera())){
			// 设置人员上下文
			PsnDocDO psndocDO = BlAmtConverUtil.getPsnInfo(param.getCode_opera());
			if (psndocDO == null) {
				throw new BizException("门诊自助划价:未查询到人员信息");
			}
			Context.get().setStuffId(psndocDO.getId_psndoc());
		}

	}

	@Override
	protected OpPricingResultDTO process(OpPricingParamDTO param) throws BizException {

		Integer callInDays = BlParams.BLSTOEP0004();//调入天数
		if(callInDays == null){
			throw new BizException("请维护参数BLSTOEP0004的值");
		}
		FDate endDate = AppUtils.getServerDate();//获取服务器时间
		FDate startDate = endDate.getDateBefore(callInDays);//开始时间，按照自然天算
//		FDate startDate = new FDate(prepayInfo.getStartDate());
//		FDate endDate = new FDate(prepayInfo.getEndDate());
		// 查询患者信息
		PatDO patDO = this.findPat(param);

		IBlOepChargeCmdService oepChargeCmdService = ServiceFinder.find(IBlOepChargeCmdService.class);// 划价服务
		// 门诊调入(默认时间费用)接口，返回数组应该是按照明细级别的
		IBlOepChargeQryService oepChargeQryService = ServiceFinder.find(IBlOepChargeQryService.class);
		//BlOepChargeInputDTO[] oepChargeInputDTOs = oepChargeQryService.findOepCostInfoPeriod(patDO.getId_pat(), startDate, endDate);
		BlOepChargeCommonCondDTO condDto = new BlOepChargeCommonCondDTO();
		condDto.setId_pat(patDO.getId_pat());
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

		// 获得根据入参就诊信息和医疗单编码而过滤后的明细集合
		List<BlOepChargeInputDTO> inputFilterItm = this.getFilterList(oepChargeInputDTOs, param);

		//判断是否存在挂起挂号数据
		boolean isSusp = this.ifSuspData(inputFilterItm);

		if(isSusp){
			return this.suspPricing(inputFilterItm, param, patDO);
		}
		
		
		// 组织门诊划价接口入参
		BlOepChargePricingDTO[] dtos = this.getOepPricingInfo(param, patDO.getId_pat(), inputFilterItm);// 明细信息
		BlOepChargeSetDTO chargeSet = this.getOepSetInfo(param, patDO);// 门诊收费配置信息

		// 划价之前判断一下是否重复划价，如果重复划价，就调用取消划价接口取消划价
		this.isRepeatPricing(dtos, oepChargeCmdService);
		
		//设置划价医保相关数据
		HPDO hpDO = null;
		if(!StringUtil.isEmpty(param.getCode_hp())){
			
			// 查询医保关联患者分类数据
			hpDO = BlAmtConverUtil.queryHpDO(param.getCode_hp());
			
			// 查询医保患者分类信息
			PiPatCaDO[] patCaDos = BlAmtConverUtil.queryPatCa(hpDO.getId_hp());
			
			chargeSet.setId_hp(hpDO.getId_hp());
			for (PiPatCaDO piPatCaDO : patCaDos) {
				if(piPatCaDO.getId_patca().equals(patDO.getId_paticate())){
					chargeSet.setId_patca(piPatCaDO.getId_patca());
					break;
				}
			}
			if(StringUtil.isEmpty(chargeSet.getId_patca())){
				chargeSet.setId_patca(patCaDos[0].getId_patca());
			}
		}		
		
		// 门诊划价接口
		BlOepChargePricingRltDTO[] oepChargePricingRltDTOs = oepChargeCmdService.pricing(dtos, chargeSet);

		// 医保处理
		MiOepChargePricingSelfOutParamDTO hpData = null;
		if (hpDO != null) {
			hpData = this.dealHp(hpDO.getId_hp(), patDO.getId_pat(), param);
		}
		
		// 把划价后产生的价格赋值给过滤后的明细集合（用id_orsrv进行匹配）
		this.setFilterItmPrice(inputFilterItm, oepChargePricingRltDTOs);

		// 获得所有就诊信息集合
		FArrayList oepEntList = this.getOepEntList(inputFilterItm.toArray(new BlOepChargeInputDTO[] {}));// OEPEntList节点

		OpPricingResultDTO outParam1 = new OpPricingResultDTO();

		outParam1.setPayno(oepChargePricingRltDTOs[0].getId_stoep());
		outParam1.setEntinfo(oepEntList);

		if(hpData != null){
			HpInfo hpInfo = new HpInfo();
			hpInfo.setHpregisterinfo(hpData.getStr_hpregister());
			hpInfo.setHpdetailuploadinfo(hpData.getStr_detailupload());
			hpInfo.setHpprestinfo(hpData.getStr_hpprest());
			FArrayList arr = new FArrayList();
			arr.add(hpInfo);
			outParam1.setHpinfo(arr);
		}


		return outParam1;
	}
	
	/**
	 * 划价之前判断一下是否重复划价，如果重复划价，就调用取消划价接口取消划价
	 * @param dtos
	 * @param oepChargeCmdService
	 * @throws BizException
	 */
	private void isRepeatPricing(BlOepChargePricingDTO[] dtos, IBlOepChargeCmdService oepChargeCmdService)
			throws BizException {
		// 分组记账与非记账数据
		List<String> chargedList = new ArrayList<String>();
		List<BlOepChargePricingDTO> unChargeList = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepChargePricingDTO pricingDto : dtos) {
			if (StringUtil.isEmpty(pricingDto.getId_cgitmoep())) {
				unChargeList.add(pricingDto);
			} else {
				chargedList.add(pricingDto.getId_cgitmoep());
			}
		}

		// 非记账数据调用划价逻辑
		if (unChargeList.size() > 0) {
			List<String> orsrvList = new ArrayList<String>();
			for (BlOepChargePricingDTO dto : unChargeList) {
				if (!StringUtil.isEmpty(dto.getId_orsrv())) {
					orsrvList.add(dto.getId_orsrv());
				}
			}

			if (orsrvList.size() == 0)
				return;

			String sql = "select id_stoep from bl_cg_itm_oep where "
					+ SqlUtils.getInSqlByParamValues("id_orsrv", orsrvList.toArray(new String[0]));
			SqlParam par = new SqlParam();
			for (String orsrvId : orsrvList) {
				par.addParam(orsrvId);
			}

			DAFacade daf = new DAFacade();
			// Integer cnt = (Integer) daf.execQuery(sql, par, new
			// ColumnHandler());
			List<String> stOepList = (List<String>) daf.execQuery(sql, par, new ColumnListHandler());

			if (!ListUtil.isEmpty(stOepList)) {
				// 取消划价
				oepChargeCmdService.cancelPricing(stOepList.get(0));
			}
		}
	}

	/**
	 * 把划价后产生的价格赋值给过滤后的明细集合（用id_orsrv进行匹配）
	 * 
	 * @param inputFilterItm
	 * @param oepChargePricingRltDTOs
	 */
	private void setFilterItmPrice(List<BlOepChargeInputDTO> inputFilterItm,
			BlOepChargePricingRltDTO[] oepChargePricingRltDTOs) {
		for (BlOepChargeInputDTO itm : inputFilterItm) {
			for (BlOepChargePricingRltDTO itmChild : oepChargePricingRltDTOs) {
				if(StringUtil.isEmpty(itm.getId_orsrv())){
					if(itm.getId_srv().equals(itmChild.getId_srv()) && itm.getQuan().equals(itmChild.getQuan())){
						itm.setPrice_ratio(itmChild.getPrice_ratio());
						itm.setAmt_hp(itmChild.getAmt_hp());
						itm.setAmt(itmChild.getAmt());
						itm.setAmt_pat(itmChild.getAmt_pat());
						itm.setAmt_ratio(itmChild.getAmt_ratio());
						itm.setAmt_std(itmChild.getAmt_std());
						itm.setId_cgitmoep(itmChild.getId_cgitmoep());
						break;
					}
				}else if (itm.getId_orsrv().equals(itmChild.getId_orsrv())) {
					itm.setPrice_ratio(itmChild.getPrice_ratio());
					itm.setAmt_hp(itmChild.getAmt_hp());
					itm.setAmt(itmChild.getAmt());
					itm.setAmt_pat(itmChild.getAmt_pat());
					itm.setAmt_ratio(itmChild.getAmt_ratio());
					itm.setAmt_std(itmChild.getAmt_std());
					itm.setQuan(itmChild.getQuan());
					itm.setId_cgitmoep(itmChild.getId_cgitmoep());
					break;
				}
			}
		}
	}

	/**
	 * 获得所有就诊信息集合
	 * 
	 * @throws BizException
	 */
	private FArrayList getOepEntList(BlOepChargeInputDTO[] oepChargeInputDTOs) throws BizException {
		// 调入明细按照就诊分组
		Map<String, List<BlOepChargeInputDTO>> map = new HashMap<String, List<BlOepChargeInputDTO>>();// key为就诊id,value为该就诊下的明细集合
		for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
			if (map.containsKey(itm.getId_ent())) {
				map.get(itm.getId_ent()).add(itm);
			} else {
				List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
				itmList.add(itm);
				map.put(itm.getId_ent(), itmList);
			}
		}

		FArrayList oepEntList = new FArrayList();// 所有就诊信息集合
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		IOutpatientRService oepAttrService = ServiceFinder.find(IOutpatientRService.class);
		IDeptbRService depQryService = ServiceFinder.find(IDeptbRService.class);
		// 按就诊进行分组
		for (String itm : map.keySet()) {
			EntInfo entInfo = new EntInfo();
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

			entInfo.setCode_ent(entDO[0].getCode());
			entInfo.setTimes_op(opAttrDO[0].getTimes_op().toString());
			entInfo.setCode_enttp(IEnDictCodeConst.SD_ENTP_OUTPATIENT);
			entInfo.setName_paticate(entItmList.get(0).getId_paticate_name());// 患者类型
			entInfo.setAmt_ent(BlAmtConverUtil.toXmlString(amtRatio));// 本次就诊总费用
			entInfo.setDt_acpt(entDO[0].getDt_acpt().toString());// 接诊时间
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
			FArrayList applyList = new FArrayList();// 医疗单集合
			ICiorderMDORService ciOrderRService = ServiceFinder.find(ICiorderMDORService.class);
			for (String itmChild3 : applyMap.keySet()) {
				// 一个医疗单下所有明细
				List<BlOepChargeInputDTO> applyItmList = applyMap.get(itmChild3);
				// 获取医嘱类别
				CiOrderDO ciOrderDO = ciOrderRService.findById(applyItmList.get(0).getId_or());
				// 获得开立科室和开立医生
				DeptBDO depDO = depQryService.findById(applyItmList.get(0).getId_dep_or());
				PsnDocDO psnDocDO = BlAmtConverUtil.getPsnDocDO(applyItmList.get(0).getId_emp_or());

				PresInfo presInfo = new PresInfo();
				presInfo.setCode_apply(itmChild3);
				presInfo.setSd_srvtp(ciOrderDO.getSd_srvtp().substring(0, 2));
				presInfo.setCode_dep_or(depDO.getCode());
				presInfo.setName_dep_or(depDO.getName());
				presInfo.setCode_emp_or(psnDocDO.getCode());
				presInfo.setName_emp_or(psnDocDO.getName());
				FDouble applyAmtRatio = FDouble.ZERO_DBL;// 一个医疗单总费用
				for (BlOepChargeInputDTO itmChild4 : applyItmList) {
					applyAmtRatio = applyAmtRatio.add(itmChild4.getAmt_ratio());
				}
				presInfo.setAmt_pres(BlAmtConverUtil.toXmlString(applyAmtRatio));

				FArrayList outApplyItmList = new FArrayList();
				IMeterialMDORService bdMMService = ServiceFinder.find(IMeterialMDORService.class);
				// 给医疗单明细赋值
				for (BlOepChargeInputDTO itmChild5 : applyItmList) {
					PresItm applyItm = new PresItm();
					applyItm.setCode_cg(itmChild5.getId_cgitmoep());//记账流水号取子表的主键
					applyItm.setCode_srv(itmChild5.getCode_srv());
					applyItm.setName_srv(itmChild5.getName_srv());
					applyItm.setName_srvu(itmChild5.getSrvu_name());
					if (itmChild5.getFg_mm().booleanValue()) {
						MeterialDO bdMMDO = bdMMService.findById(itmChild5.getId_mm());
						applyItm.setSpec(bdMMDO.getSpec());
					} else {
						applyItm.setSpec("");// 规格
					}
					applyItm.setPrice(BlAmtConverUtil.toXmlString(itmChild5.getPrice_ratio()));
					applyItm.setQuan(itmChild5.getQuan().toString());
					applyItm.setCode_inccaitm(itmChild5.getCode_inccaitm());//账单项编码
					applyItm.setName_inccaitm(itmChild5.getName_inccaitm());//账单项名称
					applyItm.setCode_dep_mp((depQryService.findById(itmChild5.getId_dep_mp())).getCode());// 执行科室编码
					applyItm.setName_dep_mp(itmChild5.getName_dep_mp());
					// applyItm.setMpStaus();//执行状态 N 未执行;Y 已执行
					// applyItm.setStStaus();//结算状态 N未结算；Y已结算
					// applyItm.setDeptLocation();//执行位置
					applyItm.setAmt(BlAmtConverUtil.toXmlString(itmChild5.getAmt_ratio()));
					//applyItm.setDt_or(itmChild5.getDt_or().toString());// 开单时间
					if(itmChild5.getDt_or() != null){
						applyItm.setDt_or(itmChild5.getDt_or().toString());// 开单时间
					}
					
					outApplyItmList.add(applyItm);
				}

				presInfo.setPresitm(outApplyItmList);
				applyList.add(presInfo);
			}
			entInfo.setPresinfo(applyList);
			oepEntList.add(entInfo);
		}
		return oepEntList;
	}

	/**
	 * 门诊划价入参-门诊收费配置信息
	 * 
	 * @param prepayInfo
	 * @param patId
	 * @return
	 * @throws BizException 
	 */
	private BlOepChargeSetDTO getOepSetInfo(OpPricingParamDTO param, PatDO patDO) throws BizException {
		BlOepChargeSetDTO chargeSet = new BlOepChargeSetDTO();
		chargeSet.setId_pat(patDO.getId_pat());
		chargeSet.setFg_calprice(FBoolean.TRUE);
		
		IPatientcategoryRService patcaService = ServiceFinder.find(IPatientcategoryRService.class);
		if(StringUtil.isEmpty(param.getCode_patca())){
			//入参患者分类编码为空时，首先取患者分类表中默认标志为Y的数据，如果取不到，则取患者表中的患者分类
			PiPatCaDO[] patCaDOs = patcaService.find(" fg_def = 'Y' ", "", FBoolean.FALSE);
			if(!ArrayUtil.isEmpty(patCaDOs)){
				chargeSet.setId_patca(patCaDOs[0].getId_patca());
			}else{
				chargeSet.setId_patca(patDO.getId_paticate());
			}
		}else{
			PiPatCaDO[] patCaDOs = patcaService.findByAttrValString(PiPatCaDO.CODE, param.getCode_patca());
			if(ArrayUtil.isEmpty(patCaDOs)){
				throw new BizException("根据患者分类编码没有查到对应数据");
			}
			chargeSet.setId_patca(patCaDOs[0].getId_patca());
		}
		
		return chargeSet;
	}

	/**
	 * 门诊划价入参-明细信息
	 * 
	 * @param prepayInfo
	 * @param patId
	 * @param inputFilterItm
	 * @return
	 */
	private BlOepChargePricingDTO[] getOepPricingInfo(OpPricingParamDTO param, String patId,
			List<BlOepChargeInputDTO> inputFilterItm) {
		List<BlOepChargePricingDTO> dtos = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepChargeInputDTO itm : inputFilterItm) {
			BlOepChargePricingDTO oepPricingDTO = new BlOepChargePricingDTO();
			oepPricingDTO.setId_cgitmoep(itm.getId_cgitmoep());
			oepPricingDTO.setId_pat(patId);
			oepPricingDTO.setId_ent(itm.getId_ent());
			oepPricingDTO.setId_or(itm.getId_or());
			oepPricingDTO.setId_orsrv(itm.getId_orsrv());
			oepPricingDTO.setId_srv(itm.getId_srv());
			oepPricingDTO.setId_mm(itm.getId_mm());
			oepPricingDTO.setSrvu(itm.getSrvu());
			oepPricingDTO.setId_pripat(itm.getId_pripat());
			// oepPricingDTO.setEu_direct(itm.getEu_direct());
			oepPricingDTO.setQuan(itm.getQuan());
			oepPricingDTO.setPrice(itm.getPrice_std());
			oepPricingDTO.setId_dep_or(itm.getId_dep_or());
			oepPricingDTO.setId_emp_or(itm.getId_emp_or());
			oepPricingDTO.setId_dep_mp(itm.getId_dep_mp());
			oepPricingDTO.setEu_srctp(itm.getEu_srctp());
			oepPricingDTO.setFg_mm(itm.getFg_mm());
			oepPricingDTO.setPrice_ratio(itm.getPrice_ratio());
			oepPricingDTO.setRatio_pripat(itm.getRatio_pripat());
			// oepPricingDTO.setSrcfunc_des(itm.getSrcfunc_des());
			oepPricingDTO.setPecode(itm.getPe_code());
			oepPricingDTO.setDt_or(itm.getDt_or());
			// oepPricingDTO.setOnly_code();// 唯一码
			// oepPricingDTO.setBatch();// 批次
			// oepPricingDTO.setId_dep_wh(StringUtil.isEmpty(itm.getId_mm()) ?
			// "" : itm.getId_dep_mp());// 执行药房
			oepPricingDTO.setId_dep_wh(itm.getId_dep_wh());
			// oepPricingDTO.setFg_addfee();// 补费标识
			dtos.add(oepPricingDTO);
		}

		return dtos.toArray(new BlOepChargePricingDTO[dtos.size()]);
	}

	/**
	 * 获得根据入参就诊信息和医疗单编码而过滤后的明细集合
	 * 
	 * @param oepChargeInputDTOs
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private List<BlOepChargeInputDTO> getFilterList(BlOepChargeInputDTO[] oepChargeInputDTOs,
			OpPricingParamDTO param) throws BizException {
		// 按照就诊分组
		Map<String, List<BlOepChargeInputDTO>> map = new HashMap<String, List<BlOepChargeInputDTO>>();// key为就诊id,value为该就诊下的明细集合
		for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
			if (map.containsKey(itm.getId_ent())) {
				map.get(itm.getId_ent()).add(itm);
			} else {
				List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
				itmList.add(itm);
				map.put(itm.getId_ent(), itmList);
			}
		}
		// 根据入参就诊信息和医疗单(药品为处方，其他为医嘱)过滤数据获得本次明细信息
		FArrayList entInputInfo = param.getEntinfo();// 入参就诊信息
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		List<BlOepChargeInputDTO> inputAllEntItm = new ArrayList<BlOepChargeInputDTO>();// 入参就诊信息下的所有明细
		List<String> inputAllApplyCode = new ArrayList<String>();// 所有医疗单编码（其中药品的医疗单只获取去掉就诊编码的处方单号）
		List<BlOepChargeInputDTO> inputFilterItm = new ArrayList<BlOepChargeInputDTO>();// 根据入参最终过滤出明细
		// 获得入参就诊信息下的所有明细
		for (Object itm : entInputInfo) {
			EntInfo entinfo = (EntInfo) itm;
			// 就诊编码转就诊id
			String entId = (entService.findByAttrValString("Code", entinfo.getCode_ent()))[0].getId_ent();
			if (map.containsKey(entId)) {
				inputAllEntItm.addAll(map.get(entId));
			}
		}
		// 获得所有医疗单编码（其中药品的医疗单只获取去掉就诊编码的处方单号）
		for (Object itm : entInputInfo) {
			EntInfo entinfo = (EntInfo) itm;
			FArrayList applyItm = entinfo.getPresinfo();
			for (Object itmChild : applyItm) {
				PresInfo presinfo = (PresInfo) itmChild;
				if (presinfo.getCode_apply().contains("-")) {
					String presCode = (presinfo.getCode_apply().split("-"))[1];
					if (!inputAllApplyCode.contains(presCode)) {
						inputAllApplyCode.add(presCode);
					}
				} else {
					inputAllApplyCode.add(presinfo.getCode_apply());
				}
			}
		}

		// 根据所有医疗单编码过滤明细
		for (String itm : inputAllApplyCode) {
			for (BlOepChargeInputDTO itmChild : inputAllEntItm) {
				if (itm.equals(itmChild.getCode_bill())) {
					inputFilterItm.add(itmChild);
				}
			}
		}
		return inputFilterItm;
	}

	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(OpPricingParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
	}

	/**
	 * 医保处理
	 * @param param
	 * @return 医保处理结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MiOepChargePricingSelfOutParamDTO dealHp(String hpId, String patId, OpPricingParamDTO param) throws BizException {
	
		MiOepChargePricingSelfInParamDTO inParam = new MiOepChargePricingSelfInParamDTO();
		inParam.setId_pat(patId);
		inParam.setStr_hpcard(((HpInfo)param.getHpinfo().get(0)).getHpcardinfo());
		
		List<BlCgItmOepDO> cgList = (List<BlCgItmOepDO>)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_CG);
		BlStOepDO stDO = (BlStOepDO)Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_PRICING_ST);
		
		FArrayList cgFList = new FArrayList();
		FArrayList stFList = new FArrayList();		
		cgFList.addAll(cgList);
		stFList.add(stDO);

		inParam.setCgtiminfo(cgFList);
		inParam.setStinfo(stFList);
		
		InsureContext insContext = new InsureContext();
		insContext.setIdHp(hpId);
		
		InsureFacade insFacade = new InsureFacade(insContext);
		ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> rlt = insFacade.oepPricingSelf(inParam);
		
		if(FBoolean.FALSE.equals(rlt.getFg_deal()))
			return null;
		
		if(FBoolean.FALSE.equals(rlt.getFg_HpSuccess())){
			throw new BizException("医保划价处理失败："+ rlt.getErrorMsg());
		}
		
		return rlt.getData();
	}

	/**
	 * 判断是否挂起挂号数据
	 * @param inputFilterItm
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private boolean ifSuspData(List<BlOepChargeInputDTO> inputFilterItm) throws BizException {
		
		List<String> cgIdList = new ArrayList<String>();
		for (BlOepChargeInputDTO inputDto : inputFilterItm) {
			
			if(!StringUtil.isEmpty(inputDto.getId_cgitmoep())){
				cgIdList.add(inputDto.getId_cgitmoep());
			}
		}
		
		if(cgIdList.size() == 0)
			return false;
		
		List<BlCgItmOepDO> itmList = (List<BlCgItmOepDO>)new DAFacade().findByPKs(BlCgItmOepDO.class, cgIdList.toArray(new String[0]));
		for (BlCgItmOepDO blCgItmOepDO : itmList) {
			
			if(FBoolean.TRUE.equals(blCgItmOepDO.getFg_susp()) 
					&& !FBoolean.TRUE.equals(blCgItmOepDO.getFg_pricinginsertcg())
					&& !FBoolean.TRUE.equals(blCgItmOepDO.getFg_acc())
					&& blCgItmOepDO.getEu_srctp() == 1){
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 挂起划价
	 * @param inputFilterItm
	 * @return
	 * @throws BizException
	 */
	private OpPricingResultDTO suspPricing(List<BlOepChargeInputDTO> inputFilterItm, OpPricingParamDTO param, PatDO patDO) throws BizException {
		
		HPDO hpDO = null;
		if(!StringUtil.isEmpty(param.getCode_hp())){
			// 查询医保关联患者分类数据
			hpDO =  BlAmtConverUtil.queryHpDO(param.getCode_hp());
		}
		
		MiOepChargePricingSelfOutParamDTO hpData = null;
		if (hpDO != null) {
			hpData = this.dealHp(hpDO.getId_hp(), patDO.getId_pat(), param);
		}
		
		List<String> cgIdList = new ArrayList<String>();
		for (BlOepChargeInputDTO inputDto : inputFilterItm) {
			cgIdList.add(inputDto.getId_cgitmoep());
		}
		
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> itmList = (List<BlCgItmOepDO>)new DAFacade().findByPKs(BlCgItmOepDO.class, cgIdList.toArray(new String[0]));
		
		// 获得所有就诊信息集合
		//List<WsResultEntInfo> oepEntList = this.getOepEntList(inputFilterItm.toArray(new BlOepChargeInputDTO[] {}));// OEPEntList节点

		OpPricingResultDTO outParam = new OpPricingResultDTO();
		outParam.setPayno(itmList.get(0).getId_stoep());
		
		if(hpData != null){
			HpInfo hpInfo = new HpInfo();
			hpInfo.setHpregisterinfo(hpData.getStr_hpregister());
			hpInfo.setHpdetailuploadinfo(hpData.getStr_detailupload());
			hpInfo.setHpprestinfo(hpData.getStr_hpprest());
			FArrayList arr = new FArrayList();
			arr.add(hpInfo);
			outParam.setHpinfo(arr);
		}
		
		return outParam;
	}
}
