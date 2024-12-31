package iih.ci.ord.s.bp.orderlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class QueryOrderListBP {

   /**
    *  
    * @param whereStr
    * @param id_ent
    * @return
    * @throws BizException
    */
   public  CiOrderDO[] getOrderList(String whereStr ,String orderbyStr)throws BizException{
	   CiOrderDO[] ciorderDO =  CiOrdAppUtils.getOrQryService().find(whereStr, orderbyStr, FBoolean.FALSE);
	   handlerOperationStatus(ciorderDO);
	   return ciorderDO;
    }
    /**
     * 
     * @param ciorderDO
     */
    public void handlerOperationStatus(CiOrderDO[] ciorderDO) throws BizException {	
    	if(ciorderDO != null) {
    	    StringBuffer sql = new  StringBuffer();
    	    Map<String,CiOrderDO> map = new HashMap<String,CiOrderDO>();
    		for(CiOrderDO order:ciorderDO) {
    			if(order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)) {
    				sql.append(",'");
    				sql.append(order.getId_or());
    				sql.append("'");
    				map.put(order.getId_or(), order);
    			}
    		}
    		if(sql != null && sql.toString().length() >1){
    		 String qrySql  = sql.toString().substring(1);
    		 List<OrdApOpDO> ordApplist =  geteSugStatus(qrySql);
    		 setOperationStatus(ordApplist,map);
    		}
    	}
    }
    /**
     * 
     * @param id_ors
     * @return
     * @throws BizException
     */
    private  List<OrdApOpDO>  geteSugStatus(String id_ors)throws BizException {
    	DAFacade  facade = new  DAFacade();
		String sql = " select id_or,sd_su_op from ci_ap_sug  where id_or   in ("+id_ors+")";
       List<OrdApOpDO> OrdApOpDOList = (List<OrdApOpDO>)facade.execQuery(sql, new BeanListHandler(OrdApOpDO.class));
       return OrdApOpDOList;
    }
    /**
     * 
     * @param ordApplist
     * @param map
     */
    private void setOperationStatus(List<OrdApOpDO> ordApplist, Map<String,CiOrderDO> map) {
    	if(ordApplist != null && ordApplist.size() >0) {
    		 for(OrdApOpDO ordapp:ordApplist) {
      			 if(map.containsKey(ordapp.getId_or())) {
      				map.get(ordapp.getId_or()).setOperation_status(ordapp.getSd_su_op());
      			 }
    		  }
    	}
    }
}
