package iih.ci.preop.imp.bp.convert;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.preop.imp.utils.ImportPreUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.d.CiTsApObsDO;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsaplabRService;
import iih.ci.tsip.i.ICitsapobsRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预住院申请导入，申请单信息转换
 * @author mkp
 *
 */
public class PreIpApplyOrderAppInfoConvertor {
	// 上下文
	CiEnContextDTO ctx;

	public PreIpApplyOrderAppInfoConvertor(CiEnContextDTO ctx) {
		this.ctx = ctx;
	}
	
	public void transfer(CiTsOrDO tsOrder, CiEmsDTO ciEmsDTO) throws BizException {
		if (ObjectUtils.isEmpty(ciEmsDTO)) {
			return;
		}
		
		Integer emsType = ciEmsDTO.getEmstype();
		if (EmsType.LIS.equals(emsType)) {
			// 检验申请
			transferLisAppInfo(ciEmsDTO, tsOrder);
		} else if (EmsType.RIS.equals(emsType)) {
			// 检查申请
			transferRisAppInfo(ciEmsDTO, tsOrder);
		}
			
	}

	/**
	 * 检查申请
	 * 
	 * @param id_or
	 * @param ciEmsDTO
	 * @param tsOrder
	 * @throws BizException
	 */
	private void transferRisAppInfo(CiEmsDTO ciEmsDTO, CiTsOrDO tsOrder) throws BizException {
		CiTsApObsDO[] tsApObsDOs = ServiceFinder.find(ICitsapobsRService.class)
				.find("a0.id_tsor = '" + tsOrder.getId_tsor() + "'", "", FBoolean.FALSE);

		if (ObjectUtils.isEmpty(tsApObsDOs)) {
			return;
		}

		CiTsApObsDO tsApLabDO = tsApObsDOs[0];
		OrdApObsDO ordApObsDO = new OrdApObsDO();
//		String id_orobs = new DBUtil().getOIDs(1)[0];
//		ordApObsDO.setId_orobs(id_orobs);
		ordApObsDO.setNo_applyform(ImportPreUtils.getApplyNoCiEms(ciEmsDTO.getSd_srvtp()));
		ordApObsDO.setId_or(ciEmsDTO.getId_or());
		ordApObsDO.setId_pps(tsApLabDO.getId_pps());
		ordApObsDO.setSd_pps(tsApLabDO.getSd_pps());
		ordApObsDO.setName_pps(tsApLabDO.getName_pps());
		ordApObsDO.setDes_pps(tsApLabDO.getDes_pps());
		ordApObsDO.setDes_sympsign(tsApLabDO.getDes_sympsign());
		ordApObsDO.setAnnouncements(tsApLabDO.getAnnouncements());
		ordApObsDO.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
		ordApObsDO.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
		ordApObsDO.setFg_prn(FBoolean.FALSE);
		ordApObsDO.setCnt_prn(0);
		
		// 查询诊断信息
		String[] diags = ImportPreUtils.getDiag(ctx.getId_en());
		if (diags != null && diags.length > 0) {
			ordApObsDO.setId_di(diags[7]);// 临床诊断
			ordApObsDO.setName_di(diags[4]);// 诊断名称 
			ordApObsDO.setName_diag(diags[4]); // 诊断名称 
			ordApObsDO.setId_diitm(diags[3]); // 诊断明细
			ordApObsDO.setStr_name_di(diags[0]);//诊断名称拼接
			ordApObsDO.setStr_id_diitm(diags[2]);//临床诊断id拼接
			ordApObsDO.setStr_code_di(diags[1]);//诊断编码拼接
		}
		ordApObsDO.setClinicalzztz(ImportPreUtils.DiseaseDescription(ctx.getId_en()));
		if(!ImportPreUtils.isEmpty(ordApObsDO.getStr_name_di())){
			ordApObsDO.setClinicalzztz((ImportPreUtils.isEmpty(ordApObsDO.getClinicalzztz())?"":(ordApObsDO.getClinicalzztz()+"\r\n"))+ "诊断：" + ordApObsDO.getStr_name_di().replace("&", "；"));//拼接诊断
		}
		
		// 计划时间
		ordApObsDO.setDt_plan(ciEmsDTO.getDt_begin());
//		ordApObsDO.setFg_mp_bed(Fg_mp_bed);
		
		
		ordApObsDO.setDef1(tsApLabDO.getDef1());
		ordApObsDO.setDef2(tsApLabDO.getDef2());
		ordApObsDO.setDef3(tsApLabDO.getDef3());
		ordApObsDO.setDef4(tsApLabDO.getDef4());
		ordApObsDO.setDef5(tsApLabDO.getDef5());
		ordApObsDO.setDef6(tsApLabDO.getDef6());
		ordApObsDO.setDef7(tsApLabDO.getDef7());
		ordApObsDO.setDef8(tsApLabDO.getDef8());
		ordApObsDO.setDef9(tsApLabDO.getDef9());
		ordApObsDO.setDef10(tsApLabDO.getDef10());
		ordApObsDO.setDef11(tsApLabDO.getDef11());
		ordApObsDO.setDef12(tsApLabDO.getDef12());
		ordApObsDO.setDef13(tsApLabDO.getDef13());
		ordApObsDO.setDef14(tsApLabDO.getDef14());
		ordApObsDO.setDef15(tsApLabDO.getDef15());
		ordApObsDO.setDef16(tsApLabDO.getDef16());
		ordApObsDO.setDef17(tsApLabDO.getDef17());
		ordApObsDO.setDef18(tsApLabDO.getDef18());
		ordApObsDO.setDef19(tsApLabDO.getDef19());
		ordApObsDO.setDef20(tsApLabDO.getDef20());
		ordApObsDO.setDef21(tsApLabDO.getDef21());
		ordApObsDO.setDef22(tsApLabDO.getDef22());
		ordApObsDO.setDef23(tsApLabDO.getDef23());
		ordApObsDO.setDef24(tsApLabDO.getDef24());
		ordApObsDO.setDef25(tsApLabDO.getDef25());
		ordApObsDO.setDef26(tsApLabDO.getDef26());
		ordApObsDO.setDef27(tsApLabDO.getDef27());
		ordApObsDO.setDef28(tsApLabDO.getDef28());
		ordApObsDO.setDef29(tsApLabDO.getDef29());
		ordApObsDO.setDef30(tsApLabDO.getDef30());
		ordApObsDO.setDef31(tsApLabDO.getDef31());
		ordApObsDO.setDef32(tsApLabDO.getDef32());
		ordApObsDO.setDef33(tsApLabDO.getDef33());
		ordApObsDO.setDef34(tsApLabDO.getDef34());
		ordApObsDO.setDef35(tsApLabDO.getDef35());
		ordApObsDO.setDef36(tsApLabDO.getDef36());
		ordApObsDO.setDef37(tsApLabDO.getDef37());
		ordApObsDO.setDef38(tsApLabDO.getDef38());
		ordApObsDO.setDef39(tsApLabDO.getDef39());
		ordApObsDO.setDef40(tsApLabDO.getDef40());
		ordApObsDO.setDef41(tsApLabDO.getDef41());
		ordApObsDO.setDef42(tsApLabDO.getDef42());
		ordApObsDO.setDef43(tsApLabDO.getDef43());
		ordApObsDO.setDef44(tsApLabDO.getDef44());
		ordApObsDO.setDef45(tsApLabDO.getDef45());
		ordApObsDO.setDef46(tsApLabDO.getDef46());
		ordApObsDO.setDef47(tsApLabDO.getDef47());
		ordApObsDO.setDef48(tsApLabDO.getDef48());
		ordApObsDO.setDef49(tsApLabDO.getDef49());
		ordApObsDO.setDef50(tsApLabDO.getDef50());
		ordApObsDO.setStatus(DOStatus.NEW);
		
		
		FMap map = new FMap();
		map.put(ciEmsDTO.getEmstype() + "", ordApObsDO);
		ciEmsDTO.setOrapplysheet(map);
		ciEmsDTO.setApplyno(ordApObsDO.getNo_applyform());
	}

	/**
	 * 检验申请
	 * 
	 * @param id_or
	 * @param ciEmsDTO
	 * @param tsOrder
	 * @throws BizException
	 */
	private void transferLisAppInfo(CiEmsDTO ciEmsDTO, CiTsOrDO tsOrder) throws BizException {
		CiTsApLabDO[] tsApLabDOs = ServiceFinder.find(ICitsaplabRService.class)
				.find("a0.id_tsor = '" + tsOrder.getId_tsor() + "'", "", FBoolean.FALSE);

		if (ObjectUtils.isEmpty(tsApLabDOs)) {
			return;
		}

		CiTsApLabDO tsApLabDO = tsApLabDOs[0];
		OrdApLabDO ordApLabDO = new OrdApLabDO();
//		String id_orlab = new DBUtil().getOIDs(1)[0];
//		ordApLabDO.setId_orlab(id_orlab);
		ordApLabDO.setNo_applyform(ImportPreUtils.getApplyNoCiEms(ciEmsDTO.getSd_srvtp()));
		ordApLabDO.setId_or(ciEmsDTO.getId_or());
		ordApLabDO.setId_samptp(tsApLabDO.getId_samptp());
		ordApLabDO.setSd_samptp(tsApLabDO.getSd_samptp());
		ordApLabDO.setName_samptp(tsApLabDO.getName_samptp());
		ordApLabDO.setId_sampcoltime(tsApLabDO.getId_sampcoltime());
		ordApLabDO.setId_sampcollecttimetp(tsApLabDO.getId_sampcollecttimetp());
		ordApLabDO.setId_unit_sampcoltime(tsApLabDO.getId_unit_sampcoltime());
		ordApLabDO.setSd_sampcollecttimetp(tsApLabDO.getSd_sampcollecttimetp());
		ordApLabDO.setName_sampcoltime(tsApLabDO.getName_sampcoltime());
		ordApLabDO.setLen_sampcoltime(tsApLabDO.getLen_sampcoltime());
		ordApLabDO.setId_su_lab(ICiDictCodeConst.ID_CI_LAB_SQ);
		ordApLabDO.setSd_su_lab(ICiDictCodeConst.SD_CI_LAB_SQ);
		ordApLabDO.setFg_prn(FBoolean.FALSE);
		ordApLabDO.setCnt_prn(0);
		
		// 查询诊断信息
		String[] diags = ImportPreUtils.getDiag(ctx.getId_en());
		if (diags != null && diags.length > 0) {
			ordApLabDO.setId_di(diags[7]);// 临床诊断
			ordApLabDO.setName_diag(diags[4]);// 诊断名称 
			ordApLabDO.setName_diag(diags[4]); // 诊断名称 
			ordApLabDO.setId_diitm(diags[3]); // 诊断明细
			ordApLabDO.setStr_name_di(diags[0]);//诊断名称拼接
			ordApLabDO.setStr_id_diitm(diags[2]);//临床诊断id拼接
			ordApLabDO.setStr_code_di(diags[1]);//诊断编码拼接
		}
		ordApLabDO.setClinicalzztz(ImportPreUtils.DiseaseDescription(ctx.getId_en()));
		if(!ImportPreUtils.isEmpty(ordApLabDO.getStr_name_di())){
			ordApLabDO.setClinicalzztz((ImportPreUtils.isEmpty(ordApLabDO.getClinicalzztz())?"":(ordApLabDO.getClinicalzztz()+"\r\n"))+ "诊断：" + ordApLabDO.getStr_name_di().replace("&", "；"));//拼接诊断
		}
		
		// 计划时间
		ordApLabDO.setDt_plan(ciEmsDTO.getDt_begin());
		
		ordApLabDO.setStatus(DOStatus.NEW);

		FMap map = new FMap();
		map.put(ciEmsDTO.getEmstype() + "", ordApLabDO);
		ciEmsDTO.setOrapplysheet(map);
		ciEmsDTO.setApplyno(ordApLabDO.getNo_applyform());
	}
}
