package iih.bd.mhi.hpdrugdircomp.s.bp;

import java.util.ArrayList;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import iih.bd.mhi.hpdrugdircomp.i.IHpdrugdircompCudService;
import iih.bd.mhi.hpdrugdircomp.s.bp.adapter.HpDrugdircompDOAdapter;
import iih.mi.mibd.docenum.d.DirCompState;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author hexx
 * @version 创建时间：2018年2月8日 上午9:25:02 药品删除对照业务 逻辑
 */
public class DeleteHpDrugCompBp {

	/**
	 * 业务执行
	 * 
	 * @param hpId
	 * @param drugdirCompDTOs
	 * @return
	 * @throws BizException
	 */
	public HpDrugDirCompDTO[] exec(String hpId, HpDrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		HpDrugDirCompDTO[] result = deleteDrugComp(hpId, drugdirCompDTOs);
		return result;
	}

	/**
	 * 删除药品对照信息
	 * 
	 * @param drugdirCompDTOs
	 * @return
	 * @throws BizException
	 */
	private HpDrugDirCompDTO[] deleteDrugComp(String hpId, HpDrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		HpDrugDirCompDO[] drugDirCompDOs = ConvertDtoToDircompDOs(hpId, drugdirCompDTOs);
		deleteDrugDirComp(drugDirCompDOs);
		String[] drugIds = getDrugIds(drugdirCompDTOs);
		HpDrugDirCompDTO[] drugDirCompDtos = findDrugCompByDrugId(hpId, drugIds);
		return drugDirCompDtos;
	}

	/**
	 * 通过医保系统ID,查找数据DO，进行回显
	 * 
	 * @param hpId
	 * @param drugIds
	 * @return
	 * @throws BizException
	 */
	private HpDrugDirCompDTO[] findDrugCompByDrugId(String hpId, String[] drugIds) throws BizException {
		FindHpDrugCompByDrugIdBp bp = new FindHpDrugCompByDrugIdBp();
		HpDrugDirCompDTO[] drugDirComps = bp.exec(hpId, drugIds);
		return drugDirComps;
	}

	/**
	 * 获取ID集合
	 * 
	 * @param drugdirCompDTOs
	 * @return
	 */
	private String[] getDrugIds(HpDrugDirCompDTO[] drugdirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (HpDrugDirCompDTO dto : drugdirCompDTOs) {
			ids.add(dto.getId_drug());
		}
		return ids.toArray(new String[0]);
	}

	/**
	 * 通过调用基础服务删除适配器处理生成的DO
	 * 
	 * @param drugDirCompDOs
	 * @throws BizException
	 */
	private void deleteDrugDirComp(HpDrugDirCompDO[] drugDirCompDOs) throws BizException {
		IHpdrugdircompCudService drugdircompCudService = ServiceFinder.find(IHpdrugdircompCudService.class);
		drugdircompCudService.delete(drugDirCompDOs);
	}

	/**
	 * 通过适配器，把DTO中的数据转移到DO中
	 * 
	 * @param drugdirCompDTOs
	 * @return
	 */
	private HpDrugDirCompDO[] ConvertDtoToDircompDOs(String hpId, HpDrugDirCompDTO[] drugdirCompDTOs) {
		ArrayList<HpDrugDirCompDO> drugDirCompDoList = new ArrayList<HpDrugDirCompDO>();
		HpDrugdircompDOAdapter adapter = new HpDrugdircompDOAdapter();
		for (HpDrugDirCompDTO compDTO : drugdirCompDTOs) {
			HpDrugDirCompDO drugdircompDO = adapter.getHpDrugDirCompDO(hpId, compDTO);
			drugdircompDO.setEu_status(DirCompState.NOT_COMP);
			drugdircompDO.setStatus(DOStatus.DELETED);
			drugDirCompDoList.add(drugdircompDO);
		}
		return drugDirCompDoList.toArray(new HpDrugDirCompDO[0]);
	}
}
