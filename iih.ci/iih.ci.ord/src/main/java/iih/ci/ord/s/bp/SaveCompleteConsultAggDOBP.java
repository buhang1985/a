/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.cg.blcgoep.d.FeeOriginEnum;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.dto.cglogic.d.BlCgAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgAccountSetDTO;
import iih.bl.cg.i.IBlCgAccountService;
import iih.bl.comm.IBlCgFuncConst;
import iih.ci.event.ord.utils.IOrdEventSources;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.cior.i.ICiorappconsultMDOCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.sdk.utils.ObjectUtils;
import iih.mp.nr.dto.internal.d.ExecuteTpEnum;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.foreign.i.IForeignService;
import iih.mp.nr.i.IMporInternalService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: SaveCompleteConsultAggDOBP
 * @Description: 完成会诊信息
 * @author Comsys-li_zheng
 * @date 2016年6月21日 下午3:30:28
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class SaveCompleteConsultAggDOBP {

	
	public  CiorappconsultAggDO   exe(CiorappconsultAggDO[] aggdos) throws BizException{
		if(aggdos == null || aggdos.length==0) throw new BizException("会诊信息为空");
		CiorappconsultAggDO agg = aggdos[0];
		Map<String,String> map = new HashMap<String,String>();
		if(agg != null){
		   CiordInviteConsDO[] inviteCons = agg.getCiordInviteConsDO();
		    //医嘱信息
		   CiorderAggDO oraggdos = CiOrdAppUtils.getOrAggQryService().findById(agg.getParentDO().getId_or());
		   if(inviteCons != null && inviteCons.length >0){
			   for(CiordInviteConsDO  invite:inviteCons){
				   //不参加会诊的
				   if(!invite.getFg_join_cons().booleanValue()){
					   map.put(invite.getId_dep(), agg.getParentDO().getId_or());
				   }
			   }
			   // 将没有参加会诊的医嘱费用标识改为N
			   setCiOrSrvFgBl(oraggdos, map);
		   }
		   /*5)	更新执行状态（CI_ORDER. sd_su_mp=4已执行，医嘱下所有的SRV都更新为已执行
		    * CI_OR_SRV.sd_su_mp=4 执行完成）。
		    * （如果医嘱是未执行的，那么转科和出院核查时会校验出来，护士会要求医生来点这个按钮）。
		    */
		   //UpdateOrderSdMp(oraggdos);
		   //保存医嘱信息
		  /* oraggdos.getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
		   oraggdos.getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
		   oraggdos.getParentDO().setStatus(DOStatus.UPDATED);
		   CiOrdAppUtils.getOrAggService().save(new CiorderAggDO[]{oraggdos});*/
		   //修改为调用执行域接口进行更新状态和计费
//		   // 更新执行的状态
//		 
//		   IForeignService service = ServiceFinder.find(IForeignService.class);
//		   String[] id_ors = new  String[] {oraggdos.getParentDO().getId_or()};
//		   service.ConsultationOrHandle(id_ors);
//		   
//	      /* 6)	调用费用记账接口，插入收费记录。*/
//		   SetOrderAppendBill_ByCi(oraggdos);
		  
		   // 会诊完成
		   agg.getParentDO().setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_HZWC);
		   agg.getParentDO().setId_su_cons(ICiDictCodeConst.ID_CI_CONS_HZWC);
		   //住院会诊完成发送BS340
		   ICiorderMDORService ciorderRService = CiOrdAppUtils.getOrQryService();
		   String[] id_ors = new  String[] {oraggdos.getParentDO().getId_or()};
		   CiOrderDO[] orderDOs = ciorderRService.findByIds(id_ors,FBoolean.FALSE);
		   if (!ObjectUtils.isEmpty(orderDOs)){
			   OrdEventFireDTO dto=new OrdEventFireDTO(); 
			   String ordIds = null;
			   for (CiOrderDO orderDO : orderDOs) {
				   ordIds = String.format(",%s", orderDO.getId_or());
				   dto.setIdors(ordIds.substring(1));
				   // 发送消息
				   OrdEventUtil.fireBDEvent(IOrdEventSources.IP_CON_COMPLETE,IEventType.TYPE_UPDATE_AFTER, dto);
			   }
		   }
		   //会诊撤回 （SD_CI_CONS_KSYYD  6   ID_CI_CONS_KSYYD 科室已应答）
		   CiOrdAppUtils.getICiorappconsultCudService().save(aggdos);
		   CiorappconsultAggDO[]  aggs = CiOrdAppUtils.getICiorappconsultCudService().save(aggdos);
		   //调用执行闭环
		   IForeignService foreignService = ServiceFinder.find(IForeignService.class);
		   
		   foreignService.upOrMpAndChargeforCons(getOrPlanDTOs(aggs), "46106035", null);
		  
		}
		return aggdos[0];
	}
	 /**
	  * 获得闭环入参
	  * @param aggdos
	  * @return
	  */
	 private OrPlanDTO[] getOrPlanDTOs(CiorappconsultAggDO[] aggdos){
		 List<OrPlanDTO> orPlanDtos = new ArrayList<OrPlanDTO>();
		 for (CiorappconsultAggDO ciorappconsultAggDO : aggdos) {
			 OrdApConsDO ordApConsDO = ciorappconsultAggDO.getParentDO();
			 OrPlanDTO plan = new OrPlanDTO();
			 plan.setId_or(ordApConsDO.getId_or());
			 plan.setId_dep(Context.get().getDeptId());
			 plan.setId_emp(Context.get().getStuffId());
			 plan.setDt_mp_plan(ordApConsDO.getDt_plan());
			 plan.setDt_exe(CiOrdAppUtils.getServerDateTime());
			 plan.setEu_tp(ExecuteTpEnum.EXECUTE);
			 orPlanDtos.add(plan);
		}
		 return orPlanDtos.toArray(new OrPlanDTO[0]);
	 }
	public  OrdApConsDO   exe1(OrdApConsDO aggdos) throws BizException{
		if(aggdos == null ) throw new BizException("会诊信息为空");
		
			aggdos.setSd_su_cons(ICiDictCodeConst.SD_CI_CONS_KSYYD);
			aggdos.setId_su_cons(ICiDictCodeConst.ID_CI_CONS_KSYYD);
		
		 //会诊撤回 （SD_CI_CONS_KSYYD  6   ID_CI_CONS_KSYYD 科室已应答）
			OrdApConsDO[] consDo = new OrdApConsDO[1];
			consDo[0]=aggdos;
			ServiceFinder.find(ICiorappconsultMDOCudService.class).update(consDo);
			//调用执行域更新医嘱状态，并取消计费
			//调用执行闭环
			IMporInternalService mporInternalService = ServiceFinder.find(IMporInternalService.class);
			   
			mporInternalService.cancelAndRefundByOrPan(getOrPlanDTOs(aggdos));
			//更改服务的费用标识
			updateCiOrSrvFgBl(aggdos.getId_or());
		return aggdos;
	}
	private void updateCiOrSrvFgBl(String id_or) throws DAException {
		if(StringUtils.isNullOrEmpty(id_or))
		{
			return;
		}
		String sql = " select id_orsrv,'Y' as fg_bl from ci_or_srv s "
				+ "left join bd_pri b on s.id_primd = b.id_pri "
				+ "where s.id_or=? and s.fg_bl='N' and b.id_pri='@@@@AA1000000000VBBQ'";
		DAFacade daf = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		List<OrdSrvDO> ordSrvs = (List<OrdSrvDO>) daf.execQuery(sql, param, new BeanListHandler(OrdSrvDO.class));
		if(ordSrvs!=null && ordSrvs.size()>0){
			daf.updateDOArray(ordSrvs.toArray(new OrdSrvDO[0]), new String[]{OrdSrvDO.ID_ORSRV});
		}
	}
	/**
	  * 获得闭环入参
	  * @param aggdos
	  * @return
	  */
	 private OrPlanDTO[] getOrPlanDTOs(OrdApConsDO ordApConsDO){
		 OrPlanDTO plan = new OrPlanDTO();
		 plan.setId_or(ordApConsDO.getId_or());
		 plan.setId_dep(Context.get().getDeptId());
		 plan.setId_emp(Context.get().getStuffId());
		 plan.setDt_mp_plan(ordApConsDO.getDt_plan());
		 plan.setDt_exe(CiOrdAppUtils.getServerDateTime());	 
		 return new OrPlanDTO[]{plan};
	 } 
	/**
	 * 不参加会诊的医嘱项目的费用标识改为N
	 * @param oraggdos
	 * @param map
	 * @throws BizException
	 */
	private void setCiOrSrvFgBl(CiorderAggDO oraggdos,Map<String,String> map) throws BizException{
		if(oraggdos != null && oraggdos.getOrdSrvDO().length >0 && map.size() >0){
			//未到的执行科室
			List<OrdSrvDO> unComeDepts = new ArrayList<OrdSrvDO>();
			for(OrdSrvDO srvdo:oraggdos.getOrdSrvDO()){
	    		if(map != null && map.size() >0){
	    			if(map.containsKey(srvdo.getId_dep_mp()))
	    			{
	    				srvdo.setFg_bl(FBoolean.FALSE);
	    				unComeDepts.add(srvdo);
	    			}
	    		}
	    	}
			if(unComeDepts.size()>0){
				new DAFacade().updateDOArray(unComeDepts.toArray(new OrdSrvDO[0]), new String[]{OrdSrvDO.FG_BL});
			}
		}
	}
	
	/**
	 * 更新医嘱状态
	 * @param oraggdosICiDictCodeConst
	 * @throws BizException
	 */
	private void  UpdateOrderSdMp(CiorderAggDO oraggdos)throws BizException{
		if(oraggdos != null){
			oraggdos.getParentDO().setSd_su_mp("4");
			oraggdos.getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
			oraggdos.getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKTHROUGH);
		}
	}
	/**
	 * 费用接口
	 * @param oraggdos
	 * @throws BizException
	 */
	private void SetOrderAppendBill_ByCi(CiorderAggDO oraggdos)throws BizException{
		IBlCgAccountService service =ServiceFinder.find(IBlCgAccountService.class);
		
		if(service != null){
			
			BlCgAccountSetDTO info = new BlCgAccountSetDTO();
	    	BlCgAccountDTO[] param= setParam(info,oraggdos);
	    	if(param==null) return;
	    	service.keepAccountForIp(param, info);
	    }
	}
	
	/**
	 * 费用的参数设置
	 * @param param
	 * @param info
	 * @param oraggdos
	 */
	private BlCgAccountDTO[]  setParam(BlCgAccountSetDTO info,CiorderAggDO oraggdos)throws BizException{
		/*1.id_pat,
		id_enttp,
		code_enttp,
		id_srv,
		quan,
		eu_direct(Ci填1),
		id_org_mp,
		id_dep_mp,
		id_or,
		id_orsrv
		必填,其他字段可省;*/
		List<BlCgAccountDTO> param = null;
		if(oraggdos != null && oraggdos.getOrdSrvDO().length >0){
			 param = new ArrayList<BlCgAccountDTO>();
			for(OrdSrvDO srvDO:oraggdos.getOrdSrvDO()){
				if(srvDO.getStatus() !=DOStatus.DELETED && srvDO.getFg_bl() != null && srvDO.getFg_bl().booleanValue()){
					BlCgAccountDTO blcgAccDTO = new BlCgAccountDTO();
					blcgAccDTO.setId_ent(oraggdos.getParentDO().getId_en());
					blcgAccDTO.setId_pat(oraggdos.getParentDO().getId_pat());
					blcgAccDTO.setId_or(srvDO.getId_or());
					blcgAccDTO.setId_orsrv(srvDO.getId_orsrv());
					blcgAccDTO.setId_srv(srvDO.getId_srv());
					blcgAccDTO.setQuan(srvDO.getQuan_medu());
					blcgAccDTO.setPrice_ratio(srvDO.getPri());
					blcgAccDTO.setPrice_std(srvDO.getPri_std());
					blcgAccDTO.setRatio_pripat(FDouble.ONE_DBL);
					blcgAccDTO.setEu_direct(BookRtnDirectEnum.CHARGES);
					blcgAccDTO.setId_dep_mp(srvDO.getId_dep_mp());
					blcgAccDTO.setId_dep_or(srvDO.getId_dep_srv());
					param.add(blcgAccDTO); 
				}
			}
		}
		info.setId_dep_cg(oraggdos.getParentDO().getId_dep_or());
		info.setId_emp_cg(oraggdos.getParentDO().getId_emp_or());
		info.setId_org_cg(oraggdos.getParentDO().getId_org());
		info.setSrcfunc_des(IBlCgFuncConst.FUNC_IPOR_DOCTORSTATION);
		info.setEu_srctp(FeeOriginEnum.ORDERS_FEE);
		info.setFg_addfee(FBoolean.FALSE);
		info.setFg_exception(FBoolean.TRUE);
		info.setFg_postpaid(FBoolean.TRUE);
		info.setFg_price_cal(FBoolean.FALSE);
		info.setFg_singlepat(FBoolean.FALSE);
		 
	 return param.size()==0?null:param.toArray(new BlCgAccountDTO[param.size()]);	 
	}
}
