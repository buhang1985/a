package iih.sc.apt.s.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.dto.d.OpCharge4EsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.sc.apt.s.listener.bp.OpLisRisAfterFeeBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 监听门诊检查检验收费后
 * @author yzh
 */
public class OpLisRisAfterFeeListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 事件源及事件类型判断
		if (!(event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OEP_CHARGE) || event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OP_CHARGE) || event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OP_ACC)))
			return;

		// 收费成功的服务项目数据及空判断逻辑
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();

		if (newObjs == null)
			return;
		OrdSrvDO[] srvs = getsrvs(newObjs, event.getSourceID());
		if (srvs == null || srvs.length == 0)
			return;
		// 获得收费后检查检验医嘱数据信息
		List<String> idorlist = this.getidors(srvs);
		if (ListUtil.isEmpty(idorlist))
			return;

		// 医嘱签署后，实现自身业务逻辑
		this.LisRisAfterFeeAction(idorlist);

	}

	
	private void LisRisAfterFeeAction(List<String> idorlist) throws BizException{
		OpLisRisAfterFeeBP bp = new OpLisRisAfterFeeBP();
		bp.exec(idorlist);
	}
	

	private List<String> getidors(OrdSrvDO[] srvs) {

		Map<String, Object> ormap = new HashMap<>();
		List<String> idorlist = new ArrayList<String>();
		for (OrdSrvDO ordSrvDO : srvs) {

			if (!ormap.containsKey(ordSrvDO.getId_or())) {

				ormap.put(ordSrvDO.getId_or(), new Object());

				idorlist.add(ordSrvDO.getId_or());
			}
		}
		if (ListUtil.isEmpty(idorlist))
			return null;

		return idorlist;

	}

	

	private OrdSrvDO[] getsrvs(Object newObjs, String sourceID) throws BizException {
		IOrdSrvDORService rservice = ServiceFinder.find(IOrdSrvDORService.class);
		List<String> idSrvlist = new ArrayList<String>();
		BusinessUserObj business = (BusinessUserObj) newObjs;

		if (sourceID.equals(IBlEventConst.EVENT_SOURCE_OP_CHARGE)) {
			OpCharge4EsDTO opcharge = (OpCharge4EsDTO) business.getUserObj();
			IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
			BlCgItmOepDO[] cgitmDos = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, opcharge.getId_st());
			for (BlCgItmOepDO blCgItmOepDO : cgitmDos) {
				//退费重收时判断不是药品的 不发送重收消息
				if (!IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(blCgItmOepDO.getCode_applytp()) && !StringUtil.isEmpty(blCgItmOepDO.getId_par()))
					continue;
				if (blCgItmOepDO.getId_orsrv() != null) {
					idSrvlist.add(blCgItmOepDO.getId_orsrv());
				}
			}
		}
		if (sourceID.equals(IBlEventConst.EVENT_SOURCE_OEP_CHARGE)) {
			BlPayOepEventDTO opcharge = (BlPayOepEventDTO) business.getUserObj();
			IBlCgItmOepDORService cgService = ServiceFinder.find(IBlCgItmOepDORService.class);
			BlCgItmOepDO[] cgitmDos = cgService.findByAttrValString(BlCgItmOepDO.ID_STOEP, opcharge.getStData().getId_stoep());
			for (BlCgItmOepDO blCgItmOepDO : cgitmDos) {
				//退费重收时判断不是药品的 不发送重收消息
				if (!IBdSrvDictCodeConst.SD_SRVTP_DRUG.equals(blCgItmOepDO.getCode_applytp()) && !StringUtil.isEmpty(blCgItmOepDO.getId_par()))
					continue;
				if (blCgItmOepDO.getId_orsrv() != null) {
					idSrvlist.add(blCgItmOepDO.getId_orsrv());
				}
			}
		}

		if (sourceID.equals(IBlEventConst.EVENT_SOURCE_OP_ACC)) {
			OpAcc4EsDTO[] accDtos = (OpAcc4EsDTO[]) business.getUserObj();
			for (OpAcc4EsDTO opAcc4EsDTO : accDtos) {
				if (opAcc4EsDTO.getId_orsrv() != null) {
					idSrvlist.add(opAcc4EsDTO.getId_orsrv());
				}
			}
		}

		// 判断是否结算
		if (idSrvlist.size() == 0)
			return null;

		OrdSrvDO[] srvs = rservice.findByBIds(idSrvlist.toArray(new String[idSrvlist.size()]), FBoolean.FALSE);
		return srvs;
	}

}
