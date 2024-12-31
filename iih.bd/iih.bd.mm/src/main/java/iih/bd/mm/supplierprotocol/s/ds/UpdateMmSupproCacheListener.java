package iih.bd.mm.supplierprotocol.s.ds;

import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import xap.lui.core.mq.IMQListener;

public class UpdateMmSupproCacheListener implements IMQListener {

	@Override
	public void doListener(Object arg0) throws Exception {
		
		if(!(arg0 instanceof SupplierprotocolAggDO[])) {
			
			return;
		}
		
		SupplierprotocolAggDO[] supProAggDOS = (SupplierprotocolAggDO[])arg0;
		SupplierProtocolCache.getInstance().updateMmSupproCache(supProAggDOS);
	}

	@Override
	public String getListenerType() {
		
		// TODO Auto-generated method stub
		return SupplierProtocolCache.UPDATE_BD_MM_SUPPRO_KEY;
	}
}
