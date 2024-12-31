package iih.bl.st.s.bp;

import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.s.bp.qry.QryOepStVsIncDetailDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据结算编号 获取 结算与发票信息（明细）
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class GetBlStOepVsIncByIdStoepBp {

	/**
	 * 根据结算编号 获取 结算与发票信息（明细）
	 * 
	 * @param idstoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String idstoep) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new QryOepStVsIncDetailDTO(idstoep), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
