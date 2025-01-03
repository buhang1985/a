package iih.ci.ord.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.medusage.i.IMedusagedesRService;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.d.desc.OrTmplDODesc;
import iih.ci.ord.dto.newordertemplatedto.d.NewOrderTemplateDTO;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.SortEnum;
import iih.ci.ord.s.bp.assi.bp.GetSrvPriceBP;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.bp.qry.GetMedSrvItemDOBP;
import iih.ci.ord.s.ems.cache.BDSrvDrugInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * @ClassName: getSrvortplitemAggDOSBP
 * @Description: 住院 医嘱助手 医嘱模板项目 
 * @author Comsys-li_zheng
 * @date 2016年3月9日 下午1:33:56
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class IPGetSrvortplitemAggDOSBP {
	
	  private FMap freqMap; //频次集合
	  private FMap measDocMap;//剂量单位
	  private FMap routeMap;//用法集合
	  private FMap routeDesMap; // 用法要求集合
	  private FMap boilMap;//煎法集合
	  private FArrayList templateList;
	  private FArrayList NewTmplateList;
	  Map<String, FDouble> srvMapPrice ;//非物品价格
	  Map<String, FDouble> mmMapPrice ;//物品价格
	  
	  Map<String, String> srvMapMedical ;//非物品医保目录
	  Map<String, String> mmMapMedical ;//物品医保目录
	  
	  Map<String, String> Id_mmMap; //物品id集合
	  Map<String, String> Id_srvMap;//项目id 集合
	  
	  //项目是否停用
	  FMap2  bdsrvUserMap;
	  List<OrdSrvChangedInfoDTO> infoList;
	  //服务校验结果
	  private Map<String, String> checkSrvValRst;
	  
	  public IPGetSrvortplitemAggDOSBP(CiEnContextDTO ctx)throws BizException{
		  this.getFreqDefDO(ctx);
		  this.getMeasDocDO();
		  this.getBoilDO();
		  //this.getRouteDO();
	  }
	  /**
       *zwq添加缓存模板数据时使用
       * @param id_ortmpl
       * @return
       * @throws BizException
       */
	  public FMap getNewOrderTemplateDTO2(String Id_pripat,String id_hp,String code_entp)throws BizException{
			  this.templateList = new FArrayList();
			  this.infoList = new ArrayList();
			  String whereStr =" 1=1";
			  if(getEnTp(code_entp) != null ){
				  whereStr += "  and " +getEnTp(code_entp); 
			  }
			  OrtmplAggDO[] aggdo = CiOrdAppUtils.getIOrtmplRService().find(whereStr, OrTmplDODesc.PRIMARYKEY_FIELDNAME, FBoolean.FALSE);

			  return HandleOrTmplate(aggdo,Id_pripat,id_hp,code_entp);
			 //return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	   /**
       * 新的医嘱模板的逻辑(20170510 改造)
       * @param id_ortmpl
       * @return
       * @throws BizException
       */
	  public FMap getNewOrderTemplateDTO2(String[] id_ortmpl,String Id_pripat,String id_hp,String code_entp)throws BizException{
			  this.templateList = new FArrayList();
			  this.infoList = new ArrayList();
			  String  whereStr = OrTmplDODesc.PRIMARYKEY_FIELDNAME +" in ( "+CiOrdUtils.IdsConveretCharacterString(id_ortmpl)+" )";
			  if(getEnTp(code_entp) != null ){
				  whereStr += "  and " +getEnTp(code_entp); 
			  }
			  OrtmplAggDO[] aggdo = CiOrdAppUtils.getIOrtmplRService().find(whereStr, OrTmplDODesc.PRIMARYKEY_FIELDNAME, FBoolean.FALSE);

			  return HandleOrTmplate(aggdo,Id_pripat,id_hp,code_entp);
			 //return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	  private String getEnTp(String code_entp){
		  String entp = null;
			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)) {
				entp = " fg_entp_op ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp)) {
				entp = " fg_entp_er ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp)) {
				entp = " fg_entp_er1 ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp)) {
				entp = " fg_entp_er2 ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)) {
				entp = " fg_entp_ip ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)) {
				entp = "  fg_entp_fm ='Y'";
			} else if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)) {
				entp = "  fg_entp_pe ='Y'";
			}
			return entp;
	  }
	  
	  /**
	   * 价格 医保，服务的启用 处理
	   * @param aggdo
	   * @param Id_pripat
	   * @param id_hp
	   * @param code_entp
	   * @return
	   * @throws BizException
	   */
	  private FMap HandleOrTmplate(OrtmplAggDO[] aggdo,String Id_pripat,String id_hp,String code_entp)throws BizException{
		  FMap   map = new FMap();  
		  if(aggdo != null && aggdo.length >0){
			  for(OrtmplAggDO agg: aggdo){
				  this.NewTmplateList =  new FArrayList(); 
				  FArrayList temp = new FArrayList();
				  //处理时数据  
				  OrtmplateConvertTONewTmplateDTO(agg, null);
				  if(this.NewTmplateList != null && this.NewTmplateList.size()!=0){
					  temp = this.NewTmplateList;
					  map.put(agg.getParentDO().getId_ortmpl(), temp) ;
				  }
			  }
		  }
		  //服务集合 
		  HandleFMap2(map,Id_pripat,id_hp,code_entp);
		   //设置价格 医保和服务的启停
		  setvalue(map);
		  return map;
	  }
	  
	  private void HandleFMap2(FMap map,String Id_pripat,String id_hp,String code_entp)throws BizException{
		  if(map != null && map.size() >0){
			  this.Id_mmMap = new HashMap();
			  this.Id_srvMap = new HashMap();
			  this.bdsrvUserMap = new FMap2();
			  Iterator entrys=  map.entrySet().iterator();
			  while(entrys.hasNext())
			  {  
				Map.Entry entry = (Map.Entry) entrys.next();
				FArrayList TemplateList = (FArrayList) entry.getValue(); 
				if(TemplateList != null && TemplateList.size() > 0)
					{ 
						for(int i=0;i<TemplateList.size();i++){
							NewOrderTemplateDTO dto = (NewOrderTemplateDTO)TemplateList.get(i);
							FArrayList  list =  dto.getItemlist();
							HandlOrTplNItmDOlist(list);
						}
					}
			    } 
				//价格
			     List<String> Id_mmList = null;
			     if(this.Id_mmMap != null && this.Id_mmMap.size() >0){
			    	 Id_mmList = new ArrayList<String>(this.Id_mmMap.keySet());
			     }
			     List<String> Id_srvList =null;
			     if(this.Id_srvMap != null && this.Id_srvMap.size() >0){
			    	 Id_srvList = new ArrayList<String>(this.Id_srvMap.keySet());
			     }
 
				setPrice(Id_pripat,Id_srvList,Id_mmList);
				//医保目录
				MedicareCataLogSrv(id_hp,Id_srvList);
				MedicareCataLogMm(id_hp,Id_mmList);
				//服务是否停用
				if(this.infoList != null && this.infoList.size() >0){
					this.ChangedSrvValidate(this.infoList.toArray(new OrdSrvChangedInfoDTO[this.infoList.size()]), code_entp);
				}
			 
		  }
	  }
	  
	  
	  /**
	   * set 价格医保信息
	   * @param map
	   */
	  private void setvalue(FMap map){
		  if(map != null && map.size() >0){
			  Iterator entrys=  map.entrySet().iterator();
			  while(entrys.hasNext())
			  {
				Map.Entry entry = (Map.Entry) entrys.next();
				FArrayList TemplateList = (FArrayList) entry.getValue(); 
				if(TemplateList != null && TemplateList.size() > 0)
					{
						for(int i=0;i<TemplateList.size();i++){
							NewOrderTemplateDTO dto = (NewOrderTemplateDTO)TemplateList.get(i);
							FArrayList  list =  dto.getItemlist();
							HandlOrTplNItmDOSetValue(list,dto);
						}
					}
			    }
		  }
	  }
	  
	  //获取价格信息
	  private  void setPrice(String idPriPat, List<String> idSrvList,List<String> idMmList){
		  GetSrvPriceBP priceBP = new GetSrvPriceBP();
		   srvMapPrice=  priceBP.getSrvPrice(idPriPat,idSrvList); 
		   mmMapPrice=  priceBP.getMMPrice(idMmList);
	  }
	  /**
	   * 获取医保信息
	   * @param list
	   */
	  private void  HandlOrTplNItmDOlist(FArrayList list){
		   if(list != null && list.size() >0){
			   for(int i=0;i<list.size();i++){
				   OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();				  
				   OrTplNItmDO itemDo = (OrTplNItmDO)list.get(i);
				   if(itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					   this.Id_mmMap.put(itemDo.getId_mm(), itemDo.getId_mm());
					   dto.setId_srv(itemDo.getId_srv());
					   dto.setId_mm(itemDo.getId_mm());
					   this.infoList.add(dto);
				   }else{
					   this.Id_srvMap.put(itemDo.getId_srv(), itemDo.getId_srv());
					   if(!CiOrdUtils.isEmpty(itemDo.getId_srv_set())&&!this.Id_srvMap.containsKey(itemDo.getId_srv_set())){
						   this.Id_srvMap.put(itemDo.getId_srv_set(), itemDo.getId_srv_set());
						   dto.setId_srv(itemDo.getId_srv_set());
					   }else{
						   dto.setId_srv(itemDo.getId_srv());
					   }
					   this.infoList.add(dto);
				   }
				   
			   }
		   }
	  }
	  
	  //设置价格和医保信息
	  private void  HandlOrTplNItmDOSetValue(FArrayList list,NewOrderTemplateDTO dto){
		   if(list != null && list.size() >0){
			   if(this.srvMapPrice != null && this.srvMapPrice.containsKey(dto.getId_srv())){
				   dto.setPrice(formatePriceLength(this.srvMapPrice.get(dto.getId_srv())));
			    }
			   if(this.mmMapMedical != null && this.mmMapMedical.containsKey(dto.getId_srv())){
				   dto.setName_hp(this.mmMapMedical.get(dto.getId_srv()));					   
				}
			   if(this.srvMapMedical != null && this.srvMapMedical.containsKey(dto.getId_srv())){
				   dto.setName_hp(this.srvMapMedical.get(dto.getId_srv()));					   
				}
			   
			   if(this.bdsrvUserMap != null ){
				   
				   String key = dto.getId_srv();
				   if(this.bdsrvUserMap.containsKey(key)){
					   dto.setDescription((String)(this.bdsrvUserMap.get(key)));	
					   dto.setFg_active(FBoolean.FALSE);
				   }else{
					   // 拼接id_srv,id_mm 作为key值
					   key += StringUtils.isBlank(dto.getId_mm()) ? "" :","+dto.getId_mm();
					   
					   if( this.bdsrvUserMap.containsKey(key)){
						   dto.setDescription((String)(this.bdsrvUserMap.get(key)));	
						   dto.setFg_active(FBoolean.FALSE);
					   }
				   }
			   }
			   
			   
			   for(int i=0;i<list.size();i++){
				   OrTplNItmDO itemDo = (OrTplNItmDO)list.get(i);

				   if(itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					   if(this.mmMapPrice != null && this.mmMapPrice.containsKey(itemDo.getId_srv()+","+itemDo.getId_mm())){
						   itemDo.setPrice(formatePriceLength(this.mmMapPrice.get(itemDo.getId_srv()+","+itemDo.getId_mm())));
					   }
					  if(this.mmMapMedical != null && this.mmMapMedical.containsKey(itemDo.getId_mm())){
						  itemDo.setName_hp(this.mmMapMedical.get(itemDo.getId_mm()));					   
						 }
					  
					if (this.bdsrvUserMap != null) {

						String key2 = itemDo.getId_srv();
						if (this.bdsrvUserMap.containsKey(key2)) {

							itemDo.setDescription((String) (this.bdsrvUserMap.get(key2)));
							itemDo.setFg_active(FBoolean.FALSE);
						} else {
							// 拼接id_srv,id_mm作为key值
							key2 += StringUtils.isBlank(itemDo.getId_mm()) ? "" : "," + itemDo.getId_mm();
							if (this.bdsrvUserMap.containsKey(key2)) {

								itemDo.setDescription((String) (this.bdsrvUserMap.get(key2)));
								itemDo.setFg_active(FBoolean.FALSE);
							}
						}
					}
					
					  
					  
					   
				   }else{
					   if(this.srvMapPrice != null && this.srvMapPrice.containsKey(itemDo.getId_srv())){
						   itemDo.setPrice(formatePriceLength(this.srvMapPrice.get(itemDo.getId_srv())));
					    }
					  if(this.srvMapMedical != null && this.srvMapMedical.containsKey(itemDo.getId_srv())){
						  itemDo.setName_hp(this.srvMapMedical.get(itemDo.getId_srv()));					   
						 }
					  if(this.bdsrvUserMap != null && this.bdsrvUserMap.containsKey(itemDo.getId_srv())){ 
						  itemDo.setDescription((String)(this.bdsrvUserMap.get(itemDo.getId_srv())));		
						  itemDo.setFg_active(FBoolean.FALSE);
						  if(dto.getUi_flag() != null && dto.getUi_flag()=="1"){
							  dto.setFg_active(FBoolean.FALSE);//套的不可启用  （套有一个项目停用的 套就停用  王琪）
							  dto.setDescription((String)(this.bdsrvUserMap.get(itemDo.getId_srv())));
						  }
						}
				   }
				   
			   }
		   }
	  }
	  
	  /**
	   * 服务的启停接口
	   * @param ordSrvChangedInfoDTO
	   * @param code_entp
	   * @throws BizException
	   */
	private void  ChangedSrvValidate(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTO,String code_entp)throws BizException{
	 OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
	  this.bdsrvUserMap = bp.exec(ordSrvChangedInfoDTO, code_entp);
	}  
	  
	  
	  //模板转换成NewTmplateDTO
	  private void OrtmplateConvertTONewTmplateDTO(OrtmplAggDO aggdo, CiEnContextDTO ctx)throws BizException{
		  // 初始化用法
		  this.getRouteDO(aggdo, ctx);
		  this.getRouteDesMap(aggdo, ctx);
		  
		  if(IBdSrvDictCodeConst.SD_ORTMPLTP_FHMBA.equals(aggdo.getParentDO().getSd_ortmpltp())
			||IBdSrvDictCodeConst.SD_ORTMPLTP_RIS.equals(aggdo.getParentDO().getSd_ortmpltp())
		    ||IBdSrvDictCodeConst.SD_ORTMPLTP_LIS.equals(aggdo.getParentDO().getSd_ortmpltp())
		    ||IBdSrvDictCodeConst.SD_ORTMPLTP_TREAT.equals(aggdo.getParentDO().getSd_ortmpltp())){
			//复合模板 
			  setOrTemplateFuhemoban(aggdo, ctx);
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(aggdo.getParentDO().getSd_ortmpltp())){
		   //西成药模板  
			   setOrTemplateXCY(aggdo);
			   
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(aggdo.getParentDO().getSd_ortmpltp())){
			   //草药模板  
			   setOrTemplateCYFJ(aggdo);
		   }
	  }
	  

	  /**
	   * 医保目录 非药品
	   * @param id_hp
	   * @param id_srv
	   * @return
	   */
	  private void MedicareCataLogSrv(String id_hp,List<String> id_srvs){
		  srvMapMedical = new HashMap();
		  if(id_hp == null || id_hp ==""){
			  
		  }else{
			  String sql = "select  bd_hp_srvorca.id_srv, bd_udidoc.name  "
			   		   +"  from bd_hp_srvorca , bd_udidoc"
	                   +" where bd_hp_srvorca.id_hpsrvtp = bd_udidoc.id_udidoc"
					   +" and  bd_hp_srvorca.id_hp = '"+id_hp+"'"
					   +" and bd_hp_srvorca.id_srv  in ("+CiOrdUtils.ListConveretCharacterString(id_srvs)+")";
			   try{
					   List<Map<String, Object>> priMapList = null;
					   priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql,
								new MapListHandler());
					   if(priMapList != null && priMapList.size() >0){
						 for(Map<String, Object> priObjMap : priMapList){
							 String key = (String) priObjMap.get("id_srv");
							 String value = (String) priObjMap.get("name");
							 srvMapMedical.put(key, value);
						  }  
					    }
			     }catch (DAException e) {
					throw new BizRuntimeException(e.getMessage());
				}
		  }
		   
		   
	  }
	  /**
	   * 医保目录药品
	   * @param id_hp
	   * @param id_mm
	   * @return
	   */
	  private void MedicareCataLogMm(String id_hp,List<String> id_mms){
		   mmMapMedical= new HashMap();
		   if(id_hp == null || id_hp ==""){
				  
			}else{
				 //select bd_hp_srvorca.id_hp,bd_hp_srvorca.id_srv,bd_hp_srvorca.id_mm, bd_udidoc.name 
				   String sql = "select  bd_hp_srvorca.id_mm, bd_udidoc.name  "
					   		   +"  from bd_hp_srvorca , bd_udidoc"
			                   +" where bd_hp_srvorca.id_hpsrvtp = bd_udidoc.id_udidoc"
							   +" and  bd_hp_srvorca.id_hp = '"+id_hp+"'"
							   +" and bd_hp_srvorca.id_mm  in ("+CiOrdUtils.ListConveretCharacterString(id_mms)+") ";
				   
				   try{
					      List<Map<String, Object>> priMapList = null;
						   priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql,
									new MapListHandler());
						   if(priMapList != null && priMapList.size() >0){
								 for(Map<String, Object> priObjMap : priMapList){
									 String key = (String) priObjMap.get("id_mm");
									 String value = (String) priObjMap.get("name");
									 mmMapMedical.put(key, value);
								  }  
							    }
					   }catch (DAException e) {
							throw new BizRuntimeException(e.getMessage());
					   }
		   }   
	  }
	  
       /**
        *  医嘱模板的逻辑
        * @param id_ortmpl
        * @return
        * @throws BizException
        */
	  @Deprecated
	  public NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl, CiEnContextDTO ctx)throws BizException{
			  this.templateList = new FArrayList(); 
			  this.NewTmplateList = new FArrayList();
			  getTemplateType(id_ortmpl,ctx);
			  
			 return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	private void getTemplateType(String id_ortmpl, CiEnContextDTO ctx)
			throws BizException {
		OrtmplAggDO aggdo = CiOrdAppUtils.getIOrtmplRService().findById(
				id_ortmpl);
		if (aggdo == null) {
			return;
		}
		// 初始化用法
		this.getRouteDO(aggdo, ctx);
		this.getRouteDesMap(aggdo, ctx);

		OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
		// TODO: 设置价格
		if (ctx != null && !StringUtils.isEmpty(ctx.getId_pripat())) {
			setPriceOrTp(orTplItem, ctx);
		}
		// 排序
		if (orTplItem != null) {
			aggdo.setOrTplNItmDO(CiOrdUtils.Sort(orTplItem, OrTplNItmDO.SORTNO, SortEnum.ASC));
		}
		// Ui_flag 1 :套 , 2:(多药品)药品, 3:(单一药品), 5 草药显示, 4 :其它 (NewTemplteDTO 的
		// str 赋值显示子项没有checkbox)
		// 复合模板
		// 西成药模板
		// 草药模板
		if (IBdSrvDictCodeConst.SD_ORTMPLTP_FHMBA.equals(aggdo.getParentDO().getSd_ortmpltp())
				|| IBdSrvDictCodeConst.SD_ORTMPLTP_RIS.equals(aggdo.getParentDO().getSd_ortmpltp())
				|| IBdSrvDictCodeConst.SD_ORTMPLTP_LIS.equals(aggdo.getParentDO().getSd_ortmpltp())) {
			// 复合模板
			setOrTemplateFuhemoban(aggdo, ctx);
		} else if (IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(aggdo.getParentDO().getSd_ortmpltp())) {
			// 西成药模板
			setOrTemplateXCY(aggdo);
		} else if (IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(aggdo.getParentDO().getSd_ortmpltp())) {
			// 草药模板
			setOrTemplateCYFJ(aggdo);
		} else {
			// 复合模板
			setOrTemplateFuhemoban(aggdo, ctx);
		}
		// 服务是否停用校验
		getOrdSRvChangedInfoDTOs();
		if (infoList != null && infoList.size() > 0) {
			checkSrvValRst = new OrdChangedSrvValidateBP().exec(ctx.getCode_entp(), infoList);
			if (checkSrvValRst != null && !checkSrvValRst.isEmpty()) {
				for (int i = 0; i < this.templateList.size(); i++) {
					NewOrderTemplateDTO dto = (NewOrderTemplateDTO) this.templateList.get(i);
					setInfo(dto);
				}
			}
		}
	}
	  
	  /**
	   * @code  设置价格
	   * @author LiYue
	   * @date 2019年9月23日,下午7:45:20
	   * @param aggdo
	   * @param ctx
	   */
	  private void setPriceOrTp(OrTplNItmDO[] OrTplNItmDOs,CiEnContextDTO ctx) {
		if (ctx == null || StringUtils.isEmpty(ctx.getId_pripat()))
			return;

		List<String> idSrvList = new ArrayList<>();
		List<String> idMMList = new ArrayList<>();
		for (OrTplNItmDO orTplNItmDO : OrTplNItmDOs) {
			if (StringUtils.isNotEmpty(orTplNItmDO.getSd_srvtp()) && orTplNItmDO.getSd_srvtp().startsWith("01")) {
				idMMList.add(orTplNItmDO.getId_mm());
			} else {
				idSrvList.add(orTplNItmDO.getId_srv());
			}
		}
		// 查询价格
		Map<String, FDouble> priMap = new GetSrvPriceBP().getSrvAndMMPrice(ctx.getId_pripat(), idSrvList, idMMList);
		// 设置价格
		if(priMap!=null && priMap.size()>0) {
		for (Map.Entry<String, FDouble> entry : priMap.entrySet()) {
			for (OrTplNItmDO orTplNItmDO : OrTplNItmDOs) {
				if (StringUtils.isNotEmpty(orTplNItmDO.getSd_srvtp()) && orTplNItmDO.getSd_srvtp().startsWith("01") 
						&& (orTplNItmDO.getId_srv()+","+orTplNItmDO.getId_mm()).equals(entry.getKey())) {
					orTplNItmDO.setPrice(formatePriceLength(entry.getValue()));
				} else if (orTplNItmDO.getId_srv().equals(entry.getKey())) {
					orTplNItmDO.setPrice(formatePriceLength(entry.getValue()));
				}
			}
		}
		}
	}

	private void getOrdSRvChangedInfoDTOs() {
		if(this.templateList==null||this.templateList.size()==0){
			  return;
		  }
		  infoList = new ArrayList<OrdSrvChangedInfoDTO>();
		  for(int i=0;i<this.templateList.size();i++){
			  NewOrderTemplateDTO tempdto = (NewOrderTemplateDTO)this.templateList.get(i);
			  FArrayList itmdos = tempdto.getItemlist();
			  if(itmdos!=null&&itmdos.size()>0){
				  List<String> idsrvs = new ArrayList<String>();// 项目id集合
				  for(int j=0;j<itmdos.size();j++){
					  OrTplNItmDO itemDo = (OrTplNItmDO)itmdos.get(j);
					  OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
					  if (itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
							dto.setId_srv(itemDo.getId_srv());
							dto.setId_mm(itemDo.getId_mm());
						} else {
							idsrvs.add(itemDo.getId_srv());
							if (!CiOrdUtils.isEmpty(itemDo.getId_srv_set()) && !idsrvs.contains(itemDo.getId_srv_set())) {
								idsrvs.add(itemDo.getId_srv_set());
								dto.setId_srv(itemDo.getId_srv_set());
							} else {
								dto.setId_srv(itemDo.getId_srv());
							}
						}
						infoList.add(dto);
				  }
			  }
		  }
	}
	  
	private void setInfo(NewOrderTemplateDTO dto) {
		if (this.checkSrvValRst != null) {

			String key = dto.getId_srv();
			if (this.checkSrvValRst.containsKey(key)) {
				dto.setDescription(this.checkSrvValRst.get(key));
				dto.setFg_active(FBoolean.FALSE);
			} 
			else {
				// 拼接id_srv,id_mm 作为key值
				key += StringUtils.isBlank(dto.getId_mm()) ? "" : "," + dto.getId_mm();
				if (this.checkSrvValRst.containsKey(key)) {
					dto.setDescription(this.checkSrvValRst.get(key));
					dto.setFg_active(FBoolean.FALSE);
				}
			}
		}
		
		FArrayList list = dto.getItemlist();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				OrTplNItmDO itemDo = (OrTplNItmDO) list.get(i);
				if (itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					if (this.mmMapPrice != null && this.mmMapPrice.containsKey(itemDo.getId_srv() + "," + itemDo.getId_mm())) {
						itemDo.setPrice(formatePriceLength(this.mmMapPrice.get(itemDo.getId_srv() + "," + itemDo.getId_mm())));
					}
					if (this.mmMapMedical != null && this.mmMapMedical.containsKey(itemDo.getId_mm())) {
						itemDo.setName_hp(this.mmMapMedical.get(itemDo.getId_mm()));
					}

					if (this.checkSrvValRst != null) {
						String key = itemDo.getId_srv();
						if (this.checkSrvValRst.containsKey(key)) {
							itemDo.setDescription(this.checkSrvValRst.get(key));
							itemDo.setFg_active(FBoolean.FALSE);
						} else {
							// 拼接id_srv,id_mm作为key值
							key += StringUtils.isBlank(itemDo.getId_mm()) ? "" : "," + itemDo.getId_mm();
							if (this.checkSrvValRst.containsKey(key)) {
								itemDo.setDescription(this.checkSrvValRst.get(key));
								itemDo.setFg_active(FBoolean.FALSE);
							}
						}
					}
				} else {
					if (this.srvMapPrice != null && this.srvMapPrice.containsKey(itemDo.getId_srv())) {
						itemDo.setPrice(formatePriceLength(this.srvMapPrice.get(itemDo.getId_srv())));
					}
					if (this.srvMapMedical != null && this.srvMapMedical.containsKey(itemDo.getId_srv())) {
						itemDo.setName_hp(this.srvMapMedical.get(itemDo.getId_srv()));
					}
					if (this.checkSrvValRst != null && this.checkSrvValRst.containsKey(itemDo.getId_srv())) {
						itemDo.setDescription(this.checkSrvValRst.get(itemDo.getId_srv()));
						itemDo.setFg_active(FBoolean.FALSE);
						if (dto.getUi_flag() != null && dto.getUi_flag() == "1") {
							dto.setFg_active(FBoolean.FALSE);
							dto.setDescription(this.checkSrvValRst.get(itemDo.getId_srv()));
						}
					}
				}
			}
		}
	}
	  
	private void  setOrTemplateFuhemoban(OrtmplAggDO aggdo, CiEnContextDTO ctx) throws BizException{
		  if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
			  OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
			  for(OrTplNItmDO  item:orTplItem){
				  if(!StringUtils.isEmpty(item.getName_srv())){
						  item.setOrtplnitm_srv_name(item.getName_srv());
					  }
				if(OrTplItmTypeEnum.ORTMPL.equals(item.getEu_ortplitmtp())){
					OrtmplAggDO tempAggDO = CiOrdAppUtils.getIOrtmplRService().findById(item.getId_srv());
					setPriceOrTp(tempAggDO.getOrTplNItmDO(), ctx);
					if (IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(tempAggDO.getParentDO().getSd_ortmpltp())) {
						// 西成药模板
						setOrTemplateXCY(tempAggDO);
					} else if (IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(tempAggDO.getParentDO().getSd_ortmpltp())) {
						// 草药模板
						setOrTemplateCYFJ(tempAggDO);
					}
				}else if(OrTplItmTypeEnum.SRV.equals(item.getEu_ortplitmtp())){
					 NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					 template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					  template.setFreqdefdo(freqMap);
					  template.setMeasdocdo(measDocMap);
					  template.setRoutedo(routeMap);
					  template.setRouteDesMap(routeDesMap);
					  template.setBoildo(boilMap);
					  template.setId_srv(item.getId_srv());
					  template.setId_mm(item.getId_mm());
					  template.setSd_srvtp(item.getSd_srvtp());
					  template.setId_freq(item.getId_freq());
					  template.setName_freq(item.getOrtplnitm_freq_name());
					  template.setDays_or(item.getDays_or());
					  template.setName_route(item.getOrtplnitm_route_name());
					  template.setName_routedes(item.getOrtplnitm_boildes_name());
					 FArrayList Itemlist = new FArrayList();
					 if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)){
						 template.setUi_flag("3");
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 MedSrvDrugDO druginfo = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, item.getId_srv());
						 if (druginfo != null) {
								if(FBoolean.TRUE.equals(druginfo.getFg_highrisk())) {
									item.setOrtplnitm_mm_name("【高危】" + item.getOrtplnitm_mm_name());
									item.setOrtplnitm_srv_name("【高危】" + item.getOrtplnitm_srv_name());
								}
							}
						 template.setId(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("4");
						 template.setTemplatetype(FBoolean.TRUE);
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 MedSrvDrugDO druginfo = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, item.getId_srv());
						 if (druginfo != null) {
								if(FBoolean.TRUE.equals(druginfo.getFg_highrisk())) {
									item.setOrtplnitm_mm_name("【高危】" + item.getOrtplnitm_mm_name());
									item.setOrtplnitm_srv_name("【高危】" + item.getOrtplnitm_srv_name());
								}
							}
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("6");//诊疗项目
						// template.setTemplatetype(FBoolean.TRUE);
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else{
						// NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
						 
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("4");
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }
					 template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
					 this.templateList.append(template);
					 this.NewTmplateList.append(template);
				 }else if(OrTplItmTypeEnum.SRVSET.equals(item.getEu_ortplitmtp())){
					 NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					 template.setName(item.getOrtplnitm_srv_name());
					 template.setId(item.getId_ortmplitm());
					 template.setUi_flag("1");
					  template.setFreqdefdo(freqMap);
					  template.setMeasdocdo(measDocMap);
					  template.setRoutedo(routeMap);
					  template.setBoildo(boilMap);
					 //template.setItem(Item);
					  template.setId_freq(item.getId_freq());
					  template.setName_freq(item.getOrtplnitm_freq_name());
					  template.setDays_or(item.getDays_or());
					  template.setName_route(item.getOrtplnitm_route_name());
					  template.setName_routedes(item.getOrtplnitm_boildes_name());
					  template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					 template.setItemlist(getOrTplNItmDOSet(item));
					 template.setId_srv(item.getId_srv());
					 template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
					 this.templateList.append(template);
					 this.NewTmplateList.append(template);
				 }
			  }
		  }
	  }
	  
	  /**
	   * 西成药
	   * @param aggdo
	   * @throws BizException
	   */
	   private void setOrTemplateXCY(OrtmplAggDO aggdo)throws BizException{
		   if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
			   OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
			   FArrayList Itemlist = new FArrayList();
			   NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
			   template.setId(aggdo.getParentDO().getId_ortmpl());
			   template.setName(aggdo.getParentDO().getName());
			   template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
			   template.setUi_flag("2");
			   template.setId_freq(aggdo.getParentDO().getId_freq());
			   template.setName_freq(aggdo.getParentDO().getOrtmpl_freq_name());
			   template.setFreqdefdo(freqMap);
			   template.setMeasdocdo(measDocMap);
			   template.setRoutedo(routeMap);
			   template.setRouteDesMap(routeDesMap);
//			   template.setBoildo(boilMap);
			   template.setName_route(aggdo.getParentDO().getOrtmpl_route_name());
			   template.setName_routedes(aggdo.getParentDO().getOrtmpl_routedes_name());
			   template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
			   if(orTplItem != null && orTplItem.length >0){
				   int num = orTplItem.length;
				   int seq =0;
				   for(OrTplNItmDO item:orTplItem){
					   item.setDays_or(aggdo.getParentDO().getDays_or());
					   item.setOrtplnitm_route_code(aggdo.getParentDO().getOrtmpl_route_code());
					   item.setOrtplnitm_route_name(aggdo.getParentDO().getOrtmpl_route_name());
					   item.setOrtplnitm_routedes_name(aggdo.getParentDO().getOrtmpl_routedes_code());
					   item.setOrtplnitm_routedes_name(aggdo.getParentDO().getOrtmpl_routedes_name());
					   
					   item.setOrtplnitm_freq_code(aggdo.getParentDO().getOrtmpl_freq_code());
					   item.setOrtplnitm_freq_name(aggdo.getParentDO().getOrtmpl_freq_name());
					   template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					   item.setIdentical_ortmpl(aggdo.getParentDO().getId_ortmpl());
					   
					      template.setName_freq(item.getOrtplnitm_freq_name());
						  template.setDays_or(item.getDays_or());
//						  template.setName_route(item.getOrtplnitm_route_name());
//						  template.setName_routedes(item.getOrtplnitm_boildes_name());
						  
						  MedSrvDrugDO druginfo = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, item.getId_srv());
							if (druginfo != null) {
								if(FBoolean.TRUE.equals(druginfo.getFg_highrisk())) {
									item.setOrtplnitm_mm_name("【高危】" + item.getOrtplnitm_mm_name());
									item.setOrtplnitm_srv_name("【高危】" + item.getOrtplnitm_srv_name());
								}
							}
						  
					   if(num==2){
						   if(seq==0){
							   item.setOrtplnitm_mm_name("┏ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┏ "+item.getOrtplnitm_srv_name());
						   }else{
							   item.setOrtplnitm_mm_name("┗ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┗ "+item.getOrtplnitm_srv_name());
						   }
						   
					   }else if(num >2){
						   if(seq==0){
							   item.setOrtplnitm_mm_name("┏ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┏ "+item.getOrtplnitm_srv_name());
						   }else if(seq==num-1){
							   item.setOrtplnitm_mm_name("┗ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┗ "+item.getOrtplnitm_srv_name());
						   }else{
							   item.setOrtplnitm_mm_name("┠ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┠ "+item.getOrtplnitm_srv_name());
						   }
					   } 
					   
					   Itemlist.append(item);
					   template.setId_srv(item.getId_srv());
					   template.setId_mm(item.getId_mm());
					   template.setSd_srvtp(item.getSd_srvtp());
					   seq++;
				   } 
			   }
			 
			   template.setItemlist(Itemlist);
			   this.templateList.append(template);
			   this.NewTmplateList.append(template);
		   }
	   }
	  
	   /**
		   *  草药方剂
		   * @param aggdo
		   * @throws BizException
		   */
		   private void setOrTemplateCYFJ(OrtmplAggDO aggdo)throws BizException{
			   if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
				   OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
				   FArrayList Itemlist = new FArrayList();
				   NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					template.setId(aggdo.getParentDO().getId_ortmpl());
					template.setName(aggdo.getParentDO().getName());
					template.setId_boil(aggdo.getParentDO().getId_boil());
					template.setId_route(aggdo.getParentDO().getId_route());
					template.setId_freq(aggdo.getParentDO().getId_freq());
					template.setName_route(aggdo.getParentDO().getOrtmpl_route_name());
					template.setName_boil(aggdo.getParentDO().getOrtmpl_boil_name());
					template.setName_freq(aggdo.getParentDO().getOrtmpl_freq_name());
					template.setId(aggdo.getParentDO().getId_ortmpl());
					template.setName(aggdo.getParentDO().getName());
					template.setTemplatetype(FBoolean.TRUE);// 其它模板时N ，草药模板时 Y
					template.setOrders(aggdo.getParentDO().getOrders());										// 页面显示控件判断使用
					template.setUi_flag("5");
					template.setName_routedes(aggdo.getParentDO().getOrtmpl_routedes_name());
					template.setFreqdefdo(freqMap);
					template.setMeasdocdo(measDocMap);
					template.setRoutedo(routeMap);
					template.setRouteDesMap(routeDesMap);
					template.setBoildo(boilMap);
					for (OrTplNItmDO item : orTplItem) {
						item.setOrders(aggdo.getParentDO().getOrders());
						template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
						item.setIdentical_ortmpl(item.getId_ortmpl());
						item.setId_boil(aggdo.getParentDO().getId_boil());
						item.setOrtplnitm_boil_name(aggdo.getParentDO().getOrtmpl_boil_name());
						MedSrvDrugDO druginfo = BDSrvDrugInfoCache.GetBdSrvDrugInfo(null, item.getId_srv());
						if (druginfo != null) {
							if(FBoolean.TRUE.equals(druginfo.getFg_highrisk())) {
								item.setOrtplnitm_mm_name("【高危】" + item.getOrtplnitm_mm_name());
								item.setOrtplnitm_srv_name("【高危】" + item.getOrtplnitm_srv_name());
							}
						}
						
						Itemlist.append(item);
						template.setId_srv(item.getId_srv());
						template.setId_mm(item.getId_mm());
						template.setSd_srvtp(item.getSd_srvtp());
						template.setName_freq(item.getOrtplnitm_freq_name());
					    template.setDays_or(item.getDays_or());
					    template.setName_route(item.getOrtplnitm_route_name());
					    template.setName_routedes(item.getOrtplnitm_routedes_name());
					}
					template.setItemlist(Itemlist);
					this.templateList.append(template);
					this.NewTmplateList.append(template);
			   }
		   }	  
	  
	  /**
	   * 
	   * @param id_srv 套id
	   * @param SrvSetName 套名臣
	   * @param id_ortmpl
	   * @return
	   * @throws BizException
	   */
	  private FArrayList getOrTplNItmDOSet(OrTplNItmDO ortmpl)throws BizException{
		  FArrayList list = new FArrayList();
		  //id_srv 是套的 id
		  GetMedSrvItemDOBP qry = new GetMedSrvItemDOBP(ortmpl.getId_srv());
		  MedSrvSetItemDO[] rtn = (MedSrvSetItemDO[])AppFwUtil.getDORstWithDao(qry, MedSrvSetItemDO.class);
		  MappingOrItem(list,rtn,ortmpl);
		  return list;
	  }

      /**
       * 模板是套时 套内明细内容
       * @param list
       * @param rtn 套内集合
       * @param id_ortmpl 模板id
       * @param id_srvset 套id
       */
	  private void MappingOrItem(FArrayList list,MedSrvSetItemDO[] rtn,OrTplNItmDO ortmpl){
		  if(rtn != null && rtn.length > 0){
			 for(MedSrvSetItemDO medSrvset:rtn){
				 OrTplNItmDO item = new OrTplNItmDO();
				 item.setId_srv(medSrvset.getId_srv_itm());
					 item.setOrtplnitm_srv_name(medSrvset.getSrv_name());
				 item.setId_ortmpl(ortmpl.getId_ortmpl());
				 item.setId_boil(medSrvset.getId_boil());
				 item.setId_boildes(medSrvset.getId_boildes());
				 item.setQuan_med(medSrvset.getQuan_medu());
				 item.setId_freq(medSrvset.getId_freq());
				 //item.setId_mm(medSrv.getId_mm);
				 item.setId_ortmplitm(medSrvset.getId_srv_itm()+medSrvset.getId_srv());
				 item.setId_route(medSrvset.getId_route());
				 item.setId_routedes(medSrvset.getId_routedes());
				 item.setId_srvtp(ortmpl.getId_srvtp());
				 item.setSd_srvtp(ortmpl.getSd_srvtp());
				 item.setId_unit_med(medSrvset.getId_medu());
				 item.setOrtplnitm_boildes_name(medSrvset.getBoil_name());
				 item.setOrtplnitm_freq_name(medSrvset.getFreq_name());
				 item.setOrtplnitm_route_name(medSrvset.getRoute_name());
				 item.setOrtplnitm_routedes_name(medSrvset.getRoutedes_name());
				 item.setOrtplnitm_unit_name(medSrvset.getMedu_name());
				 item.setFg_edit(medSrvset.getFg_edit());
				 item.setIdentical_ortmpl(medSrvset.getId_srv());
				 item.setId_srv_set(medSrvset.getId_srv());
				 item.setPrice(ortmpl.getPrice());
				 item.setOrtplnitm_mm_name(ortmpl.getOrtplnitm_srv_name());////借用这个字段存套的 名称  需求还在 ，待优化
				 item.setFg_clinical(medSrvset.getFg_clinical());//套内临床标识
				 item.setId_dep_mp(ortmpl.getId_dep_mp());
				 //item.setOrtplnitm_boil_code(medSrv.getOrtplnitm_boil_code);
				 //item.setId_boil(Id_boil);
				 //todo 继续
				 list.add(item);
			 }
		  }
	  }
	
  
	  /**
	    * 频次集合
	    * @throws BizException
	    */
	private void getFreqDefDO(CiEnContextDTO ctx)throws BizException{
	FreqdefAggDO[] freqDef = ServiceFinder.find(IFreqdefRService.class)
			.find(" fg_active='Y'" + this.getFgUseSQL(ctx.getCode_entp()), "Name", FBoolean.FALSE);
		if(freqDef != null ){
			this.freqMap = new FMap();
			FArrayList freqdo =  new FArrayList();
		   for(FreqdefAggDO freq:freqDef){
			   FreqDefDO newFreq = new FreqDefDO();
			   newFreq.setId_freq(freq.getParentDO().getId_freq());
			   newFreq.setSd_frequnitct(freq.getParentDO().getSd_frequnitct());
			   newFreq.setFre_name(freq.getParentDO().getFre_name());
			   newFreq.setName(freq.getParentDO().getName());
			   newFreq.setFreqct(freq.getParentDO().getFreqct());
			   newFreq.setFrequnitct(freq.getParentDO().getFrequnitct());
			   freqdo.add(newFreq);
		   }	
		   this.freqMap.put("FreqDefDO", freqdo);
		}
	}
	/**
	 * 单位集合
	 * @throws BizException
	 */
	private void getMeasDocDO()throws BizException{
		MeasDocDO[] measDoc = ServiceFinder.find(IMeasdocRService.class).find("1=1", "", FBoolean.FALSE);
        if(measDoc != null && measDoc.length >0){
        	this.measDocMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(MeasDocDO item :measDoc)
        	{
        		MeasDocDO newMeasDoc = new MeasDocDO();
        		newMeasDoc.setId_measdoc(item.getId_measdoc());
        		newMeasDoc.setMeasdoc_name(item.getMeasdoc_name());
        		measlist.add(newMeasDoc);
        	}
        	this.measDocMap.put("MeasDocDO",measlist);
        }
	}
	/**
	 * 煎法集合
	 * @throws BizException
	 */
	private void getBoilDO()throws BizException{
		CHerbBoilMdDO[] measDoc = ServiceFinder.find(ICherbboilmdMDORService.class).find("1=1", "", FBoolean.FALSE);
        if(measDoc != null && measDoc.length >0){
        	this.boilMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(CHerbBoilMdDO item :measDoc)
        	{
        		CHerbBoilMdDO mddo = new CHerbBoilMdDO();
        		mddo.setId_boil(item.getId_boil());
        		mddo.setName(item.getName());
        		measlist.add(mddo);
        	}
        	this.boilMap.put("CHerbBoilMdDO",measlist);
        }
	}
	/**
	 * 用法集合
	 * @throws BizException
	 */
	private void getRouteDO(OrtmplAggDO ortmplAgg, CiEnContextDTO ctx)throws BizException{
		
		MedUsageDO[] medUsages = null;
		OrTplNItmDO[] orTplNItms = ortmplAgg.getOrTplNItmDO();
		if(orTplNItms != null && orTplNItms.length > 0) {
		    String sd_srvtp = orTplNItms[0].getSd_srvtp();
		  // 如果是草药，根据草药固定的剂型查询剂型关联的用法
			if(CiOrdUtils.isHerbOrder(sd_srvtp)){
				DAFacade daFacade = new DAFacade();
				String sql = "select distinct a.*  from bd_route a "
						+ "	left join bd_route_dosage_ref b on a.id_route = b.id_route"
						+ " where b.id_dosage = ? and  b.ds=0 and a.ds= 0 and a.fg_active = 'Y'"
						+ " and a.id_org = ? and a.id_grp = ?";
				
				SqlParam sqlParam = new SqlParam();
				sqlParam.addParam(IBdSrvDictCodeConst.ID_DOSAGE_HERB);
				sqlParam.addParam(ctx.getId_org());
				sqlParam.addParam(ctx.getId_grp());
				
				List<MedUsageDO> medUsageList = (List<MedUsageDO>)daFacade.execQuery(sql, sqlParam, new BeanListHandler(MedUsageDO.class));
				medUsages = medUsageList.toArray(new MedUsageDO[medUsageList.size()]);
				
		}else{
			IMedusageRService measService =ServiceFinder.find(IMedusageRService.class);
			medUsages = measService.find("a0.fg_active = 'Y' and a0.id_org = '" + ctx.getId_org() + "' and a0.id_grp = '" + ctx.getId_grp() + "'"
			, "", FBoolean.FALSE);
		}
		
        if(medUsages != null && medUsages.length >0){
        	this.routeMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(MedUsageDO medUsage :medUsages)
        	{
        		MedUsageDO usage = new MedUsageDO();
        		usage.setId_route(medUsage.getId_route());
        		usage.setName(medUsage.getName());
        		measlist.add(usage);
        	}
        	this.routeMap.put("MedUsageDO",measlist);
        }
	  }
	}
	
	/**
	 * 用法要求集合
	 * @param ortmplAgg
	 * @param ctx
	 */
	@SuppressWarnings("unchecked")
	private void getRouteDesMap(OrtmplAggDO ortmplAgg, CiEnContextDTO ctx) throws BizException {
		MedUsageDesDO[] desDOs = ServiceFinder.find(IMedusagedesRService.class).find(" a0.ds = 0 ", "", FBoolean.FALSE);
		if (desDOs != null && desDOs.length > 0) {
        	FArrayList routeDeslist =  new FArrayList();
        	for(MedUsageDesDO desDO :desDOs)
        	{
        		routeDeslist.add(desDO);
        	}
        	this.routeDesMap = new FMap(); 
        	this.routeDesMap.put("MedUsageDesDO",routeDeslist);
		}
	}
	
	/**
	 * 价格长度处理,四舍五入
	 * @param price
	 * @return
	 */
	private FDouble formatePriceLength(FDouble price){
		//四舍五入
		if(CiOrdUtils.isEmpty(price)) return new FDouble(0.00);
		return price.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}

	public FMap getFreqMap() {
		return freqMap;
	}

	public FMap getBoilMap() {
		return boilMap;
	}

	public FMap getMeasDocMap() {
		return measDocMap;
	}

	public FMap getRouteMap() {
		return routeMap;
	}
	
	/**
	 * 获取需要校验的可使用状态的属性名
	 * 
	 * @param code_entp
	 * @return
	 */
	private String getFgUseSQL(String code_entp) {
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp))
			return " and fg_use_op='Y'";// 门诊
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
			return " and fg_use_ip='Y'";// 住院
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW.equals(code_entp))
			return " and fg_use_er='Y'";// 急诊流水
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID.equals(code_entp))
			return " and fg_use_er1='Y'";// 急诊抢救
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(code_entp))
			return " and fg_use_er2='Y'";// 急诊留观
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp))
			return " and fg_use_pe='Y'";// 体检
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp))
			return " and fg_use_fm='Y'";// 家庭

		return "";
	}
}
