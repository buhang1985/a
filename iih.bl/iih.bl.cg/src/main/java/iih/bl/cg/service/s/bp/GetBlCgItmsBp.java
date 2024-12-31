package iih.bl.cg.service.s.bp;

import iih.bl.cg.bp.GetBlStOepVsIncSql;
import iih.bl.st.dto.d.BlStReFundBillDTO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;
import iih.mp.dg.i.IMpDgOutService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 退费提取记账明细数据
 * 
 * @author yang.lu
 * @since 2017年6月26日
 * 2017年6月30日 规范 将此功能改写到退费调入中
 */
@Deprecated
public class GetBlCgItmsBp {

	/**
	 * 退费提取明细数据
	 */
	public BlStReFundBillDTO[] exec(String id_stoep) throws BizException {
		GetBlStOepVsIncSql ins = new GetBlStOepVsIncSql();
		String sql = ins.GetBlCgItms();
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_stoep);
		List<BlStReFundBillDTO> list = (List<BlStReFundBillDTO>) new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(BlStReFundBillDTO.class));
		BlStReFundBillDTO[] blStReFundBillDTOs = list.toArray(new BlStReFundBillDTO[] {});
		
		
		// 调用药品接口，获得可退数量
		List<String> Refund_mm_id_orsrv = new ArrayList<String>();
		List<OpDgRtnAmountDTO> opDgRtnAmountDTOLst = new ArrayList<OpDgRtnAmountDTO>();// 重置
		
		for (int i = 0; i < blStReFundBillDTOs.length; i++) {
			// if(blStReFundBillDTOs[i].getFg_mm().booleanValue()) //物品
			if (blStReFundBillDTOs[i].getSd_srvtp() != null && blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") == 0) // 药品
			{
				Refund_mm_id_orsrv.add(blStReFundBillDTOs[i].getId_orsrv());
				OpDgRtnAmountDTO opDgRtnAmountDTO = new OpDgRtnAmountDTO();
				opDgRtnAmountDTO.setId_orsrv(blStReFundBillDTOs[i].getId_orsrv());
				opDgRtnAmountDTO.setCharged_amount(blStReFundBillDTOs[i].getQuan());
				opDgRtnAmountDTOLst.add(opDgRtnAmountDTO);
			} else {
				if (blStReFundBillDTOs[i].getFg_feertnable() != null && !blStReFundBillDTOs[i].getFg_feertnable().booleanValue()) // 医技
				{
					blStReFundBillDTOs[i].setCan_quan(new FDouble(0));
				}
			}
		}

		OpDgRtnAmountDTO[] opDgRtnAmountDTOs = null;// 重置
		
		if (opDgRtnAmountDTOLst.size() > 0) {
			IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
			opDgRtnAmountDTOs = iMpDgOutService.getOpDgRtnAmount(opDgRtnAmountDTOLst.toArray(new OpDgRtnAmountDTO[0]));

			if (opDgRtnAmountDTOs != null && opDgRtnAmountDTOs.length > 0) {
				for (int i = 0; i < blStReFundBillDTOs.length; i++) {
					if (blStReFundBillDTOs[i].getSd_srvtp() == null || blStReFundBillDTOs[i].getSd_srvtp().indexOf("01") != 0) {
						// 非药品，跳过
					} else {
						for (int j = 0; j < opDgRtnAmountDTOs.length; j++) {
							if (opDgRtnAmountDTOs[j].getId_orsrv().equals(blStReFundBillDTOs[i].getId_orsrv())) {
								// 设置可退数
								blStReFundBillDTOs[i].setCan_quan(opDgRtnAmountDTOs[j].getRtn_amount());
								// 是否领药
								if (opDgRtnAmountDTOs[j].getFg_get().booleanValue()) {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.TRUE); // 已领药
								} else {
									blStReFundBillDTOs[i].setFg_pat_getmm(FBoolean.FALSE); // 未发药
								}
								break;
							}
						}
					}
				}
			}
			
			// //记日志，便于查询
			// BlCgLogsRecordUtil.setIBlCgLogsRecordService(ServiceFinder.find(IBlCgLogsRecordService.class));
			// BlCgLogsRecordUtil.getIBlCgLogsRecordService().recordBlCgVsMMLogs(timeService.getUFDateTime(),info.toString());
		}
		return blStReFundBillDTOs;
	}
}
