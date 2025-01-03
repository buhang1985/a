package iih.mi.mc.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mi.mc.dto.d.MiHpPatSpecDrugDTO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.mi.mc.mimcpatspecdrugalogquando.d.MiMcPatSpecDrugALogQuanDO;
import iih.mi.mc.mimcpatspecdrugalogquando.i.IMimcpatspecdrugalogquandoRService;
import iih.mi.mc.mimcpatspecdrugaquando.d.MiMcPatSpecDrugAQuanDO;
import iih.mi.mc.mimcpatspecdrugaquando.i.IMimcpatspecdrugaquandoRService;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.i.IMiMcSpecDrugDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * 医保特殊病药品增量维护查询药品
 * @author Administrator
 *
 */
public class MiHpPatSpecDrugQueryBP {
      public MiHpPatSpecDrugDTO[] exec(MiMcPatSpecDiDO mimcpatspecdido) throws BizException{
    	  //患者特殊病药品增量表服务
    	  if(StringUtil.isEmpty(mimcpatspecdido.getId_mimcpatspecdi())){
    		  return null;
    	  }

    	  IMimcpatspecdrugaquandoRService service = ServiceFinder.find(IMimcpatspecdrugaquandoRService.class);
    	  //初始化返回值集合
    	  List<MiHpPatSpecDrugDTO> listDto = new ArrayList<MiHpPatSpecDrugDTO>();
    	  //查询患者特殊病药品增量表 
    	  MiMcPatSpecDrugAQuanDO[] dos = service.find(" id_mimcpatspecdi ='"+mimcpatspecdido.getId_mimcpatspecdi()+"'", "", FBoolean.FALSE);
    	  if(!ArrayUtil.isEmptyNoNull(dos)){
    		  String[]  listIDMM = getListIDMM(dos);
    		  if(!ArrayUtil.isEmpty(listIDMM)){
    		  //获取原开立总量
    		  Map<String, FDouble> mmQuanMap = getMMQuan(listIDMM);
    		  //获取调整量  调整量显示成0 所以先不查询调整量
    		  Map<String, Integer> addQuanMap  =null;//getaddQuan(listIDMM);
    		  
    		  Map<String, MeasDocDO> meadocMap = getMeadocName(dos);
    		  if(mmQuanMap!=null||addQuanMap!=null){
                 //赋值
        		  for (MiMcPatSpecDrugAQuanDO miMcPatSpecDrugAQuanDO : dos) {
        			  MiHpPatSpecDrugDTO dto = new MiHpPatSpecDrugDTO();
        			  //主键
        			  dto.setId_mimcpatspecdrugaquan(miMcPatSpecDrugAQuanDO.getId_mimcpatspecdrugaquan());
        			  //物品id
        			  dto.setId_mm(miMcPatSpecDrugAQuanDO.getId_mm());
        			  //物品编码
        			  dto.setCode_mm(miMcPatSpecDrugAQuanDO.getCode());
        			  //物品名称
        			  dto.setName_mm(miMcPatSpecDrugAQuanDO.getName());
        			  //物品规格
        			  dto.setSpec(miMcPatSpecDrugAQuanDO.getSpec());
        			  //物品单位
        			  dto.setId_unit(miMcPatSpecDrugAQuanDO.getId_unit());
        			  if(meadocMap!=null&&miMcPatSpecDrugAQuanDO.getId_unit()!=null){
            			  //物品名称
            			  dto.setUnit(meadocMap.get(miMcPatSpecDrugAQuanDO.getId_unit()).getName());
        			  }
        			  //本月已增量
        			  dto.setAdd_quan(miMcPatSpecDrugAQuanDO.getAddquan());
        			  //原开立总量
        			  dto.setMonth_limit_quan(mmQuanMap.get(miMcPatSpecDrugAQuanDO.getId_mm()));
        			  //开始时间
        			  dto.setDt_b(miMcPatSpecDrugAQuanDO.getDt_b());
        			  //停止时间
        			  dto.setDt_e(miMcPatSpecDrugAQuanDO.getDt_e());
        			  if(addQuanMap!=null&&addQuanMap.get(miMcPatSpecDrugAQuanDO.getId_mm())!=null){
        				  dto.setCan_quan(addQuanMap.get(miMcPatSpecDrugAQuanDO.getId_mm()));
        			  }else {
        				  dto.setCan_quan(0);
        			  }
        			  listDto.add(dto);
        			  }
        		  
    		  }
    		  
    		  }
    	  }
    	  return listDto.toArray(new MiHpPatSpecDrugDTO[]{});
    	 
      }
      //获取id_mm 集合
      private String[] getListIDMM(MiMcPatSpecDrugAQuanDO[] dos) {
    	  List<String> idmms = new ArrayList<String>();
    	  for (MiMcPatSpecDrugAQuanDO MiMcPatSpecDrugAQuanDO : dos) {
    		  if(!StringUtil.isEmpty(MiMcPatSpecDrugAQuanDO.getId_mm())){

        		  idmms.add(MiMcPatSpecDrugAQuanDO.getId_mm());
    		  }
		  }
    	  return  idmms.toArray(new String[]{});
		
	}
	/**
       * 获取原开立总量
       * @return
     * @throws BizException 
       */
      private Map<String,FDouble> getMMQuan(String[] list) throws BizException{
    	
    	  Map<String,FDouble>  QuanMap = new HashMap<String,FDouble>();
    	  IMiMcSpecDrugDORService service = ServiceFinder.find(IMiMcSpecDrugDORService.class);
    	  //根据idmm查询 原开立总量
    	  MiMcSpecDrugDO[] miMcSpecDrugDOs = service.findByAttrValStrings(MiMcSpecDrugDO.ID_MM, list);
    	  if(!ArrayUtil.isEmptyNoNull(miMcSpecDrugDOs)){
    		  for (MiMcSpecDrugDO miMcSpecDrugDO : miMcSpecDrugDOs) {
    			  QuanMap.put(miMcSpecDrugDO.getId_mm(), miMcSpecDrugDO.getQuan_limit());
			}
    		return  QuanMap;
    	  }
		  return null;
	  }
      /**
       *  查询已增量
       * @param list
       * @return
       * @throws BizException
       */
      private Map<String,Integer> getaddQuan(String[] list) throws BizException{
    	  Map<String,Integer>  QuanMap = new HashMap<String,Integer>();
    	  
    	  IMimcpatspecdrugalogquandoRService service = ServiceFinder.find(IMimcpatspecdrugalogquandoRService.class);
    	  //根据idmm查询 原开立总量
    	  MiMcPatSpecDrugALogQuanDO[] miMcSpecDrugDOs = service.findByAttrValStrings(MiMcPatSpecDrugALogQuanDO.ID_MM, list);
    	  if(!ArrayUtil.isEmptyNoNull(miMcSpecDrugDOs)){
    		  for (MiMcPatSpecDrugALogQuanDO miMcSpecDrugDO : miMcSpecDrugDOs) {
    			  Integer quan;
    			  if(QuanMap.containsKey(miMcSpecDrugDO.getId_mm())){
    				  quan=miMcSpecDrugDO.getAddquan()+QuanMap.get(miMcSpecDrugDO.getId_mm());
    			  }else{
    				  quan=miMcSpecDrugDO.getAddquan();
    			  }
    			  QuanMap.put(miMcSpecDrugDO.getId_mm(), quan);
			}
    		return  QuanMap;
    	  }
		  return null;
	  }
      /**
  	 * 获取计量单位字典
  	 * 
  	 * @return
  	 * @throws BizException
  	 */
  	private Map<String, MeasDocDO> getMeadocName( MiMcPatSpecDrugAQuanDO[] dos) throws BizException {
  		List<String> listmeas = new ArrayList<String>();
  		//获取计量单位id集合
  		for (MiMcPatSpecDrugAQuanDO durgDo : dos) {
  			listmeas.add(durgDo.getId_unit());
  		}
  		Map<String,MeasDocDO>  measMap =new HashMap<String,MeasDocDO>();
  		//调用基础服务查询 
  		IMeasdocRService service = ServiceFinder.find(IMeasdocRService.class);
  		MeasDocDO[] measDocDOs = service.findByIds(listmeas.toArray(new String[]{}), FBoolean.FALSE);
  		if (measDocDOs != null && measDocDOs.length > 0) {
  			for (MeasDocDO measDocDO : measDocDOs) {
  				if (measMap.get(measDocDO.getId_measdoc()) == null) {
  					measMap.put(measDocDO.getId_measdoc(), measDocDO);
  				}
  			}
  		}
  		return measMap;
  	}
      
}
