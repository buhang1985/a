package iih.bd.pp.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.s.bp.prinew.BdPpCalSrvPriceBP;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 通用更新服务价格业务逻辑</br>
 * srvIdFielName字段类型必须是String
 * 
 * 
 * @author hao_wu 2019-5-6
 *
 */
public class CommUpdateSrvPriBp {

	public void exec(BaseDO[] datas, String srvIdFielName, String priFielName) throws BizException {
		if (ArrayUtils.isEmpty(datas) || StringUtils.isBlank(srvIdFielName) || StringUtils.isBlank(priFielName)) {
			return;
		}
		
		// 1.获取服务主键集合
		String[] srvIds = getSrvIds(datas, srvIdFielName);
		if (ArrayUtils.isEmpty(srvIds)) {
			return;
		}

		// 2.获取价格字典
		HashMap<String, FDouble> priMap = getPriMapBySrvIds(srvIds);
		if (priMap == null) {
			return;
		}

		// 3.更新价格
		updatePri(datas, srvIdFielName, priFielName, priMap);
	}

	/**
	 * 更新价格
	 * 
	 * @param datas
	 * @param srvIdFielName
	 * @param priFielName
	 * @param priMap
	 */
	private void updatePri(BaseDO[] datas, String srvIdFielName, String priFielName, HashMap<String, FDouble> priMap) {
		for (BaseDO data : datas) {
			String srvId = (String) data.getAttrVal(srvIdFielName);
			if (StringUtils.isNotBlank(srvId) && priMap.containsKey(srvId)) {
				FDouble pri = priMap.get(srvId);
				data.setAttrVal(priFielName, pri);
			}
		}
	}

	/**
	 * 获取服务主键集合
	 * 
	 * @param datas
	 * @param srvIdFielName
	 * @return
	 */
	private String[] getSrvIds(BaseDO[] datas, String srvIdFielName) {
		ArrayList<String> srvIdList = new ArrayList<String>();
		for (BaseDO data : datas) {
			String srvId = (String) data.getAttrVal(srvIdFielName);
			if (StringUtils.isNotBlank(srvId)) {
				srvIdList.add(srvId);
			}
		}
		return srvIdList.toArray(new String[0]);
	}

	/**
	 * 获取价格字典
	 * 
	 * @param srvIds
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, FDouble> getPriMapBySrvIds(String[] srvIds) throws BizException {
		BdPpCalSrvPriceBP bp = new BdPpCalSrvPriceBP();
		BdPriViewDTO[] viewDtos = bp.exec(srvIds, null);

		if (ArrayUtils.isEmpty(viewDtos)) {
			return null;
		}

		HashMap<String, FDouble> priMap = new HashMap<String, FDouble>();
		for (BdPriViewDTO bdPriViewDTO : viewDtos) {
			priMap.put(bdPriViewDTO.getId_srv(), bdPriViewDTO.getPrice_std());
		}
		return priMap;
	}
}
