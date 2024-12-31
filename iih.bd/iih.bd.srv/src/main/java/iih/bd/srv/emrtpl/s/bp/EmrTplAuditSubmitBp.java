package iih.bd.srv.emrtpl.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 病历模板提交业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EmrTplAuditSubmitBp {

	public EmrTplDO[] exec(EmrTplDO[] emrTplArray) throws BizException {
		if (emrTplArray == null || emrTplArray.length <= 0) {
			return null;
		}

		EmrTplDO[] result = Submit(emrTplArray);
		return result;
	}

	/**
	 * 提交
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] Submit(EmrTplDO[] emrTplArray) throws BizException {
		UdidocDO submitState = GetSubmitState();

		for (EmrTplDO emrTplDO : emrTplArray) {
			emrTplDO.setId_su_mrptl(submitState.getId_udidoc());
			emrTplDO.setSd_su_mrptl(submitState.getCode());
			emrTplDO.setMrtpl_code(submitState.getCode());
			emrTplDO.setMrtpl_name(submitState.getName());
			if (emrTplDO.getStatus() == DOStatus.UNCHANGED) {
				emrTplDO.setStatus(DOStatus.UPDATED);
			}
		}

		IEmrtplMDOCudService emrtplMdoCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMdoCudService.save(emrTplArray);
		return result;
	}

	/**
	 * 获取提交状态
	 * 
	 * @return
	 * @throws BizException
	 */
	private UdidocDO GetSubmitState() throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO result = udidocServiceExt.findByCode(IBdSrvDictCodeTypeConst.SD_SU_MRTPL,
				IBdSrvDictCodeConst.SD_SU_MRTPL_SUBMIT);
		return result;
	}

}
