package iih.ei.std.s.v1;

import iih.ei.std.d.v1.bl.patregordistrcarddto.d.RegOrDistrParamDTO;
import iih.ei.std.d.v1.bl.patregordistrcarddto.d.RegOrDistrResultDTO;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoParamDTO;
import iih.ei.std.d.v1.bl.pipatinfodto.d.PiPatInfoResultDTO;
import iih.ei.std.i.v1.IPiApiService;
import iih.ei.std.s.v1.bp.pi.GetPiPatInfoBP;
import iih.ei.std.s.v1.bp.pi.PatRegOrDistrCardBP;
import xap.mw.core.data.BizException;

public class PiApiServiceImpl implements IPiApiService{

	/**
	 * 患者信息查询(门诊+住院)
	 */
	@Override
	public PiPatInfoResultDTO getPiPatInfo(PiPatInfoParamDTO param) throws BizException {
		GetPiPatInfoBP bp = new GetPiPatInfoBP();
		return bp.exec(param);
	}

	/**
	 * 患者注册或者患者注册发卡
	 */
	@Override
	public RegOrDistrResultDTO patRegOrDistrCard(RegOrDistrParamDTO param) throws BizException {
		PatRegOrDistrCardBP bp = new PatRegOrDistrCardBP();
		return bp.execTrans(param);
	}

}
