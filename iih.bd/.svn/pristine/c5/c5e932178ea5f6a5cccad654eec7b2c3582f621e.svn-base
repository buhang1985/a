package iih.bd.pp.hpsrvorca.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.ImportDTO;
import iih.bd.pp.hpsrvorca.d.ImportResultEnum;
import iih.bd.pp.service.i.IPriMaintainService;
import iih.bd.utils.log.BdPpLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 导入医保目录对照任务
 * 
 * @author hao_wu
 *
 */
public class ImportMedIListCompTask implements IBackgroundWorkPlugin {

	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext bgwContext) throws BizException {

		BdPpLogUtils.info("导入医保目录对照任务开始。");

		CheckParam(bgwContext);

		InitContext(bgwContext);

		String id_hp = (String) bgwContext.getKeyMap().get("id_hp");
		String fileData = (String) bgwContext.getKeyMap().get("fileData");
		String fg_drug = (String) bgwContext.getKeyMap().get("fg_drug");

		IPriMaintainService priMaintainService = ServiceFinder.find(IPriMaintainService.class);
		ImportDTO[] importResult = priMaintainService.importHPSrvorca(id_hp, fileData,
				new FBoolean(fg_drug).booleanValue());

		FArrayList2 importResultList = new FArrayList2();
		for (ImportDTO importDTO : importResult) {
			importResultList.add(importDTO);
		}

		FBoolean saveSuccess = SaveToDb(importResult, fg_drug);

		FArrayList2 rtnList = new FArrayList2();
		rtnList.add(saveSuccess);
		rtnList.add(importResultList);

		PreAlertObject preAlertObject = new PreAlertObject();
		preAlertObject.setReturnObj(rtnList);

		BdPpLogUtils.info("导入医保目录对照任务结束。");

		BdPpLogUtils.info("importResultListSize:%s", importResultList.size());

		BdPpLogUtils.info("rtnListSize:%s", rtnList.size());

		return preAlertObject;
	}

	/**
	 * 保存导入结果到数据库
	 * 
	 * @param importResult
	 * @throws BizException
	 */
	private FBoolean SaveToDb(ImportDTO[] importResult, String fg_drug) throws BizException {
		HPSrvorcaDO[] successDatas = GetSuccessDatas(importResult);
		IPriMaintainService priMaintainService = ServiceFinder.find(IPriMaintainService.class);
		FBoolean saveSuccess = priMaintainService.saveHPSrvorca(successDatas, new FBoolean(fg_drug).booleanValue());
		return saveSuccess;
	}

	/**
	 * 获取成功的数据
	 * 
	 * @param importResult
	 * @return
	 */
	private HPSrvorcaDO[] GetSuccessDatas(ImportDTO[] importResult) {
		ArrayList<HPSrvorcaDO> succDataList = new ArrayList<HPSrvorcaDO>();
		for (ImportDTO importDTO : importResult) {
			if (importDTO != null && ImportResultEnum.IMPORTSUCCESS.equals(importDTO.getResult())) {
				succDataList.add((HPSrvorcaDO) importDTO.getHpsrvorca().get(0));
			}
		}
		return succDataList.toArray(new HPSrvorcaDO[0]);
	}

	/**
	 * 初始化上下文
	 * 
	 * @param bgwContext
	 */
	private void InitContext(BgWorkingContext bgwContext) {
		String id_grp = (String) bgwContext.getKeyMap().get("id_grp");
		String id_org = (String) bgwContext.getKeyMap().get("id_org");

		Context.get().setGroupId(id_grp);
		Context.get().setOrgId(id_org);
	}

	/**
	 * 检查参数
	 * 
	 * @param bgwContext
	 * @throws BizException
	 */
	private void CheckParam(BgWorkingContext bgwContext) throws BizException {
		LinkedHashMap<String, Object> paramMap = bgwContext.getKeyMap();
		if (paramMap == null || paramMap.size() <= 0) {
			throw new BizException("参数字典不允许为空。");
		}
		if (!paramMap.containsKey("id_grp")) {
			ThrowNullParamException("id_grp");
		}
		if (!paramMap.containsKey("id_org")) {
			ThrowNullParamException("id_org");
		}
		if (!paramMap.containsKey("id_hp")) {
			ThrowNullParamException("id_hp");
		}
		if (!paramMap.containsKey("fileData")) {
			ThrowNullParamException("fileData");
		}
		if (!paramMap.containsKey("fg_drug")) {
			ThrowNullParamException("fg_drug");
		}
	}

	/**
	 * 抛出空参数异常
	 * 
	 * @param paramCode
	 * @throws BizException
	 */
	private void ThrowNullParamException(String paramCode) throws BizException {
		String msg = String.format("参数\"%s\"不允许为空。", paramCode);
		throw new BizException(msg);
	}

}
