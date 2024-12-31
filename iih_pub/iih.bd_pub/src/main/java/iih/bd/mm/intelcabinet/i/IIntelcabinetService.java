package iih.bd.mm.intelcabinet.i;

import iih.bd.mm.intelcabinet.d.IntelCabinetDO;
import xap.mw.core.data.BizException;

/**
 * 智能柜自定义服务.
 * @author shao_yuan
 *
 */
public interface IIntelcabinetService {
	
	/**
	*  启用
	*/	
	public abstract IntelCabinetDO[] start(IntelCabinetDO[] meterialDOs) throws BizException;
	
	/**
	*  禁用
	*/	
	public abstract IntelCabinetDO[] stop(IntelCabinetDO[] meterialDOs) throws BizException;

}
