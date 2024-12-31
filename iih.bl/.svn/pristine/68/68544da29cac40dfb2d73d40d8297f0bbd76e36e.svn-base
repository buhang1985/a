package iih.bl.cg.s.bp.ip;

import iih.bl.cg.dto.d.BlFeeSrvConQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvDetailQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvTotalQryDTO;
import iih.bl.cg.s.bp.ip.qry.GetIpCgPatDetailsQry;
import iih.bl.cg.s.bp.ip.qry.GetIpCgSrvTotalQry;
import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 住院费用项目汇总统计
 * 
 * @author F
 *
 */
public class GetIpCgListBySrvTotalBP {
	/**
	 * 获取住院记账明细
	 * 
	 * @param qryDtos
	 * @return
	 * @throws BizException
	 */
	public BlFeeSrvTotalQryDTO[] exec(BlFeeSrvConQryDTO qryDtos) throws BizException {
		if (qryDtos != null) {	
			//查询记账明细
//			PagingServiceImpl<BlFeeSrvTotalQryDTO> pagingServiceImpl = new PagingServiceImpl<BlFeeSrvTotalQryDTO>();
//			GetIpCgSrvTotalQry qry = new GetIpCgSrvTotalQry(qryDtos);
//			PagingRtnData<BlFeeSrvTotalQryDTO> result = pagingServiceImpl.findByPageInfo(new BlFeeSrvTotalQryDTO(), pg,
//					qry.getQrySQLStr(),null, qry.getQryParameter(null));			
			BlFeeSrvTotalQryDTO[] blFeeSrvDetailDtos = (BlFeeSrvTotalQryDTO[]) AppFwUtil.getDORstWithDao(
					new GetIpCgSrvTotalQry(qryDtos), BlFeeSrvTotalQryDTO.class);
			return blFeeSrvDetailDtos;
		}
		return null;
	}

}
