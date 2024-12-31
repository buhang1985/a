package iih.bd.mhi.hpfeeca.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.mhi.hpfeeca.i.IHpfeecaCudService;
import iih.bd.mhi.hpfeeca.s.bp.adapt.HpFeecaCompDOAdapter;
import iih.bd.mhi.hpfeeca.s.bp.qry.FindFeecaPagingByHpIdSql;
import iih.bd.utils.ContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 保存费别对照
 * 
 * @author dj.zhang
 *
 */
public class SaveHpFeecaCompBp {

	public HPFeeCaCompDTO[] exec(String hpId, HPFeeCaCompDTO[] HPFeeCaCompDTOs) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品不允许为空");
		}
		if (HPFeeCaCompDTOs == null || HPFeeCaCompDTOs.length <= 0) {
			throw new BizException("没有需要保存的费别对照");
		}

		HPFeeCaCompDTO[] needSaveData = getSaveData(hpId, HPFeeCaCompDTOs);
		if (needSaveData == null || needSaveData.length <= 0) {
			throw new BizException("没有需要保存的费别对照");
		}

		HPFeeCaCompDTO[] result = saveHpFeecaComp(hpId, needSaveData);
		return result;
	}

	/**
	 * 保存逻辑
	 * 
	 * @param hpId
	 * @param needSaveData
	 * @return
	 * @throws BizException 
	 */
	private HPFeeCaCompDTO[] saveHpFeecaComp(String hpId, HPFeeCaCompDTO[] needSaveData) throws BizException {
		HpFeecaDO[] hpFeecaDOs = convertDtoToDOs(hpId, needSaveData);
		saveHpDosageComp(hpFeecaDOs);
		String[] hpFeecaIds = getHpFeecaIds(needSaveData);
		HPFeeCaCompDTO[] result = findHpFeecaCompByFeecaId(hpId, hpFeecaIds).toArray(new HPFeeCaCompDTO[0]);
		return result;
	}

	/**
	 * 保存
	 * 
	 * @param HpFeecaDOs
	 * @throws BizException
	 */
	private void saveHpDosageComp(HpFeecaDO[] HpFeecaDOs) throws BizException {
		IHpfeecaCudService feecaSrv = ServiceFinder.find(IHpfeecaCudService.class);
		feecaSrv.save(HpFeecaDOs);
	}

	/**
	 * 适配
	 * 
	 * @param hpId
	 * @param needSaveData
	 * @return
	 */
	private HpFeecaDO[] convertDtoToDOs(String hpId, HPFeeCaCompDTO[] needSaveData) {
		ArrayList<HpFeecaDO> dosageCompDoList = new ArrayList<HpFeecaDO>();
		HpFeecaCompDOAdapter adapter = new HpFeecaCompDOAdapter();

		for (HPFeeCaCompDTO compDTO : needSaveData) {
			HpFeecaDO hpFeecaCompDO = adapter.getFeecaCompDO(hpId, compDTO);
			if (StringUtils.isNotEmpty(hpFeecaCompDO.getId_hpfeeca())) {
				hpFeecaCompDO.setStatus(DOStatus.UPDATED);
				hpFeecaCompDO.setModifiedby(ContextUtils.getUserId());
				hpFeecaCompDO.setModifiedtime(AppUtils.getServerDateTime());
			} else {
				hpFeecaCompDO.setStatus(DOStatus.NEW);
				hpFeecaCompDO.setCreatedby(ContextUtils.getUserId());
				hpFeecaCompDO.setCreatedtime(AppUtils.getServerDateTime());
			}
			dosageCompDoList.add(hpFeecaCompDO);
		}
		return dosageCompDoList.toArray(new HpFeecaDO[0]);
	}

	/**
	 * 获得需要保存的数据
	 * 
	 * @param hpId
	 * @param HPFeeCaCompDTOs
	 * @return
	 * @throws DAException
	 */
	private HPFeeCaCompDTO[] getSaveData(String hpId, HPFeeCaCompDTO[] HPFeeCaCompDTOs) throws DAException {
		String[] hpFeecaIds = getHpFeecaIds(HPFeeCaCompDTOs);
		ArrayList<HPFeeCaCompDTO> needSaveData = new ArrayList<HPFeeCaCompDTO>();
		// 已经保存的对照数据
		HPFeeCaCompDTO[] result = findHpFeecaCompByFeecaId(hpId, hpFeecaIds).toArray(new HPFeeCaCompDTO[0]);
		for (HPFeeCaCompDTO HPFeeCaCompDTO : HPFeeCaCompDTOs) {
			// 说明是新增的对照数据
			if (StringUtils.isEmpty(HPFeeCaCompDTO.getId_hpfeeca())) {
				needSaveData.add(HPFeeCaCompDTO);
			} else {
				// 说明是修改的对照数据
				for (HPFeeCaCompDTO hpFeecaComp : result) {
					if (HPFeeCaCompDTO.getId_hpfeeca().equals(hpFeecaComp.getId_hpfeeca())
							&& (!HPFeeCaCompDTO.getCode_hp().equals(hpFeecaComp.getCode_hp()))) {
						needSaveData.add(HPFeeCaCompDTO);
					}
				}
			}

		}
		return needSaveData.toArray(new HPFeeCaCompDTO[0]);
	}

	/**
	 * 查询保存后的数据
	 * 
	 * @param hpId
	 * @param hpFeecaIds
	 * @return
	 * @throws DAException
	 */
	private ArrayList<HPFeeCaCompDTO> findHpFeecaCompByFeecaId(String hpId, String[] hpFeecaIds) throws DAException {
		String wherePart = SqlUtils.getInSqlByIds("BDINCCAITM.ID_INCCAITM", hpFeecaIds);
		FindFeecaPagingByHpIdSql sql = new FindFeecaPagingByHpIdSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<HPFeeCaCompDTO> result = (ArrayList<HPFeeCaCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPFeeCaCompDTO.class));
		if (result == null) {
			return null;
		}
		return result;
	}

	/**
	 * 获取主键集合
	 * 
	 * @param HPFeeCaCompDTOs
	 * @return
	 */
	private String[] getHpFeecaIds(HPFeeCaCompDTO[] HPFeeCaCompDTOs) {
		ArrayList<String> ids = new ArrayList<String>();

		for (HPFeeCaCompDTO dto : HPFeeCaCompDTOs) {
			ids.add(dto.getId_inccaitm());
		}

		return ids.toArray(new String[0]);
	}

}
