package iih.bd.fc.s.bp.orpltpconfig;

import iih.bd.fc.orpltp.d.OrpltpStaDO;
import iih.bd.fc.orpltp.i.IOrpltpStaDOCudService;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncCudService;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspCudService;
import iih.bd.fc.orpltpstasdto.d.OrpltpStasDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医嘱执行闭环配置保存逻辑 2018年8月6日19:39:24
 * 
 * @author zhaoyangyang
 * @version xuxing_2018年9月4日12:39:12迭代
 *
 */
public class SaveOrpltpRecBp {
	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 */
	public OrpltpStasDTO exec(OrpltpStaDO sta, OrpltpStaFuncDO[] staFuncs, OrpltpStaMapDO[] staMaps) throws BizException {

		// 1、基础校验
		validation(sta);

		//2、闭环状态保存
		OrpltpStaDO staInfo = saveOrpltpsta(sta);

		//3、初始化功能对照和状态对照
		initStaAttr(staInfo, staFuncs, staMaps);

		//4、闭环功能对照保存
		OrpltpStaFuncDO[] staFuncsInfo = saveStaFuns(staFuncs);

		//5、闭环状态对照保存
		OrpltpStaMapDO[] staMapInfo = saveStaMap(staMaps);

		//6、组装返回值
		OrpltpStasDTO rtn = packageRtn(staInfo, staFuncsInfo, staMapInfo);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(OrpltpStaDO para) throws BizException {
		if (para == null)
			throw new BizException("医嘱闭环类型信息保存，参数空异常！");
	}

	/**
	 * 闭环状态保存
	 * @param sta
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaDO saveOrpltpsta(OrpltpStaDO sta) throws BizException {
		OrpltpStaDO[] rtns = ServiceFinder.find(IOrpltpStaDOCudService.class).save(new OrpltpStaDO[] { sta });
		if (rtns == null || rtns.length < 1)
			throw new BizException("医嘱闭环信息保存，闭环状态【" + sta.getName() + "】保存异常！");
		return rtns[0];
	}

	/**
	 * 初始化功能对照和状态对照
	 * @param staInfo
	 * @param staFuncs
	 * @param staMaps
	 */
	private void initStaAttr(OrpltpStaDO staInfo, OrpltpStaFuncDO[] staFuncs, OrpltpStaMapDO[] staMaps) {
		if (staFuncs != null && staFuncs.length > 0) {
			for (OrpltpStaFuncDO fun : staFuncs) {
				fun.setId_orpltpsta(staInfo.getId_orpltpsta());
				fun.setId_orpltp(staInfo.getId_orpltp());
			}
		}
		if (staMaps != null && staMaps.length > 0) {
			for (OrpltpStaMapDO map : staMaps) {
				map.setId_orpltpsta(staInfo.getId_orpltpsta());
			}
		}
	}

	/**
	 * 闭环功能对照保存
	 * @param staFuncs
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaFuncDO[] saveStaFuns(OrpltpStaFuncDO[] staFuncs) throws BizException {
		if (staFuncs != null && staFuncs.length > 0)
			return ServiceFinder.find(IOrpltpstafuncCudService.class).save(staFuncs);
		return null;
	}

	/**
	 * 闭环状态对照保存
	 * @param staMaps
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaMapDO[] saveStaMap(OrpltpStaMapDO[] staMaps) throws BizException {
		if (staMaps != null && staMaps.length > 0)
			ServiceFinder.find(IOrpltpstamspCudService.class).save(staMaps);
		return null;
	}

	/**
	 * 组装返回值
	 * @param sta
	 * @param staFuns
	 * @param staMaps
	 * @return
	 */
	private OrpltpStasDTO packageRtn(OrpltpStaDO sta, OrpltpStaFuncDO[] staFuns, OrpltpStaMapDO[] staMaps) {
		OrpltpStasDTO rtn = new OrpltpStasDTO();
		rtn.setId_orpltpdto(sta.getId_orpltpsta());
		rtn.setArray_sta(getArray(new BaseDO[] { sta }));
		rtn.setArray_stafunc(getArray(staFuns));
		rtn.setArray_stamap(getArray(staMaps));
		return rtn;
	}

	/**
	 * 获取FArrayList对象
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getArray(BaseDO[] params) {
		FArrayList rtn = new FArrayList();
		if (params == null || params.length < 1)
			return rtn;
		for (BaseDO param : params) {
			rtn.add(param);
		}
		return rtn;
	}
}
