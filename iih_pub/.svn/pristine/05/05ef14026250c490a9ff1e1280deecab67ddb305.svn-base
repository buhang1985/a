package iih.ci.mr.pub.listener.bp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.i.ICiDiagItemDORService;
import iih.ci.diag.cidiag.i.ICidiagMDORService;
import iih.ci.mr.auditdto.d.AuditDTO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO;
import iih.ci.mr.cimrsource.d.CiMrSourceDO;
import iih.ci.mr.cimrsource.i.ICimrsourceRService;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.mr.i.ICiMrIPService;
import iih.ci.mr.i.ICiMrOutQryServices;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.ICiMrSignCaDORService;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.secinfodto.d.SecInfoDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.ord.diag.ICiEnDiagInfoService;
import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.basic.storage.BusinessStorageService;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FBinary;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 病历内容上传集成平台服务类</br>
 * @author YanSu
 * @since 2020.7.16
 */
public class CiMrUpLoadServiceBP {
	
	/**
	 * 执行
	 * @param ciMrDO 病历信息
	 * @param upLoadStatus 病历状态（01：提交，02：删除）
	 * @throws BizException
	 */
	public void exec(CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		// 服务定义
		ICiMrIPService service = ServiceFinder.find(ICiMrIPService.class);
		IMrdocrefvalueRService mrdocrefvalueservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		if (ciMrDO == null) {
			return;
		}
		// 获取dto基本数据
		CiMrIPBaseDTO[] ciMrIPBaseDTOs = service.getCiMrIPBaseDTO(ciMrDO.getId_mr());
		// 数据不可为空
		if (ArrayUtil.isEmpty(ciMrIPBaseDTOs))
			return;
		// 取集合第一条数据，理论上只存在一条数据
		CiMrIPBaseDTO ciMrIPBaseDTO = ciMrIPBaseDTOs[0];
		// 如果不存在数据集则返回，根据数据集确定文书分类
		if (ciMrIPBaseDTO.getCode_set() == null || ciMrIPBaseDTO.getCode_set() == "") {
			return;
		}
		if ("01".equals(upLoadStatus)) {
			// 设置上传状态
			if (("Y").equals(ciMrDO.getPat_age())) {
				ciMrIPBaseDTO.setType_message("1");
			} else {
				ciMrIPBaseDTO.setType_message("0");
			}
			
			if (ciMrIPBaseDTO.getDt_created() == null) {
				ciMrIPBaseDTO.setDt_created(new FDateTime());
			}
			// 获取并赋值PDF编码
			try {
				ciMrIPBaseDTO.setCode_base64(getBase64Code(ciMrDO.getId_mr()));
			} catch (IOException e) {
				ciMrIPBaseDTO.setCode_base64("");
			}
			// 获取并赋值CA签名的base64编码
			try {
				ciMrIPBaseDTO.setSignca_base64(getSignCABase64Code(ciMrDO.getId_mr()));
			} catch (IOException e) {
				ciMrIPBaseDTO.setSignca_base64("");
			}
		} else if ("02".equals(upLoadStatus)) {
			ciMrIPBaseDTO.setType_message("-1");
		}
		// 标准版域id 01his 02体检
		ciMrIPBaseDTO.setId_pre("01");
		ciMrIPBaseDTO.setName_mr(ciMrDO.getName());
		// 计算患者的年龄，并赋值给ciMrIPBaseDTO
		String age = getPatAge(ciMrIPBaseDTO.getDt_birth());
		
		if (age.contains("岁")) {
			ciMrIPBaseDTO.setAge(age.replace("岁", ""));
			ciMrIPBaseDTO.setAge_unit("岁");
		} else if (age.contains("月")) {
			ciMrIPBaseDTO.setAge(age.replace("月", ""));
			ciMrIPBaseDTO.setAge_unit("月");
		} else {
			ciMrIPBaseDTO.setAge(age.replace("天", ""));
			ciMrIPBaseDTO.setAge_unit("天");
		}
		/*
		 * 病历中引用信息的查询与再封装
		 */
		MrDocRefValueDO[] mrDocRefValueDOs = mrdocrefvalueservice.find(" id_mr = '" + ciMrIPBaseDTO.getId_mr() + "' ", "", FBoolean.FALSE);
		// 根据数据元编码匹配对应的引用信息
		for (MrDocRefValueDO rDocRefValueDO : mrDocRefValueDOs) {
			try {
				switch (rDocRefValueDO.getCode_element()) {
				case IMrPubConst.DG_ZS:
					ciMrIPBaseDTO.setCh_co(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_XBS:
					ciMrIPBaseDTO.setIll_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_JWS:
					ciMrIPBaseDTO.setPa_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_GMS:
					ciMrIPBaseDTO.setMe_al_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_JZS:
					ciMrIPBaseDTO.setFa_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_GRS:
					ciMrIPBaseDTO.setPe_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_HYS:
					ciMrIPBaseDTO.setMa_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC:
					ciMrIPBaseDTO.setPh_ex_info(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZKJC:
					ciMrIPBaseDTO.setSp_ex(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_FZJC:
					ciMrIPBaseDTO.setSu_ex(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_BCJL:
					ciMrIPBaseDTO.setProg_note(rDocRefValueDO.getContent());
					//发【BS408首次病程记录信息服务】时赋值
					if (IMrPubConst.DS_BCJL1.equals(ciMrIPBaseDTO.getCode_set())) {
						String str = rDocRefValueDO.getContent();
						String[] strs1 = str.split("病例特点");
						if (strs1.length > 1) {
							String[] strs2 = strs1[1].split("初步诊断");
							if (strs2.length > 1) {
								ciMrIPBaseDTO.setHistory_trait(strs2[0]);
								String[] strs3 = strs2[1].split("诊断依据");
								if (strs3.length > 1) {
									ciMrIPBaseDTO.setFirst_diagnosis(strs3[0]);
									String[] strs4 = strs3[1].split("鉴别诊断");
									if (strs4.length > 1) {
										ciMrIPBaseDTO.setDiagnosis_basis(strs4[0]);
										String[] strs5 = strs4[1].split("诊疗计划");
										if (strs5.length > 1) {
											ciMrIPBaseDTO.setIdentify_diagnosis(strs5[0]);
											ciMrIPBaseDTO.setDiagnosis_plan(strs5[1]);
										} else {
											ciMrIPBaseDTO.setIdentify_diagnosis(strs4[1]);	
										}
									} else {
										ciMrIPBaseDTO.setDiagnosis_basis(strs3[1]);
									}
								} else {
									ciMrIPBaseDTO.setFirst_diagnosis(strs2[1]);
								}
							} else {
								ciMrIPBaseDTO.setHistory_trait(strs1[1]);
							}
						}
					}
					break;
				case IMrPubConst.DG_ZQGZ:
					ciMrIPBaseDTO.setMr_area(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSS:
					ciMrIPBaseDTO.setSug_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_CRB:
					ciMrIPBaseDTO.setInf_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_YFJZ:
					ciMrIPBaseDTO.setPre_ino_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SXS:
					ciMrIPBaseDTO.setMet_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_YJS:
					ciMrIPBaseDTO.setMen_ht(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SMTZXX:
					ciMrIPBaseDTO.setVs_info(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZYSZ:
					ciMrIPBaseDTO.setCn_four_di(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZLJG:
					ciMrIPBaseDTO.setTher_outcinfo(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZLGC:
					ciMrIPBaseDTO.setTreatment(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_YZ:
					ciMrIPBaseDTO.setOr_le_ar(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SS:
					ciMrIPBaseDTO.setSug_info(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SWSJ:
					ciMrIPBaseDTO.setDt_de(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_SSJG:
					ciMrIPBaseDTO.setOpe_after(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SZXM:
					ciMrIPBaseDTO.setOpe_doc(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_JBMC:
					ciMrIPBaseDTO.setOpe_diag_before(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSRQ:
					ciMrIPBaseDTO.setOpe_date(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_SSJBMC:
					ciMrIPBaseDTO.setOpe_class(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_RYQK:
					ciMrIPBaseDTO.setIn_si(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_CYQK:
					ciMrIPBaseDTO.setLeave_info(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_RYZD:
					ciMrIPBaseDTO.setDiag_inhos(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_CYZD:
					ciMrIPBaseDTO.setDiag_outhos(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_CYYZ:
					ciMrIPBaseDTO.setOr_le_ar(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TW:
					ciMrIPBaseDTO.setVs_info_temp(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_MB:
					ciMrIPBaseDTO.setVs_info_pulse(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_HXPL:
					ciMrIPBaseDTO.setVs_info_breath(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSY:
					ciMrIPBaseDTO.setVs_info_sp(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SZY:
					ciMrIPBaseDTO.setVs_info_dp(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SG:
					ciMrIPBaseDTO.setVs_info_height(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TZ:
					ciMrIPBaseDTO.setVs_info_weight(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_YBZK:
					ciMrIPBaseDTO.setPhex_info_ybzk(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_PFHNM:
					ciMrIPBaseDTO.setPhex_info_pfhnm(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_QBLBJ:
					ciMrIPBaseDTO.setPhex_info_qblbj(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_TBJQQG:
					ciMrIPBaseDTO.setPhex_info_tbjqqg(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_JB:
					ciMrIPBaseDTO.setPhex_info_jb(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_XB:
					ciMrIPBaseDTO.setPhex_info_xb(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_FB:
					ciMrIPBaseDTO.setPhex_info_fb(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_GMZZ:
					ciMrIPBaseDTO.setPhex_info_gmzz(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_WSZQ:
					ciMrIPBaseDTO.setPhex_info_wszq(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_JZ:
					ciMrIPBaseDTO.setPhex_info_jz(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_SZ:
					ciMrIPBaseDTO.setPhex_info_sz(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_TGJC_SJXT:
					ciMrIPBaseDTO.setPhex_info_sjxt(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZKQK:
					ciMrIPBaseDTO.setSp_situation(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SWYY:
					ciMrIPBaseDTO.setDe_re(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSMC:
					ciMrIPBaseDTO.setOpe(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSCXL:
					ciMrIPBaseDTO.setBleed_amount(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SXL:
					ciMrIPBaseDTO.setTrans_blood(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SYL:
					ciMrIPBaseDTO.setTrans_injection(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZYSX:
					ciMrIPBaseDTO.setAttention_matters(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZZKSSJ:
					ciMrIPBaseDTO.setDt_start_symp(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_ZZJSSJ:
					ciMrIPBaseDTO.setDt_end_symp(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_ZZMS:
					ciMrIPBaseDTO.setDesc_symp(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZLJH:
					ciMrIPBaseDTO.setDiagnosis_plan(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SSKSSJ:
					ciMrIPBaseDTO.setDt_ope_start(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_SSJSSJ:
					ciMrIPBaseDTO.setDt_ope_end(new FDateTime(rDocRefValueDO.getContent()));
					break;
				case IMrPubConst.DG_SSTW:
					ciMrIPBaseDTO.setOpe_pos(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_NSSSS:
					ciMrIPBaseDTO.setProt_ope_name(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_MZYS:
					ciMrIPBaseDTO.setAnestp_doc(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_MZFS:
					ciMrIPBaseDTO.setAnestp(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_SYSJC:
					ciMrIPBaseDTO.setLab_ex_info(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_GMSBZ:
					ciMrIPBaseDTO.setMe_al_flag(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_CZBZ:
					ciMrIPBaseDTO.setFirst_dia_flag(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_BZYJMS:
					ciMrIPBaseDTO.setDial_bas(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_ZZZZ:
					ciMrIPBaseDTO.setTreat_method(rDocRefValueDO.getContent());
					break;
				case IMrPubConst.DG_JPTY:
					ciMrIPBaseDTO.setDis_agr_flag(rDocRefValueDO.getContent());
					break;
				default:
					break;
				}
			} catch (IllegalArgumentException e) {// 病历模板制作时，日期元素的时间格式可能与DTO中的时间格式不一致，这里抛出提示信息的异常
				String msg = "";
				if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SWSJ)) {
					msg += "病历模板中死亡时间元素的日期格式属性设置错误！数据元编码：" + IMrPubConst.DG_SWSJ;
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSKSSJ)) {
					msg += "病历模板中手术开始时间元素的日期格式属性设置错误！数据元编码：" + IMrPubConst.DG_SSKSSJ;
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZKSSJ)) {
					msg += "病历模板中症状开始时间元素的日期格式属性设置错误！数据元编码：" + IMrPubConst.DG_ZZKSSJ;
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZJSSJ)) {
					msg += "病历模板中症状结束时间元素的日期格式属性设置错误！数据元编码：" + IMrPubConst.DG_ZZJSSJ;
				}
				throw new IllegalArgumentException(msg);
			}
		}
		/*
		 * 病历中源信息的查询与再封装
		 */
		Map<String, String[]> mrSourceMap = getMrSourceInfo(ciMrIPBaseDTO.getId_mr());
		if (mrSourceMap != null && mrSourceMap.size() > 0) {
			Set<Entry<String, String[]>> mrSourceEntrySet = mrSourceMap.entrySet();
			String[] mrConstArrayForSource = getMrConstByPrefix("DB");
			if (mrConstArrayForSource == null) {
				throw new BizException("常量文件解析错误...");
			}
			for (Entry<String, String[]> entry : mrSourceEntrySet) {
				for (String mrConst : mrConstArrayForSource) {
					if (mrConst.equals(entry.getKey())) {
						// 0-ID，1-CODE，2-NAME
						ciMrIPBaseDTO.setDe_re_code(entry.getValue()[1]);
						ciMrIPBaseDTO.setDe_re_name(entry.getValue()[2]);
					}
				}
			}
		}
		/*
		 * 审签子DTO
		 */
		ciMrIPBaseDTO.setLs_audit(getAuditDTOList(ciMrDO.getId_mr()));
		/*
		 * 章节内容子DTO，暂时不用
		 */
		ciMrIPBaseDTO.setLs_sec(getSecInfoDTOList(ciMrDO.getId_mr()));
		/*
		 * 诊断信息子DTO，旧诊断查询方法，新需求尽量使用getDiagInfoForIp方法
		 */
		ciMrIPBaseDTO.setLs_dia(getDiaInfoDTOList(ciMrDO.getId_ent()));
		/*
		 * 查询住院诊断信息，并分类封装到总DTO
		 */
		Map<String, FArrayList> diagMap = getDiagInfoForIp(ciMrDO.getId_ent());
		Set<Entry<String,FArrayList>> diagEntrySet = diagMap.entrySet();
		for (Entry<String, FArrayList> entry : diagEntrySet) {
			switch (entry.getKey()) {
			case "00":// 门诊诊断
				ciMrIPBaseDTO.setLs_op_di(entry.getValue());
				break;
			case "11":// 初步诊断
				ciMrIPBaseDTO.setLs_prelim_di(entry.getValue());
				break;
			case "12":// 入院诊断
				ciMrIPBaseDTO.setLs_inhos_di(entry.getValue());
				break;
			case "13":// 修正诊断
				ciMrIPBaseDTO.setLs_revise_di(entry.getValue());
				break;
			case "14":// 补充诊断
				ciMrIPBaseDTO.setLs_sup_di(entry.getValue());
				break;
			case "15":// 出院诊断
				ciMrIPBaseDTO.setLs_outhos_di(entry.getValue());
				break;
			case "16":// 死亡诊断
				ciMrIPBaseDTO.setLs_death_di(entry.getValue());
				break;
			}
		}
		/*
		 *  门诊医嘱信息查询，并分类封装到总DTO
		 */
		if ("00".equals(ciMrDO.getCode_entp())) {
			ciMrIPBaseDTO.setLs_order(getOrdInfo(ciMrDO.getId_ent()));
		}
		/*
		 * 根据数据集编码进行匹配，并使用对应的服务编码及病历信息发送消息
		 */
		String[] mrConstArrayForUpLoad = getMrConstByPrefix("US");
		if (mrConstArrayForUpLoad == null) {
			throw new BizException("常量文件解析错误...");
		}
		for (String mrService : mrConstArrayForUpLoad) {
			String[] strs = mrService.split(":");
			if (strs[0].equals(ciMrIPBaseDTO.getCode_set())) {
				sendMessage(ciMrIPBaseDTO, ciMrDO, strs[1], strs[2], upLoadStatus);
				break;
			}
		}
	}
	
	/**
	 * 消息发送
	 * @param ciMrIPBaseDTO 消息封装总DTO
	 * @param ciMrDO 当前病历信息
	 * @param codeService 当前服务编码
	 * @param codeEvent 当前事件编码
	 * @param upLoadStatus 病历状态（提交/删除）
	 * @throws BizException
	 */
	private void sendMessage(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String codeService, String codeEvent, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setDt_ga_mh(ciMrDO.getCreatedtime());// 赋值采史时间,无对应取值，暂时取值文书创建时间
		ciMrIPBaseDTO.setId_server(codeService);// 服务编码
		// 消息头
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		// 区分门诊/住院的域ID及就诊次数
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		// 科室编码
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(codeEvent, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		// 更新发送状态
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	
	/**
	 * 更新字段 代表 发过集成平台消息
	 * @param mrDo
	 * @throws DAException
	 */
	private void updateMrToIPBase(CiMrDO mrDo) throws DAException {
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		StringBuilder sSql = new StringBuilder();
		sSql.append("UPDATE ci_mr SET pat_age = 'Y'  WHERE id_mr = '");
		sSql.append(mrDo.getId_mr());
		sSql.append("'");
		daf.execUpdate(sSql.toString());
	}
	
	/**
	 * 查询并重新组装病历的源信息
	 * @param idMr 病历主键
	 * @return Map<String, String[]> key：name_pro字段，value：组装后的源信息
	 * @throws BizException
	 */
	private Map<String, String[]> getMrSourceInfo(String idMr) throws BizException {
		ICimrsourceRService iCimrsourceRService = ServiceFinder.find(ICimrsourceRService.class);
		CiMrSourceDO[] ciMrSourceDOs = iCimrsourceRService.find(" id_mr = '" + idMr + "' ", "", FBoolean.FALSE);
		if (ciMrSourceDOs == null || ciMrSourceDOs.length <= 0) {
			return null;
		}
		/*
		 * 对查询的源信息进行拆分再封装
		 * 数据的拆分规则是依据前台源信息保存时的数据组装规则而定的，对于旧数据存在报错的可能
		 * 格式示例：ID:@@@@Z8100000000OVN39|CODE:27|NAME:局部麻醉
		 * （如需调整格式，注意关联修改）
		 */
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		for (CiMrSourceDO ciMrSourceDO : ciMrSourceDOs) {
			String name_pro = ciMrSourceDO.getName_pro();
			List<String> refList = new ArrayList<String>();
			if (ciMrSourceDO.getRefcontent() == null || "".equals(ciMrSourceDO.getRefcontent())) {
				continue;
			}
			String[] refs = ciMrSourceDO.getRefcontent().split("\\|");
			// 对于旧数据（数据格式错误）无法实现数据拆分，直接跳过处理
			if (refs.length <= 1) {
				continue;
			}
			for (String ref : refs) {
				refList.add(ref.split(":")[1]);
			}
			resultMap.put(name_pro, refList.toArray(new String[refList.size()]));
		}
		return resultMap;
	}
	
	/**
	 * 查询审签子DTO
	 * @param idMr 病历主键
	 * @return 审签子DTO集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getAuditDTOList(String idMr) throws BizException {
		ICiMrIPService service = ServiceFinder.find(ICiMrIPService.class);
		AuditDTO[] auditDTOs = service.getAuditDTO(idMr);
		FArrayList list = new FArrayList();
		if (auditDTOs != null && auditDTOs.length > 0) {
			list.addAll(Arrays.asList(auditDTOs));
		}
		return list;
	}
	
	/**
	 * 查询章节内容子DTO(暂时不用)
	 * @param idMr 病历主键
	 * @return 章节内容子DTO集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getSecInfoDTOList(String idMr) throws BizException {
		ICiMrIPService service = ServiceFinder.find(ICiMrIPService.class);
		SecInfoDTO[] secInfoDtos = service.getSecInfoDTO(idMr);
		FArrayList list = new FArrayList();
		if (secInfoDtos != null && secInfoDtos.length > 0) {
			list.addAll(Arrays.asList(secInfoDtos));
		}
		return list;
	}
	
	/**
	 * 查询诊断信息子DTO
	 * @param idEnt 就诊主键
	 * @return 诊断信息子DTO集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getDiaInfoDTOList(String idEnt) throws BizException {
		// 诊断信息子DTO
		ICiEnDiagInfoService diagService = ServiceFinder.find(ICiEnDiagInfoService.class);
		DiaInfoDTO[] diagInfoDtos = diagService.getCiEnDiagInfos(idEnt);
		FArrayList list = new FArrayList();
		if (diagInfoDtos != null && diagInfoDtos.length > 0) {
			list.addAll(Arrays.asList(diagInfoDtos));
		}
		return list;
	}
	
	/**
	 * 查询并组装住院诊断信息</br>
	 * 返回结果依照住院诊断中的诊断类型进行分类封装
	 * @param idEnt 就诊主键
	 * @return Map<String, FArrayList> key：诊断类型编码，value：诊断信息集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String, FArrayList> getDiagInfoForIp(String idEnt) throws BizException {
		// 定义服务
		ICidiagMDORService diagRService = ServiceFinder.find(ICidiagMDORService.class);
		ICiDiagItemDORService diagItemRService = ServiceFinder.find(ICiDiagItemDORService.class);
		// 查询诊断数据，并根据id_di分别查询诊断明细数据
		String sqlWhereStr = " id_en = '" + idEnt + "' and fg_sign='Y' and fg_cancel = 'N' ";
		CiDiagDO[] cidiagDOs = diagRService.find(sqlWhereStr, " dt_di asc ", FBoolean.FALSE);
		if (cidiagDOs == null || cidiagDOs.length <= 0) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" id_di in (  ");
		
		for (CiDiagDO ciDiagDO : cidiagDOs) {
			if (ciDiagDO.getId_di() != null && !"".equals(ciDiagDO.getId_di())) {
				sb.append("'");
				sb.append(ciDiagDO.getId_di());
				sb.append("', ");
			}
		}
		String diagItemSqlWhere = sb.toString().substring(0, sb.toString().length() - 2) + ") ";
		CiDiagItemDO[] ciDiagItemDOs = diagItemRService.find(diagItemSqlWhere, "", FBoolean.FALSE);
		// 用于封装最终返回信息
		Map<String, FArrayList> resultMap = new HashMap<String, FArrayList>();
		// 循环封装数据
		for (CiDiagDO ciDiagDO : cidiagDOs) {
			FArrayList diaglist = new FArrayList();
			List<CiDiagItemDO> diList = new ArrayList<CiDiagItemDO>();
			String sd_ditp = ciDiagDO.getSd_ditp();
			
			for (CiDiagItemDO ciDiagItemDO : ciDiagItemDOs) {
				if (ciDiagDO.getId_di().equals(ciDiagItemDO.getId_di())) {
					// 诊断明细DO中没有诊断日期字段或其他日期字段，暂时使用 补充说明 字段存储诊断日期信息
					String timeStr = ciDiagDO.getDt_di().toString();
					String supplementStr = timeStr.replace("-", "").replace(":", "").replace(" ", "");
					ciDiagItemDO.setSupplement(supplementStr);
					diList.add(ciDiagItemDO);
				}
			}
			diaglist.addAll(diList);
			resultMap.put(sd_ditp, diaglist);
		}
		return resultMap;
	}
	
	/**
	 * 查询门诊医嘱信息
	 * @param idEnt 就诊主键
	 * @return 门诊医嘱信息集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getOrdInfo(String idEnt) throws BizException {
		ICiMrOutQryServices ordMrService = ServiceFinder.find(ICiMrOutQryServices.class);
		List<CiOrdInfoDTO> ciOrdInfoList = ordMrService.getCiOrdInfoByIden(idEnt);
		FArrayList ordList = new FArrayList();
		if (ciOrdInfoList != null && ciOrdInfoList.size() > 0) {
			ordList.addAll(ciOrdInfoList);
		}
		return ordList;
	}
	
	/**
	 * 查询病历的电子文档信息并转换为base64编码
	 * @param idMr 病历主键
	 * @return 病历的base64编码
	 * @throws IOException
	 * @throws BizException
	 */
	private String getBase64Code(String idMr) throws IOException, BizException {
		// 组装二进制返回结果
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		ICimrmfileinfoRService mrmService = ServiceFinder.find(ICimrmfileinfoRService.class);
		CiMrmFileInfoDO[] doArr = mrmService.find(" id_bu_sy = '" + idMr + "' ", " sv desc ", FBoolean.FALSE);

		if (doArr.length > 0) {
			FBinary bin = fileService.read(doArr[0].getCode_file());
			// FBinary bin =
			// fileService.read("platform01/M00/01/00/rBI181r88z2EIxo8AAAAAFop6Fg2201272");
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			bin.writeBodyToStream(os);
			byte[] bytes = os.toByteArray();
			return Base64.bytes2string(bytes);
		} else {
			return "";
		}
	}
	
	/**
	 * 查询并将CA签名信息并转换为base64编码
	 * @param idMr 病历主键
	 * @return CA签名的base64编码
	 * @throws IOException
	 * @throws BizException
	 */
	private String getSignCABase64Code(String idMr) throws IOException, BizException {
		// 服务定义
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		IMrsignMDORService signService = ServiceFinder.find(IMrsignMDORService.class);
		ICiMrSignCaDORService signCAService = ServiceFinder.find(ICiMrSignCaDORService.class);
		
		String resultCode = "";
		CiMrSignDO[] ciMrSignDOs = signService.find(" id_mr = '" + idMr + "' ", "", FBoolean.FALSE);
		if (ciMrSignDOs == null || ciMrSignDOs.length <= 0) {
			return resultCode;
		}
		String id_mrsign = ciMrSignDOs[0].getId_mrsign();
		CiMrSignCaDO[] ciMrSignCaDOs = signCAService.find(" id_mrsign = '" + id_mrsign + "' ", "", FBoolean.FALSE);
		if (ciMrSignCaDOs == null || ciMrSignCaDOs.length <= 0) {
			return resultCode;
		}
		String filepath = ciMrSignCaDOs[0].getCryptd_emr_filepath();
		if (filepath == null || "".equals(filepath)) {
			return resultCode;
		}
		FBinary bin = fileService.read(filepath);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		bin.writeBodyToStream(os);
		byte[] bytes = os.toByteArray();
		return Base64.bytes2string(bytes);
	}
	
	/**
	 * 依据传入的常量名称前缀参数，通过反射的方式获取相关常量类中的公共属性，并根据前缀匹配，最终封装成所需的常量值数组
	 * @param prefix 常量名称的前缀
	 * @return 常量值的数组
	 */
	private String[] getMrConstByPrefix(String prefix) {
		String fullName = "iih.ci.mr.pub.MrConst.IMrPubConst";
		List<String> strList = new ArrayList<String>();
		try {
			Class<?> mrConstClass = Class.forName(fullName);
			Field[] fields = mrConstClass.getFields();
			// 遍历类中的所有公有属性，以属性名称的前缀作为判断标准，获取所需的所有常量内容
			for (Field field : fields) {
				if (field.getName().startsWith(prefix)) {
					strList.add(field.get(mrConstClass).toString());
				}
			}
		} catch (ClassNotFoundException e) {
			Logger.error(fullName + " 不能通过此全路径名找到此类");
			return null;
		} catch (IllegalAccessException e) {
			Logger.error(fullName + " 通过此全路径名获取的Class对象-无访问权限");
			return null;
		}
		return strList.toArray(new String[strList.size()]);
	}
	
	/**
	 * 计算患者年龄  -by Vampire
	 * @param dt_birth 出生日期
	 * @return 年龄
	 * @throws DAException
	 */
	private String getPatAge(FDate dt_birth) throws DAException {
		String age = "";
		if (dt_birth == null)
			return age;
		FDate dt_now = new FDate();
		long age_millis = dt_now.getMillis() - dt_birth.getMillis();
		double age_years = (double) age_millis / (1000.0 * 60.0 * 60.0 * 24.0 * 365.0);
		
		if (age_years >= 1.0) {
			age = (int)Math.floor(age_years) + "岁";
		} else {
			age_years = age_years * 365.0;
			
			if (age_years >= 30.0) {
				age = (int)(age_years / 30.0) + "月";
				/*
				String month = (int)(age_years / 30.0) + "月";
				String day = (int)(age_years % 30.0) + "天";
				age = month + day;
				*/
			} else {
				age = (int)(age_years % 30.0) + "天";
			}
		}
		return age;
	}
	
}
