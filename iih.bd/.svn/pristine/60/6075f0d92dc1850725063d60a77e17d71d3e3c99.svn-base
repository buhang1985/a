/**  
 * Project Name:iih.bd.mm  
 * File Name:MedidirecdtoRServiceImpl.java  
 * Package Name:iih.bd.mm.medidirecdto.s  
 * Date:2018年7月21日下午2:12:45  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mm.medidirecdto.s;

import iih.bd.mm.medidirecdto.d.MedicDirecDTO;
import iih.bd.mm.medidirecdto.i.IMedidirecdtoRService;
import iih.bd.mm.medidirecdto.s.bp.MediDirecDtoBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:MedidirecdtoRServiceImpl <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月21日 下午2:12:45 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public class MedidirecdtoRServiceImpl implements IMedidirecdtoRService {

	@Override
	public PagingRtnData<MedicDirecDTO> findPagingByQCond(QryRootNodeDTO qryRootNodeDTO, String orderPart, PaginationInfo pg) throws BizException {
		MediDirecDtoBP medbp = new MediDirecDtoBP();
		PagingRtnData<MedicDirecDTO> result =medbp.exec(qryRootNodeDTO,orderPart,pg);
		return result;
	}
}
  
