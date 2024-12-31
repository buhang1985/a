package iih.ci.preop.order.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.preop.order.dto.OrdPreopDTO;
import iih.ci.preop.order.dto.OrdPreopLisDTO;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.i.ICitsaplabCudService;
import iih.ci.tsip.i.ICitsaplabRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class LisPreopCopyBP extends BasePreopCopyBP {

	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdPreopMap().keySet().toArray(new String[0]);
		ICitsaplabRService labRService = ServiceFinder.find(ICitsaplabRService.class);
		CiTsApLabDO[] sourceApLabDos =  labRService.findByAttrValStrings(CiTsApLabDO.ID_TSOR, id_ors);
		if(sourceApLabDos != null &&sourceApLabDos.length >0){
			for (CiTsApLabDO sourceCiTsApLabDO : sourceApLabDos) {
				OrdPreopLisDTO ordPreopDTO = (OrdPreopLisDTO)this.getOrdPreopMap().get(sourceCiTsApLabDO.getId_tsor());
				CiTsApLabDO ciTsApLabDO = (CiTsApLabDO)sourceCiTsApLabDO.clone();
				ciTsApLabDO.setId_tsor(ordPreopDTO.getCiTsOrDO().getId_tsor());
				ordPreopDTO.setCiTsApLabDO(ciTsApLabDO);
			}
		}
	}
	
	@Override
	protected void save() throws BizException {
		super.save();
		Set<String> keys = this.getOrdPreopMap().keySet();
		List<CiTsApLabDO> labs = new ArrayList<CiTsApLabDO>();
		for (String sourceIdOr : keys) {
			OrdPreopLisDTO ordPreopDTO =  (OrdPreopLisDTO)this.getOrdPreopMap().get(sourceIdOr);
			labs.add(ordPreopDTO.getCiTsApLabDO());
		}
		if(labs.size() > 0){
			ICitsaplabCudService labMService = ServiceFinder.find(ICitsaplabCudService.class);
			labMService.save(labs.toArray(new CiTsApLabDO[0]));
		}
	}

	@Override
	protected OrdPreopDTO createOrdPreopDTO() {
		return new OrdPreopLisDTO();
	}

}
