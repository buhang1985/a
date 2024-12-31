package iih.bl.cg.blcgquery.Service.i;

import iih.bl.cg.blcgquery.Service.d.CreateBlcgqueryDTO;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IBLBlcgqueryService {
	public CreateBlcgqueryDTO[] blcgFindByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
}
