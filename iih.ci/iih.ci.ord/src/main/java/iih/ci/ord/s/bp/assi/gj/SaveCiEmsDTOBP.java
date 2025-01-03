/**
 * 
 */
package iih.ci.ord.s.bp.assi.gj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidate;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidateFactory;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: SaveCiEmsDTOBP
 * @Description: 多医嘱的保存
 * @author Comsys-li_zheng
 * @date 2016年9月13日 下午7:41:47
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class SaveCiEmsDTOBP {
	
	public static MoreEmsParamDTO SaveCiEmsDTO(CiEnContextDTO envinfo,CiEmsDTO[] ciEms)throws BizException{
		long startTime = System.currentTimeMillis();
		CovertTmplToMoreEmsParamBP covertTmplToMoreEmsParamBP = new  CovertTmplToMoreEmsParamBP();
		MoreEmsParamDTO param = new MoreEmsParamDTO();
		 //保存医嘱
		 FMap2  Errormap2 = new FMap2();
		 // 保存成功的医嘱
		 FArrayList2 orderList = new FArrayList2();
		 String Errorinfo = "";
		 int num = 1;
		 List<String> errorList= new ArrayList<String>();
		 //校验服务是否开立
		 covertTmplToMoreEmsParamBP.validateCiEmsDTO(envinfo, ciEms);
		 if(ciEms != null && ciEms.length >0){
			 ICiOrdMaintainService orderMainService = ServiceFinder.find(ICiOrdMaintainService.class); 
		     for(CiEmsDTO EmsDTO: ciEms){
		    	 try{
		    		 
		    		 CiEmsValidate bp = CiEmsValidateFactory.getInstance(EmsDTO.getCode_entp());
		    		 CiTmplValidateRstDTO validateRst = bp.exec(EmsDTO,errorList);
		    		 if(validateRst==null || CiTmplValidateRstDTO.INFO.compareTo(validateRst.getLevel()) == 0){
//		    			 CiOrderDO ciOrder = orderMainService.SaveCiEmsDTO(EmsDTO,envinfo);
		    			 
		    			 EmsRstDTO rst = orderMainService.SaveCiEmsDTO_new(EmsDTO,envinfo);
		    			 CiOrderDO ciOrder=(CiOrderDO)rst.getDocument().get(0);
		    			 orderList.add(ciOrder);
		    			 FMap2 emsExtMap = rst.getExtension();
		    			 if(emsExtMap.containsKey("RelSrvMessageList")) {
		    				 String msg = (String)emsExtMap.get("RelSrvMessageList");
		    				 String promptmsg=param.getPrompt_msg();
		    				 String prompt=promptmsg==null?"\r\n"+ciOrder.getName_or()+":"+msg:promptmsg+" \r\n "+ciOrder.getName_or()+":"+msg;;
		    				 param.setPrompt_msg(prompt);
		    			 }
		    		 }else if(CiTmplValidateRstDTO.WARN.compareTo(validateRst.getLevel())==0){
		    			 Errormap2.put(num+EmsDTO.getName()+ new Date().getTime(), EmsDTO); // !!!暂时添加
		    		      num ++;
		    		 }else if(CiTmplValidateRstDTO.ERROR.compareTo(validateRst.getLevel())>=0){
		    			 //错误级别，不能保存，也不能在医疗单打开
		    		 }
		    	 }catch(Exception e){
		    		// 校验通过，则可以保存，保存不成功，或者保存存在异常，将其添加到错误队列中
		    		 num ++;
		    		 e.getMessage();
		    		 e.printStackTrace();
		    		 Errorinfo += e.getMessage();
		    		 Errormap2.put(num+e.getMessage(), EmsDTO); // 注意这行代码有错误：当两个医疗单发生相同的错误时候，最后一个发生错误的医疗单得到保存，前者会被覆盖
		    		 continue;
		    	 }
		    	 finally
		    	 {
		    		 //Errormap2.put(EmsDTO.getName() + new Date().toString(), EmsDTO); // !!!暂时添加
		    	 }
		     }
		 }
		 //医嘱列表
		  FMap2  Ordermap2 = new FMap2();
		  /*String whereStr =" id_en ='"+envinfo.getId_en()+"'";
		  CiOrderDO[] orders = CiOrdAppUtils.getOrQryService().find(whereStr, "id_en", FBoolean.FALSE);		  
		  orderList.addAll(Arrays.asList(orders));*/
		  Ordermap2.put("orders", orderList);		  
		  param.setOrdermap2(Ordermap2);
		  //错误信息
		  param.setErrormap2(Errormap2);
		  if(errorList.size()>0){
			  for(String info : errorList){
				  if(!StringUtils.isEmpty(Errorinfo)){
					  Errorinfo+="\r\n";
				  }
				  if(!Errorinfo.contains(info)) {
					  Errorinfo += info;
				  }
			  }
		  }
		  param.setErrorinfo(Errorinfo);
		 //返回 成功的和本次就诊的医嘱和错误的信息
		  
		  long endTien = System.currentTimeMillis();
		  String logStr = "SaveCiEmsDTOBP.SaveCiEmsDTO 模板保存方法 保存医嘱数 ："+ciEms.length+"条;耗时："+(endTien-startTime);
		  if(Errormap2.size() != 0){
			  logStr += "；保存失败原因："+JSONObject.toJSONString(Errormap2);
		  }
		  OrdBizLogger.info(envinfo, logStr);
		return param;
	}

}
