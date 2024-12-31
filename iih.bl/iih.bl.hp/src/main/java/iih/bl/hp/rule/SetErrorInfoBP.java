package iih.bl.hp.rule;

import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;

/**
 * 返回医保校验错误信息
 * 
 * @author LIM
 *
 */
public class SetErrorInfoBP {
	/**
	 * 
	 * @param ciOrderDO
	 * @param ordSrvDO
	 * @param errMsg
	 * @param errCode
	 * @return
	 * @throws BizException
	 */
	public ItmChkRstDTO exec(CiOrderDO ciOrderDO, OrdSrvDO ordSrvDO, String errMsg, String errCode)
			throws BizException {
		if (ciOrderDO == null) {
			throw new BizException("医嘱不能为空！");
		}
		if (ordSrvDO == null) {
			throw new BizException("医嘱服务不能为空！");
		}
		if (StringUtil.isEmpty(errCode)) {
			throw new BizException("错误类型不能为空！");
		}

		FMap fMap = new FMap();
		fMap.put(errCode, errMsg);
		ItmChkRstDTO itmChkRstDTO = new ItmChkRstDTO();
		itmChkRstDTO.setId_or(ciOrderDO.getId_or());
		itmChkRstDTO.setCode_or(ciOrderDO.getCode_or());
		itmChkRstDTO.setName_or(ciOrderDO.getName_or());
		itmChkRstDTO.setId_srv(ordSrvDO.getId_srv());
		itmChkRstDTO.setCode_srv(ordSrvDO.getCode_srv());
		itmChkRstDTO.setName_srv(ordSrvDO.getName_srv());
		itmChkRstDTO.setId_mm(ordSrvDO.getId_mm());
		itmChkRstDTO.setError_map(fMap);
		return itmChkRstDTO;
	}
}
