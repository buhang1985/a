package iih.ci.ord.s.external.listener.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.ip.mqmsg.CiOrderExecDepMQBP;
import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;

public class FireOpOrAfterFeeEventMsgBP implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}
		// 事件源及事件类型判断
		//2019年3月13日 GH 修改事件源
		if (!(event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OEP_CHARGE) || event.getSourceID().equals(IBlEventConst.EVENT_SOURCE_OP_CHARGE)))
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
		CiOrderDO[] ors = getcior8srv(srvs);
		if (ors == null || ors.length == 0)
			return;

		//调用接口向手术执行科室发送消息
		CiEnContextDTO ctx = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		CiOrderExecDepMQBP ordExecDepMQBP = new CiOrderExecDepMQBP();
		ordExecDepMQBP.broadcastOrderListViewMsg(ctx, ors);
	}

	protected OrdSrvDO[] getsrvs(Object newObjs, String sourceID) throws BizException {
		IOrdSrvDORService rservice = ServiceFinder.find(IOrdSrvDORService.class);
		List<String> idSrvlist = new ArrayList<String>();
		BusinessUserObj business = (BusinessUserObj) newObjs;

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

	private String getidors(OrdSrvDO[] srvs) {
		Map<String, Object> ormap = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (OrdSrvDO ordSrvDO : srvs) {

			if (!ormap.containsKey(ordSrvDO.getId_or())) {

				ormap.put(ordSrvDO.getId_or(), new Object());

				if (sb.length() == 0) {
					sb.append("'" + ordSrvDO.getId_or() + "'");
				} else {
					sb.append(",'" + ordSrvDO.getId_or() + "'");
				}
			}
		}

		if (sb.length() == 0)
			return null;

		return sb.toString();
	}

	private String getfilter(String idors) {
		String ciorname = CiOrderDODesc.TABLE_ALIAS_NAME;
		String aString= ciorname + ".id_or in (" + idors + ") and  " + ciorname + ".code_entp='" + IBdFcDictCodeConst.SD_CODE_ENTP_OP + "' and (" + ciorname + ".sd_srvtp like '" + IBdSrvDictCodeConst.SD_SRVTP_OP + "%')";
        return aString;
	}
	
	protected CiOrderDO[] getcior8srv(OrdSrvDO[] srvs) throws BizException {
		ICiorderMDORService service = ServiceFinder.find(ICiorderMDORService.class);
		String idors = getidors(srvs);
		if (idors == null)
			return null;
		CiOrderDO[] ciords = service.find(getfilter(idors), "", FBoolean.FALSE);
		return ciords;
	}
}
