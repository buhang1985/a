package iih.ci.ord.i.ip.assi;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 住院医嘱模板主服务逻辑
 * @author wangqingzhu
 *
 */
public interface ICiIpTplMainService {
	/**
	 * 加载医疗单
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO load(CiEnContextDTO ctx, EmsLoadDTO arg) throws BizException;

	/**
	 * 保存医疗单
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO arg) throws BizException;

}
