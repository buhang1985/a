package iih.mi.mibd.drugdircomp.s.bp;

import java.util.ArrayList;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.mi.mibd.drugdircomp.i.IDrugdircompCudService;
import iih.mi.mibd.drugdircomp.s.bp.adapter.DrugdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/** 
* @author hexx 
* @version 创建时间：2018年2月8日 上午9:25:02 
* 药品删除对照业务 逻辑
*/
public class DeleteDrugCompBp {
	
	/**业务执行
	 * @param misId
	 * @param drugdirCompDTOs
	 * @return
	 * @throws BizException
	 */
	public DrugDirCompDTO[] exec(String misId,DrugDirCompDTO[] drugdirCompDTOs) throws BizException {	
		DrugDirCompDTO[] result = deleteDrugComp(misId,drugdirCompDTOs);
		return result;
	}

	/**删除药品对照信息
	 * @param drugdirCompDTOs
	 * @return
	 * @throws BizException 
	 */
	private DrugDirCompDTO[] deleteDrugComp(String misId,DrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		DrugdircompDO[] drugDirCompDOs = ConvertDtoToDircompDOs(misId,drugdirCompDTOs);
		deleteDrugDirComp(drugDirCompDOs);
		String[] drugIds = getDrugIds(drugdirCompDTOs);
		DrugDirCompDTO[] drugDirCompDtos = findDrugCompByDrugId(misId,drugIds);
		return drugDirCompDtos;
	}

	/** 通过医保系统ID,查找数据DO，进行回显
	 * @param misId
	 * @param drugIds
	 * @return
	 * @throws BizException 
	 */
	private DrugDirCompDTO[] findDrugCompByDrugId(String misId,String[] drugIds) throws BizException {
		FindDrugCompByDrugIdBp bp = new FindDrugCompByDrugIdBp();
		DrugDirCompDTO[] drugDirComps = bp.exec(misId,drugIds);
		return drugDirComps;
	}

	/**获取ID集合
	 * @param drugdirCompDTOs
	 * @return
	 */
	private String[] getDrugIds(DrugDirCompDTO[] drugdirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (DrugDirCompDTO dto : drugdirCompDTOs) {
			ids.add(dto.getId_drug());
		}
		return ids.toArray(new String[0]);
	}

	/**通过调用基础服务删除适配器处理生成的DO
	 * @param drugDirCompDOs
	 * @throws BizException
	 */
	private void deleteDrugDirComp(DrugdircompDO[] drugDirCompDOs) throws BizException {
		IDrugdircompCudService drugdircompCudService = ServiceFinder.find(IDrugdircompCudService.class);
		drugdircompCudService.delete(drugDirCompDOs);
	}

	/**通过适配器，把DTO中的数据转移到DO中
	 * @param drugdirCompDTOs
	 * @return
	 */
	private DrugdircompDO[] ConvertDtoToDircompDOs(String misId,DrugDirCompDTO[] drugdirCompDTOs) {
		ArrayList<DrugdircompDO> drugDirCompDoList = new ArrayList<DrugdircompDO>();
		DrugdircompDOAdapter adapter = new DrugdircompDOAdapter();
		for (DrugDirCompDTO compDTO : drugdirCompDTOs) {
			DrugdircompDO drugdircompDO = adapter.getDrugdircompDO(misId,compDTO);
			drugdircompDO.setEu_status(DirCompState.NOT_COMP);
			drugdircompDO.setStatus(DOStatus.DELETED);
			drugDirCompDoList.add(drugdircompDO);
		}
		return drugDirCompDoList.toArray(new DrugdircompDO[0]);
	}
}
