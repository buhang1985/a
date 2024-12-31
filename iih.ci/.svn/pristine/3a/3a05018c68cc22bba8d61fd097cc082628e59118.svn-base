package iih.ci.mr.assist.s;

import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.cidiag.i.ICidiagRService;
import iih.ci.mr.assist.i.IDiagnosisRService;
import iih.ci.mrqc.d.Cidiagdto;
import iih.ci.mrqc.serviceext.i.IQcServiceExt;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IDiagnosisRService.class }, binding = Binding.JSONRPC)
public class DiagnosisServiceImpl implements IDiagnosisRService {

	@Override
	public EntDiDO[] queryByEnt(String id_ent) throws BizException {
		IEntdiRService r = ServiceFinder.find(IEntdiRService.class);
	
		return r.find("id_ent = " + id_ent, null, new FBoolean(false));
	}

	@Override
	public Cidiagdto[] getCidiagdto(String id_ent,String[] sd_disys) throws BizException {
		IQcServiceExt r = ServiceFinder.find(IQcServiceExt.class);
		return r.getCidiagdto(id_ent,sd_disys);
	}

}