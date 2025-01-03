package iih.ci.mr.pub.listener;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bc.udi.pub.SuMrConst;
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
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.d.CiMrSignDO;
import iih.ci.mr.mrsign.i.ICiMrSignCaDORService;
import iih.ci.mr.mrsign.i.IMrsignMDORService;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.pub.listener.bp.CiMrUpLoadServiceBP;
import iih.ci.mr.secinfodto.d.SecInfoDTO;
import iih.ci.mrm.cimrmfileinfo.d.CiMrmFileInfoDO;
import iih.ci.mrm.cimrmfileinfo.i.ICimrmfileinfoRService;
import iih.ci.ord.diag.ICiEnDiagInfoService;
import iih.ci.ord.i.external.provide.meta.mr.d.CiOrdInfoDTO;
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
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 病历文书上传集成平台监听服务</br>
 * 用于病历保存流程执行完成后触发，上传完整的病历信息
 * @author YanSu
 */
public class AbstractCiMrUpLoadListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 消息校验
		if (!(event.getSourceID().equals(IMrEventConst.EVENT_SOURCE_MR_UPLOAD) 
				&& event.getEventType().equals(IEventType.TYPE_UPDATE_AFTER))) return;
		
		CiMrDO ciMrDO = new CiMrDO();
		CiMrDO[] ciMrDOs = null;
		String upLoadStatus = "";
		// 获取参数数组
		Object[] newObjs = ((BDCommonEvent)event).getNewObjs();
		
		if (newObjs != null && newObjs.length > 0) {
			// 支持单一DO类型数据和DO数组类型数据
			if (newObjs[0] instanceof CiMrDO) {
			ciMrDO = (CiMrDO)newObjs[0];
			} else if (newObjs[0] instanceof CiMrDO[]) {
				ciMrDOs = (CiMrDO[])newObjs[0];
			}
			// 病历上传状态标识
			upLoadStatus = newObjs[1].toString();
		}
		if (ciMrDOs == null) {
			ciMrDOs = new CiMrDO[]{ciMrDO};
		}
		dataUpLoad(ciMrDOs, upLoadStatus);
	}
	
	@SuppressWarnings("unchecked")
	private void dataUpLoad(CiMrDO[] paramDOs, String upLoadStatus) throws BizException {
		CiMrUpLoadServiceBP upLoadBP = new CiMrUpLoadServiceBP();
		
		for (CiMrDO paramDO : paramDOs) {
		// 非提交状态的ciMrDO不进行上传
			if ("01".equals(upLoadStatus) && !ICiMrDictCodeConst.SD_SU_MR_SUBMIT.equals(paramDO.getSd_su_mr())) {
				continue;
		}
		// 如果ciMrDO的Sd_su_mr属性为新增，说明没有提交过，则无需进行删除操作
			if ("02".equals(upLoadStatus) && SuMrConst.SD_SUMR_NEW.equals(paramDO.getSd_su_mr())) {
				continue;
			}
			upLoadBP.exec(paramDO, upLoadStatus);
		}
		/*
		// 文书集成平台dto服务
		ICiMrIPService service = ServiceFinder.find(ICiMrIPService.class);
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
				ciMrIPBaseDTO.setCode_base64(getBase64Code(ciMrDO, ciMrIPBaseDTO.getCode_entp()));
			} catch (IOException e) {
				ciMrIPBaseDTO.setCode_base64("");
			}
			// 获取并赋值CA签名的base64编码
			try {
				ciMrIPBaseDTO.setSignca_base64(getSignCABase64Code(ciMrDO));
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
		// 填充其他信息
//		IMrdocrefvalueRService mrdocrefvalueservice = ServiceFinder.find(IMrdocrefvalueRService.class);
//		MrDocRefValueDO[] mrDocRefValueDOs = mrdocrefvalueservice.find("id_mr = '" + ciMrIPBaseDTO.getId_mr() + "'", "", FBoolean.FALSE);
		MrDocRefValueDO[] mrDocRefValueDOs = getMrDocRefValueDOInfo(ciMrIPBaseDTO.getId_mr());
		
		for (MrDocRefValueDO rDocRefValueDO : mrDocRefValueDOs) {
			try {
				if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZS)) {
					ciMrIPBaseDTO.setCh_co(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_XBS)) {
					ciMrIPBaseDTO.setIll_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JWS)) {
					ciMrIPBaseDTO.setPa_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_GMS)) {
					ciMrIPBaseDTO.setMe_al_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JZS)) {
					ciMrIPBaseDTO.setFa_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_GRS)) {
					ciMrIPBaseDTO.setPe_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_HYS)) {
					ciMrIPBaseDTO.setMa_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC)) {
					ciMrIPBaseDTO.setPh_ex_info(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZKJC)) {
					ciMrIPBaseDTO.setSp_ex(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_FZJC)) {
					ciMrIPBaseDTO.setSu_ex(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_BCJL)) {
					ciMrIPBaseDTO.setProg_note(rDocRefValueDO.getContent());
					//发【BS408首次病程记录信息服务】时赋值
					if(IMrPubConst.DS_BCJL1.equals(ciMrIPBaseDTO.getCode_set())){
						String str=rDocRefValueDO.getContent();
						String [] strs1=str.split("病例特点");
						if(strs1.length>1){
							String [] strs2=strs1[1].split("初步诊断");
							if(strs2.length>1){
								ciMrIPBaseDTO.setHistory_trait(strs2[0]);
								String [] strs3=strs2[1].split("诊断依据");
								if(strs3.length>1){
									ciMrIPBaseDTO.setFirst_diagnosis(strs3[0]);
									String [] strs4=strs3[1].split("鉴别诊断");
									if(strs4.length>1){
										ciMrIPBaseDTO.setDiagnosis_basis(strs4[0]);
										String [] strs5=strs4[1].split("诊疗计划");
										if(strs5.length>1){
											ciMrIPBaseDTO.setIdentify_diagnosis(strs5[0]);
											ciMrIPBaseDTO.setDiagnosis_plan(strs5[1]);
										}else{
											ciMrIPBaseDTO.setIdentify_diagnosis(strs4[1]);	
										}
									}else{
										ciMrIPBaseDTO.setDiagnosis_basis(strs3[1]);
									}
								}else{
									ciMrIPBaseDTO.setFirst_diagnosis(strs2[1]);
								}
							}else{
								ciMrIPBaseDTO.setHistory_trait(strs1[1]);
							}
						}
					}
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZQGZ)) {
					ciMrIPBaseDTO.setMr_area(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSS)) {
					ciMrIPBaseDTO.setSug_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_CRB)) {
					ciMrIPBaseDTO.setInf_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_YFJZ)) {
					ciMrIPBaseDTO.setPre_ino_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SXS)) {
					ciMrIPBaseDTO.setMet_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_YJS)) {
					ciMrIPBaseDTO.setMen_ht(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SMTZXX)) {
					ciMrIPBaseDTO.setVs_info(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZYSZ)) {
					ciMrIPBaseDTO.setCn_four_di(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZLJG)) {
					ciMrIPBaseDTO.setTher_outcinfo(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZLGC)) {
					ciMrIPBaseDTO.setTreatment(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_YZ)) {
					ciMrIPBaseDTO.setOr_le_ar(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SS)) {
					ciMrIPBaseDTO.setSug_info(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SWSJ)) {
					ciMrIPBaseDTO.setDt_de(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSJG)) {
					ciMrIPBaseDTO.setOpe_after(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SZXM)) {
					ciMrIPBaseDTO.setOpe_doc(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JBMC)) {
					ciMrIPBaseDTO.setOpe_diag_before(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSRQ)) {
					ciMrIPBaseDTO.setOpe_date(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSJBMC)) {
					ciMrIPBaseDTO.setOpe_class(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_RYQK)) {
					ciMrIPBaseDTO.setIn_si(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_CYQK)) {
					ciMrIPBaseDTO.setLeave_info(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_RYZD)) {
					ciMrIPBaseDTO.setDiag_inhos(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_CYZD)) {
					ciMrIPBaseDTO.setDiag_outhos(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_CYYZ)) {
					ciMrIPBaseDTO.setOr_le_ar(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TW)) {
					ciMrIPBaseDTO.setVs_info_temp(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_MB)) {
					ciMrIPBaseDTO.setVs_info_pulse(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_HXPL)) {
					ciMrIPBaseDTO.setVs_info_breath(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSY)) {
					ciMrIPBaseDTO.setVs_info_sp(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SZY)) {
					ciMrIPBaseDTO.setVs_info_dp(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SG)) {
					ciMrIPBaseDTO.setVs_info_height(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TZ)) {
					ciMrIPBaseDTO.setVs_info_weight(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_YBZK)) {
					ciMrIPBaseDTO.setPhex_info_ybzk(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_PFHNM)) {
					ciMrIPBaseDTO.setPhex_info_pfhnm(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_QBLBJ)) {
					ciMrIPBaseDTO.setPhex_info_qblbj(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_TBJQQG)) {
					ciMrIPBaseDTO.setPhex_info_tbjqqg(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_JB)) {
					ciMrIPBaseDTO.setPhex_info_jb(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_XB)) {
					ciMrIPBaseDTO.setPhex_info_xb(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_FB)) {
					ciMrIPBaseDTO.setPhex_info_fb(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_GMZZ)) {
					ciMrIPBaseDTO.setPhex_info_gmzz(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_WSZQ)) {
					ciMrIPBaseDTO.setPhex_info_wszq(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_JZ)) {
					ciMrIPBaseDTO.setPhex_info_jz(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_SZ)) {
					ciMrIPBaseDTO.setPhex_info_sz(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_TGJC_SJXT)) {
					ciMrIPBaseDTO.setPhex_info_sjxt(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZKQK)) {
					ciMrIPBaseDTO.setSp_situation(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SWYY)) {
					ciMrIPBaseDTO.setDe_re(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSMC)) {
					ciMrIPBaseDTO.setOpe(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSCXL)) {
					ciMrIPBaseDTO.setBleed_amount(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SXL)) {
					ciMrIPBaseDTO.setTrans_blood(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SYL)) {
					ciMrIPBaseDTO.setTrans_injection(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZYSX)) {
					ciMrIPBaseDTO.setAttention_matters(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZKSSJ)) {
					ciMrIPBaseDTO.setDt_start_symp(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZJSSJ)) {
					ciMrIPBaseDTO.setDt_end_symp(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZMS)) {
					ciMrIPBaseDTO.setDesc_symp(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZLJH)) {
					ciMrIPBaseDTO.setDiagnosis_plan(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSKSSJ)) {
					ciMrIPBaseDTO.setDt_ope_start(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSJSSJ)) {
					ciMrIPBaseDTO.setDt_ope_end(new FDateTime(rDocRefValueDO.getContent()));
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SSTW)) {
					ciMrIPBaseDTO.setOpe_pos(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_NSSSS)) {
					ciMrIPBaseDTO.setProt_ope_name(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_MZYS)) {
					ciMrIPBaseDTO.setAnestp_doc(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_MZFS)) {
					ciMrIPBaseDTO.setAnestp(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_SYSJC)) {
					ciMrIPBaseDTO.setLab_ex_info(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_GMSBZ)) {
					ciMrIPBaseDTO.setMe_al_flag(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_CZBZ)) {
					ciMrIPBaseDTO.setFirst_dia_flag(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_BZYJMS)) {
					ciMrIPBaseDTO.setDial_bas(rDocRefValueDO.getContent());
				} else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_ZZZZ)) {
					ciMrIPBaseDTO.setTreat_method(rDocRefValueDO.getContent());
				}else if (rDocRefValueDO.getCode_element().equals(IMrPubConst.DG_JPTY)) {
					ciMrIPBaseDTO.setDis_agr_flag(rDocRefValueDO.getContent());
				}
			} catch (IllegalArgumentException e) {
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
		
		ICimrsourceRService iCimrsourceRService = ServiceFinder.find(ICimrsourceRService.class);
		CiMrSourceDO[] ciMrSourceDOs = iCimrsourceRService.find("id_mr = '" + ciMrIPBaseDTO.getId_mr() + "'", "", FBoolean.FALSE);
		String[] valueArr = new String[3];
		for (CiMrSourceDO ciMrSourceDO : ciMrSourceDOs) {
			String name_pro = ciMrSourceDO.getName_pro();
			switch (name_pro) {
			case "直接死亡原因":
				String refcontent = ciMrSourceDO.getRefcontent();
				valueArr = getValueArr(refcontent);
				ciMrIPBaseDTO.setDe_re_code(valueArr[1]);
				ciMrIPBaseDTO.setDe_re_name(valueArr[2]);
				break;
			}
		}		
		
		// 审签子DTO
		FArrayList list = new FArrayList();
		AuditDTO[] auditDTOs = service.getAuditDTO(ciMrDO.getId_mr());
		list.addAll(Arrays.asList(auditDTOs));
		ciMrIPBaseDTO.setLs_audit(list);
		// 章节内容子DTO 暂时不用
		FArrayList seclist = new FArrayList();
		SecInfoDTO[] secInfoDtos = service.getSecInfoDTO(ciMrDO.getId_mr());
		seclist.addAll(Arrays.asList(secInfoDtos));
		ciMrIPBaseDTO.setLs_sec(seclist);
		// 诊断信息子DTO
		ICiEnDiagInfoService diagService = ServiceFinder.find(ICiEnDiagInfoService.class);
		DiaInfoDTO[] diagInfoDtos = diagService.getCiEnDiagInfos(ciMrDO.getId_ent());
		
		if (diagInfoDtos != null && diagInfoDtos.length > 0) {
			FArrayList diaglist = new FArrayList();
			diaglist.addAll(Arrays.asList(diagInfoDtos));
			ciMrIPBaseDTO.setLs_dia(diaglist);
		}
		*/
		/*
		 *  添加住院诊断的分类查询方法，实现诊断数据分开上传集成平台  - by Vampire 2019.11.6
		 */
		/*
		ICidiagMDORService diagRService = ServiceFinder.find(ICidiagMDORService.class);
		ICiDiagItemDORService diagItemRService = ServiceFinder.find(ICiDiagItemDORService.class);
		// 查询诊断数据，并根据id_di分别查询诊断明细数据
		String whereStr = " id_en = '" + ciMrDO.getId_ent() + "' and fg_sign='Y' and fg_cancel = 'N' ";
		CiDiagDO[] cidiagDOs = diagRService.find(whereStr, " dt_di asc ", FBoolean.FALSE);
		
		if (cidiagDOs != null && cidiagDOs.length > 0) {
			int num = 0;
			String diagItemSqlWhere = " id_di in (";
			
			for (CiDiagDO ciDiagDO : cidiagDOs) {
				if (ciDiagDO.getId_di() == null || "".equals(ciDiagDO.getId_di())) {
					continue;
				}
				diagItemSqlWhere += " '" + ciDiagDO.getId_di() + "', ";
				num++;
			}
			
			if (num > 0) {
				diagItemSqlWhere = diagItemSqlWhere.substring(0, diagItemSqlWhere.length() - 2) + ") ";
				CiDiagItemDO[] ciDiagItemDOs = diagItemRService.find(diagItemSqlWhere, "", FBoolean.FALSE);
				// 循环封装数据
				for (CiDiagDO ciDiagDO : cidiagDOs) {
					FArrayList diaglist = new FArrayList();
					List<CiDiagItemDO> diList = new ArrayList<CiDiagItemDO>();
					String id_di = ciDiagDO.getId_di();
					String sd_ditp = ciDiagDO.getSd_ditp();
					
					if (id_di == null)
						continue;
					
					for (CiDiagItemDO ciDiagItemDO : ciDiagItemDOs) {
						if (id_di.equals(ciDiagItemDO.getId_di())) {
							// 诊断明细DO中没有诊断日期字段或其他日期字段，暂时使用 补充说明 字段存储诊断日期信息
							String timeStr = ciDiagDO.getDt_di().toString();
							String supplementStr = timeStr.replace("-", "").replace(":", "").replace(" ", "");
							ciDiagItemDO.setSupplement(supplementStr);
							diList.add(ciDiagItemDO);
						}
					}
					diaglist.addAll(diList);
					// 依据诊断类型进行数据集封装
					switch (sd_ditp) {
					case "00":// 门诊诊断
						ciMrIPBaseDTO.setLs_op_di(diaglist);
						break;
					case "11":// 初步诊断
						ciMrIPBaseDTO.setLs_prelim_di(diaglist);
						break;
					case "12":// 入院诊断
						ciMrIPBaseDTO.setLs_inhos_di(diaglist);
						break;
					case "13":// 修正诊断
						ciMrIPBaseDTO.setLs_revise_di(diaglist);
						break;
					case "14":// 补充诊断
						ciMrIPBaseDTO.setLs_sup_di(diaglist);
						break;
					case "15":// 出院诊断
						ciMrIPBaseDTO.setLs_outhos_di(diaglist);
						break;
					case "16":// 死亡诊断
						ciMrIPBaseDTO.setLs_death_di(diaglist);
						break;
					}
				}
			}
		}
		*/
		/*
		 *  添加门诊医嘱信息查询  - by Vampire 2020.4.27
		 */
		/*
		if ("00".equals(ciMrDO.getCode_entp())) {
			ICiMrOutQryServices ordMrService = ServiceFinder.find(ICiMrOutQryServices.class);
			List<CiOrdInfoDTO> ciOrdInfoList = ordMrService.getCiOrdInfoByIden(ciMrDO.getId_ent());
			
			FArrayList ordList = new FArrayList();
			ordList.addAll(ciOrdInfoList);
			ciMrIPBaseDTO.setLs_order(ordList);
		}
		
		if (ciMrIPBaseDTO.getDt_de() == null) {
			ciMrIPBaseDTO.setDt_de(new FDateTime());
		}
		if (ciMrIPBaseDTO.getDt_ga_mh() == null) {
			ciMrIPBaseDTO.setDt_ga_mh(new FDateTime());
		}

		switch (ciMrIPBaseDTO.getCode_set()) {
			// 24小时入出院记录信息服务
			case IMrPubConst.DS_RCY24:
				fireRCY24(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 24小时死亡记录信息服务
			case IMrPubConst.DS_RCY24SW:
				fireRCY24SW(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 入院记录信息服务
			case IMrPubConst.DS_RYJL:
				fireRYJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 出院小结信息服务
			case IMrPubConst.DS_CYXJ:
				fireCYXJ(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 手术操作记录信息服务
			case IMrPubConst.DS_SSJL:
				fireSSJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 死亡记录信息服务
			case IMrPubConst.DS_SWJL:
				fireSWJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 首次病程信息服务
			case IMrPubConst.DS_BCJL1:
				fireSCBC(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 日常病程记录
			case IMrPubConst.DS_BCJL2:
				fireRCBC(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 上级医师查房记录
			case IMrPubConst.DS_BCJL3:
				fireSJYSCF(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 疑难危重病例讨论
			case IMrPubConst.DS_BCJL4:
				fireYNWZBLTL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 交接班记录
			case IMrPubConst.DS_BCJL5:
				fireJJBJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 转科记录
			case IMrPubConst.DS_BCJL6:
				fireZKJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 阶段小结
			case IMrPubConst.DS_BCJL7:
				fireJDXJ(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 抢救记录
			case IMrPubConst.DS_BCJL8:
				fireQJJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 会诊记录
			case IMrPubConst.DS_BCJL9:
				fireHZJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 术前小结
			case IMrPubConst.DS_BCJL10:
				fireSQXJ(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 术后首次病程记录
			case IMrPubConst.DS_BCJL11:
				fireSHSCBC(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 出院记录
			case IMrPubConst.DS_BCJL12:
				fireCYJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 手术同意书
			case IMrPubConst.DS_ZQTY1:
				fireSSZQTY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 麻醉知情同意书
			case IMrPubConst.DS_ZQTY2:
				fireMZZQTY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 输血治疗同意书
			case IMrPubConst.DS_ZQTY3:
				fireSXZLZQTY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 特殊检查及特殊治疗同意书
			case IMrPubConst.DS_ZQTY4:
				fireTSJCTY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 病危(重)通知书
			case IMrPubConst.DS_ZQTY5:
				fireBWZTZ(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 其他知情同意书
			case IMrPubConst.DS_ZQTY6:
				fireQTZQTY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 门急诊病历
			case IMrPubConst.DS_MJZBL:
				fireMJZBL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 急诊留观记录信息服务
			case IMrPubConst.DS_JZLG:
				fireJZLG(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 术前讨论记录信息服务
			case IMrPubConst.DS_SQTL:
				fireSQTL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 死亡讨论记录信息服务
			case IMrPubConst.DS_SWTL:
				fireSWTL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 病历概要信息服务
			case IMrPubConst.DS_BLGY_HZJBXX:// 患者基本信息
				fireBLGY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			case IMrPubConst.DS_BLGY_JBJKXX:// 基本健康信息
				fireBLGY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			case IMrPubConst.DS_BLGY_WSZYSJ:// 卫生摘要事件
				fireBLGY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			case IMrPubConst.DS_BLGY_YLFYJL:// 医疗费用记录
				fireBLGY(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
			// 麻醉记录信息服务
			case IMrPubConst.DS_MZJL:
				fireMZJL(ciMrIPBaseDTO, ciMrDO, upLoadStatus);
				break;
		}
		*/
	}
	
	private void fireRCY24(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		// 赋值采史时间,无对应取值，暂时取值文书创建时间
		ciMrIPBaseDTO.setDt_ga_mh(ciMrDO.getCreatedtime());

		ciMrIPBaseDTO.setId_server("BS344");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCY24, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireRCY24SW(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		// 赋值采史时间,无对应取值，暂时取值文书创建时间
		ciMrIPBaseDTO.setDt_ga_mh(ciMrDO.getCreatedtime());
		
		ciMrIPBaseDTO.setId_server("BS345");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCY24SW, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireRYJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS335");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RYJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireCYXJ(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS341");
		if(ciMrIPBaseDTO.getOr_le_ar()==null){
		ciMrIPBaseDTO.setOr_le_ar("这个人要出院了");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_CYXJ, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireSSJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS337");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SSJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireSWJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS343");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 日常病程
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireRCBC(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		// BusinessEvent mrEvent = new
		// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCBC,
		// IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
		// EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS336");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_RCBC, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 上级医师查房记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSJYSCF(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS381");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SJYSCFJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 疑难危重病例讨论记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireYNWZBLTL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS372");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_YNWZBLTL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 交接班记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireJJBJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS446");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_JJBJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 转科记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireZKJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS383");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_ZKJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 阶段小结记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireJDXJ(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS384");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_JDXJ, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 抢救记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireQJJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS385");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_QJJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 会诊记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireHZJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS340");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_HZJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 术前小结
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSQXJ(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS375");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SQXJ, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 术后首次病程记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSHSCBC(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS386");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SHSCBCJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 出院记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireCYJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS371");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_CYJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 首次病程记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSCBC(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS408");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SCBC, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 手术知情同意书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSSZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS428");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SSZQTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 麻醉知情同意书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireMZZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS429");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_MZZQTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 输血或血液制品治疗知情同意书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSXZLZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS430");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SXZLZQTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 特殊检查同意书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireTSJCTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS431");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_TSJCTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 病危（重）通知书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireBWZTZ(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS432");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_BWZTZ, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 其他知情同意书
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireQTZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS433");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_QTZQTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/*
	private void fireZQTY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO) throws BizException {
		// BusinessEvent mrEvent = new
		// BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_ZQTY,
		// IEventType.TYPE_UPDATE_AFTER, ciMrIPBaseDTO);
		// EventDispatcher.fireEvent(mrEvent);
		ciMrIPBaseDTO.setId_server("BS338");
		
		if (ciMrIPBaseDTO.getMr_area() == null) {
			ciMrIPBaseDTO.setMr_area("知情同意书内容为空，请修改模板");
		}
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_ZQTY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age()))) {
			updateMrToIPBase(ciMrDO);
		}
	}
	*/
	private void fireMJZBL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS333");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_MJZBL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	
	/**
	 * 急诊留观记录信息服务
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireJZLG(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS339");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_JZLG, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}

	private void fireSQTL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS370");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SQTL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 死亡病例讨论记录
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireSWTL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS373");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_SWTL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 病历概要信息服务
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireBLGY(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS426");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_BLGY, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	/**
	 * 麻醉记录信息服务
	 * @param ciMrIPBaseDTO
	 * @param ciMrDO
	 * @throws BizException
	 */
	private void fireMZJL(CiMrIPBaseDTO ciMrIPBaseDTO, CiMrDO ciMrDO, String upLoadStatus) throws BizException {
		ciMrIPBaseDTO.setId_server("BS327");
		MsgObj msgobj = new MsgObj();
		msgobj.setEnNO(ciMrIPBaseDTO.getId_ent());
		// 消息头中的就诊类型信息
		String bussiType = IMrPubConst.NOCAT;
		// 消息头中的科室编码信息
		String deptId = "0";
		
		if (ciMrIPBaseDTO.getCode_entp().equals("01")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_op()));
			bussiType = IMrPubConst.MZ;
		}
		if (ciMrIPBaseDTO.getCode_entp().equals("03")) {
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(ciMrIPBaseDTO.getTimes_ip()));
			bussiType = IMrPubConst.ZY;
		}
		
		if (ciMrIPBaseDTO.getCode_dept() != null) {
			deptId = ciMrIPBaseDTO.getCode_dept();
		}
		msgobj.setPatientCode(ciMrIPBaseDTO.getId_pat());
		msgobj.setInteractionCode(ciMrIPBaseDTO.getType_message());
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ciMrIPBaseDTO, bussiType, deptId, "0");
		buo.setMsgObj(msgobj);
		BusinessEvent event = new BusinessEvent(IMrEventConst.EVENT_SOURCE_MR_MR_MZJL, IEventType.TYPE_UPDATE_AFTER, buo);
		BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
		beListener.doAction(event);
		
		if (!("Y".equals(ciMrDO.getPat_age())) && "01".equals(upLoadStatus)) {
			updateMrToIPBase(ciMrDO);
		}
	}
	
	// 更新字段 代表 发过集成平台消息
	private void updateMrToIPBase(CiMrDO mrDo) throws DAException {
		DAFacade daf = new DAFacade();
		daf.setAddTimeStamp(false);
		StringBuilder sSql = new StringBuilder();
		sSql.append("UPDATE ci_mr SET pat_age = 'Y'  WHERE id_mr = '");
		sSql.append(mrDo.getId_mr());
		sSql.append("'");
		daf.execUpdate(sSql.toString());
	}

	private String getBase64Code(CiMrDO ciMrDO, String codeEntp) throws IOException, BizException {
		// 组装二进制返回结果
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		ICimrmfileinfoRService mrmService = ServiceFinder.find(ICimrmfileinfoRService.class);
		CiMrmFileInfoDO[] doArr = mrmService.find(" id_bu_sy = '" + ciMrDO.getId_mr() + "' ", " sv desc ", FBoolean.FALSE);

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
	 * 查询并将CA签名信息转换为base64编码
	 * @param ciMrDO
	 * @return
	 * @throws IOException
	 * @throws BizException
	 */
	private String getSignCABase64Code(CiMrDO ciMrDO) throws IOException, BizException {
		// 服务定义
		BusinessStorageService fileService = ServiceFinder.find(BusinessStorageService.class);
		IMrsignMDORService signService = ServiceFinder.find(IMrsignMDORService.class);
		ICiMrSignCaDORService signCAService = ServiceFinder.find(ICiMrSignCaDORService.class);
		
		String resultCode = "";
		
		CiMrSignDO[] ciMrSignDOs = 
				signService.find(" id_mr = '" + ciMrDO.getId_mr() + "' ", "", FBoolean.FALSE);
		if (ciMrSignDOs == null || ciMrSignDOs.length <= 0)
			return resultCode;
		String id_mrsign = ciMrSignDOs[0].getId_mrsign();
		
		CiMrSignCaDO[] ciMrSignCaDOs = 
				signCAService.find(" id_mrsign = '" + id_mrsign + "' ", "", FBoolean.FALSE);
		if (ciMrSignCaDOs == null || ciMrSignCaDOs.length <= 0)
			return resultCode;
		String filepath = ciMrSignCaDOs[0].getCryptd_emr_filepath();
		
		if (filepath == null || "".equals(filepath))
			return resultCode;
		FBinary bin = fileService.read(filepath);
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		bin.writeBodyToStream(os);
		byte[] bytes = os.toByteArray();
		return Base64.bytes2string(bytes);
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
	
	private MrDocRefValueDO[] getMrDocRefValueDOInfo(String id_mr) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a0.Code_data_element, ");
		sb.append(" a0.Code_element, ");
		sb.append(" a0.Content, ");
		sb.append(" a0.Createdby, ");
		sb.append(" a0.Createdtime, ");
		sb.append(" a0.Ds, ");
		sb.append(" a0.Id_docrefvalue, ");
		sb.append(" a0.Id_element, ");
		sb.append(" a0.Id_ent, ");
		sb.append(" a0.Id_grp, ");
		sb.append(" a0.Id_mr, ");
		sb.append(" a0.Id_org, ");
		sb.append(" a0.Modifiedby, ");
		sb.append(" a0.Modifiedtime, ");
		sb.append(" a0.Sv ");
		sb.append(" FROM ci_mr_doc_reference_value a0 ");
		sb.append(" WHERE a0.id_mr = ? ");
		sb.append(" AND a0.ds = 0 ");

		SqlParam sp = new SqlParam();
		sp.addParam(id_mr);
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MrDocRefValueDO> listMr = (List<MrDocRefValueDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(MrDocRefValueDO.class));
		return (MrDocRefValueDO[])listMr.toArray(new MrDocRefValueDO[]{});
	}
	
	private String[] getValueArr(String arr) {
		String[] split = arr.split("\\|");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			string = string.substring(string.indexOf(":") + 1);
			split[i] = string;
		}
		return split;
	}
}
