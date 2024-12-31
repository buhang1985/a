package iih.bd.srv.mrctmca.s.bp;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.emrtype.d.MrTpDO;
import iih.bd.srv.emrtype.i.IEmrtypeRService;
import iih.bd.srv.mrctmca.d.MrCaCtmItmDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 使用数据集分类获取错误项目列表业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GetErrorItemArrBySetCaBp {

	public MrCaCtmItmDO[] exec(String setCaId, MrCaCtmItmDO[] mrCaCtmItmArr) throws BizException {
		if (StringUtils.isEmpty(setCaId)) {
			throw new BizException("数据集分类不允许为空。");
		}
		if (mrCaCtmItmArr == null || mrCaCtmItmArr.length <= 0) {
			return null;
		}
		MrCaCtmItmDO[] result = GetErrorItemArrBySetCa(setCaId, mrCaCtmItmArr);
		return result;

	}

	/**
	 * 用数据集分类获取错误项目列表
	 * 
	 * @param dataSetCaId
	 * @param mrCaCtmItmArr
	 * @return
	 * @throws BizException
	 */
	private MrCaCtmItmDO[] GetErrorItemArrBySetCa(String dataSetCaId, MrCaCtmItmDO[] mrCaCtmItmArr)
			throws BizException {
		HashMap<String, MrTpDO> mrTpMap = GetMrTpMapByDataSetCaId(dataSetCaId);
		ArrayList<MrCaCtmItmDO> errorList = new ArrayList<MrCaCtmItmDO>();
		for (MrCaCtmItmDO mrCaCtmItmDO : mrCaCtmItmArr) {
			if (!StringUtils.isEmpty(mrCaCtmItmDO.getId_mrtp()) && !mrTpMap.containsKey(mrCaCtmItmDO.getId_mrtp())) {
				errorList.add(mrCaCtmItmDO);
			}
		}
		return errorList.toArray(new MrCaCtmItmDO[0]);
	}

	/**
	 * 获取指定数据集分类下的医疗记录类型字典
	 * 
	 * @param dataSetCaId
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, MrTpDO> GetMrTpMapByDataSetCaId(String dataSetCaId) throws BizException {
		IEmrtypeRService emrtypeRService = ServiceFinder.find(IEmrtypeRService.class);
		String whereStr = String.format("ID_DATA_SET IN (SELECT ID_SET FROM BD_SET WHERE ID_SETCA = '%s')",
				dataSetCaId);
		String orderStr = "code";
		MrTpDO[] result = emrtypeRService.find(whereStr, orderStr, FBoolean.FALSE);
		HashMap<String, MrTpDO> mrTpMap = BuildMrTpMap(result);
		return mrTpMap;
	}

	/**
	 * 构建医疗记录类型字典
	 * 
	 * @param result
	 * @return
	 */
	private HashMap<String, MrTpDO> BuildMrTpMap(MrTpDO[] result) {
		HashMap<String, MrTpDO> mrTpMap = new HashMap<String, MrTpDO>();
		for (MrTpDO mrTpDO : result) {
			mrTpMap.put(mrTpDO.getId_mrtp(), mrTpDO);
		}
		return mrTpMap;
	}

}
