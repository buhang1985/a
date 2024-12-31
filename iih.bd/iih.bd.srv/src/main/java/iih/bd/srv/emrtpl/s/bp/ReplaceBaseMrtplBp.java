package iih.bd.srv.emrtpl.s.bp;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.emrtpl.i.IEmrtplMDOCudService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 替换基础模板业务逻辑
 * 
 * @author hao_wu
 *
 */
public class ReplaceBaseMrtplBp {

	public EmrTplDO exec(EmrTplDO emrTplDo, EmrBaseTplDO emrBaseTplDo) throws BizException {
		if (emrTplDo == null || emrBaseTplDo == null) {
			return null;
		}
		UpdateData(emrTplDo, emrBaseTplDo);
		EmrTplDO result = Save(emrTplDo);
		return result;
	}

	/**
	 * 更新数据
	 * 
	 * @param emrTplDo
	 * @param emrBaseTplDo
	 */
	private void UpdateData(EmrTplDO emrTplDo, EmrBaseTplDO emrBaseTplDo) {
		emrTplDo.setId_basemrtpl(emrBaseTplDo.getId_basemrtpl());
		emrTplDo.setBase_code(emrBaseTplDo.getCode());
		emrTplDo.setBase_name(emrBaseTplDo.getName());
		emrTplDo.setBase_idmred(emrBaseTplDo.getId_mred());
		if (emrTplDo.getStatus() == DOStatus.UNCHANGED) {
			emrTplDo.setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 保存模板
	 * 
	 * @param emrTplDo
	 * @return
	 * @throws BizException
	 */
	private EmrTplDO Save(EmrTplDO emrTplDo) throws BizException {
		IEmrtplMDOCudService emrtplMDOCudService = ServiceFinder.find(IEmrtplMDOCudService.class);
		EmrTplDO[] result = emrtplMDOCudService.save(new EmrTplDO[] { emrTplDo });
		if (result != null && result.length >= 1) {
			return result[0];
		}
		return null;
	}
}
