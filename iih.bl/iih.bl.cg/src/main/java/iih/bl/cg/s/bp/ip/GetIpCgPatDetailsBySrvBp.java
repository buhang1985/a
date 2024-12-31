package iih.bl.cg.s.bp.ip;

import iih.bl.cg.dto.d.BlFeeSrvConQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvDetailQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvTotalQryDTO;
import iih.bl.cg.s.bp.ip.qry.GetIpCgPatDetailsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 住院费用项目明细患者信息查询
 * 
 * @author zhangxin 2018年10月22日
 *
 *
 */
public class GetIpCgPatDetailsBySrvBp {
	/**
	 * 住院费用项目明细患者信息查询
	 * 
	 * @param blFeeSrvTotalQryDto
	 * @param blFeeSrvConQryDto
	 * @return 费用项目明细 DTO数据
	 * @throws BizException
	 */
	public PagingRtnData<BlFeeSrvDetailQryDTO> exec(BlFeeSrvTotalQryDTO blFeeSrvTotalQryDto, BlFeeSrvConQryDTO blFeeSrvConQryDto,PaginationInfo pg)
			throws BizException {
		// 查询费用明细根据查询条件dto
		PagingServiceImpl<BlFeeSrvDetailQryDTO> pagingServiceImpl = new PagingServiceImpl<BlFeeSrvDetailQryDTO>();
		GetIpCgPatDetailsQry qry = new GetIpCgPatDetailsQry(blFeeSrvTotalQryDto, blFeeSrvConQryDto);
		PagingRtnData<BlFeeSrvDetailQryDTO> result = pagingServiceImpl.findByPageInfo(new BlFeeSrvDetailQryDTO(), pg,
				qry.getQrySQLStr(), null, qry.getQryParameter(null));
//		BlFeeSrvDetailQryDTO[] blFeeSrvDetailDtos = (BlFeeSrvDetailQryDTO[]) AppFwUtil.getDORstWithDao(
//				new GetIpCgPatDetailsQry(blFeeSrvTotalQryDto, blFeeSrvConQryDto), BlFeeSrvDetailQryDTO.class);
		return result;

	}
}
