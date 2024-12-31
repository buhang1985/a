package iih.ci.mr.s;

import java.util.List;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimrvt.d.CimrvtAggDO;
import iih.ci.mr.cimrvt.d.VitalSignSave;
import iih.ci.mr.cimrvt.i.ICimrvtCudService;
import iih.ci.mr.i.VitalSignSaveService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { VitalSignSaveService.class }, binding = Binding.JSONRPC)
public class VitalSignSaveServiceImpl implements VitalSignSaveService {

	@Override
	public VitalSignSave[] VatilSignSave(VitalSignSave[] ListSaveDTOS) throws BizException {

		ICiemrCudService CimrService = ServiceFinder.find(ICiemrCudService.class);
		ICimrvtCudService CimrvtService = ServiceFinder.find(ICimrvtCudService.class);

		for (VitalSignSave SaveDTO : ListSaveDTOS) {

			CiMrDO[] SavedCiEmrDO = CimrService.save(new CiMrDO[] { SaveDTO.getCimrDO() });
			SaveDTO.getAggDO().getParentDO().setId_mr(SavedCiEmrDO[0].getId_mr());
			SaveDTO.getAggDO().getParentDO().setId_grp(Context.get().getGroupId());
			SaveDTO.getAggDO().getParentDO().setId_org(Context.get().getOrgId());
			CimrvtService.save(new CimrvtAggDO[] { SaveDTO.getAggDO() });
		}
		return ListSaveDTOS;

	}
}
