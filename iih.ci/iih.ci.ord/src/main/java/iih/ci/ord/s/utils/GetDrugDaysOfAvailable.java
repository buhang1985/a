package iih.ci.ord.s.utils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取领量天数
 */
public class GetDrugDaysOfAvailable {
	
	public int exec(CiEmsSrvDTO srvDTO) throws BizException {
		
		if (StringUtil.isEmpty(srvDTO.getSd_srvtp()) || StringUtil.isEmpty(srvDTO.getId_mm())
				|| StringUtil.isEmpty(srvDTO.getId_unit_sale())) {
			return 0;
		}

		if (srvDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || srvDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
			if (StringUtil.isEmpty(srvDTO.getId_freq())) {
				throw new BizException(srvDTO.getName_srv() + " 频次为空");
			}
			
			DAFacade dafacade = new DAFacade();
			String sql =" select Freqct from bd_freq where id_freq = ? ";
			SqlParam sqlParam = new SqlParam();
			sqlParam.addParam(srvDTO.getId_freq());
			
			FreqDefDO freqDef = (FreqDefDO)dafacade.execQuery(sql, sqlParam, new BeanHandler(FreqDefDO.class));
			if (freqDef != null) {
				// 变动用药
				if (srvDTO.getFg_dose_anoma() != null && srvDTO.getFg_dose_anoma().booleanValue()) {
					// 需要变动用药逻辑
				} else {
					// 取值总量单位的换算系数和物品的取整模式
					FDouble factor = new GetDrugSaleFactor().exec(srvDTO.getId_mm(), srvDTO.getId_unit_sale());

					if (null != freqDef.getFreqct() && 0 != freqDef.getFreqct() && null != srvDTO.getQuan_med()
							&& 0 != srvDTO.getQuan_med().doubleValue()) {
						double days = ((srvDTO.getQuan_cur()==null?new FDouble(0):srvDTO.getQuan_cur()).doubleValue() * factor.doubleValue()
								* srvDTO.getFactor_mb().doubleValue())
								/ (freqDef.getFreqct().doubleValue() * srvDTO.getQuan_med().doubleValue());

						return (int) days;
					}
				}
			}
		}
		return 0;
	}
}
