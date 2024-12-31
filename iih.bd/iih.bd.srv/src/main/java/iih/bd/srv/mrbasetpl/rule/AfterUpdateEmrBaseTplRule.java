package iih.bd.srv.mrbasetpl.rule;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsCudService;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsRService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 基础病历模板更新后规则
 * 
 * @author hao_wu
 *
 */
public class AfterUpdateEmrBaseTplRule implements IRule<EmrBaseTplDO> {

	@Override
	public void process(EmrBaseTplDO... arg0) throws BizException {
		for (EmrBaseTplDO emrBaseTplDO : arg0) {
			updateBaseMrTplStream(emrBaseTplDO);
		}
	}

	/**
	 * 更新基础病历模板流数据
	 * 
	 * @param emrBaseTplDO
	 * @throws BizException
	 */
	private void updateBaseMrTplStream(EmrBaseTplDO emrBaseTplDO) throws BizException {
		BaseMrTplStreamDO baseMrTplStreamDO = getBaseMrTplStream(emrBaseTplDO);
		if (baseMrTplStreamDO != null) {
			updatePropValue(baseMrTplStreamDO, emrBaseTplDO);
			updateBaseMrTplStream(baseMrTplStreamDO);
		}
	}

	/**
	 * 更新基础病历模板流数据属性值
	 * 
	 * @param baseMrTplStreamDO
	 * @param emrBaseTplDO
	 */
	private void updatePropValue(BaseMrTplStreamDO baseMrTplStreamDO, EmrBaseTplDO emrBaseTplDO) {
		if (baseMrTplStreamDO == null || emrBaseTplDO == null 
				|| emrBaseTplDO.getId_basemrtpl() == null || emrBaseTplDO.getFs() == null) {
			return;
		}
		baseMrTplStreamDO.setFs(emrBaseTplDO.getFs());
		baseMrTplStreamDO.setStatus(DOStatus.UPDATED);
	}

	/**
	 * 查找对应基础病历模板流数据
	 * 
	 * @param emrBaseTplDO
	 * @return
	 * @throws BizException
	 */
	private BaseMrTplStreamDO getBaseMrTplStream(EmrBaseTplDO emrBaseTplDO) throws BizException {
		if (emrBaseTplDO == null || emrBaseTplDO.getId_basemrtpl() == null) {
			return null;
		}
		IBasemrtplfsRService basemrtplfsRService = ServiceFinder.find(IBasemrtplfsRService.class);
		BaseMrTplStreamDO[] result = basemrtplfsRService.findByAttrValString(BaseMrTplStreamDO.ID_BASEMRTPL,
				emrBaseTplDO.getId_basemrtpl());
		if (result != null && result.length == 1) {
			return result[0];
		}
		return null;
	}

	/**
	 * 调用服务更新基础病历模板流数据
	 * 
	 * @param baseMrTplStreamDO
	 * @throws BizException
	 */
	private void updateBaseMrTplStream(BaseMrTplStreamDO baseMrTplStreamDO) throws BizException {
		if (baseMrTplStreamDO == null || baseMrTplStreamDO.getStatus() != DOStatus.UPDATED) {
			return;
		}
		IBasemrtplfsCudService basemrtplfsCudService = ServiceFinder.find(IBasemrtplfsCudService.class);
		basemrtplfsCudService.update(new BaseMrTplStreamDO[] { baseMrTplStreamDO });
	}

}
