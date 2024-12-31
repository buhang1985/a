package iih.pi.reg.patbbr.i;

import xap.mw.core.data.BizException;
import iih.pi.reg.patbbr.d.PiPatBbrDO;

/**
* 患者不良记录数据维护服务
*/
public interface IPatbbrExtCudService {
	
	public abstract PiPatBbrDO[] Close(PiPatBbrDO[] piPatBbrs) throws BizException;
	
}
