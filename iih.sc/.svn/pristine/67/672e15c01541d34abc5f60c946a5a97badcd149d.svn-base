package iih.sc.apt.s.bp.ip;

import iih.bd.res.bed.d.BedDTO;
import iih.sc.apt.dto.d.BedQrySchmDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 查询床位信息 需要床位信息、就诊、预约信息(C#)
 * 
 * @author
 */
public class GetBedInfoByWherePartBP {

	/**
	 * 查询床位信息 需要床位信息、就诊、预约信息(C#)
	 * 
	 * @param pg
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<BedDTO> exec(PaginationInfo pg, BedQrySchmDTO qrySchmDTO) throws BizException {
		return new GetBedListBP().exec(qrySchmDTO, pg, qrySchmDTO.getId_dep());
	}
}
