package iih.bd.pp.anhuiinsur.bgtasks;

import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.bgtasks.bp.GenerateDiffInfoBp;
import iih.bd.pp.medinsurrecdiff.d.MedInsurRecDiffDO;
import iih.bd.pp.medinsurrecdiff.i.IMedinsurrecdiffMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 生成差异信息后台任务
 * 
 * @author hao_wu
 *
 */
public class GenerateDiffInfoBgTask implements IBackgroundWorkPlugin {

	/**
	 * 差异主键，导入任务主键
	 */
	private String _diffId;

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgWorkingContext) throws BizException {
		InitBgTaskParam(bgWorkingContext);
		MedInsurRecDiffDO recDiff = WhaitImportRecTaskComplete();
		GenerateDiffInfo(recDiff);
		return new PreAlertObject();
	}

	/**
	 * 等待导入记录任务完成
	 * 
	 * @throws BizException
	 */
	private MedInsurRecDiffDO WhaitImportRecTaskComplete() throws BizException {
		int count = 0;
		while (true) {
			MedInsurRecDiffDO recDiff = GetRecDiffByDiffId();
			if (recDiff != null) {
				return recDiff;
			}
			count++;
			if (count++ >= 200) {
				// 等待十分钟，如果等不到，则不执行
				throw new BizException("等待导入医保记录后台任务完成次数达到200，自动退出");
			}
			// 每次睡三秒
			try {
				Thread.sleep(3 * 1000);
			} catch (InterruptedException e) {
				throw new BizException(e);
			}
		}
	}

	/**
	 * 通过差异主键获取差异信息，获取到差异信息，则代表可进行差异数据生成
	 * 
	 * @return
	 * @throws BizException
	 */
	private MedInsurRecDiffDO GetRecDiffByDiffId() throws BizException {
		IMedinsurrecdiffMDORService medinsurrecdiffMDORService = ServiceFinder.find(IMedinsurrecdiffMDORService.class);
		MedInsurRecDiffDO result = medinsurrecdiffMDORService.findById(this._diffId);
		return result;
	}

	/**
	 * 生成差异信息
	 * 
	 * @throws BizException
	 */
	private void GenerateDiffInfo(MedInsurRecDiffDO recDiff) throws BizException {
		GenerateDiffInfoBp bp = new GenerateDiffInfoBp();
		bp.exec(recDiff);
	}

	/**
	 * 初始化后台任务参数
	 * 
	 * @param bgWorkingContext
	 * @throws BizException
	 */
	private void InitBgTaskParam(BgWorkingContext bgWorkingContext) throws BizException {
		LinkedHashMap<String, Object> paramMap = bgWorkingContext.getKeyMap();
		if (paramMap == null) {
			throw new BizException("参数字典不允许为空。");
		}

		this._diffId = (String) paramMap.get(IBdPpBgTaskParamCodeConst.CODE_GENERATEDIFFINFO_DIFFID);
		CheckParams();
	}

	/**
	 * 检查参数
	 * 
	 * @throws BizException
	 */
	private void CheckParams() throws BizException {
		if (StringUtils.isEmpty(this._diffId)) {
			throw new BizException("差异主键不允许为空");
		}
	}
}
