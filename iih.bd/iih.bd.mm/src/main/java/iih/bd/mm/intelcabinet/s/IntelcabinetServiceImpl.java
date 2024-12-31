package iih.bd.mm.intelcabinet.s;


import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import iih.bd.mm.intelcabinet.i.IIntelcabinetService;
import iih.bd.mm.intelcabinet.s.bp.UpdateIntelCabiBp;
import xap.mw.core.data.BizException;

public class IntelcabinetServiceImpl implements IIntelcabinetService{

	@Override
	public IntelCabinetDO[] start(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		UpdateIntelCabiBp bp = new UpdateIntelCabiBp();
		
		return bp.Start(intelCabiDOS);
	}

	@Override
	public IntelCabinetDO[] stop(IntelCabinetDO[] intelCabiDOS) throws BizException {
		
		UpdateIntelCabiBp bp = new UpdateIntelCabiBp();
		
		return bp.Stop(intelCabiDOS);
	}
}
