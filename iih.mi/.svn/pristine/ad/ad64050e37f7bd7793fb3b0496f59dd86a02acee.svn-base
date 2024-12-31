package iih.mi.verify.s;

import iih.mi.biz.dto.verify.d.VerifyInputDTO;
import iih.mi.verify.bp.GetEntVerifyBP;
import iih.mi.verify.bp.GetIpVerifyBP;
import iih.mi.verify.bp.GetOepVerifyBP;
import iih.mi.verify.i.IMIVerifyRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
/**
 * 智能审核实现类
 * @author hanjq  2019年3月29日
 */
public class MIVerifyServiceImpl implements IMIVerifyRService {

	/**
	 * 获取就诊审核信息
	 * @param id_ent
	 * @return
	 * @throws BizException
	 * @author hanjq 2019年4月9日
	 */
	@Override
	public VerifyInputDTO getEntVerifyInput(String id_ent) throws BizException {
		GetEntVerifyBP bp = new GetEntVerifyBP();
		return bp.exce(id_ent);
	}

	@Override
	public VerifyInputDTO getOepVerifyInput(FArrayList id_ors, String id_ent) throws BizException {
		GetOepVerifyBP bp = new GetOepVerifyBP();
		return bp.exce(id_ors, id_ent);
	}

	@Override
	public VerifyInputDTO getIpVerifyInput(FArrayList id_ors, String id_ent) throws BizException {
		GetIpVerifyBP bp = new GetIpVerifyBP();
		return bp.exce(id_ors, id_ent);
	}
}
