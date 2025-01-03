package iih.ci.ord.s.bp.cfg.rulecfg.validator.drug.excessive;

import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.cfg.RuleCfgConstant;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
 * 超额开单校验(处方金额大于500时，提示填写超额开单原因)
 * @author zhangwq
 *
 */
public class MoreMoneyReasonValidator extends AbstractExcessiveDrugValidator{
	private int maxmoney;
	@Override
	protected boolean validate(CiEmsDTO ciEms) {
		FArrayList emssrvs = ciEms.getEmssrvs();
		FDouble totalPri = new FDouble(0);
		for(Object srvObj : emssrvs){
			CiEmsSrvDTO ciEmsSrvDTO = (CiEmsSrvDTO)srvObj;
			//临床项目费用 (不记自备药费用)
			if((ciEmsSrvDTO.getFg_self()== null || !ciEmsSrvDTO.getFg_self().booleanValue()) && FBoolean.TRUE.equals(ciEmsSrvDTO.getFg_mm())&&DOStatus.DELETED!=ciEmsSrvDTO.getStatus()&&FBoolean.TRUE.equals(ciEmsSrvDTO.getFg_bl())&&(OrSrvSourceFromEnum.PHYSIAN.equals(ciEmsSrvDTO.getEu_sourcemd())||OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(ciEmsSrvDTO.getEu_sourcemd())
					||OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(ciEmsSrvDTO.getEu_sourcemd()))){
				if(ciEmsSrvDTO.getPrice()!=null){
					totalPri = totalPri.add(new FDouble((ciEmsSrvDTO.getPrice()==null?new FDouble(0):ciEmsSrvDTO.getPrice()).multiply((ciEmsSrvDTO.getQuan_total_medu()==null?new FDouble(0):ciEmsSrvDTO.getQuan_total_medu())).doubleValue(),2));
				}
			}
		}
		if(this.cfgJsonResult.containsKey("maxMoney")){
			maxmoney=Integer.parseInt(this.cfgJsonResult.getString("maxMoney"));
		}else{
			maxmoney=500;
		}
		
		if(totalPri.compareTo(new FDouble(maxmoney))>0&&CiOrdUtils.isEmpty(ciEms.getMore_money_reason())){
			this.ruleMsg.setContent(this.getExcessiveReasonMsg());
			this.ruleMsg.getExt_content().put(RuleCfgConstant.MAX_MONEY, maxmoney);
			return false;
		}
		return true;
	}
	@Override
	protected boolean isConformToTheRules(CiEmsDTO ciEms) {
		
		return false;
	}

	@Override
	protected String getExcessiveReasonIdentity() {
		return null;
	}

	@Override
	protected String getExcessiveReasonMsg() {
		return "处方金额大于"+maxmoney+",请填写超额开单原因";
	}

	@Override
	protected int getDefaultUseDays() {
		return 0;
	}
	
}
