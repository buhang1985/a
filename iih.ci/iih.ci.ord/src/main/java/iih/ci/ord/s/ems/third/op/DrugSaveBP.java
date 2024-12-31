package iih.ci.ord.s.ems.third.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrOpSessionInsertBP;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitMpHandleBP;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.base.BaseSaveBP;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.third.def.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.utils.CiEnContextUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
/**
 * 小his系统，开立药品服务 处方类型修改为@@@@
 * @author zhangwq
 *
 */
public class DrugSaveBP extends BaseSaveBP{
	private FDateTime now;
	/**
	 * 药品类的保存
	 * @param pat
	 * @param params
	 * @param defaultparam
	 * @return
	 * @throws BizException
	 */
	public List<ThirdRstDTO> exec(PatiVisitDO pat, ChargeForCiParamDTO[] params, DefaultCreateParam[] defaultparam)
			throws BizException {
		now = new FDateTime();
		DefaultDrugsCreateOrderInfo defaultDrug = new DefaultDrugsCreateOrderInfo();
		CiEnContextUtils enContexxt = new CiEnContextUtils();
		CiEnContextDTO ctx = enContexxt.getCiEnContextDTO(pat);
		Context.get().setAttribute("CiEnContextDTO",ctx);
		OrderPakageInfo[] szOrderPakageInfo = defaultDrug.createOrdeAggInfo(ctx,defaultparam);
		Map<String, ChargeForCiParamDTO> tempChargeMap = new HashMap<String, ChargeForCiParamDTO>();
		List<ThirdRstDTO> rsts = new ArrayList<ThirdRstDTO>();
		for (ChargeForCiParamDTO dto : params) {
			tempChargeMap.put(dto.getId_srv(), dto);
		}
		FArrayList orderList = new FArrayList();
		// 给总量赋值
		handleUserParameter(szOrderPakageInfo, tempChargeMap);
		for (OrderPakageInfo opInfo : szOrderPakageInfo) {
			// 保存医嘱
			CiorderAggDO[] szRstOrderAggInfo = CiOrdAppUtils.getOrAggService()
					.save(new CiorderAggDO[] { opInfo.getOrderAggInfo() });
			// 保存物品信息
			if (opInfo.getOrderSrvMmList() != null && opInfo.getOrderSrvMmList().size() > 0) {
				OrdSrvMmDO[] szOrdSrvMmDO = CiOrdAppUtils.getOrsrvmmService()
						.save(updateOrderSrvMMInfo(szRstOrderAggInfo[0].getOrdSrvDO(), opInfo.getOrderSrvMmList()));
				CiPresDO[] preses = CiOrdAppUtils.getCiPresService().save(new CiPresDO[] { createCiPres(pat,
						szRstOrderAggInfo[0].getParentDO(), szRstOrderAggInfo[0].getOrdSrvDO()[0], szOrdSrvMmDO[0],saveCiOrSession(szRstOrderAggInfo[0].getParentDO())) });
				// 更新srv中的处方id
				szRstOrderAggInfo[0].getOrdSrvDO()[0].setId_pres(preses[0].getId_pres());
				szRstOrderAggInfo[0].getOrdSrvDO()[0].setStatus(DOStatus.UPDATED);
				CiOrdAppUtils.getOrSrvService().save(new OrdSrvDO[] { szRstOrderAggInfo[0].getOrdSrvDO()[0] });
				this.ciOrPresSplitMpHandle(preses);
				for(CiorderAggDO aggDO: szRstOrderAggInfo) {
					orderList.add(aggDO);
				}
			}
			ThirdRstDTO rst = new ThirdRstDTO();
			rst.setSuccessful(FBoolean.TRUE);
			rst.setOrderAggInfoList(orderList);
			rsts.add(rst);
		}
		return rsts;
	}

	private CiPresDO createCiPres(PatiVisitDO pat, CiOrderDO order, OrdSrvDO srv, OrdSrvMmDO mm,CiOrSessionDO session) throws BizException {
		CiPresDO pres = new CiPresDO();
		pres.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_MZCFJ);
		pres.setSd_prestp(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MZCFJ);
		pres.setFg_vip(FBoolean.FALSE);
		
		String code_cg= CiOrdUtils.generatePresNo(order.getId_en());
		pres.setCode(code_cg);
		pres.setId_session(session.getId_ciorsession());
		pres.setId_entp(order.getId_entp());
		pres.setCode_entp(order.getCode_entp());
		pres.setId_grp(order.getId_grp());
		pres.setId_org(order.getId_org());
		pres.setId_en(order.getId_en());
		pres.setId_pati(order.getId_pat());
		pres.setId_srvtp(order.getId_srvtp());
		pres.setSd_srvtp(order.getSd_srvtp());
		pres.setId_dep_or(order.getId_dep_or());
		pres.setId_dep_mp(order.getId_dep_mp());
		pres.setId_emp_or(order.getId_emp_or());
		pres.setId_emp(order.getId_emp_or());
		pres.setFg_base(srv.getFg_base());
		pres.setFg_bb(order.getFg_bb());
		pres.setId_route(order.getId_route());
		pres.setId_routedes(order.getId_routedes());
		pres.setDt_entry(order.getDt_entry());
		pres.setFg_hp_pres(FBoolean.FALSE);
		pres.setStatus(DOStatus.NEW);
		return pres;
	}

	/**
	 * 给总量赋值
	 * 
	 * @param szOrderPakageInfo
	 * @param tempChargeMap
	 */
	protected void handleUserParameter(OrderPakageInfo[] szOrderPakageInfo,
			Map<String, ChargeForCiParamDTO> tempChargeMap) {
		for (OrderPakageInfo opInfo : szOrderPakageInfo) {
			opInfo.getOrderAggInfo().getParentDO().setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);
			opInfo.getOrderAggInfo().getParentDO().setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);
			opInfo.getOrderAggInfo().getParentDO().setDt_last_bl(now);
			opInfo.getOrderAggInfo().getParentDO().setFg_sign(FBoolean.TRUE);
			opInfo.getOrderAggInfo().getParentDO().setDt_sign(now);
			opInfo.getOrderAggInfo().getParentDO().setDt_effe(now);
			OrdSrvDO[] results = opInfo.getOrderAggInfo().getOrdSrvDO();
			if (!CiOrdUtils.isEmpty(results)) {
				for (OrdSrvDO srv : results) {
					if (tempChargeMap.containsKey(srv.getId_srv())) {
						srv.setQuan_total_medu(new FDouble(tempChargeMap.get(srv.getId_srv()).getQuan()));
					}
				}
			}
			List<OrdSrvMmDO> mms = opInfo.getOrderSrvMmList();
			if (!CiOrdUtils.isEmpty(mms)) {
				for (OrdSrvMmDO mm : mms) {
					if (tempChargeMap.containsKey(mm.getId_srv())) {
						mm.setQuan_cur(new FDouble(tempChargeMap.get(mm.getId_srv()).getQuan()));
						mm.setPrice_pgku_cur(tempChargeMap.get(mm.getId_srv()).getPrice());
						mm.setId_pgku_cur(tempChargeMap.get(mm.getId_srv()).getId_unit_pkg());
					}
				}
			}
		}
	}
	/**
	 * 创建处方发药状态
	 * @param ciorder
	 * @return
	 * @throws BizException
	 */
	private CiOrSessionDO saveCiOrSession(CiOrderDO ciorder) throws BizException{
		//创建门诊医嘱会话区间
		CiOrOpSessionInsertBP bpSession = new CiOrOpSessionInsertBP();
		return bpSession.exec(new CiOrderDO[]{ciorder}, now);
	}
	/**
	 * 临床医嘱处方分方后执行域相关处理
	 * @param cipres
	 * @throws BizException
	 */
	private void ciOrPresSplitMpHandle(CiPresDO[] cipres) throws BizException{
		CiOrPresSplitMpHandleBP bp=new CiOrPresSplitMpHandleBP();
		bp.exec(cipres);
	}
}
