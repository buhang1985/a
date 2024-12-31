package iih.bd.mm.supplierprotocol.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolRService;
import iih.bd.mm.supplierprotocol.s.ds.SupplierProtocolCache;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class SupproCuAfterBp {
	
	public void exec(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(supproAggDOS);
		
		// ■ 本地缓存信息更新
		this.updateCache(supproAggDOS);
	}

	private void validaPara(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		if(supproAggDOS == null || supproAggDOS.length <= 0) {
			
			throw new BizException("传入供应商与物品协议信息为空。");
		}
	}
	
	private void updateCache(SupplierprotocolAggDO[] supproAggDOS) throws BizException {
		
		List<SupplierprotocolAggDO> updateAggDOS = new ArrayList<SupplierprotocolAggDO>();
		List<SupplierprotocolAggDO> delAggDOS = new ArrayList<SupplierprotocolAggDO>();
		
		for(SupplierprotocolAggDO supproAggDO : supproAggDOS) {
			
			SuppierProtocolDO supproDO = supproAggDO.getParentDO();
			if(IBdMmDictCodeConst.SD_SU_PROT_PASS.equals(supproDO.getSd_su_prot()) && 
					supproDO.getFg_active().booleanValue()) {
				
				updateAggDOS.add(supproAggDO);
			} else if(IBdMmDictCodeConst.SD_SU_PROT_PASS.equals(supproDO.getSd_su_prot()) &&
					!supproDO.getFg_active().booleanValue()) {
				
				delAggDOS.add(supproAggDO);
			}
		}
		
		if(updateAggDOS != null && updateAggDOS.size() > 0) {
			
			SupplierProtocolCache.getInstance().updateCache(updateAggDOS.toArray(new SupplierprotocolAggDO[updateAggDOS.size()]));
		}
		
		if(delAggDOS != null && delAggDOS.size() > 0) {
			
			SupplierProtocolCache.getInstance().deleteCache(delAggDOS.toArray(new SupplierprotocolAggDO[delAggDOS.size()]));
		}
	}
	
	public void exec(SuppierProtocolDO[] supproDOS) throws BizException {
		
		ISupplierprotocolRService supplierprotocolRSrv = ServiceFinder.find(ISupplierprotocolRService.class);
		List<String> ids = new ArrayList<String>();
		for(SuppierProtocolDO supproDO : supproDOS) {
			ids.add(supproDO.getId_sup_prot());
		}
		SupplierprotocolAggDO[] supproAggDOS = supplierprotocolRSrv.findByIds(ids.toArray(new String[0]), FBoolean.FALSE);
		if(supproAggDOS == null || supproAggDOS.length <= 0) {
			return;
		}
		
		// ■ 本地缓存信息更新
		this.updateCache(supproAggDOS);
	}
}
