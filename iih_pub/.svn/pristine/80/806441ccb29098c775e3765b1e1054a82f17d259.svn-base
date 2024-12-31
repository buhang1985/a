package iih.mm.qy.lowstoragequerydto.i;

import iih.mm.qy.lowstoragequerydto.d.LowStorageQueryDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * ClassName:ILowStorageQueryService <br/>  
 * Function: 高低储查询服务接口 <br/>  
 * Date:     2019年4月3日 上午10:18:16 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_76       
 */
public interface ILowStorageQueryService {

	/**
	 * GetLowStorageQueryDtos:低储查询<br/>  
	 * @author zmyang  
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param isLazy
	 * @return  
	 * @throws BizException 
	 * @since JDK 1.7.0_76
	 */
	LowStorageQueryDTO[] getLowStorageQueryDtos(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy) throws BizException;
	
	/**
	 * GetHightStorageQueryDtos:高储查询<br/>  
	 * @author zmyang  
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param isLazy
	 * @return  
	 * @throws BizException 
	 * @since JDK 1.7.0_76
	 */
	LowStorageQueryDTO[] getHightStorageQueryDtos(QryRootNodeDTO qryRootNodeDTO, String orderStr, FBoolean isLazy) throws BizException;
}
  
