package iih.bl.st.s.bp.oepcharge;

import java.util.HashMap;
import java.util.Map;

import iih.bd.base.utils.SVCheckUtils;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeSvCheckDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊收费校验医嘱sv
 * @author ly 2019/11/28
 *
 */
public class BlOepChargeCheckOrdSvBP {

	/**
	 * 门诊收费校验医嘱sv
	 * @param checkDtos
	 * @throws BizException
	 */
	public void exec(BlOepChargeSvCheckDTO[] checkDtos) throws BizException {

		if(ArrayUtil.isEmpty(checkDtos))
			return;
		
		Map<String,FDateTime> svCheckMap = new HashMap<String,FDateTime>();
		for (BlOepChargeSvCheckDTO checkDto : checkDtos) {
				
			if(!StringUtil.isEmpty(checkDto.getId_or()) && checkDto.getChecksv() != null){
				svCheckMap.put(checkDto.getId_or(), checkDto.getChecksv());
			}
		}
		
		if(svCheckMap.size() == 0)
			return;
		
		Boolean check = SVCheckUtils.checkSv(svCheckMap, new CiOrderDO());
		if(!check){
			throw new BizException("当前医嘱数据已被他人修改，请重新调入");
		}
	}
}
