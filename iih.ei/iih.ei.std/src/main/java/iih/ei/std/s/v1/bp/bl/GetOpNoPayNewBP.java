package iih.ei.std.s.v1.bp.bl;

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
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeCommonCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.bl.st.i.IBlOepChargeQryService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ei.std.d.v1.bl.opnopaydto.d.EntInfo;
import iih.ei.std.d.v1.bl.opnopaydto.d.OpNoPayParamDTO;
import iih.ei.std.d.v1.bl.opnopaydto.d.OpNoPayResultDTO;
import iih.ei.std.d.v1.bl.opnopaydto.d.PresInfo;
import iih.ei.std.d.v1.bl.opnopaydto.d.PresItm;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
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

/***
 * 门诊待缴费查询
 * 
 * @author shaokx
 * @date: 2019.10.12
 */
public class GetOpNoPayNewBP extends IIHServiceBaseBP<OpNoPayParamDTO, OpNoPayResultDTO>{

	@Override
	protected void checkParam(OpNoPayParamDTO param) throws BizException {
		
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
		
	}

	@Override
	protected OpNoPayResultDTO process(OpNoPayParamDTO param) throws BizException {

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
			return new OpNoPayResultDTO();
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
		FArrayList oepEntList = this.getOepEntList(oepChargeInputDTOs, param,patId);// OEPEntList节点

		OpNoPayResultDTO rlt1 = new OpNoPayResultDTO();
		rlt1.setEntinfo(oepEntList);
		
		return rlt1;
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
	private FArrayList getOepEntList(BlOepChargeInputDTO[] oepChargeInputDTOs, OpNoPayParamDTO param,String patId)
			throws BizException {
		// 调入明细按照就诊分组
		Map<String, List<BlOepChargeInputDTO>> map = new HashMap<String, List<BlOepChargeInputDTO>>();// key为就诊id,value为该就诊下的明细集合
		// 如果就诊次数为空的话查出该患者所有就诊信息，如果有值的话，查出该次就诊对应的信息
		if (!StringUtil.isEmpty(param.getTimes_op())) {
			String entId = this.findEntInfo(patId, param.getTimes_op());//获得患者该次就诊的就诊id
			List<BlOepChargeInputDTO> itmList = new ArrayList<BlOepChargeInputDTO>();
			for (BlOepChargeInputDTO itm : oepChargeInputDTOs) {
				if(entId.equals(itm.getId_ent())){
					itmList.add(itm);
				}
			}
			
			//有个特殊情况，一个患者有多条已签署的就诊记录，这个患者再挂个号，医生不接诊，入参里传入该次就诊，那么接口会报空指针
			if(ListUtil.isEmpty(itmList)){
				return new FArrayList();
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
			entInfo.setName_paticate(ListUtil.isEmpty(entItmList) ? "" : entItmList.get(0).getId_paticate_name());// 患者类型
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
				PsnDocDO psnDocDO = BlAmtConverUtil.getPsnDocDO(applyItmList.get(0).getId_emp_or());

				PresInfo presInfo = new PresInfo();
				presInfo.setCode_apply(itmChild3);
				presInfo.setSd_srvtp(applyItmList.get(0) == null ? "" : (applyItmList.get(0).getSd_srvtp() == null ? "" : applyItmList.get(0).getSd_srvtp().substring(0,2)));
				presInfo.setId_or(orId);//医嘱ID
				presInfo.setName_or(orName);//医嘱名称
				presInfo.setDt_effe(dtEffe);//医嘱生效日期
				presInfo.setCode_dep_or(depDO == null ? "" : depDO.getCode());
				presInfo.setName_dep_or(depDO == null ? "" : depDO.getName());
				presInfo.setCode_emp_or(psnDocDO == null ? "" : psnDocDO.getCode());
				presInfo.setName_emp_or(psnDocDO == null ? "" : psnDocDO.getName());
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
					// applyItm.setInccacode(itmChild5);//账单项编码
					// applyItm.setInccaItm();//账单项名称
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
					
					//给医嘱明细增加医嘱信息
					applyItm.setId_or(itmChild5.getId_or());//医嘱主键
					applyItm.setName_or(itmChild5.getName_or());
					
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
	 * 查询患者id_pat
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private String findPat(OpNoPayParamDTO param) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(param.getCode_pat());
		condDto.setId_code(param.getCode_idnum());
		condDto.setCard_code(param.getCode_card());

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
