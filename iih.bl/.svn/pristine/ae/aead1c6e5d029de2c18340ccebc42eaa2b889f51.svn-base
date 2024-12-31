package iih.bl.hp.hpentcodeoep.s;

import iih.bl.hp.hpentcodeoep.d.HpEntCodeOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.bizrule.IRule;

public class OepInsertBeforeRule implements IRule<HpEntCodeOepDO> {

	@Override
	public void process(HpEntCodeOepDO... array) throws BizException {
		if(ArrayUtil.isEmpty(array))
			return;
		addEmpAndDt(array);
	}

	/**
	 * 添加操作人和操作时间
	 * @param array
	 */
	private void addEmpAndDt(HpEntCodeOepDO[] array){
		String idEmp = Context.get().getStuffId();
		FDateTime dt = new FDateTime();
		for(HpEntCodeOepDO itm:array){
			if(DOStatus.NEW == itm.getStatus()){
				itm.setId_emp_act(idEmp);
				itm.setDt_act(dt);
			}
		}
	}
}
