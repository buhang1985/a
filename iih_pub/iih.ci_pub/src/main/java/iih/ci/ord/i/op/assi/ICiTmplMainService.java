package iih.ci.ord.i.op.assi;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.TmplLoadDTO;
import iih.ci.ord.i.meta.TmplRstDTO;
import iih.ci.ord.i.meta.TmplSaveDTO;
import xap.mw.core.data.BizException;

public interface ICiTmplMainService {
	/**
	 * 加载模板
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO load(CiEnContextDTO ctx, TmplLoadDTO ems) throws BizException ;
	
	
	
	/**
	 * 保存模板
	 * @param ems
	 * @return
	 */
	public abstract TmplRstDTO save(CiEnContextDTO ctx, TmplSaveDTO ems) throws BizException ;
}
