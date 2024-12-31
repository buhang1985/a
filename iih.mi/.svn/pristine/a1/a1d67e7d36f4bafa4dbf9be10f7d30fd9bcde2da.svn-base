package iih.mi.bd.s.bp;

import java.util.ArrayList;

import iih.bd.base.utils.FMapUtils;
import iih.mi.bd.d.AdmStatusCompInfoDTO;
import iih.mi.bd.s.bp.sql.FindAdmStatusMapByHisIdsSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据HIS入院状态主键集合查询医保入院状态字典业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindAdmStatusMapByHisIdsBp {

	@SuppressWarnings("unchecked")
	public FMap2 exec(String hpId, String[] hisAdmStatusIds) throws BizException {

		FindAdmStatusMapByHisIdsSql sql = new FindAdmStatusMapByHisIdsSql(hpId, hisAdmStatusIds);

		DAFacade daFacade = new DAFacade();
		ArrayList<AdmStatusCompInfoDTO> admStatusCompInfoDTOList = (ArrayList<AdmStatusCompInfoDTO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(AdmStatusCompInfoDTO.class));

		if (admStatusCompInfoDTOList == null || admStatusCompInfoDTOList.size() <= 0) {
			return null;
		}
		AdmStatusCompInfoDTO[] admStatusCompInfoDTOs = admStatusCompInfoDTOList.toArray(new AdmStatusCompInfoDTO[0]);

		FMap2 admStatusMap = FMapUtils.getFMap2("Id_leveldise", admStatusCompInfoDTOs);
		return admStatusMap;
	}
}
