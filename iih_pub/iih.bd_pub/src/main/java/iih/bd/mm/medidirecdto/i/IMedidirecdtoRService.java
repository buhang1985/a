/**  
 * Project Name:iih.bd_pub  
 * File Name:IMedidirecdtoRService.java  
 * Package Name:iih.bd.mm.medidirecdto.i  
 * Date:2018年7月21日上午11:42:51  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.bd.mm.medidirecdto.i;

import iih.bd.mm.medidirecdto.d.MedicDirecDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:IMedidirecdtoRService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月21日 上午11:42:51 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public interface IMedidirecdtoRService {

	PagingRtnData<MedicDirecDTO>  findPagingByQCond(QryRootNodeDTO qryRootNodeDTO, String orderPart, PaginationInfo pg) throws BizException;
}
  
