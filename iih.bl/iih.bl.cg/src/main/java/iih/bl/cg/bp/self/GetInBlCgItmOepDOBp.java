package iih.bl.cg.bp.self;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.d.BlCgOepAggDTO;

/**
 * 获取收费明细do
 * 
 * @author LIM
 *
 */
public class GetInBlCgItmOepDOBp {
	public List<BlCgItmOepDO> exec(BlCgOepAggDTO blCgOepAggDTO) throws BizException {
		List<BlCgItmOepDO> cgItmDoLst = new ArrayList<BlCgItmOepDO>();
		if (blCgOepAggDTO != null && blCgOepAggDTO.getBlcgoepAggDO() != null && blCgOepAggDTO.getBlcgoepAggDO().size() != 0) {
			for (Object cgaggdo : blCgOepAggDTO.getBlcgoepAggDO()) {
				BlcgoepAggDO dto = (BlcgoepAggDO) cgaggdo;
				for (int i = 0; i < dto.getBlCgItmOepDO().length; i++) {
					cgItmDoLst.add(dto.getBlCgItmOepDO()[i]);
				}
			}
		}
		return cgItmDoLst;
	}
}
