package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciprn.i.ICiprintExtService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.OrConfirmBP;
import iih.ci.ord.s.bp.UseBtContainsBuValidateBP;
import iih.ci.ord.s.bp.UseBtOrNumMarginBuUpdateBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医嘱作废
 * @author Young
 *
 */
public class OrderCancelBP implements IOrderCancelBP {

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		StringList lstIdors = new StringList(paramList);
		if (lstIdors.size() == 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		//获得医嘱聚集数据集合
		CiOrderDO[] orderDOs = CiOrdAppUtils.getOrQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(orderDOs)) {
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		boolean hasBiologyTestOr = false;
		for (CiOrderDO orderDO : orderDOs) {
			if(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS.equals(orderDO.getId_freq())){
				try {
					//未记账的持续医嘱可作废
					if(CiOrdUtils.ordIsHasBl(orderDO.getId_or())){
						FMap2 scene = new FMap2();
						scene.put(OrderUtils.KYE_MESSAGE, "医嘱【"+orderDO.getName_or()+"】已记账，无法作废！");
						rstDTO.setExtension(scene);
						rstDTO.setIsSuccess(FBoolean.FALSE);
						return rstDTO;
					}
				} catch (BizException e) {
					e.printStackTrace();
				}
			}else{
				if(FBoolean.TRUE.equals(orderDO.getFg_canc())
						|| (ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())?false:FBoolean.TRUE.equals(orderDO.getFg_uncancelable()))
						|| FBoolean.FALSE.equals(orderDO.getFg_chk())){
						FMap2 scene = new FMap2();
						scene.put(OrderUtils.KYE_MESSAGE, "选择的医嘱项目不允许“作废” ");
						rstDTO.setExtension(scene);
						rstDTO.setIsSuccess(FBoolean.FALSE);
						return rstDTO;
					}
			}
			if (!hasBiologyTestOr
					&& orderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS_MICROGERM)) {
				hasBiologyTestOr = true;
			}
		}
		//校验备血医嘱
		UseBtContainsBuValidateBP btbp=new UseBtContainsBuValidateBP();
		if(btbp.exec(orderDOs)){
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "备血医嘱已关联用血，请确认！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		
		//微生物送检医嘱删除（医生作废）时判断
		if(hasBiologyTestOr){
//			CheckCanDelCanc4BiologyTestBP bp = new CheckCanDelCanc4BiologyTestBP();
//			if (!bp.exec(orderDOs[0].getId_en(), lstIdors.asArray()).isValue()) {
//				FMap2 scene = new FMap2();
//				scene.put(OrderUtils.KYE_MESSAGE, "存在有效的特殊使用级抗菌药医嘱，不可删除（或作废）微生物送检医嘱！");
//				rstDTO.setExtension(scene);
//				rstDTO.setIsSuccess(FBoolean.FALSE);
//				return rstDTO;
//			}
		}
		
		this.updateOrderStatus(ctx, orderDOs);
		
		//备血可用血余量更新
		UseBtOrNumMarginBuUpdateBP bpBuUpdate = new UseBtOrNumMarginBuUpdateBP();
		bpBuUpdate.exec(orderDOs, false);
		
		//删除检查打印数据
		ServiceFinder.find(ICiprintExtService.class).DeleteAppRisData(lstIdors.asArray());
		
		CiOrdAppUtils.getIResponseOrderHandelService().responseOrInvalid(lstIdors.asArray());
		
		// 医嘱作废确认
		handleMtOrderCancelInfo(ctx,orderDOs);
		// 护嘱作废确认
		handleNurOrderCancelInfo(ctx,orderDOs);
				
		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}
	
	/**
	 * 医技医嘱自动作废确认
	 * @param ctx
	 * @param ciors
	 * @throws BizException
	 */
	private void handleMtOrderCancelInfo(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())){
			// 过滤当前医嘱的执行科室必须为本科室(是否需要 限定服务类型？？)
			List<CiOrderDO> orderInfoList = new ArrayList<CiOrderDO>();
			for(CiOrderDO orderInfo : ciors){
				if(orderInfo.getId_dep_mp()!=null && orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					orderInfoList.add(orderInfo);
				}
			}
			
			if(orderInfoList.size() > 0){
				// 医技医嘱确认
				OrConfirmBP confirmBP = new OrConfirmBP();
				String errorMsg = confirmBP.runMtOrderCancelConfirm(orderInfoList.toArray(new CiOrderDO[orderInfoList.size()]));
				if(!StringUtils.isNullOrEmpty(errorMsg)){
					throw new BizException (errorMsg); 
				}
			}
			
		}
	}
	
	/**
	 * 护嘱自动作废确认
	 * @param ctx
	 * @param ciors
	 * @throws BizException
	 */
	private void handleNurOrderCancelInfo(CiEnContextDTO ctx,CiOrderDO[] ciors) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){
			// 过滤当前医嘱的执行科室必须为本科室(是否需要 限定服务类型？？)
			List<CiOrderDO> orderInfoList = new ArrayList<CiOrderDO>();
			for(CiOrderDO orderInfo : ciors){
				if(orderInfo.getId_dep_mp()!=null && orderInfo.getId_dep_mp().equals(ctx.getId_dep_or())){
					orderInfoList.add(orderInfo);
				}
			}
			
			if(orderInfoList.size() > 0){
				// 医技医嘱确认
				OrConfirmBP confirmBP = new OrConfirmBP();
				String errorMsg = confirmBP.runNurOrderCancelConfirm(orderInfoList.toArray(new CiOrderDO[orderInfoList.size()]));
				if(!StringUtils.isNullOrEmpty(errorMsg)){
					throw new BizException (errorMsg); 
				}
			}
			
		}
	}

	/**
	 * 更新医嘱停止状态
	 * 
	 * @param orders
	 * @throws BizException
	 */
	private void updateOrderStatus(CiEnContextDTO enContext, CiOrderDO[] orders) throws BizException {
		String[] arrayFieldNames = new String[] { CiOrderDO.ID_SU_OR, CiOrderDO.SD_SU_OR, 
				CiOrderDO.FG_CANC, CiOrderDO.DT_CANC, 
				CiOrderDO.ID_DEP_CANC, CiOrderDO.ID_EMP_CANC,
				CiOrderDO.FG_CHK_CANC, CiOrderDO.DT_CHK_CANC, 
				CiOrderDO.ID_DEP_CHK_CANC, CiOrderDO.ID_EMP_CHK_CANC};
		
		//获取包含特殊级抗菌药的医嘱
		SqlParam sqlParam = new SqlParam();
		String strWhereIdors = "";
		for(CiOrderDO order:orders){
			sqlParam.addParam(order.getId_or());
			strWhereIdors += ",?";
		}
		List<String> idors_specanti = this.getIdors4SpecAnti(sqlParam, strWhereIdors.substring(1));
		
		FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		String id_dep = enContext.getId_dep_or();
		String id_emp = enContext.getId_emp_or();
		List<CiOrderDO> origindos = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			origindos.add(order);
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CANCEL);
			order.setSd_su_or(ICiDictCodeConst.SD_SU_CANCEL);
			order.setFg_canc(FBoolean.TRUE);
			order.setDt_canc(dtNow);
			order.setId_dep_canc(id_dep);
			order.setId_emp_canc(id_emp);
			//特殊使用级抗菌药，作废和作废确认一步完成
			if(idors_specanti.contains(order.getId_or())){
				order.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKCANCEL);
				order.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKCANCEL);
				order.setFg_chk_canc(FBoolean.TRUE);
				order.setDt_chk_canc(dtNow);
				order.setId_dep_chk_canc(id_dep);
				order.setId_emp_chk_canc(id_emp);
			}
		}
		new DAFacade().updateDOArray(orders, arrayFieldNames);
	}
	
	/**
	 * 获取包含特殊级抗菌药的医嘱
	 * @param sqlParam
	 * @param strWhereIdors
	 * @return
	 * @throws BizException 
	 */
	private List<String> getIdors4SpecAnti(SqlParam sqlParam, String strWhereIdors) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct ORD.id_or from ci_order ORD ")
		.append("left join ci_or_srv ORSRV on ORD.id_or=ORSRV.id_or ")
		.append("left join bd_srv_drug DRUG on DRUG.id_srv=ORSRV.id_srv ")
		.append("where DRUG.sd_anti='3' and ORD.id_or in (" + strWhereIdors + ")");
		List<Map<String, Object>> sqlRst = CiOrdUtils.getRsMapList(sb.toString(), sqlParam);
		List<String> idors = new ArrayList<String>();
		if (sqlRst == null || sqlRst.size() <= 0) {
			for (Map<String, Object> rst : sqlRst) {
				idors.add(rst.get("id_or").toString());
			}
		}
		return idors;
	}
}
