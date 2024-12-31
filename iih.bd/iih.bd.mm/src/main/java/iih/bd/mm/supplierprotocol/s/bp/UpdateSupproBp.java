package iih.bd.mm.supplierprotocol.s.bp;

import iih.bd.mm.supplierprotocol.d.ProtocolGoodsDO;
import iih.bd.mm.supplierprotocol.d.SuppierProtocolDO;
import iih.bd.mm.supplierprotocol.d.SupplierprotocolAggDO;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolCudService;
import iih.bd.mm.supplierprotocol.i.ISupplierprotocolRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateSupproBp {
	
	public FBoolean DeleteCheck(String[] ids) throws BizException {
		
		// ■ 参数校验
		this.validaPara(ids);
		
		// ■ 删除验证
		return this.deleteCheck(ids);
	}
	
	private FBoolean deleteCheck(String[] ids) throws BizException {
		
		SupplierprotocolAggDO[] supProAggDOS = this.getAggList(ids);
		for(SupplierprotocolAggDO supProAggDO : supProAggDOS) {
			
			ProtocolGoodsDO[] proGoodsDOS = supProAggDO.getProtocolGoodsDO();
			if(proGoodsDOS != null && proGoodsDOS.length > 0) {
				
				return FBoolean.FALSE;
			}
		}
		
		return FBoolean.TRUE;
	}

	public void Delete(String[] ids) throws BizException {
		
		// ■ 参数校验
		this.validaPara(ids);
		
		// ■ 删除数据
		this.deleteAggDO(ids);
	}

	private void validaPara(String[] ids) throws BizException {
		
		if(ids == null || ids.length <= 0) {
			
			throw new BizException("传入参数信息为空。");
		}
	}
	
	private void deleteAggDO(String[] ids) throws BizException {
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		
		SupplierprotocolAggDO[] supProAggDOS = this.getAggList(ids);
		supProCudSrv.delete(supProAggDOS);
	}
	
	public SupplierprotocolAggDO[] Enable(String[] ids) throws BizException {
		
		// ■ 参数校验
		this.validaPara(ids);
		
		// ■ 数据获取
		SupplierprotocolAggDO[] supproAggList = this.getAggList(ids);
		
		// ■ 启用
		return this.enable(supproAggList);
	}

	private SupplierprotocolAggDO[] getAggList(String[] ids) throws BizException {
		
		ISupplierprotocolRService supProRSrv = ServiceFinder.find(ISupplierprotocolRService.class);
		
		SupplierprotocolAggDO[] supProAggDOS = supProRSrv.findByBIds(ids, FBoolean.FALSE);
		if(supProAggDOS == null || supProAggDOS.length <= 0) {
			
			throw new BizException("获取供应商物品协议失败。");
		}
		
		return supProAggDOS;
	}
	
	private SupplierprotocolAggDO[] enable(SupplierprotocolAggDO[] supproAggList) throws BizException {
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		
		for(SupplierprotocolAggDO supProAggDO : supproAggList) {
			
			SuppierProtocolDO supProDO = supProAggDO.getParentDO();
			supProDO.setStatus(DOStatus.UPDATED);
			//启用
			supProDO.setFg_active(FBoolean.TRUE);
		}
		
		return supProCudSrv.update(supproAggList);
	}
	
	public SupplierprotocolAggDO[] Disable(String[] ids) throws BizException {
		
		// ■ 参数校验
		this.validaPara(ids);
		
		// ■ 数据获取
		SupplierprotocolAggDO[] supproAggList = this.getAggList(ids);
		
		// ■ 启用
		return this.disable(supproAggList);
	}

	private SupplierprotocolAggDO[] disable(SupplierprotocolAggDO[] supproAggList) throws BizException {
		
		ISupplierprotocolCudService supProCudSrv = ServiceFinder.find(ISupplierprotocolCudService.class);
		
		for(SupplierprotocolAggDO supProAggDO : supproAggList) {
			
			SuppierProtocolDO supProDO = supProAggDO.getParentDO();
			supProDO.setStatus(DOStatus.UPDATED);
			//启用
			supProDO.setFg_active(FBoolean.FALSE);
		}
		
		return supProCudSrv.update(supproAggList);
	}
}
