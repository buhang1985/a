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
 * 停用医疗记录段落模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DisableMrTplSegmentBp {
	public MrTplSegmentDO[] exec(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		if (mrTplSegmentDOs == null || mrTplSegmentDOs.length <= 0) {
			return null;
		}
		MrTplSegmentDO[] result = DisableMrTplSegment(mrTplSegmentDOs);
		return result;
	}

	/**
	 * 启用医疗记录段落模板
	 * 
	 * @param mrTplSegmentDOs
	 * @return
	 * @throws BizException
	 */
	private MrTplSegmentDO[] DisableMrTplSegment(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		for (MrTplSegmentDO mrTplSegmentDO : mrTplSegmentDOs) {
			DisableMrTplSegment(mrTplSegmentDO);
		}
		MrTplSegmentDO[] result = SaveMrTplSegment(mrTplSegmentDOs);
		return result;
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
	private void DisableMrTplSegment(MrTplSegmentDO mrTplSegmentDO) {
		mrTplSegmentDO.setFg_active(FBoolean.FALSE);
		mrTplSegmentDO.setDt_active(null);
		mrTplSegmentDO.setId_emp_active(null);
		mrTplSegmentDO.setDt_stop(AppUtils.getServerDateTime());
		mrTplSegmentDO.setId_emp_stop(Context.get().getUserId());
		mrTplSegmentDO.setStatus(DOStatus.UPDATED);
	}
}
