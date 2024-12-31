package iih.bd.bs.ctmitf.i;

import iih.bd.bs.ctmitf.d.CtmImplDO;
import xap.mw.core.data.BizException;

/**
 * 客开接口实现类扩展服务接口
 * 
 * @author hao_wu 2019-7-29
 *
 */
public interface ICtmImplExtCudService {

	/**
	 * 升级为系统数据
	 * 
	 * @param ctmImpls
	 * @return
	 * @throws BizException
	 */
	public abstract CtmImplDO[] updateSys(CtmImplDO[] ctmImpls) throws BizException;
}
