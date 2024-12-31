package iih.bd.fc.pub;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.mdwfconfig.i.IMdWfDORService;
import iih.bd.fc.mdwfor.i.IMdwforRService;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import iih.bd.srv.srvcate.i.ISrvcateMDORService;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.i.IDeptRService;

public class BdFcAppUtils {
	/**
	 * 获得系统环境变量
	 * MM
	 * @return
	 */
	public static Context getEnvContext(){
		return Context.get();
	}
	
	/***
	 * 获得服务器日期时间
	 * @return
	 */
	public static FDateTime getServerDateTime(){
		TimeService ts=(TimeService)ServiceFinder.find(TimeService.class.getName());
		return  ts.getUFDateTime();
	}
	
	/**
	 * 获得医嘱流向开立参数查询服务
	 * @return
	 */
	public static IMdwforRService getMdwforQryService(){
		return (IMdwforRService)ServiceFinder.find(IMdwforRService.class);
	}
	
	/**
	 * 获得部门查询服务
	 * @return
	 */
	public static IDeptRService getDeptQryService(){
		return (IDeptRService)ServiceFinder.find(IDeptRService.class);
	}
	
	/**
	 * 获得医嘱流向查询服务
	 * @return
	 */
	public static IMdWfDORService getMdWfQryService(){
		return (IMdWfDORService)ServiceFinder.find(IMdWfDORService.class);
	}
	/**
	 * 获得服务基本分类信息查询服务
	 * @return
	 */
	public static ISrvcateMDORService getBdSrvCaQryService(){
		return (ISrvcateMDORService)ServiceFinder.find(ISrvcateMDORService.class);
	}
	
	/**
	 * 根据就诊类型编码获得就诊类型主键值
	 * @param code_entp
	 * @return
	 */
	public static String getEntpId(String code_entp){
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp)){
			return IBdFcDictCodeConst.ID_CODE_ENTP_OP;
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp)){
			return IBdFcDictCodeConst.ID_CODE_ENTP_ET;
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp)){
			return IBdFcDictCodeConst.ID_CODE_ENTP_IP;
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp)){
			return IBdFcDictCodeConst.ID_CODE_ENTP_PE;
		}else if(IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp)){
			return IBdFcDictCodeConst.ID_CODE_ENTP_FA;
		}
		return "";
	}
	
	/**
	 * 根据就诊类型主键值获得就诊类型编码
	 * @param id_entp
	 * @return
	 */
	public static String getEntpCode(String id_entp){
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(id_entp)){
			return IBdFcDictCodeConst.SD_CODE_ENTP_OP;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_ET.equals(id_entp)){
			return IBdFcDictCodeConst.SD_CODE_ENTP_ET;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_IP.equals(id_entp)){
			return IBdFcDictCodeConst.SD_CODE_ENTP_IP;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_PE.equals(id_entp)){
			return IBdFcDictCodeConst.SD_CODE_ENTP_PE;
		}else if(IBdFcDictCodeConst.ID_CODE_ENTP_FA.equals(id_entp)){
			return IBdFcDictCodeConst.SD_CODE_ENTP_FA;
		}
		return "";
	}
	
	/**
	 * 获得医疗物品与仓库关系查询服务
	 * @return
	 */
	public static IWarehouseinfoRService getWarehouseinfoQryService(){
		return (IWarehouseinfoRService)ServiceFinder.find(IWarehouseinfoRService.class);
	}
}
