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
 * 启用医疗记录基础模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class EnableEmrBaseTplBp {
	public EmrBaseTplDO[] exec(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		if (emrBaseTplDOs == null || emrBaseTplDOs.length <= 0) {
			return null;
		}
		EmrBaseTplDO[] result = EnableEmrBaseTpl(emrBaseTplDOs);
		return result;
	}

	/**
	 * 启用医疗记录基础模板
	 * 
	 * @param emrBaseTplDOs
	 * @return
	 * @throws BizException
	 */
	private EmrBaseTplDO[] EnableEmrBaseTpl(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		CheckContent(emrBaseTplDOs);
		for (EmrBaseTplDO emrBaseTplDO : emrBaseTplDOs) {
			EnableEmrBaseTpl(emrBaseTplDO);
		}
		EmrBaseTplDO[] result = SaveEmrBaseTpl(emrBaseTplDOs);
		return result;
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrBaseTplDOs
	 * @throws BizException
	 */
	private void CheckContent(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		CheckContentBeforeEnabelBp bp = new CheckContentBeforeEnabelBp();
		bp.exec(emrBaseTplDOs);
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
	 * 启用医疗记录基础模板
	 * 
	 * @param emrBaseTplDO
	 * @throws BizException
	 */
	private void EnableEmrBaseTpl(EmrBaseTplDO emrBaseTplDO) throws BizException {
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO udidocDo = udidocServiceExt.findByCode(IBdSrvDictCodeTypeConst.SD_SU_BASEMRTPL,
				IBdSrvDictCodeConst.SD_SU_BASEMRTPL_ENABLE);

		emrBaseTplDO.setSd_su_basemrtpl(udidocDo.getCode());
		emrBaseTplDO.setId_su_basemrtpl(udidocDo.getId_udidoc());
		emrBaseTplDO.setId_su_code(udidocDo.getCode());
		emrBaseTplDO.setId_su_name(udidocDo.getName());
		emrBaseTplDO.setFg_active(FBoolean.TRUE);
		emrBaseTplDO.setTime_active(AppUtils.getServerDateTime());
		emrBaseTplDO.setEmp_active(Context.get().getUserId());
		emrBaseTplDO.setEmp_stop(null);
		emrBaseTplDO.setTime_stop(null);
		emrBaseTplDO.setStatus(DOStatus.UPDATED);
	}
}
