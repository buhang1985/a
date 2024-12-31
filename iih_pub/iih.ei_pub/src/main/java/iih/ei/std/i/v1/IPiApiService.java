package iih.ei.std.i.v1;

import iih.ei.std.d.v1.bl.patregordistrcarddto.d.RegOrDistrParamDTO;
import iih.ei.std.d.v1.bl.patregordistrcarddto.d.RegOrDistrResultDTO;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoParamDTO;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoResultDTO;
import xap.mw.core.data.BizException;

public interface IPiApiService {

	/**
	 * 患者信息查询(门诊+住院)
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PiPatInfoResultDTO getPiPatInfo(PiPatInfoParamDTO param) throws BizException;
	
	/**
	 * 患者注册或者患者注册发卡
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public RegOrDistrResultDTO patRegOrDistrCard(RegOrDistrParamDTO param) throws BizException;
}
