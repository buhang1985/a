package iih.bd.mm.packageunit.s.bp;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.bd.mm.packageunit.d.PackageUnitDO;
import iih.bd.mm.wahouseunittype.d.WahouseUnitTypeDO;
import iih.bd.mm.wahouseunittype.i.IWahouseunittypeRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class PkgutpDeBeforeBp {
	
	public void exec(PackageUnitDO[] pkgutpDOS) throws BizException {
		
		if(pkgutpDOS == null || pkgutpDOS.length <= 0) {
			
			return;
		}
		
		// ■ 验证仓库包装单位类型是否允许删除
		this.checkCanDelete(pkgutpDOS);
	}

	private void checkCanDelete(PackageUnitDO[] pkgutpDOS) throws BizException {
		
		IMMPackageUnitDORService mmpkguRSrv = ServiceFinder.find(IMMPackageUnitDORService.class);
		IWahouseunittypeRService whunittpRSrv = ServiceFinder.find(IWahouseunittypeRService.class);
		
		for(PackageUnitDO pkgUnitTpDO : pkgutpDOS) {
			
			//包装单位类型是否已被物品引用
			String whrStr = String.format("id_mmpkgutp = '%s'", pkgUnitTpDO.getId_mmpkgutp());
			MMPackageUnitDO[] mmpkguUnitDOS = mmpkguRSrv.find(whrStr, "", FBoolean.TRUE);
			if(mmpkguUnitDOS != null && mmpkguUnitDOS.length > 0) {
				
				throw new BizException(String.format("包装单位类型【%s】已被物品引用，不允许删除。", pkgUnitTpDO.getName()));
			}
			//包装单位类型是否已被仓库包装单位类型引用
			WahouseUnitTypeDO[] whUnitTpDOS = whunittpRSrv.find(whrStr, "", FBoolean.TRUE);
			if(whUnitTpDOS != null && whUnitTpDOS.length > 0) {
				
				throw new BizException(String.format("包装单位类型【%s】已被仓库包装单位类型引用，不允许删除。", pkgUnitTpDO.getName()));
			}
		}
	}
}
