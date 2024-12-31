package iih.bd.pp.hp.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HpDosageDO;
import iih.bd.pp.hp.i.IHpDosageDOCudService;
import iih.bd.pp.hp.s.bp.adapter.HpDosageCompDOAdapter;
import iih.bd.pp.hp.s.bp.sql.FindPagingByHpIdSql;
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
public class DelHpDosageCompBp {

	/**
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 * @throws BizException 
	 */
	public HpDosageCompDTO[] exec(String hpId, HpDosageCompDTO[] hpDosageCompDtos) throws BizException {
		HpDosageDO[] hpDosageDOs = convertDtoToDOs(hpId, hpDosageCompDtos);
		delHpDosageComp(hpDosageDOs);
		String[] hpDosageIds = getHpDosageIds(hpDosageCompDtos);
		HpDosageCompDTO[] result = findHpDosageCompByDosageId(hpId, hpDosageIds);
		return result;
	}

	/**
	 * @param hpId
	 * @param hpDosageIds
	 * @return
	 * @throws DAException 
	 */
	private HpDosageCompDTO[] findHpDosageCompByDosageId(String hpId, String[] hpDosageIds) throws DAException {
		String wherePart = SqlUtils.getInSqlByIds("DOSAGE.ID_UDIDOC", hpDosageIds);
		FindPagingByHpIdSql sql = new FindPagingByHpIdSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<HpDosageCompDTO> result = (ArrayList<HpDosageCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HpDosageCompDTO.class));
		if (result == null) {
			return null;
		}
		return result.toArray(new HpDosageCompDTO[0]);
	}

	/**
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
	 * @param hpDosageDOs
	 * @throws BizException 
	 */
	private void delHpDosageComp(HpDosageDO[] hpDosageDOs) throws BizException {
		IHpDosageDOCudService hpDosageDOCudService = ServiceFinder.find(IHpDosageDOCudService.class);
		hpDosageDOCudService.save(hpDosageDOs);
	}

	/**
	 * @param hpId
	 * @param hpDosageCompDtos
	 * @return
	 */
	private HpDosageDO[] convertDtoToDOs(String hpId, HpDosageCompDTO[] hpDosageCompDtos) {
		ArrayList<HpDosageDO> dosageCompDoList = new ArrayList<HpDosageDO>();
		HpDosageCompDOAdapter adapter = new HpDosageCompDOAdapter();

		for (HpDosageCompDTO compDTO : hpDosageCompDtos) {
			HpDosageDO hpDosageCompDO = adapter.getDosageCompDO(hpId, compDTO);
			hpDosageCompDO.setStatus(DOStatus.DELETED);
			dosageCompDoList.add(hpDosageCompDO);
		}
		return dosageCompDoList.toArray(new HpDosageDO[0]);
	}

}
