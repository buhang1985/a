package iih.bl.cg.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.dto.oepcg4en.d.BlCgUnpay4EnDTO;
import iih.bl.comm.util.BlFlowParamLoader;
import iih.bl.params.BlParams;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargePricingRltDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSetDTO;
import iih.bl.st.i.IBlOepChargeCmdService;
import iih.bl.st.i.IBlOepChargeQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 查询患者门诊待交费数据
 * @author ly 2019/02/26
 *
 */
public class GetOepUnpayDetailBP {

	/**
	 * 查询患者门诊待交费数据
	 * @param patId 患者id
	 * @param days 查询天数
	 * @return 待交费数据
	 * @throws BizException
	 */
	public BlCgUnpay4EnDTO[] exec(String patId, Integer days) throws BizException{
		
		if(StringUtil.isEmpty(patId))
			return null;
		
		if(days == null){
			BlFlowParamLoader paramLoader = new BlFlowParamLoader();
			paramLoader.loadOepCostParam();
			
			days = BlParams.BLSTOEP0004();
		}
		
		FDate dtEnd = AppUtils.getServerDate();
		FDate dtBegin = dtEnd.getDateBefore(days);
		
		Context.get().setAttribute("fg_qrycg","Y");
		
		IBlOepChargeQryService oepRService = ServiceFinder.find(IBlOepChargeQryService.class);
		BlOepChargeInputDTO[] oepDatas = oepRService.findOepCostInfoPeriod(patId, dtEnd, dtBegin);
		if(ArrayUtil.isEmpty(oepDatas)){
			return null;
		}
		
		List<BlOepChargePricingDTO> pricingList = new ArrayList<BlOepChargePricingDTO>();
		for (BlOepChargeInputDTO oepCgDto : oepDatas) {
			
			BlOepChargePricingDTO pricingDto = new BlOepChargePricingDTO();
			pricingDto.setId_pat(oepCgDto.getId_pat());
			pricingDto.setId_ent(oepCgDto.getId_ent());
			pricingDto.setId_or(oepCgDto.getId_or());
			pricingDto.setId_orsrv(oepCgDto.getId_orsrv());
			pricingDto.setId_srv(oepCgDto.getId_srv());
			pricingDto.setId_mm(oepCgDto.getId_mm());
			pricingDto.setSrvu(oepCgDto.getSrvu());
			pricingDto.setId_pripat(oepCgDto.getId_pripat());
			pricingDto.setId_paticate(oepCgDto.getId_paticate());
			pricingDto.setFg_mm(oepCgDto.getFg_mm());
			pricingDto.setQuan(oepCgDto.getQuan());
			pricingDto.setId_dep_mp(oepCgDto.getId_dep_mp());
			pricingDto.setId_dep_wh(oepCgDto.getId_dep_wh());
			pricingDto.setFg_or(oepCgDto.getFg_or());
			pricingList.add(pricingDto);
		}
		BlOepChargeSetDTO chargeSet = new BlOepChargeSetDTO();
		chargeSet.setId_pat(patId);;
		
		IBlOepChargeCmdService oepCService = ServiceFinder.find(IBlOepChargeCmdService.class);
		BlOepChargePricingRltDTO[] pricingRltDtos = oepCService.prePricing(pricingList.toArray(new BlOepChargePricingDTO[0]), chargeSet);
		
		List<BlCgUnpay4EnDTO> cgEnDtoList = new ArrayList<BlCgUnpay4EnDTO>();
		for (int i = 0; i < oepDatas.length; i++) {
			
			BlOepChargePricingRltDTO priRltDto = pricingRltDtos[i];
			BlOepChargeInputDTO oepCgDto = oepDatas[i];
			
			BlCgUnpay4EnDTO cgEnDto = new BlCgUnpay4EnDTO();
			cgEnDto.setId_or(oepCgDto.getId_or());
			cgEnDto.setId_srv(oepCgDto.getId_srv());
			cgEnDto.setCode_srv(oepCgDto.getCode_srv());
			cgEnDto.setName_srv(oepCgDto.getName_srv());
			cgEnDto.setId_mm(oepCgDto.getId_mm());
			cgEnDto.setName_mm(oepCgDto.getName_mm());
			cgEnDto.setPrice_ratio(priRltDto.getPrice_ratio());
			cgEnDto.setQuan(oepCgDto.getQuan());
			cgEnDto.setAmt_ratio(priRltDto.getAmt_ratio());
			cgEnDto.setId_measdoc(oepCgDto.getSrvu());
			cgEnDto.setName_measdoc(oepCgDto.getSrvu_name());
		    cgEnDto.setSpec(oepCgDto.getSpec());
			cgEnDto.setId_dep_or(oepCgDto.getId_dep_or());
			cgEnDto.setName_dep_or(oepCgDto.getName_dep_or());
			cgEnDto.setId_emp_or(oepCgDto.getId_emp_or());
			cgEnDto.setName_emp_or(oepCgDto.getName_emp_or());
			cgEnDto.setCode_or(oepCgDto.getCode_or());
			cgEnDto.setContent_or(oepCgDto.getContent_or());
			
			cgEnDtoList.add(cgEnDto);
		}
		
		return cgEnDtoList.toArray(new BlCgUnpay4EnDTO[0]);
	}
}
