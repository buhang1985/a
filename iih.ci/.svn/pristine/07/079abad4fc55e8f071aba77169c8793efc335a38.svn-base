package iih.ci.diag.pub;

import iih.bl.hp.bdhpindicationdto.service.i.IHpQueService;
import iih.ci.ciet.cievent.i.ICieventCudService;
import iih.ci.diag.cidiag.i.ICiDiagItemDOCudService;
import iih.ci.diag.cidiag.i.ICidiagCudService;
import iih.ci.diag.cidiag.i.ICidiagMDOCudService;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.en.pv.entdi.i.IEntdiCudService;
import xap.mw.sf.core.util.ServiceFinder;

public class CiDiAppUtils {

	
	
	/**
	 * ci诊断 agg
	 * @return
	 */
	public static ICidiagCudService getICidiagCudService(){
		
		return  (ICidiagCudService)ServiceFinder.find(ICidiagCudService.class);
	}
	/**
	 * 诊断项目
	 * @return
	 */
	public  static ICiDiagItemDOCudService getICiDiagItemDOCudService(){
		return  (ICiDiagItemDOCudService)ServiceFinder.find(ICiDiagItemDOCudService.class);

	}
	/**
	 * ci诊断
	 * @return
	 */
	public static ICidiagMDOCudService getICidiagMDOCudService(){
		
		return  (ICidiagMDOCudService)ServiceFinder.find(ICidiagMDOCudService.class);
	}
	/**
	 * en 诊断
	 * @return
	 */
   public static IEntdiCudService getIEntdiCudService(){
		return  (IEntdiCudService)ServiceFinder.find(IEntdiCudService.class);
	}
  
   /**
    *事件
    * @return
    */
   public static ICieventCudService getICieventCudService(){
	   return (ICieventCudService)ServiceFinder.find(ICieventCudService.class);
   }
   
   /**
    *诊断医保的判断
    * @return
    */
   public static IHpQueService getIHpQueService(){
	   return (IHpQueService)ServiceFinder.find(IHpQueService.class);
   }
   
   /**
    * 医嘱的查询
    * @return
    */
   public static ICiOrdQryService getICiOrdQryService(){
	   return (ICiOrdQryService)ServiceFinder.find(ICiOrdQryService.class);
   }
   /**
    * 医嘱的更新
    * @return
    */
   public static ICiOrdMaintainService getICiOrdMaintainService(){
	   return (ICiOrdMaintainService)ServiceFinder.find(ICiOrdMaintainService.class);
   }
   /**
    * 诊断的 查询
    * @return
    */
   public static ICidiagQryService getICidiagQryService(){
	   return (ICidiagQryService)ServiceFinder.find(ICidiagQryService.class);
   }
}
