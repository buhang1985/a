package iih.bd.mhi.hptreatdircomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import iih.bd.mhi.hptreatdircomp.i.IHptreatdircompCudService;
import iih.bd.mhi.hptreatdircomp.s.bp.adapter.HpTreatDirCompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author dj.zhang
 *
 */
public class SaveHpTreatCompBp {

	/**
	 * 业务执行
	 * @param hpId
	 * @param hpTreatDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	public HpTreatDirCompDTO[] exec(String hpId, HpTreatDirCompDTO[] hpTreatDirCompDTOs) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品不允许为空。");
		}
		if (hpTreatDirCompDTOs == null || hpTreatDirCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的诊疗对照。");
		}
		HpTreatDirCompDTO[] result = saveHpTreatComp(hpId, hpTreatDirCompDTOs);
		return result;
	}

	/**
	 * 保存诊疗对照逻辑
	 * @param hpId
	 * @param hpTreatDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private HpTreatDirCompDTO[] saveHpTreatComp(String hpId, HpTreatDirCompDTO[] hpTreatDirCompDTOs)
			throws BizException {
		HpTreatDirCompDO[] hpTreatDirCompDos = ConvertDtoToDircompDOs(hpId, hpTreatDirCompDTOs);
		saveHpTreatDirComp(hpTreatDirCompDos);
		String[] hpTreatIds = getHpTreatIds(hpTreatDirCompDTOs);
		HpTreatDirCompDTO[] hpTreatDirCompDtos = findHpTreatCompByTreatId(hpId, hpTreatIds);
		return hpTreatDirCompDtos;
	}

	/**
	 * 通过适配器，把DTO中的数据转移到DO中
	 * @param hpId
	 * @param hpTreatDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private HpTreatDirCompDO[] ConvertDtoToDircompDOs(String hpId, HpTreatDirCompDTO[] hpTreatDirCompDTOs)
			throws BizException {
		ArrayList<HpTreatDirCompDO> treatDirCompDoList = new ArrayList<HpTreatDirCompDO>();
		HpTreatDirCompDOAdapter adapter = new HpTreatDirCompDOAdapter();

		for (HpTreatDirCompDTO compDTO : hpTreatDirCompDTOs) {
			HpTreatDirCompDO hpTreatDirCompDO = adapter.getTreatdircompDO(hpId, compDTO);
			hpTreatDirCompDO.setEu_status(DirCompState.COMPED);
			if (StringUtils.isNotEmpty(hpTreatDirCompDO.getId_comp_treat())) {
				hpTreatDirCompDO.setStatus(DOStatus.UPDATED);
			} else {
				hpTreatDirCompDO.setStatus(DOStatus.NEW);
			}
			treatDirCompDoList.add(hpTreatDirCompDO);
		}

		return treatDirCompDoList.toArray(new HpTreatDirCompDO[0]);
	}

	/**
	 * 通过调用基础服务保存
	 * @param hpTreatDirCompDos
	 * @throws BizException
	 */
	private void saveHpTreatDirComp(HpTreatDirCompDO[] hpTreatDirCompDos) throws BizException {
		IHptreatdircompCudService hpTreatdircompCudService = ServiceFinder.find(IHptreatdircompCudService.class);
		hpTreatdircompCudService.save(hpTreatDirCompDos);
	}

	/**
	 * 获取ID集合
	 * @param hpTreatDirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private String[] getHpTreatIds(HpTreatDirCompDTO[] hpTreatDirCompDTOs) throws BizException {
		ArrayList<String> ids = new ArrayList<String>();

		for (HpTreatDirCompDTO dto : hpTreatDirCompDTOs) {
			ids.add(dto.getId_treat());
		}

		return ids.toArray(new String[0]);
	}

	/**
	 * 通过医保产品ID,查找保存过的数据DO，进行回显
	 * @param hpId
	 * @param hpTreatIds
	 * @return
	 * @throws BizException
	 */
	private HpTreatDirCompDTO[] findHpTreatCompByTreatId(String hpId, String[] hpTreatIds) throws BizException {
		FindHpTreatCompByHpTreatIdBp bp = new FindHpTreatCompByHpTreatIdBp();
		HpTreatDirCompDTO[] hpTreatDirComps = bp.exec(hpId, hpTreatIds);
		return hpTreatDirComps;
	}

}
