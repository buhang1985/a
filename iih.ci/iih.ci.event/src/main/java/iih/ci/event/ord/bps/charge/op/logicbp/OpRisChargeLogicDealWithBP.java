package iih.ci.event.ord.bps.charge.op.logicbp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.event.ord.bps.charge.op.query.OpRisChargeContacterQuery;
import iih.ci.event.ord.bps.charge.op.query.OpRisChargeInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpRisIllHisDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrContacterDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class OpRisChargeLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台检查申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BaseDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		
		// 获得sql串及其对应的结果集map
		String sql = getSQlStr(firedto.getIdors());
		
		// 组装检查数据
		List<Map<String, Object>> maps=OrdEventUtil.getRsMapList(sql);
		//日志记录查询语句 便于查错
		if(StringUtils.isNotEmpty(sql)) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "BS002 门诊收费检查 sql:"+sql);
		}
		//查询联系人集合
		OpRisChargeContacterQuery contacterQry = new OpRisChargeContacterQuery(firedto.getIdors());
		IEOpRisOrContacterDTO[] contacterDTOs = (IEOpRisOrContacterDTO[])AppFwUtil.getDORstWithDao(contacterQry, IEOpRisOrContacterDTO.class);
		List<IEOpRisOrEnDTO> risenlist=new ArrayList<>();
		for (Map<String, Object> map2 : maps) {
			IEOpRisOrEnDTO ierisdto = new IEOpRisOrEnDTO();
			setRisEnDto8Map(ierisdto, map2);
			risenlist.add(ierisdto);
			//赋值联系人集合
			if(StringUtils.isNotEmpty(ierisdto.getPatient_id()) && !OrdEventUtil.isEmpty(contacterDTOs)  ) {
				FArrayList2 contacters = new FArrayList2();
				for(IEOpRisOrContacterDTO dto:contacterDTOs) {
					if(StringUtils.isNotEmpty(dto.getPatient_id()) && ierisdto.getPatient_id().equals(dto.getPatient_id())) {
						contacters.add(dto);
					}
				}
				ierisdto.setId_contacters(contacters);
			}
		}

		if(risenlist.size()>0)
		return risenlist.toArray(new IEOpRisOrEnDTO[0]);//new IEOpLisOrEnDTO[] { ielisdto };
		else{
			return new IEOpRisOrEnDTO[]{};
		}
	}
	
	/**
	 * 获得 SQL串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_ors) {
		OpRisChargeInfoQuery qry = new OpRisChargeInfoQuery(id_ors);
		return qry.getQrySQLStr();
	}
	
	/**
	 * IE检查申请就诊信息DTO   IEOpRisOrEnDTO
	 * @param ieoprisdto
	 * @param map
	 */
	@SuppressWarnings("unchecked")
	private void setRisEnDto8Map(IEOpRisOrEnDTO ieoprisdto, Map<String, Object> map) {

		IEOpRisOrDTO ierisdto=new IEOpRisOrDTO();
		IEOpRisIllHisDTO ierisillhisdto=new IEOpRisIllHisDTO();
		setRisOrDto8Map(ierisdto, map);
		setRisOrIllHisDto8Map(ierisillhisdto, map);
		FArrayList2 faIerisors=new FArrayList2();
		FArrayList2 faIerishis=new FArrayList2();
		faIerisors.add(ierisdto);
		faIerishis.add(ierisillhisdto);
		ieoprisdto.setOrg_code(OrdEventUtil.nullHandle(map.get("org_code")));
		ieoprisdto.setOrg_name(OrdEventUtil.nullHandle(map.get("org_name")));
		ieoprisdto.setId_ierisoren(OrdEventUtil.nullHandle(map.get("id_ierisoren")));
		ieoprisdto.setIerisors(faIerisors);
		ieoprisdto.setIerishises(faIerishis);
		ieoprisdto.setPatient_id(OrdEventUtil.nullHandle(map.get("patient_id")));
		ieoprisdto.setP_bar_code(OrdEventUtil.nullHandle(map.get("p_bar_code")));
		ieoprisdto.setWard_code(OrdEventUtil.nullHandle(map.get("ward_code")));
		ieoprisdto.setWard_code_name(OrdEventUtil.nullHandle(map.get("ward_code_name")));
		ieoprisdto.setBed_no(OrdEventUtil.nullHandle(map.get("bed_no")));
		ieoprisdto.setSocial_no(OrdEventUtil.nullHandle(map.get("social_no")));
		ieoprisdto.setAddition_no(OrdEventUtil.nullHandle(map.get("addition_no")));
		ieoprisdto.setName(OrdEventUtil.nullHandle(map.get("name")));
		ieoprisdto.setHome_tel(OrdEventUtil.nullHandle(map.get("home_tel")));
		ieoprisdto.setSexid(OrdEventUtil.nullHandle(map.get("sexid")));
		ieoprisdto.setBirthday(map.get("birthday")==null?null:new FDateTime(map.get("birthday").toString()));
		if(!OrdEventUtil.isEmpty(ieoprisdto.getBirthday())) {
			ieoprisdto.setAge(AgeCalcUtil.getAge(ieoprisdto.getBirthday().getDate()));
		}
		ieoprisdto.setHome_street(OrdEventUtil.nullHandle(map.get("home_street")));
		ieoprisdto.setMarry_code(OrdEventUtil.nullHandle(map.get("marry_code")));
		ieoprisdto.setNation_code(OrdEventUtil.nullHandle(map.get("nation_code")));
		ieoprisdto.setOccupation_type(OrdEventUtil.nullHandle(map.get("occupation_type")));
		ieoprisdto.setOccupation_type_name(OrdEventUtil.nullHandle(map.get("occupation_type_name")));
		ieoprisdto.setWork_unit(OrdEventUtil.nullHandle(map.get("work_unit")));
		ieoprisdto.setCountry_code(OrdEventUtil.nullHandle(map.get("country_code")));
		ieoprisdto.setCountry_code_name(OrdEventUtil.nullHandle(map.get("country_code_name")));
		ieoprisdto.setApply_hospital(OrdEventUtil.nullHandle(map.get("apply_hospital")));
		ieoprisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
		ieoprisdto.setApply_doctor(OrdEventUtil.nullHandle(map.get("apply_doctor")));
		ieoprisdto.setApply_doctor_name(OrdEventUtil.nullHandle(map.get("apply_doctor_name")));
		ieoprisdto.setApply_unit(OrdEventUtil.nullHandle(map.get("apply_unit")));
		ieoprisdto.setApply_unit_name(OrdEventUtil.nullHandle(map.get("apply_unit_name")));
		ieoprisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
		ieoprisdto.setConfirm_opera(OrdEventUtil.nullHandle(map.get("confirm_opera")));
		ieoprisdto.setConfirm_opera_name(OrdEventUtil.nullHandle(map.get("confirm_opera_name")));
		ieoprisdto.setResponse_type(OrdEventUtil.nullHandle(map.get("response_type")));
		ieoprisdto.setTimes(map.get("times")==null?"0":map.get("times").toString());
		ieoprisdto.setDiag_type_code(OrdEventUtil.nullHandle(map.get("diag_type_code")));
		ieoprisdto.setDiag_type_name(OrdEventUtil.nullHandle(map.get("diag_type_name")));
		ieoprisdto.setDiag_input_date(map.get("diag_input_date")==null?null:new FDateTime(map.get("diag_input_date").toString()));
		ieoprisdto.setDiag_code(OrdEventUtil.nullHandle(map.get("diag_code")));
		ieoprisdto.setDiag_str(OrdEventUtil.nullHandle(map.get("diag_str")));
		ieoprisdto.setDomain_id("01");
		
		ieoprisdto.setCode_dep_ns(OrdEventUtil.nullHandle(map.get("code_dep_ns")));
		ieoprisdto.setName_dep_ns(OrdEventUtil.nullHandle(map.get("name_dep_ns")));
		ieoprisdto.setVisitordno(OrdEventUtil.nullHandle(map.get("visitordno")));
		ieoprisdto.setVisittypecode(getParamCodeEntp(OrdEventUtil.nullHandle(map.get("visittypecode"))));//就诊类型编码
		ieoprisdto.setVisittypename(OrdEventUtil.nullHandle(map.get("visittypename")));//就诊类型名称
		//健康卡号
		ieoprisdto.setHealth_card_no(OrdEventUtil.nullHandle(map.get("health_card_no")));
		//主诉
		String sql = String.format("id_ent='%s' and code_element ='%s'", map.get("id_ent"),
				ICiDictCodeConst.CODE_ELEMENT_MAINSUIT);
		MrDocRefValueDO[] mrdocs = null;
		try {
			mrdocs = OrdEventUtil.getMrdocrefvalueRService().find(sql, "", FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(!OrdEventUtil.isEmpty(mrdocs)) {
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			teamMr.put(mrdocs[0].getCode_element(), mrdocs[0]);
			ieoprisdto.setMain_suit(teamMr.get(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT).getContent());
		}
		//现病史
		String sqlNow = String.format("id_ent='%s' and code_element ='%s'", map.get("id_ent"),
				ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE);
		MrDocRefValueDO[] mrdocsNow = null;
		try {
			mrdocsNow = OrdEventUtil.getMrdocrefvalueRService().find(sqlNow, "", FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(!OrdEventUtil.isEmpty(mrdocsNow)) {
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			teamMr.put(mrdocsNow[0].getCode_element(), mrdocsNow[0]);
			ieoprisdto.setNow_diease((teamMr.get(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE).getContent()));
		}
		//过敏史
		ieoprisdto.setAllergy(OrdEventUtil.nullHandle(map.get("allergy")));
	}
	
	@SuppressWarnings("unchecked")
	private void setRisOrDto8Map(IEOpRisOrDTO ierisdto, Map<String, Object> map) {
	
		IEOpRisOrItmDTO ierisitemdto=new IEOpRisOrItmDTO();
		setRisOrItemDto8Map(ierisitemdto, map);
		FArrayList fa=new FArrayList();
		fa.add(ierisitemdto);
		ierisdto.setId_ierisor(OrdEventUtil.nullHandle( map.get("id_ierisor")));
		ierisdto.setId_ierisoren(OrdEventUtil.nullHandle( map.get("id_ierisoren")));
		ierisdto.setId_ierisoritms(fa);
		ierisdto.setApply_serial(OrdEventUtil.nullHandle( map.get("apply_serial")));
		ierisdto.setExam_type(OrdEventUtil.nullHandle( map.get("exam_type")));
		ierisdto.setExam_type_name(OrdEventUtil.nullHandle( map.get("exam_type_name")));
		ierisdto.setExam_content(OrdEventUtil.nullHandle( map.get("exam_content")));
		ierisdto.setExam_request_date(map.get("exam_request_date")==null?null:new FDateTime(map.get("exam_request_date").toString()));
		ierisdto.setSamp_bar_code(OrdEventUtil.nullHandle( map.get("samp_bar_code")));
		ierisdto.setSamp_type(OrdEventUtil.nullHandle( map.get("samp_type")));
		ierisdto.setSamp_content(OrdEventUtil.nullHandle( map.get("samp_content")));
		ierisdto.setExam_exec_date(map.get("exam_exec_date")==null?null:new FDateTime(map.get("exam_exec_date").toString()));
		ierisdto.setExec_unit(OrdEventUtil.nullHandle( map.get("exec_unit")));
		ierisdto.setSqd_deptcode(OrdEventUtil.nullHandle( map.get("sqd_deptcode")));
		ierisdto.setNote(OrdEventUtil.nullHandle( map.get("note")));
		ierisdto.setIemsgca_code(OrdEventUtil.nullHandle(map.get("iemsgca_code"))); // 集成平台用服务分类编码
		ierisdto.setIemsgca_name(OrdEventUtil.nullHandle(map.get("iemsgca_name"))); // 集成平台用服务分类名称
		ierisdto.setIemsgca_typename(OrdEventUtil.nullHandle(map.get("iemsgca_typename"))); // 集成平台用服务分类类型名称
		ierisitemdto.setOrder_pri(getRisPrice(OrdEventUtil.nullHandle(map.get("id_ierisor"))));//医嘱费用
		
	}
	/**
	 * 获取检查价格
	 * @param id_or
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String getRisPrice(String id_or){
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		FDouble price_total = FDouble.ZERO_DBL;
		try {
			sql.append(" select * from ci_or_srv where id_or=? and fg_bl=? and eu_sourcemd in(?,?,?) ");
			SqlParam param = new SqlParam();
			param.addParam(id_or);
			param.addParam("Y");
			param.addParam(OrSrvSourceFromEnum.PHYSIAN);
			param.addParam(OrSrvSourceFromEnum.AGENTFROMPRIMD);
			param.addParam(OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD);
			List<OrdSrvDO> list = (List<OrdSrvDO>)dafacade.execQuery(
					sql.toString(), param,new BeanListHandler(OrdSrvDO.class));
			if(!OrdEventUtil.isEmpty(list)) {
				for (OrdSrvDO ordSrvDO : list) {
					if(FBoolean.FALSE.equals(ordSrvDO.getFg_mm())){
						price_total = price_total
								.add((ordSrvDO.getQuan_total_medu()==null?FDouble.ZERO_DBL:ordSrvDO.getQuan_total_medu())
										.multiply((ordSrvDO.getPri()==null?FDouble.ZERO_DBL:ordSrvDO.getPri())));
					}else{
						sql.delete(0, sql.length());
						sql.append(" select * from ci_or_srv_mm where id_orsrv=? ");
						SqlParam param2 = new SqlParam();
						param2.addParam(ordSrvDO.getId_orsrv());
						List<OrdSrvMmDO> ordSrvMmList = (List<OrdSrvMmDO>)dafacade.execQuery(
								sql.toString(),param2, new BeanListHandler(OrdSrvMmDO.class));
						if(!OrdEventUtil.isEmpty(ordSrvMmList)) {
							for (OrdSrvMmDO ordSrvMmDO : ordSrvMmList) {
								price_total = price_total
										.add((ordSrvMmDO.getQuan_cur()==null?FDouble.ZERO_DBL:ordSrvMmDO.getQuan_cur())
												.multiply((ordSrvMmDO.getPrice_pgku_cur()==null?FDouble.ZERO_DBL:ordSrvMmDO.getPrice_pgku_cur())));
							}
						}
					}
				}
			}
		} catch (BizException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
		return price_total.toString();
	}
	private void setRisOrIllHisDto8Map(IEOpRisIllHisDTO ierisillhisdto, Map<String, Object> map) {
		
		ierisillhisdto.setId_ierisillhis(OrdEventUtil.nullHandle( map.get("")));
		ierisillhisdto.setId_ierisoren(OrdEventUtil.nullHandle( map.get("id_ierisoren")));
		ierisillhisdto.setAnamnesis_code(OrdEventUtil.nullHandle( map.get("")));
		ierisillhisdto.setAnamnesis_disease_code(OrdEventUtil.nullHandle( map.get("diag_code")));
		//既往史
		ICiMrOutQryServices pastService = (ICiMrOutQryServices)ServiceFinder.find(ICiMrOutQryServices.class.getName());
		try {
			String[] codeStrings= {"S.04"}; 
			MrDocRefValueDO[] mrdo  = pastService.getCimrPhaseByElemCode(map.get("id_ent").toString(), codeStrings);
			if(!OrdEventUtil.isEmpty(mrdo)) {
				ierisillhisdto.setAnamnesis_content(mrdo[mrdo.length-1].getContent());
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
	
	private void setRisOrItemDto8Map(IEOpRisOrItmDTO ierisitemdto, Map<String, Object> map){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if(ierisitemdto==null||map==null)return;
		ierisitemdto.setId_ierisoritm(OrdEventUtil.nullHandle(map.get("id_ierisoritm")));
		ierisitemdto.setId_ierisor(OrdEventUtil.nullHandle( map.get("id_ierisor")));
		ierisitemdto.setExam_serial(OrdEventUtil.nullHandle( map.get("exam_serial")));
		ierisitemdto.setExam_sub_type(OrdEventUtil.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_type_name(OrdEventUtil.nullHandle( map.get("exam_sub_type_name")));
		ierisitemdto.setExam_sub_fftype(OrdEventUtil.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_fftype_name(OrdEventUtil.nullHandle( map.get("exam_sub_type_name")));
		ierisitemdto.setExam_region(OrdEventUtil.nullHandle( map.get("exam_region")));
		ierisitemdto.setExam_region_name(OrdEventUtil.nullHandle( map.get("exam_region_name")));
		ierisitemdto.setYz_frequency(OrdEventUtil.nullHandle( map.get("yz_frequency")));
		ierisitemdto.setDt_effe(OrdEventUtil.nullHandle(map.get("dt_effe")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_effe").toString()).getMillis()))));
		ierisitemdto.setDt_end(OrdEventUtil.nullHandle(map.get("dt_end")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_end").toString()).getMillis())) ));
		ierisitemdto.setOrdertimetype(OrdEventUtil.nullHandle(map.get("ordertimetype")));//医嘱时间类型编码
		ierisitemdto.setOrdertimetypename(OrdEventUtil.nullHandle(map.get("ordertimetypename")));//医嘱时间类型名称
		// 设置vip标识
		String id_en = (String) map.get("id_ierisoren");
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			ierisitemdto.setEu_vip(vip);
		} catch (BizException e) {
			e.printStackTrace();
		}
		//检查类型编码 新（服务类型编码）
		ierisitemdto.setSer_type_code(OrdEventUtil.nullHandle( map.get("ser_type_code")));
		//检查类型编码名称 新（服务类型编码名称）
		ierisitemdto.setSer_type_name(OrdEventUtil.nullHandle( map.get("ser_type_name")));
		//是否哺乳
		ierisitemdto.setIsbreastfeeding(OrdEventUtil.nullHandle( map.get("is_breastfeeding")));
		//是否妊娠
		ierisitemdto.setIspregnancy(OrdEventUtil.nullHandle( map.get("is_pregnancy")));
		//妊娠时间
		ierisitemdto.setPregnancy_date(map.get("pregnancy_date")==null?null:new FDateTime(map.get("pregnancy_date").toString()));
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			if(!OrdEventUtil.isEmpty(id_en)) {
				String[] arrStrings=id_en.split(",");
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				if(!OrdEventUtil.isEmpty(dto)) {
					//体重
					if(!OrdEventUtil.isEmpty(dto[0].getWeight())) {
						ierisitemdto.setWeight(dto[0].getWeight().toString());
					}
					//体重单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_weight())) {
						ierisitemdto.setWeight_unit(dto[0].getName_unit_weight());
					}
					//身高
					if(!OrdEventUtil.isEmpty(dto[0].getHeight())) {
						ierisitemdto.setHeight(dto[0].getHeight().toString());
					}
					//身高单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_height())) {
						ierisitemdto.setHeight_unit(dto[0].getName_unit_height());
					}
				}
			}
			
		} catch (BizException e) {
			ierisitemdto.setWeight("");
			ierisitemdto.setWeight_unit("");
			ierisitemdto.setHeight("");
			ierisitemdto.setHeight_unit("");
			e.printStackTrace();
		}
		//费用金额
		ierisitemdto.setAmounts(OrdEventUtil.nullHandle( map.get("amounts")));
		//收费状态标识
		String id_or = ierisitemdto.getId_ierisor();
		if(StringUtils.isNotEmpty(id_or)) {
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
				if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
					ierisitemdto.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				ierisitemdto.setPayflag("");
				e.printStackTrace();
			}
		}
	}
}
