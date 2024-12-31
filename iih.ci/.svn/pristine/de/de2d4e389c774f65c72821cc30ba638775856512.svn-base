/**
 * 
 */
package iih.ci.diag.s.bp;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.s.bp.qry.getCiDiagItemDOBPQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @ClassName: getCiDiagItemDOBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月22日 上午10:30:27
 * @Package iih.ci.diag.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCiDiagItemDOBP {
   
	  public  CiDiagItemDO exe(String id_en,String code_entp)throws BizException{
		  if(id_en == null)return  null; 
		  getCiDiagItemDOBPQry qry = new getCiDiagItemDOBPQry(id_en,code_entp);
		  CiDiagItemDO[] rtn =   (CiDiagItemDO[])AppFwUtil.getDORstWithDao(qry, CiDiagItemDO.class);
	      if(rtn != null && rtn.length>0){
	    	  return rtn[0];
	      }
	      return null;
	  }
}
