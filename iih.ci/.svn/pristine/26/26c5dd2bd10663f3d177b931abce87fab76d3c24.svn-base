package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单保存业务逻辑
 * @author wangqingzhu
 *
 */
public interface IEmsSaveBP  extends IEmsBP{
	/**
	 * 保存医疗单
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] save(CiEnContextDTO ctx,EmsSaveDTO[] szEms) throws BizException;
	
	/**
	 * 单体创建逻辑接口
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException;
}
