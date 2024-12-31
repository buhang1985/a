package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.op.tmpl.TmplRstDTO;
import iih.ci.ord.i.op.tmpl.TmplSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 辅助录入助手保存逻辑接口
 * 
 * @author wangqingzhu
 *
 */
public interface ITmplSaveBP {
	/**
	 * 模板保存医疗单
	 * 
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract TmplRstDTO save(CiEnContextDTO ctx, TmplSaveDTO arg) throws BizException;
}
