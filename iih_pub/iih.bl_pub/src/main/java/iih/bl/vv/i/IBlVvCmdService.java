package iih.bl.vv.i;

import iih.bl.vv.dto.blcpnout.d.BlCpnOutDTO;
import xap.mw.core.data.BizException;

/**
 * 优惠券模块数据维护服务
 * @author ly 2018/02/25
 *
 */
public interface IBlVvCmdService {
	
    /**
     * 优惠券发放
     * @param 扫码枪扫码或者手动输入患者编码后则代表该优惠券已发放给患者
     * @author houll
     * 
     */
    public abstract void couponGrant(String idPat, String cpnCode) throws BizException;
    /**
     * 删除优惠券记录
     * @author houll
     */
    public abstract void patCpnOutDle(BlCpnOutDTO dto) throws BizException;

}
