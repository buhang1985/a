package iih.bd.srv.emrtpl.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.utils.UdidocUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 病历模板审核驳回业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EmrTplAuditRejectBp {

	public EmrTplDO[] exec(EmrTplDO[] emrTplArray) throws BizException {
		if (emrTplArray == null || emrTplArray.length <= 0) {
			return null;
		}
		EmrTplDO[] result = AuditReject(emrTplArray);
		return result;
	}

	/**
	 * 审核通过
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] AuditReject(EmrTplDO[] emrTplArray) throws BizException {
		UdidocDO suMrTpl = GetSuMrTpl();
		for (EmrTplDO emrTplDO : emrTplArray) {
			emrTplDO.setActivestate(1);
			emrTplDO.setIsdefault(FBoolean.FALSE);
			emrTplDO.setId_su_mrptl(suMrTpl.getId_udidoc());
			emrTplDO.setSd_su_mrptl(suMrTpl.getCode());
			emrTplDO.setMrtpl_code(suMrTpl.getCode());
			emrTplDO.setMrtpl_name(suMrTpl.getName());
			emrTplDO.setId_emp_review(Context.get().getUserId());
			emrTplDO.setStatus(DOStatus.UPDATED);
		}
		EmrTplDO[] result = SaveEmrTplData(emrTplArray);
		return result;
	}

	/**
	 * 获取病历模板状态_新建
	 * 
	 * @return
	 * @throws BizException
	 */
	private UdidocDO GetSuMrTpl() throws BizException {
		UdidocDO result = UdidocUtils.getUdidocByCode(IBdSrvDictCodeTypeConst.SD_SU_MRTPL,
				IBdSrvDictCodeConst.SD_SU_MRTPL_NEW);
		return result;
	}

	/**
	 * 保存病历模板
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO[] SaveEmrTplData(EmrTplDO[] emrTplArray) throws BizException {
		IEmrtplMDOCudService emrtplMdoCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMdoCudService.save(emrTplArray);
		return result;
	}

}