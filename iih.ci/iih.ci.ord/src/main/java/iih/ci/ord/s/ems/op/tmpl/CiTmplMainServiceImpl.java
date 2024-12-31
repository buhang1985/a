package iih.ci.ord.s.ems.op.tmpl;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.op.tmpl.ICiTmplMainService;
import iih.ci.ord.i.op.tmpl.TmplLoadDTO;
import iih.ci.ord.i.op.tmpl.TmplRstDTO;
import iih.ci.ord.i.op.tmpl.TmplSaveDTO;
import iih.ci.ord.s.ems.itf.bp.ITmplLoadBP;
import iih.ci.ord.s.ems.itf.bp.ITmplSaveBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiTmplMainService.class }, binding = Binding.JSONRPC)
public class CiTmplMainServiceImpl implements ICiTmplMainService {

	// 铜陵
	private ITmplLoadBP iTmplLoadBP = new TmplLoadAction();
	private ITmplSaveBP iTmplSaveBP = new TmplSaveAction();

	@Override
	public TmplRstDTO load(CiEnContextDTO ctx, TmplLoadDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmplRstDTO save(CiEnContextDTO ctx, TmplSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub

		return iTmplSaveBP.save(ctx,ems);
	}

}
