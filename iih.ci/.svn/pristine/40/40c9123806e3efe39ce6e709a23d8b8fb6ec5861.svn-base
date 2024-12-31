package iih.ci.diag.s;

import java.util.Map;

import iih.bd.pp.i.IBdHpQryService;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ci.ciet.cievent.i.ICieventCudService;
import iih.ci.diag.cidiag.i.ICiDiagItemDOCudService;
import iih.ci.diag.cidiag.i.ICiDiagItemDORService;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagMDORService;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.diag.i.ICidiagMaintainService;
import iih.ci.diag.s.bp.qry.getUdiDocListsMapQry;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 诊断领域共同信息
 * @author li_zheng
 *
 */
public class CiDiUtils {

	
	
	/**
	 * 数组对象为空
	 * 
	 * @param objs
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		return false;
	}
	
	
	/**
	 * 服务时间
	 * @return
	 */
	public static FDateTime getSystemDateTime(){
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();
		return dateTime;
		
	}
	/**
	 * 集团
	 * @return
	 */
	public static  String getGroupId(){
		return Context.get().getGroupId();
	}
	/**
	 * 组织
	 * @return
	 */
	public static  String getOrgId(){
		return Context.get().getOrgId();
	}
	/**
	 * 科室
	 * @return
	 */
	public static  String getDeptId(){
		return Context.get().getDeptId();
	}
	/**
	 * 用户
	 * @return
	 */
	public static  String getUserId(){
		return Context.get().getUserId();
	}
 
	
/*	curtime=CiOrdAppUtils.getServerDateTime();
	grpid=CiOrdAppUtils.getEnvContext().getGroupId();    //集团id
	orgid=CiOrdAppUtils.getEnvContext().getOrgId();    //组织id
	depid=CiOrdAppUtils.getEnvContext().getDeptId();    //科室id
	empid=CiOrdAppUtils.getEnvContext().getUserId();    //人员id
*/	
	/**
	 * 诊断信息
	 * @return 
	 */
	public static IDiagdefMDORService getIDiagdefMDORService(){
		return  ServiceFinder.find(IDiagdefMDORService.class);
		
	}
	
	
	/***
	 * 临床诊断字表
	 * @return
	 */
	public static ICiDiagItemDORService getICiDiagItemDORService(){
		 return ServiceFinder.find(ICiDiagItemDORService.class);
	}
	
	/**
	 * 临床诊断  主表
	 * @return
	 */
	public static ICidiagMDORService getICidiagMDORService(){
		return ServiceFinder.find(ICidiagMDORService.class);
	}
	
	/**
	 * 临床诊断  agg 
	 * @return
	 */
	public static ICidiagCudService getICidiagCudService(){
		return ServiceFinder.find(ICidiagCudService.class);
	}
	/**
	 * 临床诊断  agg 
	 * @return
	 */
	public static ICidiagRService getICidiagRService(){
		return ServiceFinder.find(ICidiagRService.class);
	}
	/**
	 * 诊断项目
	 * @return
	 */
    public static ICiDiagItemDOCudService getICiDiagItemDOCudService(){
    	return ServiceFinder.find(ICiDiagItemDOCudService.class);
    }
	/**
	 *  诊断
	 * @return
	 */
	public static ICidiagMaintainService getCidiagMaintainServiceImpl(){
		return ServiceFinder.find(ICidiagMaintainService.class);
	}
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiRService getIEntdiRService(){
		return ServiceFinder.find(IEntdiRService.class);
	}
	/**
	 * 就诊诊断
	 * @return
	 */
	public static IEntdiCudService getIEntdiCudService(){
		return ServiceFinder.find(IEntdiCudService.class);
	}
	/**
	 * 事件
	 * @return
	 */
    public static ICieventCudService getICieventCudService(){
    	return ServiceFinder.find(ICieventCudService.class);
    }
	
    /**
	 * 医保查询服务接口
	 * @return
	 */
    public static IBdHpQryService getBdHpQrySerice(){
    	return  ServiceFinder.find(IBdHpQryService.class);
 
    }
    /**
     * 新版医保平台接口
     * @return
     */
    public static IMiMcRuleService GetIMiMcRuleService(){
    	return ServiceFinder.find(IMiMcRuleService.class);
    }
}
