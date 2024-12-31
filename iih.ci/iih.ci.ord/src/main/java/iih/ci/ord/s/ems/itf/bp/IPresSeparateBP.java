package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.PresRstDTO;
import iih.ci.ord.i.meta.PresSplDTO;
import xap.mw.core.data.BizException;

/**
 * 处方分方业务处理
 * 
 * @author wangqingzhu
 *
 */
public interface IPresSeparateBP {
	/**
	 * 重新分方
	 * 
	 * @param ld
	 * @return
	 * @throws BizException
	 */
	public abstract PresRstDTO reSeparate(CiEnContextDTO ctx, PresSplDTO ld) throws BizException;
}
