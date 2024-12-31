package iih.bd.mm.supplier.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.mm.supplier.d.SupplierDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class SupplierCuAfterBp {
	
	public void exec(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		
		// ■ 参数校验
		this.validaPara(vos, originVOs);
		
		// ■ 更新药品基本信息
		this.updateMmSupInfo(vos);
	}

	private void validaPara(SupplierDO[] vos, SupplierDO[] originVOs) throws BizException {
		
		if(vos == null || vos.length <= 0) {
			
			throw new BizException("传入供应商厂商字典数据为空。");
		}
		
		if(originVOs == null || originVOs.length <= 0) {
			
			throw new BizException("传入供应商厂商字典数据为空。");
		}
	}
	
	private void updateMmSupInfo(SupplierDO[] vos) throws BizException {
		Map<String, SupplierDO> supMap = new HashMap<String, SupplierDO>();
		for(SupplierDO supDO : vos) {
			supMap.put(supDO.getId_sup(), supDO);
		}
		IMeterialMDORService meteialRSrv = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] mmdos = meteialRSrv.findByAttrValStrings(MeterialDO.ID_SUP, supMap.keySet().toArray(new String[0]));
		if(mmdos == null || mmdos.length <= 0) {
			return;
		}
		List<MeterialDO> updateList = new ArrayList<MeterialDO>();
		for(MeterialDO mmDO : mmdos) {
			SupplierDO supDO = supMap.get(mmDO.getId_sup());
			if(supDO.getName().equals(mmDO.getSup_name())) {
				continue;
			}
			mmDO.setStatus(DOStatus.UPDATED);
			mmDO.setFactory_name(supDO.getName());
			mmDO.setSup_name(supDO.getName());
			updateList.add(mmDO);
		}
		if(updateList != null && updateList.size() > 0) {
			IMeterialMDOCudService meteialCudSrv = ServiceFinder.find(IMeterialMDOCudService.class);
			meteialCudSrv.update(updateList.toArray(new MeterialDO[0]));
		}
	}
}
