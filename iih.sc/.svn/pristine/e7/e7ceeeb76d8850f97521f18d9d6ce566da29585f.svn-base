package iih.sc.scbd.s.bp;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.res.bizgrp.d.BizGroupDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 获取科室可用医疗组列表
 * @author fanlq
 *
 */
public class GetWgListByDepBP {
	/***
	 * 获取科室可用医疗组列表
	 * @param depId 科室id
	 * @param wgId 医疗组id
	 * @return
	 * @throws BizException
	 */
	public BizGroupDO[] exec(String depId,String wgId) throws BizException{		
		
		StringBuilder sb = new StringBuilder();
	    SqlParam sp = new SqlParam();
	    sb.append("select  * ");
	    sb.append("from bd_wg wg where 1=1 ");
	    if(!StringUtils.isNullOrEmpty(depId)){
	    	 sb.append("and wg.id_dep = ? ");
	    	 sp.addParam(depId);
	    }
	    if(!StringUtils.isNullOrEmpty(wgId)){
	    	sb.append("and wg.id_wg = ? ");
	    	sp.addParam(wgId);
	    }
	    @SuppressWarnings("unchecked")
		List<BizGroupDO> datas = (List<BizGroupDO>) new DAFacade().execQuery(sb.toString(),
				sp, new BeanListHandler(BizGroupDO.class));
	   if(ListUtil.isEmpty(datas))
		  return null;	  
		return datas.toArray(new BizGroupDO[]{});
	} 
}
