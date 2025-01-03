package iih.ci.ord.s.bp.ems.hp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.mysql.jdbc.StringUtils;

import iih.ci.mi.ord.i.ICiMiOrdRService;
import iih.ci.mi.ord.i.meta.OrdRuleParamDTO;
import iih.ci.mi.ord.i.meta.OrdRuleRstDTO;
import iih.ci.mi.ord.i.meta.OrdSrvRuleParamDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保开单规则校验
 * @author HUMS
 *
 */
public class GetMiRuleVerifyRstBP {

	private ICiMiOrdRService ciMiOrdRService ; 
	public GetMiRuleVerifyRstBP(){
		ciMiOrdRService = ServiceFinder.find(ICiMiOrdRService.class);
	}
	
	public OrdRuleRstDTO getMiRuleRst(CiEnContextDTO ctx, CiOrAggAndRelDatum orAggAndRelDatum) throws BizException{
		
		List<OrdRuleParamDTO> orderList = null;
		FMap ordSrvMmMap = null;
		
		CiorderAggDO orderAgg = orAggAndRelDatum.getOraggdo();
		OrdRuleParamDTO ordRule = this.getOrdRuleParam(ctx,orderAgg);
		
		if(ordRule.getChildSzie() == 0 ){
			return null;
		}
		
		if (!CiOrdUtils.isEmpty(orAggAndRelDatum.getOrattachht()))
			ordSrvMmMap = (FMap) orAggAndRelDatum.getOrattachht().get(OrdSrvMmDODesc.CLASS_FULLNAME);
	
		// 存在物品
		if(ordSrvMmMap != null ){			
			for(OrdSrvRuleParamDTO ordSrvRule : ordRule.getOrdSrvRuleParamList()){
				String tempKey = ordSrvRule.getId_srv() + "_"+ ordSrvRule.getId_mm();
				if(!ordSrvMmMap.containsKey(tempKey)){
					continue;
				}
				OrdSrvMmDO ordSrvMm = ((List<OrdSrvMmDO>)ordSrvMmMap.get(tempKey)).get(0);			
				this.setOrdSrvMmInfo(ordSrvRule, ordSrvMm);			
			}
		}

		orderList = new ArrayList<OrdRuleParamDTO>();
		orderList.add(ordRule);
		List<OrdRuleRstDTO> orderRstList = ciMiOrdRService.checkWholeRule(ctx, orderList);
		return orderRstList.get(0);
	}
	
	/**
	 * 医嘱签署时调用开单校验
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	public List<OrdRuleRstDTO>  getMiRuleRst(CiEnContextDTO ctx, CiorderAggDO[] ordAggs) throws BizException{
		
		List<OrdRuleParamDTO> orderList = new ArrayList<OrdRuleParamDTO>();
		
		Map<String,OrdSrvMmDO> ordSrvMmMap = this.getOrdSrvMmMap(ctx, ordAggs);
		
		for(CiorderAggDO orderAgg : ordAggs){
			OrdRuleParamDTO ordRule = this.getOrdRuleParam(ctx,orderAgg);
			
			// 存在物品
			if(ordSrvMmMap != null ){
				
				for(OrdSrvRuleParamDTO ordSrvRule : ordRule.getOrdSrvRuleParamList()){
					
					OrdSrvMmDO ordSrvMm = ordSrvMmMap.get(ordSrvRule.getId_orsrv());			
				
					this.setOrdSrvMmInfo(ordSrvRule, ordSrvMm);
				
				}
			}
			
			
			orderList.add(ordRule);
		}
		
		List<OrdRuleRstDTO> orderRstList = ciMiOrdRService.checkWholeRule(ctx, orderList);
		return orderRstList;
	}

	/**
	 * 获取规则校验医和嘱服务项目对象
	 * @param ctx
	 * @param orderAgg
	 * @return
	 */
	private OrdRuleParamDTO getOrdRuleParam(CiEnContextDTO ctx, CiorderAggDO orderAgg){
		
		CiOrderDO order = orderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
		
		OrdRuleParamDTO ordRule = new OrdRuleParamDTO();
		
		String id_or = order.getId_or();
		if(StringUtils.isNullOrEmpty(id_or)){
			id_or =UUID.randomUUID().toString();
		}
		
		ordRule.setId_or(id_or);
		ordRule.setCode_or(order.getCode_or());
		ordRule.setName_or(order.getName_or());
		ordRule.setSd_srvtp(order.getSd_srvtp());
		ordRule.setId_srv(order.getId_srv());
		ordRule.setDays_or(order.getDays_or());
		ordRule.setOrders(order.getOrders());
		//0196006: 【验证版】医保患者皮试医嘱签署报错
		//皮试医嘱不做开单校验
		if (FBoolean.TRUE.equals(order.getFg_skintest())) {
			return ordRule;
		}
		for(OrdSrvDO ordSrv : ordSrvs){
			
			if(ordSrv.getId_srv().equals(ordRule.getId_srv())){
				ordRule.setCode_srv(ordSrv.getCode_srv());
				ordRule.setName_srv(ordSrv.getName_srv());
			}
			
			if(ordSrv.getStatus() == DOStatus.DELETED || !FBoolean.TRUE.equals(ordSrv.getFg_bl())){
				continue;					
			}
			
			if(FBoolean.TRUE.equals(ordSrv.getFg_self())){
				continue;
			}
			
			// 费用关联出来的药品不做开单校验，费用关联出来的物品，fg_or=N 
			if(!FBoolean.TRUE.equals(ordSrv.getFg_or()) && FBoolean.TRUE.equals(ordSrv.getFg_mm())){
				continue;
			}
			
			// 自费的，或者不需要判断（科研、不计费医嘱）的不处理
			/*if(HpJudgeRstEnum.NOT_JUDGE.equals(ordSrv.getEu_orsrvhp()) ||HpJudgeRstEnum.SELFPAY.equals(ordSrv.getEu_orsrvhp())){
				continue;
			}*/
			// 非医保项，不需要做医保规则校验
			if(!HpJudgeRstEnum.HP.equals(ordSrv.getEu_orsrvhp())){
				continue;
			}
			
			OrdSrvRuleParamDTO ordSrvRule = new OrdSrvRuleParamDTO();
									
			ordSrvRule.setId_or(id_or);
			ordSrvRule.setId_orsrv(ordSrv.getId_orsrv());
			ordSrvRule.setSd_srvtp(ordSrv.getSd_srvtp());
			
			ordSrvRule.setId_srv(ordSrv.getId_srv());
			ordSrvRule.setCode_srv(ordSrv.getCode_srv());
			ordSrvRule.setName_srv(ordSrv.getName());
			ordSrvRule.setPrice(ordSrv.getPri());
			
			ordSrvRule.setId_dsdef(ordSrv.getId_dsdef());
			ordSrvRule.setCode_dsdef(ordSrv.getCode_dsdef());
			ordSrvRule.setName_dsdef(ordSrv.getName_dsdef());
			
			ordSrvRule.setId_mm(ordSrv.getId_mm());
			ordSrvRule.setFg_mm(ordSrv.getFg_mm());
			ordSrvRule.setFg_specill(ordSrv.getFg_specill());			
			
			ordRule.addChild(ordSrvRule);
		}
		
		return ordRule;
	}
	
	/**
	 * 设置服务项目物品信息
	 * @param ordSrvRule
	 * @param ordSrvMm
	 */
	private void setOrdSrvMmInfo(OrdSrvRuleParamDTO ordSrvRule, OrdSrvMmDO ordSrvMm){
		
		if(!FBoolean.TRUE.equals(ordSrvRule.getFg_mm())){
			return ;
		}
		
		ordSrvRule.setId_mm(ordSrvMm.getId_mm());
		ordSrvRule.setCode_mm(ordSrvMm.getCode_mm());
		ordSrvRule.setName_mm(ordSrvMm.getName_mm());
		ordSrvRule.setId_dosage(ordSrvMm.getId_dosage());
		ordSrvRule.setDays_available(ordSrvMm.getDays_available());
		ordSrvRule.setFactor(ordSrvMm.getFactor());
		ordSrvRule.setFactor_mb(ordSrvMm.getFactor_mb());
		ordSrvRule.setPrice(ordSrvMm.getPrice_pgku_cur());
		ordSrvRule.setQuan_cur(ordSrvMm.getQuan_cur());
		ordSrvRule.setId_pgku_cur(ordSrvMm.getId_pgku_cur());
		ordSrvRule.setName_pgku_cur(ordSrvMm.getName_pgku_cur());
	}
	
	
	/**
	 * 获取医疗服务物品信息
	 * @param ctx
	 * @param ordAggs
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrdSrvMmDO> getOrdSrvMmMap(CiEnContextDTO ctx, CiorderAggDO[] ordAggs) throws BizException{
		
		IOrdsrvmmRService ordSrvMmRService = ServiceFinder.find(IOrdsrvmmRService.class);

		StringBuffer idOrSrvBuffer = new StringBuffer();
		
		Map<String,OrdSrvMmDO> ordSrvMmMap = new HashMap<String,OrdSrvMmDO>();
		for(CiorderAggDO orderAgg : ordAggs){
			OrdSrvDO[] ordSrvs = orderAgg.getOrdSrvDO();
			for(OrdSrvDO ordSrv : ordSrvs){
				if(FBoolean.TRUE.equals(ordSrv.getFg_mm()) && FBoolean.TRUE.equals(ordSrv.getFg_or())){
					idOrSrvBuffer.append(",'"+ordSrv.getId_orsrv()+"'");	
				}
			}
		}
		
		if(idOrSrvBuffer.length()>0){
			OrdSrvMmDO[] ordSrvMms = ordSrvMmRService.find("id_orsrv in ("+idOrSrvBuffer.substring(1) +")",null,FBoolean.TRUE);
			for(OrdSrvMmDO ordSrvMm : ordSrvMms){
				ordSrvMmMap.put(ordSrvMm.getId_orsrv(), ordSrvMm);
			}
		}
		
		return ordSrvMmMap;
	}
}
