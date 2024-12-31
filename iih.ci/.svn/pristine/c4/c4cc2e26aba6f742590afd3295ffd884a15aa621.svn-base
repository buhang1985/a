package iih.ci.ord.s.bp.iemsg;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.StringUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IELisOrDTO;
import iih.ci.ord.iemsg.d.IELisOrItmDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiLisOpOrNoAcountQry;
import iih.ci.ord.s.bp.iemsg.qry.CiLisOrNoAcountQry;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * BS006：生成集成平台检验申请服务数据信息操作BP 
 * （住院）
 * 
 * 
 */
public class GetIEMsgInfo4LisNewBP {
	/**
	 * 生成集成平台检验申请服务数据信息
	 * （住院）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpLisOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		CiLisOrNoAcountQry qry = new CiLisOrNoAcountQry(id_ors);
		//获得sql串及其对应的结果集map
		String sql = qry.getQrySQLStr();
		SqlParam param = qry.getQryParameter(new StringBuffer());
		List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql,param);
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
	 * IE检验申请就诊信息DTO   IELisOrEnDTO
	 * @param ielisdto
	 * @param map
	 * @throws BizException 
	 */
	private void setLisEnDto8Map(IEOpLisOrEnDTO ieoplisdto, Map<String, Object> map) throws BizException {
      
		IEOpLisOrDTO ielisdto=new IEOpLisOrDTO();
		setLisOrDto8Map(ielisdto, map);
		FArrayList2 fa2=new FArrayList2();
		fa2.add(ielisdto);
		ieoplisdto.setDomain_id("01");//门诊住院域id都是"01"
		ieoplisdto.setId_ielisoren(CiOrdUtils.nullHandle(map.get("id_ielisoren")));
		ieoplisdto.setId_ielisors(fa2);
		ieoplisdto.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
		ieoplisdto.setP_bar_code(CiOrdUtils.nullHandle(map.get("p_bar_code")));
		ieoplisdto.setWard_code(CiOrdUtils.nullHandle(map.get("ward_code")));
		ieoplisdto.setWard_code_name(CiOrdUtils.nullHandle(map.get("ward_code_name")));
		ieoplisdto.setBed_no(CiOrdUtils.nullHandle(map.get("bed_no")));
		ieoplisdto.setSocial_no(CiOrdUtils.nullHandle(map.get("social_no")));
		ieoplisdto.setName(CiOrdUtils.nullHandle(map.get("name")));
		ieoplisdto.setHome_tel(CiOrdUtils.nullHandle(map.get("home_tel")));
		ieoplisdto.setCellphone(CiOrdUtils.nullHandle(map.get("cellphone")));
		ieoplisdto.setSex(CiOrdUtils.nullHandle(map.get("sex")));
		if(map.get("birthday")!=null){
		String ss=map.get("birthday").toString();
		FDateTime fd=new FDateTime(ss);
//			String bdstr=IemsgEventUtils.ModifyDateFormat(fd);
		ieoplisdto.setBirthday(fd);
		String ager=AgeCalcUtil.getAge(new FDate(fd.toString()));
		ieoplisdto.setAge(ager);    //该方法暂时有问题
		}
		ieoplisdto.setHome_street(CiOrdUtils.nullHandle(map.get("home_street")));
		//邮编
		ieoplisdto.setPost_code(CiOrdUtils.nullHandle(map.get("add_post_code")));
		ieoplisdto.setWork_place_code(CiOrdUtils.nullHandle(map.get("work_place_code")));
		ieoplisdto.setWork_place(CiOrdUtils.nullHandle(map.get("work_place")));
		ieoplisdto.setHospital_code(CiOrdUtils.nullHandle(map.get("hospital_code")));
		ieoplisdto.setHospital_name(CiOrdUtils.nullHandle(map.get("hospital_name")));
		ieoplisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
		ieoplisdto.setApply_doctor(CiOrdUtils.nullHandle(map.get("apply_doctor")));
		ieoplisdto.setApply_doctor_name(CiOrdUtils.nullHandle(map.get("apply_doctor_name")));
		ieoplisdto.setApply_unit(CiOrdUtils.nullHandle(map.get("apply_unit")));
		ieoplisdto.setApply_unit_name(CiOrdUtils.nullHandle(map.get("apply_unit_name")));
		ieoplisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
		ieoplisdto.setConfirm_opera(CiOrdUtils.nullHandle(map.get("confirm_opera")));
		ieoplisdto.setConfirm_opera_name(CiOrdUtils.nullHandle(map.get("confirm_opera_name")));
		ieoplisdto.setInput_begindate(map.get("input_begindate")==null?null:new FDateTime(map.get("input_begindate").toString()));
		ieoplisdto.setInput_enddate(map.get("input_enddate")==null?null:new FDateTime(map.get("input_enddate").toString()));
		ieoplisdto.setInput_opera(CiOrdUtils.nullHandle(map.get("input_opera")));
		ieoplisdto.setInput_opera_name(CiOrdUtils.nullHandle(map.get("input_opera_name")));
		ieoplisdto.setTimes(map.get("times")+"");
		ieoplisdto.setVisit_type(CiOrdUtils.nullHandle(map.get("visit_type")));
		ieoplisdto.setVisit_type_name(CiOrdUtils.nullHandle(map.get("visit_type_name")));
		ieoplisdto.setYq_code(CiOrdUtils.nullHandle(map.get("yq_code")));
		ieoplisdto.setYz_code_name(CiOrdUtils.nullHandle(map.get("yz_code_name")));
		//检查类型编码
		ieoplisdto.setDiag_type(CiOrdUtils.nullHandle(map.get("diag_type")));
		//疾病编码
		ieoplisdto.setDiag_code(CiOrdUtils.nullHandle(map.get("diag_code")));
		//疾病名称
		ieoplisdto.setDiag_str(CiOrdUtils.nullHandle(map.get("diag_str")));
		//检查类型名称
		ieoplisdto.setDiag_type_name(CiOrdUtils.nullHandle(map.get("diag_type_name")));
		ieoplisdto.setPatient_deptcode(CiOrdUtils.nullHandle(map.get("patient_deptcode")));
		ieoplisdto.setPatient_deptname(CiOrdUtils.nullHandle(map.get("patient_deptname")));
		ieoplisdto.setVisitordno(CiOrdUtils.nullHandle(map.get("visitordno")));//就诊流水号
		ieoplisdto.setVisittype(CiOrdUtils.nullHandle(map.get("visittype")));//就诊类型编码
		ieoplisdto.setVisittypename(CiOrdUtils.nullHandle(map.get("visittypename")));//就诊类型名称
		//过敏史
		ieoplisdto.setAllergy(CiOrdUtils.nullHandle(map.get("allergy")));
		//健康卡号
		ieoplisdto.setHealth_card_no(CiOrdUtils.nullHandle(map.get("health_card_no")));
	}
	/**
	 * IE检验申请信息DTO   IELisOrDTO
	 * @param ielisordto
	 * @param map
	 * @throws BizException 
	 */
	private void setLisOrDto8Map(IEOpLisOrDTO ielisordto, Map<String, Object> map) throws BizException {

		IEOpLisOrItmDTO ielisitemdto=new IEOpLisOrItmDTO();
		setLisOrItemDto8Map(ielisitemdto, map);
		FArrayList2 fa2=new FArrayList2();
		fa2.add(ielisitemdto);
		ielisordto.setId_ielisor(CiOrdUtils.nullHandle( map.get("id_ielisor")));
		ielisordto.setId_ielisoren(CiOrdUtils.nullHandle( map.get("id_ielisoren")));
		ielisordto.setId_ielisoritms(fa2);
		ielisordto.setJy_applyserial1(CiOrdUtils.nullHandle( map.get("jy_applyserial1")));
		ielisordto.setOrder_type(CiOrdUtils.nullHandle( map.get("order_type")));
		ielisordto.setOrder_type_name(CiOrdUtils.nullHandle( map.get("order_type_name")));
		ielisordto.setApply_date(map.get("apply_date")==null?null:new FDateTime(map.get("apply_date").toString()));
		ielisordto.setIs_private(CiOrdUtils.nullHandle( map.get("is_private")));
		ielisordto.setDiag_type(CiOrdUtils.nullHandle( map.get("diag_type")));
		ielisordto.setDiag_name(CiOrdUtils.nullHandle( map.get("diag_name")));
		ielisordto.setDiag_str(CiOrdUtils.nullHandle( map.get("diag_str")));
		ielisordto.setIemsgca_code(CiOrdUtils.nullHandle( map.get("iemsgca_code")));
		ielisordto.setIemsgca_name(CiOrdUtils.nullHandle( map.get("iemsgca_name")));
	}

	/**
	 * IE检验申请对应项目信息DTO IELisOrItmDTO
	 * 
	 * @param ielisitemdto
	 * @param map
	 * @throws BizException
	 */
	private void setLisOrItemDto8Map(IEOpLisOrItmDTO ielisitemdto, Map<String, Object> map) throws BizException {
		ielisitemdto.setTest_price(CiOrdUtils.nullHandle( map.get("test_price")));
		ielisitemdto.setId_ielisoritm(CiOrdUtils.nullHandle( map.get("id_ielisoritm")));
		ielisitemdto.setId_ielisor(CiOrdUtils.nullHandle( map.get("id_ielisor")));
		// ielisitemdto.setYz_no((CiOrdUtils.nullHandle( map.get("yz_no")).substring(0, 9)));
		//ielisitemdto.setYz_no(CiOrdUtils.nullHandle( map.get("jy_applyserial1")));
		ielisitemdto.setYz_no(CiOrdUtils.nullHandle( map.get("yz_no")));
		ielisitemdto.setJy_applyserial(CiOrdUtils.nullHandle( map.get("jy_applyserial")));//jy_applySerial   jy_applySerial
		ielisitemdto.setJyname(CiOrdUtils.nullHandle( map.get("jyname")));
		ielisitemdto.setPriority(CiOrdUtils.nullHandle( map.get("priority")));
		ielisitemdto.setYz_start_date(map.get("yz_start_date") == null ? null : new FDateTime(map.get("yz_start_date").toString()));
		ielisitemdto.setYz_stop_date(map.get("yz_stop_date") == null ? null : new FDateTime(map.get("yz_stop_date").toString()));
		ielisitemdto.setYz_frequency(CiOrdUtils.nullHandle( map.get("yz_frequency")));
		ielisitemdto.setYz_frequency_name(CiOrdUtils.nullHandle( map.get("yz_frequency_name")));
		ielisitemdto.setDescp_code(CiOrdUtils.nullHandle( map.get("descp_code")));
		ielisitemdto.setDescription(CiOrdUtils.nullHandle( map.get("description")));
		ielisitemdto.setCollect_ragion(CiOrdUtils.nullHandle( map.get("collect_ragion")));
		ielisitemdto.setSample_id(CiOrdUtils.nullHandle( map.get("sample_id")));
		ielisitemdto.setSample_class(CiOrdUtils.nullHandle( map.get("sample_class")));
		ielisitemdto.setSample_code_name(CiOrdUtils.nullHandle( map.get("sample_code_name")));
		ielisitemdto.setCollect_time(map.get("collect_time") == null ? null : new FDateTime(map.get("collect_time").toString()));
		ielisitemdto.setContainer_code(CiOrdUtils.nullHandle( map.get("container_code")));
		ielisitemdto.setContainer_code_name(CiOrdUtils.nullHandle( map.get("container_code_name")));
		ielisitemdto.setCollecter_code(CiOrdUtils.nullHandle( map.get("collecter_code")));
		ielisitemdto.setCollecter_code_name(CiOrdUtils.nullHandle( map.get("collecter_code_name")));
		ielisitemdto.setCollecter_place(CiOrdUtils.nullHandle( map.get("collecter_place")));
		ielisitemdto.setExec_code(CiOrdUtils.nullHandle( map.get("exec_code")));
		ielisitemdto.setExec_code_name(CiOrdUtils.nullHandle( map.get("exec_code_name")));
//		GetOrSrvPriceBP priBp = new GetOrSrvPriceBP();
//		String id_or = CiOrdUtils.nullHandle( map.get("id_ielisor"));
//		PriStdSrvDTO[] pris = priBp.exec(new String[] { id_or });
//		if(pris!=null&&pris.length>0)
//		ielisitemdto.setTest_price(pris[0].getPrice() + "");//
		ielisitemdto.setSupply_price(CiOrdUtils.nullHandle( map.get("supply_price")));
		ielisitemdto.setCommenttp(CiOrdUtils.nullHandle( map.get("commenttp")));
		ielisitemdto.setSample_request(CiOrdUtils.nullHandle( map.get("sample_request")));
		ielisitemdto.setIsstest(CiOrdUtils.nullHandle( map.get("isstest")));
		ielisitemdto.setStest(CiOrdUtils.nullHandle( map.get("stest")));
		ielisitemdto.setIs_em(CiOrdUtils.nullHandle( map.get("is_em")));
		ielisitemdto.setIs_em_r(CiOrdUtils.nullHandle( map.get("is_em_r")));
		ielisitemdto.setIsyg(CiOrdUtils.nullHandle( map.get("isyg")));
		ielisitemdto.setYg(CiOrdUtils.nullHandle( map.get("yg")));
		ielisitemdto.setOrdertimetypecode(CiOrdUtils.nullHandle(map.get("ordertimetypecode")));//医嘱时间类型编码
		ielisitemdto.setOrdertimetypename(CiOrdUtils.nullHandle(map.get("ordertimetypename")));//医嘱时间类型名称
		//TODO 根据就诊id 获取vip状态， 代码重构时再做调整
		String id_en = (String) map.get("id_ielisoren");
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			ielisitemdto.setEu_vip(vip);
		} catch (BizException e) {
			e.printStackTrace();
		}
		//是否哺乳
		ielisitemdto.setIs_breastfeeding(CiOrdUtils.nullHandle( map.get("is_breastfeeding")));
		//是否妊娠
		ielisitemdto.setIs_pregnancy(CiOrdUtils.nullHandle( map.get("is_pregnancy")));
		//妊娠时间
		ielisitemdto.setPregnancy_date(map.get("pregnancy_date")==null?null:new FDateTime(map.get("pregnancy_date").toString()));
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		try {
			if(!CiOrdUtils.isEmpty(id_en)) {
				String[] arrStrings=id_en.split(",");
				EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
				if(!CiOrdUtils.isEmpty(dto)) {
					//体重
					if(!CiOrdUtils.isEmpty(dto[0].getWeight())) {
						ielisitemdto.setWeight(dto[0].getWeight().toString());
					}
					//体重单位
					if(!CiOrdUtils.isEmpty(dto[0].getName_unit_weight())) {
						ielisitemdto.setWeilght_unit(dto[0].getName_unit_weight());
					}
					//身高
					if(!CiOrdUtils.isEmpty(dto[0].getHeight())) {
						ielisitemdto.setHeight(dto[0].getHeight().toString());
					}
					//身高单位
					if(!CiOrdUtils.isEmpty(dto[0].getName_unit_height())) {
						ielisitemdto.setHeight_unit(dto[0].getName_unit_height());
					}
				}
			}
			
		} catch (BizException e) {
			e.printStackTrace();
		}
		//收费状态标识
		String code_or = ielisitemdto.getYz_no();
		if(StringUtils.isNotEmpty(code_or)) {
			OrdSrvDO[] ordSrvDOs;
			try {
				ordSrvDOs = GetPayFlagHelper.getOrdSrvDO(CiOrderDO.CODE_OR, code_or);
				if(!CiOrdUtils.isEmpty(ordSrvDOs)) {
					ielisitemdto.setPayflag(ordSrvDOs[0].getSd_su_bl());
				}
			} catch (BizException e) {
				ielisitemdto.setPayflag("");
				e.printStackTrace();
			}
		}
	}
}
