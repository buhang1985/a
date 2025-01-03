package iih.ci.ord.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.ci.mr.cimrvs.d.CiMrVsItmDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.ems.OrderPassRstDTO;
import iih.ci.ord.i.ems.RationalUseCheckItemDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetRationalUseItemQry;
import iih.ci.ord.s.bp.qry.GetTemperature;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.out.d.EntOpVitalSignsDTO;
import iih.en.pv.out.i.IEn4CiQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 合理用药明细信息
 * @author zhagnwq
 *
 */
public class GetRationalUseInfoBP {
	public OrderPassRstDTO getRationalUseInfo(String id_ent,String id_pat,String idors) throws BizException{
		OrderPassRstDTO rst = new OrderPassRstDTO();
		IEn4CiQryService service = (IEn4CiQryService)ServiceFinder.find(IEn4CiQryService.class.getName());
		String[] arrStrings=id_ent.split(",");
		EntOpVitalSignsDTO[] dto  = service.getEntOpVitalSigns(arrStrings);
		if (dto!=null) {
			if (dto[0].getHeight()!=null) {
				rst.setHeight(dto[0].getHeight().toString());
			}
			if (dto[0].getWeight()!=null) {
				rst.setWeight(dto[0].getWeight().toString());
			}
		}
		
		rst.setPatDiagInfoList(getPatDiagInfo(id_ent));
		rst.setPiPatAlDOList(getPiPatAlDO(id_pat));
		rst.setRationalUseItemList(getRationalUseItemList(id_ent,idors));
		rst.setJson(getJson(id_ent,id_pat,idors));
		return rst;
	}
	/**
	 * 补充json
	 * @param id_ent
	 * @param id_pat
	 * @param idors
	 * @return
	 * @throws BizException 
	 */
	private String getJson(String id_ent, String id_pat, String idors) throws BizException {
		StringBuilder sb = new StringBuilder();
		//获取患者补充信息
		String patientInfo = getPatientInfo(id_ent);
		sb.append(patientInfo);
		//用药药品信息补充
		String druginfo = getDruginfo(idors);
		sb.append(druginfo);
		//中药处方剂数信息
		String recipeinfo =getRecipeinfo(idors);
		sb.append(recipeinfo);
		if (StringUtils.isNotEmpty(sb.toString())) {
			String string = sb.toString();
			string = string.substring(0, string.length()-1);
			return string;
		}
		return null;
	}
	/**
	 * 中药处方剂数信息
	 * @param idors
	 * @return
	 * @throws BizException 
	 */
	private String getRecipeinfo(String idors) throws BizException {
		StringBuilder sb = new StringBuilder();
		ICiorderMDORService   iCiorderRService = ServiceFinder.find(ICiorderMDORService.class);
		IMedusageRService   iMedusageRService = ServiceFinder.find(IMedusageRService.class);
		 CiOrderDO[] ciOrderDOs = iCiorderRService.find(" Id_or in ("+idors+")", "",FBoolean.FALSE);
		 if (ciOrderDOs!=null && ciOrderDOs.length>0) {
			 for (CiOrderDO ciOrderDO : ciOrderDOs) {
				 sb.append("{ \n");
					sb.append("\"type\":\"recipeinfo\",\n");
					sb.append("\"recipenno\":\""+ciOrderDO.getCode_or()+"\",\n"); 
					if (ciOrderDO.getSd_srvtp().contains("0103")) {
						 sb.append("\"recipetypecode\":\"7\",\n");
						 sb.append("\"recipetypename\":\"中药\",\n");
						 sb.append("\"recipedosage\":\""+ciOrderDO.getOrders()+"\",\n"); 
					}else{
						IOrdSrvDORService  iSrvDORService= ServiceFinder.find(IOrdSrvDORService.class);
						IMedSrvDrugDORService  iMedSrvDrugDORService= ServiceFinder.find(IMedSrvDrugDORService.class);
						 
						OrdSrvDO[] ordSrvDOs = iSrvDORService.findByAttrValString("Id_or",ciOrderDO.getId_or());
						
						if (ordSrvDOs!=null&&ordSrvDOs.length>0) {
							String[] id_srv=new String[ordSrvDOs.length];
							for (int i = 0; i < ordSrvDOs.length; i++) {
								if (ordSrvDOs[i].getId_srv()!=null) {
									id_srv[i]=ordSrvDOs[i].getId_srv() ;
								}
								
							}
							MedSrvDrugDO[] medSrvDrugDOs = iMedSrvDrugDORService.findByAttrValStrings("Id_srv", id_srv);
							if (medSrvDrugDOs!=null && medSrvDrugDOs.length>0) {
								for (MedSrvDrugDO medSrvDrugDO : medSrvDrugDOs) {
									if (medSrvDrugDO.getSd_pois()!=null) {
										sb.append("\"recipetypecode\":\""+medSrvDrugDO.getSd_pois()+"\",\n");
										sb.append("\"recipetypename\":\""+medSrvDrugDO.getName_pois()+"\",\n");
									}
								}
							}
						}
						
					}
						 if (ciOrderDO.getId_route()!=null) {
							
						}
						 if (ciOrderDO.getId_route()!=null) {
							 MedUsageDO medUsageDO = iMedusageRService.findById(ciOrderDO.getId_route());
							 if (medUsageDO!=null) {
								 sb.append("\"reciperoutecode\":\""+medUsageDO.getCode()+"\",\n"); 
							}
						}else{
							sb.append("\"reciperoutecode\":\"\",\n");
						}
						
						 sb.append("\"reciperoutename\":\""+ciOrderDO.getRoute_name()+"\",\n"); 
						 sb.append("\"recipefreq\":\""+ciOrderDO.getFreq_name()+"\",\n"); 
						 
						 sb.append("\"recipremark\":\""+ciOrderDO.getDes_or()+"\",\n"); 
					if (ciOrderDO.getSd_excessive_reason()!=null) {
						if ("2".equals(ciOrderDO.getSd_excessive_reason())) {
							sb.append("\"ischronicdisease\":\"1\",\n");
						}else{
							sb.append("\"ischronicdisease\":\"0\",\n");
						}
					}else{
						sb.append("\"ischronicdisease\":\"-1\",\n");
					}
					
					sb.append("}, \n");
			}
			 
		}
		
		return sb.toString();
	}
	/**
	 * 患者基本信息补充
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String getPatientInfo(String id_ent) throws BizException{
		StringBuilder sb = new StringBuilder();
		
	    sb.append("{ \n");
	    sb.append("\"type\":\"patientinfo\",\n");
	    IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
	    PatiVisitDO enInfo = service.getEnInfo(id_ent);
	    if (enInfo!=null ) {
	    	if (enInfo.getId_hp()==null) {
	    		sb.append("\"medicaretype\":\"0\",\n");
			}else{
				sb.append("\"medicaretype\":\"1\",\n");
			}
	    	
		}else{
			  sb.append("\"medicaretype \":\"0\",\n");
		}
	  
	    String temperature = getTemperature(id_ent);
	    if(temperature!=null){
	    	 sb.append("\"temperature\":\""+temperature+"\",\n");
	    }
	    sb.append("}, \n");
	    return sb.toString();
	}
	/**
	 * 病人用药信息补充
	 * @param idors
	 * @return
	 * @throws BizException 
	 */
	private String getDruginfo(String idors) throws BizException{
		StringBuilder sb = new StringBuilder();
		IOrdSrvDORService  iSrvDORService= ServiceFinder.find(IOrdSrvDORService.class);
		IDeptRService RService= ServiceFinder.find(IDeptRService.class); 
		 OrdSrvDO[] ordSrvDOs = iSrvDORService.find(" Id_or in ("+idors+")", "",FBoolean.FALSE);
		 Logger.error("签署的医嘱是："+idors);
		 if (ordSrvDOs!=null&&ordSrvDOs.length>0) {
			 for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				 
				 DeptDO dept = RService.findById(ordSrvDO.getId_dep_wh());
					if (dept!=null&&!StringUtils.isEmpty(dept.getName())) {
						sb.append("{ \n");
						 sb.append("\"type\":\"druginfo\",\n");
						 sb.append("\"index\":\""+ordSrvDO.getId_or()+"\",\n");
						sb.append("\"pharmacycode\":\""+dept.getCode()+"\",\n");
						sb.append("\"pharmacyname\":\""+dept.getName()+"\",\n");
						sb.append("}, \n");
					}
			}
			 
		}	
		 Logger.error("生成的字符串是："+sb.toString());
		return sb.toString();
		
	}

	/**
	 * 诊断信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FArrayList getPatDiagInfo(String id_ent) throws BizException{
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		EntDiDO[] entDis = service.getEntDiDOList(id_ent);
		FArrayList list = new FArrayList();
		if(!CiOrdUtils.isEmpty(entDis)&&entDis.length>0){
			for(EntDiDO item : entDis){
				EntDiDO di = new EntDiDO();
				di.setCode_didef_dis(item.getCode_didef_dis());
				di.setName_didef_dis(item.getName_didef_dis());
				list.add(di);
			}
		}
		return list;
	}
	/**
	 * 患者过敏史
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public FArrayList getPiPatAlDO(String id_pat) throws BizException{
		IPiPatAlDORService service = (IPiPatAlDORService)ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] pats = service.findByAttrValString(PiPatAlDO.ID_PAT, id_pat);
		FArrayList list = new FArrayList();
		if(!CiOrdUtils.isEmpty(pats)&&pats.length>0){
			for(PiPatAlDO item : pats){
				PiPatAlDO pipatal = new PiPatAlDO();
				pipatal.setName_alcla(item.getName_alcla());
				pipatal.setDes_alcla(item.getDes_alcla());
				list.add(item);
			}
		}
		return list;
	}
	/**
	 * 合理用药明细信息
	 * @param id_ent
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	public FArrayList getRationalUseItemList(String id_ent,String idors) throws BizException{
		GetRationalUseItemQry qry = new GetRationalUseItemQry(id_ent,idors);
		RationalUseCheckItemDTO[] itemArray = (RationalUseCheckItemDTO[])AppFwUtil.getDORstWithDao(qry,RationalUseCheckItemDTO.class);
		FArrayList list = new FArrayList();
		if(!CiOrdUtils.isEmpty(itemArray)&&itemArray.length>0){
			for(RationalUseCheckItemDTO item : itemArray){
				list.add(item);
			}
		}
		return list;
	}
	
	public String getTemperature(String id_ent) throws BizException{
		GetTemperature qry=new GetTemperature(id_ent);
		CiMrVsItmDO[] rtn = (CiMrVsItmDO[])AppFwUtil.getDORstWithDao(qry, CiMrVsItmDO.class);
		if (rtn !=null&&rtn.length>0) {
			return rtn[0].getValue();
		}
		return "";
	}
}
