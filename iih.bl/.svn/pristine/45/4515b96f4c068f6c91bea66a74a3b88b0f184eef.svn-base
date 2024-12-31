package iih.bl.cg.s;

import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccount4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpAccountRlt4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgOpRefund4EnDTO;
import iih.bl.cg.dto.en.opaccount.d.BlCgReplaceEntDTO;
import iih.bl.cg.i.IBlCgForEnService;
import iih.bl.cg.s.bp.IsPreipTransfBP;
import iih.bl.cg.s.provide.en.BlCgOpAccount4EnBP;
import iih.bl.cg.s.provide.en.BlCgOpRefund4EnBP;
import iih.bl.cg.s.provide.en.BlCgUpdateCgWhenReplaceEntBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用记帐域对就诊提供服务
 * @author ly 2019/10/31
 *
 */
public class BlCgForEnServiceImpl implements IBlCgForEnService {

	/**
	 * 挂号记账
	 * @param accDto
	 * @return
	 * @throws BizException
	 * @author ly 2019/10/31
	 */
	@Override
	public BlCgOpAccountRlt4EnDTO opKeepAccount(BlCgOpAccount4EnDTO accDto) throws BizException {
		BlCgOpAccount4EnBP bp = new BlCgOpAccount4EnBP();
		return bp.exec(accDto);
	}
	
	/**
	 * 挂号取消记账
	 * @param rfdDto
	 * @throws BizException
	 * @author ly 2019/10/31
	 */
	@Override
	public void opRefundAccount(BlCgOpRefund4EnDTO rfdDto) throws BizException{
		BlCgOpRefund4EnBP bp = new BlCgOpRefund4EnBP();
		bp.exec(rfdDto);
	}
	
	/**
	 * 替诊时更新费用
	 * @param dto
	 * @throws BizException
	 * @author ly 2019/11/18
	 */
	@Override
	public void updateCgWhenReplaceEnt(BlCgReplaceEntDTO dto) throws BizException{
		BlCgUpdateCgWhenReplaceEntBP bp = new BlCgUpdateCgWhenReplaceEntBP();
		bp.exec(dto);
	}

	/**
	 * 是否存在预住院费用转入门诊/住院
	 */
	@Override
	public FBoolean isPreipTransf(String idEnt, FBoolean isOep) throws BizException {
		IsPreipTransfBP bp = new IsPreipTransfBP();
		return bp.exec(idEnt,isOep);
	}
}
