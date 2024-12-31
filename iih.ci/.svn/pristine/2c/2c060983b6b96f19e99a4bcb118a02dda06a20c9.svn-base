package iih.ci.mr.mrserviceext.s.bp;

import iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.cimrfp.d.CiMrFpDO;
import iih.ci.mrfp.cimrfp.i.ICimrfpCudService;
import iih.ci.mrfp.cimrfp.i.ICimrfpRService;
import iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO;
import iih.ci.mrfp.hospitalfirstpagedto.d.HospitalFirstPageDTO;
import iih.ci.mrfp.hospitalfirstpagedto.d.MrfpPathologyDTO;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDORService;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpRService;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FBinary;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 	1.提供病病案首页相关数据的查询方法<br>
 * 	2.数据用于上传集成平台
 * @author YanSu
 */
public class JCPTMrFpDataBP {
	
	/**
	 * 	查询病案首页西医相关数据，返回病案首页集成平台DTO
	 * 	@param id_ent
	 * 	@return HospitalFirstPageDTO
	 * 	@throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HospitalFirstPageDTO getMrfpXYDataForIE(String id_ent) throws BizException {
//		IAmrapplyRService amrApplyService = ServiceFinder.find(IAmrapplyRService.class);
//		AmrApplyDO[] applyArr = amrApplyService.find("a0.id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();
		hospitalFirstPageDTO.setDt_message(new FDateTime());
		
//		if (applyArr.length > 0) {
//			hospitalFirstPageDTO.setType_message("1");// 修改 给集成平台发送过消息
//		} else {
//			hospitalFirstPageDTO.setType_message("0");// 新增
//		}
		// 文书集成平台患者dto服务
		ICiMrIPService IPservice = ServiceFinder.find(ICiMrIPService.class);
		CiMrPatInfoDTO[] ipDtoArr = IPservice.getCiMrPatInfoDTO(id_ent);
		
		if (ipDtoArr.length > 0) {
			CiMrPatInfoDTO mrPatInfoDto = ipDtoArr[0];
			hospitalFirstPageDTO.setCode_pat(mrPatInfoDto.getCode_pat());
			hospitalFirstPageDTO.setCode_ent(mrPatInfoDto.getCode_ent());
			hospitalFirstPageDTO.setCode_org(mrPatInfoDto.getCode_org()); // 医疗机构编码
			hospitalFirstPageDTO.setName_org(mrPatInfoDto.getOrg()); // 医疗 机构名称
			hospitalFirstPageDTO.setCode_ent_liushui(mrPatInfoDto.getCode_ent_liushui());// 就诊流水
		}
		// 病案首页主表
		ICimrfpRService cimrfpRService = ServiceFinder.find(ICimrfpRService.class);
		CiMrFpDO[] ciMrFpDOArrs = cimrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		hospitalFirstPageDTO.setCode_author("1111111111");
		hospitalFirstPageDTO.setName_author("一笑奈何");
		hospitalFirstPageDTO.setDt_author(new FDateTime());
		
		if (ciMrFpDOArrs.length > 0) {
			CiMrFpDO mrfpDo = ciMrFpDOArrs[0];
			hospitalFirstPageDTO.setCode_author(mrfpDo.getAuthor_code());
			hospitalFirstPageDTO.setName_author(mrfpDo.getAuthor_name());
			hospitalFirstPageDTO.setDt_author(mrfpDo.getDt_create());
			hospitalFirstPageDTO.setCode_zuozhe(mrfpDo.getAuthor_code());
			hospitalFirstPageDTO.setName_zuozhe(mrfpDo.getAuthor_name());
			hospitalFirstPageDTO.setFg_submit(mrfpDo.getFg_submit());
			// 集成平台上传标识
			String type_message = mrfpDo.getType_message();
			
			if ("1".equals(type_message)) {
				hospitalFirstPageDTO.setType_message("1");// 修改 给集成平台发送过消息
			} else {
				hospitalFirstPageDTO.setType_message("0");// 新增
			}
			// 获取base64
			BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
			ICimrmfileinfoRService mrmService = ServiceFinder.find(ICimrmfileinfoRService.class);
			CiMrmFileInfoDO[] doArr = mrmService.find(" id_bu_sy='" + mrfpDo.getId_mrfp() + "'", " sv desc ", FBoolean.FALSE);
			
			if (doArr.length > 0 && doArr[0].getCode_file() != null && !"~".equals(doArr[0].getCode_file())) {
				FBinary bin = fileService.read(doArr[0].getCode_file());
				// FBinary bin =
				// fileService.read("platform01/M00/01/00/rBI181r88z2EIxo8AAAAAFop6Fg2201272");
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				try {
					bin.writeBodyToStream(os);
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] bytes = os.toByteArray();
				hospitalFirstPageDTO.setCodebase64(Base64.bytes2string(bytes));
			}
		}
		// 患者信息
		IPat2mrfpRService pat2mrfpRService = ServiceFinder.find(IPat2mrfpRService.class);
		CiMrFpPatDO[] ciMrFpPatDOArrs = pat2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpPatDOArrs.length > 0) {
			CiMrFpPatDO fpPatDo = ciMrFpPatDOArrs[0];
			hospitalFirstPageDTO.setId_mrfp(fpPatDo.getId_cimrfppat());
			// 现住址
			hospitalFirstPageDTO.setAddr_home_sheng(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_shi(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_xian(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_jiedao(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_postcode(fpPatDo.getZip_addr_now());
			// 工作地址
			hospitalFirstPageDTO.setAddr_work(fpPatDo.getWorkunit());
			hospitalFirstPageDTO.setAddr_work_postcode(fpPatDo.getZip_addr_work());
			// 户口地址
			hospitalFirstPageDTO.setAddr_id_sheng(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_shi(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_xian(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_jiedao(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_postcode(fpPatDo.getZip_addr_cencus());
			// 籍贯
			hospitalFirstPageDTO.setJiguan_sheng(fpPatDo.getAddr_origin());
			hospitalFirstPageDTO.setJiguan_shi(fpPatDo.getAddr_origin());

			hospitalFirstPageDTO.setHealth_card_id(fpPatDo.getHealth_card_id());// 健康卡号
			hospitalFirstPageDTO.setTel_home(fpPatDo.getTel_addr_now());
			hospitalFirstPageDTO.setTel_work(fpPatDo.getDel_addr_work());
			hospitalFirstPageDTO.setIdcard_code(fpPatDo.getId_code());// 身份证号
			hospitalFirstPageDTO.setPatiname(fpPatDo.getName_pat());// 患者姓名
			hospitalFirstPageDTO.setCode_sex(fpPatDo.getSd_sex());
			hospitalFirstPageDTO.setName_sex(fpPatDo.getName_sex());
			hospitalFirstPageDTO.setDt_birth(fpPatDo.getDt_birth_pat()); // 出生日期
			hospitalFirstPageDTO.setPat_age(fpPatDo.getAge()); // 年龄
			hospitalFirstPageDTO.setCode_hunyin(fpPatDo.getSd_marry()); // 婚姻状况编码
			hospitalFirstPageDTO.setName_hunyin(fpPatDo.getName_marry()); // 婚姻状况
			hospitalFirstPageDTO.setCode_minzu(fpPatDo.getSd_nation()); // 民族编码
			hospitalFirstPageDTO.setName_minzu(fpPatDo.getName_nation()); // 民族
			hospitalFirstPageDTO.setAddr_chushengdi(fpPatDo.getAddr_born()); // 出生地
			hospitalFirstPageDTO.setCode_zuozhe(""); // 文档作者编码
			hospitalFirstPageDTO.setName_zuozhe(""); // 文档作者姓名
			hospitalFirstPageDTO.setCode_dianziqianzhanghao(""); // 电子签章号
			hospitalFirstPageDTO.setConnect_guanxi(fpPatDo.getName_conttp()); // 联系人-与患者关系名称
			hospitalFirstPageDTO.setConnect_addr(fpPatDo.getAddr_cont()); // 联系人-地址
			hospitalFirstPageDTO.setConnect_tel(fpPatDo.getTel_cont()); // 联系人-电话
			hospitalFirstPageDTO.setConnect_name(fpPatDo.getName_cont()); // 联系人-姓名
			hospitalFirstPageDTO.setTimes_ip(fpPatDo.getN_times_inhospital() == null ? "" : fpPatDo.getN_times_inhospital().toString()); // 住院次数
			hospitalFirstPageDTO.setCode_type_inhos(fpPatDo.getSd_referalsrc()); // 入院途径编码
			hospitalFirstPageDTO.setType_inhos_name(fpPatDo.getName_referalsrc()); // 入院途径名称
			hospitalFirstPageDTO.setDt_acpt(fpPatDo.getDt_acpt()); // 入院时间
			hospitalFirstPageDTO.setDt_end(fpPatDo.getDt_end()); // 出院时间
			hospitalFirstPageDTO.setCode_indep(fpPatDo.getDep_phyadm_code()); // 入院科室编码
			hospitalFirstPageDTO.setName_indep(fpPatDo.getDep_phyadm_name()); // 入院科室
			hospitalFirstPageDTO.setName_indepnur(fpPatDo.getName_in_bed()); // 入院病区名称
			hospitalFirstPageDTO.setCode_indepnur(fpPatDo.getSd_in_bed()); // 入院病区编码
			hospitalFirstPageDTO.setZhiye(fpPatDo.getName_occu()); // 患者职业
			hospitalFirstPageDTO.setCode_zhiye(fpPatDo.getSd_occu()); // 患者职业编码
			hospitalFirstPageDTO.setGuoji(fpPatDo.getName_country()); // 患者国籍
			hospitalFirstPageDTO.setCode_guoji(fpPatDo.getSd_country()); // 患者国籍编码
			hospitalFirstPageDTO.setNewbabytizhong_ruyuan(fpPatDo.getAddmission_weight() == null ? "" : fpPatDo.getAddmission_weight().toString()); // 新生儿入院体重
			hospitalFirstPageDTO.setNewbabytizhong_chusheng(fpPatDo.getBirth_weight() == null ? "" : fpPatDo.getBirth_weight().toString()); // 新生儿出生体重
			hospitalFirstPageDTO.setCode_outdiag(fpPatDo.getSd_outp_emer_di()); // 门诊诊断-疾病编码
			hospitalFirstPageDTO.setName_outdiag(fpPatDo.getName_outp_emer_di()); // 门诊诊断-疾病名称
			hospitalFirstPageDTO.setCode_dep_zhuanke(fpPatDo.getSd_dep_trans()); // 转科科室编码
			hospitalFirstPageDTO.setName_dep_zhuanke(fpPatDo.getName_dep_trans()); // 转科科室名称
			hospitalFirstPageDTO.setCode_byedep(fpPatDo.getSd_dep_phydisc()); // 出院科室编码
			hospitalFirstPageDTO.setName_byedep(fpPatDo.getName_dep_phydisc()); // 出院科室名称
			hospitalFirstPageDTO.setName_byenurdep(fpPatDo.getName_out_bed()); // 出院病区名称
			hospitalFirstPageDTO.setCode_byenurdep(fpPatDo.getSd_out_bed()); // 出院病区编码
			hospitalFirstPageDTO.setDays_in(fpPatDo.getHosdays() == null ? "" : (fpPatDo.getHosdays().toString())); // 实际住院天数
			hospitalFirstPageDTO.setType_pay(fpPatDo.getName_pay_method()); // 医疗付款方式名称
			hospitalFirstPageDTO.setCode_type_pay(fpPatDo.getSd_pay_method()); // 医疗付款方式编码
		}
		// 其他信息
		IOther2mrfpMDORService other2mrfpMDORService = ServiceFinder.find(IOther2mrfpMDORService.class);
		CiMrFpOtherDO[] ciMrFpOtherDOArrs = other2mrfpMDORService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpOtherDOArrs.length > 0) {
			CiMrFpOtherDO otherDo = ciMrFpOtherDOArrs[0];
			hospitalFirstPageDTO.setId_mrfp(otherDo.getId_cimrfpother());
			//hospitalFirstPageDTO.setList_reason(new FArrayList2()); // 损伤,中毒的外部原因信息
			hospitalFirstPageDTO.setSd_iioutreason(otherDo.getSd_iioutreason());
			hospitalFirstPageDTO.setName_iioutreason(otherDo.getName_iioutreason());
			MrfpPathologyDTO pathologyDto = new MrfpPathologyDTO();
			pathologyDto.setNumber_pathology(otherDo.getNum_patho());
			//hospitalFirstPageDTO.setList_pathology(new FArrayList2()); // 病理诊断信息
			hospitalFirstPageDTO.setCode_pathology(otherDo.getSd_dipathology());// 病理诊断编码
			hospitalFirstPageDTO.setName_pathology(otherDo.getName_dipathology());// 病理诊断名称
			//hospitalFirstPageDTO.setDt_hunmi_begin(""); // 颅脑损伤患者入院前昏迷时间
			//hospitalFirstPageDTO.setDt_hunmi_end(""); // 颅脑损伤患者入院后昏迷时间
			hospitalFirstPageDTO.setComa_time_bef_inhos_days(otherDo.getComa_time_bef_inhos_days());
			hospitalFirstPageDTO.setComa_time_bef_inhos_hours(otherDo.getComa_time_bef_inhos_hours());
			hospitalFirstPageDTO.setComa_time_bef_inhos_mins(otherDo.getComa_time_bef_inhos_mins());
			hospitalFirstPageDTO.setComa_time_inhos_days(otherDo.getComa_time_inhos_days());
			hospitalFirstPageDTO.setComa_time_inhos_hours(otherDo.getComa_time_inhos_hours());
			hospitalFirstPageDTO.setComa_time_inhos_mins(otherDo.getComa_time_inhos_mins());
//			hospitalFirstPageDTO.setList_otherdiag(null); // 其他诊断信息
			hospitalFirstPageDTO.setDt_byediag(null); // 出院诊断-主要诊断确诊日期
//			hospitalFirstPageDTO.setCode_byediag(null); // 出院诊断-主要诊断疾病编码
//			hospitalFirstPageDTO.setName_byediag(null); // 出院诊断-主要诊断疾病名称
//			hospitalFirstPageDTO.setCode_byediag_ruyuanbingqing(null); // 出院诊断-主要诊断入院病情编码
//			hospitalFirstPageDTO.setName_byediag_ruyuanbingqing(null); // 出院诊断-主要诊断入院病情名称 
			
			if (otherDo.getAllergic_drugs() != null) {
				hospitalFirstPageDTO.setCode_guomin("1"); // 是否药物过敏编码
				hospitalFirstPageDTO.setName_guomin("是"); // 是否药物过敏
				hospitalFirstPageDTO.setWhat_guomin(otherDo.getAllergic_drugs()); // 过敏描述
			} else {
				hospitalFirstPageDTO.setCode_guomin("0"); // 是否药物过敏编码
				hospitalFirstPageDTO.setName_guomin("否"); // 是否药物过敏
				hospitalFirstPageDTO.setWhat_guomin(otherDo.getAllergic_drugs()); // 过敏描述
			}
			hospitalFirstPageDTO.setCode_abo(otherDo.getId_blood_type()); // ABO血型编码
			hospitalFirstPageDTO.setName_abo(otherDo.getName_blood_type()); // ABO血型名称
			hospitalFirstPageDTO.setCode_rh(otherDo.getId_rh_type()); // Rh血型编码
			hospitalFirstPageDTO.setName_rh(otherDo.getName_rh_type()); // Rh血型名称
			hospitalFirstPageDTO.setList_shoushu(null); // 手术
			hospitalFirstPageDTO.setFg_shijian("1".equals(otherDo.getId_aut_dead_pat()) ? FBoolean.FALSE : FBoolean.TRUE); // 死亡患者尸检标志
			hospitalFirstPageDTO.setType_liyuan(otherDo.getName_out_hos_mode()); // 离院方式名称
			hospitalFirstPageDTO.setCode_type_liyuan(otherDo.getOut_hos_mode()); // 离院方式编码
			hospitalFirstPageDTO.setName_nijieshouyiliao(otherDo.getName_med_in_1() != null ? otherDo.getName_med_in_1() : otherDo.getName_med_in_2()); // 拟接受医疗机构名称
			hospitalFirstPageDTO.setFg_again_in("1".equals(otherDo.getId_is_have_inhos_plan()) ? FBoolean.FALSE : FBoolean.TRUE); // 出院31天内再住院标志
			hospitalFirstPageDTO.setWhy_again_in(otherDo.getGoal_inhos_plan()); // 出院31天内再住院目的
			hospitalFirstPageDTO.setBinganzhili(otherDo.getName_qom_record()); // 病案质量
			hospitalFirstPageDTO.setDt_qc(otherDo.getQc_date()); // 质控日期
			hospitalFirstPageDTO.setList_qc(new FArrayList2()); // 质控信息
			hospitalFirstPageDTO.setList_sign(new FArrayList2()); // 签名信息
			hospitalFirstPageDTO.setSd_qcp_nur(otherDo.getSd_qcp_nur()); // 质控护士(sd)
			hospitalFirstPageDTO.setName_qcp_nur(otherDo.getName_qcp_nur()); // 质控护士
			hospitalFirstPageDTO.setSd_qcp_doc(otherDo.getSd_qcp_doc()); // 质控医师
			hospitalFirstPageDTO.setName_qcp_doc(otherDo.getName_qcp_doc()); // 质控医师
			hospitalFirstPageDTO.setSd_intern_doc(otherDo.getSd_intern_doc()); // 实习医师(sd)
			hospitalFirstPageDTO.setName_intern_doc(otherDo.getName_intern_doc()); // 实习医师
			hospitalFirstPageDTO.setSd_learn_doc(otherDo.getSd_learn_doc()); // 进修医师(sd)
			hospitalFirstPageDTO.setName_learn_doc(otherDo.getName_learn_doc()); // 进修医师
			hospitalFirstPageDTO.setSd_zy_doc(otherDo.getSd_zy_doc()); // 住院医师(sd)
			hospitalFirstPageDTO.setName_zy_doc(otherDo.getName_zy_doc()); // 住院医师
			hospitalFirstPageDTO.setSd_zz_doc(otherDo.getSd_zz_doc()); // 主治医师(sd)
			hospitalFirstPageDTO.setName_zz_doc(otherDo.getName_zz_doc()); // 主治医师
			hospitalFirstPageDTO.setSd_emp_nur(otherDo.getSd_emp_nur()); // 责任护士(sd)
			hospitalFirstPageDTO.setName_emp_nur(otherDo.getName_emp_nur()); // 责任护士
			hospitalFirstPageDTO.setSd_emp_phy(otherDo.getSd_emp_phy()); // 主诊医师(sd)
			hospitalFirstPageDTO.setName_emp_phy(otherDo.getName_emp_phy()); // 主诊医师
			hospitalFirstPageDTO.setSd_zr_doc(otherDo.getSd_zr_doc()); // 主任（副主任）医师(sd)
			hospitalFirstPageDTO.setName_zr_doc(otherDo.getName_zr_doc()); // 主任（副主任）医师
			hospitalFirstPageDTO.setSd_dirofdept(otherDo.getSd_dirofdept()); // 科主任(sd)
			hospitalFirstPageDTO.setDirofdept(otherDo.getDirofdept()); // 科主任
			hospitalFirstPageDTO.setName_coder(otherDo.getName_coder()); // 编码员
			hospitalFirstPageDTO.setSd_coder(otherDo.getSd_coder()); // 编码员(sd)
		}
		// 费用信息
		IBl2mrfpRService bl2mrfpRService = ServiceFinder.find(IBl2mrfpRService.class);
		CiMrFpBlDO[] ciMrFpBlDOArrs = bl2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpBlDOArrs.length > 0) {
			CiMrFpBlDO blDo = ciMrFpBlDOArrs[0];
			hospitalFirstPageDTO.setBl_total(blDo.getAmount().toString()); // 住院总费用
			hospitalFirstPageDTO.setBl_total_zifu(blDo.getCms_spamount().toString()); // 住院总费用-自付费用
			hospitalFirstPageDTO.setBl_yibanyiliao(blDo.getCms_gmsfee().toString()); // 综合医疗服务费-一般医疗服务费
			hospitalFirstPageDTO.setBl_yibanzhiliao(blDo.getCms_gtofee().toString()); // 综合医疗服务费-一般治疗操作费
			hospitalFirstPageDTO.setBl_huli(blDo.getCms_nurfee().toString()); // 综合医疗服务费-护理费
			hospitalFirstPageDTO.setBl_qita(blDo.getCms_otherfee().toString()); // 综合医疗服务费-其他费用
			hospitalFirstPageDTO.setDiagbl_bingli(blDo.getDi_pdifee().toString()); // 诊断-病理诊断费
			hospitalFirstPageDTO.setDiagbl_shiyanshi(blDo.getDi_ldifee().toString()); // 诊断-实验室诊断费
			hospitalFirstPageDTO.setDiagbl_yingxiangxue(blDo.getDi_idifee().toString()); // 诊断-影像学诊断费
			hospitalFirstPageDTO.setDiagbl_linchuang(blDo.getDi_cdifee().toString()); // 诊断-临床诊断项目费
			hospitalFirstPageDTO.setTreatbl_feishoushu(blDo.getTc_nstpfee().toString()); // 治疗-非手术治疗项目费
			hospitalFirstPageDTO.setTreatbl_feishou_linchuang(blDo.getTc_cptfee().toString()); // 治疗-非手术治疗项目费-临床物理治疗费
			hospitalFirstPageDTO.setTreatbl_shoushu(blDo.getTc_stfee().toString()); // 治疗-手术治疗费
			hospitalFirstPageDTO.setTreatbl_shoushu_mazui(blDo.getTc_anfee().toString()); // 治疗-手术治疗费-麻醉费
			hospitalFirstPageDTO.setTreatbl_shoushu_shoushu(blDo.getTc_stfee().toString()); // 治疗-手术治疗费-手术费
			hospitalFirstPageDTO.setBl_kangfu(blDo.getRc_rcfee().toString()); // 康复费
			hospitalFirstPageDTO.setBl_zhongyi(blDo.getTcm_cmtfee().toString()); // 中医治疗费
			hospitalFirstPageDTO.setBl_xiyao(blDo.getWm_wmfee().toString()); // 西药费
			hospitalFirstPageDTO.setBl_xiyao_kangjun(blDo.getWm_agfee().toString()); // 西药费-抗菌药物费用
			hospitalFirstPageDTO.setBl_zhongyao_zhongcheng(blDo.getTcmt_cpmfee().toString()); // 中药费-中成药费
			hospitalFirstPageDTO.setBl_zhongyao_zhongcao(blDo.getTcmt_chmfee().toString()); // 中药费-中草药费
			hospitalFirstPageDTO.setBl_abo(blDo.getBabp_bfee().toString()); // 血费
			hospitalFirstPageDTO.setBl_baidanbai(blDo.getBabp_apfee().toString()); // 白蛋白类制品费
			hospitalFirstPageDTO.setBl_qidanbai(blDo.getBabp_gpfee().toString()); // 球蛋白类制品费
			hospitalFirstPageDTO.setBl_ningxueyinzi(blDo.getBabp_bcffee().toString()); // 凝血因子类制品费
			hospitalFirstPageDTO.setBl_xibaoyinzi(blDo.getBabp_cflfee().toString()); // 细胞因子类制品费
			hospitalFirstPageDTO.setBl_yici_jiancha(blDo.getSc_dmmfifee().toString()); // 一次性医用材料费-检查用
			hospitalFirstPageDTO.setBl_yici_zhiliao(blDo.getSc_dmmftfee().toString()); // 一次性医用材料费-治疗用
			hospitalFirstPageDTO.setBl_yici_shoushu(blDo.getSc_dmmfsfee().toString()); // 一次性医用材料费-手术用
			hospitalFirstPageDTO.setBl_other(blDo.getOc_ocfee().toString()); // 其他费
		}
		DAFacade daf = new DAFacade();
		// 西医诊断信息
		List<CiMrFpXydiDO> otherDiList = new ArrayList<CiMrFpXydiDO>();
		StringBuilder xySb = new StringBuilder();
		xySb.append("select xydi.id_mrfpxydi, ");
		xySb.append("       xydi.id_mrfpdi, ");
		xySb.append("       xydi.id_di, ");
		xySb.append("       xydi.sd_di, ");
		xySb.append("       xydi.name_di, ");
		xySb.append("       xydi.fg_maindi, ");
		xySb.append("       xydi.id_dislvl_inp, ");
		xySb.append("       xydi.name_dislvl_inp ");
		xySb.append("from ci_mr_fp_di di ");
		xySb.append("left join ci_mr_fp_xydi xydi ");
		xySb.append("on di.id_mrfpdi = xydi.id_mrfpdi ");
		xySb.append("where di.id_ent = ? ");
		
		SqlParam xySp = new SqlParam();
		xySp.addParam(id_ent);
		
		List<CiMrFpXydiDO> xyDiDataList = 
				(List<CiMrFpXydiDO>) daf.execQuery(xySb.toString(), xySp, new BeanListHandler(CiMrFpXydiDO.class));
		if (xyDiDataList != null && xyDiDataList.size() > 0) {
			for (CiMrFpXydiDO ciMrFpXydiDO : xyDiDataList) {
				if (ciMrFpXydiDO.getFg_maindi().booleanValue()) {
					hospitalFirstPageDTO.setCode_byediag(ciMrFpXydiDO.getSd_di()); // 出院诊断-主要诊断疾病编码
					hospitalFirstPageDTO.setName_byediag(ciMrFpXydiDO.getName_di()); // 出院诊断-主要诊断疾病名称
					String Id_dislvl_inp = ciMrFpXydiDO.getId_dislvl_inp() == null ? "" : ciMrFpXydiDO.getId_dislvl_inp().toString();
					hospitalFirstPageDTO.setCode_byediag_ruyuanbingqing(Id_dislvl_inp); // 出院诊断-主要诊断入院病情编码
					hospitalFirstPageDTO.setName_byediag_ruyuanbingqing(ciMrFpXydiDO.getName_dislvl_inp()); // 出院诊断-主要诊断入院病情名称 
				} else {
					otherDiList.add(ciMrFpXydiDO);
				}
			}
		}
		FArrayList diList = new FArrayList();
		diList.addAll(otherDiList);
		hospitalFirstPageDTO.setList_otherdiag(diList);
		// 手术信息
		ISug2mrfpRService sug2mrfpRService = ServiceFinder.find(ISug2mrfpRService.class);
		CiMrFpSugDO[] ciMrFpSugDOArrs = sug2mrfpRService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		
		if (ciMrFpSugDOArrs == null || ciMrFpSugDOArrs.length <= 0) {
			return hospitalFirstPageDTO;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("select bu.code        as sd_incicondi, ");
			sb.append("       bu.name        as name_incicondi, " );
			sb.append("       bu.pycode      as def1, " );
			//sb.append("       null           as item_version, " );
			sb.append("       bu.activestate as def2, " );
			sb.append("       sug.id_mrfpsug as id_mrfpsug " );
			sb.append("  from ci_mr_fp_sug sug " );
			sb.append("  left join bd_udidoc bu " );
			sb.append("    on sug.id_incicondi = bu.id_udidoc " );
			sb.append(" where sug.id_mrfpsug in ");
			String sqlWhere = " (";
			
			for (CiMrFpSugDO ciMrFpSugDO : ciMrFpSugDOArrs) {
				sqlWhere += "'" + ciMrFpSugDO.getId_mrfpsug() + "', ";
			}
			sqlWhere = sqlWhere.substring(0, sqlWhere.length() - 2) + ") ";
			sb.append(sqlWhere);
			List<CiMrFpSugDO> sugDataList = 
					(List<CiMrFpSugDO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrFpSugDO.class));
			
			for (CiMrFpSugDO ciMrFpSugDO : ciMrFpSugDOArrs) {
				if (ciMrFpSugDO.getId_mrfpsug() == null)
					continue;
				
				for (CiMrFpSugDO sugDO : sugDataList) {
					if (sugDO.getId_mrfpsug() == null)
						continue;
					
					if (ciMrFpSugDO.getId_mrfpsug().equals(sugDO.getId_mrfpsug())) {
						ciMrFpSugDO.setDef1(sugDO.getDef1());// 拼音吗
						ciMrFpSugDO.setDef2(sugDO.getDef2());// 停用标志
					}
				}
			}
			FArrayList list = new FArrayList();
			List<CiMrFpSugDO> asList = Arrays.asList(ciMrFpSugDOArrs);
			list.addAll(asList);
			hospitalFirstPageDTO.setLs_sug(list);
			return hospitalFirstPageDTO;
		}
	}
	
	/**
	 * 	查询病案首页中医相关数据，返回病案首页集成平台DTO
	 * 	@param id_ent
	 * 	@return HospitalFirstPageDTO
	 * 	@throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HospitalFirstPageDTO getMrfpZYDataForIE(String id_ent) throws BizException {
//		IAmrapplyRService amrApplyService = ServiceFinder.find(IAmrapplyRService.class);
//		AmrApplyDO[] applyArr = amrApplyService.find(" a0.id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();
		hospitalFirstPageDTO.setDt_message(new FDateTime());
		
//		if (applyArr.length > 0) {
//			hospitalFirstPageDTO.setType_message("1");// 修改 给集成平台发送过消息
//		} else {
//			hospitalFirstPageDTO.setType_message("0");// 新增
//		}
		// 文书集成平台患者dto服务
		ICiMrIPService IPservice = ServiceFinder.find(ICiMrIPService.class);
		CiMrPatInfoDTO[] ipDtoArr = IPservice.getCiMrPatInfoDTO(id_ent);
		
		if (ipDtoArr.length > 0) {
			CiMrPatInfoDTO mrPatInfoDto = ipDtoArr[0];
			hospitalFirstPageDTO.setCode_pat(mrPatInfoDto.getCode_pat());
			hospitalFirstPageDTO.setCode_ent(mrPatInfoDto.getCode_ent());
			hospitalFirstPageDTO.setCode_org(mrPatInfoDto.getCode_org()); // 医疗机构编码
			hospitalFirstPageDTO.setName_org(mrPatInfoDto.getOrg()); // 医疗 机构名称
			hospitalFirstPageDTO.setCode_ent_liushui(mrPatInfoDto.getCode_ent_liushui());// 就诊流水
		}
		// 病案首页主表
		ICimrfpRService cimrfpRService = ServiceFinder.find(ICimrfpRService.class);
		CiMrFpDO[] ciMrFpDOArrs = cimrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		hospitalFirstPageDTO.setCode_author("1111111111");
		hospitalFirstPageDTO.setName_author("一笑奈何");
		hospitalFirstPageDTO.setDt_author(new FDateTime());
		
		if (ciMrFpDOArrs.length > 0) {
			CiMrFpDO mrfpDo = ciMrFpDOArrs[0];
			hospitalFirstPageDTO.setCode_author(mrfpDo.getAuthor_code());
			hospitalFirstPageDTO.setName_author(mrfpDo.getAuthor_name());
			hospitalFirstPageDTO.setDt_author(mrfpDo.getDt_create());
			hospitalFirstPageDTO.setCode_zuozhe(mrfpDo.getAuthor_code());
			hospitalFirstPageDTO.setName_zuozhe(mrfpDo.getAuthor_name());
			hospitalFirstPageDTO.setFg_submit(mrfpDo.getFg_submit());
			// 集成平台上传标识
			String type_message = mrfpDo.getType_message();
			
			if ("1".equals(type_message)) {
				hospitalFirstPageDTO.setType_message("1");// 修改 给集成平台发送过消息
			} else {
				hospitalFirstPageDTO.setType_message("0");// 新增
			}
			// 获取base64
			BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
			ICimrmfileinfoRService mrmService = ServiceFinder.find(ICimrmfileinfoRService.class);
			CiMrmFileInfoDO[] doArr = mrmService.find(" id_bu_sy='" + mrfpDo.getId_mrfp() + "'", " sv desc ", FBoolean.FALSE);
			
			if (doArr.length > 0 && doArr[0].getCode_file() != null && !"~".equals(doArr[0].getCode_file())) {
				FBinary bin = fileService.read(doArr[0].getCode_file());
				// FBinary bin =
				// fileService.read("platform01/M00/01/00/rBI181r88z2EIxo8AAAAAFop6Fg2201272");
				ByteArrayOutputStream os = new ByteArrayOutputStream();
				try {
					bin.writeBodyToStream(os);
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] bytes = os.toByteArray();
				hospitalFirstPageDTO.setCodebase64(Base64.bytes2string(bytes));
			}
		}
		// 患者信息
		IPat2mrfpRService pat2mrfpRService = ServiceFinder.find(IPat2mrfpRService.class);
		CiMrFpPatDO[] ciMrFpPatDOArrs = pat2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpPatDOArrs.length > 0) {
			CiMrFpPatDO fpPatDo = ciMrFpPatDOArrs[0];
			hospitalFirstPageDTO.setId_mrfp(fpPatDo.getId_cimrfppat());
			// 现住址
			hospitalFirstPageDTO.setAddr_home_sheng(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_shi(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_xian(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_jiedao(fpPatDo.getAddr_now());
			hospitalFirstPageDTO.setAddr_home_postcode(fpPatDo.getZip_addr_now());
			// 工作地址
			hospitalFirstPageDTO.setAddr_work(fpPatDo.getAddr_work());
			hospitalFirstPageDTO.setAddr_work_postcode(fpPatDo.getZip_addr_work());
			// 户口地址
			hospitalFirstPageDTO.setAddr_id_sheng(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_shi(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_xian(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_jiedao(fpPatDo.getAddr_cencus());
			hospitalFirstPageDTO.setAddr_id_postcode(fpPatDo.getZip_addr_cencus());
			// 籍贯
			hospitalFirstPageDTO.setJiguan_sheng(fpPatDo.getAddr_origin());
			hospitalFirstPageDTO.setJiguan_shi(fpPatDo.getAddr_origin());

			hospitalFirstPageDTO.setHealth_card_id(fpPatDo.getHealth_card_id());// 健康卡号
			hospitalFirstPageDTO.setTel_home(fpPatDo.getTel_addr_now());
			hospitalFirstPageDTO.setTel_work(fpPatDo.getDel_addr_work());
			hospitalFirstPageDTO.setIdcard_code(fpPatDo.getId_code());// 身份证号
			hospitalFirstPageDTO.setPatiname(fpPatDo.getName_pat());// 患者姓名
			hospitalFirstPageDTO.setCode_sex(fpPatDo.getSd_sex());
			hospitalFirstPageDTO.setName_sex(fpPatDo.getName_sex());
			hospitalFirstPageDTO.setDt_birth(fpPatDo.getDt_birth_pat()); // 出生日期
			hospitalFirstPageDTO.setPat_age(fpPatDo.getAge()); // 年龄
			hospitalFirstPageDTO.setCode_hunyin(fpPatDo.getSd_marry()); // 婚姻状况编码
			hospitalFirstPageDTO.setName_hunyin(fpPatDo.getName_marry()); // 婚姻状况
			hospitalFirstPageDTO.setCode_minzu(fpPatDo.getSd_nation()); // 民族编码
			hospitalFirstPageDTO.setName_minzu(fpPatDo.getName_nation()); // 民族
			hospitalFirstPageDTO.setAddr_chushengdi(fpPatDo.getAddr_born()); // 出生地
			hospitalFirstPageDTO.setCode_zuozhe(""); // 文档作者编码
			hospitalFirstPageDTO.setName_zuozhe(""); // 文档作者姓名
			hospitalFirstPageDTO.setCode_dianziqianzhanghao(""); // 电子签章号
			hospitalFirstPageDTO.setConnect_guanxi(fpPatDo.getName_conttp()); // 联系人-与患者关系名称
			hospitalFirstPageDTO.setConnect_addr(fpPatDo.getAddr_cont()); // 联系人-地址
			hospitalFirstPageDTO.setConnect_tel(fpPatDo.getTel_cont()); // 联系人-电话
			hospitalFirstPageDTO.setConnect_name(fpPatDo.getName_cont()); // 联系人-姓名
			hospitalFirstPageDTO.setTimes_ip(fpPatDo.getN_times_inhospital() == null ? "" : fpPatDo.getN_times_inhospital().toString()); // 住院次数
			hospitalFirstPageDTO.setCode_type_inhos(fpPatDo.getSd_referalsrc()); // 入院途径编码
			hospitalFirstPageDTO.setType_inhos_name(fpPatDo.getName_referalsrc()); // 入院途径名称
			hospitalFirstPageDTO.setDt_acpt(fpPatDo.getDt_acpt()); // 入院时间
			hospitalFirstPageDTO.setDt_end(fpPatDo.getDt_end()); // 出院时间
			hospitalFirstPageDTO.setCode_indep(fpPatDo.getDep_phyadm_code()); // 入院科室编码
			hospitalFirstPageDTO.setName_indep(fpPatDo.getDep_phyadm_name()); // 入院科室
			hospitalFirstPageDTO.setName_indepnur(fpPatDo.getName_in_bed()); // 入院病区名称
			hospitalFirstPageDTO.setCode_indepnur(fpPatDo.getSd_in_bed()); // 入院病区编码
			hospitalFirstPageDTO.setZhiye(fpPatDo.getName_occu()); // 患者职业
			hospitalFirstPageDTO.setCode_zhiye(fpPatDo.getSd_occu()); // 患者职业编码
			hospitalFirstPageDTO.setGuoji(fpPatDo.getName_country()); // 患者国籍
			hospitalFirstPageDTO.setCode_guoji(fpPatDo.getSd_country()); // 患者国籍编码
			hospitalFirstPageDTO.setNewbabytizhong_ruyuan(fpPatDo.getAddmission_weight() == null ? "" : fpPatDo.getAddmission_weight().toString()); // 新生儿入院体重
			hospitalFirstPageDTO.setNewbabytizhong_chusheng(fpPatDo.getBirth_weight() == null ? "" : fpPatDo.getBirth_weight().toString()); // 新生儿出生体重
			hospitalFirstPageDTO.setCode_outdiag(fpPatDo.getSd_outp_emer_di()); // 门诊诊断-疾病编码
			hospitalFirstPageDTO.setName_outdiag(fpPatDo.getName_outp_emer_di()); // 门诊诊断-疾病名称
			hospitalFirstPageDTO.setCode_cm_outdiag(fpPatDo.getSd_outp_cm_di()); // 门诊诊断（中医诊断）-疾病编码
			hospitalFirstPageDTO.setName_cm_outdiag(fpPatDo.getName_outp_cm_di()); // 门诊诊断（中医诊断）-疾病名称
			hospitalFirstPageDTO.setCode_cm_symptom(fpPatDo.getCode_cm_symptom());// 门诊诊断-中医证候编码
			hospitalFirstPageDTO.setName_cm_symptom(fpPatDo.getName_cm_symptom());// 门诊诊断-中医证候名称
			hospitalFirstPageDTO.setCode_dep_zhuanke(fpPatDo.getSd_dep_trans()); // 转科科室编码
			hospitalFirstPageDTO.setName_dep_zhuanke(fpPatDo.getName_dep_trans()); // 转科科室名称
			hospitalFirstPageDTO.setCode_byedep(fpPatDo.getSd_dep_phydisc()); // 出院科室编码
			hospitalFirstPageDTO.setName_byedep(fpPatDo.getName_dep_phydisc()); // 出院科室名称
			hospitalFirstPageDTO.setName_byenurdep(fpPatDo.getName_out_bed()); // 出院病区名称
			hospitalFirstPageDTO.setCode_byenurdep(fpPatDo.getSd_out_bed()); // 出院病区编码
			hospitalFirstPageDTO.setDays_in(fpPatDo.getHosdays() == null ? "" : (fpPatDo.getHosdays().toString())); // 实际住院天数
			hospitalFirstPageDTO.setType_pay(fpPatDo.getName_pay_method()); // 医疗付款方式名称
			hospitalFirstPageDTO.setCode_type_pay(fpPatDo.getSd_pay_method()); // 医疗付款方式编码
		}
		// 其他信息
		IOther2mrfpMDORService other2mrfpMDORService = ServiceFinder.find(IOther2mrfpMDORService.class);
		CiMrFpOtherDO[] ciMrFpOtherDOArrs = other2mrfpMDORService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpOtherDOArrs.length > 0) {
			CiMrFpOtherDO otherDo = ciMrFpOtherDOArrs[0];
			hospitalFirstPageDTO.setId_mrfp(otherDo.getId_cimrfpother());
			//hospitalFirstPageDTO.setList_reason(new FArrayList2()); // 损伤,中毒的外部原因信息
			hospitalFirstPageDTO.setSd_iioutreason(otherDo.getSd_iioutreason());
			hospitalFirstPageDTO.setName_iioutreason(otherDo.getName_iioutreason());
			MrfpPathologyDTO pathologyDto = new MrfpPathologyDTO();
			pathologyDto.setNumber_pathology(otherDo.getNum_patho());
			//hospitalFirstPageDTO.setList_pathology(new FArrayList2()); // 病理诊断信息
			hospitalFirstPageDTO.setCode_pathology(otherDo.getSd_dipathology());// 病理诊断编码
			hospitalFirstPageDTO.setName_pathology(otherDo.getName_dipathology());// 病理诊断名称
			//hospitalFirstPageDTO.setDt_hunmi_begin(""); // 颅脑损伤患者入院前昏迷时间
			//hospitalFirstPageDTO.setDt_hunmi_end(""); // 颅脑损伤患者入院后昏迷时间
			hospitalFirstPageDTO.setComa_time_bef_inhos_days(otherDo.getComa_time_bef_inhos_days());
			hospitalFirstPageDTO.setComa_time_bef_inhos_hours(otherDo.getComa_time_bef_inhos_hours());
			hospitalFirstPageDTO.setComa_time_bef_inhos_mins(otherDo.getComa_time_bef_inhos_mins());
			hospitalFirstPageDTO.setComa_time_inhos_days(otherDo.getComa_time_inhos_days());
			hospitalFirstPageDTO.setComa_time_inhos_hours(otherDo.getComa_time_inhos_hours());
			hospitalFirstPageDTO.setComa_time_inhos_mins(otherDo.getComa_time_inhos_mins());
			hospitalFirstPageDTO.setList_otherdiag(null); // 其他诊断信息
			hospitalFirstPageDTO.setDt_byediag(null); // 出院诊断-主要诊断确诊日期
			hospitalFirstPageDTO.setCode_byediag(otherDo.getCode_byediag()); // 出院诊断-主要诊断疾病编码
			hospitalFirstPageDTO.setName_byediag(otherDo.getName_byediag()); // 出院诊断-主要诊断疾病名称
			hospitalFirstPageDTO.setCode_byediag_ruyuanbingqing(null); // 出院诊断-主要诊断入院病情编码
			hospitalFirstPageDTO.setName_byediag_ruyuanbingqing(null); // 出院诊断-主要诊断入院病情名称 
			hospitalFirstPageDTO.setCode_cm_mainill(otherDo.getCode_cm_mainill());// 中医出院诊断_主病编码
			hospitalFirstPageDTO.setName_cm_mainill(otherDo.getName_cm_mainill());// 中医出院诊断_主病名称
			hospitalFirstPageDTO.setCode_cm_mainsym(otherDo.getCode_cm_mainsym());// 中医出院诊断_主症编码
			hospitalFirstPageDTO.setName_cm_mainsym(otherDo.getName_cm_mainsym());// 中医出院诊断_主症名称
			
			if (otherDo.getAllergic_drugs() != null) {
				hospitalFirstPageDTO.setCode_guomin("1"); // 是否药物过敏编码
				hospitalFirstPageDTO.setName_guomin("是"); // 是否药物过敏
				hospitalFirstPageDTO.setWhat_guomin(otherDo.getAllergic_drugs()); // 过敏描述
			} else {
				hospitalFirstPageDTO.setCode_guomin("0"); // 是否药物过敏编码
				hospitalFirstPageDTO.setName_guomin("否"); // 是否药物过敏
				hospitalFirstPageDTO.setWhat_guomin(otherDo.getAllergic_drugs()); // 过敏描述
			}
			hospitalFirstPageDTO.setCode_abo(otherDo.getId_blood_type()); // ABO血型编码
			hospitalFirstPageDTO.setName_abo(otherDo.getName_blood_type()); // ABO血型名称
			hospitalFirstPageDTO.setCode_rh(otherDo.getId_rh_type()); // Rh血型编码
			hospitalFirstPageDTO.setName_rh(otherDo.getName_rh_type()); // Rh血型名称
			hospitalFirstPageDTO.setList_shoushu(null); // 手术
			hospitalFirstPageDTO.setFg_shijian("1".equals(otherDo.getId_aut_dead_pat()) ? FBoolean.FALSE : FBoolean.TRUE); // 死亡患者尸检标志
			hospitalFirstPageDTO.setType_liyuan(otherDo.getName_out_hos_mode()); // 离院方式名称
			hospitalFirstPageDTO.setCode_type_liyuan(otherDo.getOut_hos_mode()); // 离院方式编码
			hospitalFirstPageDTO.setName_nijieshouyiliao(otherDo.getName_med_in_1() != null ? otherDo.getName_med_in_1() : otherDo.getName_med_in_2()); // 拟接受医疗机构名称
			hospitalFirstPageDTO.setFg_again_in("1".equals(otherDo.getId_is_have_inhos_plan()) ? FBoolean.FALSE : FBoolean.TRUE); // 出院31天内再住院标志
			hospitalFirstPageDTO.setWhy_again_in(otherDo.getGoal_inhos_plan()); // 出院31天内再住院目的
			hospitalFirstPageDTO.setBinganzhili(otherDo.getName_qom_record()); // 病案质量
			hospitalFirstPageDTO.setDt_qc(otherDo.getQc_date()); // 质控日期
			hospitalFirstPageDTO.setList_qc(new FArrayList2()); // 质控信息
			hospitalFirstPageDTO.setList_sign(new FArrayList2()); // 签名信息
			hospitalFirstPageDTO.setSd_qcp_nur(otherDo.getSd_qcp_nur()); // 质控护士(sd)
			hospitalFirstPageDTO.setName_qcp_nur(otherDo.getName_qcp_nur()); // 质控护士
			hospitalFirstPageDTO.setSd_qcp_doc(otherDo.getSd_qcp_doc()); // 质控医师
			hospitalFirstPageDTO.setName_qcp_doc(otherDo.getName_qcp_doc()); // 质控医师
			hospitalFirstPageDTO.setSd_intern_doc(otherDo.getSd_intern_doc()); // 实习医师(sd)
			hospitalFirstPageDTO.setName_intern_doc(otherDo.getName_intern_doc()); // 实习医师
			hospitalFirstPageDTO.setSd_learn_doc(otherDo.getSd_learn_doc()); // 进修医师(sd)
			hospitalFirstPageDTO.setName_learn_doc(otherDo.getName_learn_doc()); // 进修医师
			hospitalFirstPageDTO.setSd_zy_doc(otherDo.getSd_zy_doc()); // 住院医师(sd)
			hospitalFirstPageDTO.setName_zy_doc(otherDo.getName_zy_doc()); // 住院医师
			hospitalFirstPageDTO.setSd_zz_doc(otherDo.getSd_zz_doc()); // 主治医师(sd)
			hospitalFirstPageDTO.setName_zz_doc(otherDo.getName_zz_doc()); // 主治医师
			hospitalFirstPageDTO.setSd_emp_nur(otherDo.getSd_emp_nur()); // 责任护士(sd)
			hospitalFirstPageDTO.setName_emp_nur(otherDo.getName_emp_nur()); // 责任护士
			hospitalFirstPageDTO.setSd_emp_phy(otherDo.getSd_emp_phy()); // 主诊医师(sd)
			hospitalFirstPageDTO.setName_emp_phy(otherDo.getName_emp_phy()); // 主诊医师
			hospitalFirstPageDTO.setSd_zr_doc(otherDo.getSd_zr_doc()); // 主任（副主任）医师(sd)
			hospitalFirstPageDTO.setName_zr_doc(otherDo.getName_zr_doc()); // 主任（副主任）医师
			hospitalFirstPageDTO.setSd_dirofdept(otherDo.getSd_dirofdept()); // 科主任(sd)
			hospitalFirstPageDTO.setDirofdept(otherDo.getDirofdept()); // 科主任
			hospitalFirstPageDTO.setName_coder(otherDo.getName_coder()); // 编码员
			hospitalFirstPageDTO.setSd_coder(otherDo.getSd_coder()); // 编码员(sd)
		}
		IBl2mrfpRService bl2mrfpRService = ServiceFinder.find(IBl2mrfpRService.class);
		CiMrFpBlDO[] ciMrFpBlDOArrs = bl2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		
		if (ciMrFpBlDOArrs.length > 0) {
			CiMrFpBlDO blDo = ciMrFpBlDOArrs[0];
			hospitalFirstPageDTO.setBl_total(blDo.getAmount().toString());// 住院总费用
			hospitalFirstPageDTO.setBl_total_zifu(blDo.getCms_spamount().toString());// 住院总费用-自付费用
			hospitalFirstPageDTO.setBl_yibanyiliao(blDo.getCms_gmsfee().toString());// 综合医疗服务费-一般医疗服务费
			hospitalFirstPageDTO.setBl_yibanzhiliao(blDo.getCms_gtofee().toString());// 综合医疗服务费-一般治疗操作费
			hospitalFirstPageDTO.setBl_huli(blDo.getCms_nurfee().toString());// 综合医疗服务费-护理费
			hospitalFirstPageDTO.setBl_qita(blDo.getCms_otherfee().toString());// 综合医疗服务费-其他费用
			hospitalFirstPageDTO.setDiagbl_bingli(blDo.getDi_pdifee().toString());// 诊断-病理诊断费
			hospitalFirstPageDTO.setDiagbl_shiyanshi(blDo.getDi_ldifee().toString());// 诊断-实验室诊断费
			hospitalFirstPageDTO.setDiagbl_yingxiangxue(blDo.getDi_idifee().toString());// 诊断-影像学诊断费
			hospitalFirstPageDTO.setDiagbl_linchuang(blDo.getDi_cdifee().toString());// 诊断-临床诊断项目费
			hospitalFirstPageDTO.setTreatbl_feishoushu(blDo.getTc_nstpfee().toString());// 治疗-非手术治疗项目费
			hospitalFirstPageDTO.setTreatbl_feishou_linchuang(blDo.getTc_cptfee().toString());// 治疗-非手术治疗项目费-临床物理治疗费
			hospitalFirstPageDTO.setTreatbl_shoushu(blDo.getTc_stfee().toString());// 治疗-手术治疗费
			hospitalFirstPageDTO.setTreatbl_shoushu_mazui(blDo.getTc_anfee().toString());// 治疗-手术治疗费-麻醉费
			hospitalFirstPageDTO.setTreatbl_shoushu_shoushu(blDo.getTc_stfee().toString());// 治疗-手术治疗费-手术费
			hospitalFirstPageDTO.setBl_kangfu(blDo.getRc_rcfee().toString());// 康复费
			hospitalFirstPageDTO.setBl_zhongyi(blDo.getTcm_cmtfee().toString());// 中医治疗费
			hospitalFirstPageDTO.setBl_xiyao(blDo.getWm_wmfee().toString());// 西药费
			hospitalFirstPageDTO.setBl_xiyao_kangjun(blDo.getWm_agfee().toString());// 西药费-抗菌药物费用
			hospitalFirstPageDTO.setBl_zhongyao_zhongcheng(blDo.getTcmt_cpmfee().toString());// 中药费-中成药费
			hospitalFirstPageDTO.setBl_zhongyao_zhongcao(blDo.getTcmt_chmfee().toString());// 中药费-中草药费
			hospitalFirstPageDTO.setBl_abo(blDo.getBabp_bfee().toString());// 血费
			hospitalFirstPageDTO.setBl_baidanbai(blDo.getBabp_apfee().toString());// 白蛋白类制品费
			hospitalFirstPageDTO.setBl_qidanbai(blDo.getBabp_gpfee().toString());// 球蛋白类制品费
			hospitalFirstPageDTO.setBl_ningxueyinzi(blDo.getBabp_bcffee().toString());// 凝血因子类制品费
			hospitalFirstPageDTO.setBl_xibaoyinzi(blDo.getBabp_cflfee().toString());// 细胞因子类制品费
			hospitalFirstPageDTO.setBl_yici_jiancha(blDo.getSc_dmmfifee().toString());// 一次性医用材料费-检查用
			hospitalFirstPageDTO.setBl_yici_zhiliao(blDo.getSc_dmmftfee().toString());// 一次性医用材料费-治疗用
			hospitalFirstPageDTO.setBl_yici_shoushu(blDo.getSc_dmmfsfee().toString());// 一次性医用材料费-手术用
			hospitalFirstPageDTO.setBl_other(blDo.getOc_ocfee().toString());// 其他费
			hospitalFirstPageDTO.setCms_decnfee(blDo.getCms_decnfee().toString());// 综合医疗服务类_中医辨证论治费
			hospitalFirstPageDTO.setCms_decfee(blDo.getCms_decfee().toString());// 综合医疗服务类_中医辨证论治会诊费
			hospitalFirstPageDTO.setTcm_difee(blDo.getTcm_difee().toString());// 中医类_中医诊断费
			hospitalFirstPageDTO.setTcm_etfee(blDo.getTcm_etfee().toString());// 中医类_外治费
			hospitalFirstPageDTO.setTcm_bffee(blDo.getTcm_bffee().toString());// 中医类_骨伤费
			hospitalFirstPageDTO.setTcm_tcmfee(blDo.getTcm_tcmfee().toString());// 中医类_针刺与灸法费
			hospitalFirstPageDTO.setTcm_mnpfee(blDo.getTcm_mnpfee().toString());// 中医类_推拿治疗费
			hospitalFirstPageDTO.setTcm_anrfee(blDo.getTcm_anrfee().toString());// 中医类_肛肠治疗费
			hospitalFirstPageDTO.setTcm_spcialfee(blDo.getTcm_spcialfee().toString());// 中医类_特殊治疗费
			hospitalFirstPageDTO.setTcm_otherfee(blDo.getTcm_otherfee().toString());// 中医类_其他费
			hospitalFirstPageDTO.setTcm_allocationfee(blDo.getTcm_allocationfee().toString());// 中医类_特殊调配加工费
			hospitalFirstPageDTO.setTcm_dcfee(blDo.getTcm_dcfee().toString());// 中医类_辨证施膳费
			hospitalFirstPageDTO.setTcmt_ppafee(blDo.getTcmt_ppafee().toString());// 中药类_制剂费
		}
		// 手术信息
		ISug2mrfpRService sug2mrfpRService = ServiceFinder.find(ISug2mrfpRService.class);
		CiMrFpSugDO[] ciMrFpSugDOArrs = sug2mrfpRService.find(" id_ent = '" + id_ent + "' ", "", FBoolean.FALSE);
		
		if (ciMrFpSugDOArrs == null || ciMrFpSugDOArrs.length <= 0) {
			return hospitalFirstPageDTO;
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("select bu.code        as sd_incicondi, ");
			sb.append("       bu.name        as name_incicondi, " );
			sb.append("       bu.pycode      as def1, " );
			//sb.append("       null           as item_version, " );
			sb.append("       bu.activestate as def2, " );
			sb.append("       sug.id_mrfpsug as id_mrfpsug " );
			sb.append("  from ci_mr_fp_sug sug " );
			sb.append("  left join bd_udidoc bu " );
			sb.append("    on sug.id_incicondi = bu.id_udidoc " );
			sb.append(" where sug.id_mrfpsug in ");
			String sqlWhere = " (";
			
			for (CiMrFpSugDO ciMrFpSugDO : ciMrFpSugDOArrs) {
				sqlWhere += "'" + ciMrFpSugDO.getId_mrfpsug() + "', ";
			}
			sqlWhere = sqlWhere.substring(0, sqlWhere.length() - 2) + ") ";
			sb.append(sqlWhere);
			DAFacade daf = new DAFacade();
			List<CiMrFpSugDO> sugDataList = 
					(List<CiMrFpSugDO>) daf.execQuery(sb.toString(), new BeanListHandler(CiMrFpSugDO.class));
			
			for (CiMrFpSugDO ciMrFpSugDO : ciMrFpSugDOArrs) {
				if (ciMrFpSugDO.getId_mrfpsug() == null)
					continue;
				
				for (CiMrFpSugDO sugDO : sugDataList) {
					if (sugDO.getId_mrfpsug() == null)
						continue;
					
					if (ciMrFpSugDO.getId_mrfpsug().equals(sugDO.getId_mrfpsug())) {
						ciMrFpSugDO.setDef1(sugDO.getDef1());// 拼音吗
						ciMrFpSugDO.setDef2(sugDO.getDef2());// 停用标志
					}
				}
			}
			FArrayList list = new FArrayList();
			List<CiMrFpSugDO> asList = Arrays.asList(ciMrFpSugDOArrs);
			list.addAll(asList);
			hospitalFirstPageDTO.setLs_sug(list);
			return hospitalFirstPageDTO;
		}
	}
	
	/**
	 * 更新病案首页主表中的集成平台上传标识（上传后更新为已上传状态）
	 * @param idEnt
	 * @throws BizException
	 */
	public void updateFlagForMrFpUpload(String idEnt) throws BizException {
		ICimrfpRService mrfpRService = ServiceFinder.find(ICimrfpRService.class);
		ICimrfpCudService mrfpCudService = ServiceFinder.find(ICimrfpCudService.class);
		
		CiMrFpDO[] ciMrFpDOs = mrfpRService.find(" id_ent = '" + idEnt + "' ", "", FBoolean.FALSE);
		// 如果因id_ent问题或病案首页数据问题导致没有查询结果，则不修改上传状态  - by Vampire 2020.3.8
		if (ciMrFpDOs != null && ciMrFpDOs.length > 0) {
			CiMrFpDO ciMrFpDO = ciMrFpDOs[0];
			ciMrFpDO.setType_message("1");
			mrfpCudService.update(new CiMrFpDO[]{ ciMrFpDO });
		}
	}
	
}
