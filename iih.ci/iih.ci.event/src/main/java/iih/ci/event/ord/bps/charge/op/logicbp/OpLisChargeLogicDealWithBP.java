package iih.ci.event.ord.bps.charge.op.logicbp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.ci.event.ord.bps.charge.op.query.OpLisChargeAllInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventHelper;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
/**
 * 门诊收费 检验处理逻辑BS006
 * @author F
 *
 * @date 2019年9月12日上午9:18:45
 *
 * @classpath iih.ci.event.ord.bps.charge.op.logicbp.OpLisChargeLogicDealWithBP
 */
public class OpLisChargeLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台检验申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpLisOrEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		
		//获得sql串及其对应的结果集map
		String sql=getSQlStr(firedto.getIdors());
		List<Map<String, Object>> maps=OrdEventUtil.getRsMapList(sql);
		List<IEOpLisOrEnDTO> lisenlist=new ArrayList<>();
		for (Map<String, Object> map2 : maps) {
			IEOpLisOrEnDTO ielisdto = new IEOpLisOrEnDTO();
			setLisEnDto8Map(ielisdto, map2);
			lisenlist.add(ielisdto);
		}
		// 组装检验数据
		if(lisenlist.size()>0)
		return lisenlist.toArray(new IEOpLisOrEnDTO[0]);//new IEOpLisOrEnDTO[] { ielisdto };
		else{
			return new IEOpLisOrEnDTO[]{};
		}
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_ors){
		OpLisChargeAllInfoQuery qry=new OpLisChargeAllInfoQuery(id_ors);
		return qry.getQrySQLStr();
	} 
	
	
	/**
	 * IE检验申请就诊信息DTO   IELisOrEnDTO
	 * @param ielisdto
	 * @param map
	 * @throws BizException 
	 */
		@SuppressWarnings("unchecked")
		private void setLisEnDto8Map(IEOpLisOrEnDTO ieoplisdto, Map<String, Object> map) throws BizException {
			IEOpLisOrDTO ielisdto=new IEOpLisOrDTO();
			setLisOrDto8Map(ielisdto, map);
			FArrayList2 fa2=new FArrayList2();
			fa2.add(ielisdto);
			ieoplisdto.setDomain_id("01");
			ieoplisdto.setId_ielisoren(OrdEventUtil.nullHandle(map.get("id_ielisoren")));
			ieoplisdto.setId_ielisors(fa2);
			ieoplisdto.setPatient_id(OrdEventUtil.nullHandle(map.get("patient_id")));
			ieoplisdto.setP_bar_code(OrdEventUtil.nullHandle(map.get("p_bar_code")));
			ieoplisdto.setWard_code(OrdEventUtil.nullHandle(map.get("ward_code")));
			ieoplisdto.setWard_code_name(OrdEventUtil.nullHandle(map.get("ward_code_name")));
			ieoplisdto.setBed_no(OrdEventUtil.nullHandle(map.get("bed_no")));
			ieoplisdto.setSocial_no(OrdEventUtil.nullHandle(map.get("social_no")));
			ieoplisdto.setName(OrdEventUtil.nullHandle(map.get("name")));
			ieoplisdto.setHome_tel(OrdEventUtil.nullHandle(map.get("home_tel")));
			ieoplisdto.setCellphone(OrdEventUtil.nullHandle(map.get("cellphone")));
			ieoplisdto.setSex(OrdEventUtil.nullHandle(map.get("sex")));
			if(map.get("birthday")!=null){
				FDateTime fd=new FDateTime(map.get("birthday").toString());
				ieoplisdto.setBirthday(fd);
				ieoplisdto.setAge(AgeCalcUtil.getAge(new FDate(fd.toString())));    
			}
			ieoplisdto.setHome_street(OrdEventUtil.nullHandle(map.get("home_street")));
			//邮编 
			ieoplisdto.setPost_code(OrdEventUtil.nullHandle(map.get("add_post_code")));
			ieoplisdto.setWork_place_code(OrdEventUtil.nullHandle(map.get("work_place_code")));
			ieoplisdto.setWork_place(OrdEventUtil.nullHandle(map.get("work_place")));
			ieoplisdto.setHospital_code(OrdEventUtil.nullHandle(map.get("hospital_code")));
			ieoplisdto.setHospital_name(OrdEventUtil.nullHandle(map.get("hospital_name")));
			ieoplisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
			ieoplisdto.setApply_doctor(OrdEventUtil.nullHandle(map.get("apply_doctor")));
			ieoplisdto.setApply_doctor_name(OrdEventUtil.nullHandle(map.get("apply_doctor_name")));
			ieoplisdto.setApply_unit(OrdEventUtil.nullHandle(map.get("apply_unit")));
			ieoplisdto.setApply_unit_name(OrdEventUtil.nullHandle(map.get("apply_unit_name")));
			ieoplisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
			ieoplisdto.setConfirm_opera(OrdEventUtil.nullHandle(map.get("confirm_opera")));
			ieoplisdto.setConfirm_opera_name(OrdEventUtil.nullHandle(map.get("confirm_opera_name")));
			ieoplisdto.setInput_begindate(map.get("input_begindate")==null?null:new FDateTime(map.get("input_begindate").toString()));
			ieoplisdto.setInput_enddate(map.get("input_enddate")==null?null:new FDateTime(map.get("input_enddate").toString()));
			ieoplisdto.setInput_opera(OrdEventUtil.nullHandle(map.get("input_opera")));
			ieoplisdto.setInput_opera_name(OrdEventUtil.nullHandle(map.get("input_opera_name")));
			ieoplisdto.setTimes(map.get("times")==null?"0":map.get("times").toString());
			ieoplisdto.setVisit_type(OrdEventUtil.nullHandle(map.get("visit_type")));
			ieoplisdto.setVisit_type_name(OrdEventUtil.nullHandle(map.get("visit_type_name")));
			ieoplisdto.setYq_code(OrdEventUtil.nullHandle(map.get("yq_code")));
			ieoplisdto.setYz_code_name(OrdEventUtil.nullHandle(map.get("yz_code_name")));
			//诊断类别编码
			ieoplisdto.setDiag_type(OrdEventUtil.nullHandle(map.get("diag_type")));
			//疾病编码
			ieoplisdto.setDiag_code(OrdEventUtil.nullHandle(map.get("diag_code")));
			//疾病名称
			ieoplisdto.setDiag_str(OrdEventUtil.nullHandle(map.get("diag_str")));
			//诊断类别名称
			ieoplisdto.setDiag_type_name(OrdEventUtil.nullHandle(map.get("diag_type_name")));
			ieoplisdto.setPatient_deptcode(OrdEventUtil.nullHandle(map.get("patient_deptcode")));
			ieoplisdto.setPatient_deptname(OrdEventUtil.nullHandle(map.get("patient_deptname")));
			ieoplisdto.setVisitordno(OrdEventUtil.nullHandle(map.get("visitordno")));//就诊流水号
			ieoplisdto.setVisittype(getParamCodeEntp(OrdEventUtil.nullHandle(map.get("visittype"))));//就诊类型编码
			ieoplisdto.setVisittypename(OrdEventUtil.nullHandle(map.get("visittypename")));//就诊类型名称
			//健康卡号
			ieoplisdto.setHealth_card_no(OrdEventUtil.nullHandle(map.get("health_card_no")));
			//过敏史
			ieoplisdto.setAllergy(OrdEventUtil.nullHandle(map.get("allergy")));
			
		}
	/**
	 * IE检验申请信息DTO   IELisOrDTO
	 * @param ielisordto
	 * @param map
	 * @throws BizException 
	 */
		@SuppressWarnings("unchecked")
		private void setLisOrDto8Map(IEOpLisOrDTO ielisordto, Map<String, Object> map) throws BizException {
			IEOpLisOrItmDTO ielisitemdto=new IEOpLisOrItmDTO();
			setLisOrItemDto8Map(ielisitemdto, map);
			FArrayList2 fa2=new FArrayList2();
			fa2.add(ielisitemdto);
			ielisordto.setId_ielisor(OrdEventUtil.nullHandle( map.get("id_ielisor")));
			ielisordto.setId_ielisoren(OrdEventUtil.nullHandle( map.get("id_ielisoren")));
			ielisordto.setId_ielisoritms(fa2);
			ielisordto.setJy_applyserial1(OrdEventUtil.nullHandle( map.get("jy_applyserial1")));
			ielisordto.setOrder_type(OrdEventUtil.nullHandle( map.get("order_type")));
			ielisordto.setOrder_type_name(OrdEventUtil.nullHandle( map.get("order_type_name")));
			ielisordto.setApply_date(map.get("apply_date")==null?null:new FDateTime(map.get("apply_date").toString()));
			ielisordto.setIs_private(OrdEventUtil.nullHandle( map.get("is_private")));
			ielisordto.setDiag_type(OrdEventUtil.nullHandle( map.get("diag_type")));
			ielisordto.setDiag_name(OrdEventUtil.nullHandle( map.get("diag_name")));
			ielisordto.setDiag_str(OrdEventUtil.nullHandle( map.get("diag_str")));
			ielisordto.setIemsgca_code(OrdEventUtil.nullHandle( map.get("iemsgca_code")));
			ielisordto.setIemsgca_name(OrdEventUtil.nullHandle( map.get("iemsgca_name")));
		}

	/**
	 * IE检验申请对应项目信息DTO IELisOrItmDTO
	 * 
	 * @param ielisitemdto
	 * @param map
	 * @throws BizException
	 */
	private void setLisOrItemDto8Map(IEOpLisOrItmDTO ielisitemdto, Map<String, Object> map) throws BizException {
		ielisitemdto.setTest_price(OrdEventUtil.nullHandle( map.get("test_price")));
		ielisitemdto.setId_ielisoritm(OrdEventUtil.nullHandle( map.get("id_ielisoritm")));
		ielisitemdto.setId_ielisor(OrdEventUtil.nullHandle( map.get("id_ielisor")));
		ielisitemdto.setYz_no(OrdEventUtil.nullHandle( map.get("jy_applyserial1")));
		ielisitemdto.setYz_no(OrdEventUtil.nullHandle( map.get("yz_no")));
		ielisitemdto.setJy_applyserial(OrdEventUtil.nullHandle( map.get("jy_applyserial")));
		ielisitemdto.setJyname(OrdEventUtil.nullHandle( map.get("jyname")));
		ielisitemdto.setPriority(OrdEventUtil.nullHandle( map.get("priority")));
		ielisitemdto.setYz_start_date(map.get("yz_start_date") == null ? null : new FDateTime(map.get("yz_start_date").toString()));
		ielisitemdto.setYz_stop_date(map.get("yz_stop_date") == null ? null : new FDateTime(map.get("yz_stop_date").toString()));
		ielisitemdto.setYz_frequency(OrdEventUtil.nullHandle( map.get("yz_frequency")));
		ielisitemdto.setYz_frequency_name(OrdEventUtil.nullHandle( map.get("yz_frequency_name")));
		ielisitemdto.setDescp_code(OrdEventUtil.nullHandle( map.get("descp_code")));
		ielisitemdto.setDescription(OrdEventUtil.nullHandle( map.get("description")));
		ielisitemdto.setCollect_ragion(OrdEventUtil.nullHandle( map.get("collect_ragion")));
		ielisitemdto.setSample_id(OrdEventUtil.nullHandle( map.get("sample_id")));
		ielisitemdto.setSample_class(OrdEventUtil.nullHandle( map.get("sample_class")));
		ielisitemdto.setSample_code_name(OrdEventUtil.nullHandle( map.get("sample_code_name")));
		ielisitemdto.setCollect_time(map.get("collect_time") == null ? null : new FDateTime(map.get("collect_time").toString()));
		ielisitemdto.setContainer_code(OrdEventUtil.nullHandle( map.get("container_code")));
		ielisitemdto.setContainer_code_name(OrdEventUtil.nullHandle( map.get("container_code_name")));
		ielisitemdto.setCollecter_code(OrdEventUtil.nullHandle( map.get("collecter_code")));
		ielisitemdto.setCollecter_code_name(OrdEventUtil.nullHandle( map.get("collecter_code_name")));
		ielisitemdto.setCollecter_place(OrdEventUtil.nullHandle( map.get("collecter_place")));
		ielisitemdto.setExec_code(OrdEventUtil.nullHandle( map.get("exec_code")));
		ielisitemdto.setExec_code_name(OrdEventUtil.nullHandle( map.get("exec_code_name")));
		ielisitemdto.setSupply_price(OrdEventUtil.nullHandle( map.get("supply_price")));
		ielisitemdto.setCommenttp(OrdEventUtil.nullHandle( map.get("commenttp")));
		ielisitemdto.setSample_request(OrdEventUtil.nullHandle( map.get("sample_request")));
		ielisitemdto.setIsstest(OrdEventUtil.nullHandle( map.get("isstest")));
		ielisitemdto.setStest(OrdEventUtil.nullHandle( map.get("stest")));
		ielisitemdto.setIs_em(OrdEventUtil.nullHandle( map.get("is_em")));
		ielisitemdto.setIs_em_r(OrdEventUtil.nullHandle( map.get("is_em_r")));
		ielisitemdto.setIsyg(OrdEventUtil.nullHandle( map.get("isyg")));
		ielisitemdto.setYg(OrdEventUtil.nullHandle( map.get("yg")));
		ielisitemdto.setOrdertimetypecode(OrdEventUtil.nullHandle(map.get("ordertimetypecode")));//医嘱时间类型编码
		ielisitemdto.setOrdertimetypename(OrdEventUtil.nullHandle(map.get("ordertimetypename")));//医嘱时间类型名称
		
		//TODO 根据就诊id 获取vip状态， 代码重构时再做调整
		String id_en = (String) map.get("id_ielisoren");
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			ielisitemdto.setEu_vip(vip);
		} catch (BizException e) {
			ielisitemdto.setEu_vip("");
		}
		//是否哺乳
		ielisitemdto.setIs_breastfeeding(OrdEventUtil.nullHandle( map.get("is_breastfeeding")));
		//是否妊娠
		ielisitemdto.setIs_pregnancy(OrdEventUtil.nullHandle( map.get("is_pregnancy")));
		//妊娠时间
		ielisitemdto.setPregnancy_date(map.get("pregnancy_date")==null?null:new FDateTime(map.get("pregnancy_date").toString()));
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			if(!OrdEventUtil.isEmpty(id_en)) {
				String[] arrStrings=id_en.split(",");
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				if(!OrdEventUtil.isEmpty(dto)) {
					//体重
					if(!OrdEventUtil.isEmpty(dto[0].getWeight())) {
						ielisitemdto.setWeight(dto[0].getWeight().toString());
					}
					//体重单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_weight())) {
						ielisitemdto.setWeilght_unit(dto[0].getName_unit_weight());
					}
					//身高
					if(!OrdEventUtil.isEmpty(dto[0].getHeight())) {
						ielisitemdto.setHeight(dto[0].getHeight().toString());
					}
					//身高单位
					if(!OrdEventUtil.isEmpty(dto[0].getName_unit_height())) {
						ielisitemdto.setHeight_unit(dto[0].getName_unit_height());
					}
				}
			}
		} catch (BizException e) {
			ielisitemdto.setWeight("");
			ielisitemdto.setWeilght_unit("");
			ielisitemdto.setHeight("");
			ielisitemdto.setHeight_unit("");
		}
		//收费状态标识
		String id_or = ielisitemdto.getId_ielisor();
		if(StringUtils.isNotEmpty(id_or)) {
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = OrdEventHelper.getOrdSrvDO(id_or);
				if(!OrdEventUtil.isEmpty(ordSrvDOs)) {
					ielisitemdto.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				ielisitemdto.setPayflag("");
			}
		}
	}
}
