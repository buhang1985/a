/**
 * 
 */
package iih.ci.ord.s.bp.assi.tl;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.i.IOrTplNItmDORService;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: JudgeOrderTemlateType
 * @Description: 判断模板的类型
 * @author Comsys-li_zheng
 * @date 2016年9月12日 下午8:02:17
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class JudgeOrderTemlateType {
    
	 private List herbalDruglist = new ArrayList();//草药 注射（多服务的药品）
	 private List commonDruglist = new ArrayList();//草药（当服务的药品）
	
	public FMap2 JudgeOrederTemlate(OrTplNItmDO[] ortplItems)throws BizException{
		FMap2  map =new FMap2();
		herbalDruglist.clear();
		commonDruglist.clear();
		if(ortplItems == null ||ortplItems.length == 0) return null;
		OrtemplateGrouping(map,ortplItems);
		
		//判断模板的类型  基础模板  服务 和套
//		List<OrTplNItmDO> list = JudgeTmplType(ortplItemDO);
//		
//		for(OrTplNItmDO itemDO:list){
//			JudgeOrderTemplateDetailedType(itemDO);
//		}
//         map.put(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, commonDruglist);
//         map.put(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, herbalDruglist);
		return map;
	}
    /**
     * 医嘱项目 一个医嘱模板的 是一条医嘱
     * @param map
     * @param ortplItemDO
     * @throws BizException
     */
	private  void OrtemplateGrouping(FMap2  map,OrTplNItmDO[] ortplItems)throws BizException{
		if(ortplItems != null && ortplItems.length >0){
			List itemlist  = null;
			// 根据数据库中的医嘱模板明细补全前台传入的模板明细
			setOrtmplItmDefaultVal(ortplItems);
			List<String>  ortmplList = new ArrayList();
			for(OrTplNItmDO item: ortplItems){
				ortmplList.add(item.getId_ortmpl());
				String key = item.getId_ortmpl()+item.getIdentical_ortmpl()+item.getSd_srvtp().substring(0, 2);
				if(map.containsKey(key)){
					itemlist = (List)map.get(key);
					itemlist.add(item);
				}else{
				 List  temp = new ArrayList();
				  temp.add(item);
				 map.put(key, temp);
				}
			}
			 map.put("ortmplList",ortmplList);
		}
	}
	
	
	/**
	 * 根据数据库中的医嘱模板，补全前台传入的医嘱模板数据
	 * @return
	 * @throws BizException 
	 */
	private void  setOrtmplItmDefaultVal(OrTplNItmDO[] ortplItems) throws BizException{
		
		// 医嘱模板明细id集合
		List<String> idOrtmplItm = new ArrayList<String>();
				
		for(OrTplNItmDO orTplNItm : ortplItems){
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_ortmplitm())||orTplNItm.getId_ortmplitm().length()>20){
				continue;
			}
			idOrtmplItm.add(orTplNItm.getId_ortmplitm());
		}
		
		// 查询中数据库中的医嘱模板，并转换为map结构
		IOrTplNItmDORService orTplNItmDORService =  (IOrTplNItmDORService)ServiceFinder.find(IOrTplNItmDORService.class);
		OrTplNItmDO[] defaultOrTplNItms = orTplNItmDORService.findByIds(idOrtmplItm.toArray(new String[0]), FBoolean.FALSE);
		if(defaultOrTplNItms == null || defaultOrTplNItms.length ==0){
			return ;
		}
		
		Map<String,OrTplNItmDO> orTplNItmMap = new HashMap<String,OrTplNItmDO>();
		Map<String,String> mapIdmm = new HashMap<String,String>();
		for(OrTplNItmDO orTplNItm : defaultOrTplNItms){
			orTplNItmMap.put(orTplNItm.getId_ortmplitm(), orTplNItm);
			if(orTplNItm.getSd_srvtp().startsWith("01")) {
				mapIdmm.put(orTplNItm.getId_mm(), orTplNItm.getId_unit_med());
			}
			
		}
		//判断模板的医学单位华为药品基本信息的基本单位是否不一致
		String message = JudgeMMUintMed(defaultOrTplNItms);
		if(!StringUtils.isNullOrEmpty(message)) {
			throw new BizException(message);
		}
		// 将数据库中医嘱模板信息合并到前台传入的模板数据中
		for(OrTplNItmDO orTplNItm : ortplItems){
			
			OrTplNItmDO sourceOrTplNItm = orTplNItmMap.get(orTplNItm.getId_ortmplitm());
			if(sourceOrTplNItm==null){
				continue;
			}
				
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_freq())){
				orTplNItm.setId_freq(sourceOrTplNItm.getId_freq());
				orTplNItm.setOrtplnitm_freq_code(sourceOrTplNItm.getOrtplnitm_freq_code());
				orTplNItm.setOrtplnitm_freq_name(sourceOrTplNItm.getOrtplnitm_freq_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_route())){
				orTplNItm.setId_route(sourceOrTplNItm.getId_route());
				orTplNItm.setOrtplnitm_route_code(sourceOrTplNItm.getOrtplnitm_route_code());
				orTplNItm.setOrtplnitm_route_name(sourceOrTplNItm.getOrtplnitm_route_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_routedes())){
				orTplNItm.setId_routedes(sourceOrTplNItm.getId_routedes());
				orTplNItm.setOrtplnitm_routedes_code(sourceOrTplNItm.getOrtplnitm_routedes_code());
				orTplNItm.setOrtplnitm_routedes_name(sourceOrTplNItm.getOrtplnitm_routedes_name());
			}
			
			if(StringUtils.isNullOrEmpty(orTplNItm.getId_boil())){
				orTplNItm.setId_boil(sourceOrTplNItm.getId_boil());
				orTplNItm.setOrtplnitm_boil_code(sourceOrTplNItm.getOrtplnitm_boil_code());
				orTplNItm.setOrtplnitm_boil_name(sourceOrTplNItm.getOrtplnitm_boil_name());
			}
			
			if(orTplNItm.getDays_or() == null){
				orTplNItm.setDays_or(sourceOrTplNItm.getDays_or());
			}
			if(orTplNItm.getDes_or() == null){
				orTplNItm.setDes_or(sourceOrTplNItm.getDes_or());
		
			}
			if(StringUtils.isNullOrEmpty(orTplNItm.getName_srv())){
				orTplNItm.setName_srv(sourceOrTplNItm.getName_srv());		
			}
			if(orTplNItm.getId_dep_mp()==null||!orTplNItm.getId_dep_mp().equals(sourceOrTplNItm.getId_dep_mp())){
				orTplNItm.setId_dep_mp(sourceOrTplNItm.getId_dep_mp());
			}			
		}
	}
	
	
	 /**
	  * 判断 药品的医学单位和模板的医学单位是否一致
	  * @param envinfo
	  * @param ortplItemDO
	  * @return
	  */
	  private String JudgeMMUintMed(OrTplNItmDO[] defaultOrTplNItms) throws BizException{
		 StringBuffer message =  new StringBuffer();
		 List<String> list = new ArrayList<String>();//药品 id_mm 集合
		 Map<String,String> map = new HashMap<String,String>();
		 if(defaultOrTplNItms !=null && defaultOrTplNItms.length > 0) {
			 for(OrTplNItmDO itemDO: defaultOrTplNItms) {
				 if(itemDO.getSd_srvtp().startsWith("01")) {
					 map.put(itemDO.getId_mm(), itemDO.getId_unit_med());
					 list.add(itemDO.getId_mm());
				 }
			 }
			 if(list != null && list.size() > 0) {
				 List<MeterialDO> materiaDOS = getMeterialDO((String[])list.toArray(new String[list.size()]));
			     if(materiaDOS != null && materiaDOS.size() > 0) {
			    	 for(MeterialDO meteria :materiaDOS) {
				    	 if(!meteria.getId_unit_med().equals(map.get(meteria.getId_mm()))){
				    		 message.append(meteria.getName()).append("" );
				    		 message.append("在模板里面的剂量单位和 药品基本信息里的剂量单位不一致 请修改模板，在开立" ).append("\n");
				    	 }
				     } 
			     } 
			 } 
		 }
		 return message.toString();
	  }
	
	  /**
	   * 查询药品  名称和 医学单位
	   * @param id_mms
	   * @return
	   * @throws BizException
	   */
	  private List<MeterialDO> getMeterialDO(String[] id_mms)throws BizException {
		  String sql ="select bdmm.name, bdmm.id_mm,bdmm.id_unit_med from bd_mm bdmm where  ";
		    sql +=	 SqlUtils.getInSqlByIds("bdmm.id_mm", id_mms);
		   DAFacade  facade = new  DAFacade();
		   List<MeterialDO> meterialDO = (List<MeterialDO>)facade.execQuery(sql, new BeanListHandler(MeterialDO.class));
	       return meterialDO;
	  }
	
	/**
	 * @DmEnumDesc(name="模板",description="基础医嘱模板")
		public static final Integer ORTMPL=0; //模板
	    @DmEnumDesc(name="服务",description="医疗服务")
		public static final Integer SRV=1; //服务
	    @DmEnumDesc(name="套",description="服务套")
		public static final Integer SRVSET=2; //套
	 * @param ortplItemDO
	 */
	private List<OrTplNItmDO> JudgeTmplType(OrTplNItmDO[] ortplItemDO)throws BizException{
		 List list = new ArrayList();
		 for(OrTplNItmDO itemDO: ortplItemDO){
			 if(OrTplItmTypeEnum.ORTMPL.equals(itemDO.getEu_ortplitmtp())){
				 getBdSrvORTmplItem(list,itemDO.getId_srv());
			 }else{
				 list.add(itemDO);
			 }
		 }
		 return list;
	}
	
	/**
	 * 医嘱模板引用基础模板的 
	 * @param list
	 * @param id_ortmpl
	 * @throws BizException
	 */
	private void getBdSrvORTmplItem(List<OrTplNItmDO> list ,String id_ortmpl)throws BizException{
		 String whereStr = OrTplNItmDO.ID_ORTMPL + " = '"+ id_ortmpl  +"'";
		 OrTplNItmDO[] itemDOS =  CiOrdAppUtils.getIOrTplNItmDORService().find(whereStr, OrTplNItmDO.ID_ORTMPL, FBoolean.FALSE);
	     if(itemDOS != null && itemDOS.length >0){
	    	 for(OrTplNItmDO itemDO:itemDOS){
	    		 list.add(itemDO); 
	    	 }
	     }
	}
	
	
	/**
	 * 判断医嘱模板明细类型
	 * @param itemDO
	 */
	private void JudgeOrderTemplateDetailedType(OrTplNItmDO itemDO)throws BizException{
		     
		     String sd_srvtp = itemDO.getSd_srvtp();
		     if(sd_srvtp != null && sd_srvtp.length()>1){
		    	 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){ //药品
		    		 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
				    		   ||sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) ){
				    		  //注射类药品  和草药
		    			      if(herbalDruglist != null && herbalDruglist.size() >0){
		    			    	  //判断同一类型 是否是 同一模板下的项目
		    			    	  OrTplNItmDO temp = (OrTplNItmDO)herbalDruglist.get(herbalDruglist.size()-1);
		    			    	  if(temp.getId_ortmpl().equals(itemDO.getId_ortmpl())){
		    			    		  herbalDruglist.add(itemDO);
		    			    	  }else{
		    			    		  commonDruglist.add(itemDO);
		    			    	  }
		    			      }else if(herbalDruglist.size()==0){
	    			    		  herbalDruglist.add(itemDO);
	    			    	  }
		    			      
				    		 }else{
				    		  // 普通药品和其他药 
				    			 commonDruglist.add(itemDO);
				    		 }
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){ //检查
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){ //检验
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){ //手术
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){ //治疗
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)){ //护理
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)){ //卫才
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){ //嘱托
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HEALTH)){ //健康
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SRVPKG)){ //治疗包
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN)){ //患者管理类 （转科出院死亡 等）
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_FIXFEE)){ //固定费用
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)){ //血液制品
		    		  commonDruglist.add(itemDO);
		    	  }else{
		    		  commonDruglist.add(itemDO);
		    	  }
		    	 }else{
		    		// sd_srvtp为空的时 处理
		    	 }
		     }
	
}
