package iih.bd.pp.anhuisrvorca.s;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.i.ITreatCompReportService;
import iih.bd.pp.anhuisrvorca.s.bp.TreatCompReportBp;
import iih.bd.pp.anhuisrvorca.s.bp.TreatCompRevokeReportBp;
import xap.mw.core.data.BizException;

/**
 * 安徽东软医保诊疗对照上报服务
 * 
 * @author hao_wu
 *
 */
public class TreatCompReportServiceImpl implements ITreatCompReportService {

	@Override
	public TreatCompDTO[] InsurReport(TreatCompDTO[] treatCompDtos) throws BizException {
		TreatCompReportBp bp = new TreatCompReportBp();
		TreatCompDTO[] result = bp.exec(treatCompDtos);
		return result;
	}

	@Override
	public TreatCompDTO[] RevokeInsurReport(TreatCompDTO[] treatCompDtos) throws BizException {
		TreatCompRevokeReportBp bp = new TreatCompRevokeReportBp();
		TreatCompDTO[] result = bp.exec(treatCompDtos);
		return result;
	}

}
