package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.s.bp.qry.BlStOepVsIncDTOQry;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 根据结算编号 获取 结算与发票信息
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class GetBlStOepVsIncByIdStoepBp {

	/**
	 * 根据结算编号 获取 结算与发票信息
	 * 
	 * @param idstoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String idstoep) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new BlStOepVsIncDTOQry(idstoep), BlStOepVsIncDTO.class);
		return blStOepVsIncDTOArr;
	}
}
