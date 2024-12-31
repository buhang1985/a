package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class MaterialReAfterBp {
	
	public void exec(MeterialAggDO[] mmAggDOS) throws BizException {
		
		if(mmAggDOS == null || mmAggDOS.length <= 0) {
			
			return;
		}
		
		// ■ 医疗服务关联信息设置
		this.setupDOAfterSearch(mmAggDOS);
	}

	private void setupDOAfterSearch(MeterialAggDO[] mmAggDOS) throws BizException {
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		
		List<MeterialDO> mmDOS = new ArrayList<MeterialDO>();
		for(MeterialAggDO mmAggDO : mmAggDOS) {
			
			mmDOS.add(mmAggDO.getParentDO());
		}
		meterialService.getMedSrvInfo(mmDOS.toArray(new MeterialDO[mmDOS.size()]));
	}
}
