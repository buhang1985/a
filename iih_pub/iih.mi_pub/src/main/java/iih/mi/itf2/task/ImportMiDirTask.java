package iih.mi.itf2.task;

import java.util.LinkedHashMap;

import iih.bd.base.utils.StringUtils;
import iih.mi.itf2.dto.MiContext;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveEnum;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveInDetailParam;
import iih.mi.itf2.dto.midirsave.d.MiDirSaveInParam;
import iih.mi.itf2.service.IMiBdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 导入医保信息后台任务
 * Title: ImportMiDirTask.java
 * @author zhang.hw
 * @date 2019年5月30日  
 * @version 1.0
 */
public class ImportMiDirTask implements IBackgroundWorkPlugin {

	private MiContext _miContext;
	
	private FArrayList list;
	
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		InitBgTaskParam(arg0);
		CheckParam();
		IMiBdService miBdService = ServiceFinder.find(IMiBdService.class);
		MiDirSaveInParam inParam = new MiDirSaveInParam();
		inParam.setDetail(this.list);
		PreAlertObject preAlertObject = new PreAlertObject();
//		FArrayList2 rtnList = new FArrayList2();
//		try {
			miBdService.saveMiDir(this._miContext,inParam);
//			rtnList.add(new FBoolean(true));
//		} catch (Exception e) {
//			rtnList.add(new FBoolean(false));
//			throw new BizException("导入文件报错，报错原因："+e.getMessage());
//		}finally {
//			preAlertObject.setReturnObj(rtnList);
			return preAlertObject;
//		}
		
		
	}
	
	/**
	 * 检查参数
	 * @author zhang.hw
	 * @date 2019年5月30日
	 * @throws BizException
	 */
	private void CheckParam() throws BizException {
		MiDirSaveInDetailParam miDirSaveInDetailParam = (MiDirSaveInDetailParam)list.get(0);
		if (!StringUtils.isNotEmpty(miDirSaveInDetailParam.getDirtype())) {
			throw new BizException("医保服务类型不允许为空。");
		}
		if (this._miContext == null) {
			throw new BizException("医保上下文不允许为空。");
		}
		if (!StringUtils.isNotEmpty(miDirSaveInDetailParam.getDirkey())) {
			throw new BizException("后台任务——传递参数为空！请检查传参");
		}
	}
	
	/**
	 * 初始化后台任务参数
	 * @author zhang.hw
	 * @date 2019年5月30日
	 * @param bgWorkingContext
	 * @throws BizException
	 */
	private void InitBgTaskParam(BgWorkingContext bgWorkingContext) throws BizException {
		LinkedHashMap<String, Object> paramMap = bgWorkingContext.getKeyMap();
		if (paramMap == null||paramMap.size()==0) {
			throw new BizException("参数字典不允许为空。");
		}
		String jsonArray = (String) paramMap.get(MiDirSaveEnum.PARAM);
		if (StringUtils.isNotEmpty(jsonArray)) {
			MiDirSaveInDetailParam miDirSaveInDetail = new MiDirSaveInDetailParam();
			miDirSaveInDetail.deSerializeJson(jsonArray);
			this.list = new FArrayList();
			this.list.add(miDirSaveInDetail);
		}
		String insureContextJson = (String) paramMap.get(MiDirSaveEnum.MICONTEXT);
		if (StringUtils.isNotEmpty(insureContextJson)) {
			this._miContext = new MiContext();
			this._miContext.deSerializeJson(insureContextJson);
		}
	}
}
