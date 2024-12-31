package iih.mi.mibd.srvfacdircomp.s.bp;

import iih.mi.mibd.srvfacdircomp.d.SrvfacDirCompDTO;
import iih.mi.mibd.srvfacdircomp.s.bp.sql.FindSrvfacCompsql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import org.apache.commons.lang.StringUtils;
/** 
* @author hexx 
* @version 创建时间：2018年2月6日 上午9:47:48 
* 服务设施查询业务逻辑
*/
public class FindSrvfacCompBp {
	
	public PagingRtnData<SrvfacDirCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String mis_id,PaginationInfo pg)
			throws BizException{
				String wherePart = getWherePart(qryRootNodeDto);
				FindSrvfacCompsql sql = new FindSrvfacCompsql(mis_id,wherePart);
				PagingServiceImpl<SrvfacDirCompDTO> pagingServiceImpl = new PagingServiceImpl<>();
				PagingRtnData<SrvfacDirCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new SrvfacDirCompDTO(),pg, sql.getQrySQLStr(),"EU_STATUS DESC,CODE", sql.getQryParameter(null));
				return pagingRtnData;
			}

	public String getWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
				StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
				IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
				String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
				if (StringUtils.isNotEmpty(wherePart)) {
					wherePartBuilder.append("AND");
					wherePartBuilder.append(wherePart);
				}
				return wherePartBuilder.toString();
			}
}
