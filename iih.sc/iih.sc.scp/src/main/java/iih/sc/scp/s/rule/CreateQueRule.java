package iih.sc.scp.s.rule;

import iih.sc.scp.s.rule.bp.CreateQueBP;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.bizrule.IRule;

/**
 * 生成队列规则
 * 
 * @author liubin
 *
 * @param <T>
 */
public class CreateQueRule<T> implements IRule<T> {

	//原排班计划
	private T[] origins;
	
	public CreateQueRule(){}
	
	public CreateQueRule(T[] origins){
		this.origins = origins;
	}

	@Override
	public void process(T... arg0) throws BizException {
		CreateQueBP bp = new CreateQueBP();
		if(!ArrayUtil.isEmpty(origins)){
			for(T scPlanDo : origins){
				bp.exec((ScPlanDO) scPlanDo);
			}
		}
		if(!ArrayUtil.isEmpty(arg0)){
			for(T scPlanDo : arg0){
				bp.exec((ScPlanDO) scPlanDo);
			}
		}
	}

}
