package iih.bd.mm.intelcabinet.s.bp;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.mm.intelcabinet.i.IIntelcabinetCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class UpdateIntelCabiBp {
	
	public IntelCabinetDO[] Start(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(intelCabiDOS);
		
		// ■ 启用	
		return this.start(intelCabiDOS);
	}

	private void validaPara(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		if(intelCabiDOS == null || intelCabiDOS.length <= 0) {
			
			throw new BizException("传入智能柜数据为空。");
		}
	}
	
	private IntelCabinetDO[] start(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		for(IntelCabinetDO intelCabiDO : intelCabiDOS) {
			
			intelCabiDO.setStatus(DOStatus.UPDATED);
			//启用
			intelCabiDO.setFg_active(FBoolean.TRUE);
		}
		
		IIntelcabinetCudService intelCabiCudSrv = ServiceFinder.find(IIntelcabinetCudService.class);
		return intelCabiCudSrv.update(intelCabiDOS);
	}
	
	public IntelCabinetDO[] Stop(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		// ■ 参数校验
		this.validaPara(intelCabiDOS);
		
		// ■ 停用
		return this.stop(intelCabiDOS);
	}
	
	private IntelCabinetDO[] stop(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		for(IntelCabinetDO intelCabiDO : intelCabiDOS) {
			
			intelCabiDO.setStatus(DOStatus.UPDATED);
			//启用
			intelCabiDO.setFg_active(FBoolean.FALSE);
		}
		
		IIntelcabinetCudService intelCabiCudSrv = ServiceFinder.find(IIntelcabinetCudService.class);
		return intelCabiCudSrv.update(intelCabiDOS);
	}
}
