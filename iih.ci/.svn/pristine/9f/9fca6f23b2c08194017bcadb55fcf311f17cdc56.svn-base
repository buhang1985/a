/**
 * 
 */
package iih.ci.ord.s.bp.splitpres;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * @ClassName: RrevokeOrderHandlePresBP
 * @Description: 撤回已签署的医嘱的对分方的处理
 * @author Comsys-li_zheng
 * @date 2016年10月12日 下午3:10:47
 * @Package iih.ci.ord.s.bp.splitpres
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class RrevokeOrderHandlePresBP {
	
	  /**
     * 签署的医嘱撤回对分方的处理
     * @param id_ors
     * @throws BizException
     */
	public void execOrders(CiOrderDO[] orders)throws BizException{
		if(orders !=  null && orders.length >0){
			String[] id_ors = new String[orders.length];
			int i =0;
			for(CiOrderDO order:orders){
				id_ors[i] = order.getId_or();
				i++;
			}
			this.exec(id_ors);
		}
	}
	
	
	
    /**
     * 签署的医嘱撤回对分方的处理
     * @param id_ors
     * @throws BizException
     */
	public void exec(String[] id_ors)throws BizException{
	   /* 处理逻辑
	    1 查询 ci_or_srv 表 条件是 id_ors
	    2 */
		if(id_ors != null && id_ors.length >0){
			String IdOrs = CiOrdUtils.IdsConveretCharacterString(id_ors);
			String whereStr = " id_pres != '~'  and  id_or in ("+IdOrs+")";
			OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(whereStr, OrdSrvDO.ID_OR, FBoolean.FALSE);
			if(CiOrdUtils.isEmpty(ordSrvDOs)){
				return;
			}
			List<String> idPreses = new ArrayList<String>();
			for(OrdSrvDO srv : ordSrvDOs){
				if(!idPreses.contains(srv.getId_pres())){
					idPreses.add(srv.getId_pres());
				}
				//
			}
			/**---将处方下所有的服务全部查询出来，通过处方id进行分堆---*/
			OrdSrvDO[] presDos = CiOrdAppUtils.getOrSrvQryService().findByAttrValStrings("Id_pres", idPreses.toArray(new String[0]));
			if(CiOrdUtils.isEmpty(presDos)){
				return;
			}
			Map<String,List<OrdSrvDO>> tempMap = new HashMap<String,List<OrdSrvDO>>();
			for(OrdSrvDO srvdo : presDos){
				String id_pres = srvdo.getId_pres();
				if(tempMap.containsKey(id_pres)){
					List<OrdSrvDO> ordList = tempMap.get(id_pres);
					ordList.add(srvdo);
				}else {
					List<OrdSrvDO> ordSrvList = new ArrayList<OrdSrvDO>();
					ordSrvList.add(srvdo);
					tempMap.put(id_pres, ordSrvList);
				}
			}
			/**---分堆结束---*/
			List<String> deleteCIPres = new ArrayList<String>();
			//判断撤回的医嘱在分堆中是否存在，存在分堆中移除
			for(OrdSrvDO srv : ordSrvDOs){
				List<OrdSrvDO> srvList = tempMap.get(srv.getId_pres());
				if(!CiOrdUtils.isEmpty(srvList)){
					OrdSrvDO ordSrvDO = null;
					for(OrdSrvDO srvdo : srvList){
						if(srvdo.getId_orsrv().equals(srv.getId_orsrv())){
							ordSrvDO = srvdo;
							break;
						}
					}
					srvList.remove(ordSrvDO);
					if(srvList.size()==0){
						deleteCIPres.add(srv.getId_pres());
					}
				}
			}
			//删除处方
			if(deleteCIPres.size()>0){
				this.DeleteCIPres(deleteCIPres);
			}
			//更新服务的处方id
			this.UpdateCiOrSrv(idPreses, IdOrs);
		 }
	}
	  /**
	   * 删除分方表和更新ci_or_srv 表
	   * @param map
	   * @throws BizException
	   */
	 private void DeleteAndUpdatePres(Map map,String IdOrs)throws BizException{
		 if(map != null && map.size() >0)
		 {  
			 List cipreslist = new ArrayList();//处方id集合
			 List ciordSrvlist = new ArrayList();//医嘱项目的处方id集合
			 Iterator<Map.Entry<String, Boolean>> it = map.entrySet().iterator();
			 while(it.hasNext()){
				Map.Entry<String, Boolean> entry = it.next();
				if(entry.getValue()){
					cipreslist.add(entry.getKey());
					ciordSrvlist.add(entry.getKey());
				}else{
					ciordSrvlist.add(entry.getKey());
				}
			}
			 //删除处方
			 if(cipreslist != null && cipreslist.size() >0){
				 DeleteCIPres(cipreslist);
			 }
			//更新ci_or_srv 表
			 if(ciordSrvlist != null && ciordSrvlist.size() >0){
				 UpdateCiOrSrv(ciordSrvlist,IdOrs);
			 }
		 }
	 }
	 
	 /**
	  * 删除处方
	  * @param cipreslist
	  * @throws BizException
	  */
	 private void DeleteCIPres( List cipreslist)throws BizException{
		 String[] idpres = (String[])cipreslist.toArray(new String[cipreslist.size()]);
		 CiPresDO[] cipres=  CiOrdAppUtils.getCiPresQryService().findByIds(idpres,FBoolean.FALSE);
		 CiOrdAppUtils.getCiPresService().delete(cipres); 
	 }
	 
	 /**
	  * 更新ci_or_srv 表
	  * @param ciordSrvlist
	  * @throws BizException
	  */
	 private void UpdateCiOrSrv(List ciordSrvlist,String IdOrs)throws BizException{
		 String[] idpres = (String[])ciordSrvlist.toArray(new String[ciordSrvlist.size()]);
		 String id_pres = CiOrdUtils.IdsConveretCharacterString(idpres);
		 String  whereStr = " id_pres in ("+id_pres+")   and   id_or in ("+IdOrs+")";
		 OrdSrvDO[] ordersrv = CiOrdAppUtils.getOrSrvQryService().find(whereStr, "id_pres", FBoolean.FALSE);
	     if(ordersrv != null && ordersrv.length >0){
	    	 for(OrdSrvDO srv:ordersrv){
	    		 srv.setId_pres("~");
	    		 srv.setStatus(DOStatus.UPDATED);
	    	 }
	    	 CiOrdAppUtils.getOrSrvService().save(ordersrv);
	     }
	 }
	/**
	 * 判断处方id_pres 是否对应多个医嘱
	 * @param ordSrvDOs
	 * @param IdOrs
	 * @return
	 * @throws BizException
	 */
	private Map getIdPres(OrdSrvDO[] ordSrvDOs,String[] IdOrs)throws BizException{
		Map<String,Boolean> map = new HashMap();
		if(ordSrvDOs != null && ordSrvDOs.length >0){
			for(OrdSrvDO srvdo: ordSrvDOs){
				if(map.containsKey(srvdo.getId_pres())){
					map.put(srvdo.getId_pres(), IsTrue(srvdo.getId_or(),IdOrs));
				 }else{
					map.put(srvdo.getId_pres(), IsTrue(srvdo.getId_or(),IdOrs));
				}
			}
		}
		return map;
	}
	/**
	 * 判断 医嘱id对否在传过来的字符串中
	 * @param id_or
	 * @param IdOrs
	 * @return
	 */
	private Boolean IsTrue(String id_or,String[] IdOrs){
		if(IdOrs != null){
			for(String tempId_or :IdOrs){
				if(tempId_or.equals(id_or)){
					return true;
				}else{
					return false;
				}
			}
		}
		return false; 
	}
}
