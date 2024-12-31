package iih.bl.cg.s;

import iih.bl.cg.bp.op.rpt.GetOpCostStatsListBP;
import iih.bl.cg.i.IBlOpRptQryService;
import iih.bl.cg.rpt.dto.d.OpCostStatsDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 门诊费用报表查询服务
 * @author yankan
 * @since 2017-11-27
 *
 */
@Service(serviceInterfaces = { IBlOpRptQryService.class }, binding = Binding.JSONRPC)
public class BlOpRptQryServiceImpl implements IBlOpRptQryService {
	/**
	 * 获取门诊费用汇总信息
	 * @param pg 分页对象
	 * @param nodeDTO 查询方案
	 * @return
	 * @throws BizException
	 * @author liming
	 */
	@Override
	public PagingRtnData<OpCostStatsDTO> getOpCostStatsList(PaginationInfo pg, QryRootNodeDTO nodeDTO) throws BizException{
		GetOpCostStatsListBP getCostStatsBP = new GetOpCostStatsListBP();
		return getCostStatsBP.exec(pg, nodeDTO);
	}
}