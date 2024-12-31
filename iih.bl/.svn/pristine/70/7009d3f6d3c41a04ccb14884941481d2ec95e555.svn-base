package iih.bl.cg.s.cglogic.util;

import iih.bd.base.utils.PrecisionUtils;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendInpBillParamDTO;
import iih.bl.cg.dto.addfee.d.BlCgAddFeeDTO;
import iih.bl.cg.dto.addfee.d.BlCgRefundAddFeeDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 旧接口数据组装类
 * @author ly 2018/04/26
 *
 */
public class BlCgForOldDataUtil {

	/**
	 * 组装纯补费数据
	 * @param enDO
	 * @param feeDtos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static BlOrderAppendBillParamDTO[] assemblePureSrvData(PatiVisitDO enDO,BlCgAddFeeDTO[] feeDtos)throws BizException {
		
		// 服务信息
		List<String> srvIds = new ArrayList<String>();
		Map<String, MedSrvDO> srvMap = new HashMap<String, MedSrvDO>();
		for (BlCgAddFeeDTO feeDto : feeDtos) {
			srvIds.add(feeDto.getId_srv());
		}

		DAFacade daf = new DAFacade();
		List<MedSrvDO> srvDoList = (List<MedSrvDO>) daf.findByPKs(
				MedSrvDO.class, srvIds.toArray(new String[0]));
		if (!ListUtil.isEmpty(srvDoList)) {
			for (MedSrvDO srvDo : srvDoList) {
				srvMap.put(srvDo.getId_srv(), srvDo);
			}
		}

		// 价格信息
		IBdPriCalcService priService = ServiceFinder
				.find(IBdPriCalcService.class);
		Map<String, PriceResultDTO> priMap = priService.batchCalcPatPrice(
				srvIds.toArray(new String[0]), enDO.getId_pripat());

		// 组装记账数据
		FDateTime now = new FDateTime();
		List<BlOrderAppendBillParamDTO> billParamList = new ArrayList<BlOrderAppendBillParamDTO>();

		for (BlCgAddFeeDTO feeDto : feeDtos) {

			BlOrderAppendBillParamDTO blCgDTO = new BlOrderAppendBillParamDTO();
			//患者就诊数据
			blCgDTO.setId_pat(enDO.getId_pat());
			blCgDTO.setId_ent(enDO.getId_ent());
			blCgDTO.setId_enttp(enDO.getId_entp());
			blCgDTO.setCode_enttp(enDO.getCode_entp());

			// 服务信息
			MedSrvDO medSrvDO = srvMap.get(feeDto.getId_srv());
			blCgDTO.setId_srvtp(medSrvDO.getId_srvtp());
			blCgDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
			blCgDTO.setId_srvca(medSrvDO.getId_srvca());
			blCgDTO.setId_srv(medSrvDO.getId_srv());
			blCgDTO.setCode_srv(medSrvDO.getCode());
			blCgDTO.setName_srv(medSrvDO.getName());
			blCgDTO.setSrvu(medSrvDO.getId_unit_med());

			// 价格信息 admDO.getId_srv()
			PriceResultDTO pri = priMap.get(feeDto.getId_srv());
			if (pri == null) {
				continue;
			}
			blCgDTO.setPri_std(pri.getPrice_std());
			blCgDTO.setRatio_pripat(pri.getPrice_ratio());
			blCgDTO.setPri_ratio(pri.getRate());
			blCgDTO.setQuan(new FDouble(feeDto.getQuan())); // 数量
			blCgDTO.setAmt_std(PrecisionUtils.formatAmt(pri.getPrice_std()
					.multiply(blCgDTO.getQuan()))); //标准金额=标准价格*数量
			blCgDTO.setAmt_ratio(PrecisionUtils.formatAmt(pri.getPrice_ratio()
					.multiply(blCgDTO.getQuan()))); //金额_价格比例=折后价格(标准价格*价格比例)*数量   
			blCgDTO.setAmt_pat(blCgDTO.getAmt_ratio());// 自付金额=折后金额
			blCgDTO.setAmt(blCgDTO.getAmt_ratio()); // 金额=折后金额
			blCgDTO.setAmt_hp(FDouble.ZERO_DBL);

			// 记账信息
			blCgDTO.setId_org(enDO.getId_org());
			blCgDTO.setId_grp(enDO.getId_grp());
			blCgDTO.setId_emp_cg(Context.get().getStuffId());// 记账员
			blCgDTO.setId_org_cg(enDO.getId_org());
			blCgDTO.setId_dep_cg(Context.get().getDeptId());// 记账科室
			blCgDTO.setId_dep_or(feeDto.getId_dep_or());
			blCgDTO.setId_emp_or(feeDto.getId_emp_or());
			blCgDTO.setId_dep_mp(feeDto.getId_dep_mp());
			blCgDTO.setFg_mm(FBoolean.FALSE);
			blCgDTO.setDt_cg(now);
			blCgDTO.setFg_additm(FBoolean.TRUE);
			blCgDTO.setSupportAppendBill(FBoolean.TRUE);// 后台划价支持后付费
			blCgDTO.setDt_last_bl(now);// 计费时间
			blCgDTO.setEu_direct(feeDto.getEu_direct());
			blCgDTO.setSrcfunc_des(feeDto.getSrcfunc_des());// 来源入院登记自动记账
			blCgDTO.setId_pripat(enDO.getId_pripat());//患者价格分类
			
			BlOrderAppendInpBillParamDTO inpBillDTO = new BlOrderAppendInpBillParamDTO();
			inpBillDTO.setFg_pddisc(null);// 出院带药标志
			inpBillDTO.setId_wg_or(null);// 医疗组
			inpBillDTO.setId_dep_nur(enDO.getId_dep_nur());
			inpBillDTO.setFg_bb(FBoolean.FALSE);// 婴儿标志
			blCgDTO.setInpBillDTO(inpBillDTO);

			billParamList.add(blCgDTO);
		}
		
		return billParamList.toArray(new BlOrderAppendBillParamDTO[0]);
	}

	/**
	 * 组装退补费数据
	 * @param enDO
	 * @param feeDtos
	 * @return
	 * @throws BizException
	 */
	public static BlOrderAppendBillParamDTO[] assembleRefundPureSrvData(PatiVisitDO enDO, BlCgRefundAddFeeDTO[] feeDtos)throws BizException {
		
		List<BlOrderAppendBillParamDTO> billParamList = new ArrayList<BlOrderAppendBillParamDTO>();

		for (BlCgRefundAddFeeDTO feeDto : feeDtos) {
			
			BlOrderAppendBillParamDTO paramDto = new BlOrderAppendBillParamDTO();
			paramDto.setId_pat(enDO.getId_pat());
			paramDto.setId_ent(enDO.getId_ent());
			paramDto.setId_org(Context.get().getOrgId());
			paramDto.setId_grp(Context.get().getGroupId());
			paramDto.setId_org_cg(Context.get().getOrgId());
			paramDto.setId_dep_cg(Context.get().getDeptId());
			paramDto.setId_emp_cg(Context.get().getStuffId());
			paramDto.setId_or(feeDto.getId_or());
			paramDto.setId_srv(feeDto.getId_srv());
			paramDto.setSrcfunc_des(feeDto.getSrcfunc_des());
			
			BlOrderRefundBillParamDTO blDto = new BlOrderRefundBillParamDTO();
			blDto.setId_cg_pk(feeDto.getId_cg());
			blDto.setId_org_cg(Context.get().getOrgId());
			blDto.setId_dep_cg(Context.get().getDeptId());
			blDto.setId_emp_cg(Context.get().getStuffId());
			
			paramDto.setRefundBillParamDTO(blDto);
			billParamList.add(paramDto);
		}
		
		return billParamList.toArray(new BlOrderAppendBillParamDTO[0]);
	}
}
