package iih.bd.srv.mrtplseg.i;

import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import xap.mw.core.data.BizException;

/**
 * 医疗记录段落模板启用服务
 * 
 * @author hao_wu
 *
 */
public interface IMrTplSegEnableService {
	/**
	 * 启用医疗记录段落模板
	 * 
	 * @param mrTplSegmentDOs
	 *            医疗记录段落模板列表
	 * @return
	 * @throws BizException
	 */
	public abstract MrTplSegmentDO[] Enable(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException;

	/**
	 * 停用医疗记录段落模板
	 * 
	 * @param mrTplSegmentDOs
	 *            医疗记录段落模板列表
	 * @return
	 * @throws BizException
	 */
	public abstract MrTplSegmentDO[] Disable(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException;
}
