package iih.bd.mhi.hpdrugdircomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.docenum.d.DirCompState;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompCudService;
import iih.bd.mhi.hpdrugdircomp.s.bp.adapter.HpDrugdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存药品对照业务逻辑
 * 
 * @author hexx
 */
public class SaveHpDrugCompBp {

	/**
	 * @Title: exec
	 * @Description: 业务执行
	 * @param hpId
	 * @param hpdrugdirCompDTOs
	 * @return HpDrugDirCompDTO[]
	 * @throws BizException
	 */
	public HpDrugDirCompDTO[] exec(String hpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保系统不允许为空");
		}
		if (hpdrugdirCompDTOs == null || hpdrugdirCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的药品对照。");
		}
		HpDrugDirCompDTO[] result = saveHpDrugComp(hpId, hpdrugdirCompDTOs);
		return result;
	}

	/**
	 * 保存药品对照信息
	 * 
	 * @param hpdrugdirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private HpDrugDirCompDTO[] saveHpDrugComp(String hpId, HpDrugDirCompDTO[] hpdrugdirCompDTOs) throws BizException {
		HpDrugDirCompDO[] hpdrugDirCompDOs = ConvertDtoToDircompDOs(hpId, hpdrugdirCompDTOs);
		saveHpDrugDirComp(hpdrugDirCompDOs);
		String[] drugIds = getHpDrugIds(hpdrugdirCompDTOs);
		HpDrugDirCompDTO[] hpdrugDirCompDtos = findHpDrugCompByDrugId(hpId, drugIds);
		return hpdrugDirCompDtos;
	}

	/**
	 * @Title: ConvertDtoToDircompDOs
	 * @Description: 通过适配器，把DTO中的数据转移到DO中
	 * @param hpId
	 */
	private HpDrugDirCompDO[] ConvertDtoToDircompDOs(String hpId, HpDrugDirCompDTO[] HpDrugDirCompDTOs) {
		ArrayList<HpDrugDirCompDO> hpdrugDirCompDoList = new ArrayList<HpDrugDirCompDO>();
		HpDrugdircompDOAdapter adapter = new HpDrugdircompDOAdapter();
		for (HpDrugDirCompDTO hpcompDTO : HpDrugDirCompDTOs) {
			HpDrugDirCompDO hpdrugdircompDO = adapter.getHpDrugDirCompDO(hpId, hpcompDTO);
			hpdrugdircompDO.setEu_status(DirCompState.COMPED);
			if (StringUtils.isNotEmpty(hpdrugdircompDO.getId_comp_drug())) {
				hpdrugdircompDO.setStatus(DOStatus.UPDATED);
			} else {
				hpdrugdircompDO.setStatus(DOStatus.NEW);
			}
			hpdrugDirCompDoList.add(hpdrugdircompDO);
		}
		return hpdrugDirCompDoList.toArray(new HpDrugDirCompDO[0]);
	}

	/**
	 * @Title: saveHpDrugDirComp
	 * @Description: 通过调用基础服务保存适配器处理生成的DO
	 * @param hpdrugdircompDOs
	 * @return HpDrugDirCompDO[]
	 * @throws BizException
	 */
	private HpDrugDirCompDO[] saveHpDrugDirComp(HpDrugDirCompDO[] hpdrugdircompDOs) throws BizException {
		IHpdrugdircompCudService hpdrugdircompCudService = ServiceFinder.find(IHpdrugdircompCudService.class);
		HpDrugDirCompDO[] result = hpdrugdircompCudService.save(hpdrugdircompDOs);
		return result;
	}

	/**
	 * @Title: findHpDrugCompByDrugId
	 * @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
	 * @param hpId
	 * @param hpdrugIds
	 * @return
	 * @throws BizException
	 */
	private HpDrugDirCompDTO[] findHpDrugCompByDrugId(String hpId, String[] hpdrugIds) throws BizException {
		FindHpDrugCompByDrugIdBp bp = new FindHpDrugCompByDrugIdBp();
		HpDrugDirCompDTO[] hpdrugDirComps = bp.exec(hpId, hpdrugIds);
		return hpdrugDirComps;
	}

	/**
	 * @Title: getHpDrugIds
	 * @Description: 获取ID集合
	 * @param hpdrugDirCompDTOs
	 * @return
	 */
	private String[] getHpDrugIds(HpDrugDirCompDTO[] hpdrugDirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (HpDrugDirCompDTO dto : hpdrugDirCompDTOs) {
			ids.add(dto.getId_drug());
		}
		return ids.toArray(new String[0]);
	}

}
