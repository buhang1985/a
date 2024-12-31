package iih.ci.ord.s.ems.ip.order;

import java.util.HashMap;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.OrderUtils;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱删除
 * 
 * @author Young
 *
 */
public class OrderDeleteBP implements IOrderDeleteBP {

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
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

		String strIdors = "";
		for (Object obj : paramList) {
			strIdors += ",'" + obj.toString() + "'";
		}
		strIdors = strIdors.substring(1);

		//获得医嘱集合
		CiorderAggDO[] aggDOs = CiOrdAppUtils.getOrAggQryService().findByIds(lstIdors.asArray(), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(aggDOs)) {
			FMap2 scene = new FMap2();
			scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
			rstDTO.setExtension(scene);
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdorsrvs = "";
		boolean hasBiologyTestOr = false;
		HashMap<Integer, String> mapEmsType = new HashMap<Integer, String>();
		for (CiorderAggDO aggDO : aggDOs) {
			if(aggDO.getParentDO().getFg_sign().isValue()&&!ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){
				FMap2 scene = new FMap2();
				scene.put(OrderUtils.KYE_MESSAGE, "医嘱状态已经发生变化，请刷新列表！");
				rstDTO.setExtension(scene);
				rstDTO.setIsSuccess(FBoolean.FALSE);
				return rstDTO;
			}
			
			OrdSrvDO[] orsrvDOs = aggDO.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(orsrvDOs))
				continue;
			for (OrdSrvDO orsrvDO : orsrvDOs) {
				strIdorsrvs += ",'" + orsrvDO.getId_orsrv() + "'";
			}

			Integer tp = getEmsType(aggDO.getParentDO().getSd_srvtp());
			if (mapEmsType.containsKey(tp)) {
				mapEmsType.put(tp, mapEmsType.get(tp) + ",'" + aggDO.getParentDO().getId_or() + "'");
			} else {
				mapEmsType.put(tp, "'" + aggDO.getParentDO().getId_or() + "'");
			}
			if (!hasBiologyTestOr
					&& aggDO.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS_MICROGERM)) {
				hasBiologyTestOr = true;
			}
		}
		//微生物送检医嘱删除（医生作废）时判断
		// TODO：微生物送检医嘱删除（医生作废）时判断
//		if(hasBiologyTestOr){
//			CheckCanDelCanc4BiologyTestBP bp = new CheckCanDelCanc4BiologyTestBP();
//			if (!bp.exec(aggDOs[0].getParentDO().getId_en(), lstIdors.asArray()).isValue()) {
//				FMap2 scene = new FMap2();
//				scene.put(OrderUtils.KYE_MESSAGE, "存在有效的特殊使用级抗菌药医嘱，不可删除（或作废）微生物送检医嘱！");
//				rstDTO.setExtension(scene);
//				rstDTO.setIsSuccess(FBoolean.FALSE);
//				return rstDTO;
//			}
//		}
		
		//医嘱项目关联物品数据删除
		if (!StringUtils.isNullOrEmpty(strIdorsrvs)) {
			deleteCiOrSrvMm(strIdorsrvs.substring(1));
		}
		//医嘱项目关联变动剂量数据删除
		deleteCiOrSrvDose(strIdors);
		//医嘱或医嘱项目关联套内项目数据删除
		deleteCiOrSrvSet(strIdors);
		//医嘱对应的皮试相关结果的删除
		deleteCiOrSkinTestRst(strIdors);

		//医嘱对应的检验申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.LIS))
			deleteCiOrdApLabDO(mapEmsType.get(EmsType.LIS));
		//医嘱对应的检查申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.RIS))
			deleteCiOrdApObsDO(mapEmsType.get(EmsType.RIS));
		if (mapEmsType.containsKey(EmsType.CONS))
			deleteCiOrdApConsDO(mapEmsType.get(EmsType.CONS));
		if (mapEmsType.containsKey(EmsType.BT))
			deleteCiOrdApbtDO(mapEmsType.get(EmsType.BT));
		if (mapEmsType.containsKey(EmsType.BTUSE))
			deleteCiOrdApbuDO(mapEmsType.get(EmsType.BTUSE));
		if (mapEmsType.containsKey(EmsType.OPER))
			deleteCiOrdApOpDO(mapEmsType.get(EmsType.OPER));
		if (mapEmsType.containsKey(EmsType.PATHGY))
			deleteCiOrdApPathgyDO(mapEmsType.get(EmsType.PATHGY));
		if (mapEmsType.containsKey(EmsType.TRANSDEPT))
			deleteCiOrdAptransdeptDO(mapEmsType.get(EmsType.TRANSDEPT));
		if (mapEmsType.containsKey(EmsType.OUTHOSP))
			deleteCiOrdApoutDO(mapEmsType.get(EmsType.OUTHOSP));

		deleteCiOrder(aggDOs);
		deleteCiOrEvent(strIdors);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 医嘱项目关联物品数据删除
	 * 
	 * @param strIdorsrvs
	 * @throws BizException
	 */
	private void deleteCiOrSrvMm(String strIdorsrvs) throws BizException {
		new DAFacade().deleteByWhere(OrdSrvMmDO.class, OrdSrvMmDO.ID_ORSRV + " in (" + strIdorsrvs + ")");
	}

	/**
	 * 医嘱项目关联变动剂量数据删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvDose(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdSrvDoseDO.class, OrdSrvDoseDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 医嘱或医嘱项目关联套内项目数据删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvSet(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdSrvSetDO.class, OrdSrvSetDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 医嘱对应的皮试相关结果的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSkinTestRst(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(CiSkinTestRstDO.class, CiSkinTestRstDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 临床医嘱删除
	 * 
	 * @param aggdo
	 * @throws BizException
	 */
	private void deleteCiOrder(CiorderAggDO[] aggdos) throws BizException {
		CiOrdAppUtils.getOrAggService().delete(aggdos);
	}

	/**
	 * 删除医嘱对应的临床事件
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrEvent(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(CiEventDO.class, CiEventDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 医嘱对应的检验申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApLabDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApLabDO.class, OrdApLabDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 医嘱对应的检查申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApObsDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApObsDO.class, OrdApObsDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 医嘱对应的会诊申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApConsDO(String strIdors) throws BizException {
		String condstr = OrdApConsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappconsultAggDO[] dos = CiOrdAppUtils.getOrappconsultQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappconsultService().delete(dos);
	}

	/**
	 * 备血对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbtDO(String strIdors) throws BizException {
		String condstr = OrdApBtDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappbtAggDO[] dos = CiOrdAppUtils.getOrappbtQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappbtService().delete(dos);
	}

	/**
	 * 用血对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbuDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdAppBtUseDO.class, OrdAppBtUseDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 手术对应申请单相关的信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApOpDO(String strIdors) throws BizException {
		String condstr = OrdApOpDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappsurgeryAggDO[] dos = CiOrdAppUtils.getOrappsurgeryQrytService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappsurgerytService().delete(dos);
	}

	/**
	 * 病理对应的申请单相关的信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApPathgyDO(String strIdors) throws BizException {
		String condstr = OrdApPathgyDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorapppathgyAggDO[] dos = CiOrdAppUtils.getOrapppathgyQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapppathgyService().delete(dos);
	}

	/**
	 * 转科对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdAptransdeptDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApTransDO.class, OrdApTransDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 出院对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApoutDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApOutDO.class, OrdApOutDO.ID_OR + " in (" + strIdors + ")");
	}

	/**
	 * 获得默认医疗单类型
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException {
		GetDefaultEmsTp8SrvtpBP bp = new GetDefaultEmsTp8SrvtpBP();
		return bp.exec(sd_srvtp);
	}
}
