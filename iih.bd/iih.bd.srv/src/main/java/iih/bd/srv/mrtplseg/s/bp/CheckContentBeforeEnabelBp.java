package iih.bd.srv.mrtplseg.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplsec.i.IMrtplsecRService;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 启用前检查模板内容业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckContentBeforeEnabelBp {
	public void exec(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		if (mrTplSegmentDOs == null || mrTplSegmentDOs.length <= 0) {
			return;
		}
		CheckContent(mrTplSegmentDOs);
	}

	/**
	 * 检查模板内容
	 * 
	 * @param mrTplSegmentDOs
	 * @throws BizException
	 */
	private void CheckContent(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		HashMap<String, MrTplSegFsDO> tplContentMap = GetTplContentMap(mrTplSegmentDOs);
		for (MrTplSegmentDO emrTplDO : mrTplSegmentDOs) {
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
	private void CheckContent(MrTplSegmentDO emrTplDO, HashMap<String, MrTplSegFsDO> tplContentMap)
			throws BizException {
		if (!tplContentMap.containsKey(emrTplDO.getId_mrtplsec())) {
			String msg = String.format("医疗记录模板\"%s\"未设计，不允许启用。", emrTplDO.getName());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取模板内容字典
	 * 
	 * @param mrTplSegmentDOs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, MrTplSegFsDO> GetTplContentMap(MrTplSegmentDO[] mrTplSegmentDOs) throws BizException {
		String[] emrTplSegmentIdArray = GetEmrTplSegmentIdArray(mrTplSegmentDOs);

		IMrtplsecRService mrtplsecRService = ServiceFinder.find(IMrtplsecRService.class);
		MrTplSegFsDO[] result = mrtplsecRService.findByAttrValStrings(MrTplSegFsDO.ID_MRTPLSEC, emrTplSegmentIdArray);
		HashMap<String, MrTplSegFsDO> map = ConvertToMap(result);
		return map;
	}

	/**
	 * 列表转为字典
	 * 
	 * @param baseMrTplStreamDOs
	 * @return
	 */
	private HashMap<String, MrTplSegFsDO> ConvertToMap(MrTplSegFsDO[] baseMrTplStreamDOs) {
		HashMap<String, MrTplSegFsDO> map = new HashMap<String, MrTplSegFsDO>();
		if (baseMrTplStreamDOs == null || baseMrTplStreamDOs.length <= 0) {
			return map;
		}
		for (MrTplSegFsDO mrTplSegFsDO : baseMrTplStreamDOs) {
			map.put(mrTplSegFsDO.getId_mrtplsec(), mrTplSegFsDO);
		}
		return map;
	}

	/**
	 * 获取基础病历模板主键列表
	 * 
	 * @param mrTplSegmentDOs
	 * @return
	 */
	private String[] GetEmrTplSegmentIdArray(MrTplSegmentDO[] mrTplSegmentDOs) {
		ArrayList<String> idList = new ArrayList<String>();
		for (MrTplSegmentDO emrTplDO : mrTplSegmentDOs) {
			idList.add(emrTplDO.getId_mrtplsec());
		}
		return idList.toArray(new String[0]);
	}
}
