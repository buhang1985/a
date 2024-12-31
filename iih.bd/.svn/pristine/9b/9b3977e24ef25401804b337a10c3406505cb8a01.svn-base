package iih.bd.mm.meterial.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.s.ds.MaterialCache;
import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.i.IProtocolGoodsDOCudService;
import iih.bd.mm.supplierprotocol.i.IProtocolGoodsDORService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class MaterialDeAfterBp {
	
	public void exec(MeterialAggDO[] mmAggDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(mmAggDOS);
		
		// ■ 删除关联数据
		this.deleteRelData(mmAggDOS);
		
		// ■ 清空缓存
		this.clearCache(mmAggDOS);
	}

	private void validaPara(MeterialAggDO[] mmAggDOS) throws BizException {
		
		if(mmAggDOS == null || mmAggDOS.length <= 0) {
			
			throw new BizException("传入物品基本信息为空。");
		}
	}
	
	private void deleteRelData(MeterialAggDO[] mmAggDOS) throws BizException {
		
		//删除供应商与物品协议数据
		this.deleteProGoods(mmAggDOS);
		
		//删除仓库与物品关系数据
		this.deleteWhMm(mmAggDOS);
	}

	private void deleteProGoods(MeterialAggDO[] mmAggDOS) throws BizException {
		
		IProtocolGoodsDORService proGoodsRSrv = ServiceFinder.find(IProtocolGoodsDORService.class);
		
		String[] mmIdList = this.getMmIdList(mmAggDOS);
		ProtocolGoodsDO[] proGoodsDOS = proGoodsRSrv.findByAttrValStrings(ProtocolGoodsDO.ID_MM, mmIdList);
		if(proGoodsDOS != null && proGoodsDOS.length > 0) {
			
			IProtocolGoodsDOCudService proGoodsCudSrv = ServiceFinder.find(IProtocolGoodsDOCudService.class);
			proGoodsCudSrv.delete(proGoodsDOS);
		}
	}

	private String[] getMmIdList(MeterialAggDO[] mmAggDOS) throws BizException {
		
		List<String> mmIdList = new ArrayList<String>();
		for(MeterialAggDO mmAggDO : mmAggDOS) {
			
			mmIdList.add(mmAggDO.getParentDO().getId_mm());
		}
		
		return mmIdList.toArray(new String[mmIdList.size()]);
	}
	
	private void deleteWhMm(MeterialAggDO[] mmAggDOS) throws BizException {
		
		IWarehouseinfoRService whMmRSrv = ServiceFinder.find(IWarehouseinfoRService.class);
		
		String[] mmIdList = this.getMmIdList(mmAggDOS);
		WarehouseInfoDO[] whMmDOS = whMmRSrv.findByAttrValStrings(WarehouseInfoDO.ID_MM, mmIdList);
		if(whMmDOS != null && whMmDOS.length > 0) {
			
			IWarehouseinfoCudService whMmCudSrv = ServiceFinder.find(IWarehouseinfoCudService.class);
			whMmCudSrv.delete(whMmDOS);
		}
	}
	
	private void clearCache(MeterialAggDO[] mmAggDOS) throws BizException {
		
		MaterialCache.getInstance().clearCache(mmAggDOS);
	}
}
