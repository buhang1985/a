package iih.ci.mi.external.obtain.mi.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.mi.ord.i.meta.OrdIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdIndicRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicParamDTO;
import iih.ci.mi.ord.i.meta.OrdSrvIndicRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationInParamDTO;
import iih.mi.mc.dto.mimcindicationrule.d.MiMcIndicationOutParamDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcDiDefDTO;
import iih.mi.mc.i.IMiMcRuleService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保适应症校验结果
 * 
 * @author HUMS
 *
 */
public class GetMiIndicVerifyBP extends BasicMiVerifyBP{

	private ICidiagQryService diagService;
	private IMiMcRuleService miMcRuleService;

	public GetMiIndicVerifyBP() {
		miMcRuleService = ServiceFinder.find(IMiMcRuleService.class);
		diagService = ServiceFinder.find(ICidiagQryService.class);
	}

	public List<OrdIndicRstDTO> exec(CiEnContextDTO ctx, List<OrdIndicParamDTO> orderList) throws BizException {

		List<OrdIndicRstDTO> ordIndicRstList = new ArrayList<OrdIndicRstDTO>();
		List<MiMcIndicationInParamDTO> indicParamList = new ArrayList<MiMcIndicationInParamDTO>();

		Map<String,OrdSrvIndicParamDTO> ordSrvIndicParamMap = new HashMap<String,OrdSrvIndicParamDTO>();
		FArrayList miMcDiDefList = this.getMiDiags(ctx.getId_en());
				
		for (OrdIndicParamDTO order : orderList) {

			for (OrdSrvIndicParamDTO ordSrv : order.getOrdSrvIndicParamList()) {

				ordSrvIndicParamMap.put(ordSrv.getKey(), ordSrv);
				
				// 非费用项目，自定义服务，自备药不需要进行医保判断
				if(!FBoolean.TRUE.equals(ordSrv.getFg_indicverify())){
					continue;
				}
				
				// 药品适应症在前台已经判断
				if(order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					if (HpJudgeRstEnum.SELFPAY.equals(ordSrv.getEu_orsrvhp()) || HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())) {
						continue;
					}
				}
				
				MiMcIndicationInParamDTO indicParam = new MiMcIndicationInParamDTO();

				indicParam.setId_ent(ctx.getId_en());
				indicParam.setId_hp(ctx.getId_hp());
				if(this.isEmergencyDepartment(ctx)){
					indicParam.setCode_entp("0101");	
				}else{
					indicParam.setCode_entp(ctx.getCode_entp());	
				}
				

				indicParam.setId_or(order.getId_or());
				indicParam.setCode_or(order.getCode_or());
				indicParam.setName_or(order.getName_or());

				indicParam.setId_orsrv(ordSrv.getId_orsrv());

				indicParam.setSd_srvtp(ordSrv.getSd_srvtp());

				indicParam.setId_srv(ordSrv.getId_srv());
				indicParam.setCode_srv(ordSrv.getCode_srv());
				indicParam.setName_srv(ordSrv.getName_srv());

				indicParam.setId_mm(ordSrv.getId_mm());
				indicParam.setCode_mm(ordSrv.getCode_mm());
				indicParam.setName_mm(ordSrv.getName_mm());

				indicParam.setEu_orsrvhp(ordSrv.getEu_orsrvhp());
				indicParam.setPrice(ordSrv.getPrice());

				indicParam.setId_dsdef(ordSrv.getId_dsdef());
				indicParam.setCode_dsdef(ordSrv.getCode_dsdef());
				indicParam.setName_dsdef(ordSrv.getName_dsdef());
				
				indicParam.setEu_orsrvhp(ordSrv.getEu_orsrvhp());

				indicParam.setCi_di_itms(miMcDiDefList);
				
				

				indicParamList.add(indicParam);
			}
		}
		
		
		Map<String, MiMcIndicationOutParamDTO> miIndicMap = new HashMap<String, MiMcIndicationOutParamDTO>();
		if(indicParamList.size() >0){
			
			MiMcIndicationOutParamDTO[] miIndics = miMcRuleService
					.checkIndicationRule(indicParamList.toArray(new MiMcIndicationInParamDTO[indicParamList.size()]));
			
			for (MiMcIndicationOutParamDTO miIndic : miIndics) {
				miIndicMap.put(miIndic.getId_srv() + StringUtils.trimToEmpty(miIndic.getId_mm()), miIndic);
			}
		}

		for (OrdIndicParamDTO order : orderList) {
			OrdIndicRstDTO ordIndicRst = getDefaultOrdIndicRst(ctx, order);
			for (OrdSrvIndicRstDTO ordSrvRst : ordIndicRst.getOrdSrvIndicRstList()) {			

				MiMcIndicationOutParamDTO miIndic = miIndicMap.get(ordSrvRst.getKey());
				if(miIndic != null){
					
					if(StringUtils.isEmpty(miIndic.getCode_hpindicjudged()) || "21".equals(miIndic.getCode_hpindicjudged()) || "12".equals(miIndic.getCode_hpindicjudged())){
						ordSrvRst.setEu_hpjudge(HpJudgeEnum.WAITING_JUDGE);
						ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.WAITING_JUDGE);
					}else{
						ordSrvRst.setEu_hpjudge(HpJudgeEnum.SYSTEM_JUDGE);
						ordSrvRst.setEu_orsrvhp(miIndic.getEu_orsrvhp());
					}
					ordSrvRst.setDes_limit(miIndic.getDes_limit());
				}else{
					OrdSrvIndicParamDTO ordSrv = ordSrvIndicParamMap.get(ordSrvRst.getKey());
					
					if(!FBoolean.TRUE.equals(ordSrv.getFg_indicverify())){
						
						ordSrvRst.setEu_hpjudge(HpJudgeEnum.NOT_JUDGE);
						ordSrvRst.setEu_orsrvhp(HpJudgeRstEnum.NOT_JUDGE);
						
						if(!FBoolean.TRUE.equals(ordSrv.getFg_bl())){
							ordSrvRst.setEu_hpjudge(HpJudgeEnum.NON_BLITEM);	
						}
						
						ordSrvRst.setDes_limit("非费用项不进行医保判断!");
					}else{
						ordSrvRst.setEu_hpjudge(ordSrv.getEu_hpjudge());
						ordSrvRst.setEu_orsrvhp(ordSrv.getEu_orsrvhp());
						//ordSrvRst.setDes_limit(ordSrv.getDes_limit());
					}					
					
				}
			}
			
			ordIndicRstList.add(ordIndicRst);
		}

		return ordIndicRstList;
	}

	/**
	 * 获取就诊诊断
	 * 
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	protected FArrayList getMiDiags(String id_en) throws BizException {

		FArrayList diDefFList = new FArrayList();
		List<String> idDidefList = new ArrayList<String>();

		// 病种模式时，不传入诊断
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
				// 自定义诊断，id_didef为空
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

	/**
	 * 获取医保适应症默认返回对象
	 * 
	 * @param ctx
	 * @param order
	 * @return
	 */
	private OrdIndicRstDTO getDefaultOrdIndicRst(CiEnContextDTO ctx, OrdIndicParamDTO order) {

		OrdIndicRstDTO ordIndicRst = new OrdIndicRstDTO();

		ordIndicRst.setId_en(ctx.getId_en());
		ordIndicRst.setId_hp(ctx.getId_hp());
		if(this.isEmergencyDepartment(ctx)){
			ordIndicRst.setCode_entp("0101");
		}else{
			ordIndicRst.setCode_entp(ctx.getCode_entp());	
		}
		
		ordIndicRst.setId_or(order.getId_or());
		ordIndicRst.setCode_or(order.getCode_or());
		ordIndicRst.setName_or(order.getName_or());

		for (OrdSrvIndicParamDTO ordSrv : order.getOrdSrvIndicParamList()) {

			OrdSrvIndicRstDTO ordSrvRst = new OrdSrvIndicRstDTO();

			ordSrvRst.setId_orsrv(ordSrv.getId_orsrv());

			ordSrvRst.setSd_srvtp(ordSrv.getSd_srvtp());

			ordSrvRst.setId_srv(ordSrv.getId_srv());
			ordSrvRst.setCode_srv(ordSrv.getCode_srv());
			ordSrvRst.setName_srv(ordSrv.getName_srv());

			ordSrvRst.setId_mm(ordSrv.getId_mm());
			ordSrvRst.setCode_mm(ordSrv.getCode_mm());
			ordSrvRst.setName_mm(ordSrv.getName_mm());

			ordSrvRst.setId_dsdef(ordSrv.getId_dsdef());
			ordSrvRst.setCode_dsdef(ordSrv.getCode_dsdef());
			ordSrvRst.setName_dsdef(ordSrv.getName_dsdef());
			
			ordIndicRst.addChild(ordSrvRst);
		}

		return ordIndicRst;
	}

	@Override
	public boolean isEnabledVerify(CiEnContextDTO ctx) throws BizException {

		// 暂时没用
		return true;
	}
}
