package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.i.IDrugCompReportService;
import iih.bd.pp.anhuisrvorca.s.bp.DrugCompReportBp;
import iih.bd.pp.anhuisrvorca.s.bp.DrugCompRevokeReportBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保药品对照上报服务
 * 
 * @author hao_wu
 *
 */
public class DrugCompReportServiceImpl implements IDrugCompReportService {

	@Override
	public DrugCompDTO[] InsurReport(DrugCompDTO[] drugCompDtos) throws BizException {
		DrugCompReportBp bp = new DrugCompReportBp();
		DrugCompDTO[] result = bp.exec(drugCompDtos);
		return result;
	}

	@Override
	public DrugCompDTO[] RevokeInsurReport(DrugCompDTO[] drugCompDtos) throws BizException {
		DrugCompRevokeReportBp bp = new DrugCompRevokeReportBp();
		DrugCompDTO[] result = bp.exec(drugCompDtos);
		return result;
	}

}
