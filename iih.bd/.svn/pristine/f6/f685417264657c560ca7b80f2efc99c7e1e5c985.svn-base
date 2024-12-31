/**  
 * Project Name:iih.bd.mm  
 * File Name:MedidirecDTO.java  
 * Package Name:iih.bd.mm.medidirecdto.s.bp  
 * Date:2018年7月21日下午2:13:21  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mm.medidirecdto.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.medidirecdto.d.MedicDirecDTO;
import iih.bd.mm.medidirecdto.s.bp.sql.MediDirecDtoSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**  
 * ClassName:MedidirecDTO <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月21日 下午2:13:21 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public class MediDirecDtoBP {

	public PagingRtnData<MedicDirecDTO> exec(QryRootNodeDTO qryRootNodeDTO, String orderPart, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO);
		PagingRtnData<MedicDirecDTO> result = FindPagingByWherePart(wherePart, orderPart, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 根据查询条件和排序条件查询分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedicDirecDTO> FindPagingByWherePart(String wherePart, String orderPart,
			PaginationInfo pg) throws BizException {
		MediDirecDtoSql sql = new MediDirecDtoSql(wherePart);
		PagingServiceImpl<MedicDirecDTO> pagingServiceImpl = new PagingServiceImpl<MedicDirecDTO>();
		PagingRtnData<MedicDirecDTO> result = pagingServiceImpl.findByPageInfo(new MedicDirecDTO(), pg,
				sql.getQrySQLStr(), orderPart, sql.getQryParameter(null));
		return result;
	}
}
  
