/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mrqc.s.bp.mrtask;

import iih.ci.mrqc.mrtask.d.MrTaskDO;
import iih.ci.mrqc.mrtask.i.IMrtaskRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 〈扼要描述〉
 * 书写任务查询
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class MrWriteTaskQryByBP extends PagingServiceImpl<MrTaskDO>{

	public PagingRtnData<MrTaskDO> getMrTaskByIdUserQryList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		IMrtaskRService qryService=ServiceFinder.find(IMrtaskRService.class);
		StringBuilder sb=new StringBuilder();
		sb.append(" 1=1");
 		if (qryRootNodeDTO!=null){
 			sb.append("  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO));
 		}
		sb.append(" and id_exec_doctor='"+Context.get().getUserId()+"'");
 		PagingRtnData<MrTaskDO> pagingRtnData = qryService.findByPageInfo(paginationInfo, sb.toString(), "");
 		
		return pagingRtnData;
 	}
}
