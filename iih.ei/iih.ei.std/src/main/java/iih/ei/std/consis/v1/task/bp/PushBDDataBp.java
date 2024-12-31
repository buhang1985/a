package iih.ei.std.consis.v1.task.bp;

import org.apache.commons.lang.StringUtils;

import iih.ei.std.consis.v1.d.PushBDDataParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 推送基础数据业务逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushBDDataBp {

	public void exec(PushBDDataParamDTO paramDto) throws BizException {

		// 1.检查任务参数
		checkParam(paramDto);

		// 2.初始化上下文
		initContext(paramDto);

		// 3.推送摆药机基础数据
		pushBDData(paramDto);
	}

	/**
	 * 使用后台任务参数初始化上下文
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	protected void initContext(PushBDDataParamDTO paramDto) throws BizException {

		DAFacade daFacade = new DAFacade();
		PsnDocDO psnDocDo = (PsnDocDO) daFacade.findByPK(PsnDocDO.class, paramDto.getOperId());
		if (psnDocDo == null) {
			String msg = String.format("未查询到操作员信息，操作员ID：%s。", paramDto.getOperId());
			throw new BizException(msg);
		}

		Context.get().setGroupId(psnDocDo.getId_group());
		Context.get().setOrgId(psnDocDo.getId_org());
		Context.get().setDeptId(psnDocDo.getId_dep());
		Context.get().setStuffId(psnDocDo.getId_psndoc());
	}

	/**
	 * 初始化任务参数
	 * 
	 * @param paramMap
	 * @throws BizException
	 */
	protected void checkParam(PushBDDataParamDTO paramDto) throws BizException {
		if (StringUtils.isEmpty(paramDto.getOperId())) {
			throw new BizException("操作员不允许为空。");
		}
	}

	/**
	 * 推送摆药机基础数据
	 * 
	 * @throws BizException
	 */
	protected void pushBDData(PushBDDataParamDTO paramDto) throws BizException {

		// 推送药品字典
		pushDrugDic(paramDto);

		// 推送窗口字典
		pushWinDic(paramDto);

		// 推送科室字典
		pushDeptDic(paramDto);

		// 推送药房人员字典
		pushPharmacyPsnDic(paramDto);

		// 推送药品货位字典
		pushDrugLocDic(paramDto);
	}

	/**
	 * 推送药品字典
	 * 
	 * @throws BizException
	 */
	protected void pushDrugDic(PushBDDataParamDTO paramDto) throws BizException {
		if (!FBoolean.TRUE.equals(paramDto.getPushDrugDic())) {
			return;
		}
		PushDrugDicBp bp = new PushDrugDicBp();
		bp.exec();
	}

	/**
	 * 推送窗口字典
	 * 
	 * @throws BizException
	 */
	protected void pushWinDic(PushBDDataParamDTO paramDto) throws BizException {
		if (!FBoolean.TRUE.equals(paramDto.getPushWinDic())) {
			return;
		}
		PushWinDicBp bp = new PushWinDicBp();
		bp.exec(paramDto.getPharmacyId());
	}

	/**
	 * 推送科室字典
	 * 
	 * @throws BizException
	 */
	protected void pushDeptDic(PushBDDataParamDTO paramDto) throws BizException {
		if (!FBoolean.TRUE.equals(paramDto.getPushDeptDic())) {
			return;
		}
		PushDeptDicBp bp = new PushDeptDicBp();
		bp.exec();
	}

	/**
	 * 推送药房人员字典
	 * 
	 * @throws BizException
	 */
	protected void pushPharmacyPsnDic(PushBDDataParamDTO paramDto) throws BizException {
		if (!FBoolean.TRUE.equals(paramDto.getPushPharmacyPsnDic())) {
			return;
		}
		PushPharmacyPsnDicBp bp = new PushPharmacyPsnDicBp();
		bp.exec(paramDto.getPharmacyId());
	}

	/**
	 * 推送药品货位字典
	 * 
	 * @throws BizException
	 */
	protected void pushDrugLocDic(PushBDDataParamDTO paramDto) throws BizException {
		if (!FBoolean.TRUE.equals(paramDto.getPushDrugLocDic())) {
			return;
		}
		PushDrugLocDicBp bp = new PushDrugLocDicBp();
		bp.exec();
	}
}
