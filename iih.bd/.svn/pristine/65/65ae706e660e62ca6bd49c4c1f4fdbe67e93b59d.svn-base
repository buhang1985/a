package iih.bd.pp.hpdivshisdto.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO;
import iih.bd.pp.anhuiinsur.i.IBdhpdiorginalRService;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 补全医保诊断信息业务逻辑</br>
 * 选择医保诊断参照后进行补全
 * 
 * @author hao_wu
 *
 */
public class CompInsurDiDataBp {

	public HpDiVsHisDTO[] exec(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException {
		if (hpDiVsHisDTOs == null) {
			return null;
		}
		CompInsurDiData(hpDiVsHisDTOs);
		return hpDiVsHisDTOs;
	}

	/**
	 * 补全医保诊断信息列表
	 * 
	 * @param hpDiVsHisDTOs
	 * @throws BizException
	 */
	private void CompInsurDiData(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException {
		for (HpDiVsHisDTO hpDiVsHisDTO : hpDiVsHisDTOs) {
			CompInsurDiData(hpDiVsHisDTO);
		}
	}

	/**
	 * 补全医保诊断信息
	 * 
	 * @param hpDiVsHisDTO
	 * @throws BizException
	 */
	private void CompInsurDiData(HpDiVsHisDTO hpDiVsHisDTO) throws BizException {
		if (hpDiVsHisDTO == null) {
			return;
		}
		if (StringUtils.isBlank(hpDiVsHisDTO.getHpdidict_code())) {
			ClearInsurDiDataBp bp = new ClearInsurDiDataBp();
			bp.exec(hpDiVsHisDTO);
		}
		BdHpDiOrginalDO bdHpDiOrginalDO = GetInsurDiByCode(hpDiVsHisDTO.getHpdidict_code(),hpDiVsHisDTO.getId_hp());
		CompInsurDiData(hpDiVsHisDTO, bdHpDiOrginalDO);
	}

	/**
	 * 使用医保诊断编码查询医保诊断
	 * 
	 * @param hpdidict_code
	 * @return
	 * @throws BizException
	 */
	private BdHpDiOrginalDO GetInsurDiByCode(String hpdidict_code,String id_hp) throws BizException {
		if (StringUtils.isEmpty(hpdidict_code)) {
			return null;
		}
		IBdhpdiorginalRService bdhpdiorginalRService = ServiceFinder.find(IBdhpdiorginalRService.class);
		String sql = " Code='"+hpdidict_code+"' and Id_hp='"+id_hp+"' ";
		BdHpDiOrginalDO[] result = bdhpdiorginalRService.find(sql, "",FBoolean.FALSE);
		if (result == null || result.length <= 0) {
			String msg = String.format("获取医保诊断失败，医保诊断编码：\"%s\"。", hpdidict_code);
			throw new BizException(msg);
		}
		return result[0];
	}

	/**
	 * 补全医保诊断信息
	 * 
	 * @param hpDiVsHisDTO
	 * @param bdHpDiOrginalDO
	 */
	private void CompInsurDiData(HpDiVsHisDTO hpDiVsHisDTO, BdHpDiOrginalDO bdHpDiOrginalDO) {
		if (hpDiVsHisDTO == null) {
			return;
		}

		if (bdHpDiOrginalDO == null) {
			ClearInsurDiData(hpDiVsHisDTO);
			return;
		}

		hpDiVsHisDTO.setId_hp(bdHpDiOrginalDO.getId_hp());
		hpDiVsHisDTO.setId_hpdidict(bdHpDiOrginalDO.getId_hpdiorginal());
		hpDiVsHisDTO.setHpdidict_name(bdHpDiOrginalDO.getName());
		hpDiVsHisDTO.setHpdidict_code(bdHpDiOrginalDO.getCode());
		hpDiVsHisDTO.setClassific_di(bdHpDiOrginalDO.getClassific_di());
		hpDiVsHisDTO.setStr_di_spec(bdHpDiOrginalDO.getStr_di_spec());
		hpDiVsHisDTO.setStr_di_pay(bdHpDiOrginalDO.getStr_di_pay());
		hpDiVsHisDTO.setClassific_di_spec(bdHpDiOrginalDO.getClassific_di_spec());
		hpDiVsHisDTO.setStr_treatment_plan(bdHpDiOrginalDO.getStr_treatment_plan());
		hpDiVsHisDTO.setPay_max(bdHpDiOrginalDO.getPay_max());
		hpDiVsHisDTO.setTr_bind_deductible(bdHpDiOrginalDO.getTr_bind_deductible());
		hpDiVsHisDTO.setPay_small_45_oep(bdHpDiOrginalDO.getPay_small_45_oep());
		hpDiVsHisDTO.setPay_big_45_oep(bdHpDiOrginalDO.getPay_big_45_oep());
		hpDiVsHisDTO.setPay_small_45_ip(bdHpDiOrginalDO.getPay_small_45_ip());
		hpDiVsHisDTO.setPay_big_45_ip(bdHpDiOrginalDO.getPay_big_45_ip());
		hpDiVsHisDTO.setPay_retire_oep(bdHpDiOrginalDO.getPay_retire_oep());
		hpDiVsHisDTO.setPay_retire_ip(bdHpDiOrginalDO.getPay_retire_ip());
		hpDiVsHisDTO.setAmt_amount_disease(bdHpDiOrginalDO.getAmt_amount_disease());
		hpDiVsHisDTO.setPy_code(bdHpDiOrginalDO.getPy_code());
		hpDiVsHisDTO.setWb_code(bdHpDiOrginalDO.getWb_code());
		hpDiVsHisDTO.setZdy_code(bdHpDiOrginalDO.getZdy_code());
		hpDiVsHisDTO.setStr_effective(bdHpDiOrginalDO.getStr_effective());
		hpDiVsHisDTO.setId_emp_handle(bdHpDiOrginalDO.getId_emp_handle());
		hpDiVsHisDTO.setDt_handle(ConvertToDateTime(bdHpDiOrginalDO.getDt_handle()));
		hpDiVsHisDTO.setPay_mx_small_45oep(bdHpDiOrginalDO.getPay_mx_small_45oep());
		hpDiVsHisDTO.setPay_mx_big_45oep(bdHpDiOrginalDO.getPay_mx_big_45oep());
		hpDiVsHisDTO.setNote(bdHpDiOrginalDO.getNote());
		if (hpDiVsHisDTO.getStatus() == DOStatus.UNCHANGED) {
			hpDiVsHisDTO.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 清除医保诊断关联数据
	 * 
	 * @param hpDiVsHisDTO
	 */
	private void ClearInsurDiData(HpDiVsHisDTO hpDiVsHisDTO) {
		hpDiVsHisDTO.setId_hpdidict(null);
		hpDiVsHisDTO.setHpdidict_name(null);
		hpDiVsHisDTO.setHpdidict_code(null);
		hpDiVsHisDTO.setClassific_di(null);
		hpDiVsHisDTO.setStr_di_spec(null);
		hpDiVsHisDTO.setStr_di_pay(null);
		hpDiVsHisDTO.setClassific_di_spec(null);
		hpDiVsHisDTO.setStr_treatment_plan(null);
		hpDiVsHisDTO.setPay_max(null);
		hpDiVsHisDTO.setTr_bind_deductible(null);
		hpDiVsHisDTO.setPay_small_45_oep(null);
		hpDiVsHisDTO.setPay_big_45_oep(null);
		hpDiVsHisDTO.setPay_small_45_ip(null);
		hpDiVsHisDTO.setPay_big_45_ip(null);
		hpDiVsHisDTO.setPay_retire_oep(null);
		hpDiVsHisDTO.setPay_retire_ip(null);
		hpDiVsHisDTO.setAmt_amount_disease(null);
		hpDiVsHisDTO.setPy_code(null);
		hpDiVsHisDTO.setWb_code(null);
		hpDiVsHisDTO.setZdy_code(null);
		hpDiVsHisDTO.setStr_effective(null);
		hpDiVsHisDTO.setId_emp_handle(null);
		hpDiVsHisDTO.setDt_handle(null);
		hpDiVsHisDTO.setPay_mx_small_45oep(null);
		hpDiVsHisDTO.setPay_mx_big_45oep(null);
		hpDiVsHisDTO.setNote(null);
		if (hpDiVsHisDTO.getStatus() == DOStatus.UNCHANGED) {
			hpDiVsHisDTO.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 转换为日期时间格式
	 * 
	 * @param dateTimeStr
	 * @return
	 */
	private FDateTime ConvertToDateTime(String dateTimeStr) {
		if (!StringUtil.isEmpty(dateTimeStr) && dateTimeStr.length() == 14) {
			String newValue = String.format("%s-%s-%s %s:%s:%s", dateTimeStr.substring(0, 4),
					dateTimeStr.substring(4, 6), dateTimeStr.substring(6, 8), dateTimeStr.substring(8, 10),
					dateTimeStr.substring(10, 12), dateTimeStr.substring(12, 14));
			return new FDateTime(newValue);
		}
		return null;
	}
}
