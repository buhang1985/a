package iih.bl.prop.service.s;

import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.service.bp.saveProp;
import iih.bl.prop.service.i.IBLPropMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IBLPropMaintainService.class}, binding=Binding.JSONRPC)
public class IBLPropMaintainServiceImpl implements IBLPropMaintainService{

	/**
	 * 保存门诊分摊数据
	 */
	@Override
	public FMap2 saveOepProp(BlPropOepDO[] blPropOepDOArr,
			BlproparoepAggDO[] blproparoepAggDOArr) throws BizException {
		saveProp bp=new saveProp();
		return bp.saveOepProp(blPropOepDOArr, blproparoepAggDOArr);	
	}

}
