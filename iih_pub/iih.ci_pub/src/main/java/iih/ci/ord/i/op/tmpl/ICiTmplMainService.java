package iih.ci.ord.i.op.tmpl;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public interface ICiTmplMainService {
	/**
	 * 加载模板
	 * 
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO load(CiEnContextDTO ctx, TmplLoadDTO ems) throws BizException;

	/**
	 * 保存模板
	 * 
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO save(CiEnContextDTO ctx, TmplSaveDTO ems) throws BizException;
}
