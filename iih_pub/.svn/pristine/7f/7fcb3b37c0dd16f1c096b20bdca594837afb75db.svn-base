package iih.bl.cg.i;

import iih.bl.cg.rpt.dto.d.IpCostIncStatsDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 住院费用报表查询服务
 * @author yankan
 * @since 2017-11-27
 *
 */
public interface IBlIpRptQryService {
	/**
	 * 获取住院费用按发票分类汇总信息
	 * @param pg 分页对象
	 * @param nodeDTO 查询方案
	 * @return
	 * @throws BizException
	 * @author liming
	 */
	PagingRtnData<IpCostIncStatsDTO> getIpCostIncStatsList(PaginationInfo pg, QryRootNodeDTO nodeDTO) throws BizException;
}
