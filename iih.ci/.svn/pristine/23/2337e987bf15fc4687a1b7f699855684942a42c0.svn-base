package iih.ci.ord.s.bp.iemsg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpOpOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisIllHisDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrContacterDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiRisOpOrContacterQry;
import iih.ci.ord.s.bp.iemsg.qry.CiRisOpOrNoAcountQry;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import iih.pi.reg.pat.d.PiPatContDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * BS002：生成集成平台检查申请服务数据信息操作BP 未记账
 * （门诊）
 */
public class GetIEOpMsgInfo4RisNoAcountBP {
	/**
	 * 生成集成平台检查申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		// 获得sql串及其对应的结果集map
		CiRisOpOrNoAcountQry qry = new CiRisOpOrNoAcountQry(id_ors);
		
		//String sql = getSQlStr(id_ors);
		String sql = qry.getQrySQLStr();
		
		//Map<String, Object> map = CiOrdUtils.getRsMap(sql);
		SqlParam param = qry.getQryParameter(new StringBuffer());
		//日志记录查询语句 便于查错
		if(StringUtils.isNotEmpty(sql) && param != null) {
			CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
			OrdBizLogger.info(ctx, "++++++++检查 sql:"+sql+" --param:"+param.toString());
		}
		//查询联系人集合
		CiRisOpOrContacterQry contacterQry = new CiRisOpOrContacterQry(id_ors);
		IEOpRisOrContacterDTO[] contacterDTOs = (IEOpRisOrContacterDTO[])AppFwUtil.getDORstWithDao(contacterQry, IEOpRisOrContacterDTO.class);
		// 组装检查数据
		List<Map<String, Object>> maps = CiOrdUtils.getRsMapList(sql,param);
		List<IEOpRisOrEnDTO> risenlist=new ArrayList<>();

		for (Map<String, Object> map2 : maps) {
			IEOpRisOrEnDTO ierisdto = new IEOpRisOrEnDTO();
			setRisEnDto8Map(ierisdto, map2);
			risenlist.add(ierisdto);
			if(!CiOrdUtils.isEmpty(ierisdto.getBirthday())) {
				ierisdto.setAge(AgeCalcUtil.getAge(ierisdto.getBirthday().getDate()));
			}
			//赋值联系人集合
			if(StringUtils.isNotEmpty(ierisdto.getPatient_id()) && !CiOrdUtils.isEmpty(contacterDTOs)  ) {
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
		CiRisOpOrNoAcountQry qry = new CiRisOpOrNoAcountQry(id_ors);
		return qry.getQrySQLStr();
	}
	
	/**
	 * IE检查申请就诊信息DTO   IEOpRisOrEnDTO
	 * @param ieoprisdto
	 * @param map
	 */
	private void setRisEnDto8Map(IEOpRisOrEnDTO ieoprisdto, Map<String, Object> map) {

		IEOpRisOrDTO ierisdto=new IEOpRisOrDTO();
		IEOpRisIllHisDTO ierisillhisdto=new IEOpRisIllHisDTO();
		setRisOrDto8Map(ierisdto, map);
		setRisOrIllHisDto8Map(ierisillhisdto, map);
		FArrayList2 faIerisors=new FArrayList2();
		FArrayList2 faIerishis=new FArrayList2();
		faIerisors.add(ierisdto);
		faIerishis.add(ierisillhisdto);
		ieoprisdto.setOrg_code(CiOrdUtils.nullHandle(map.get("org_code")));
		ieoprisdto.setOrg_name(CiOrdUtils.nullHandle(map.get("org_name")));
		ieoprisdto.setId_ierisoren(CiOrdUtils.nullHandle(map.get("id_ierisoren")));
		ieoprisdto.setIerisors(faIerisors);
		ieoprisdto.setIerishises(faIerishis);
		ieoprisdto.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
		ieoprisdto.setP_bar_code(CiOrdUtils.nullHandle(map.get("p_bar_code")));
		ieoprisdto.setWard_code(CiOrdUtils.nullHandle(map.get("ward_code")));
		ieoprisdto.setWard_code_name(CiOrdUtils.nullHandle(map.get("ward_code_name")));
		ieoprisdto.setBed_no(CiOrdUtils.nullHandle(map.get("bed_no")));
		ieoprisdto.setSocial_no(CiOrdUtils.nullHandle(map.get("social_no")));
		ieoprisdto.setAddition_no(CiOrdUtils.nullHandle(map.get("addition_no")));
		ieoprisdto.setName(CiOrdUtils.nullHandle(map.get("name")));
		ieoprisdto.setHome_tel(CiOrdUtils.nullHandle(map.get("home_tel")));
		ieoprisdto.setSexid(CiOrdUtils.nullHandle(map.get("sexid")));
		ieoprisdto.setBirthday(map.get("birthday")==null?null:new FDateTime(map.get("birthday").toString()));
		ieoprisdto.setAge(CiOrdUtils.nullHandle(map.get("age")));
		ieoprisdto.setHome_street(CiOrdUtils.nullHandle(map.get("home_street")));
		ieoprisdto.setMarry_code(CiOrdUtils.nullHandle(map.get("marry_code")));
		ieoprisdto.setNation_code(CiOrdUtils.nullHandle(map.get("nation_code")));
		ieoprisdto.setOccupation_type(CiOrdUtils.nullHandle(map.get("occupation_type")));
		ieoprisdto.setOccupation_type_name(CiOrdUtils.nullHandle(map.get("occupation_type_name")));
		ieoprisdto.setWork_unit(CiOrdUtils.nullHandle(map.get("work_unit")));
		ieoprisdto.setCountry_code(CiOrdUtils.nullHandle(map.get("country_code")));
		ieoprisdto.setCountry_code_name(CiOrdUtils.nullHandle(map.get("country_code_name")));
		ieoprisdto.setApply_hospital(CiOrdUtils.nullHandle(map.get("apply_hospital")));
		ieoprisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
		ieoprisdto.setApply_doctor(CiOrdUtils.nullHandle(map.get("apply_doctor")));
		ieoprisdto.setApply_doctor_name(CiOrdUtils.nullHandle(map.get("apply_doctor_name")));
		ieoprisdto.setApply_unit(CiOrdUtils.nullHandle(map.get("apply_unit")));
		ieoprisdto.setApply_unit_name(CiOrdUtils.nullHandle(map.get("apply_unit_name")));
		ieoprisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
		ieoprisdto.setConfirm_opera(CiOrdUtils.nullHandle(map.get("confirm_opera")));
		ieoprisdto.setConfirm_opera_name(CiOrdUtils.nullHandle(map.get("confirm_opera_name")));
		ieoprisdto.setResponse_type(CiOrdUtils.nullHandle(map.get("response_type")));
		ieoprisdto.setTimes(CiOrdUtils.nullHandle(map.get("times")));
		ieoprisdto.setDiag_type_code(CiOrdUtils.nullHandle(map.get("diag_type_code")));
		ieoprisdto.setDiag_type_name(CiOrdUtils.nullHandle(map.get("diag_type_name")));
		ieoprisdto.setDiag_input_date(map.get("diag_input_date")==null?null:new FDateTime(map.get("diag_input_date").toString()));
		ieoprisdto.setDiag_code(CiOrdUtils.nullHandle(map.get("diag_code")));
		ieoprisdto.setDiag_str(CiOrdUtils.nullHandle(map.get("diag_str")));
		ieoprisdto.setDomain_id("01");
		
		ieoprisdto.setCode_dep_ns(CiOrdUtils.nullHandle(map.get("code_dep_ns")));
		ieoprisdto.setName_dep_ns(CiOrdUtils.nullHandle(map.get("name_dep_ns")));
		ieoprisdto.setVisitordno(CiOrdUtils.nullHandle(map.get("visitordno")));//流水号
		ieoprisdto.setVisittypecode(CiOrdUtils.nullHandle(map.get("visittypecode")));//就诊类型编码
		ieoprisdto.setVisittypename(CiOrdUtils.nullHandle(map.get("visittypename")));//就诊类型名称
		//主诉
		String sql = String.format("id_ent='%s' and code_element ='%s'", map.get("id_ent"),
				ICiDictCodeConst.CODE_ELEMENT_MAINSUIT);
		MrDocRefValueDO[] mrdocs = null;
		try {
			mrdocs = CiOrdAppUtils.getMrdocrefvalueRService().find(sql, "", FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(!CiOrdUtils.isEmpty(mrdocs)) {
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			teamMr.put(mrdocs[0].getCode_element(), mrdocs[0]);
			ieoprisdto.setMain_suit(teamMr.get(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT).getContent());
		}
		//现病史
		String sqlNow = String.format("id_ent='%s' and code_element ='%s'", map.get("id_ent"),
				ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE);
		MrDocRefValueDO[] mrdocsNow = null;
		try {
			mrdocsNow = CiOrdAppUtils.getMrdocrefvalueRService().find(sqlNow, "", FBoolean.FALSE);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if(!CiOrdUtils.isEmpty(mrdocsNow)) {
			Map<String, MrDocRefValueDO> teamMr = new HashMap<String, MrDocRefValueDO>();
			teamMr.put(mrdocsNow[0].getCode_element(), mrdocsNow[0]);
			ieoprisdto.setNow_diease((teamMr.get(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE).getContent()));
		}
		//过敏史
		ieoprisdto.setAllergy(CiOrdUtils.nullHandle(map.get("allergy")));
		//健康卡号
		ieoprisdto.setHealth_card_no(CiOrdUtils.nullHandle(map.get("health_card_no")));
	}
	
	private void setRisOrDto8Map(IEOpRisOrDTO ierisdto, Map<String, Object> map) {
	
		IEOpRisOrItmDTO ierisitemdto=new IEOpRisOrItmDTO();
		setRisOrItemDto8Map(ierisitemdto, map);
		FArrayList fa=new FArrayList();
		fa.add(ierisitemdto);
		ierisdto.setId_ierisor(CiOrdUtils.nullHandle( map.get("id_ierisor")));
		ierisdto.setId_ierisoren(CiOrdUtils.nullHandle( map.get("id_ierisoren")));
		ierisdto.setId_ierisoritms(fa);
		ierisdto.setApply_serial(CiOrdUtils.nullHandle( map.get("apply_serial")));
		ierisdto.setExam_type(CiOrdUtils.nullHandle( map.get("exam_type")));
		ierisdto.setExam_type_name(CiOrdUtils.nullHandle( map.get("exam_type_name")));
		ierisdto.setExam_content(CiOrdUtils.nullHandle( map.get("exam_content")));
		ierisdto.setExam_request_date(map.get("exam_request_date")==null?null:new FDateTime(map.get("exam_request_date").toString()));
		ierisdto.setSamp_bar_code(CiOrdUtils.nullHandle( map.get("samp_bar_code")));
		ierisdto.setSamp_type(CiOrdUtils.nullHandle( map.get("samp_type")));
		ierisdto.setSamp_content(CiOrdUtils.nullHandle( map.get("samp_content")));
		ierisdto.setExam_exec_date(map.get("exam_exec_date")==null?null:new FDateTime(map.get("exam_exec_date").toString()));
		ierisdto.setExec_unit(CiOrdUtils.nullHandle( map.get("exec_unit")));
		ierisdto.setSqd_deptcode(CiOrdUtils.nullHandle( map.get("sqd_deptcode")));
		ierisdto.setNote(CiOrdUtils.nullHandle( map.get("note")));
		ierisdto.setIemsgca_code(CiOrdUtils.nullHandle(map.get("iemsgca_code"))); // 集成平台用服务分类编码
		ierisdto.setIemsgca_name(CiOrdUtils.nullHandle(map.get("iemsgca_name"))); // 集成平台用服务分类名称
		ierisdto.setIemsgca_typename(CiOrdUtils.nullHandle(map.get("iemsgca_typename"))); // 集成平台用服务分类类型名称
		ierisitemdto.setOrder_pri(getRisPrice(CiOrdUtils.nullHandle(map.get("id_ierisor"))));//医嘱费用
		ierisitemdto.setOrdertimetype(CiOrdUtils.nullHandle(map.get("ordertimetype")));//医嘱时间类型编码
		ierisitemdto.setOrdertimetypename(CiOrdUtils.nullHandle(map.get("ordertimetypename")));//医嘱时间类型名称

	}
	/**
	 * 获取检查价格
	 * @param id_or
	 * @return
	 */
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
			if(list!=null && list.size()>0) {
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
						if(ordSrvMmList!=null&& ordSrvMmList.size()>0) {
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
		
		ierisillhisdto.setId_ierisillhis(CiOrdUtils.nullHandle( map.get("")));
		ierisillhisdto.setId_ierisoren(CiOrdUtils.nullHandle( map.get("id_ierisoren")));
		ierisillhisdto.setAnamnesis_code(CiOrdUtils.nullHandle( map.get("")));
		ierisillhisdto.setAnamnesis_disease_code(CiOrdUtils.nullHandle( map.get("diag_code")));
		//既往史
		ICiMrOutQryServices pastService = (ICiMrOutQryServices)ServiceFinder.find(ICiMrOutQryServices.class.getName());
		try {
			String[] codeStrings= {"S.04"}; 
			MrDocRefValueDO[] mrdo  = pastService.getCimrPhaseByElemCode(map.get("id_ent").toString(), codeStrings);
			if(!CiOrdUtils.isEmpty(mrdo)) {
				ierisillhisdto.setAnamnesis_content(mrdo[mrdo.length-1].getContent());
			}
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
	
	private void setRisOrItemDto8Map(IEOpRisOrItmDTO ierisitemdto, Map<String, Object> map){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if(ierisitemdto==null||map==null)return;
		ierisitemdto.setId_ierisoritm(CiOrdUtils.nullHandle(map.get("id_ierisoritm")));
		ierisitemdto.setId_ierisor(CiOrdUtils.nullHandle( map.get("id_ierisor")));
		ierisitemdto.setExam_serial(CiOrdUtils.nullHandle( map.get("exam_serial")));
		ierisitemdto.setExam_sub_type(CiOrdUtils.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_type_name(CiOrdUtils.nullHandle( map.get("exam_sub_type_name")));
//		ierisitemdto.setExam_sub_fftype(CiOrdUtils.nullHandle( map.get("exam_sub_fftype")));
//		ierisitemdto.setExam_sub_fftype_name(CiOrdUtils.nullHandle( map.get("exam_sub_fftype_name")));
		ierisitemdto.setExam_sub_fftype(CiOrdUtils.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_fftype_name(CiOrdUtils.nullHandle( map.get("exam_sub_type_name")));
		ierisitemdto.setExam_region(CiOrdUtils.nullHandle( map.get("exam_region")));
		ierisitemdto.setExam_region_name(CiOrdUtils.nullHandle( map.get("exam_region_name")));
		ierisitemdto.setYz_frequency(CiOrdUtils.nullHandle( map.get("yz_frequency")));
		ierisitemdto.setYz_frequency_name(CiOrdUtils.nullHandle( map.get("yz_frequency_name")));
		//医嘱开始时间取dt_effe by yzh 2017-08-01 19:00:33
		ierisitemdto.setDt_effe(CiOrdUtils.nullHandle(map.get("dt_effe")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_effe").toString()).getMillis()))));
		ierisitemdto.setDt_end(CiOrdUtils.nullHandle(map.get("dt_end")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_end").toString()).getMillis())) ));
		ierisitemdto.setIs_em(CiOrdUtils.nullHandle( map.get("is_em")));//是否加急
		// 设置vip标识
		String id_en = (String) map.get("id_ierisoren");
		
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			ierisitemdto.setEu_vip(vip);
		} catch (BizException e) {
			e.printStackTrace();
		}
		//是否哺乳
		ierisitemdto.setIsbreastfeeding(CiOrdUtils.nullHandle( map.get("is_breastfeeding")));
		//是否妊娠
		ierisitemdto.setIspregnancy(CiOrdUtils.nullHandle( map.get("is_pregnancy")));
		//妊娠时间
		ierisitemdto.setPregnancy_date(map.get("pregnancy_date")==null?null:new FDateTime(map.get("pregnancy_date").toString()));
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			if(!CiOrdUtils.isEmpty(id_en)) {
				String[] arrStrings=id_en.split(",");
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				if(!CiOrdUtils.isEmpty(dto)) {
					//体重
					if(!CiOrdUtils.isEmpty(dto[0].getWeight())) {
						ierisitemdto.setWeight(dto[0].getWeight().toString());
					}
					//体重单位
					if(!CiOrdUtils.isEmpty(dto[0].getName_unit_weight())) {
						ierisitemdto.setWeight_unit(dto[0].getName_unit_weight());
					}
					//身高
					if(!CiOrdUtils.isEmpty(dto[0].getHeight())) {
						ierisitemdto.setHeight(dto[0].getHeight().toString());
					}
					//身高单位
					if(!CiOrdUtils.isEmpty(dto[0].getName_unit_height())) {
						ierisitemdto.setHeight_unit(dto[0].getName_unit_height());
					}
				}
			}
			
		} catch (BizException e) {
			e.printStackTrace();
		}
		//费用金额
		ierisitemdto.setAmounts(CiOrdUtils.nullHandle( map.get("amounts")));
		//检查类型编码
		ierisitemdto.setExamtypecode(CiOrdUtils.nullHandle( map.get("exam_type")));
		//检查类型名称
		ierisitemdto.setExamtypename(CiOrdUtils.nullHandle( map.get("exam_type_name")));
		//检查类型编码 新（服务类型编码）
		ierisitemdto.setSer_type_code(CiOrdUtils.nullHandle( map.get("ser_type_code")));
		//检查类型编码名称 新（服务类型编码名称）
		ierisitemdto.setSer_type_name(CiOrdUtils.nullHandle( map.get("ser_type_name")));
		//收费状态标识
		String code_or = ierisitemdto.getExam_serial();
		if(StringUtils.isNotEmpty(code_or)) {
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.CODE_OR, code_or);
				if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
					ierisitemdto.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				ierisitemdto.setPayflag("");
				e.printStackTrace();
			}
		}
	}
	
}
