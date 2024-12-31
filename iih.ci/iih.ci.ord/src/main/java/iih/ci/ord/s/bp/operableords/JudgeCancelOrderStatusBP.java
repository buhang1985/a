package iih.ci.ord.s.bp.operableords;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获取允许作废的医嘱
 * @author HUMS
 *
 */
public class JudgeCancelOrderStatusBP extends JudgeBackOrderStatusBP{

	@Override
	public FMap2 exec(CiOrderDO[] orders, String id_dep_phy, String id_dep_nur) throws BizException {
		// 提示信息
		StringBuffer msgBuffer = new StringBuffer();

		FMap2 ordsMap = new FMap2();
		ordsMap.put(STATUS_ERROR, FBoolean.FALSE);

		CiOrderDO[] savedOrds = this.getSavedOrds(orders);
		// 判断患者就诊状态
		CiOrOpenEntStatusValidateBP entBp = new CiOrOpenEntStatusValidateBP();
		entBp.exec(savedOrds[0].getCode_entp(),
				savedOrds[0].getId_en(), id_dep_phy,id_dep_nur);
	
		//判断医嘱状态是否发生改变
		if (isOrdStatusChanged(orders, savedOrds)) {

			ordsMap.put(STATUS_ERROR, FBoolean.TRUE);
			ordsMap.put(ORD_MSG, "医嘱状态发生改变，请刷新医嘱列表后重新操作！");
			return ordsMap;
		}

		// 根据医嘱状态获取所有允许执行操作的医嘱
		List<CiOrderDO> allowedOrdList = this.getAllowdOrds(savedOrds);
		
		// 转换为传输用的FArrayList
		List<CiOrderDO> refuseList = this.getRefusedOrds(savedOrds, allowedOrdList);
		FArrayList flistAllowed = new FArrayList();
		flistAllowed.addAll(allowedOrdList);

		FArrayList flistRefused = new FArrayList();
		flistRefused.addAll(refuseList);

		ordsMap.put(ALLOWED_ORDS, flistAllowed);
		ordsMap.put(ORD_MSG, msgBuffer.toString());
		ordsMap.put(REFUSED_ORDS, flistRefused);

		return ordsMap;
	}

	@Override
	protected List<CiOrderDO> getAllowdOrds(CiOrderDO[] orders)  {
		
		List<CiOrderDO> orderList = new ArrayList<CiOrderDO>();
		for (CiOrderDO order : orders) {
			//长期医嘱是否允许作废
			FBoolean flag;
			try {
				flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_FgLong_cancel);
				if(FBoolean.FALSE.equals(flag)){
					if (FBoolean.TRUE.equals(order.getFg_long())) {
						continue;
					}
				}
				
			} catch (BizException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//持续性医嘱判断,判断是否已经收费
			if(FBoolean.TRUE.equals(order.getFg_chk()) && IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ALWAYS.equals(order.getId_freq())){
				try {
					//未记账的可以作废
					if(!CiOrdUtils.ordIsHasBl(order.getId_or())){
						orderList.add(order);
					}
				} catch (BizException e) {
					e.printStackTrace();
				}
			}else if(FBoolean.TRUE.equals(order.getFg_chk()) && FBoolean.FALSE.equals(order.getFg_canc()) &&  FBoolean.FALSE.equals(order.getFg_uncancelable())){
				// 护士已经核对，未作废，并且医嘱不可取消为false时，允许作废
				orderList.add(order);
			}
		}
		return orderList;
	}
}
