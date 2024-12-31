package iih.ci.event.ord.listeners.charge.op;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.st.dto.blpayoep.d.BlPayOepEventDTO;
import iih.ci.event.ord.listeners.OpEnterCommonListener;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
/**
 * 门诊收费入口监听类
 * @author F
 *
 * @date 2019年9月10日下午5:13:44
 *
 * @classpath iih.ci.event.ord.listeners.charge.op.OpChargeEnterListener
 */
public abstract class OpChargeEnterListener extends OpEnterCommonListener{

	/**
	 * 是否满足事件源和事件类型
	 * @param event
	 * @return
	 * @throws BizException
	 */
	@Override
	public boolean isMatchSourceIdAndEventType(IBusinessEvent event)throws BizException{
		OrdEventLogger.info(OpChargeEnterListener.class.getSimpleName(), "门诊收费入口监听");
		//该事件源用的费用组的 这是费用组发出来的 由他们定义的 事件类型 eventType:482001
		if(!IBlEventConst.EVENT_SOURCE_OEP_CHARGE.equals(event.getSourceID())){
			return false;
		}
		return true;
	}
	/**
	 * 转换获取到的数据
	 */
	@Override
	public CiOrderDO[] transformData(IBusinessEvent event)throws BizException{
		BusinessEvent dbevent = (BusinessEvent) event;
		Object newObjs = dbevent.getUserObject();
		if (newObjs == null)return null;
		OrdSrvDO[] srvs = getsrvs(newObjs, event.getSourceID());
		if (OrdEventUtil.isEmpty(srvs))return null;
		CiOrderDO[] ors = getcior8srv(srvs);
		return ors;
	}
	/**
	 * 获取医嘱
	 * @param srvs
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] getcior8srv(OrdSrvDO[] srvs) throws BizException {
		ICiorderMDORService service = ServiceFinder.find(ICiorderMDORService.class);
		String idors = getidors(srvs);
		OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊、急诊流水、急诊抢救的获取到的各个收费医嘱idors："+idors);
		if (idors == null)
			return null;
		CiOrderDO[] ciords = service.find(getfilter(idors), "", FBoolean.FALSE);
		return getOpData(ciords);
	}
	/**
	 * 过滤数据
	 * @param ciords
	 * @return
	 * @throws BizException
	 */
	protected CiOrderDO[] getOpData(CiOrderDO[] ciords) throws BizException{
		if(OrdEventUtil.isEmpty(ciords)) {
			return null;
		}
		//过滤数据
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
		for(CiOrderDO ciOrderDO:ciords) {
			OrdEventLogger.info(this.getClass().getSimpleName(), "普通门诊、急诊流水、急诊抢救的获取到的各个收费医嘱："+ciOrderDO.serializeJson());
			//门诊、急诊流水、急诊抢救数据筛选 ，放最上面 不符合没必要执行下面操作
			if(!isOpData(ciOrderDO))continue;
			rtn.add(ciOrderDO);
		}
		//空判断
		if(OrdEventUtil.isEmpty(rtn))return null;
		//返回值
		return rtn.toArray(new CiOrderDO[0]);
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
		if (sb.length() == 0)return null;
		return sb.toString();

	}

	/**
	 * 过滤医嘱 之前只查检查检验治疗  现在都查，查了不发消息不就行了 反正发什么消息 发不发都是自己定义  为了客开人员方便以及结构统一
	 * @param idors
	 * @return
	 */
	private String getfilter(String idors) {
//		String ciorname = CiOrderDODesc.TABLE_ALIAS_NAME;
//		String aString= ciorname + ".id_or in (" + idors + ") and  " +
//		ciorname + ".code_entp='" + OrdEventUtil.OP + "' and (" + 
//		ciorname + ".sd_srvtp like '" + OrdEventUtil.SD_SRVTP_RIS + "%' or " + 
//		ciorname + ".sd_srvtp like '" + OrdEventUtil.SD_SRVTP_LIS + "%' or "+
//		ciorname +".sd_srvtp like '"+ OrdEventUtil.SD_SRVTP_TREAT+"%')";
//      return aString;//以前的逻辑
		String ciorname = OrdEventUtil.TABLE_ALIAS_NAME;
		String aString= ciorname + ".id_or in (" + idors + ") and  " +ciorname
				+ ".code_entp in ('"+ OrdEventUtil.OP+"','"+OrdEventUtil.LS+"','"+OrdEventUtil.QJ+"')";
        return aString;
	}
	/**
	 * 获取服务
	 * @param newObjs
	 * @param sourceID
	 * @return
	 * @throws BizException
	 */
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
				if (!OrdEventUtil.SD_SRVTP_DRUG.equals(blCgItmOepDO.getCode_applytp()) && !StringUtil.isEmpty(blCgItmOepDO.getId_par()))
					continue;
				if (blCgItmOepDO.getId_orsrv() != null) {
					idSrvlist.add(blCgItmOepDO.getId_orsrv());
				}
			}
		}
		//这段逻辑就目前而言根本不可能走
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
	//下面三个方法没有调用 假如以后门诊收费也分急诊流水什么的会用的上
	/**
	 * 是否为特定医嘱判断
	 * 用户可重写该方法
	 * 判断逻辑可调用CiOrPubUtils.getCiOrderType(or)
	 * @param ors
	 * @return
	 */
	@Override
	protected boolean isSpecificOrder(CiOrderDO or){
		return true;
	}
	
	/**
	 * 按医嘱状态过滤检查
	 * @param ordo
	 * @return
	 */
	@Override
	protected boolean isOrStatusCheck(CiOrderDO ordo) {
		return true;
	}

}
