package iih.bd.srv.mrbasetpl.s.bp;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.i.IMrbasetplCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 停用医疗记录基础模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DisableEmrBaseTplBp {
	public EmrBaseTplDO[] exec(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		if (emrBaseTplDOs == null || emrBaseTplDOs.length <= 0) {
			return null;
		}
		EmrBaseTplDO[] result = DisableEmrBaseTpl(emrBaseTplDOs);
		return result;
	}

	/**
	 * 停用医疗记录基础模板
	 * 
	 * @param emrBaseTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrBaseTplDO[] DisableEmrBaseTpl(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		for (EmrBaseTplDO emrBaseTplDO : emrBaseTplDOs) {
			DisableEmrBaseTpl(emrBaseTplDO);
		}
		EmrBaseTplDO[] result = SaveEmrBaseTpl(emrBaseTplDOs);
		return result;
	}

	/**
	 * 保存医疗记录基础模板
	 * 
	 * @param emrBaseTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrBaseTplDO[] SaveEmrBaseTpl(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		IMrbasetplCudService mrbasetplCudService = ServiceFinder.find(IMrbasetplCudService.class);
		EmrBaseTplDO[] result = mrbasetplCudService.save(emrBaseTplDOs);
		return result;
	}

	/**
	 * 停用医疗记录基础模板
	 * 
	 * @param emrBaseTplDO
	 * @throws BizException
	 */
	private void DisableEmrBaseTpl(EmrBaseTplDO emrBaseTplDO) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO udidocDo = udidocServiceExt.findByCode(IBdSrvDictCodeTypeConst.SD_SU_BASEMRTPL,
				IBdSrvDictCodeConst.SD_SU_BASEMRTPL_DISABLE);

		emrBaseTplDO.setSd_su_basemrtpl(udidocDo.getCode());
		emrBaseTplDO.setId_su_basemrtpl(udidocDo.getId_udidoc());
		emrBaseTplDO.setId_su_code(udidocDo.getCode());
		emrBaseTplDO.setId_su_name(udidocDo.getName());
		emrBaseTplDO.setFg_active(FBoolean.FALSE);
		emrBaseTplDO.setTime_active(null);
		emrBaseTplDO.setEmp_active(null);
		emrBaseTplDO.setEmp_stop(Context.get().getUserId());
		emrBaseTplDO.setTime_stop(AppUtils.getServerDateTime());
		emrBaseTplDO.setStatus(DOStatus.UPDATED);
	}
}
