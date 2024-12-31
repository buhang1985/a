package iih.bd.srv.mrbasetpl.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsRService;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用前检查模板内容业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckContentBeforeEnabelBp {
	public void exec(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		if (emrBaseTplDOs == null || emrBaseTplDOs.length <= 0) {
			return;
		}
		CheckContent(emrBaseTplDOs);
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrBaseTplDOs
	 * @throws BizException
	 */
	private void CheckContent(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		HashMap<String, BaseMrTplStreamDO> tplContentMap = GetTplContentMap(emrBaseTplDOs);
		for (EmrBaseTplDO emrBaseTplDO : emrBaseTplDOs) {
			CheckContent(emrBaseTplDO, tplContentMap);
		}
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrBaseTplDO
	 * @param tplContentMap
	 * @throws BizException
	 */
	private void CheckContent(EmrBaseTplDO emrBaseTplDO, HashMap<String, BaseMrTplStreamDO> tplContentMap)
			throws BizException {
		if (!tplContentMap.containsKey(emrBaseTplDO.getId_basemrtpl())) {
			String msg = String.format("医疗记录基础模板\"%s\"未设计，不允许启用。", emrBaseTplDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取模板内容字典
	 * 
	 * @param emrBaseTplDOs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, BaseMrTplStreamDO> GetTplContentMap(EmrBaseTplDO[] emrBaseTplDOs) throws BizException {
		String[] emrBaseTplIdArray = GetEmrBaseTplIdArray(emrBaseTplDOs);

		IBasemrtplfsRService basemrtplfsRService = ServiceFinder.find(IBasemrtplfsRService.class);
		BaseMrTplStreamDO[] result = basemrtplfsRService.findByAttrValStrings(BaseMrTplStreamDO.ID_BASEMRTPL,
				emrBaseTplIdArray);
		HashMap<String, BaseMrTplStreamDO> map = ConvertToMap(result);
		return map;
	}

	/**
	 * 列表转为字典
	 * 
	 * @param baseMrTplStreamDOs
	 * @return
	 */
	private HashMap<String, BaseMrTplStreamDO> ConvertToMap(BaseMrTplStreamDO[] baseMrTplStreamDOs) {
		HashMap<String, BaseMrTplStreamDO> map = new HashMap<String, BaseMrTplStreamDO>();
		if (baseMrTplStreamDOs == null || baseMrTplStreamDOs.length <= 0) {
			return map;
		}
		for (BaseMrTplStreamDO baseMrTplStreamDO : baseMrTplStreamDOs) {
			map.put(baseMrTplStreamDO.getId_basemrtpl(), baseMrTplStreamDO);
		}
		return map;
	}

	/**
	 * 获取基础病历模板主键列表
	 * 
	 * @param emrBaseTplDOs
	 * @return
	 */
	private String[] GetEmrBaseTplIdArray(EmrBaseTplDO[] emrBaseTplDOs) {
		ArrayList<String> idList = new ArrayList<String>();
		for (EmrBaseTplDO emrBaseTplDO : emrBaseTplDOs) {
			idList.add(emrBaseTplDO.getId_basemrtpl());
		}
		return idList.toArray(new String[0]);
	}
}
