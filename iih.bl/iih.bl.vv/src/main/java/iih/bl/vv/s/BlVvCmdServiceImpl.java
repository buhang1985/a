package iih.bl.vv.s;

import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import iih.bl.vv.i.IBlVvCmdService;
import iih.bl.vv.s.bp.BlCpnGraBP;
import iih.bl.vv.s.bp.PatCpnOutDleBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 优惠券模块数据维护服务
 * @author ly 2018/02/25
 *
 */
@Service(serviceInterfaces = { IBlVvCmdService.class }, binding = Binding.JSONRPC)
public class BlVvCmdServiceImpl implements IBlVvCmdService {

	/**
	 * 。
	 * 优惠券发放
	 * @param 扫码枪扫码或者手动输入患者编码后则代表该优惠券已发放给患者
	 * @author houll
	 * 
	 */

	@Override
	public void couponGrant(String idPat, String cpnCode) throws BizException {
		BlCpnGraBP bp=new BlCpnGraBP();
		bp.exec(idPat,cpnCode);
	}

	/**
	 * 删除优惠券记录
	 * @author houll
	 */

	@Override
	public void patCpnOutDle(BlCpnOutDTO dto) throws BizException {
		PatCpnOutDleBP bp=new PatCpnOutDleBP();
		bp.exec(dto);
	}

}
