package iih.ci.mi.external.obtain.mi.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvRuleRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcDiDefDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleInParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcWholeRuleOutParamDTO;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;

/**
 * 获取医保规则校验结果
 * 
 * @author HUMS
 *
 */
public class GetMiRuleVerifyBP extends BasicMiVerifyBP{

	private ICidiagQryService diagService;
	private IMiMcRuleService miMcRuleService;

	public GetMiRuleVerifyBP() {
		miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
		diagService = ServiceFinder.find(ICidiagQryService.class);
	}

	public List<OrdRuleRstDTO> exec(CiEnContextDTO ctx, List<OrdRuleParamDTO> orderList) throws BizException {
			
		MiMcWholeRuleInParamDTO ruleParam = new MiMcWholeRuleInParamDTO();
		
		ruleParam.setId_ent(ctx.getId_en());
		ruleParam.setId_pat(ctx.getId_pat());
		ruleParam.setId_hp(ctx.getId_hp());
		ruleParam.setNo_hp(ctx.getNo_hp());
		if(this.isEmergencyDepartment(ctx)){
			ruleParam.setCode_entp("0101");
		}else{
			ruleParam.setCode_entp(ctx.getCode_entp());	
		}
		

		FArrayList miOrdList = new FArrayList();
		ruleParam.setCiorderlist(miOrdList);

		for (OrdRuleParamDTO order : orderList) {

			MiMcOrderDTO miOrder = new MiMcOrderDTO();
			miOrder.setId_or(order.getId_or());
			miOrder.setCode_or(order.getCode_or());
			miOrder.setName_or(order.getName_or());
			miOrder.setContent_or(order.getContent_or());

			miOrder.setSd_srvtp(order.getSd_srvtp());
			miOrder.setId_srv(order.getId_srv());
			miOrder.setCode_srv(order.getCode_srv());
			miOrder.setName_srv(order.getName_srv());
			miOrder.setQuan_days(order.getDays_or()); // 医嘱天数
			miOrder.setQuan_orders(order.getOrders()); // 草药医嘱付数
			miOrder.setDt_effe(order.getDt_effe());

			FArrayList ordSrvFList = new FArrayList();
			for (OrdSrvRuleParamDTO ordSrv : order.getOrdSrvRuleParamList()) {

				MiMcOrdSrvDTO miOrdSrv = new MiMcOrdSrvDTO();

				miOrdSrv.setId_dsdef(ordSrv.getId_dsdef());
				miOrdSrv.setCode_dsdef(ordSrv.getCode_dsdef());
				miOrdSrv.setName_dsdef(ordSrv.getName_dsdef());

				miOrdSrv.setSd_srvtp(ordSrv.getSd_srvtp());
				miOrdSrv.setId_srv(ordSrv.getId_srv());
				miOrdSrv.setCode_srv(ordSrv.getCode_srv());
				miOrdSrv.setName_srv(ordSrv.getName_srv());

				miOrdSrv.setId_mm(ordSrv.getId_mm());
				miOrdSrv.setCode_mm(ordSrv.getCode_mm());
				miOrdSrv.setName_mm(ordSrv.getName_mm());

				miOrdSrv.setId_freq(ordSrv.getId_freq());
				miOrdSrv.setId_dosage(ordSrv.getId_dosage());
				miOrdSrv.setDays_available(ordSrv.getDays_available());
				miOrdSrv.setFactor(ordSrv.getFactor());
				miOrdSrv.setFactor_mb(ordSrv.getFactor_mb());
				miOrdSrv.setQuan(ordSrv.getQuan_cur());
				miOrdSrv.setId_unit(ordSrv.getId_pgku_cur());
				miOrdSrv.setName_unit(ordSrv.getName_pgku_cur());
				
				miOrdSrv.setSpecdrug_flag(ordSrv.getFg_specill());
				
				ordSrvFList.add(miOrdSrv);
			}

			miOrder.setOrdsrvlist(ordSrvFList);
			miOrdList.add(miOrder);
		}

		FArrayList didefList = this.getMiDiags(ctx.getId_en());
		ruleParam.setCidilist(didefList);

		MiMcWholeRuleOutParamDTO miRuleRst = miMcRuleService.checkWholeRule(ruleParam);

		List<OrdRuleRstDTO> orderRstList = new ArrayList<OrdRuleRstDTO>();
		FArrayList errorItmList = miRuleRst.getErroritm_list();
		Map<String,MiMcOrdSrvResultDTO> miMcOrdSrvRstMap = new HashMap<String,MiMcOrdSrvResultDTO>();
		
		if(errorItmList != null && errorItmList.size() >0){
			for(Object obj : errorItmList){
				MiMcOrdSrvResultDTO ordSrvRst = (MiMcOrdSrvResultDTO)obj;
				miMcOrdSrvRstMap.put(ordSrvRst.getId_or(), ordSrvRst);
			}	
		}
		
		for (OrdRuleParamDTO order : orderList) {

			OrdRuleRstDTO ordRuleRst = new OrdRuleRstDTO();
			ordRuleRst.setId_or(order.getId_or());
			ordRuleRst.setCode_or(order.getCode_or());
			ordRuleRst.setName_or(order.getName_or());

			ordRuleRst.setSd_srvtp(order.getSd_srvtp());
			ordRuleRst.setId_srv(order.getId_srv());
			ordRuleRst.setCode_srv(order.getCode_srv());
			ordRuleRst.setName_srv(order.getName_srv());

			for (OrdSrvRuleParamDTO ordSrv : order.getOrdSrvRuleParamList()) {

				OrdSrvRuleRstDTO ordSrvRst = new OrdSrvRuleRstDTO();

				ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
				ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
				ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());

				ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
				ordSrvRst.setId_srv(ordSrv.getId_srv());
				ordSrvRst.setCode_srv(ordSrv.getCode_srv());
				ordSrvRst.setName_srv(ordSrv.getName_srv());

				ordSrvRst.setId_mm(ordSrv.getId_mm());
				ordSrvRst.setCode_mm(ordSrv.getCode_mm());
				ordSrvRst.setName_mm(ordSrv.getName_mm());
				
				MiMcOrdSrvResultDTO miMcOrdSrvRst = miMcOrdSrvRstMap.get(ordSrv.getId_or());
				if(miMcOrdSrvRst != null){
					ordSrvRst.setError_map(miMcOrdSrvRst.getError_map());
				}
				
				ordRuleRst.addChild(ordSrvRst);
			}

			orderRstList.add(ordRuleRst);
		}
		
		return orderRstList;
	}
	
	private OrdRuleRstDTO getDefaultOrdRuleRst(CiEnContextDTO ctx, OrdRuleParamDTO order){
		
		OrdRuleRstDTO ordRuleRst = new OrdRuleRstDTO();
		ordRuleRst.setId_or(order.getId_or());
		ordRuleRst.setCode_or(order.getCode_or());
		ordRuleRst.setName_or(order.getName_or());

		ordRuleRst.setSd_srvtp(order.getSd_srvtp());
		ordRuleRst.setId_srv(order.getId_srv());
		ordRuleRst.setCode_srv(order.getCode_srv());
		ordRuleRst.setName_srv(order.getName_srv());

		for (OrdSrvRuleParamDTO ordSrv : order.getOrdSrvRuleParamList()) {

			OrdSrvRuleRstDTO ordSrvRst = new OrdSrvRuleRstDTO();

			//miOrdSrv.setId_dsdef()
			//miOrdSrv.setCode_dsdef(Code_dsdef);
			//miOrdSrv.setName_dsdef(Name_dsdef);
			//miOrdSrv.setId_di

			ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());
			ordSrvRst.setId_srv(ordSrv.getId_srv());
			ordSrvRst.setCode_srv(ordSrv.getCode_srv());
			ordSrvRst.setName_srv(ordSrv.getName_srv());

			ordSrvRst.setId_mm(ordSrv.getId_mm());
			ordSrvRst.setCode_mm(ordSrv.getCode_mm());
			ordSrvRst.setName_mm(ordSrv.getName_mm());
			
			ordRuleRst.addChild(ordSrvRst);
		}
		
		return ordRuleRst;
	}

	protected FArrayList getMiDiags(String id_en) throws BizException {
		
		FArrayList diDefFList = new FArrayList();
		List<String> idDidefList = new ArrayList<String>();
		/*if (CiMiParamUtil.MHIR0001() != 1)
        {
            return diDefFList;
        }*/
		CidiagAggDO[] diagAggs = diagService.getLastCiDiags(id_en);
		for (CidiagAggDO diagAgg : diagAggs) {
			
			CiDiagItemDO[] diagItems = diagAgg.getCiDiagItemDO();
			
			if(diagItems == null || diagItems.length ==0){ // 清空诊断时，明细为空
				continue;
			}
			
			for (CiDiagItemDO diagItem : diagItems) {
				if (StringUtils.isEmpty(diagItem.getId_didef()) || idDidefList.contains(diagItem.getId_didef())) {
					continue;
				}

				MiMcDiDefDTO diDef = new MiMcDiDefDTO();

				diDef.setId_didef(diagItem.getId_didef());
				diDef.setCode_didef(diagItem.getDidef_code());
				diDef.setName_didef(diagItem.getDidef_name());
				diDef.setFg_haschronic(diagItem.getFg_chronic()); // 是否慢性病诊断 ,行动不便 医保平台根据 诊断名称判断
				diDefFList.add(diDef);
			}
		}
		return diDefFList;
	}

	@Override
	public boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		return true;
	}

}
