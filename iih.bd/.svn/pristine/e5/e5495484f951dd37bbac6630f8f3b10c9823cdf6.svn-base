package iih.bd.fc.s.bp.orpltpconfig;

import java.util.Arrays;

import iih.bd.fc.orpltpconfig.d.OrpltpStaDTO;
import iih.bd.fc.orpltpstafunc.d.OrpltpStaFuncDO;
import iih.bd.fc.orpltpstafunc.i.IOrpltpstafuncRService;
import iih.bd.fc.orpltpstamsp.d.OrpltpStaMapDO;
import iih.bd.fc.orpltpstamsp.i.IOrpltpstamspRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取闭环状态和状态对照，功能对照信息集合
 * 
 * @author xuxing_2017年6月21日15:10:39
 *
 */
public class GetOrpltpStaInfoByIdBp {

	/**
	 * 主入口
	 * 
	 * @param id_orpltpsta
	 * @return
	 * @throws BizException
	 */
	public OrpltpStaDTO exec(String id_orpltpsta) throws BizException {

		// 1、校验
		validation(id_orpltpsta);

		// 2、获取功能对照信息
		OrpltpStaFuncDO[] funcDOS = getOrpltpFuncs(id_orpltpsta);

		// 3、状态对照信息
		OrpltpStaMapDO[] staMaps = getOrpltpStaMaps(id_orpltpsta);

		// 4、拼装返回结果
		OrpltpStaDTO rtn = packageRtn(id_orpltpsta, funcDOS, staMaps);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param id_orpltp
	 * @throws BizException
	 */
	private void validation(String id_orpltpsta) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_orpltpsta)) {
			throw new BizException("参数空异常!");
		}
	}

	/**
	 * 获取功能对照集合
	 * 
	 * @param id_orpltpsta
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaFuncDO[] getOrpltpFuncs(String id_orpltpsta) throws BizException {
		IOrpltpstafuncRService findService = ServiceFinder.find(IOrpltpstafuncRService.class);
		return findService.findByAttrValString(OrpltpStaFuncDO.ID_ORPLTPSTA, id_orpltpsta);
	}

	/**
	 * 获取状态对照集合
	 * 
	 * @param id_orpltpsta
	 * @return
	 * @throws BizException
	 */
	private OrpltpStaMapDO[] getOrpltpStaMaps(String id_orpltpsta) throws BizException {
		IOrpltpstamspRService findService = ServiceFinder.find(IOrpltpstamspRService.class);
		return findService.findByAttrValString(OrpltpStaMapDO.ID_ORPLTPSTA, id_orpltpsta);
	}

	/**
	 * 拼装返回结果
	 * 
	 * @param id_orpltpsta
	 * @param staDO
	 * @param funcDOS
	 * @param staMaps
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private OrpltpStaDTO packageRtn(String id_orpltpsta, OrpltpStaFuncDO[] funcDOS, OrpltpStaMapDO[] staMaps) {

		OrpltpStaDTO rtn = new OrpltpStaDTO();
		rtn.setId_orpltpsta(id_orpltpsta);

		if (funcDOS != null && funcDOS.length > 0) {
			FArrayList arrayFunc = new FArrayList();
			arrayFunc.addAll(Arrays.asList(funcDOS));
			rtn.setArray_func(arrayFunc);
		}
		if (staMaps != null && staMaps.length > 0) {
			FArrayList arrayStaMap = new FArrayList();
			arrayStaMap.addAll(Arrays.asList(staMaps));
			rtn.setArray_stamap(arrayStaMap);
		}
		return rtn;
	}
}
