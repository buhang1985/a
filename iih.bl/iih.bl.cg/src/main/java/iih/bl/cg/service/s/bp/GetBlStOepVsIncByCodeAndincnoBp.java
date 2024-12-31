package iih.bl.cg.service.s.bp;

import iih.bl.cg.service.s.bp.qry.BlStOepVsIncDTOQry;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得患者指定流水号与发票号的结算与发票信息
 * 
 * @author yang.lu 2017年6月26日
 *
 */
public class GetBlStOepVsIncByCodeAndincnoBp {

	/**
	 * 获得患者指定流水号与发票号的结算与发票信息
	 * 
	 * @param id_pat
	 *            患者编号
	 * @param codest
	 *            流水号
	 * @param incno
	 *            发票号
	 * @return
	 * @throws BizException
	 */
	public BlStOepVsIncDTO[] exec(String id_pat, String codest, String incno) throws BizException {
		BlStOepVsIncDTO[] blStOepVsIncDTOArr = null;
		if (!StringUtil.isEmptyWithTrim(id_pat) && !StringUtil.isEmptyWithTrim(codest) && !StringUtil.isEmptyWithTrim(incno)) {
			blStOepVsIncDTOArr = (BlStOepVsIncDTO[]) AppFwUtil.getDORstWithDao(new BlStOepVsIncDTOQry(id_pat, codest, incno, null), BlStOepVsIncDTO.class);
			if (blStOepVsIncDTOArr != null && blStOepVsIncDTOArr.length != 0) {
				if (blStOepVsIncDTOArr[0].getFg_canc().booleanValue()) {
					throw new BizException("对应的结算已取消，无法执行退费操作！");
				}
			}
		}
		return blStOepVsIncDTOArr;
	}
}
