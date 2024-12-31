package iih.bl.cg.service.s.bp;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.mp.dg.i.IMpDgOutService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医嘱取消记账（销账后，【记账状态】=已退费，冲账类型 =销账） 且取消物品预留，
 * 
 * @author Administrator
 *
 */
public class CancelReserveBP {
	/**
	 * 医嘱取消记账（销账后，【记账状态】=已退费，冲账类型 =销账） 且取消物品预留，
	 * 必填：id_pat,id_org,id_or,id_orsrv,code_enttp,Id_emp_cg
	 * 
	 * @param refundBillParamDTO
	 *            必填：id_pat,id_org,id_or,id_orsrv,code_enttp,Id_emp_cg
	 * @param code_enttp
	 *            就诊类型代码
	 * @return 返回“销账成功，销账金额：……”
	 * @throws BizException
	 */
	public String exec(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {

		this.Validate(refundBillParamDTO);

		ArrayList<BlOrderAppendBillParamDTO> ordlist = new ArrayList<BlOrderAppendBillParamDTO>();

		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		// 取消预留
		BlcgoepAggDO[] blcgoepAggDOs = bp.GetOrginBlcgoepAggDOFromIdorsrv(refundBillParamDTO);
		List<String> id_presLst = new ArrayList<String>();
		FDouble amt_ratio = new FDouble(0);
		for (BlcgoepAggDO dto : blcgoepAggDOs) {
			/*if (!refundBillParamDTO[0].getId_emp_cg().equals(dto.getParentDO().getId_emp_cg())) {
				throw new BizException("记账人与销账人必须是同一人。销账失败！");
			}*/
			BlCgItmOepDO[] blCgItmOepDOs = dto.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
				if (blCgItmOepDO.getId_par() != null && !"~".equals(blCgItmOepDO.getId_par())) {
					continue;
				}
				ordlist.add(getDTOByOrSrvId(refundBillParamDTO, blCgItmOepDO.getId_orsrv()));
				if (!StringUtil.isEmpty(blCgItmOepDO.getId_pres()) && 
						!id_presLst.contains(blCgItmOepDO.getId_pres())) {
					id_presLst.add(blCgItmOepDO.getId_pres());
				}
				amt_ratio = amt_ratio.add(blCgItmOepDO.getAmt_ratio().multiply(dto.getParentDO().getEu_direct()));
			}
		}

		String tip = "";

		if (ordlist != null && ordlist.size() != 0) {
			bp.SetOrderRefundBill(ordlist.toArray(new BlOrderAppendBillParamDTO[ordlist.size()]), true, code_enttp); // 已经处理了：销账后，【记账状态】=已退费，冲账类型

			if (id_presLst != null && id_presLst.size() > 0) {
				// 释放窗口队列
				IMpDgOutService iMpDgOutService = ServiceFinder.find(IMpDgOutService.class);
				iMpDgOutService.releaseQueueByPresId(id_presLst.toArray(new String[0]));
			}
			tip = "销账成功，销账金额：" + amt_ratio.setScale(-2, BigDecimal.ROUND_HALF_UP);
		}else{
			tip = "销账失败";
		}
		//tip = "销账成功，销账金额：" + amt_ratio.setScale(-2, BigDecimal.ROUND_HALF_UP);
		
		return tip;
	}

	private BlOrderAppendBillParamDTO getDTOByOrSrvId(BlOrderAppendBillParamDTO[] refundBillParamDTO, String orsrvID) {
		for (BlOrderAppendBillParamDTO blOrdDTO : refundBillParamDTO) {
			if (blOrdDTO.getId_orsrv().equals(orsrvID)) {
				return blOrdDTO;
			}
		}
		return null;
	}

	/**
	 * 验证当前数据是否可退
	 * 
	 * @param refundBillParamDTO
	 * @throws BizException
	 */
	private void Validate(BlOrderAppendBillParamDTO[] refundBillParamDTO) throws BizException {
		String strWhere = "";
		String[] conStrs = { OrdSrvDO.NAME, OrdSrvDO.FG_FEERTNABLE };
		String errMsg = "";
		if(refundBillParamDTO==null || refundBillParamDTO.length<=0){
			throw new BizException("没有获取到需要销账的数据！");
		}
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : refundBillParamDTO) {
			blOrderAppendBillParamDTO.getId_orsrv();
			strWhere = strWhere + ("".equals(strWhere) ? "" : ",") + "'" + blOrderAppendBillParamDTO.getId_orsrv() + "'";
		}
		strWhere = OrdSrvDO.ID_ORSRV + " in (" + strWhere + ")";
		List<OrdSrvDO> stDoList = (List<OrdSrvDO>) new DAFacade().findByCond(OrdSrvDO.class, strWhere, " 1 ", conStrs);
		for (OrdSrvDO ordSrvDO : stDoList) {
			if (!ordSrvDO.getFg_feertnable().booleanValue()) {
				errMsg += ("".equals(errMsg) ? "" : ",") + ordSrvDO.getName();
			}
		}
		if (!StringUtil.isEmptyWithTrim(errMsg)) {
			throw new BizException("服务项目：" + errMsg + " 状态已更改，请刷新后重新操作！");
		}
	}

}
