package iih.bl.hp.hpentcode.s.rule;

import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.bizrule.IRule;

/**
 * 保存前校验
 * @author hanjq
 */
public class IpInsertBeforeRule implements IRule<HpEntCodeDO> {

	@Override
	public void process(HpEntCodeDO... array) throws BizException {
		if(ArrayUtil.isEmpty(array))
			return;
		addEmpAndDt(array);
	}
	
	/**
	 * 添加操作人和操作时间
	 * @param array
	 */
	private void addEmpAndDt(HpEntCodeDO[] array){
		String idEmp = Context.get().getStuffId();
		FDateTime dt = new FDateTime();
		for(HpEntCodeDO itm:array){
			if(DOStatus.NEW == itm.getStatus()){
				itm.setId_emp_act(idEmp);
				itm.setDt_act(dt);
			}
		}
	}

}
