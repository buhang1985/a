package iih.mi.mibd.drugdircomp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.drugdircomp.d.DrugDirCompDTO;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.mi.mibd.drugdircomp.i.IDrugdircompCudService;
import iih.mi.mibd.drugdircomp.s.bp.adapter.DrugdircompDOAdapter;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存药品对照业务逻辑
 * 
 * @author hexx
 */
public class SaveDrugCompBp {
	
	/**  
	* @Title: exec  
	* @Description: 业务执行
	* @param misId
	* @param drugdirCompDTOs
	* @return DrugDirCompDTO[]
	* @throws BizException   
	*/  
	public DrugDirCompDTO[] exec(String misId, DrugDirCompDTO[] drugdirCompDTOs) throws BizException {
		if (StringUtils.isEmpty(misId)) {
			throw new BizException("医保系统不允许为空");
		}
		if (drugdirCompDTOs == null || drugdirCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的药品对照。");
		}
		DrugDirCompDTO[] result = saveDrugComp(misId, drugdirCompDTOs);
		return result;
	}

	/**
	 * 保存药品对照信息
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	private DrugDirCompDTO[] saveDrugComp(String misId, DrugDirCompDTO[] drugDirCompDTOs) throws BizException {
		DrugdircompDO[] drugDirCompDOs = ConvertDtoToDircompDOs(misId, drugDirCompDTOs);
		saveDrugDirComp(drugDirCompDOs);
		String[] drugIds = getDrugIds(drugDirCompDTOs);
		DrugDirCompDTO[] drugDirCompDtos = findDrugCompByDrugId(misId, drugIds);
		return drugDirCompDtos;
	}

	/**  
	* @Title: ConvertDtoToDircompDOs  
	* @Description: 通过适配器，把DTO中的数据转移到DO中
	* @param misId
	*/ 
	private DrugdircompDO[] ConvertDtoToDircompDOs(String misId, DrugDirCompDTO[] DrugDirCompDTOs) {
		ArrayList<DrugdircompDO> drugDirCompDoList = new ArrayList<DrugdircompDO>();
		DrugdircompDOAdapter adapter = new DrugdircompDOAdapter();
		for (DrugDirCompDTO compDTO : DrugDirCompDTOs) {
			DrugdircompDO drugdircompDO = adapter.getDrugdircompDO(misId, compDTO);
			drugdircompDO.setEu_status(DirCompState.COMPED);
			drugDirCompDoList.add(drugdircompDO);
			if (StringUtils.isNotEmpty(drugdircompDO.getId_comp_drug())) {
				drugdircompDO.setStatus(DOStatus.UPDATED);
			} else {
				drugdircompDO.setStatus(DOStatus.NEW);
			}
		}
		return drugDirCompDoList.toArray(new DrugdircompDO[0]);
	}

	/**  
	* @Title: saveDrugDirComp  
	* @Description: 通过调用基础服务保存适配器处理生成的DO
	* @param drugdircompDOs
	* @return DrugdircompDO[]
	* @throws BizException   
	*/ 
	private DrugdircompDO[] saveDrugDirComp(DrugdircompDO[] drugdircompDOs) throws BizException {
		IDrugdircompCudService drugdircompCudService = ServiceFinder.find(IDrugdircompCudService.class);
		DrugdircompDO[] result = drugdircompCudService.save(drugdircompDOs);
		return result;
	}

	/**  
	* @Title: findDrugCompByDrugId  
	* @Description: 通过医保系统ID,查找保存过的数据DO，进行回显
	* @param misId
	* @param drugIds
	* @return
	* @throws BizException   
	*/
	private DrugDirCompDTO[] findDrugCompByDrugId(String misId, String[] drugIds) throws BizException {
		FindDrugCompByDrugIdBp bp = new FindDrugCompByDrugIdBp();
		DrugDirCompDTO[] drugDirComps = bp.exec(misId, drugIds);
		return drugDirComps;
	}

	/**  
	* @Title: getDrugIds  
	* @Description: 获取ID集合
	* @param drugDirCompDTOs
	* @return   
	*/
	private String[] getDrugIds(DrugDirCompDTO[] drugDirCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();
		for (DrugDirCompDTO dto : drugDirCompDTOs) {
			ids.add(dto.getId_drug());
		}
		return ids.toArray(new String[0]);
	}

}
