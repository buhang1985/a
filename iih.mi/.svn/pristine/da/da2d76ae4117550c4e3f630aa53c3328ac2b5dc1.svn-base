package iih.mi.mibd.didircomp.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.d.DidircompDO;
import iih.mi.mibd.didircomp.i.IDidircompCudService;
import iih.mi.mibd.didircomp.s.bp.adapter.DidircompDoAdapter;
import iih.mi.mibd.docenum.d.DirCompState;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: DelDiCompBp
 * @Description: 删除病种对照服务
 * @author: dj.zhang
 * @date: 2018年2月8日 上午11:16:05
 */
public class DelDiCompBp {

	/**
	 * @Title: exec
	 * @Description: 执行删除逻辑
	 * @param misId
	 * @param diDirCompDtOs
	 * @return
	 */
	public DiDirCompDTO[] exec(String misId, DiDirCompDTO[] diDirCompDtOs) throws BizException {
		DidircompDO[] diDirCompDos = ConvertDtoToDircompDOs(misId, diDirCompDtOs);
		deleteDiDirComp(diDirCompDos);
		String[] diIds = getTreatIds(diDirCompDtOs);
		DiDirCompDTO[] diDirCompDtos = findDiCompByTreatId(misId, diIds);
		return diDirCompDtos;
	}

	/**
	 * @Title: ConvertDtoToDircompDOs
	 * @Description: 通过适配器，把DTO中的数据转移到DO中
	 * @param misId
	 * @param treatDirCompDTOs
	 * @return TreatdircompDO[]
	 * @throws BizException
	 */
	private DidircompDO[] ConvertDtoToDircompDOs(String misId, DiDirCompDTO[] diDirCompDtOs) throws BizException {
		ArrayList<DidircompDO> diDirCompDoList = new ArrayList<DidircompDO>();
		DidircompDoAdapter adapter = new DidircompDoAdapter();

		for (DiDirCompDTO compDTO : diDirCompDtOs) {
			DidircompDO didircompDO = adapter.getDidircompDO(misId, compDTO);
			didircompDO.setEu_status(DirCompState.NOT_COMP);
			didircompDO.setStatus(DOStatus.DELETED);
			diDirCompDoList.add(didircompDO);
		}
		return diDirCompDoList.toArray(new DidircompDO[0]);
	}

	/**
	 * @Title: deleteDiDirComp
	 * @Description: 通过调用基础服务删除适配器处理生成的DO
	 * @param diDirCompDos
	 * @throws BizException
	 */
	private void deleteDiDirComp(DidircompDO[] diDirCompDos) throws BizException {
		IDidircompCudService didircompCudService = ServiceFinder.find(IDidircompCudService.class);
		didircompCudService.save(diDirCompDos);
	}

	/**
	 * @Title: getDiIds
	 * @Description: 获得主键集合
	 * @param diDirCompDtos
	 * @return
	 */
	private String[] getTreatIds(DiDirCompDTO[] diDirCompDtOs) throws BizException {
		List<String> diIds = new ArrayList<String>();
		for (DiDirCompDTO diDirCompDTO : diDirCompDtOs) {
			diIds.add(diDirCompDTO.getId_di());
		}
		return diIds.toArray(new String[0]);
	}

	/**
	 * @Title: findDiCompByDiId
	 * @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
	 * @param misId
	 * @param diIds
	 * @return
	 * @throws BizException
	 */
	private DiDirCompDTO[] findDiCompByTreatId(String misId, String[] diIds) throws BizException {
		FindDiCompByDiIdBp bp = new FindDiCompByDiIdBp();
		DiDirCompDTO[] diDirComps = bp.exec(misId, diIds);
		return diDirComps;
	}

}
