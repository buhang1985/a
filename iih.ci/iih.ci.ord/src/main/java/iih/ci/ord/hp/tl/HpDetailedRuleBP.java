/**
 * 
 */
package iih.ci.ord.hp.tl;

import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * @ClassName: HpDetailedRuleBP
 * @Description: 医保的项目规则
 * @author Comsys-li_zheng
 * @date 2016年11月23日 上午11:29:04
 * @Package iih.ci.ord.hp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class HpDetailedRuleBP {
 
	//保存校验
	public String[] getHpDetailedRule(CiOrAggAndRelDatum oraggandrelinfo,CiEnContextDTO context)throws BizException{
		//诊断信息
		CiorderAggDO aggors =oraggandrelinfo.getOraggdo();
		FArrayList2 diagList  = CiOrdUtils.getDiagList(aggors.getParentDO().getId_en());
		//医保信息
		return JudgeCiHpSave(oraggandrelinfo, diagList,context);
	}
	
	//签署校验
	public  String[] getHpOrderSigndRule(CiorderAggDO[] aggors)throws BizException{
		//诊断信息
		 
		FArrayList2 diagList  = CiOrdUtils.getDiagList(aggors[0].getParentDO().getId_en());
		//医保信息
		return SignJudgeCiHpSave(aggors, diagList);
	}
	
	
	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
	 * @param aggDO
	 * @return  CiOrAggAndRelDatum oraggandrelinfo
	 */
	 public  String[]  JudgeCiHpSave(CiOrAggAndRelDatum oraggandrelinfo,FArrayList2 diagList,CiEnContextDTO context)throws BizException{
		         CiorderAggDO aggors  =oraggandrelinfo.getOraggdo();
		         String[]  error =null;
				 CiHpCheckDTO ciHpCheckDTO  = new  CiHpCheckDTO();
				 ciHpCheckDTO.setId_pat(aggors.getParentDO().getId_pat());
				 ciHpCheckDTO.setId_ent(aggors.getParentDO().getId_en());
				 ciHpCheckDTO.setCi_di_itms(diagList);
				 //医嘱  ，医嘱项目 ，物品 等 集合信息
				 if(getOrderSrvMmDO(ciHpCheckDTO,oraggandrelinfo,context)){
					 CiHpCheckResultDTO result =  HpService.checkCiHpSave(ciHpCheckDTO);
					 if(result == null){
						 CiOrdUtils.LogerOutInfo(aggors.getParentDO().getName_or()+"  验证规则信息返回null");
					 }else{
						 CiOrdUtils.LogerOutInfo(aggors.getParentDO().getName_or()+"  验证规则信息"+result.toString());
					 }
					 
					 if(result != null ){
						 if(!FBoolean.TRUE.equals(result.getCheckflag())){
							 FMap2 map = result .getFailidorsrvmap();
							   error = getHPMessageError(map);
						 }else{
							 return error;
						 }
					 }
				 }
				 return error;	 
	 }
	 
	 /**
	  * 医保的提示信息
	  * @param map
	  * @return 
	  */
	 private String[] getHPMessageError(FMap2 map){
		 
		 String[] err= null;
		 for(Object str:map.values()){
			 if(str != null && str != ""){
				 //提示信息和编码 格式       例如  ：   医保信息|&|10
			     err =  (str.toString()).split("\\"+IBdPpCodeTypeConst.CHECK_CIHP_SAVE_DES_CODE_SPLIT);
			 } 
		 }
		return err;
	 }
	 
	 
	 
	 /**
	   * 获取需要医保校验的物品<br>
	   * 非自费的服务
	   * @param oraggandrelinfo
	   * @return
	   */
	private boolean getOrderSrvMmDO(CiHpCheckDTO ciHpCheckDTO, CiOrAggAndRelDatum oraggandrelinfo, CiEnContextDTO context) throws BizException {

		CiorderAggDO aggors = oraggandrelinfo.getOraggdo();
		
		if (!CiOrdUtils.isHpUsing(context) || aggors == null) {
			return false;
		}
		
		FArrayList2 hpqry = new FArrayList2();

		FArrayList2 srvList = new FArrayList2();
		HpQryCiorderDTO hpqryCiOrderDto = new HpQryCiorderDTO();
		OrdSrvDO[] orsrvdos = aggors.getOrdSrvDO();
		
		for (OrdSrvDO srvDO : orsrvdos) {
			
			if(FBoolean.TRUE.equals(srvDO.getFg_selfpay())){
				continue;
			}
			
			srvList.append(srvDO);
		}
		
		if(srvList.size() == 0){
			return false;
		}
		
		getOrderSrvMms(hpqryCiOrderDto, oraggandrelinfo);
		hpqryCiOrderDto.setCiorderdo(aggors.getParentDO());
		//hpqryCiOrderDto.setOrdsrvmms(srvMmList);
		hpqryCiOrderDto.setOrdsrvs(srvList);
		hpqry.append(hpqryCiOrderDto);

		ciHpCheckDTO.setSavecidto(hpqry);
		
		return true;
	}
	 
	 /**
	  * 
	  * @param id_orsrv
	  * @throws BizException
	  */
	 private void getOrderSrvMms(HpQryCiorderDTO hpqryCiOrderDto,CiOrAggAndRelDatum oraggandrelinfo)throws BizException{
		 CiorderAggDO aggors  =oraggandrelinfo.getOraggdo();
		 Hashtable ht = oraggandrelinfo.getOrattachht();
				if(ht == null) return ;
				String key=OrdSrvMmDODesc.CLASS_FULLNAME;
				FMap srvmmmap =  (FMap)ht.get(key);
				 FArrayList2 srvMmList=new FArrayList2();
				 if(srvmmmap != null && srvmmmap.size() >0){
				  for (String id_srv : srvmmmap.keySet()) {
					 // OrdSrvMmDO ordersrvmm  = (OrdSrvMmDO)srvmmmap.get(id_srv);
					  List<OrdSrvMmDO>  list =   ( List<OrdSrvMmDO>)srvmmmap.get(id_srv);
					  if(list != null && list.size() >0){
						for(OrdSrvMmDO ordersrvmm:list){
							  if(id_srv.indexOf("_") >0){
								  ordersrvmm.setId_srv(id_srv.substring(0, id_srv.indexOf("_")));
							  }else{
								  ordersrvmm.setId_srv(id_srv);
							  }
						 
							  srvMmList.append(ordersrvmm);
						}  
					  }
				
					 
					}
				}
				 //设置物品信息
				 hpqryCiOrderDto.setOrdsrvmms(srvMmList);
				 
	/*	 if(id_orsrv != ""){
			 FArrayList2 srvMmList=new FArrayList2();
			 String  whereStr = OrdSrvMmDO.ID_ORSRV+" in ("+id_orsrv.substring(1)+")";
			 OrdSrvMmDO[] srvmmDO = CiOrdAppUtils.getOrSrvMmQryService().find(whereStr, OrdSrvMmDO.ID_ORSRV, FBoolean.FALSE);
		      for(OrdSrvMmDO mm: srvmmDO){
		    	  srvMmList.append(mm);
		      }
		      hpqryCiOrderDto.setOrdsrvmms(srvMmList);
		 }*/
	 }
	 
	 
	 /**
		 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
		 * @param aggDO
		 * @return
		 */
		 public  String[]  SignJudgeCiHpSave(CiorderAggDO[] aggors,FArrayList2 diagList)throws BizException{
			         String[]  error =null;
					 CiHpCheckDTO ciHpCheckDTO  = new  CiHpCheckDTO();
					 ciHpCheckDTO.setId_pat(aggors[0].getParentDO().getId_pat());
					 ciHpCheckDTO.setId_ent(aggors[0].getParentDO().getId_en());
					 ciHpCheckDTO.setCi_di_itms(diagList);
					 //医嘱  ，医嘱项目 ，物品 等 集合信息
					 if(getOrderSignSrvMmDO(ciHpCheckDTO,aggors)){
						 CiHpCheckResultDTO result =  HpService.checkCiHpSave(ciHpCheckDTO);
						 if(result == null){
							 CiOrdUtils.LogerOutInfo(aggors[0].getParentDO().getName_or()+"  验证规则信息返回null");
						 }else{
							 CiOrdUtils.LogerOutInfo(aggors[0].getParentDO().getName_or()+"  验证规则信息"+result.toString());
						 }
						 
						 if(result != null ){
							 if(!FBoolean.TRUE.equals(result.getCheckflag())){
								 FMap2 map = result .getFailidorsrvmap();
								   error = getHPMessageError(map);
							 }else{
								 return error;
							 }
						 }
					 }
					 return error;	 
		 }
		 
		 
		 
		 
		 
		 /**
		   * 获取物品信息
		   * @param oraggandrelinfo
		   * @return
		   */
		 private  boolean  getOrderSignSrvMmDO(CiHpCheckDTO ciHpCheckDTO,CiorderAggDO[] aggors)throws BizException{
			  boolean  IsHp = false;
			 if(aggors != null && aggors.length >0){
				 FArrayList2 hpqry = new FArrayList2();
				 for(CiorderAggDO aggDO:aggors){
					 if(aggDO != null && aggDO.getParentDO() != null && aggDO.getOrdSrvDO().length >0  
							 && aggDO.getOrdSrvDO()[0].getId_hp() != null
							 /*&& aggDO.getOrdSrvDO()[0].getFg_selfpay() != null 
							 && !aggDO.getOrdSrvDO()[0].getFg_selfpay().booleanValue()*/){
					
						 FArrayList2 srvList=new FArrayList2();
						 HpQryCiorderDTO hpqryCiOrderDto = new HpQryCiorderDTO();
						 OrdSrvDO[] orsrvdos=aggDO.getOrdSrvDO();
						 String id_orsrv ="";
						 List  idSrvList = new java.util.ArrayList<>();
							 for(OrdSrvDO srvDO:orsrvdos){
								 id_orsrv +=",'"+srvDO.getId_orsrv()+"'";
								 idSrvList.add(srvDO.getId_srv());
							    srvList.append(srvDO);
							 } 
						getOrderSignSrvMms(hpqryCiOrderDto,id_orsrv,idSrvList);
						 hpqryCiOrderDto.setCiorderdo(aggDO.getParentDO());
						 //hpqryCiOrderDto.setOrdsrvmms(srvMmList);
						 hpqryCiOrderDto.setOrdsrvs(srvList);
						 hpqry.append(hpqryCiOrderDto);
						 IsHp = true;
					 } 
				 }
				 ciHpCheckDTO.setSavecidto(hpqry);
			 }
			 return IsHp;
		 }
		 
		 /**
		  * 
		  * @param id_orsrv
		  * @throws BizException
		  */
		 private void getOrderSignSrvMms(HpQryCiorderDTO hpqryCiOrderDto,String id_orsrv,List<String>  idSrvList)throws BizException{
			 if(id_orsrv != ""){
				 FArrayList2 srvMmList=new FArrayList2();
				 String  whereStr = OrdSrvMmDO.ID_ORSRV+" in ("+id_orsrv.substring(1)+")";
				 OrdSrvMmDO[] srvmmDO = CiOrdAppUtils.getOrSrvMmQryService().find(whereStr, OrdSrvMmDO.ID_ORSRV, FBoolean.FALSE);
			      int i = 0;
				 for(OrdSrvMmDO mm: srvmmDO){
					 if(i<=idSrvList.size()){
						 mm.setId_srv(idSrvList.get(i));
					 }
			    	  srvMmList.append(mm);
			    	  i++;
			      }
			      hpqryCiOrderDto.setOrdsrvmms(srvMmList);
			 }
		 }
}
