package iih.bd.srv.emrtpl.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.bd.srv.mrtplstream.i.IMrtplstreamRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用前检查模板内容业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckContentBeforeEnabelBp {
	public void exec(EmrTplDO[] emrTplDOs) throws BizException {
		if (emrTplDOs == null || emrTplDOs.length <= 0) {
			return;
		}
		CheckContent(emrTplDOs);
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrTplDOs
	 * @throws BizException
	 */
	private void CheckContent(EmrTplDO[] emrTplDOs) throws BizException {
		HashMap<String, EmrTplStreamDO> tplContentMap = GetTplContentMap(emrTplDOs);
		for (EmrTplDO emrTplDO : emrTplDOs) {
			CheckContent(emrTplDO, tplContentMap);
		}
	}

	/**
	 * 检查模板内容
	 * 
	 * @param emrTplDO
	 * @param tplContentMap
	 * @throws BizException
	 */
	private void CheckContent(EmrTplDO emrTplDO, HashMap<String, EmrTplStreamDO> tplContentMap) throws BizException {
		if (!tplContentMap.containsKey(emrTplDO.getId_mrtpl())) {
			String msg = String.format("医疗记录模板\"%s\"未设计，不允许启用。", emrTplDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取模板内容字典
	 * 
	 * @param emrTplDOs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, EmrTplStreamDO> GetTplContentMap(EmrTplDO[] emrTplDOs) throws BizException {
		String[] emrTplIdArray = GetEmrTplIdArray(emrTplDOs);

		IMrtplstreamRService mrtplstreamRService = ServiceFinder.find(IMrtplstreamRService.class);
		EmrTplStreamDO[] result = mrtplstreamRService.findByAttrValStrings(EmrTplStreamDO.ID_MRTPL, emrTplIdArray);
		HashMap<String, EmrTplStreamDO> map = ConvertToMap(result);
		return map;
	}

	/**
	 * 列表转为字典
	 * 
	 * @param baseMrTplStreamDOs
	 * @return
	 */
	private HashMap<String, EmrTplStreamDO> ConvertToMap(EmrTplStreamDO[] baseMrTplStreamDOs) {
		HashMap<String, EmrTplStreamDO> map = new HashMap<String, EmrTplStreamDO>();
		if (baseMrTplStreamDOs == null || baseMrTplStreamDOs.length <= 0) {
			return map;
		}
		for (EmrTplStreamDO emrTplStreamDO : baseMrTplStreamDOs) {
			map.put(emrTplStreamDO.getId_mrtpl(), emrTplStreamDO);
		}
		return map;
	}

	/**
	 * 获取基础病历模板主键列表
	 * 
	 * @param emrTplDOs
	 * @return
	 */
	private String[] GetEmrTplIdArray(EmrTplDO[] emrTplDOs) {
		ArrayList<String> idList = new ArrayList<String>();
		for (EmrTplDO emrTplDO : emrTplDOs) {
			idList.add(emrTplDO.getId_mrtpl());
		}
		return idList.toArray(new String[0]);
	}
}
