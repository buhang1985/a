package iih.ci.ord.i.op.pres;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.PresLoadDTO;
import iih.ci.ord.i.meta.PresRstDTO;
import iih.ci.ord.i.meta.PresSplDTO;
import xap.mw.core.data.BizException;

public interface ICiPresListMainService {

	/**
	 * 加载处方
	 * 
	 * @param ld
	 * @return
	 * @throws BizException
	 */
	public abstract PresRstDTO load(CiEnContextDTO ctx, PresLoadDTO ld) throws BizException;

	/**
	 * 重新分方
	 * 
	 * @param ld
	 * @return
	 * @throws BizException
	 */
	public abstract PresRstDTO reSeparate(CiEnContextDTO ctx, PresSplDTO ld) throws BizException;
}
