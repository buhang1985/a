package iih.bd.mm.meterial.s.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import xap.lui.core.mq.IMQListener;

public class ClearMMCacheListener implements IMQListener {
	
	@Override
	public void doListener(Object arg0) throws Exception {
		
        if(arg0 instanceof MeterialDO[]) {
			
			MeterialDO[] mmDOs=(MeterialDO[])arg0;
			
            for(MeterialDO mmdo : mmDOs) {
				
            	MaterialCache.getInstance().clearMaterialCache(mmdo);
			}
		} else if (arg0 instanceof MeterialAggDO[]) {
			
			MeterialAggDO[] aggDOS = (MeterialAggDO[])arg0;
			List<MMPackageUnitDO> pkgDOs = new ArrayList<MMPackageUnitDO>();
			List<MeterialDO> mmdos = new ArrayList<MeterialDO>();
			for(MeterialAggDO aggDO : aggDOS) {
				
				mmdos.add(aggDO.getParentDO());
				pkgDOs.addAll(Arrays.asList(aggDO.getMMPackageUnitDO()));
			}
			
			MaterialCache.getInstance().clearMaterialCache(mmdos.toArray(new MeterialDO[0]));
			MaterialCache.getInstance().clearPackageUnitCache(pkgDOs.toArray(new MMPackageUnitDO[0]));
		} else if(arg0 instanceof MMPackageUnitDO[]) {
			
			MMPackageUnitDO[] pkgList = (MMPackageUnitDO[])arg0;
			List<String> mmList = new ArrayList<String>();
			for(MMPackageUnitDO pkgDO : pkgList) {
				
				if(!mmList.contains(pkgDO.getId_mm())) {
					
					mmList.add(pkgDO.getId_mm());
				}
			}
			
			MaterialCache.getInstance().clearPackageUnitCache(mmList.toArray(new String[0]));
		}
	}

	@Override
	public String getListenerType() {
		// TODO Auto-generated method stub
		return MaterialCache.CLEAR_BD_MM_KEY;
	}
}
