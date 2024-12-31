package iih.bd.srv.mrtplseg.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import iih.bd.srv.mrtplseg.i.IMrtplsegCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用医疗记录段落模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EnableMrTplSegmentBp {
	public MrTplSegmentDO[] exec(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		if (mrTplSegmentDOs == null || mrTplSegmentDOs.length <= 0) {
			return null;
		}
		MrTplSegmentDO[] result = EnableMrTplSegment(mrTplSegmentDOs);
		return result;
	}

	/**
	 * 启用医疗记录段落模板
	 * 
	 * @param mrTplSegmentDOs
	 * @return
	 * @throws BizException
	 */
	private MrTplSegmentDO[] EnableMrTplSegment(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		CheckContent(mrTplSegmentDOs);
		for (MrTplSegmentDO mrTplSegmentDO : mrTplSegmentDOs) {
			EnableMrTplSegment(mrTplSegmentDO);
		}
		MrTplSegmentDO[] result = SaveMrTplSegment(mrTplSegmentDOs);
		return result;
	}

	/**
	 * 检查片段模板内容
	 * 
	 * @param mrTplSegmentDOs
	 * @throws BizException
	 */
	private void CheckContent(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		CheckContentBeforeEnabelBp bp = new CheckContentBeforeEnabelBp();
		bp.exec(mrTplSegmentDOs);
	}

	/**
	 * 保存医疗记录段落模板
	 * 
	 * @param mrTplSegmentDOs
	 * @return
	 * @throws BizException
	 */
	private MrTplSegmentDO[] SaveMrTplSegment(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		IMrtplsegCudService mrtplsegCudService = ServiceFinder.find(IMrtplsegCudService.class);
		MrTplSegmentDO[] result = mrtplsegCudService.save(mrTplSegmentDOs);
		return result;
	}

	/**
	 * 启用医疗记录段落模板
	 * 
	 * @param mrTplSegmentDO
	 */
	private void EnableMrTplSegment(MrTplSegmentDO mrTplSegmentDO) {
		mrTplSegmentDO.setFg_active(FBoolean.TRUE);
		mrTplSegmentDO.setDt_active(AppUtils.getServerDateTime());
		mrTplSegmentDO.setId_emp_active(Context.get().getUserId());
		mrTplSegmentDO.setDt_stop(null);
		mrTplSegmentDO.setId_emp_stop(null);
		mrTplSegmentDO.setStatus(DOStatus.UPDATED);
	}
}
