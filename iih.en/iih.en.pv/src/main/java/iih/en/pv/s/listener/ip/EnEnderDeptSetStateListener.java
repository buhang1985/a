package iih.en.pv.s.listener.ip;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntStateDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.s.bp.SetEntStateBP;
import iih.pi.overview.overview.d.PiPatAlDO;
import iih.pi.overview.overview.i.IPiPatAlDORService;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;

/**
 * 入科监听器
 * 写入就诊状况（入院，病情，过敏）
 * 
 * @author liubin
 *
 */
public class EnEnderDeptSetStateListener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//校验事件
		this.validate(event);
		
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		EnterDept4EsDTO eventSourceDTO = (EnterDept4EsDTO) bizUserObj.getUserObj();
		if(eventSourceDTO == null)
			return;
		List<EntStateDTO> stateList = new LinkedList<>();
		//设置入院就诊状况
		this.setAdminssionToday(stateList, eventSourceDTO);
		//设置病情就诊状况
		this.setDiseState(stateList, eventSourceDTO);
		//设置过敏就诊状况
		this.setPatAlState(stateList, eventSourceDTO);
		//保存就诊状况
		if(stateList.size() > 0){
			SetEntStateBP setEntStateBP = new SetEntStateBP();
			setEntStateBP.exec(stateList.toArray(new EntStateDTO[0]));
		}
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
	/**
	 * 设置当日入院就诊状况
	 * 
	 * @param list
	 * @param eventSourceDTO
	 * @throws BizException
	 */
	private void setAdminssionToday(List<EntStateDTO> list, EnterDept4EsDTO eventSourceDTO) throws BizException{
		EntStateDTO inHosEntState = new EntStateDTO();
		inHosEntState.setId_ent(eventSourceDTO.getId_ent());
		inHosEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTATE_ADMINSSIONTODAY);
		inHosEntState.setVal(IBdFcDictCodeConst.EN_STATE_HASSTATE);
		inHosEntState.setDt_occ(eventSourceDTO.getDt_acpt());
		list.add(inHosEntState);
	}
	/**
	 * 设置当日入院就诊状况
	 * 
	 * @param list
	 * @param eventSourceDTO
	 * @throws BizException
	 */
	private void setDiseState(List<EntStateDTO> list, EnterDept4EsDTO eventSourceDTO) throws BizException{
		InpatientDO ipDo = new IpEP().getIpByEntId(eventSourceDTO.getId_ent());
		if(ipDo == null || EnValidator.isEmpty(ipDo.getSd_level_dise()))
			return;
		EntStateDTO disEntState = new EntStateDTO();
		disEntState.setId_ent(ipDo.getId_ent());
		disEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE);
		disEntState.setVal(ipDo.getSd_level_dise());
		disEntState.setDt_occ(eventSourceDTO.getDt_acpt());
		list.add(disEntState);
	}
	/**
	 * 患者过敏就诊状况
	 * 
	 * @param list
	 * @param eventSourceDTO
	 * @throws BizException
	 */
	private void setPatAlState(List<EntStateDTO> list, EnterDept4EsDTO eventSourceDTO) throws BizException{
		IPiPatAlDORService serv = ServiceFinder.find(IPiPatAlDORService.class);
		PiPatAlDO[] als = serv.find("ID_PAT = '"+ eventSourceDTO.getId_pat() + "' ", "NVL(SD_ALDEG,'1') DESC", FBoolean.FALSE);
		if(!EnValidator.isEmpty(als)){
			EntStateDTO alEntState = new EntStateDTO();
			alEntState.setId_ent(eventSourceDTO.getId_ent());
			alEntState.setSd_enstatetp(IBdFcDictCodeConst.SD_ENSTATE_ALLERGY);
			alEntState.setVal(!EnValidator.isEmpty(als[0].getSd_aldeg()) ? als[0].getSd_aldeg() : IPiDictCodeConst.SD_ALDEG_GENARAL);
			alEntState.setDt_occ(eventSourceDTO.getDt_acpt());
			list.add(alEntState);
		}
	}
}
