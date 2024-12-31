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
 * 下载医保对照审批未通过数据
 * 
 * @author dj.zhang
 *
 */
public class ImportUnPassDataBgTask implements IBackgroundWorkPlugin {

	/**
	 * 医保上下文
	 */
	InsureContext _insureContext;
	/**
	 * 文件Key，医保计划编码
	 */
	private String _fileKey;

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgWorkingContext) throws BizException {
		InitBgTaskParam(bgWorkingContext);
		ImportMedInsur();
		return new PreAlertObject();
	}

	/**
	 * 导入未审批信息
	 * 
	 * @throws BizException
	 */
	private void ImportMedInsur() {
		IInsureService insureService = ServiceFinder.find(IInsureService.class);
		insureService.saveUnPassData(this._insureContext, this._fileKey);
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

	}

}
