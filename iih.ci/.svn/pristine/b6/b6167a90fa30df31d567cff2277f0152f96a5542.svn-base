package iih.ci.ord.s.bp.task;

import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.op.order.OrderSignBP;
import iih.mp.nr.foreign.i.IForeignService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.permfw.user.d.UserDO;

/**
 * 皮试结果为阴性时设置定时任务，到时间对应的医嘱自动设置签署状态。
 * 
 * @author LiYue
 *
 */
public class CompleteSkinTestStatusTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		String idor = null;
		
		Map<String, Object> variableValueMap = arg0.getKeyMap();
		idor = (String) variableValueMap.get("idor");
		CiOrderDO order = CiOrdAppUtils.getOrQryService().findById(idor);
		//给上下文赋值
		setContextValue(order);
		//组装签署需要的数据
		CiEnContextDTO ciEnContextDTO = new CiEnContextDTO();
		ciEnContextDTO.setId_en(order.getId_en());
		ciEnContextDTO.setCode_entp(order.getCode_entp());
		
		OrderOperateDTO orderoperatedto = new OrderOperateDTO();
		FArrayList document =new FArrayList();
		document.add(0, order.getId_or());
		orderoperatedto.setDocument(document);
		FMap2 extension =new FMap2();
		orderoperatedto.setExtension(extension);
		OrdBizLogger.info(null,"皮试自动签署--开始");
		OrdBizLogger.info(null,"皮试自动签署--入参：id_or:"+order.getId_or());
		//签署
		OrderSignBP sign =new OrderSignBP();
		sign.sign(ciEnContextDTO, orderoperatedto);
		OrdBizLogger.info(null,"皮试自动签署--结束");
		return null;
	}

	private void setContextValue(CiOrderDO order) throws BizException {
		Context.get().setDeptId(order.getId_dep_or());
		Context.get().setOrgId(order.getId_org());
		UserDO[] udos = CiOrdAppUtils.getUserQryService().findByAttrValString(UserDO.ID_PSN, order.getId_emp_or());
		if(udos!=null&&udos.length>0){
			Context.get().setUserId(udos[0].getId_user());
		}
		
	}


	
}
