package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import xap.mw.core.data.DOStatus;

/**
 * 清除服务设施对照中的医保服务设施信息
 * 
 * @author hao_wu
 *
 */
public class ClearInsurFwssDataBp {

	public void exec(FwssCompDTO fwssCompDTO) {
		fwssCompDTO.setId_srv(null);
		fwssCompDTO.setSrv_code(null);
		fwssCompDTO.setSrv_name(null);
		fwssCompDTO.setSrv_price(null);
//		fwssCompDTO.setId_hp(null);
//		fwssCompDTO.setId_hpfwssorginal(null);
//		fwssCompDTO.setName(null);
//		fwssCompDTO.setCode(null);
//		fwssCompDTO.setCode_ca(null);
//		fwssCompDTO.setSd_hpsrvtp(null);
//		fwssCompDTO.setPri_max(null);
//		fwssCompDTO.setRetire_ey_pri_max(null);
//		fwssCompDTO.setDes(null);
//		fwssCompDTO.setDt_b(null);
//		fwssCompDTO.setDt_e(null);
//		fwssCompDTO.setHospital_code(null);
//		fwssCompDTO.setStr_effective(null);
//		fwssCompDTO.setHospital_rank(null);
//		fwssCompDTO.setHospital_bed_rank(null);
//		fwssCompDTO.setFwss_pay_standard(null);
//		fwssCompDTO.setId_emp_handle(null);
//		fwssCompDTO.setDt_handle(null);
//		fwssCompDTO.setPy_code(null);
//		fwssCompDTO.setWb_code(null);
//		fwssCompDTO.setZdy_code(null);
//		fwssCompDTO.setStr_prc_drug_list(null);
//		fwssCompDTO.setStr_prc_b_drug_list(null);
//		fwssCompDTO.setStr_resident_use(null);
		fwssCompDTO.setStatus(DOStatus.UNCHANGED);
	}
}
