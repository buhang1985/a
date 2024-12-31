package iih.ci.mrqc.s.bp.outqc;

import iih.ci.mrqc.cimrqcrandomrule.d.CiMrQcRandomRuleDO;
import iih.ci.mrqc.cimrqcrandomrule.i.ICimrqcrandomruleRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class OutMrQcRandomRulePageInfoQryBP extends PagingServiceImpl<CiMrQcRandomRuleDO> {

	
	/**
	 * 门诊部抽查规则-查询
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CiMrQcRandomRuleDO> getOutMrQcRandomRuleQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		ICimrqcrandomruleRService qryService=ServiceFinder.find(ICimrqcrandomruleRService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
 		sb.append(" and id_org='"+Context.get().getOrgId()+"'");
 		PagingRtnData<CiMrQcRandomRuleDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), " sv desc");

		return pagingRtnData;
 	}
}
