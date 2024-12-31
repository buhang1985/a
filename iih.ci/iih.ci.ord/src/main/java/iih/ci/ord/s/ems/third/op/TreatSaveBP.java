package iih.ci.ord.s.ems.third.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.thirdparam.ChargeForCiParamDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.third.MpOrderFeeAction;
import iih.ci.ord.s.ems.third.base.OrderPakageInfo;
import iih.ci.ord.s.ems.third.def.DefaultTreatCreateOrderInfo;
import iih.ci.ord.s.ems.utils.CiEnContextUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
/**
 * 治疗类的保存
 * @author zhangwq
 *
 */
public class TreatSaveBP {
	private FDateTime now;
	public List<ThirdRstDTO> exec(PatiVisitDO pat, ChargeForCiParamDTO[] params, DefaultCreateParam[] defaultparam)
			throws BizException {
		now = new FDateTime();
		DefaultTreatCreateOrderInfo defaultTreat = new DefaultTreatCreateOrderInfo();
		CiEnContextUtils enContexxt = new CiEnContextUtils();
		CiEnContextDTO ctx = enContexxt.getCiEnContextDTO(pat);
		ctx.setId_dep_or(pat.getId_dep_phy());
		Context.get().setAttribute("CiEnContextDTO",ctx);
		OrderPakageInfo[] szOrderPakageInfo = defaultTreat.createOrdeAggInfo(ctx,
				defaultparam);
		Map<String, ChargeForCiParamDTO> tempChargeMap = new HashMap<String, ChargeForCiParamDTO>();
		List<ThirdRstDTO> rsts = new ArrayList<ThirdRstDTO>();
		for (ChargeForCiParamDTO dto : params) {
			tempChargeMap.put(dto.getId_srv(), dto);
		}
		// 给总量赋值
		handleUserParameter(szOrderPakageInfo, tempChargeMap);
		MpOrderFeeAction mp = new MpOrderFeeAction();
		for(OrderPakageInfo pakage : szOrderPakageInfo){
			ThirdRstDTO rst = mp.save(new CiorderAggDO[] { pakage.getOrderAggInfo() });
			rsts.add(rst);
		}
		
		return rsts;
	}

	/**
	 * 给总量赋值
	 * 
	 * @param szOrderPakageInfo
	 * @param tempChargeMap
	 */
	private void handleUserParameter(OrderPakageInfo[] szOrderPakageInfo,
			Map<String, ChargeForCiParamDTO> tempChargeMap) {
		for (OrderPakageInfo opInfo : szOrderPakageInfo) {
			CiOrderDO order = opInfo.getOrderAggInfo().getParentDO();
			order.setDt_effe(now);
			order.setDt_end(now);
			order.setDt_entry(now);
			order.setDt_last_bl(now);
			order.setFg_sign(FBoolean.TRUE);
			order.setDt_sign(now);
			OrdSrvDO[] results = opInfo.getOrderAggInfo().getOrdSrvDO();
			if (!CiOrdUtils.isEmpty(results)) {
				for (OrdSrvDO srv : results) {
					srv.setDt_create(now);
					srv.setDt_last_bl(now);
					if (tempChargeMap.containsKey(srv.getId_srv())) {
						srv.setQuan_total_medu(new FDouble(tempChargeMap.get(srv.getId_srv()).getQuan()));
						srv.setPri(tempChargeMap.get(srv.getId_srv()).getPrice());
						srv.setPri_ratio(new FDouble(1));
						srv.setPri_std(tempChargeMap.get(srv.getId_srv()).getPrice());
						srv.setEu_blmd(1);
					}
				}
			}
			List<OrdSrvMmDO> mms = opInfo.getOrderSrvMmList();
			if (!CiOrdUtils.isEmpty(mms)) {
				for (OrdSrvMmDO mm : mms) {
					if (tempChargeMap.containsKey(mm.getId_srv())) {
						mm.setQuan_cur(new FDouble(tempChargeMap.get(mm.getId_srv()).getQuan()));
					}
				}
			}
		}
	}

}
