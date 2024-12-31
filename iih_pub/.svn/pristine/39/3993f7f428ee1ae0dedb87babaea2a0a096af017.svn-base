package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保药品对照上报服务
 * 
 * @author hao_wu
 *
 */
public interface IDrugCompReportService {

	/**
	 * 医保药品对照上报
	 * 
	 * @param drugCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] InsurReport(DrugCompDTO[] drugCompDtos) throws BizException;

	/**
	 * 医保药品对照上报撤销
	 * 
	 * @param drugCompDtos
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] RevokeInsurReport(DrugCompDTO[] drugCompDtos) throws BizException;
}
