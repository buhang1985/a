package iih.bd.srv.s.bp;

import iih.bd.srv.d.MrtplItmDTO;
import iih.bd.srv.s.bp.qry.SetItmDeInfoSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class SetItmDeInfobp {

	/**
	 * 医疗服务确定后，查询生命体征明细
	 * 
	 * @param DTO
	 * @return
	 * @throws BizException
	 */
	public MrtplItmDTO exec(MrtplItmDTO DTO) throws BizException {

		if (StringUtil.isEmpty(DTO.getId_srv())) {

			return DTO;
		}

		SetItmDeInfoSql Sql = new SetItmDeInfoSql(DTO.getId_srv());

		MrtplItmDTO[] DTOS = (MrtplItmDTO[]) AppFwUtil.getDORstWithDao(Sql, MrtplItmDTO.class);

		if (DTOS != null && DTOS.length == 1) {

			return DTOS[0];
		}

		return null;
	}
}
