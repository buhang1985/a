package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.utils.ParamUtils;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.EnumOpAgainChkRst;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.ValidateRtnInfoDTO;
import iih.ci.ord.cior.i.ICiorappsurgeryMDORService;
import iih.ci.ord.cior.i.ICiorappsurgeryRService;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.ICiOrdCustomSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 二次手术签署校验
 * @author zhangwq
 *
 */
public class CiApSugAgainSignValidateBP {
	/**
	 * 就诊id
	 */
	private String id_ent;
	/**
	 * 患者id
	 */
	private String id_pat;
	//新建的二次手术申请单
	private List<OrdApOpAgainDO> newApOpAgains = new ArrayList<OrdApOpAgainDO>();
	private StringBuilder errorInfo = new StringBuilder();
	//手术未审核的医嘱
	private List<CiOrderDO> unCheckedOrders = new ArrayList<CiOrderDO>();
	//二次手术审核未通过的医嘱
	private List<CiOrderDO> rejectOrders = new ArrayList<CiOrderDO>();
	//可以继续保存的医嘱
	private List<CiOrderDO> canSaveOrders = new ArrayList<CiOrderDO>();
	public ValidateRtnInfoDTO exec(CiOrderDO[] ciors) throws BizException{
		this.id_ent = ciors[0].getId_en();
		this.id_pat = ciors[0].getId_pat();
		ValidateRtnInfoDTO rtndto = new ValidateRtnInfoDTO();
		CiOrderDO[] sugOrders = getSugOrders(ciors);
		//存在手术医嘱
		if(sugOrders!=null&&sugOrders.length>0){
			//手术医嘱的判断
			apSugAgainOrders(sugOrders);
			if(unCheckedOrders.size()>0){
				int i=0;
				for(CiOrderDO ciOrderDO : unCheckedOrders){
					errorInfo.append("【"+ciOrderDO.getName_or()+"】");
					if(i!=unCheckedOrders.size()-1){
						errorInfo.append("、");
					}
					i++;
				}
				errorInfo.append("二次手术未审核！\r\n");
			}
			if(rejectOrders.size()>0){
				int i=0;
				for(CiOrderDO ciOrderDO : rejectOrders){
					errorInfo.append("【"+ciOrderDO.getName_or()+"】");
					i++;
					if(i!=rejectOrders.size()-1){
						errorInfo.append("、");
					}
				}
				errorInfo.append("二次手术申请被驳回！\r\n");
			}
		}
		if(errorInfo.length()>0){
			FMap2 map = new FMap2();
			map.put("ApOpAgainErrroInfo", errorInfo.toString());
			if(canSaveOrders.size()>0){ 
				FArrayList list = new FArrayList();
				list.addAll(canSaveOrders);
				map.put("IsCanSaveOrders",list) ;
			}
			rtndto.setScenedatum(map);
			return rtndto;
		}
		return null;
	}
	/**
	 * 获取手术医嘱
	 * @param rtndto
	 * @param ciors
	 * @return
	 */
	private CiOrderDO[] getSugOrders(CiOrderDO[] ciors){
		List<CiOrderDO> sugOrders = new ArrayList<CiOrderDO>();
		for(CiOrderDO ciorder : ciors){
			if(ciorder.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){
				sugOrders.add(ciorder);
			}else{
				canSaveOrders.add(ciorder);
			}
		}
		return sugOrders.toArray(new CiOrderDO[0]);
	}
	/**
	 * 二次手术判断
	 * @param ciors
	 * @throws BizException 
	 */
	private void apSugAgainOrders(CiOrderDO[] ciors) throws BizException{
		List<String> idors = new ArrayList<String>();
		Map<String,CiOrderDO> orderTempMap = new HashMap<String,CiOrderDO>();
		for(CiOrderDO order:ciors){
			idors.add(order.getId_or());
			orderTempMap.put(order.getId_or(), order);
		}
		//查询准备签署的手术申请单
		ICiorappsurgeryRService aggService = ServiceFinder.find(ICiorappsurgeryRService.class);
		CiorappsurgeryAggDO[] appsugAggs = aggService.findByAttrValStrings(OrdApOpDO.ID_OR, idors.toArray(new String[0]));
		for(CiorappsurgeryAggDO sugAgg : appsugAggs){
			OrdApOpDO op = sugAgg.getParentDO();
			String sd_surgical_site = op.getSd_surgical_site();
			String id_apop = op.getId_apop();
			//是否开启二次手术审核流程
			FBoolean sugAgainSign = getsugAgainSign();
			//是否已经存在二次手术申请单
			OrdApOpAgainDO[] ordApOpAgainDOs = sugAgg.getOrdApOpAgainDO();
			//不存在二次手术申请单
			if(ordApOpAgainDOs==null||ordApOpAgainDOs.length==0){
				//查询是否已经存在同部位的手术医嘱,判断是否为二次手术
				OrdApOpDO[] firstApOps = getSameSiteSug(id_ent,id_apop,sd_surgical_site);
				if(firstApOps != null && firstApOps.length>0 && sugAgainSign.booleanValue() ){
					OrdApOpDO  firstApOp = firstApOps[0];
					//创建二次手术申请单
					this.newApOpAgains.add(createOrdApOpAgainDO(firstApOp,op));
					unCheckedOrders.add(orderTempMap.get(op.getId_or()));
				}else{
					this.canSaveOrders.add(orderTempMap.get(op.getId_or()));
				}
				//
			}else{
				//存在二次手术申请单
				OrdApOpAgainDO again = ordApOpAgainDOs[0];
				//未审批
				if(EnumOpAgainChkRst.NULL.equals(again.getSd_reltp())){
					unCheckedOrders.add(orderTempMap.get(op.getId_or()));
				}else if(EnumOpAgainChkRst.REJECTED.equals(again.getSd_reltp())){
					this.rejectOrders.add(orderTempMap.get(op.getId_or()));
				}else{
					this.canSaveOrders.add(orderTempMap.get(op.getId_or()));
				}
			}
		}
		if(this.newApOpAgains.size()>0){
			IOrdApOpAgainDOCudService againService = ServiceFinder.find(IOrdApOpAgainDOCudService.class);
			againService.save(newApOpAgains.toArray(new OrdApOpAgainDO[0]));
		}
	}
	/**
	 * 是否开启二次手术审核
	 * @return
	 */
	private FBoolean getsugAgainSign() {
		FBoolean sugAgainSign =FBoolean.TRUE;
		try {
			sugAgainSign = ParamUtils.GetOrgParamFBooleanValue(ICiOrdCustomSysParamConst.WW_SUG_AGAIN);
		} catch (BizException e) {
			
			e.printStackTrace();
		}
		return sugAgainSign;
	}
	/**
	 * 查询是否已经存在同部位的手术医嘱
	 * @param id_ent
	 * @param id_apop
	 * @param sd_surgical_site
	 * @return
	 * @throws DAException
	 */
	private OrdApOpDO[] getSameSiteSug(String id_ent,String id_apop,String sd_surgical_site) throws DAException{
		DAFacade dao = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		param.addParam(id_apop);
		param.addParam(sd_surgical_site);
		List<OrdApOpDO> ordApOps= (List<OrdApOpDO>)dao.execQuery(getSameSiteSugSql(), param, new BeanListHandler(OrdApOpDO.class));
		if(ordApOps!=null&&ordApOps.size()>0){
			return ordApOps.toArray(new OrdApOpDO[0]);
		}
		return null;
	}
	private String getSameSiteSugSql(){
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sug.*,bd_srv.name as Name_op ");
		sb.append("from ci_ap_sug sug "); 
        sb.append("left join ci_order ci on sug.id_or = ci.id_or ");
        sb.append("left join bd_srv on sug.id_srv=bd_srv.id_srv ");
		sb.append("where ci.fg_canc='N' and ci.id_en=? and ci.fg_sign='Y' and sug.id_apop<> ? and sug.sd_surgical_site=? ");
		return sb.toString();
	}
	/**
	 * 创建二次手术申请单
	 * @param firstOp
	 * @param secondOp
	 * @return
	 */
	private OrdApOpAgainDO createOrdApOpAgainDO(OrdApOpDO firstOp,OrdApOpDO secondOp){
		OrdApOpAgainDO again = new OrdApOpAgainDO();
		again.setId_pat(this.id_pat);
		again.setId_apop(secondOp.getId_apop());
		again.setDt_apply(secondOp.getDt_plan());
		again.setDt_first_op(firstOp.getDt_plan());
		again.setDt_again_op(secondOp.getDt_plan());
		again.setFg_urgent(FBoolean.FALSE);
		again.setFg_same_dep(FBoolean.FALSE);
		again.setFirst_op_id_srv(firstOp.getId_srv());
		again.setFirst_op_name(firstOp.getName_op());
		again.setAgain_op_id_srv(secondOp.getId_srv());
		again.setAgain_op_name(secondOp.getName_op());
		again.setFg_submit(FBoolean.FALSE);
		again.setSd_reltp(EnumOpAgainChkRst.NULL);
		again.setStatus(DOStatus.NEW);
		return again;
	}
}
