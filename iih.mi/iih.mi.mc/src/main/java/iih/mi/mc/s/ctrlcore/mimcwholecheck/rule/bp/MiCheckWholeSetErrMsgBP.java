package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule.bp;

import iih.mi.mc.dto.mimcwholerule.d.MiMcCheckFailResultEnum;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrdSrvResultDTO;
import iih.mi.mc.dto.mimcwholerule.d.MiMcOrderDTO;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 组织返回的错误信息
 * 
 * @author LIM
 * @since 2019-09-24
 */
public class MiCheckWholeSetErrMsgBP {
	public MiMcOrdSrvResultDTO exec(MiMcOrderDTO miMcOrderDTO, MiMcOrdSrvDTO miMcOrdSrvDTO, String errCode, String errMsg) {
		if (miMcOrdSrvDTO == null || StringUtil.isEmpty(errCode))
			return null;
		MiMcOrdSrvResultDTO miMcOrdSrvResultDTO = new MiMcOrdSrvResultDTO();
		miMcOrdSrvResultDTO.setId_di(miMcOrdSrvDTO.getId_di());
		miMcOrdSrvResultDTO.setId_or(miMcOrderDTO.getId_or());
		miMcOrdSrvResultDTO.setCode_or(miMcOrderDTO.getCode_or());
		miMcOrdSrvResultDTO.setName_or(miMcOrderDTO.getName_or());
		miMcOrdSrvResultDTO.setId_orsrv(miMcOrdSrvDTO.getId_orsrv());
		miMcOrdSrvResultDTO.setId_srv(miMcOrdSrvDTO.getId_srv());
		miMcOrdSrvResultDTO.setCode_srv(miMcOrdSrvDTO.getCode_srv());
		miMcOrdSrvResultDTO.setName_srv(miMcOrdSrvDTO.getName_srv());
		miMcOrdSrvResultDTO.setId_mm(miMcOrdSrvDTO.getId_mm());
		miMcOrdSrvResultDTO.setCode_mm(miMcOrdSrvDTO.getCode_mm());
		miMcOrdSrvResultDTO.setName_mm(miMcOrdSrvDTO.getName_mm());
		if (MiMcCheckFailResultEnum.RADIATION_CLASS_ORDER.equals(errCode)) {
			miMcOrdSrvResultDTO.setFg_result(FBoolean.TRUE);
		} else {
			miMcOrdSrvResultDTO.setFg_result(FBoolean.FALSE);
		}

		FMap fMap = new FMap();
		fMap.put(errCode, errMsg);
		miMcOrdSrvResultDTO.setError_map(fMap);
		return miMcOrdSrvResultDTO;
	}
}
