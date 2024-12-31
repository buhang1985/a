package iih.bd.srv.emrtpl.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存医疗记录模板及其流文件业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveEmrTplAndStreamBp {

	public void exec(EmrTplDO emrTplDo, EmrTplStreamDO streamDO) throws BizException {
		EmrTplDO result = SaveEmrTpl(emrTplDo);
		SaveEmrTplStream(result, streamDO);
	}

	/**
	 * 保存医疗记录模板
	 * 
	 * @param emrTplDo
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO SaveEmrTpl(EmrTplDO emrTplDo) throws BizException {
		IEmrtplMDOCudService emrtplMDOCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMDOCudService.save(new EmrTplDO[] { emrTplDo });
		return result[0];
	}

	/**
	 * 保存医疗记录模板内容
	 * 
	 * @param result
	 * @param streamDO
	 * @throws BizException
	 */
	private void SaveEmrTplStream(EmrTplDO result, EmrTplStreamDO streamDO) throws BizException {
		streamDO.setId_mrtpl(result.getId_mrtpl());

		IMrtplstreamCudService mrtplstreamCudService = ServiceFinder.find(IMrtplstreamCudService.class);
		mrtplstreamCudService.save(new EmrTplStreamDO[] { streamDO });
	}

}
