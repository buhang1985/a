package iih.bl.cg.bp.oep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bl.cg.bp.oep.qry.GetWriteoffQry;
import iih.bl.cg.service.s.bp.qry.BlStOepVsIncDTOQry;
import iih.bl.st.dto.d.BlStOepVsIncDTO;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 
 * @author
 *
 */
public class GetOepCanCancelCgListBP {
	/**
	 * 获取可退的记账信息集合
	 * 
	 * @param patId
	 *            患者ID
	 * @param st_b
	 *            开始时间
	 * @param st_e
	 *            结束时间
	 * @return liwenqiang
	 * @throws BizException
	 */
	public BlStReFundBillDTO[] exec(String patId, FDateTime st_b, FDateTime st_e) throws BizException {
		// 1.查询记账数据
		BlStReFundBillDTO[] blStOepVsIncDTOArr = (BlStReFundBillDTO[]) AppFwUtil.getDORstWithDao(new GetWriteoffQry(patId, st_b.toString(), st_e.toString()), BlStReFundBillDTO.class);
		if (blStOepVsIncDTOArr == null || blStOepVsIncDTOArr.length == 0) {
			return null;
		}
		// 含有已发药服务的医嘱set
		Set<String> idOrSet = new HashSet<>();
		List<String> Refund_mm_id_orsrv = new ArrayList<String>();
		List<OpDgRtnAmountDTO> opDgRtnAmountDTOLst = new ArrayList<OpDgRtnAmountDTO>();
		// 判断药品的可退数量是否等于医嘱开药数量,如果相等认为未发药
		for (int i = 0; i < blStOepVsIncDTOArr.length; i++) {
			// 判断是否是物品 药品
			if (blStOepVsIncDTOArr[i].getSd_srvtp() != null && blStOepVsIncDTOArr[i].getSd_srvtp().indexOf("01") == 0) {
				OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
				opDgRtnAmountDTO.setId_orsrv(blStOepVsIncDTOArr[i].getId_orsrv());
				opDgRtnAmountDTO.setCharged_amount(blStOepVsIncDTOArr[i].getQuan());
				opDgRtnAmountDTOLst.add(opDgRtnAmountDTO);
			}
		}

		// 2.调用物品域接口 设置可退数量与 是否领药的状态
		if (opDgRtnAmountDTOLst.size() > 0) {
			IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
			OpDgRtnAmountDTO[] opDgRtnAmountDTOs = iMpDgOutService.getOpDgRtnAmount(opDgRtnAmountDTOLst.toArray(new OpDgRtnAmountDTO[0]));
			// 判断药品服务是否已发药
			if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
				for (int i = 0; i < blStOepVsIncDTOArr.length; i++) {
					if (blStOepVsIncDTOArr[i].getSd_srvtp() != null && blStOepVsIncDTOArr[i].getSd_srvtp().indexOf("01") > -1) {
						for (int j = 0; j < opDgRtnAmountDTOs.length; j++) {
							if (opDgRtnAmountDTOs[j].getId_orsrv().equals(blStOepVsIncDTOArr[i].getId_orsrv())) {
								// 设置可退数
								blStOepVsIncDTOArr[i].setCan_quan(opDgRtnAmountDTOs[j].getRtn_amount());
								// 是否领药
								if (opDgRtnAmountDTOs[j].getFg_get().booleanValue()) {// 已领药
									blStOepVsIncDTOArr[i].setFg_pat_getmm(FBoolean.TRUE);
									idOrSet.add(blStOepVsIncDTOArr[i].getId_or());
								} else {// 未发药
									blStOepVsIncDTOArr[i].setFg_pat_getmm(FBoolean.FALSE);
								}
								break;
							}
						}
					}
				}
			}
		}
		if (idOrSet == null || idOrSet.size() == 0) {
			return blStOepVsIncDTOArr;
		}
		// 需要返回的数组
		List<BlStReFundBillDTO> retList = new ArrayList<>();
		// 排除已发药服务对应的医嘱
		for (BlStReFundBillDTO blStOepVsIncDTO : blStOepVsIncDTOArr) {
			if (!idOrSet.contains(blStOepVsIncDTO.getId_or())) {
				retList.add(blStOepVsIncDTO);
			}
		}

		return retList.toArray(new BlStReFundBillDTO[0]);
	}
}
