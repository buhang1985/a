package iih.ei.std.consis.v1.task;

import java.util.LinkedHashMap;

import iih.ei.std.consis.v1.d.PushBDDataParamDTO;
import iih.ei.std.consis.v1.task.bp.PushBDDataBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 推送基础数据到门诊配药机
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushBDDataTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext cxt) throws BizException {

		PushBDDataParamDTO paramDto = getParamDto(cxt.getKeyMap());
		pushBDData(paramDto);

		return new PreAlertObject();
	}

	/**
	 * 推送基础数据
	 * 
	 * @param paramDto
	 * @throws BizException
	 */
	protected void pushBDData(PushBDDataParamDTO paramDto) throws BizException {
		PushBDDataBp bp = new PushBDDataBp();
		bp.exec(paramDto);
	}

	protected PushBDDataParamDTO getParamDto(LinkedHashMap<String, Object> paramMap) throws BizException {
		if (paramMap == null) {
			throw new BizException("参数字典为空。");
		}

		PushBDDataParamDTO paramDto = new PushBDDataParamDTO();

		if (paramMap.containsKey(ParamCodeConst.OperId)) {
			paramDto.setOperId((String) paramMap.get(ParamCodeConst.OperId));
		}

		if (paramMap.containsKey(ParamCodeConst.PharmacyId)) {
			paramDto.setPharmacyId((String) paramMap.get(ParamCodeConst.PharmacyId));
		}

		if (paramMap.containsKey(ParamCodeConst.PushDrugDic)) {
			String pushDrugDic = (String) paramMap.get(ParamCodeConst.PushDrugDic);
			paramDto.setPushDrugDic("Y".equals(pushDrugDic) ? FBoolean.TRUE : FBoolean.FALSE);
		}

		if (paramMap.containsKey(ParamCodeConst.PushWinDic)) {
			String pushWinDic = (String) paramMap.get(ParamCodeConst.PushWinDic);
			paramDto.setPushWinDic("Y".equals(pushWinDic) ? FBoolean.TRUE : FBoolean.FALSE);
		}

		if (paramMap.containsKey(ParamCodeConst.PushDeptDic)) {
			String pushDeptDic = (String) paramMap.get(ParamCodeConst.PushDeptDic);
			paramDto.setPushDeptDic("Y".equals(pushDeptDic) ? FBoolean.TRUE : FBoolean.FALSE);
		}

		if (paramMap.containsKey(ParamCodeConst.PushPharmacyPsnDic)) {
			String pushPharmacyPsnDic = (String) paramMap.get(ParamCodeConst.PushPharmacyPsnDic);
			paramDto.setPushPharmacyPsnDic("Y".equals(pushPharmacyPsnDic) ? FBoolean.TRUE : FBoolean.FALSE);
		}

		if (paramMap.containsKey(ParamCodeConst.PushDrugLocDic)) {
			String pushDrugLocDic = (String) paramMap.get(ParamCodeConst.PushDrugLocDic);
			paramDto.setPushDrugLocDic("Y".equals(pushDrugLocDic) ? FBoolean.TRUE : FBoolean.FALSE);
		}

		return paramDto;
	}

}
