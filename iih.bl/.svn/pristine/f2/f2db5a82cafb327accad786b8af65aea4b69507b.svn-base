package iih.bl.cg.bp.oep;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 *  检查医嘱是否结算过 收费、退费、重收 都算是结算过
 * @author lpy
 * @author yang.lu 2018年1月4日 改
 *
 */
public class GetOepOrSrvStStatusBP {
	/**
	 * 检查医嘱是否结算过 收费、退费、重收 都算是结算过
	 * @param orSrvIds 医嘱服务ID
	 * @return map,[key:医嘱服务ID,value: FBoolean]
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap exec(String[] orSrvIds) throws BizException{
		
		FMap newMap = new FMap();
		for(String strId_orsrv :orSrvIds)
		{
			 newMap.put(strId_orsrv, FBoolean.FALSE);  
		}
		StringBuffer sb =  new StringBuffer();
		sb.append(" select cgitm.id_orsrv ");
		sb.append(" from  bl_cg_itm_oep  cgitm ");
		sb.append(" inner join bl_cg_oep  cgoep on cgitm.id_cgoep = cgoep.id_cgoep ");
		sb.append(" inner join bl_st_oep  stoep  on cgitm.id_stoep = stoep.id_stoep ");
		sb.append(" where  nvl(stoep.id_paypatoep,'~')<>'~' ");
		sb.append(" and ").append(SqlUtils.getInSqlByIds("cgitm.id_orsrv", orSrvIds));
		sb.append(" group by cgitm.id_orsrv ");
		
		DAFacade facade = new DAFacade();
		List<BlCgItmOepDO> cgitmDOLst = (List<BlCgItmOepDO>) facade.execQuery(sb.toString(), new BeanListHandler(BlCgItmOepDO.class));
		if (cgitmDOLst != null && cgitmDOLst.size() > 0) 
		{
	      for(BlCgItmOepDO cgitm :cgitmDOLst)
	      {
	    	 if(newMap.containsKey(cgitm.getId_orsrv()))
	    	 {
	    		 newMap.remove(cgitm.getId_orsrv());
	    		 newMap.put(cgitm.getId_orsrv(), FBoolean.TRUE); 
	    	 }
	     }
	     
		}
       return newMap;
	}
}
