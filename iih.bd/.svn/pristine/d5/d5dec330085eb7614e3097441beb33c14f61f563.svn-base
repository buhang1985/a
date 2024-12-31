package iih.bd.srv.mrbasetpl.bp;

import java.util.ArrayList;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsRService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 填充医疗记录基础模板流数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FillEmrBaseTplFsBp {

	public void exec(EmrBaseTplDO[] pageData) throws BizException {
		String[] pks = getDataPkValues(pageData);
		IBasemrtplfsRService basemrtplfsRService = ServiceFinder.find(IBasemrtplfsRService.class);
		BaseMrTplStreamDO[] result = basemrtplfsRService.findByAttrValStrings(BaseMrTplStreamDO.ID_BASEMRTPL, pks);
		setFs(pageData, result);
	}

	/**
	 * 设置流数据属性
	 * 
	 * @param pageData
	 * @param result
	 */
	private void setFs(EmrBaseTplDO[] pageData, BaseMrTplStreamDO[] result) {
		if (pageData == null || pageData.length <= 0) {
			return;
		}
		for (EmrBaseTplDO emrBaseTplDO : pageData) {
			BaseMrTplStreamDO baseMrTplStreamDO = getBaseMrTplStreamDOByIdBasemrtpl(result,
					emrBaseTplDO.getId_basemrtpl());
			if (baseMrTplStreamDO != null) {
				emrBaseTplDO.setFs(baseMrTplStreamDO.getFs());
			}
		}
	}

	/**
	 * 根据模板id获取流数据
	 * 
	 * @param result
	 * @param id_basemrtpl
	 * @return
	 */
	private BaseMrTplStreamDO getBaseMrTplStreamDOByIdBasemrtpl(BaseMrTplStreamDO[] result, String id_basemrtpl) {
		if (result == null || result.length <= 0) {
			return null;
		}
		for (BaseMrTplStreamDO baseMrTplStreamDO : result) {
			if (baseMrTplStreamDO != null && baseMrTplStreamDO.getId_basemrtpl() != null
					&& baseMrTplStreamDO.getId_basemrtpl().equals(id_basemrtpl)) {
				return baseMrTplStreamDO;
			}
		}
		return null;
	}

	/**
	 * 获取数据主键数组
	 * 
	 * @param pageData
	 * @return
	 */
	private String[] getDataPkValues(EmrBaseTplDO[] pageData) {
		ArrayList<String> pks = new ArrayList<String>();
		if (pageData != null) {
			for (EmrBaseTplDO emrBaseTplDO : pageData) {
				pks.add(emrBaseTplDO.getId_basemrtpl());
			}
		}
		return pks.toArray(new String[0]);
	}

}
