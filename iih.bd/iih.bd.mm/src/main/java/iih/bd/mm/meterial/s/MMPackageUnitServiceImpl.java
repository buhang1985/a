package iih.bd.mm.meterial.s;

import iih.bd.mm.meterial.bp.MeterialUnitBp;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitService;
import xap.sys.jdbc.facade.DAException;

public class MMPackageUnitServiceImpl implements IMMPackageUnitService {

	@Override
	public MMPackageUnitDO getMeterialAndUnit(String id_mm, String id_mmsmc) throws DAException {
		MeterialUnitBp meterialUnitBp = new MeterialUnitBp();
		return meterialUnitBp.getMeterialAndUnit(id_mm, id_mmsmc);
	}

}
