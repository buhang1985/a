package iih.bd.srv.mrtplstream.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import iih.mkr.std.deset.d.SetDgDO;
import iih.mkr.std.deset.i.ISetDgDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗记录模板流数据中数据组业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckDataGroupBp {

	public void exec(EmrTplStreamDO emrTplStreamDO, String[] dataGrpCodeArr) throws BizException {
		if (emrTplStreamDO == null) {
			return;
		}
		CheckDataGroup(emrTplStreamDO, dataGrpCodeArr);
	}

	/**
	 * 检查数据组
	 * 
	 * @param emrTplStreamDO
	 * @param dataGrpCodeArr
	 * @throws BizException
	 */
	private void CheckDataGroup(EmrTplStreamDO emrTplStreamDO, String[] dataGrpCodeArr) throws BizException {
		SetDgDO[] missDgArr = GetMissDataGrp(emrTplStreamDO, dataGrpCodeArr);
		if (missDgArr == null || missDgArr.length <= 0) {
			return;
		}
		String msg = GetMsg(missDgArr);
		throw new BizException(msg);
	}

	/**
	 * 获取错误消息
	 * 
	 * @param missDgMap
	 * @return
	 */
	private String GetMsg(SetDgDO[] missDgArr) {
		StringBuilder msgBuilder = new StringBuilder();
		msgBuilder.append("缺少");
		for (int i = 0; i < missDgArr.length; i++) {
			if (i != 0) {
				msgBuilder.append(",");
			}
			msgBuilder.append("【");
			String name = StringUtils.isEmpty(missDgArr[i].getName()) ? missDgArr[i].getDedg_name()
					: missDgArr[i].getName();
			msgBuilder.append(name);
			msgBuilder.append("】");
		}
		msgBuilder.append("业务组，请添加。");
		return msgBuilder.toString();
	}

	/**
	 * 获取缺失的数据组
	 * 
	 * @param emrTplStreamDO
	 * @param dataGrpCodeArr
	 * @return
	 * @throws BizException
	 */
	private SetDgDO[] GetMissDataGrp(EmrTplStreamDO emrTplStreamDO, String[] dataGrpCodeArr) throws BizException {
		String whereStr = GetWherePart(emrTplStreamDO, dataGrpCodeArr);
		ISetDgDORService setDgDORService = ServiceFinder.find(ISetDgDORService.class);
		SetDgDO[] result = setDgDORService.find(whereStr, "", FBoolean.FALSE);
		result = RemoveDuplicateData(result);
		return result;
	}

	/**
	 * 移除重复数据
	 * 
	 * @param result
	 * @return
	 */
	private SetDgDO[] RemoveDuplicateData(SetDgDO[] result) {
		ArrayList<SetDgDO> missDataGrpList = new ArrayList<SetDgDO>();
		ArrayList<String> dataGrpNameList = new ArrayList<String>();
		for (SetDgDO setDgDO : result) {
			if (!dataGrpNameList.contains(setDgDO.getDedg_name())) {
				dataGrpNameList.add(setDgDO.getDedg_name());
				missDataGrpList.add(setDgDO);
			}
		}
		return missDataGrpList.toArray(new SetDgDO[0]);
	}

	/**
	 * 获取条件片段
	 * 
	 * @param emrTplStreamDO
	 * @param dataGrpCodeArr
	 * @return
	 */
	private String GetWherePart(EmrTplStreamDO emrTplStreamDO, String[] dataGrpCodeArr) {
		StringBuilder wherePartBuilder = new StringBuilder("Fg_active = 'Y'");
		String str = String.format(" AND Id_set in (select Id_data_set from bd_mrtp where id_mrtp in (select id_mrtp from bd_mrtpl where id_mrtpl = '%s')) ",
				emrTplStreamDO.getId_mrtpl());
		wherePartBuilder.append(str);

		if (dataGrpCodeArr != null && dataGrpCodeArr.length > 0) {
			String wherpart = SqlUtils.getInSqlByIds(DeDataGrpDO.CODE, dataGrpCodeArr);

			str = String.format(" AND Id_dg not in (select Id_dg from bd_dg where %s) ", wherpart);
			wherePartBuilder.append(str);
		}

		return wherePartBuilder.toString();
	}

}
