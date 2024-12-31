package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ciet.cievent.d.desc.CiEventDODesc;
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
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdDrugDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdDrugDODesc;
import iih.ci.ord.ciorder.d.desc.OrdFreqTimeDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;

/**
 * 医嘱删除逻辑
 * @author Young
 *
 */
public class OrderDeleteOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ciEnContextDTO, FMap2 extension)
			throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		if (idors == null || idors.length <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdors = "";
		for (String idor : idors) {
			strIdors += ",'" + idor + "'";
		}
		strIdors = strIdors.substring(1);
		
		//查询id_or,sd_srvtp,id_orsrv集合
		List<Map<String, Object>> lstIdorsrvs = this.getIdorsrvs(strIdors);
		if (CiOrdUtils.isEmpty(lstIdorsrvs)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdorsrvs = "";
		HashMap<Integer, String> mapEmsType = new HashMap<Integer, String>();
		for (Map<String, Object> map : lstIdorsrvs) {
			strIdorsrvs += ",'" + map.get("Id_orsrv").toString() + "'";
			Integer sdtp = this.getEmsType(map.get("Sd_srvtp").toString());
			String idor = map.get("Id_or").toString();
			if (mapEmsType.containsKey(sdtp)) {
				String idors_ems = mapEmsType.get(sdtp);
				if (!idors_ems.contains(idor)) {
					mapEmsType.put(sdtp, idors_ems + ",'" + idor + "'");
				}
			} else {
				mapEmsType.put(sdtp, "'" + idor + "'");
			}
		}

		//医嘱项目关联物品数据删除
		if (!StringUtils.isNullOrEmpty(strIdorsrvs)) {
			this.deleteCiOrSrvMm(strIdorsrvs.substring(1));
		}
		//医嘱项目关联变动剂量数据删除
		this.deleteCiOrSrvDose(strIdors);
		//医嘱或医嘱项目关联套内项目数据删除
		this.deleteCiOrSrvSet(strIdors);
		//医嘱对应的皮试相关结果的删除
		this.deleteCiOrSkinTestRst(strIdors);

		//医嘱对应的检验申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.LIS))
			this.deleteCiOrdApLabDO(mapEmsType.get(EmsType.LIS));
		//医嘱对应的检查申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.RIS))
			this.deleteCiOrdApObsDO(mapEmsType.get(EmsType.RIS));
		//医嘱对应的会诊申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.CONS))
			this.deleteCiOrdApConsDO(mapEmsType.get(EmsType.CONS));
		//医嘱对应的备血申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.BT))
			this.deleteCiOrdApbtDO(mapEmsType.get(EmsType.BT));
		//医嘱对应的用血申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.BTUSE))
			this.deleteCiOrdApbuDO(mapEmsType.get(EmsType.BTUSE));
		//医嘱对应的手术申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.OPER))
			this.deleteCiOrdApOpDO(mapEmsType.get(EmsType.OPER));
		//医嘱对应的病理申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.PATHGY))
			this.deleteCiOrdApPathgyDO(mapEmsType.get(EmsType.PATHGY));
		//医嘱对应的转科申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.TRANSDEPT))
			this.deleteCiOrdAptransdeptDO(mapEmsType.get(EmsType.TRANSDEPT));
		//医嘱对应的出院申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.OUTHOSP))
			this.deleteCiOrdApoutDO(mapEmsType.get(EmsType.OUTHOSP));

		//医嘱删除
		this.deleteCiOrder(strIdors);
		//医嘱对应的临床事件删除
		this.deleteCiOrEvent(strIdors);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 根据医嘱id查询医嘱项目
	 * @param idors
	 * @return
	 * @throws BizException
	 */
	private List<Map<String, Object>> getIdorsrvs(String idors) throws BizException {
		String sqlStr = "select ORSRV.Id_or,ORD.Sd_srvtp,ORSRV.Id_orsrv from ci_or_srv ORSRV inner join ci_order ORD on ORD.id_or=ORSRV.id_or "
				+ "where ORD.Fg_sign='N' and ORD.Fg_canc='N' and ORSRV.id_or in (" + idors + "))";
		return CiOrdUtils.getRsMapList(sqlStr);
	}
	
	/**
	 * 拼接条件语句
	 * @param strTblName
	 * @param strFildName
	 * @param strValue
	 * @return
	 */
	private String getStrCondition(String strTblName, String strFildName, String strValue) {
		StringBuilder sb = new StringBuilder();
		sb.append(strTblName).append(".").append(strFildName).append(" in (").append(strValue).append(")");
		return sb.toString();
	}

	/**
	 * 医嘱项目关联物品数据删除*
	 * 
	 * @param strIdorsrvs
	 * @throws BizException
	 */
	private void deleteCiOrSrvMm(String strIdorsrvs) throws BizException {
		OrdSrvMmDO[] dos = CiOrdAppUtils.getOrSrvMmQryService().find(
				this.getStrCondition(OrdSrvMmDODesc.TABLE_ALIAS_NAME, "id_orsrv", strIdorsrvs), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrsrvmmService().logicDelete(dos);
	}

	/**
	 * 医嘱项目关联变动剂量数据删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvDose(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdSrvDoseDO.class, 
				this.getStrCondition(OrdSrvDoseDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 医嘱或医嘱项目关联套内项目数据删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvSet(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdSrvSetDO.class, 
				this.getStrCondition(OrdSrvSetDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 医嘱对应的皮试相关结果的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSkinTestRst(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(CiSkinTestRstDO.class, 
				this.getStrCondition(CiSkinTestRstDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 临床医嘱删除*
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrder(String strIdors) throws BizException {
		//医嘱删除
		new DAFacade().deleteByWhere(CiOrderDO.class, 
				this.getStrCondition(CiOrderDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
		//医嘱服务删除
		new DAFacade().deleteByWhere(OrdSrvDO.class, 
				this.getStrCondition(OrdSrvDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
		//医嘱药品删除
		new DAFacade().deleteByWhere(OrdDrugDO.class, 
				this.getStrCondition(OrdDrugDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
		//医嘱执行时刻删除
		new DAFacade().deleteByWhere(OrdFreqTimeDO.class, 
				this.getStrCondition(OrdFreqTimeDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 删除医嘱对应的临床事件*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrEvent(String strIdors) throws BizException {
		CiEventDO[] dos = CiOrdAppUtils.getCieventQryService().find(
				this.getStrCondition(CiEventDODesc.TABLE_ALIAS_NAME, "id_or", strIdors), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getCieventService().logicDelete(dos);
	}

	/**
	 * 医嘱对应的检验申请相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApLabDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApLabDO.class, 
				this.getStrCondition(OrdApLabDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 医嘱对应的检查申请相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApObsDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApObsDO.class, 
				this.getStrCondition(OrdApObsDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 医嘱对应的会诊申请相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApConsDO(String strIdors) throws BizException {
		CiorappconsultAggDO[] dos = CiOrdAppUtils.getOrappconsultQryService().find(
				this.getStrCondition(OrdApConsDODesc.TABLE_ALIAS_NAME, "id_or", strIdors), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappconsultService().delete(dos);
	}

	/**
	 * 备血对应的申请单相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbtDO(String strIdors) throws BizException {
		CiorappbtAggDO[] dos = CiOrdAppUtils.getOrappbtQryService().find(
				this.getStrCondition(OrdApBtDODesc.TABLE_ALIAS_NAME, "id_or", strIdors), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappbtService().delete(dos);
	}

	/**
	 * 用血对应的申请单相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbuDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdAppBtUseDO.class, 
				this.getStrCondition(OrdAppBtUseDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 手术对应申请单相关的信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApOpDO(String strIdors) throws BizException {
		CiorappsurgeryAggDO[] dos = CiOrdAppUtils.getOrappsurgeryQrytService().find(
				this.getStrCondition(OrdApOpDODesc.TABLE_ALIAS_NAME, "id_or", strIdors), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappsurgerytService().delete(dos);
	}

	/**
	 * 病理对应的申请单相关的信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApPathgyDO(String strIdors) throws BizException {
		CiorapppathgyAggDO[] dos = CiOrdAppUtils.getOrapppathgyQryService().find(
				this.getStrCondition(OrdApPathgyDODesc.TABLE_ALIAS_NAME, "id_or", strIdors), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapppathgyService().delete(dos);
	}

	/**
	 * 转科对应的申请单相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdAptransdeptDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApTransDO.class, 
				this.getStrCondition(OrdApTransDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
	}

	/**
	 * 出院对应的申请单相关信息的删除*
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApoutDO(String strIdors) throws BizException {
		new DAFacade().deleteByWhere(OrdApOutDO.class, 
				this.getStrCondition(OrdApOutDODesc.TABLE_ALIAS_NAME, "id_or", strIdors));
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
