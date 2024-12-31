package iih.bd.srv.medsrv.s.rule.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 检查默认用量单位业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckUnitMedBp {
	public void exec(MedSrvDO[] medSrvDOs) throws BizException {
		if (medSrvDOs == null || medSrvDOs.length <= 0) {
			return;
		}
		CheckUnitMed(medSrvDOs);
	}

	/**
	 * 检查默认用量单位
	 * 
	 * @param medSrvDOs
	 * @throws BizException
	 */
	private void CheckUnitMed(MedSrvDO[] medSrvDOs) throws BizException {
		FBoolean unitNullFlag = BdPpParamUtils.GetUnitNullFlag();
		if (FBoolean.TRUE.equals(unitNullFlag)) {
			return;
		}
		for (MedSrvDO medSrvDO : medSrvDOs) {
			CheckUnitMed(medSrvDO);
		}
	}

	/**
	 * 检查默认用量单位
	 * 
	 * @param medSrvDO
	 * @throws BizException
	 */
	private void CheckUnitMed(MedSrvDO medSrvDO) throws BizException {
		if (!StringUtils.isEmpty(medSrvDO.getSd_srvtp())
				&& !medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
				&& StringUtils.isEmpty(medSrvDO.getId_unit_med())) {
			String msg = GetErrorMsg(medSrvDO);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取错误信息
	 * 
	 * @param medSrvDO
	 * @return
	 */
	private String GetErrorMsg(MedSrvDO medSrvDO) {
		if (!StringUtils.isEmpty(medSrvDO.getSd_primd())
				&& medSrvDO.getSd_primd().equals(IBdPrimdCodeConst.CODE_PRI_SRV)) {
			return String.format("服务项目\"%s\"计量单位不允许为空。", medSrvDO.getName());
		}
		return String.format("服务项目\"%s\"默认用量单位不允许为空。", medSrvDO.getName());
	}
}
