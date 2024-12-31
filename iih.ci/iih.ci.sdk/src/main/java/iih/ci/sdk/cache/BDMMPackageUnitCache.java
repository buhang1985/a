package iih.ci.sdk.cache;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.IMMPackageUnitDORService;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class BDMMPackageUnitCache {
	public static String BDMMPackageUnitCache_Key = "BDMMPackageUnitCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDMMPackageUnitCache() {
	}

	public static MMPackageUnitDO[] GetMMPackageUnitInfo(String id_mm) throws BizException {
		
		List<MMPackageUnitDO> pkgList = ContextCache.Get(BDMMPackageUnitCache.class.getSimpleName(), DefaultContext_ID,
				 DefaultContext_ID,
				 BDMMPackageUnitCache_Key,
				id_mm);
		if(ObjectUtils.isEmpty(pkgList)) {
			MMPackageUnitDO[] szPkg = ServiceFinder.find(IMMPackageUnitDORService.class).findByAttrValString(MMPackageUnitDO.ID_MM, id_mm);
			if(!ObjectUtils.isEmpty(szPkg)) {
				ContextCache.Put(BDMMPackageUnitCache.class.getSimpleName(), DefaultContext_ID,
						 DefaultContext_ID,
						 BDMMPackageUnitCache_Key,
						id_mm,Arrays.asList(szPkg));
				
				Arrays.sort(szPkg, new Comparator<MMPackageUnitDO>() {

					@Override
					public int compare(MMPackageUnitDO o1, MMPackageUnitDO o2) {
						// TODO Auto-generated method stub
						if(o2.getEn_ippkgtp()!=null && o1.getEn_ippkgtp() ==null) {
							return 1;
						}
						else if(o2.getEn_ippkgtp()!=null && o1.getEn_ippkgtp() !=null) {
							return o2.getEn_ippkgtp() > o1.getEn_ippkgtp()?-1:1;
						}
						return 0;
					}});
				
				pkgList = Arrays.asList(szPkg);
			}
		}
		return pkgList.toArray(new MMPackageUnitDO[1]);
	}
}
