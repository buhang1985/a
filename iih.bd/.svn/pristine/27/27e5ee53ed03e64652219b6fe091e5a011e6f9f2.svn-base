package iih.bd.srv.s.bp;


import iih.bd.fc.i.IBdFcQryService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.mmrelskinsrv.i.IMmrelskinsrvRService;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.pp.priusg.i.IPriusgRService;
import iih.bd.srv.deptsrvlimit.i.IDeptsrvlimitRService;
import iih.bd.srv.ems.i.IEmsRelSrvDORService;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import iih.bd.srv.i.IBdSrvMaintainService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import iih.bd.srv.medsrv.i.IMedSrvRelMmDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.ortpl.i.IRegularorcaRService;
import iih.bd.srv.ortpl.i.IRegularorrelsrvRService;
import iih.bd.srv.ortpl.i.ISrvortplitemCudService;
import iih.bd.srv.ortpl.i.ISrvortplitemRService;
import iih.bl.cg.service.IBlcgqueryService;
import iih.ci.ciet.cievent.i.ICieventCudService;
import iih.ci.ciet.cievent.i.ICieventRService;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.ord.cior.i.ICiorappbtCudService;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.cior.i.ICiorappbuCudService;
import iih.ci.ord.cior.i.ICiorappbuRService;
import iih.ci.ord.cior.i.ICiorappconsultCudService;
import iih.ci.ord.cior.i.ICiorappconsultRService;
import iih.ci.ord.cior.i.ICiorapplisCudService;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.cior.i.ICiorappouthospCudService;
import iih.ci.ord.cior.i.ICiorappouthospRService;
import iih.ci.ord.cior.i.ICiorapppathgyCudService;
import iih.ci.ord.cior.i.ICiorapppathgyRService;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.ci.ord.cior.i.ICiorappsurgeryCudService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.cior.i.ICiorapptransdeptCudService;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.cior.i.ICiorreactlogCudService;
import iih.ci.ord.cior.i.ICiorreactlogRService;
import iih.ci.ord.cior.i.ICiorsessionCudService;
import iih.ci.ord.cior.i.ICiorsessionRService;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.cirptlab.i.ICirptlabRService;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseCudService;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetCudService;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;
import iih.ci.ord.skintest.i.ISkintestCudService;
import iih.ci.ord.skintest.i.ISkintestRService;
import iih.en.pv.entdi.i.IEntdiCudService;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mp.dg.i.IMpDgOutService;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import iih.pi.overview.overview.i.IPiPatAlDOCudService;
import iih.pi.overview.overview.i.IPiPatAlDORService;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.devcfg.func.i.IPageRService;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.permfw.user.i.IUserRService;

public class BdAppUtils {
	
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
	 * 获得医嘱项目服务
	 * @return
	 */
	public static IOrdSrvDORService getOrSrvQryService(){
		return (IOrdSrvDORService)ServiceFinder.find(IOrdSrvDORService.class);
	}
	/**
	 * 获得医嘱服务
	 * @return
	 */
	public static ICiorderMDORService getOrQryService(){
		return (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
	}
	
	/**
	 * 获得医嘱维护服务
	 * @return
	 */
	public static ICiorderMDOCudService getOrService(){
		return (ICiorderMDOCudService)ServiceFinder.find(ICiorderMDOCudService.class);
	}
	
	/**
	 * 获得医嘱聚集维护服务
	 * @return
	 */
	public static ICiorderCudService getOrAggService(){
		return (ICiorderCudService)ServiceFinder.find(ICiorderCudService.class);
	}
	
	/**
	 * 获得医嘱聚集服务
	 * @return
	 */
	public static ICiorderRService getOrAggQryService(){
		return (ICiorderRService)ServiceFinder.find(ICiorderRService.class);
	}
	

	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IOrdsrvmmRService getOrSrvMmQryService(){
		return (IOrdsrvmmRService)ServiceFinder.find(IOrdsrvmmRService.class);
	}
	
	/**
	 * 获得编码字段生成管理器
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManager(){
		return (IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
	}
	
	/**
	 * 获得用户服务
	 * @return
	 */
	public static IUserRService getUserQryService(){
		return (IUserRService)ServiceFinder.find(IUserRService.class);
	}
	
	/**
	 * 获得部门服务
	 * @return
	 */
	public static IDeptRService getDeptQryService(){
		return (IDeptRService)ServiceFinder.find(IDeptRService.class);
	}
	
	/**
	 * 获得人员服务
	 * @return
	 */
	public static IPsndocMDORService getPsnDocQryService(){
		return (IPsndocMDORService)ServiceFinder.find(IPsndocMDORService.class);
	}
	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMeterialMDORService getMaterialQryService(){
		return (IMeterialMDORService)ServiceFinder.find(IMeterialMDORService.class);
	}
	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMaterialService getMaterialService(){
		return (IMaterialService)ServiceFinder.find(IMaterialService.class);
	}
	
	/**
	 * 获得物品结存及价格相关信息服务
	 * @return
	 */
	public static IMaterialStockService getMaterialStockQryService(){
		return (IMaterialStockService)ServiceFinder.find(IMaterialStockService.class);
	}
	
	
	/**
	 * 获得物品基本信息服务
	 * @return
	 */
	public static IMaterialBaseInfoService getMaterialBaseInfoyService(){
		return (IMaterialBaseInfoService)ServiceFinder.find(IMaterialBaseInfoService.class);
	}

	
	/**
	 * 获得医嘱项目物品服务
	 * @return
	 */
	public static IMmrelskinsrvRService getMmRelSkinQryService(){
		return (IMmrelskinsrvRService)ServiceFinder.find(IMmrelskinsrvRService.class);
	}
	
	/**
	 * 获得皮试结果服务
	 */
	public static ISkintestRService getCiskintestrstQryService(){
		return (ISkintestRService)ServiceFinder.find(ISkintestRService.class);
	}
	
	/**
	 * 获得皮试结果维护服务
	 */
	public static ISkintestCudService getCiskintestrstService(){
		return (ISkintestCudService)ServiceFinder.find(ISkintestCudService.class);
	}
	
	/**
	 * 获得临床事件维护服务
	 */
	public static ICieventCudService getCieventService(){
		return (ICieventCudService)ServiceFinder.find(ICieventCudService.class);
	}
	
	/**
	 * 获得临床事件查询服务
	 */
	public static ICieventRService getCieventQryService(){
		return (ICieventRService)ServiceFinder.find(ICieventRService.class);
	}

	/**
	 * 获得用法下费用对照查询服务
	 */
	public static IPriusgRService getPriusgRService(){
		return (IPriusgRService)ServiceFinder.find(IPriusgRService.class);
	}
	
	/**
	 * 获得患者就诊信息查询服务
	 */
	public static IEnOutQryService getEnOutQryService(){
		return (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class);
	}
	
	/**
	 * 获得服务套套内项目信息查询服务
	 */
	public static IMedSrvSetItemDORService getMedSrvSetItemRService(){
		return (IMedSrvSetItemDORService)ServiceFinder.find(IMedSrvSetItemDORService.class);
	}
	
	/**
	 * 获得服务项目信息查询服务
	 */
	public static IMedsrvMDORService getMedsrvMDORService(){
		return (IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class);
	}
	
	/**
	 * 获得服务项目信息查询服务
	 */
	public static IMedsrvRService getMedsrvRService(){
		return (IMedsrvRService)ServiceFinder.find(IMedsrvRService.class);
	}
	
	/**
	 * 获得医疗服务关联的查询服务
	 */
	public static IMedSrvRelMmDORService getMedsrvRelMmQryService(){
		return (IMedSrvRelMmDORService)ServiceFinder.find(IMedSrvRelMmDORService.class);
	}
	
	
	
	/**
	 * 获得医嘱服务查询
	 */
	public static ICiorderMDORService getCiorderMDORService(){
		return (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
	}
	
 
	/**
	 * 获得检验的查询服务 agg
	 */
	public static ICirptlabRService getCirptlabRService(){
		return (ICirptlabRService)ServiceFinder.find(ICirptlabRService.class);
	}
	
	/**
	 * 获得计价模式价格计算服务
	 */
	public static IPriCalService getPriCalService(){
		return (IPriCalService)ServiceFinder.find(IPriCalService.class);
	}
	
	
	/**
	 * 获得频次查询服务
	 */
	public static IFreqdefMDORService getFreqdefMDORService(){
		return (IFreqdefMDORService)ServiceFinder.find(IFreqdefMDORService.class);
	}
	
	/**
	 * 获得临床医嘱项目对应物品服务
	 */
	public static IOrdsrvmmCudService getOrsrvmmService(){
		return (IOrdsrvmmCudService)ServiceFinder.find(IOrdsrvmmCudService.class);
	}
	
	/**
	 * 获得临床医嘱项目变动剂量服务
	 */
	public static IOrdsrvdoseCudService getOrsrvdoseService(){
		return (IOrdsrvdoseCudService)ServiceFinder.find(IOrdsrvdoseCudService.class);
	}
	
	/**
	 * 获得临床医嘱项目变动剂量查询服务
	 */
	public static IOrdsrvdoseRService getOrsrvdoseQryService(){
		return (IOrdsrvdoseRService)ServiceFinder.find(IOrdsrvdoseRService.class);
	}
	
	/**
	 * 获得临床医嘱或项目套内项目服务
	 */
	public static IOrdsrvsetCudService getOrsrvsetService(){
		return (IOrdsrvsetCudService)ServiceFinder.find(IOrdsrvsetCudService.class);
	}
	
	/**
	 * 获得临床医嘱或项目套内项目查询服务
	 */
	public static IOrdsrvsetRService getOrsrvsetQryService(){
		return (IOrdsrvsetRService)ServiceFinder.find(IOrdsrvsetRService.class);
	}
	
	/**
	 * 获得会诊申请维护服务
	 */
	public static ICiorappconsultCudService getOrappconsultService(){
		return (ICiorappconsultCudService)ServiceFinder.find(ICiorappconsultCudService.class);
	}
	
	/**
	 * 获得会诊申请查询服务
	 */
	public static ICiorappconsultRService getOrappconsultQryService(){
		return (ICiorappconsultRService)ServiceFinder.find(ICiorappconsultRService.class);
	}
	
	/**
	 * 获得手术申请维护服务
	 */
	public static ICiorappsurgeryCudService getOrappsurgerytService(){
		return (ICiorappsurgeryCudService)ServiceFinder.find(ICiorappsurgeryCudService.class);
	}
	
	/**
	 * 获得手术申请维护服务
	 */
	public static ICiorappsurgeryRService getOrappsurgeryQrytService(){
		return (ICiorappsurgeryRService)ServiceFinder.find(ICiorappsurgeryRService.class);
	}
	
	/**
	 * 获得病理申请维护服务
	 */
	public static ICiorapppathgyCudService getOrapppathgyService(){
		return (ICiorapppathgyCudService)ServiceFinder.find(ICiorapppathgyCudService.class);
	}
	
	/**
	 * 获得病理申请查询服务
	 */
	public static ICiorapppathgyRService getOrapppathgyQryService(){
		return (ICiorapppathgyRService)ServiceFinder.find(ICiorapppathgyRService.class);
	}
	
	/**
	 * 获得备血申请维护服务
	 */
	public static ICiorappbtCudService getOrappbtService(){
		return (ICiorappbtCudService)ServiceFinder.find(ICiorappbtCudService.class);
	}
	
	/**
	 * 获得备血申请查询服务
	 */
	public static ICiorappbtRService getOrappbtQryService(){
		return (ICiorappbtRService)ServiceFinder.find(ICiorappbtRService.class);
	}
	
	/**
	 * 获得用血申请维护服务
	 */
	public static ICiorappbuCudService getOrappbuService(){
		return (ICiorappbuCudService)ServiceFinder.find(ICiorappbuCudService.class);
	}
	
	/**
	 * 获得用血申请查询服务
	 */
	public static ICiorappbuRService getOrappbuQryService(){
		return (ICiorappbuRService)ServiceFinder.find(ICiorappbuRService.class);
	}

	/**
	 * 获得检验申请维护服务
	 */
	public static ICiorapplisCudService getOrapplisService(){
		return (ICiorapplisCudService)ServiceFinder.find(ICiorapplisCudService.class);
	}
	
	/**
	 * 获得检验申请查询服务
	 */
	public static ICiorapplisRService getOrapplisQryService(){
		return (ICiorapplisRService)ServiceFinder.find(ICiorapplisRService.class);
	}
	
	/**
	 * 获得出院申请维护服务
	 */
	public static ICiorappouthospCudService getOrappoutService(){
		return (ICiorappouthospCudService)ServiceFinder.find(ICiorappouthospCudService.class);
	}
	
	/**
	 * 获得出院申请查询服务
	 */
	public static ICiorappouthospRService getOrappoutQryService(){
		return (ICiorappouthospRService)ServiceFinder.find(ICiorappouthospRService.class);
	}	
	
	/**
	 * 获得检查申请维护服务
	 */
	public static ICiorapprisCudService getOrapprisService(){
		return (ICiorapprisCudService)ServiceFinder.find(ICiorapprisCudService.class);
	}
	
	/**
	 * 获得检查申请查询服务
	 */
	public static ICiorapprisRService getOrapprisQryService(){
		return (ICiorapprisRService)ServiceFinder.find(ICiorapprisRService.class);
	}
	
	/**
	 * 获得转科申请维护服务
	 */
	public static ICiorapptransdeptCudService getOrapptransdepService(){
		return (ICiorapptransdeptCudService)ServiceFinder.find(ICiorapptransdeptCudService.class);
	}
	
	/**
	 * 获得转科申请查询服务
	 */
	public static ICiorapptransdeptRService getOrapptransdepQryService(){
		return (ICiorapptransdeptRService)ServiceFinder.find(ICiorapptransdeptRService.class);
	}
	
	/**
	 * 获得转科申请查询服务
	 */
	public static IBdFcQryService getBdFcQryQryService(){
		return (IBdFcQryService)ServiceFinder.find(IBdFcQryService.class);
	}
	
	/**
	 * 获得医疗服务查询服务
	 */
	public static IBdSrvQryService getBdSrvQryQryService(){
		return (IBdSrvQryService)ServiceFinder.find(IBdSrvQryService.class);
	}
	/**
	 * 获得医疗服务维护通用服务
	 */
	public static IBdSrvMaintainService getBdSrvMaintainService(){
		return (IBdSrvMaintainService)ServiceFinder.find(IBdSrvMaintainService.class);
	}
	
	/**
	 * 获得医嘱互斥记录查询服务
	 */
	public static ICiorreactlogRService getOrreactlogQryService(){
		return (ICiorreactlogRService)ServiceFinder.find(ICiorreactlogRService.class);
	}
	
	/**
	 * 获得医嘱互斥记录维护服务
	 */
	public static ICiorreactlogCudService getOrreactlogService(){
		return (ICiorreactlogCudService)ServiceFinder.find(ICiorreactlogCudService.class);
	}
	 
	/**
	 * 获得医嘱门诊开立区间维护服务
	 */
	public static ICiorsessionCudService getCiorsessionService(){
		return (ICiorsessionCudService)ServiceFinder.find(ICiorsessionCudService.class);
	}	

	/**
	 * 获得医嘱门诊开立区间查询服务
	 */
	public static ICiorsessionRService getCiorsessionQryService(){
		return (ICiorsessionRService)ServiceFinder.find(ICiorsessionRService.class);
	}
	
	/**
	 * 获得部门服务限制查询服务
	 */
	public static IDeptsrvlimitRService getDeptSrvLimitQryService(){
		return (IDeptsrvlimitRService)ServiceFinder.find(IDeptsrvlimitRService.class);
	}
	 
	/**
	 * 获得医嘱处方查询服务
	 */
	public static IPresRService getCiPresQryService(){
		return (IPresRService)ServiceFinder.find(IPresRService.class);
	}
	 
	/**
	 * 获得医嘱处方维护服务
	 */
	public static IPresCudService getCiPresService(){
		return (IPresCudService)ServiceFinder.find(IPresCudService.class);
	}
	 
	/**
	 * 获得医嘱服务维护服务
	 */
	public static IOrdSrvDOCudService getOrSrvService(){
		return (IOrdSrvDOCudService)ServiceFinder.find(IOrdSrvDOCudService.class);
	}
	
	/**
	 * 获得药品执行相关服务
	 */
	public static IMpDgOutService getMpDrugOutService(){
		return (IMpDgOutService)ServiceFinder.find(IMpDgOutService.class);
	}
	
	/**
	 * 单据编码管理服务，包括申请单据号，回退单据号等
	 * @return
	 */
	public static IBillcodeManage getIBillcodeManage(){
		return 	 (IBillcodeManage)ServiceFinder.find(IBillcodeManage.class);
	}
	/**
	 * 病历的信息（门诊 住院使用）
	 * @return
	 */
	public static IMrServiceExt getIMrServiceExt(){
		return 	 (IMrServiceExt)ServiceFinder.find(IMrServiceExt.class);
	}            
	/**
	 * 生命体征信息
	 * @return
	 */
	public static IForeignService getIForeignService(){
		 return (IForeignService)ServiceFinder.find(IForeignService.class);
	}
	
	/**
	 * 总览取得费用数据
	 * @return
	 */
	public static IBlcgqueryService getIBlcgqueryService(){
		return (IBlcgqueryService)ServiceFinder.find(IBlcgqueryService.class);
	}
	/**
	 * 获得患者过敏史查询服务
	 * @return
	 */
	public static IPiPatAlDORService getIPiPatAlDORService(){
		return  (IPiPatAlDORService)ServiceFinder.find(IPiPatAlDORService.class);
	}
	/**
	 * 获得患者过敏史维护服务
	 * @return
	 */
	public static IPiPatAlDOCudService getIPiPatAlDOService(){
		return  (IPiPatAlDOCudService)ServiceFinder.find(IPiPatAlDOCudService.class);
	}
	/**
	 * 就诊Service 
	 * @return
	 */
	public static IEnOutQryService getIEQryService(){
		return  ServiceFinder.find(IEnOutQryService.class);
	}
	/**
	 * 医嘱助手列表集合(患者既往)
	 * @return
	 */
	public static IPageRService getIPageRService(){
		return ServiceFinder.find(IPageRService.class);	
	}
	/**
	 * 医嘱助手常用模板分类
	 * @return
	 */
	public static IRegularorcaRService getIRegularorcaRService(){
		return ServiceFinder.find(IRegularorcaRService.class);
	}
	/**
	 * 医嘱助手常用模板项目
	 * @return
	 */
	 public static IRegularorrelsrvRService getIRegularorrelsrvRService(){
		 return ServiceFinder.find(IRegularorrelsrvRService.class);
	 }
	 
	 /**
	  * 医嘱助手模板AggDO
	  * @return
	  */
	 public static ISrvortplitemRService getISrvortplitemRService(){
		 return ServiceFinder.find(ISrvortplitemRService.class);
	 }
	 
	 /**
	  * 医嘱模板项目
	  * @return
	  */
	 public static ISrvortplitemCudService getISrvortplitemCudService(){
		 return ServiceFinder.find(ISrvortplitemCudService.class);
	 }
	 /**
	  * 医疗服务药品属性
	  * @return
	  */
	  public  static IMedSrvDrugDORService getIMedSrvDrugDORService(){
		  return ServiceFinder.find(IMedSrvDrugDORService.class);
	  }
	  
	/**
	 * 获得医疗单关联服务数据信息查询服务
	 * @return
	 */
	public static IEmsRelSrvDORService getEmsRelSrvQryService(){
		return (IEmsRelSrvDORService)ServiceFinder.find(IEmsRelSrvDORService.class);
	}	
	
	/**
	 * 获得患者就诊信息查询服务
	 * @return
	 */
	public static IPativisitRService getPativisitQryService(){
		return (IPativisitRService)ServiceFinder.find(IPativisitRService.class);
	}
	/**
	 * 基础数据医疗服务（bd_srv）
	 * @return
	 */
	public static IMedsrvMDORService getIMedsrvMDORService(){
		return (IMedsrvMDORService)ServiceFinder.find(IMedsrvMDORService.class);
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
	 * 会诊agg  
	 * @return
	 */
	public static ICiorappconsultCudService getICiorappconsultCudService(){
		return ServiceFinder.find(ICiorappconsultCudService.class);
	}
	/**
	 * 医嘱停止和作废调用执行接口
	 * @return
	 */
	public static IResponseOrderHandelService getIResponseOrderHandelService(){
		return ServiceFinder.find(IResponseOrderHandelService.class);
	}
	public static IMedSrvSetItemDORService getIMedSrvSetItemDOCrudService(){
		return ServiceFinder.find(IMedSrvSetItemDORService.class);
	}
}
