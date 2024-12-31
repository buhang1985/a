/**
 * 
 */
package iih.ci.ord.s.bp.assi.tl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.cache.BDMmDoseUnitInfoCache;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: getMoreEmsParamDTOBP
 * @Description: 医嘱助手模板保存
 * @author Comsys-li_zheng
 * @date 2016年9月5日 下午4:39:06
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getMoreEmsParamDTOBP {
	
	private ConvertOrtmlNItem2CiOrTmplBP bp;
	
	public getMoreEmsParamDTOBP() {

		bp = new ConvertOrtmlNItem2CiOrTmplBP();
	}
	
	public  MoreEmsParamDTO  exec(CiEnContextDTO envinfo,OrTplNItmDO[] ortplItemDO)throws BizException{
		//本次就诊的医嘱和保存错误的医嘱
		//MoreEmsParamDTO  moreEmsDTO = new MoreEmsParamDTO();
		//映射成 逻辑医嘱模板 信息
		//CiOrTmplDTO[] ciOrtmplAggDTOS = getCiortmplAggDTO(ortplItemDO);
		//放入上下文信息
		Context.get().setAttribute("CiEnContextDTO", envinfo);
		List<CiOrTmplDTO> ciOrtmplList =  bp.exec(ortplItemDO, OrSourceFromEnum.IIHORTMPLHELPER);
		if(ciOrtmplList == null ) throw new BizException("选中的数据有错"); 
		//映射成CiEmsDTO
		String message = JudgeMMUintMed(envinfo,ortplItemDO);
		if(!StringUtils.isBlank(message)) {
			throw new BizException(message);
		}
		
		CiOrTmplAggDTOMappingCiEmsDTO ciEmsDTO = new CiOrTmplAggDTOMappingCiEmsDTO();
		return ciEmsDTO.Mapping(envinfo, ciOrtmplList.toArray(new CiOrTmplDTO[ciOrtmplList.size()]));
		
		/*//是否有申请表
		JudgeOrderTemplateApplicationTable apptable = new JudgeOrderTemplateApplicationTable();
		apptable.JudgeOrederTemplateAppTabel(ciEms,envinfo);
		//系统参数判断 保存数据库还是进入医疗单
		//0  仅生成医疗单UI数据（非自动生成医嘱模式）
		//1  后台自动生成医嘱模式
		 if(IsSaveEmsDTO()){
			//保存医嘱
				return SaveCiEmsDTOBP.SaveCiEmsDTO(envinfo, ciEms);
		 }else{
			 MoreEmsParamDTO param = new MoreEmsParamDTO();
			 //保存医嘱
			 FMap2  Errormap2 = new FMap2();
			 Errormap2.put("0", ciEms);
			 param.setErrormap2(Errormap2);
			return param;
		 }*/
	 
		 
	 
	}
	
	 

	/**
	  * 判断 药品的医学单位和模板的医学单位是否一致
	  * @param envinfo
	  * @param ortplItemDO
	  * @return
	  */
	  private String JudgeMMUintMed(CiEnContextDTO envinfo,OrTplNItmDO[] ortplItemDO) throws BizException{
		 StringBuffer message =  new StringBuffer();
		 List list = new ArrayList();//药品 id_mm 集合
		 Map<String,String> map = new HashMap<String,String>();
		 if(ortplItemDO !=null && ortplItemDO.length > 0) {
			 for(OrTplNItmDO itemDO: ortplItemDO) {
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
				    		 message.append("在模板里面的剂量单位和 药品基本信息里的剂量单位不一致, 请修改模板，在开立" ).append("\n");
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
      * 0  仅生成医疗单UI数据（非自动生成医嘱模式）
	  * 1  后台自动生成医嘱模式
      * @return
      * @throws BizException
      */
     /*private Boolean IsSaveEmsDTO()throws BizException{
    	 String isSave = CiOrdAppUtils.getCiOrdQryService().getCiOrAssMultiEmsHandleMode();
    	 if(isSave != null && "1".equals(isSave)){
    		 return true;
    	 }
    	 return false;
     }*/
	
	
	/**
	 * 医嘱助手-医嘱模板映射成逻辑的医嘱模板
	 * @param ortplItemDO
	 * @return
	 * @throws BizException
	 */
	/*private CiOrTmplDTO[] getCiortmplAggDTO(OrTplNItmDO[] ortplItemDO)throws BizException{
	 if(ortplItemDO == null || ortplItemDO.length ==0) return null;
	 //医嘱模板
	 FMap2 map = JudgeOrderTemlateType.JudgeOrederTemlate(ortplItemDO);
	 if(map == null || map.size() == 0) return null;
	 List<CiOrTmplDTO>  tmpList = new ArrayList();
	 List commonDrugList =(List)map.get(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG);
	 List herbalDrugList = (List)map.get(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
	
	  //普通药品（单服务）
	   if(commonDrugList != null && commonDrugList.size()>0){
		  // FArrayList srvlist = new FArrayList();
			for(int i =0;i<commonDrugList.size();i++){
			 FArrayList srvlist = new FArrayList();
				CiOrTmplDTO  aggdto = new CiOrTmplDTO();
				OrTplNItmDO   orTplItem = (OrTplNItmDO)commonDrugList.get(i);
				//映射医嘱
				MappingFieldOrder(aggdto,orTplItem);
				//映射医嘱的项目
				//srvlist.
				srvlist.append(MappinfieldOrderSrv(aggdto,orTplItem));
				aggdto.setOrtmplsrvs(srvlist);
				tmpList.add(aggdto);
			}
	   }
	 
	   
	    //草药 注射类（多服务）
	  if(herbalDrugList != null && herbalDrugList.size() > 0){
		  CiOrTmplDTO  aggdto = new CiOrTmplDTO();
		  FArrayList srvlist = new FArrayList();
			for(int i =0;i<herbalDrugList.size();i++){
				OrTplNItmDO   orTplItem = (OrTplNItmDO)herbalDrugList.get(i);
				MappingFieldOrder(aggdto,orTplItem);
				srvlist.append(MappinfieldOrderSrv(aggdto,orTplItem));
			}
			aggdto.setOrtmplsrvs(srvlist);
			tmpList.add(aggdto);
	  }
		return tmpList.toArray(new CiOrTmplDTO[]{});
	}
	
	
	*//**
	 * 判断医嘱模板明细类型
	 * @param itemDO
	 *//*
	private  CiOrTmplDTO JudgeOrderTemplateType(OrTplNItmDO itemDO)throws BizException{
		     CiOrTmplDTO  orTplItem = null;
		     String sd_srvtp = itemDO.getSd_srvtp();
		     if(sd_srvtp != null && sd_srvtp.length()>1){
		    	
		    	 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){ //药品
		    		 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
		    		   ||sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) ){
		    		  //注射类药品  和草药
		    		 }else{
		    		  // 普通药品和其他药 
		    		 }
		    		 
		    		 
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){ //检查
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){ //检验
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){ //手术
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){ //治疗
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)){ //护理
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)){ //卫才
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){ //嘱托
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HEALTH)){ //健康
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SRVPKG)){ //治疗包
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN)){ //患者管理类 （转科出院死亡 等）
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_FIXFEE)){ //固定费用
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)){ //血液制品
		    		  
		    	  }else{
		    		  
		    	  }
		    	 }
		      return orTplItem;
		     }*/
	
	
	/**
	 * 医嘱 字段映射
	 * @param dto
	 * @param orTplItem
	 */
	/*private void MappingFieldOrder(CiOrTmplDTO dto,OrTplNItmDO  orTplItem)throws BizException{
		 
		OrTmplDO orTemplateDO =  CiOrdAppUtils.getIOrtmplMDORService().findById(orTplItem.getId_ortmpl());
		//dto.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板主键标识
		//dto.setOrtmplsrvs(orTplItem.getOrtmplsrvs());//医嘱模板项目列表
		dto.setEu_orsrcfromtp(CiOrSrcTypeEnum.BDORTMPL);//临床医嘱来源类型
		dto.setId_orsrc_m(orTplItem.getId_ortmpl());//来源ID_主
		dto.setId_orsrc_s(orTplItem.getId_ortmpl());//来源ID_子
		//dto.setId_orsrc_gs(orTplItem.getId_orsrc_gs());//来源ID_孙
		dto.setCode(orTplItem.getOrtplnitm_srv_code());//编码
		dto.setName(orTplItem.getOrtplnitm_srv_name());//名称
		dto.setId_srvtp(orTplItem.getId_srvtp());//医嘱类型
		dto.setSd_srvtp(orTplItem.getSd_srvtp());//医嘱类型编码
		dto.setEu_long(LongTempOrEnum.TEMPORARYOR);//长期临时类型
		dto.setId_freq(orTemplateDO.getId_freq());//医嘱频次
		dto.setId_route(orTemplateDO.getId_route());//用法
		dto.setId_routedes(orTemplateDO.getId_routedes());//用法要求
		dto.setId_boil(orTemplateDO.getId_boil());//煎法
		dto.setId_boildes(orTemplateDO.getId_boildes());//煎法要求
		//dto.setFg_boil(orTemplateDO.getfg);//代煎标识
		dto.setDays_or(orTemplateDO.getDays_or());//医嘱天数
		dto.setOrders(orTemplateDO.getOrders());//医嘱付数
		//dto.setTimes(orTemplateDO.getTimes());//医嘱次数
	   // dto.setDes_or(orTemplateDO.getDes_or());//医嘱描述
		dto.setId_srv(orTplItem.getId_srv());
		
	}
	*//**
	 * 映射医嘱的项目
	 * @param aggDTO
	 * @param orTplItem
	 *//*
	private CiOrTmplSrvDTO MappinfieldOrderSrv(CiOrTmplDTO ciOrtemplateDTO,OrTplNItmDO  orTplItem)throws BizException{
		 
		CiOrTmplSrvDTO srvDTO = new CiOrTmplSrvDTO();
		 MedSrvDO medSrvDO =  CiOrdAppUtils.getIMedsrvMDORService().findById(orTplItem.getId_srv());
		//srvDTO.setId_ciortmplsrv(orTplItem.getId_ciortmplsrv());//临床医嘱模板项目主键标识
		//srvDTO.setId_ciortmpl(orTplItem.getId_ciortmpl());//临床医嘱模板
		srvDTO.setSortno(orTplItem.getSortno());//序号
		srvDTO.setId_srv(orTplItem.getId_srv());//服务
		//srvDTO.setOrtplnitm_srv_name(orTplItem.getOrtplnitm_srv_name());
		//srvDTO.setFg_selfsrv(medSrvDO.getFg_selfsrv());//自定义服务标识
		//srvDTO.setName_selfsrv(medSrvDO.get);//自定义服务名
		srvDTO.setFg_set(medSrvDO.getFg_set());//套标识
		srvDTO.setId_srvtp(orTplItem.getId_srvtp());//服务类型
		srvDTO.setSd_srvtp(orTplItem.getSd_srvtp());//服务类型编码
		if(orTplItem.getId_freq() != null && orTplItem.getId_freq() !=""){
			srvDTO.setId_freq(orTplItem.getId_freq());//频次
		}else{
			srvDTO.setId_freq(medSrvDO.getId_freq());//频次
		}
		if(orTplItem.getId_route() != null && orTplItem.getId_route() !=""){
			srvDTO.setId_route(orTplItem.getId_route());//用法
		}else{
			srvDTO.setId_route(medSrvDO.getId_route());//用法
		}
		if(orTplItem.getId_route() != null && orTplItem.getId_route() !=""){
			srvDTO.setId_route(orTplItem.getId_route());//用法
		}else{
			srvDTO.setId_route(medSrvDO.getId_route());//用法
		}
		if(orTplItem.getId_route() != null && orTplItem.getId_route() != ""){
			srvDTO.setId_route(orTplItem.getId_route());//用法
		}else{
			srvDTO.setId_route(medSrvDO.getId_route());//用法
		}
		if(orTplItem.getId_routedes() != null && orTplItem.getId_routedes() !=""){
			srvDTO.setId_routedes(orTplItem.getId_routedes());//要求
		}else{
			srvDTO.setId_routedes(medSrvDO.getId_routedes());//要求
		}
		if(orTplItem.getId_routedes() != null && orTplItem.getId_routedes() !=""){
			srvDTO.setId_routedes(orTplItem.getId_routedes());//要求
		}else{
			srvDTO.setId_routedes(medSrvDO.getId_routedes());//要求
		}
		if(orTplItem.getId_boil() != null && orTplItem.getId_boil() !=""){
			srvDTO.setId_boil(orTplItem.getId_boil());//煎法
		}else{
			srvDTO.setId_boil(medSrvDO.getId_boil());//煎法
		}
		if(orTplItem.getId_boildes() != null && orTplItem.getId_boildes() !=""){
			srvDTO.setId_boildes(orTplItem.getId_boildes());//中医要求
		}else{
			srvDTO.setId_boildes(medSrvDO.getId_boildes());//中医要求
		}
		if(orTplItem.getId_unit_med() != null && orTplItem.getId_unit_med() !=""){
			srvDTO.setId_unit_med(orTplItem.getId_unit_med());//医学单位
		}else{
			srvDTO.setId_unit_med(medSrvDO.getId_unit_med());//医学单位
		}
		if(orTplItem.getQuan_med() != null ){
			srvDTO.setQuan_med(orTplItem.getQuan_med());//医学单位数值	
		}else{
			srvDTO.setQuan_med(medSrvDO.getQuan_med());//医学单位数值
		}
		//srvDTO.setQuan_total_medu(orTplItem.getQuan_total_medu());//服务总量
		srvDTO.setQuan_total_medu(orTplItem.getQuan_med());//todo
		srvDTO.setId_dep_mp(orTplItem.getId_dep_mp());//执行科室
		srvDTO.setId_mm(orTplItem.getId_mm());//关联物品
	
		//srvDTO.setSrvsetitms(orTplItem.getSrvsetitms());//套内项目集合
		return  srvDTO;
	}
	*/
	
	
	
	
}
