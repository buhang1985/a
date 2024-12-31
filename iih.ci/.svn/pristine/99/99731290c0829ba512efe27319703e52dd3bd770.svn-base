package iih.ci.mr.assist.s;

import iih.ci.mr.assist.i.IVitalSignRService;
import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import iih.ci.mr.cimrvt.d.CimrvtAggDO;
import iih.ci.mr.cimrvt.i.ICimrvtRService;
import iih.ci.mr.i.ICiVitalSignsService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IVitalSignRService.class }, binding = Binding.JSONRPC)
public class VitalSignServiceImpl implements IVitalSignRService {

	@Override
	public VitalSignsDTO[] GetVitalSignsDTOList(String id_ent,String BeginDate,String EndDate) throws BizException {
		ICiVitalSignsService r = ServiceFinder.find(ICiVitalSignsService.class);
		return r.GetVitalSignsDTOList(id_ent, BeginDate, EndDate);
	}
}