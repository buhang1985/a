package iih.bd.pp.hpdivshisdto.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpdivshis.d.HpDiVsHisDO;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpdivshisdto.s.bp.sql.DeleteHpDiVsHisSql;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除医保病种目录对照数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteHpDiVsHisDataBp {

	public HpDiVsHisDTO[] exec(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException {
		if (hpDiVsHisDtos == null || hpDiVsHisDtos.length <= 0) {
			return null;
		}
		HpDiVsHisDTO[] result = DeleteHpDiVsHis(hpDiVsHisDtos);
		return result;
	}

	/**
	 * 删除医保病种目录对照数据
	 * 
	 * @param hpDiVsHisDtos
	 * @return
	 * @throws BizException
	 */
	private HpDiVsHisDTO[] DeleteHpDiVsHis(HpDiVsHisDTO[] hpDiVsHisDtos) throws BizException {
		String wherePart = GetWherePart(hpDiVsHisDtos);
		DeleteHpDiVsHisSql sql = new DeleteHpDiVsHisSql(wherePart);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
		UpdateHpDiVsHisDTO(hpDiVsHisDtos);
		return hpDiVsHisDtos;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param hpDiVsHisDtos
	 * @return
	 */
	private String GetWherePart(HpDiVsHisDTO[] hpDiVsHisDtos) {
		String[] idhpdivshisArr = GetIdhpdivshisArr(hpDiVsHisDtos);
		String wherePart = SqlUtils.getInSqlByIds(HpDiVsHisDO.ID_HPDIVSHIS, idhpdivshisArr);
		return wherePart;
	}

	/**
	 * 更新DTO数据
	 * 
	 * @param hpDiVsHisDtos
	 */
	private void UpdateHpDiVsHisDTO(HpDiVsHisDTO[] hpDiVsHisDtos) {
		for (HpDiVsHisDTO hpDiVsHisDTO : hpDiVsHisDtos) {
			ClearInsurDiDataBp bp = new ClearInsurDiDataBp();
			bp.exec(hpDiVsHisDTO);
			hpDiVsHisDTO.setEu_status(HpStatusEnum.NOT_MATCHED);
			hpDiVsHisDTO.setStatus(DOStatus.UNCHANGED); 
		}
	}

	/**
	 * 获取对照主键列表
	 * 
	 * @param hpDiVsHisDtos
	 * @return
	 */
	private String[] GetIdhpdivshisArr(HpDiVsHisDTO[] hpDiVsHisDtos) {
		ArrayList<String> pkList = new ArrayList<String>();
		for (HpDiVsHisDTO hpDiVsHisDTO : hpDiVsHisDtos) {
			pkList.add(hpDiVsHisDTO.getId_hpdivshis());
		}
		return pkList.toArray(new String[0]);
	}
}
