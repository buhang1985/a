package iih.bd.mm.departinfo.s.ds;

import org.apache.commons.lang3.StringUtils;

import iih.bd.mm.departinfo.d.DepartInfoDO;
import iih.bd.mm.departinfo.i.IDepartinfoRService;
import iih.bd.mm.departinfo.i.ds.IDepartInfoService;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class DepartInfoServiceImpl implements IDepartInfoService {

	@Override
	public FDouble getMaterialMaxStockNum(String depId, String materialId,
			String pkguId) throws BizException {
		if (StringUtils.isBlank(depId)) {
			throw new BizException("Invalid parameter.[depId]");
		}
		
		if (StringUtils.isBlank(materialId)) {
			throw new BizException("Invalid parameter.[materialId]");
		}
		
		if (StringUtils.isBlank(pkguId)) {
			throw new BizException("Invalid parameter.[pkguId]");
		}
		
		IDepartinfoRService departinfoRService = ServiceFinder.find(IDepartinfoRService.class);
		StringBuffer whereBuff = new StringBuffer(" a0.ds=0 ");
		whereBuff.append(" and a0.fg_active='Y' ");
		whereBuff.append(" and a0.id_dep='" + depId + "' ");
		whereBuff.append(" and a0.id_mm='" + materialId + "' ");
		DepartInfoDO[] departInfoDOs = departinfoRService.find(whereBuff.toString(), null, FBoolean.TRUE);
		if (departInfoDOs == null || departInfoDOs.length <= 0) {
			return FDouble.ZERO_DBL;
		}
		
		IMeterialService meterialService = ServiceFinder.find(IMeterialService.class);
		FDouble baseMaxNum = departInfoDOs[0].getMaxstnum();
		MMPackageUnitDO mmPackageUnitDO = meterialService.findBasePackageUnit(materialId);
		String basePkguId = mmPackageUnitDO.getId_mmpkgu();
		
		return meterialService.packageUnitConversion(IMeterialService.TYPE_NUM, baseMaxNum, basePkguId, pkguId);
	}

}
