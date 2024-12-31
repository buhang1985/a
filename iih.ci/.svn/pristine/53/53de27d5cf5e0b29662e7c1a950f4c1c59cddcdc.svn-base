package iih.ci.preop.order.copy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import iih.ci.preop.order.dto.OrdPreopDTO;
import iih.ci.preop.order.dto.OrdPreopLisDTO;
import iih.ci.preop.order.dto.OrdPreopRisDTO;
import iih.ci.tsip.d.CiTsApLabDO;
import iih.ci.tsip.d.CiTsApObsDO;
import iih.ci.tsip.i.ICitsaplabCudService;
import iih.ci.tsip.i.ICitsapobsCudService;
import iih.ci.tsip.i.ICitsapobsRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 检查预住院复制逻辑
 * @author F
 *
 */
public class RisPreopCopyBP extends BasePreopCopyBP {

	@Override
	protected void copyApSheet() throws BizException {
		String[] id_ors = this.getOrdPreopMap().keySet().toArray(new String[0]);
		ICitsapobsRService obsRService = ServiceFinder.find(ICitsapobsRService.class);
		CiTsApObsDO[] sourceApObsDos =  obsRService.findByAttrValStrings(CiTsApObsDO.ID_TSOR, id_ors);
		if(sourceApObsDos != null &&sourceApObsDos.length >0){
			for (CiTsApObsDO sourceCiTsApObsDO : sourceApObsDos) {
				OrdPreopRisDTO ordPreopDTO = (OrdPreopRisDTO)this.getOrdPreopMap().get(sourceCiTsApObsDO.getId_tsor());
				CiTsApObsDO ciTsApObsDO = (CiTsApObsDO)sourceCiTsApObsDO.clone();
				ciTsApObsDO.setId_tsor(ordPreopDTO.getCiTsOrDO().getId_tsor());
				ordPreopDTO.setCiTsApObsDO(ciTsApObsDO);
			}
		}
	}

	@Override
	protected void save() throws BizException {
		super.save();
		List<CiTsApObsDO> labs = new ArrayList<CiTsApObsDO>();
		Set<String> keys = this.getOrdPreopMap().keySet();
		for (String sourceIdOr : keys) {
			OrdPreopRisDTO ordPreopDTO =  (OrdPreopRisDTO)this.getOrdPreopMap().get(sourceIdOr);
			labs.add(ordPreopDTO.getCiTsApObsDO());
		}
		if(labs.size() > 0){
			ICitsapobsCudService obsMService = ServiceFinder.find(ICitsapobsCudService.class);
			obsMService.save(labs.toArray(new CiTsApObsDO[0]));
		}
	}

	@Override
	protected OrdPreopDTO createOrdPreopDTO() {
		return new OrdPreopRisDTO();
	}

}
