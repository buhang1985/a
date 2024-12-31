package iih.ci.mrm.s.mrmmisoperation.audlogic;

import iih.ci.mrm.cimrmcopy.i.ICimrmcopyRService;
import iih.ci.mrm.cimrmoperate.i.ICimrmoperateCudService;
import iih.ci.mrm.cimrmsp.i.ICimrmspRService;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmmisoperation.audlogic.IMrmMisoperationAudLogicService;
import iih.mp.mb.i.InsertIntoCAInfoRequest;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces={IMrmMisoperationAudLogicService.class}, binding=Binding.JSONRPC)
public class IMrmMisoperationAudLogicServiceImpl implements IMrmMisoperationAudLogicService{

	@Override
	public String SaveCiMrmOperateDO(CiMrmQryListDTO cimrmqrylistdto) {
		ICimrmspRService rService = ServiceFinder.find(ICimrmspRService.class);
		ICimrmoperateCudService cudService = ServiceFinder.find(ICimrmoperateCudService.class);
		
//		String id_amr=cimrmqrylistdto.getId_amr();
		
        return null;
	}

	


}
