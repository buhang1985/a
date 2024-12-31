package iih.bd.pp.hp.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.i.IHpDosageDOCudService;
import iih.bd.pp.hp.s.bp.adapter.HpDosageCompDOAdapter;
import iih.bd.pp.hp.s.bp.sql.FindPagingByHpIdSql;
import iih.bd.utils.ContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @author dj.zhang
 *
 */
public class SaveHpDosageCompBp {

	/**
	 * 执行保存
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	public HpDosageCompDTO[] exec(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品不允许为空");
		}
		if (hpDosageCompDtos == null || hpDosageCompDtos.length <= 0) {
			throw new BizException("没有需要保存的剂型对照");
		}

		HpDosageCompDTO[] needSaveData = getSaveData(hpId, hpDosageCompDtos);
		if (needSaveData == null || needSaveData.length <= 0) {
			throw new BizException("没有需要保存的剂型对照");
		}

		HpDosageCompDTO[] result = saveHpDosageComp(hpId, needSaveData);
		return result;
	}

	/**
	 * 获得需要保存的数据
	 * 
	 * @param hpDosageCompDtos
	 * @return
	 * @throws DAException
	 */
	private HpDosageCompDTO[] getSaveData(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws DAException {
		String[] hpDosageIds = getHpDosageIds(hpDosageCompDtos);
		ArrayList<HpDosageCompDTO> needSaveData = new ArrayList<HpDosageCompDTO>();
		HpDosageCompDTO[] result = findHpDosageCompByDosageId(hpId, hpDosageIds).toArray(new HpDosageCompDTO[0]);
		for (HpDosageCompDTO hpDosageCompDTO : hpDosageCompDtos) {
			
			if(StringUtils.isEmpty(hpDosageCompDTO.getId_hp_dosage())){
				needSaveData.add(hpDosageCompDTO);
			}else {
				for (HpDosageCompDTO hpDosageComp : result) {
						if(hpDosageCompDTO.getId_hp_dosage().equals(hpDosageComp.getId_hp_dosage())
									&& (!hpDosageCompDTO.getCode_hp().equals(hpDosageComp.getCode_hp()))){
						needSaveData.add(hpDosageCompDTO);
					}
				}
			}
			
		}
		return needSaveData.toArray(new HpDosageCompDTO[0]);
	}

	/**
	 * 保存逻辑
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException
	 */
	private HpDosageCompDTO[] saveHpDosageComp(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException {
		HpDosageDO[] hpDosageDOs = convertDtoToDOs(hpId, hpDosageCompDtos);
		saveHpDosageComp(hpDosageDOs);
		String[] hpDosageIds = getHpDosageIds(hpDosageCompDtos);
		HpDosageCompDTO[] result = findHpDosageCompByDosageId(hpId, hpDosageIds).toArray(new HpDosageCompDTO[0]);
		return result;
	}

	/**
	 * 适配DTO
	 * 
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 */
	private HpDosageDO[] convertDtoToDOs(String hpId, HpDosageCompDTO[] hpDosageCompDtos) {
		ArrayList<HpDosageDO> dosageCompDoList = new ArrayList<HpDosageDO>();
		HpDosageCompDOAdapter adapter = new HpDosageCompDOAdapter();

		for (HpDosageCompDTO compDTO : hpDosageCompDtos) {
			HpDosageDO hpDosageCompDO = adapter.getDosageCompDO(hpId, compDTO);
			if (StringUtils.isNotEmpty(hpDosageCompDO.getId_hp_dosage())) {
				hpDosageCompDO.setStatus(DOStatus.UPDATED);
				hpDosageCompDO.setCreatedby(compDTO.getCreatedby());
				hpDosageCompDO.setCreatedtime(compDTO.getCreatedtime());
				hpDosageCompDO.setModifiedby(ContextUtils.getUserId());
				hpDosageCompDO.setModifiedtime(AppUtils.getServerDateTime());
			} else {
				hpDosageCompDO.setStatus(DOStatus.NEW);
				hpDosageCompDO.setCreatedby(ContextUtils.getUserId());
				hpDosageCompDO.setCreatedtime(AppUtils.getServerDateTime());
			}
			dosageCompDoList.add(hpDosageCompDO);
		}
		return dosageCompDoList.toArray(new HpDosageDO[0]);
	}

	/**
	 * 调用基础服务保存
	 * 
	 * @param hpDosageDOs
	 * @throws BizException
	 */
	private void saveHpDosageComp(HpDosageDO[] hpDosageDOs) throws BizException {
		IHpDosageDOCudService hpDosageDOCudService = ServiceFinder.find(IHpDosageDOCudService.class);
		hpDosageDOCudService.save(hpDosageDOs);

	}

	/**
	 * 获取主键集合
	 * 
	 * @param hpDosageCompDtos
	 * @return
	 */
	private String[] getHpDosageIds(HpDosageCompDTO[] hpDosageCompDtos) {
		ArrayList<String> ids = new ArrayList<String>();

		for (HpDosageCompDTO dto : hpDosageCompDtos) {
			ids.add(dto.getId_dosage());
		}

		return ids.toArray(new String[0]);
	}

	/**
	 * 查询保存后的数据回显
	 * 
	 * @param hpId
	 * @param hpDosageIds
	 * @return
	 * @throws DAException
	 */
	private ArrayList<HpDosageCompDTO> findHpDosageCompByDosageId(String hpId, String[] hpDosageIds)
			throws DAException {
		String wherePart = SqlUtils.getInSqlByIds("DOSAGE.ID_UDIDOC", hpDosageIds);
		FindPagingByHpIdSql sql = new FindPagingByHpIdSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<HpDosageCompDTO> result = (ArrayList<HpDosageCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HpDosageCompDTO.class));
		if (result == null) {
			return null;
		}
		return result;
	}

}
