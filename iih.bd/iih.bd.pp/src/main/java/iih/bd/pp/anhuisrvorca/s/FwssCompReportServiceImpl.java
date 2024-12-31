package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.anhuisrvorca.i.IFwssCompReportService;
import iih.bd.pp.anhuisrvorca.s.bp.FwssCompReportBp;
import iih.bd.pp.anhuisrvorca.s.bp.FwssCompRevokeReportBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保服务设施对照上报服务
 * 
 * @author hao_wu
 *
 */
public class FwssCompReportServiceImpl implements IFwssCompReportService {

	@Override
	public FwssCompDTO[] InsurReport(FwssCompDTO[] fwssCompDtos) throws BizException {
		FwssCompReportBp bp = new FwssCompReportBp();
		FwssCompDTO[] result = bp.exec(fwssCompDtos);
		return result;
	}

	@Override
	public FwssCompDTO[] RevokeInsurReport(FwssCompDTO[] fwssCompDtos) throws BizException {
		FwssCompRevokeReportBp bp = new FwssCompRevokeReportBp();
		FwssCompDTO[] result = bp.exec(fwssCompDtos);
		return result;
	}

}
