/**  
 * Project Name:iih.mp_pub  
 * File Name:IOperworkloadRCrudService.java  
 * Package Name:iih.mp.orm.operworkload.i  
 * Date:2018年7月16日下午7:55:51  
 * Copyright (c) 2018, chenzhou1025@126.com All Rights Reserved.  
 *  
*/  
  
package iih.mp.orm.operworkload.i;

import iih.mp.orm.operworkload.d.OperSituationDO;
import iih.mp.orm.operworkload.d.SurgeryNumDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:IOperworkloadRCrudService <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2018年7月16日 下午7:55:51 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80  
 * @see        
 */
public interface IOperworkloadRService {
	
	/**
	 * 
	 * GetSurScheUserRoleDTO:(这里用一句话描述这个方法的作用). <br/>  
	 * @author zmyang  
	 * @param sursche
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	SurgeryNumDO[] GetSurgeryNumDO(QryRootNodeDTO qryRootNodeDto) throws BizException;
	/**
	 * 
	 * GetSurSchedulingDTO:(这里用一句话描述这个方法的作用). <br/>  
	 * @author zmyang  
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	OperSituationDO[] GetOperSituationDO(String sursche) throws BizException;
}
  
