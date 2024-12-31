package iih.ci.diag.s.ip.bp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.util.StringUtils;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.pub.CiDiagConstant;
import iih.ci.diag.pub.CommonUtil;
import iih.ci.diag.s.CiDiUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * @author li_zheng
 *
 */
public class getCiDiagSelectedTypeBP {
	  /**
     * 新怎诊断下拉要选择的诊断类型
     * @param id_ent
     * @param id_org
     * @return
     */
    public   String getCiDiagSelectedType(String id_ent,String id_org)throws BizException{
    	String strWhere = "";
    	//参数值：01不管控,02严格管控
    	String controlMode = CommonUtil.getIpDiControlMode(id_org);
    	if(CiDiagConstant.sys_IpDiControlMode_02.equals(controlMode)){
    	 	String QrywhereStr =" fg_cancel !='Y' and  fg_sign ='Y' and id_en ='"+id_ent+"'";
        	CiDiagDO[] cidiag =CiDiUtils.getICidiagMDORService().find(QrywhereStr, "Dt_sign", FBoolean.FALSE);
        	return getQryCiDiagType(cidiag);
    	}else {
    	    return strWhere= " bd_udidoc.id_udidoclist ='"+ICiDictCodeConst.ID_process_udidoclist+"' and bd_udidoc.code !='"+ICiDictCodeConst.SD_OPDI+"'";	
    	}
   
    }
    
    /**
     * 严格控制下诊断类型
     * @param cidiag
     * @return
     */
    private String getQryCiDiagType(CiDiagDO[] cidiag){
    	String strWhere =  " bd_udidoc.id_udidoclist ='"+ICiDictCodeConst.ID_process_udidoclist+"' and bd_udidoc.code !='"+ICiDictCodeConst.SD_OPDI+"'";
    	if(cidiag== null || cidiag.length==0){
    		strWhere= String.format(" bd_udidoc.code in ('%s','%s')", ICiDictCodeConst.SD_FIRST,ICiDictCodeConst.SD_INHOSPITAL);
    	}
    	Map map =  getCiDiagType(cidiag);
    	if(!StringUtils.isEmpty(map)){
    		if(map.get(ICiDictCodeConst.SD_INHOSPITAL) != null && map.get(ICiDictCodeConst.SD_FIRST)== null)
    		{
    			strWhere= String.format(" bd_udidoc.code in ('%s','%s','%s','%s')", ICiDictCodeConst.SD_AMEND,ICiDictCodeConst.SD_SUPPLY,
    					ICiDictCodeConst.SD_OUTHOSPITAL,ICiDictCodeConst.SD_DIE);
    		}else if(map.get(ICiDictCodeConst.SD_FIRST) != null && map.get(ICiDictCodeConst.SD_INHOSPITAL)== null
    				&& map.get(ICiDictCodeConst.SD_SUPPLY)== null
    				&& map.get(ICiDictCodeConst.SD_AMEND)== null
    				&& map.get(ICiDictCodeConst.SD_OUTHOSPITAL)== null
    				&& map.get(ICiDictCodeConst.SD_DIE)== null)
    		{
    			strWhere= String.format(" bd_udidoc.code in ('%s')", ICiDictCodeConst.SD_INHOSPITAL);
    		}else if(map.get(ICiDictCodeConst.SD_INHOSPITAL) != null && map.get(ICiDictCodeConst.SD_FIRST) != null){
    			strWhere= String.format(" bd_udidoc.code in ('%s','%s','%s','%s')", ICiDictCodeConst.SD_AMEND,ICiDictCodeConst.SD_SUPPLY,	
    					ICiDictCodeConst.SD_OUTHOSPITAL,ICiDictCodeConst.SD_DIE);
    		}
    	}
    	return strWhere;
    }
    
    /**
     * 签署的诊断类型
     * @param cidiag
     * @return
     */
    private Map getCiDiagType(CiDiagDO[] cidiag){
    	Map map = new HashMap();
    	for(CiDiagDO cidiagDO:cidiag){
    		if(ICiDictCodeConst.SD_FIRST.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_FIRST, cidiagDO);
    		 }
    		
    		if(ICiDictCodeConst.SD_INHOSPITAL.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_INHOSPITAL, cidiagDO);
    		 }
    		
    		if(ICiDictCodeConst.SD_SUPPLY.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_SUPPLY, cidiagDO);
    		 }
    		
    		if(ICiDictCodeConst.SD_AMEND.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_AMEND, cidiagDO);
    		 }
    		
    		if(ICiDictCodeConst.SD_OUTHOSPITAL.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_OUTHOSPITAL, cidiagDO);
    		 }
    		
    		if(ICiDictCodeConst.SD_DIE.equals(cidiagDO.getSd_ditp())){
    			map.put(ICiDictCodeConst.SD_DIE, cidiagDO);
    		 }
    		
    	}
    	return map;
    }
}
