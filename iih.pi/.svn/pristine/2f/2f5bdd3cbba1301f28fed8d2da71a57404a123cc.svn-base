package iih.pi.card.s.bp.cardrtnrpt;

import iih.pi.card.dto.d.CardrtnrptDTO;
import iih.pi.card.s.bp.cardrtnrpt.qry.CardrtnrptPagingSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**  
 * Function: 卡管理查询服务分页bp <br/>  
 * Date:     2018年9月12日 下午9:54:43 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80       
 */
public class CardrtnrptBpPaging {

	/**
	 * 查询分页数据
	 * 
	 * @param pg
	 * @param wherePart
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<CardrtnrptDTO> GetPagingRtnData(PaginationInfo pg, String wherePart, String hpCode)throws BizException {
		CardrtnrptPagingSql sql = new CardrtnrptPagingSql(wherePart);
		PagingServiceImpl<CardrtnrptDTO> pagingServiceImpl = new PagingServiceImpl<CardrtnrptDTO>();
		PagingRtnData<CardrtnrptDTO> pRtnData = pagingServiceImpl.findByPageInfo(new CardrtnrptDTO(), pg,
				sql.getQrySQLStr(), null, sql.getQryParameter(null));
		return pRtnData;
	}
}
  
