package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保诊疗对照上报服务
 * 
 * @author hao_wu
 *
 */
public interface ITreatCompReportService {
	/**
	 * 医保诊疗对照上报
	 * 
	 * @param treatCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] InsurReport(TreatCompDTO[] treatCompDtos) throws BizException;

	/**
	 * 医保诊疗对照上报撤销
	 * 
	 * @param treatCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] RevokeInsurReport(TreatCompDTO[] treatCompDtos) throws BizException;
}
