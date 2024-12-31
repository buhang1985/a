package iih.bd.res.bed.s;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedPatchDTO;
import iih.bd.res.bed.i.IBedService;
import iih.bd.res.bed.s.bp.PatchAddBedBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IBedService.class }, binding = Binding.JSONRPC)
public class BedServiceImpl implements IBedService {

	@Override
	public Bdbed[] patchAdd(BedPatchDTO bedPatchDto, String id_dep) throws BizException {
		PatchAddBedBp bp = new PatchAddBedBp();
		Bdbed[] beds = bp.exec(bedPatchDto, id_dep);
		return beds;
	}
}
