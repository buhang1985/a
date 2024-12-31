package iih.bd.mhi.hpfeeca.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.mhi.hpfeeca.d.HpFeecaDO;
import iih.bd.mhi.hpfeeca.i.IHpfeecaCudService;
import iih.bd.mhi.hpfeeca.s.bp.adapt.HpFeecaCompDOAdapter;
import iih.bd.mhi.hpfeeca.s.bp.qry.FindFeecaPagingByHpIdSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 删除费别对照BP
 * 
 * @author dj.zhang
 *
 */
public class DelHpFeecaCompBp {

	public HPFeeCaCompDTO[] exec(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) throws BizException {
		HpFeecaDO[] HpFeecaDOs = convertDtoToDOs(hpId, hpFeecaCompDtos);
		delHpFeecaComp(HpFeecaDOs);
		String[] HpFeecaIds = getHpFeecaIds(hpFeecaCompDtos);
		HPFeeCaCompDTO[] result = findHpFeecaCompByHpFeecaId(hpId, HpFeecaIds);
		return result;
	}

	/**
	 * 获取删除集合回显
	 * 
	 * @param hpId
	 * @param hpFeecaIds
	 * @return
	 * @throws DAException
	 */
	private HPFeeCaCompDTO[] findHpFeecaCompByHpFeecaId(String hpId, String[] hpFeecaIds) throws DAException {
		String wherePart = SqlUtils.getInSqlByIds("BDINCCAITM.ID_INCCAITM", hpFeecaIds);
		FindFeecaPagingByHpIdSql sql = new FindFeecaPagingByHpIdSql(hpId, wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<HPFeeCaCompDTO> result = (ArrayList<HPFeeCaCompDTO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPFeeCaCompDTO.class));
		if (result == null) {
			return null;
		}
		return result.toArray(new HPFeeCaCompDTO[0]);
	}

	/**
	 * 获取ID集合
	 * 
	 * @param hpFeecaCompDtos
	 * @return
	 */
	private String[] getHpFeecaIds(HPFeeCaCompDTO[] hpFeecaCompDtos) {
		ArrayList<String> ids = new ArrayList<String>();

		for (HPFeeCaCompDTO dto : hpFeecaCompDtos) {
			ids.add(dto.getId_inccaitm());
		}

		return ids.toArray(new String[0]);
	}

	/**
	 * 删除
	 * 
	 * @param hpFeecaDOs
	 * @throws BizException 
	 */
	private void delHpFeecaComp(HpFeecaDO[] hpFeecaDOs) throws BizException {
		IHpfeecaCudService hpDosageDOCudService = ServiceFinder.find(IHpfeecaCudService.class);
		hpDosageDOCudService.save(hpFeecaDOs);
		
	}

	/**
	 * 适配
	 * 
	 * @param hpId
	 * @param hpFeecaCompDtos
	 * @return
	 */
	private HpFeecaDO[] convertDtoToDOs(String hpId, HPFeeCaCompDTO[] hpFeecaCompDtos) {
		ArrayList<HpFeecaDO> dosageCompDoList = new ArrayList<HpFeecaDO>();
		HpFeecaCompDOAdapter adapter = new HpFeecaCompDOAdapter();

		for (HPFeeCaCompDTO compDTO : hpFeecaCompDtos) {
			HpFeecaDO hpDosageCompDO = adapter.getFeecaCompDO(hpId, compDTO);
			hpDosageCompDO.setStatus(DOStatus.DELETED);
			dosageCompDoList.add(hpDosageCompDO);
		}
		return dosageCompDoList.toArray(new HpFeecaDO[0]);
	}

}
