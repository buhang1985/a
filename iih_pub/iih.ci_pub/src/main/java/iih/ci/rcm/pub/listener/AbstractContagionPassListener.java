package iih.ci.rcm.pub.listener;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.rcm.contagion.d.AidsDO;
import iih.ci.rcm.contagion.d.ContagionDO;
import iih.ci.rcm.contagion.d.HFMDO;
import iih.ci.rcm.contagion.d.HepatitisBDO;
import iih.ci.rcm.contagion.d.StdDO;
import iih.ci.rcm.contagion.d.SyphilisDO;
import iih.ci.rcm.contagion.i.IAidsDORService;
import iih.ci.rcm.contagion.i.IHFMDORService;
import iih.ci.rcm.contagion.i.IHepatitisBDORService;
import iih.ci.rcm.contagion.i.IStdDORService;
import iih.ci.rcm.contagion.i.ISyphilisDORService;
import iih.ci.rcm.contagionmessage.d.ContagionMessageDTO;
import iih.ci.rcm.hospitalcontagiondto.d.HospitalContagionDTO;
import iih.ci.rcm.pub.ReportConst.IReportPubConst;

import java.util.Arrays;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;

public class AbstractContagionPassListener extends AbstractContagionDOUpdateAfterListener {
	@SuppressWarnings("unchecked")
	@Override
	protected void doActionCiMrDOChange(ContagionDO[] contagionDOs) throws BizException {
		for(ContagionDO contagionDO:contagionDOs){

			if (contagionDO == null || contagionDO.getId_con_cardsu() == null
					|| !(IReportPubConst.Id_con_cardsu_ok.contains(contagionDO.getId_con_cardsu())||
							IReportPubConst.Id_con_cardsu_tj.contains(contagionDO.getId_con_cardsu()))) {
				continue;
			}
			// 根据传染病选择情况，对传染病分类字段赋值
			if (contagionDO.getEu_jlcrb() != null) {
				contagionDO.setCode_crbfl("01");
				contagionDO.setName_crbfl("甲类传染病");
			} else if (contagionDO.getEu_ylcrb() != null) {
				contagionDO.setCode_crbfl("02");
				contagionDO.setName_crbfl("乙类传染病");
			} else if (contagionDO.getEu_blcrb() != null) {
				contagionDO.setCode_crbfl("03");
				contagionDO.setName_crbfl("丙类传染病");
			} else {
				contagionDO.setCode_crbfl("99");
				contagionDO.setName_crbfl("其他传染病");
			}
			HospitalContagionDTO hospitalContagionDTO = new HospitalContagionDTO();
			hospitalContagionDTO.setId_contagion(contagionDO.getId_contagion());

			FArrayList list = new FArrayList();
			list.addAll(Arrays.asList(contagionDO));
			hospitalContagionDTO.setLs_contagion(list);
			// 用于封装传染病副卡的简单信息
			FArrayList crbfkList = new FArrayList();
			// 性病副卡
			IStdDORService std = ServiceFinder.find(IStdDORService.class);
			StdDO[] stds = std.find("a1.id_contagion = '" + contagionDO.getId_contagion() + "'", null, FBoolean.FALSE);
			FArrayList list1 = new FArrayList();

			if (stds != null && stds.length > 0) {
				list1.add(stds[0]);
				// 赋值需要上传的传染病副卡简单信息
				ContagionMessageDTO msgDTO = new ContagionMessageDTO();
				msgDTO.setId_contagion(stds[0].getId_contagion_std());
				msgDTO.setName_disease("性病附卡");
				msgDTO.setDef1(stds[0].getSd_conclusion());// 实验室检测结果编码
				msgDTO.setDef2(stds[0].getName_conclusion());// 实验室检测结果名称
				crbfkList.add(msgDTO);
			}
			hospitalContagionDTO.setLs_std(list1);
			// 梅毒副卡
			ISyphilisDORService syphilis = ServiceFinder.find(ISyphilisDORService.class);
			SyphilisDO[] syphs = syphilis.find("a3.id_contagion = '" + contagionDO.getId_contagion() + "'", null, FBoolean.FALSE);
			FArrayList list2 = new FArrayList();

			if (syphs != null && syphs.length > 0) {
				list2.add(syphs[0]);
				// 赋值需要上传的传染病副卡简单信息
				ContagionMessageDTO msgDTO = new ContagionMessageDTO();
				msgDTO.setId_contagion(syphs[0].getId_contagion_ss());
				msgDTO.setName_disease("梅毒附卡");
				msgDTO.setDef1("");//
				msgDTO.setDef2(syphs[0].getSyphilis_result());// 梅毒检验结果
				crbfkList.add(msgDTO);
			}
			hospitalContagionDTO.setLs_syphilis(list2);
			// 手足口副卡
			IHFMDORService hfm = ServiceFinder.find(IHFMDORService.class);
			HFMDO[] hfms = hfm.find("a4.id_contagion = '" + contagionDO.getId_contagion() + "'", null, FBoolean.FALSE);
			FArrayList list3 = new FArrayList();

			if (hfms != null && hfms.length > 0) {
				list3.add(hfms[0]);
				// 赋值需要上传的传染病副卡简单信息
				ContagionMessageDTO msgDTO = new ContagionMessageDTO();
				msgDTO.setId_contagion(hfms[0].getId_contagion_hfm());
				msgDTO.setName_disease("手足口附卡");
				msgDTO.setDef1(hfms[0].getCode_hfm_result());// 实验室结果编码
				msgDTO.setDef2(hfms[0].getName_hfm_result());// 实验室结果名称
				crbfkList.add(msgDTO);
			}
			hospitalContagionDTO.setLs_hfm(list3);
			// 乙肝副卡
			IHepatitisBDORService hepat = ServiceFinder.find(IHepatitisBDORService.class);
			HepatitisBDO[] hepats = hepat.find("a2.id_contagion = '" + contagionDO.getId_contagion() + "'", null, FBoolean.FALSE);
			FArrayList list4 = new FArrayList();

			if (hepats != null && hepats.length > 0) {
				list4.add(hepats[0]);
				// 赋值需要上传的传染病副卡简单信息
				ContagionMessageDTO msgDTO = new ContagionMessageDTO();
				msgDTO.setId_contagion(hepats[0].getId_contagion_hb());
				msgDTO.setName_disease("乙肝附卡");
				msgDTO.setDef1(hepats[0].getCode_liver_puncture_results());// 肝穿刺检测结果code
				msgDTO.setDef2(hepats[0].getName_liver_puncture_results());// 肝穿刺检测结果name
				crbfkList.add(msgDTO);
			}
			hospitalContagionDTO.setLs_hepatitisb(list4);
			// 艾滋病副卡
			IAidsDORService aids = ServiceFinder.find(IAidsDORService.class);
			AidsDO[] aidsDos = aids.find("a5.id_contagion = '" + contagionDO.getId_contagion() + "'", null, FBoolean.FALSE);
			FArrayList list7 = new FArrayList();

			if (aidsDos != null && aidsDos.length > 0) {
				list7.add(aidsDos[0]);
				// 赋值需要上传的传染病副卡简单信息
				ContagionMessageDTO msgDTO = new ContagionMessageDTO();
				msgDTO.setId_contagion(aidsDos[0].getId_aids());
				msgDTO.setName_disease("艾滋病附卡");
				msgDTO.setDef1(aidsDos[0].getSd_conclusion());// 实验室检测结论编码
				msgDTO.setDef2(aidsDos[0].getName_conclusion());// 实验室检测结论名称
				crbfkList.add(msgDTO);
			}
			hospitalContagionDTO.setLs_aids(list7);

			ICiMrIPService ipservice = ServiceFinder.find(ICiMrIPService.class);
			FArrayList list5 = new FArrayList();
			FArrayList list6 = new FArrayList();
			CiMrPatInfoDTO[] patinfoDTOs = ipservice.getCiMrPatInfoDTO(contagionDO.getId_ent());
			int crb_idx = 0;

			if (patinfoDTOs.length > 0) {
				for (int i = 0; i < patinfoDTOs.length; i++) {
					patinfoDTOs[i].setName_province(contagionDO.getProvince_name());// 现住址
					patinfoDTOs[i].setStreet(contagionDO.getStreet());// 现住址-街道
					patinfoDTOs[i].setVillage(contagionDO.getVillage());// 现住址-村
					patinfoDTOs[i].setHousenum(contagionDO.getHousenum() + "号");// 现住址-门牌号
					patinfoDTOs[i].setResidence(contagionDO.getBirth_place_name());// 户籍地址
					patinfoDTOs[i].setResi_village(contagionDO.getDef2());// 户籍地址-村
					patinfoDTOs[i].setResi_housenum(contagionDO.getDef3());// 户籍地址-门牌号
					patinfoDTOs[i].setTel_num(contagionDO.getMob());
					patinfoDTOs[i].setTel(contagionDO.getTel());
					patinfoDTOs[i].setHzjzxm(contagionDO.getHzjzxm());
					patinfoDTOs[i].setEu_rqfl_name(contagionDO.getEu_rqfl_name());
					patinfoDTOs[i].setEu_rqfl_code(contagionDO.getEu_rqfl_code());
					patinfoDTOs[i].setEu_blfl_name(contagionDO.getEu_blfl_name());
					patinfoDTOs[i].setEu_blfl_code(contagionDO.getEu_blfl_code());
					patinfoDTOs[i].setWorkunit(contagionDO.getWorkunit());
					patinfoDTOs[i].setRevised_name(contagionDO.getRevised_name());
					patinfoDTOs[i].setRetreat_reason(contagionDO.getRetreat_reason());
					patinfoDTOs[i].setEu_nldw_name(contagionDO.getEu_nldw_name());
					patinfoDTOs[i].setEu_brsy_code(contagionDO.getEu_brsy_code());
					patinfoDTOs[i].setEu_brsy_name(contagionDO.getEu_brsy_name());
					patinfoDTOs[i].setEu_rqfl_code(contagionDO.getEu_rqfl_code());
					patinfoDTOs[i].setEu_rqfl_name(contagionDO.getEu_rqfl_name());
					patinfoDTOs[i].setExact_age(contagionDO.getExact_age());
					patinfoDTOs[i].setEu_bklb_code(contagionDO.getEu_bklb_code());
					patinfoDTOs[i].setEu_bklb_name(contagionDO.getEu_bklb_name());
					patinfoDTOs[i].setFbrq(contagionDO.getFbrq());
					patinfoDTOs[i].setZdrq(contagionDO.getZdrq());
					patinfoDTOs[i].setSwrq(contagionDO.getSwrq());
					patinfoDTOs[i].setCode(contagionDO.getCode());
					patinfoDTOs[i].setId_sex_pat(contagionDO.getSd_sex());
					patinfoDTOs[i].setName_sex_pat(contagionDO.getName_sex());
					// 是否审核通过
					if ("3".equals(contagionDO.getSd_con_cardsu())) {
						patinfoDTOs[i].setName_con_cardsu("true");
					} else if ("4".equals(contagionDO.getSd_con_cardsu())) {
						patinfoDTOs[i].setName_con_cardsu("false");
					} else {
						patinfoDTOs[i].setName_con_cardsu("");
					}
					// patinfoDTOs[i].setSd_con_cardsu(contagionDO.getSd_con_cardsu());
					// patinfoDTOs[i].setName_con_cardsu(contagionDO.getName_con_cardsu());
					patinfoDTOs[i].setReport_unit_code(contagionDO.getReport_unit_code());
					patinfoDTOs[i].setReport_unit_name(contagionDO.getReport_unit_name());
					patinfoDTOs[i].setDoctor_card(contagionDO.getDoctor_card());
					patinfoDTOs[i].setEu_jlcrb_code(contagionDO.getEu_jlcrb_code());
					patinfoDTOs[i].setEu_jlcrb_name(contagionDO.getEu_jlcrb_name());
					patinfoDTOs[i].setEu_ylcrb_code(contagionDO.getEu_ylcrb_code());
					patinfoDTOs[i].setEu_ylcrb_name(contagionDO.getEu_ylcrb_name());
					patinfoDTOs[i].setEu_blcrb_code(contagionDO.getEu_blcrb_code());
					patinfoDTOs[i].setEu_blcrb_name(contagionDO.getEu_blcrb_name());
					patinfoDTOs[i].setSd_other_diseases(contagionDO.getSd_other_diseases());
					patinfoDTOs[i].setName_other_diseases(contagionDO.getName_other_diseases());
					patinfoDTOs[i].setSd_emp_entry(contagionDO.getSd_emp_entry());
					patinfoDTOs[i].setName_emp_entry(contagionDO.getName_emp_entry());
					patinfoDTOs[i].setDt_contagion(contagionDO.getDt_contagion());
					patinfoDTOs[i].setCode_eu_bqfl(contagionDO.getCode_eu_bqfl());
					patinfoDTOs[i].setName_eu_bqfl(contagionDO.getName_eu_bqfl());
					patinfoDTOs[i].setRemarks(contagionDO.getRemarks());
					patinfoDTOs[i].setIs_alike(contagionDO.getIs_alike());

					if (contagionDO.getEu_jlcrb() != null) {
						// 甲类传染病 赋值给 集成平台
						patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_jlcrb_code());
						patinfoDTOs[i].setName_congation_type("甲类传染病");
						patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_jlcrb_code());
						patinfoDTOs[i].setName_congationnew(contagionDO.getEu_jlcrb_name());
						patinfoDTOs[i].setFg_crb("true");
						crb_idx = 1;
					}
					if (contagionDO.getEu_ylcrb() != null) {
						// 乙类传染病 赋值给 集成平台
						patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_ylcrb_code());
						patinfoDTOs[i].setName_congation_type("乙类传染病");
						patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_ylcrb_code());
						patinfoDTOs[i].setName_congationnew(contagionDO.getEu_ylcrb_name());
						patinfoDTOs[i].setFg_crb("true");
						crb_idx = 2;
					}
					if (contagionDO.getEu_blcrb() != null) {
						// 丙类传染病 赋值给 集成平台
						patinfoDTOs[i].setCode_congation_type(contagionDO.getEu_blcrb_code());
						patinfoDTOs[i].setName_congation_type("丙类传染病");
						patinfoDTOs[i].setCode_congationnew(contagionDO.getEu_blcrb_code());
						patinfoDTOs[i].setName_congationnew(contagionDO.getEu_blcrb_name());
						patinfoDTOs[i].setFg_crb("true");
						crb_idx = 3;
					}
					if (contagionDO.getId_other_diseases() != null) {
						// 其他传染病 赋值给 集成平台
						patinfoDTOs[i].setCode_congation_type(contagionDO.getSd_other_diseases());
						patinfoDTOs[i].setName_congation_type("其他法定管理以及重点监测传染病");
						patinfoDTOs[i].setCode_congationnew(contagionDO.getSd_other_diseases());
						patinfoDTOs[i].setName_congationnew(contagionDO.getName_other_diseases());
						patinfoDTOs[i].setFg_crb("true");
						crb_idx = 4;
					}
					patinfoDTOs[i].setName_disease("艾滋附卡-项目名称为空");
					patinfoDTOs[i].setConclusion_name("艾滋附卡-实验室检测结论为空");
					patinfoDTOs[i].setContact_history_name("艾滋附卡-接触史项目名称为空");
					
					if (aidsDos != null && aidsDos.length > 0) {
						if (aidsDos[0].getDisease_name() != null) {
							patinfoDTOs[i].setName_disease(aidsDos[0].getDisease_name());
						}
						if (aidsDos[0].getName_conclusion() != null) {
							patinfoDTOs[i].setConclusion_name(aidsDos[0].getName_conclusion());
						}
						if (aidsDos[0].getName_contact_history() != null) {
							patinfoDTOs[i].setContact_history_name(aidsDos[0].getName_contact_history());
						}
					}
					// 传染病附卡信息
					patinfoDTOs[i].setLs_contagionmsg(crbfkList);
				}
			}

			if (crb_idx == 1 || crb_idx == 2 || crb_idx == 3 || crb_idx == 4) {
				list6.addAll(Arrays.asList(patinfoDTOs));
			} else {
				CiMrPatInfoDTO e = new CiMrPatInfoDTO();
				e.setCode_congation_type("传染病类型code");
				e.setName_congation_type("传染病类型名称");
				e.setCode_congationnew("传染病code");
				e.setName_congationnew("传染病名称");
				e.setFg_crb("false");
				list6.add(e);
			}
			list5.addAll(Arrays.asList(patinfoDTOs));
			// list1.add(auditDTOs);
			hospitalContagionDTO.setLs_patient(list5);

			// list6.addAll(Arrays.asList(patinfoDTOs));
			hospitalContagionDTO.setLs_crb(list6);
			// BusinessEvent mrEvent = new
			// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_CONTAGION_PASS,
			// IEventType.TYPE_UPDATE_AFTER, hospitalContagionDTO);
			// EventDispatcher.fireEvent(mrEvent);

			String bussiType = IMrPubConst.NOCAT;

			// DomainBusinessUserObj buo = new
			// DomainBusinessUserObj(hospitalContagionDTO, IMrPubConst.MZ, "", "0");
			// by ldq 2017-08-07
			MsgObj msgObj = new MsgObj();
			
			if (hospitalContagionDTO.getLs_patient() != null) {
				FArrayList fa = (FArrayList) hospitalContagionDTO.getLs_patient();
				if (fa.size() > 0) {
					CiMrPatInfoDTO pa = (CiMrPatInfoDTO) fa.get(0);
					Integer enTimes = null;
					if (pa.getTimes_op() != null && pa.getId_entp().equals("01")) {
						enTimes = Integer.parseInt(pa.getTimes_op());
						bussiType = IMrPubConst.MZ;
					}
					if (pa.getTimes_ip() != null && pa.getId_entp().equals("03")) {
						enTimes = Integer.parseInt(pa.getTimes_ip());
						bussiType = IMrPubConst.ZY;
					}
					if (pa.getId_entp().equals("01")) {
						pa.setTimes_ip(pa.getTimes_op());
					}
					pa.setId_pre("01");
					msgObj.setInteractionCode("0");
					msgObj.setPatientCode(pa.getCode_pat());
					msgObj.setEntimes(enTimes);
					msgObj.setEnNO(pa.getCode_ent());
					// MsgObj msgObj = new MsgObj("0", pa.getCode_pat(), enTimes,
					// pa.getCode_ent(), null, null, null);
					// buo.setMsgObj(msgObj);
				} else {
					bussiType = IMrPubConst.MZ;
				}
			} else {
				bussiType = IMrPubConst.MZ;
			}

			DomainBusinessUserObj buo = new DomainBusinessUserObj(hospitalContagionDTO, bussiType, "", "0");
			if (msgObj.getInteractionCode() != null) {
				buo.setMsgObj(msgObj);
			}

			BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_CONTAGION_PASS,
					IEventType.TYPE_UPDATE_AFTER, buo);
			BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
			beListener.doAction(event);
		}
		
		// try {
		// EventDispatcher.fireEvent(event);
		// } catch (BizException e) {
		// e.printStackTrace();
		// }
	}
	// private <T> FArrayList setDOValues( Class<T> serviceInterface , String
	// whereStr , Object dos ){
	// FArrayList list = new FArrayList();
	// T t = ServiceFinder.find(serviceInterface);
	//
	// return list;
	// }
}
