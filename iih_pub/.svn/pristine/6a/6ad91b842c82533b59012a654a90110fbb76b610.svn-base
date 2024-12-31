package iih.nmr.ha.tcho.i;

import iih.nmr.ha.tcho.ipevalsigle.d.TchoipevalsigleAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public interface INmrTchoQueryService {

	/**
	 * 实例化护理文书实体，赋初始值
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList initData(String id_ent, String fullClassName) throws BizException;

	/**
	 * 获取住院患者及健康教育评价单
	 * 
	 * @param Id_ent
	 *            就诊 ID
	 * @param code_udi
	 *            自定义档案编码
	 * @return
	 * @throws BizException
	 * @author jinkk
	 */
	public TchoipevalsigleAggDO getIpevalsigle(String Id_ent, String code_udi) throws BizException;

}
