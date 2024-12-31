package iih.bl.st.s.bp;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.s.bp.qry.QryOepStVsIncDetailDTO;
import iih.bl.st.s.bp.qry.QryOepStVsIncMergeDTO;

/**
 * 根据结算id获取结算付款信息
 * @author liwq
 *
 */
public class GetOepStVsIncDetailBP {
	public BlStOepVsIncDTO[] exec(String id_stoep) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		//blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new QryOepStVsIncDetailDTO(id_pat, dt_b, dt_e), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
