package iih.ci.ord.s.ems.ip.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.ip.ems.base.CommonIpEmsSaveBP;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.utils.OrderSrvRefUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 住院医生站药品保存基类实现
 * @author wangqingzhu
 *
 */
public class BaseIpEmsMedicinesSaveBP extends CommonIpEmsSaveBP {
	
	@Override
	protected OrderPackageInfo[] handleOrderAggInfoList(CiEnContextDTO ctx, ObjectList objList) throws BizException {
		OrderPackageInfoList listOrderPakageInfo = new OrderPackageInfoList();
		// 定义新建医嘱集合与更新医嘱集合
		List<Object> listCreateInfo = new ArrayList<Object>();
		List<Object> listUpdateInfo = new ArrayList<Object>();
		if(objList!=null && objList.size() > 0){
			boolean isNew = true;
			for (Object item : objList) {
				if (GetSrvObjStatus(item) != DOStatus.NEW) {
					isNew = false;
				}
			}
			if (isNew) {
				listCreateInfo.addAll(objList);
			} else {
				listUpdateInfo.addAll(objList);// 更新医疗单
			}
		}
		

		OrderPackageInfo[] szCreateOrderAgg = handleCreateOrderInfo(ctx, listCreateInfo);
		if (szCreateOrderAgg != null && szCreateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szCreateOrderAgg));
		}

		OrderPackageInfo[] szUpdateOrderAgg = handleUpdateOrderInfo(ctx, listUpdateInfo);
		if (szUpdateOrderAgg != null && szUpdateOrderAgg.length > 0) {
			listOrderPakageInfo.addAll(Arrays.asList(szUpdateOrderAgg));
		}

		return listOrderPakageInfo.asArray();
	}

	@Override
	protected OrderPackageInfo[] handleCreateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {
		OrderPackageInfo[] orderPakageInfos = super.handleCreateOrderInfo(ctx, listUiModel);
		if(CiOrdUtils.isEmpty(orderPakageInfos))
			return null;
		// 处理用法与煎法关联服务
		for (OrderPackageInfo pInfo : orderPakageInfos) {
			// 用法关联服务信息
			handleOrderRouteInfo(pInfo,pInfo.getUiModel());
			if(CiOrdUtils.isTrue(pInfo.getOrderInfo().getFg_boil())){
				// 煎法关联服务信息
				handleOrderBoilInfo(pInfo, pInfo.getUiModel());
			}
			// 医嘱关联服务信息
			handleOrderSrvRelInfo(pInfo, pInfo.getOrderSrvList());
		}
		return orderPakageInfos;
	}
	
	
	
	@Override
	protected OrderPackageInfo[] handleUpdateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPackageInfo = super.handleUpdateOrderInfo(ctx, listUiModel);
		if(CiOrdUtils.isEmpty(szOrderPackageInfo)){
			return null;
		}
		// 处理用法与煎法关联服务
		for (OrderPackageInfo pInfo : szOrderPackageInfo) {
			// 用法关联服务信息
			handleOrderRouteInfo(pInfo,pInfo.getUiModel());
			if(CiOrdUtils.isTrue(pInfo.getOrderInfo().getFg_boil())){
				// 煎法关联服务信息
				handleOrderBoilInfo(pInfo, pInfo.getUiModel());
			}
			// 医嘱关联服务信息
			handleOrderSrvRelInfo(pInfo, pInfo.getOrderSrvList());
		}
		return szOrderPackageInfo;
	}

	/**
	 * 处理医嘱关联服务的状态
	 * @param pInfo
	 * @param szOrdSrvInfo
	 * @throws BizException
	 */
	protected void handleOrderSrvRelInfo(OrderPackageInfo pInfo, OrdSrvDO[] szOrdSrvInfo) throws BizException {
		
	}
	
	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		// 
		OrderPackageInfo[] rstOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			
			// 合并医嘱服务变动用药
			if (pInfo.getOrderSrvDoseList() != null && pInfo.getOrderSrvDoseList().size() > 0) {
				//mergeOrderDoseInfo(ctx, pInfo.getOrderSrvDoseList(), pInfo.getUiModel());
			}
		}
		return rstOrderPackageInfo;
	}
	
	/**
	 * 合并变动用药信息
	 * 
	 * @param ctx
	 * @param doseList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderDoseInfo(CiEnContextDTO ctx, OrdSrvDoseDO[] doseList, Object uiModel) throws BizException {

	}
	
	/**
	 * 处理服务用法描述信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderSrvRouteDesInfo(OrdSrvDO srvInfo, Object uiModelInfo) throws BizException {

	}

	/**
	 * 处理用法信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderRouteInfo(OrderPackageInfo opInfo,  Object uiModelInfo) throws BizException {
		// 获得用法关联费用项目
		OrdSrvDO[] routeRelFeeSrvs = OrderSrvRefUtils.RouteRelFeeSrvs(this.getEnContextInfo(), opInfo.getOrderInfo());
		// 将用法关联的费用添加到agg中
		OrderSrvMmList listOrderSrvInfo = opInfo.getOrderSrvMmList();
		if (!CiOrdUtils.isEmpty(routeRelFeeSrvs) && !CiOrdUtils.isEmpty(listOrderSrvInfo)) {
			
			// 合并后的数组
			listOrderSrvInfo.append(routeRelFeeSrvs);
			
		}
		
	}

	/**
	 * 处理煎法信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderBoilInfo(OrderPackageInfo opInfo,  Object uiModelInfo) throws BizException {
		// 获得煎法关联费用项目
		OrdSrvDO[] boilRelFeeSrvs = OrderSrvRefUtils.BoilRelFeeSrvs(this.getEnContextInfo(), opInfo.getOrderInfo());
		// 将煎法关联的费用添加到agg中
		OrderSrvMmList listOrderSrvInfo = opInfo.getOrderSrvMmList();
		if (!CiOrdUtils.isEmpty(boilRelFeeSrvs) && !CiOrdUtils.isEmpty(listOrderSrvInfo)) {
			
			// 合并后的数组
			listOrderSrvInfo.append(boilRelFeeSrvs);
			
		}
		
	}
	
	/**
	 * 修复每个医嘱包中的医保信息
	 * @param ctx
	 * @param orderPackageInfo
	 * @return
	 */
	protected OrderPackageInfo repairHpOrderPackageInfo(CiEnContextDTO ctx, OrderPackageInfo orderPackageInfo){
		
		OrderSrvMmInfo[] orderSrvMmInfos = orderPackageInfo.getAllOrderSrvMmList().asArray();
		for (OrderSrvMmInfo orderSrvMmInfo : orderSrvMmInfos) {

			OrdSrvDO ordSrv = orderSrvMmInfo.getOrderSrvInfo();
			
			if(DOStatus.DELETED == ordSrv.getStatus()){
				continue;
			}

			// 只有费用项才有医保目录
			if (!FBoolean.TRUE.equals(ordSrv.getFg_bl())) {					
				continue;
			}
			
			// 如果费用项是不判断的，但是不满足不判断项目的限制条件，如果是自费，改为医生判断自费，否则改为待判断
			if(HpIndicJudgeRstEnum.NEVER_JUDGE.equals(ordSrv.getEu_hpindicjudge())){
				if(!(StringUtils.isNotEmpty(ordSrv.getSd_nodispense()) || FBoolean.TRUE.equals(ordSrv.getFg_research()))){
					
					if(FBoolean.TRUE.equals(ordSrv.getFg_selfpay())){
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
						ordSrv.setDes_hplimit("医生选择自费开立医嘱");
					}else{
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
						ordSrv.setDes_hplimit("");
					}
				}
			}
			
			// 不摆药类型为空时设置为不判断
			if (StringUtils.isNotEmpty(ordSrv.getSd_nodispense())) {
				ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(FBoolean.FALSE);
				ordSrv.setDes_hplimit("不计费类型限制【" + ordSrv.getSd_nodispense() + "】：限制服务项目不进行医保判断");
			}
			
			// 科研项目不进行适应症判断
			if (FBoolean.TRUE.equals(ordSrv.getFg_research())) {
				ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.NEVER_JUDGE);
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(null);
				ordSrv.setDes_hplimit("科研项目不判断医保！");
			}

			// 如果判断，返回判断下一条
			if(ordSrv.getEu_hpindicjudge() != null && !HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge())){
				continue;
			}
			
			// 医生勾选自费，服务项目的医保判断结果是待判定的都设置为自费
			/*if (FBoolean.TRUE.equals(ordSrv.getFg_selfpay()) && HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge())) {
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_indic(null);
				ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);
				ordSrv.setDes_hplimit("医生选择自费开立医嘱");
			}*/

			
			
			
			// 医生判断自费
			if(HpIndicJudgeRstEnum.DOCTOR_JUDGE.equals(ordSrv.getEu_hpindicjudge())){
				
				if(HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()) || ordSrv.getEu_hpindicjudge() == null){
				
					if(!FBoolean.TRUE.equals(ordSrv.getFg_selfpay())){
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
						ordSrv.setFg_selfpay(null);
						
					}else{
						ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.DOCTOR_JUDGE);	
						ordSrv.setFg_selfpay(FBoolean.TRUE);
						ordSrv.setFg_indic(null);
						ordSrv.setDes_hplimit("医生选择自费开立医嘱");
					}
				}
				
			}else if(HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()) || ordSrv.getEu_hpindicjudge() == null){
				
				if(HpIndicJudgeRstEnum.WAITING_JUDGE.equals(ordSrv.getEu_hpindicjudge()) || ordSrv.getEu_hpindicjudge() == null){							
					ordSrv.setEu_hpindicjudge(HpIndicJudgeRstEnum.WAITING_JUDGE);
					ordSrv.setFg_selfpay(null);
				}
				
			}
		}		
	
		
		return orderPackageInfo;
	}
	
	/**
	 * 处理药品属性信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderSrvDrugInfo(OrdSrvDO srvInfo, Object uiModelInfo) throws BizException {
		//		ordInfo.setFg_extdispense(FBoolean.FALSE) ;
		//		ordInfo.setFg_base(FBoolean Fg_base) ;
		//		ordInfo.setFg_dose_anoma(srvAgg.getParentDO().getFg_dose_anoma()) ;
		//		ordInfo.setFg_pres_outp(FBoolean.FALSE) ;
		//		ordInfo.setFg_self(FBoolean.FALSE);
	}
	
	@Override
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);
		// 取一条集合中第一条名称作为医嘱名称
		for(OrdSrvDO ordSrv : srvInfos){
			
			if(DOStatus.DELETED == ordSrv.getStatus()){
				continue;
			}
			
			orderInfo.setName_or(ordSrv.getName());
			break;
		}
		
	}
}
