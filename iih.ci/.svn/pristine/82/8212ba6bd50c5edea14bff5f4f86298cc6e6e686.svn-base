package iih.ci.ord.s.ems.op.orderv1.bp.ope;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.cfg.CiRuleCfgExecutorBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitList2CiOrPresHandleBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitMpHandleBP;
import iih.ci.ord.s.ems.itf.bp.IOrderOperateBP;
import iih.ci.ord.s.ems.op.orderv1.bp.qry.GetPresSplitDTOs4ReCoverPresQry;

/**
 * 重新分方逻辑
 * @author Young
 *
 */
public class OrderReCoverPresOperateBP implements IOrderOperateBP {

	@Override
	public OrderRstDTO exec(String[] idors, CiEnContextDTO ctx, FMap2 extension) 
			throws BizException {
		// TODO Auto-generated method stub
		if(ctx==null){
			OrderRstDTO rstDTO = new OrderRstDTO();
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		Context.get().setAttribute("CiEnContextDTO", ctx);
		String id_en = ctx.getId_en();
		String code_entp = ctx.getCode_entp();
		String id_psndoc = ctx.getId_emp_or();
		
		GetPresSplitDTOs4ReCoverPresQry qry = new GetPresSplitDTOs4ReCoverPresQry(id_psndoc, code_entp, id_en);
		OrderPresSplitDTO[] rtn = (OrderPresSplitDTO[]) AppFwUtil.getDORstWithDao(qry, OrderPresSplitDTO.class);

		if (rtn != null && rtn.length > 0) {
			List<CiOrPresSplitList> orpressplitlists = CiOrPresSplitDTO2CiOrPresSplitList(rtn);

			CiRuleCfgExecutorBP cfgExecutorBp = new CiRuleCfgExecutorBP();
			List<CiOrPresSplitList> presList = cfgExecutorBp.execSplitPres(ctx,orpressplitlists);

			CiOrPresSplitList2CiOrPresHandleBP bp = new CiOrPresSplitList2CiOrPresHandleBP();
			CiPresDO[] cipres = bp.exec(presList, null);

			CiOrPresSplitMpHandleBP bps = new CiOrPresSplitMpHandleBP();
			bps.exec(cipres);

			// 这样返回还是有问题的，应该确定接口返回值 ？？？？
			List<CiOrderDO> lstOrders = new ArrayList<CiOrderDO>();
			for (OrderPresSplitDTO p : rtn) {
				CiOrderDO ord = new CiOrderDO();
				ord.setId_or(p.getId_or());
				ord.setSd_srvtp(p.getSd_srvtp());
				ord.setId_en(p.getId_en());
				ord.setCode_entp(p.getCode_entp());
				ord.setFg_sign(FBoolean.TRUE);
				ord.setFg_chk(p.getFg_chk());
				ord.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
				ord.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
				lstOrders.add(ord);
			}

			// 保存成功后往集成平台同步数据，发送处方新增事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_AGAIN_NEW, IEventType.TYPE_UPDATE_AFTER, lstOrders.toArray(new CiOrderDO[]{}));
			
			OrderRstDTO rstDTO = new OrderRstDTO();
			rstDTO.setIsSuccess(FBoolean.TRUE);
			return rstDTO;
		}
		
		OrderRstDTO rstDTO = new OrderRstDTO();
		rstDTO.setIsSuccess(FBoolean.FALSE);
		return rstDTO;
	}

	/**
	 * 分方数据DTO到临床医嘱分方数据信息列表数据
	 * @param orderpresdtos
	 * @return
	 */
	private List<CiOrPresSplitList> CiOrPresSplitDTO2CiOrPresSplitList(OrderPresSplitDTO[] orderpresdtos) {
		List<CiOrPresSplitList> orderpresList = new ArrayList<CiOrPresSplitList>();
		if (orderpresdtos == null)
			return orderpresList;
		
		List<OrderPresSplitDTO> orderPresSplitDTOs = new ArrayList<OrderPresSplitDTO>();
		for (OrderPresSplitDTO dto : orderpresdtos) {
			if (FBoolean.TRUE.equals(dto.getFg_or())) {
				orderPresSplitDTOs.add(dto);
			}
		}
		
		CiOrPresSplitList orderPres = new CiOrPresSplitList();
		orderPres.setOrderList(orderPresSplitDTOs);
		orderpresList.add(orderPres);
		return orderpresList;
	}
}
