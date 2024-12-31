package iih.ci.ord.s.bp;

import iih.ci.ord.dto.d.CiOrdModifyEndTimeDTO;
import iih.ci.ord.s.bp.qry.GetOrdAlwaysQry;
import iih.mp.nr.outpatskin.d.ContentOrDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class GetCiOrdIsAlwaysStopedBP {
	public CiOrdModifyEndTimeDTO[] exec(QryRootNodeDTO queryNode) throws BizException{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		GetOrdAlwaysQry sql = new GetOrdAlwaysQry(service.getQueryStringWithoutDesc(queryNode));
		return (CiOrdModifyEndTimeDTO[]) AppFwUtil.getDORstWithDao(sql, CiOrdModifyEndTimeDTO.class);
	}
}
