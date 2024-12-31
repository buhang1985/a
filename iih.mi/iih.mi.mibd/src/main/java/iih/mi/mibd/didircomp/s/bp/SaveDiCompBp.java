package iih.mi.mibd.didircomp.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.didircomp.d.DiDirCompDTO;
import iih.mi.mibd.didircomp.d.DidircompDO;
import iih.mi.mibd.didircomp.i.IDidircompCudService;
import iih.mi.mibd.didircomp.s.bp.adapter.DidircompDoAdapter;
import iih.mi.mibd.docenum.d.DirCompState;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: SaveDiCompBp
 * @Description: 保存病种对照
 * @author: dj.zhang
 * @date: 2018年2月6日 下午4:25:20
 */
public class SaveDiCompBp {

	public DiDirCompDTO[] exec(String misId, DiDirCompDTO[] diDirCompDtos) throws BizException {
		if (StringUtils.isEmpty(misId)) {
			throw new BizException("医保系统不能为空");
		}
		if (diDirCompDtos == null || diDirCompDtos.length <= 0) {
			throw new BizException("没有需要保存的病种对照。");
		}
		DiDirCompDTO[] result = saveDiCompBp(misId, diDirCompDtos);
		return result;
	}

	/**
	 * @Title: saveDiCompBp
	 * @Description: 保存逻辑三步骤：适配，保存，查找保存数据
	 * @param misId
	 * @param diDirCompDtos
	 * @return
	 * @throws BizException
	 */
	private DiDirCompDTO[] saveDiCompBp(String misId, DiDirCompDTO[] diDirCompDtos) throws BizException {
		DidircompDO[] diDirCompDos = ConvertDtoToDircompDOs(misId, diDirCompDtos);
		saveDiDirComp(diDirCompDos);
		String[] diIds = getDiIds(diDirCompDtos);
		DiDirCompDTO[] diDirCompDTOs = findDiCompByDiId(misId, diIds);
		return diDirCompDTOs;
	}

	/**
	 * @Title: findDiCompByDiId
	 * @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
	 * @param misId
	 * @param diIds
	 * @return
	 * @throws BizException
	 */
	private DiDirCompDTO[] findDiCompByDiId(String misId, String[] diIds) throws BizException {
		FindDiCompByDiIdBp bp = new FindDiCompByDiIdBp();
		DiDirCompDTO[] diDirComps = bp.exec(misId, diIds);
		return diDirComps;
	}

	/**
	 * @Title: getDiIds
	 * @Description: 获得主键集合
	 * @param diDirCompDtos
	 * @return
	 */
	private String[] getDiIds(DiDirCompDTO[] diDirCompDtos) {
		List<String> diIds = new ArrayList<String>();
		for (DiDirCompDTO diDirCompDTO : diDirCompDtos) {
			diIds.add(diDirCompDTO.getId_di());
		}
		return diIds.toArray(new String[0]);
	}

	/**
	 * @Title: saveDiDirComp
	 * @Description: 保存对照
	 * @param diDirCompDos
	 * @throws BizException
	 */
	private void saveDiDirComp(DidircompDO[] diDirCompDos) throws BizException {
		IDidircompCudService didircompCudService = ServiceFinder.find(IDidircompCudService.class);
		didircompCudService.save(diDirCompDos);
	}

	/**
	 * @Title: ConvertDtoToDircompDOs
	 * @Description: 调用适配器
	 * @param misId
	 * @param diDirCompDtos
	 * @return
	 * @throws BizException
	 */
	private DidircompDO[] ConvertDtoToDircompDOs(String misId, DiDirCompDTO[] diDirCompDtos) throws BizException {
		List<DidircompDO> diDirCompDtosList = new ArrayList<DidircompDO>();
		DidircompDoAdapter adapter = new DidircompDoAdapter();
		for (DiDirCompDTO diDirCompDTO : diDirCompDtos) {
			DidircompDO didircompDO = adapter.getDidircompDO(misId, diDirCompDTO);
			didircompDO.setEu_status(DirCompState.COMPED);
			if (StringUtils.isNotEmpty(didircompDO.getId_comp_di())) {
				didircompDO.setStatus(DOStatus.UPDATED);
			} else {
				didircompDO.setStatus(DOStatus.NEW);
			}
			diDirCompDtosList.add(didircompDO);
		}
		return diDirCompDtosList.toArray(new DidircompDO[0]);
	}

}
