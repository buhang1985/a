package iih.bl.hp.s.bp;

import iih.bl.hp.dto.d.HpSettledReportDTO;
import iih.bl.hp.s.bp.qry.GetSettledReportInfoQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 获取医保结算单信息
 * @author liwq
 */
public class GetSettledReportInfoBp {

	public HpSettledReportDTO[] exec(QryRootNodeDTO qryRootNodeDTO) throws BizException  {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereSql = ser.getQueryStringWithoutDesc(qryRootNodeDTO);
		
		HpSettledReportDTO[] hpSettledDto = null;
		hpSettledDto = (HpSettledReportDTO[]) AppFwUtil.getDORstWithDao(new GetSettledReportInfoQry(whereSql), HpSettledReportDTO.class);
		
		return hpSettledDto;
	}
}
