package iih.bd.srv.empphydto.s.bp;

import iih.bd.srv.empphydto.d.EmpphyDTO;
import iih.bd.srv.empphydto.s.bp.qry.FindEmpPhyDtoQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 查询医师信息DTO业务逻辑FindByPageInfo
 * @author guoyang
 *
 */
public class GetEmpPhyDtoByPageInfoBp {

	public PagingRtnData<EmpphyDTO> exec(PaginationInfo pg, String wherePart, String orderByPart) throws BizException {
		FindEmpPhyDtoQry qry = new FindEmpPhyDtoQry(wherePart);
		PagingServiceImpl<EmpphyDTO> pagingServiceImpl = new PagingServiceImpl<EmpphyDTO>();
		return pagingServiceImpl.findByPageInfo(new EmpphyDTO(), pg, qry.getQrySQLStr(), orderByPart, null);
	}

}
