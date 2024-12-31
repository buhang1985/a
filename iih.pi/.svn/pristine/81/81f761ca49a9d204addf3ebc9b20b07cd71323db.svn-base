package iih.pi.reg.s;

import iih.pi.reg.i.IPiPatRegService;
import iih.pi.reg.s.wsstd.bp.elehealcard.UpdateEleHealCardBp;
import iih.pi.reg.s.wsstd.bp.patinfo.GetPiPatInfoBP;
import iih.pi.reg.s.wsstd.bp.patreg.PatRegAndDistrCardBP;
import xap.mw.core.data.BizException;

/**
 * 患者域对外标准webservice服务
 * @author shaokx 2019/01/28
 *
 */
public class PiPatRegServiceImpl implements IPiPatRegService{

	/**
	 * 患者信息查询
	 * @param param
	 * @return
	 * @throws BizException
	 * @author shaokx 2019/1/28
	 */
	@Override
	public String getPiPatInfo(String param) throws BizException {
		GetPiPatInfoBP bp = new GetPiPatInfoBP();
		return bp.exec(param);
	}

	/**
	 * 患者注册发卡或者患者注册
	 */
	@Override
	public String patRegAndDistrCard(String param) throws BizException {
		PatRegAndDistrCardBP bp = new PatRegAndDistrCardBP();
		return bp.execTrans(param);
	}

	/**
	 * 更新电子健康卡(该接口的基础是患者已建档)
	 */
	@Override
	public String updateEleHealCard(String param) throws BizException {
		UpdateEleHealCardBp bp = new UpdateEleHealCardBp();
		return bp.exec(param);
	}
}
