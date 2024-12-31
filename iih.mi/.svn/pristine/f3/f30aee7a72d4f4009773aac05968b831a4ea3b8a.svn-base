package iih.mi.mibd.treatdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.treatdircomp.d.TreatDirCompDTO;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.mi.mibd.treatdircomp.i.ITreatdircompCudService;
import iih.mi.mibd.treatdircomp.s.bp.adapter.TreatdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: DelTreatCompBp
 * @Description: 删除诊疗对照服务
 * @author: dj.zhang
 * @date: 2018年2月8日 上午9:56:11
 */
public class DelTreatCompBp {

	/**
	 * @Title: exec
	 * @Description: 执行删除逻辑
	 * @param misId
	 * @param treatDirCompDtOs
	 * @return
	 * @throws BizException
	 */
	public TreatDirCompDTO[] exec(String misId, TreatDirCompDTO[] treatDirCompDtOs) throws BizException {
		TreatdircompDO[] treatDirCompDos = ConvertDtoToDircompDOs(misId, treatDirCompDtOs);
		deleteTreatDirComp(treatDirCompDos);
		String[] treatIds = getTreatIds(treatDirCompDtOs);
		TreatDirCompDTO[] treatDirCompDtos = findTreatCompByTreatId(misId, treatIds);
		return treatDirCompDtos;
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

	/**
	 * @Title: getTreatIds
	 * @Description: 获取ID集合
	 * @param treatDirCompDTOs
	 * @return
	 */
	private String[] getTreatIds(TreatDirCompDTO[] treatDirCompDtOs) throws BizException {
		ArrayList<String> ids = new ArrayList<String>();

		for (TreatDirCompDTO dto : treatDirCompDtOs) {
			ids.add(dto.getId_treat());
		}

		return ids.toArray(new String[0]);
	}

	/**
	 * @Title: deleteTreatDirComp
	 * @Description: 通过调用基础服务删除适配器处理生成的DO
	 * @param treatdircompDOs
	 * @return TreatdircompDO[]
	 * @throws BizException
	 */
	private void deleteTreatDirComp(TreatdircompDO[] treatDirCompDos) throws BizException {
		ITreatdircompCudService treatdircompCudService = ServiceFinder.find(ITreatdircompCudService.class);
		treatdircompCudService.save(treatDirCompDos);

	}

	/**
	 * @Title: ConvertDtoToDircompDOs
	 * @Description: 通过适配器，把DTO中的数据转移到DO中
	 * @param misId
	 * @param treatDirCompDTOs
	 * @return TreatdircompDO[]
	 * @throws BizException
	 */
	private TreatdircompDO[] ConvertDtoToDircompDOs(String misId, TreatDirCompDTO[] treatDirCompDtOs)
			throws BizException {
		ArrayList<TreatdircompDO> treatDirCompDoList = new ArrayList<TreatdircompDO>();
		TreatdircompDOAdapter adapter = new TreatdircompDOAdapter();

		for (TreatDirCompDTO compDTO : treatDirCompDtOs) {
			TreatdircompDO treatdircompDO = adapter.getTreatdircompDO(misId, compDTO);
			treatdircompDO.setEu_status(DirCompState.NOT_COMP);
			treatdircompDO.setStatus(DOStatus.DELETED);
			treatDirCompDoList.add(treatdircompDO);
		}
		return treatDirCompDoList.toArray(new TreatdircompDO[0]);
	}

}
