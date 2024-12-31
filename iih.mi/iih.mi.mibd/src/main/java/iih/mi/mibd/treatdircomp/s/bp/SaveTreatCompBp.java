package iih.mi.mibd.treatdircomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.mi.mibd.treatdircomp.i.ITreatdircompCudService;
import iih.mi.mibd.treatdircomp.s.bp.adapter.TreatdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: SaveTreatCompBp
 * @Description: 保存诊疗对照业务处理
 * @author: dj.zhang
 * @date: 2018年1月31日 下午2:18:44
 */
public class SaveTreatCompBp {
	/**
	 * @Title: exec
	 * @Description: 业务执行
	 * @param misId
	 * @param treatDirCompDTOs
	 * @return TreatDirCompDTO[]
	 * @throws BizException
	 */
	public TreatDirCompDTO[] exec(String misId, TreatDirCompDTO[] treatDirCompDTOs) throws BizException {
		if (StringUtils.isEmpty(misId)) {
			throw new BizException("医保系统不允许为空。");
		}
		if (treatDirCompDTOs == null || treatDirCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的诊疗对照。");
		}

		TreatDirCompDTO[] result = saveTreatComp(misId, treatDirCompDTOs);
		return result;
	}

	/**
	 * @Title: saveTreatComp
	 * @Description: 保存诊疗对照逻辑
	 * @param misId
	 * @param treatDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private TreatDirCompDTO[] saveTreatComp(String misId, TreatDirCompDTO[] treatDirCompDTOs) throws BizException {

		TreatdircompDO[] treatDirCompDos = ConvertDtoToDircompDOs(misId, treatDirCompDTOs);
		saveTreatDirComp(treatDirCompDos);
		String[] treatIds = getTreatIds(treatDirCompDTOs);
		TreatDirCompDTO[] treatDirCompDtos = findTreatCompByTreatId(misId, treatIds);

		return treatDirCompDtos;
	}

	/**
	 * @Title: ConvertDtoToDircompDOs
	 * @Description: 通过适配器，把DTO中的数据转移到DO中
	 * @param misId
	 * @param treatDirCompDTOs
	 * @return TreatdircompDO[]
	 * @throws BizException
	 */
	private TreatdircompDO[] ConvertDtoToDircompDOs(String misId, TreatDirCompDTO[] treatDirCompDTOs)
			throws BizException {

		ArrayList<TreatdircompDO> treatDirCompDoList = new ArrayList<TreatdircompDO>();
		TreatdircompDOAdapter adapter = new TreatdircompDOAdapter();

		for (TreatDirCompDTO compDTO : treatDirCompDTOs) {
			TreatdircompDO treatdircompDO = adapter.getTreatdircompDO(misId, compDTO);
			treatdircompDO.setEu_status(DirCompState.COMPED);
			if (StringUtils.isNotEmpty(treatdircompDO.getId_comp_treat())) {
				treatdircompDO.setStatus(DOStatus.UPDATED);
			} else {
				treatdircompDO.setStatus(DOStatus.NEW);
			}
			treatDirCompDoList.add(treatdircompDO);
		}

		return treatDirCompDoList.toArray(new TreatdircompDO[0]);
	}

	/**
	 * @Title: saveTreatDirComp
	 * @Description: 通过调用基础服务保存适配器处理生成的DO
	 * @param treatdircompDOs
	 * @return TreatdircompDO[]
	 * @throws BizException
	 */
	private void saveTreatDirComp(TreatdircompDO[] treatdircompDOs) throws BizException {
		ITreatdircompCudService treatdircompCudService = ServiceFinder.find(ITreatdircompCudService.class);
		treatdircompCudService.save(treatdircompDOs);
	}

	/**
	 * @Title: getTreatIds
	 * @Description: 获取ID集合
	 * @param treatDirCompDTOs
	 * @return
	 */
	private String[] getTreatIds(TreatDirCompDTO[] treatDirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();

		for (TreatDirCompDTO dto : treatDirCompDTOs) {
			ids.add(dto.getId_treat());
		}

		return ids.toArray(new String[0]);
	}

	/**
	 * @Title: findTreatCompByTreatId
	 * @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
	 * @param misId
	 * @param treatIds
	 * @return
	 * @throws BizException
	 */
	private TreatDirCompDTO[] findTreatCompByTreatId(String misId, String[] treatIds) throws BizException {
		FindTreatCompByTreatIdBp bp = new FindTreatCompByTreatIdBp();
		TreatDirCompDTO[] treatDirComps = bp.exec(misId, treatIds);
		return treatDirComps;
	}

}
