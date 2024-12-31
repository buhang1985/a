package iih.ci.mr.s;

import java.io.IOException;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.i.IMrTransactionService;
import iih.ci.mr.i.IOPMrService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueCudService;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.mr.s.bp.CiMrFsBP;
import iih.ci.mr.s.bp.MrSaveTransactionBp;

@Service(serviceInterfaces = { IOPMrService.class }, binding = Binding.JSONRPC)
public class MrTransactionServiceImpl implements IMrTransactionService {

	@Override
	public FArrayList2 saveMr(CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException {
		// TODO Auto-generated method stub
		MrSaveTransactionBp bp = new MrSaveTransactionBp();
		return bp.SaveMr(ciMrDO, ciMrFsDO);
	}

	@Override
	public FArrayList2 saveMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,
			CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException {
		// TODO Auto-generated method stub
			
		MrSaveTransactionBp bp = new MrSaveTransactionBp();
		return bp.saveMrAndRef(mrDocRefValueDOs, ciMrDO, ciMrFsDO);
	}

	@Override
	public FArrayList2 saveOPMrAndRef(MrDocRefValueDO[] mrDocRefValueDOs,
			CiMrDO ciMrDO, CiMrFsDO ciMrFsDO) throws BizException, IOException {
		// TODO Auto-generated method stub
			
		MrSaveTransactionBp bp = new MrSaveTransactionBp();
		return bp.saveOPMrAndRef(mrDocRefValueDOs, ciMrDO, ciMrFsDO);
	}
}
