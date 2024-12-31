package iih.bd.pp.anhuiinsur.bgtasks;

import java.util.LinkedHashMap;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuiinsur.bgtasks.bp.ImportMedInsurRecBp;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 导入医保记录后台任务
 * 
 * @author hao_wu
 *
 */
public class ImportMedInsurRecBgTask implements IBackgroundWorkPlugin {

	// 下载记录ID
	private String _downRecId;

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgWorkingContext) throws BizException {
		InitBgTaskParam(bgWorkingContext);
		MedInsurFileDownRecDO downRec = WhaitImportTaskComplete();
		ImportMedInsurRec(downRec);
		return new PreAlertObject();
	}

	/**
	 * 等待导入医保数据任务完成
	 * 
	 * @throws BizException
	 */
	private MedInsurFileDownRecDO WhaitImportTaskComplete() throws BizException {
		int count = 0;
		while (true) {
			MedInsurFileDownRecDO downRec = GetDownRecByDownId();
			if (downRec != null) {
				return downRec;
			}
			count++;
			if (count++ >= 200) {
				// 等待十分钟，如果等不到，则不执行
				throw new BizException("等待导入医保数据任务完成次数达到200，自动退出");
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
	 * 根据下载记录主键获取下载记录
	 * 
	 * @return
	 * @throws BizException
	 */
	private MedInsurFileDownRecDO GetDownRecByDownId() throws BizException {
		IMedinsurfiledownrecRService medinsurfiledownrecRService = ServiceFinder
				.find(IMedinsurfiledownrecRService.class);
		MedInsurFileDownRecDO downRec = medinsurfiledownrecRService.findById(this._downRecId);
		return downRec;
	}

	/**
	 * 导入医保目录记录
	 * 
	 * @param downRec
	 * @throws BizException
	 */
	private void ImportMedInsurRec(MedInsurFileDownRecDO downRec) throws BizException {
		ImportMedInsurRecBp bp = new ImportMedInsurRecBp();
		bp.exec(downRec);
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

		this._downRecId = (String) paramMap.get(IBdPpBgTaskParamCodeConst.CODE_IMPORTMEDINSURREC_DOWNRECID);

		CheckParams();
	}

	/**
	 * 检查参数
	 * 
	 * @throws BizException
	 */
	private void CheckParams() throws BizException {
		if (StringUtils.isEmpty(this._downRecId)) {
			throw new BizException("下载记录主键不允许为空");
		}
	}
}
