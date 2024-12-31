package iih.bd.pp.anhuiinsur.bgtasks;

import java.util.LinkedHashMap;

import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.IInsureService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 导入医保信息后台任务
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurBgTask implements IBackgroundWorkPlugin {

	/**
	 * 医保上下文
	 */
	InsureContext _insureContext;
	/**
	 * 文件Key，医保计划编码
	 */
	private String _fileKey;
	// 医保项目类型
	private String _hpSrvTp;

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgWorkingContext) throws BizException {
		InitBgTaskParam(bgWorkingContext);
		ImportMedInsur();
		return new PreAlertObject();
	}

	/**
	 * 导入医保信息
	 * 
	 * @throws BizException
	 */
	private void ImportMedInsur() throws BizException {
		IInsureService insureService = ServiceFinder.find(IInsureService.class);
		insureService.saveMedInsurDir(this._insureContext, this._hpSrvTp, this._fileKey);
		// ImportMedInsurBp bp = new ImportMedInsurBp();
		// bp.exec(this._fileKey, this._hpCode, this._hpSrvTp);
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

		this._fileKey = (String) paramMap.get(IBdPpBgTaskParamCodeConst.CODE_IMPORTMEDINSUR_FILEKEY);
		this._insureContext = (InsureContext) paramMap.get(IBdPpBgTaskParamCodeConst.CODE_IMPORTMEDINSUR_HPCODE);
		this._hpSrvTp = (String) paramMap.get(IBdPpBgTaskParamCodeConst.CODE_IMPORTMEDINSUR_HPSRVTP);
	}
}