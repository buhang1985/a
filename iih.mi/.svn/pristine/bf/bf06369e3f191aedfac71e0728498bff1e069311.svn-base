package iih.mi.inst.bizbase.bp;

import iih.bd.bc.param.IBdPpParamValueConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;

/**
 * @author dj.zhang
 *
 */
public class SetMiInfoBp {

	public void exec(HPSrvorcaDO[] hpSrvorcaDOs) throws BizException {
		if (hpSrvorcaDOs == null || hpSrvorcaDOs.length <= 0) {
			return;
		}

		setMiInfo(hpSrvorcaDOs);
	}

	/**
	 * 设置医保信息
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void setMiInfo(HPSrvorcaDO[] hpSrvorcaDOs) throws BizException {
		String miDrugNameType = BdPpParamUtils.GetMiDrugNameType();

		for (HPSrvorcaDO hpSrvorcaDO : hpSrvorcaDOs) {
			SetHisInfo(hpSrvorcaDO, miDrugNameType);
		}
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param hpSrvorcaDO
	 * @throws BizException
	 */
	private void SetHisInfo(HPSrvorcaDO hpSrvorcaDO, String miDrugNameType) throws BizException {
		Integer hpSrvTp = hpSrvorcaDO.getEu_hpsrvtp();
		if (HpSrvTpEnum.DRUG.equals(hpSrvTp)) {
			hpSrvorcaDO.setHis_code(hpSrvorcaDO.getMm_code());

			if (IBdPpParamValueConst.MI_DRUGNAMETYP_MMNAME.equals(miDrugNameType)) {
				hpSrvorcaDO.setHis_name(hpSrvorcaDO.getMm_name());
			} else if (IBdPpParamValueConst.MI_DRUGNAMETYP_SRVNAME.equals(miDrugNameType)) {
				hpSrvorcaDO.setHis_name(hpSrvorcaDO.getSrv_name());
			} else if (IBdPpParamValueConst.MI_DRUGNAMETYP_MINAME.equals(miDrugNameType)) {
				hpSrvorcaDO.setHis_name(hpSrvorcaDO.getMm_hiname());
			} else {
				throw new BizException("不支持的参数值。");
			}

		} else {
			hpSrvorcaDO.setHis_code(hpSrvorcaDO.getSrv_code());
			hpSrvorcaDO.setHis_name(hpSrvorcaDO.getSrv_name());
		}
	}

}
