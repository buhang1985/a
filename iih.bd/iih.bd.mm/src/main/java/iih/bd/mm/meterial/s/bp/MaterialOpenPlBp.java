package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MaterialOpenPlBp {

	public MeterialDO[] exec(MeterialDO[] materials, boolean b) throws BizException {
		for(MeterialDO mmDo : materials) {
			mmDo.setFg_stop_mmpo(new FBoolean(b));
			mmDo.setStatus(DOStatus.UPDATED);
		}
		IMeterialMDOCudService meterialMDOCudService = ServiceFinder.find(IMeterialMDOCudService.class);
		MeterialDO[] result = meterialMDOCudService.save(materials);
		return result;
	}

}
