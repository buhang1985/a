package iih.ci.mr.mrws.hosgetmr.s;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.jws.WebService;


import iih.ci.mr.mrws.hosgetmr.i.IMrWsForHosSysService;
import iih.ci.mr.mrws.hosgetmr.s.bp.MrWsForHosSysUPloadBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@WebService
@Service(serviceInterfaces = {IMrWsForHosSysService.class }, binding = Binding.JSONRPC)
public class MrWsForHosSysServiceImpl implements IMrWsForHosSysService{
	
	@Override
	public boolean AddMrmFileInfo(String code_pat, String times_inhos, String id_busy, String id_set, String name,
			String file, Boolean isClear, int sortNo) throws  IOException , BizException {
		// TODO Auto-generated method stub
		MrWsForHosSysUPloadBp bp = new MrWsForHosSysUPloadBp();
		return bp.AddMrmFileInfo(code_pat, times_inhos, id_busy, id_set, name, file, isClear, sortNo);
	}
	
	public boolean UpLoadMrmFileInfo(String code_pat, String times_inhos,String code_ent, String id_busy, String id_set, String name,
			String file, Boolean isClear, int sortNo,int tCount) throws  IOException , BizException{
		MrWsForHosSysUPloadBp bp = new MrWsForHosSysUPloadBp();
		return bp.upLoadMrmFileInfo(code_pat, times_inhos, code_ent, id_busy, id_set, name, file, isClear, sortNo, tCount);
	}
	
	public boolean UpdateMrmStatisticsInfo(String code_pat, String times_inhos,String code_ent,String id_set, int tCount) throws  IOException , BizException{
		MrWsForHosSysUPloadBp bp = new MrWsForHosSysUPloadBp();
		return bp.updateMrmStatisticsInfo(code_pat, times_inhos, code_ent, id_set, tCount);
	}
	
}
