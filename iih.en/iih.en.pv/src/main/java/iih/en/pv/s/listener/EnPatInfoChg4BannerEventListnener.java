package iih.en.pv.s.listener;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pub.IEnSysMsgConst;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.message.message.i.IGenerateMessageExtdService;

/**
 * 就诊信息改变事件,通知banner处理
 * 
 * @author liubin
 *
 */
public class EnPatInfoChg4BannerEventListnener implements IBusinessListener {

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BDCommonEvent event = (BDCommonEvent) arg0;
		//事件源校验
		if(!PatiVisitDO.class.getName().equals(event.getSourceID()))
			return;
		//事件类型
		if(!IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType()))
			return;
		PatiVisitDO[] oldPvDos = essemly(event.getOldObjs());
		PatiVisitDO[] newPvDos = essemly(event.getNewObjs());
		
		if(EnValidator.isEmpty(oldPvDos) || EnValidator.isEmpty(newPvDos))
			return;
		
		//比较详细并发送消息
		compareAndSendMsg(oldPvDos, newPvDos);
	}
	/**
	 * 比较详细并发送消息
	 * 
	 * @param oldPvDos
	 * @param newPvDos
	 * @throws BizException 
	 */
	private void compareAndSendMsg(PatiVisitDO[] oldPvDos, PatiVisitDO[] newPvDos) throws BizException{
		for(PatiVisitDO oldPvDo : oldPvDos){
			for(PatiVisitDO newPvDo : newPvDos){
				if(oldPvDo.getId_ent().equals(newPvDo.getId_ent())){
					//如果是门诊的就诊信息变更，则不发送
					if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(newPvDo.getCode_entp())){
						break;
					}
					compareAndSendMsg(oldPvDo, newPvDo);
				}
			}
		}
	}
	/**
	 * 比较详细并发送消息
	 * 
	 * @param oldPvDo
	 * @param newPvDo
	 * @throws BizException 
	 */
	private void compareAndSendMsg(PatiVisitDO oldPvDo, PatiVisitDO newPvDo) throws BizException{
		List<String> chgList = new ArrayList<String>();
		//姓名比较
		if(!isSame(oldPvDo.getName_pat(), newPvDo.getName_pat()))
			chgList.add("姓名");
		//性别比较
		if(!isSame(oldPvDo.getSd_sex_pat(), newPvDo.getSd_sex_pat()))
			chgList.add("性别");
		//出生日期比较
		if(!isSame(oldPvDo.getDt_birth_pat(), newPvDo.getDt_birth_pat()))
			chgList.add("出生日期");
		//患者分类比较
		if(!isSame(oldPvDo.getId_patca(), newPvDo.getId_patca()))
			chgList.add("患者分类");
		//价格分类比较
		if(!isSame(oldPvDo.getId_pripat(), newPvDo.getId_pripat()))
			chgList.add("价格分类");
		//医保比较
		if(!isSame(oldPvDo.getId_hp(), newPvDo.getId_hp()))
			chgList.add("医保");
		//在院状态
		if(!isSame(oldPvDo.getFg_ip(), newPvDo.getFg_ip()))
			chgList.add("在院状态");
		//科室改变
		if(!isSame(oldPvDo.getId_dep_phy(), newPvDo.getId_dep_phy()))
			chgList.add("科室");
		//病区改变
		if(!isSame(oldPvDo.getId_dep_nur(), newPvDo.getId_dep_nur()))
			chgList.add("病区");
		if(EnValidator.isEmpty(chgList))
			return;
		sendMsg(newPvDo, chgList);
	}
	/**
	 * 发送消息
	 * 
	 * @param pv
	 * @param chgList
	 * @throws BizException 
	 */
	private void sendMsg(PatiVisitDO pv, List<String> chgList) throws BizException{
		if(pv == null  || EnValidator.isEmpty(chgList))
			return;
		Map<String, Object> map = new HashMap<>();
		map.put(PatiVisitDO.class.getSimpleName(), pv);
		map.put("ChgList", chgList);
		IGenerateMessageExtdService service = ServiceFinder.find(IGenerateMessageExtdService.class);
		service.GenerateMessageAndMap(IEnSysMsgConst.MSG_ENPATCHG_BANNER, map, null);
	}
	
	/**
	 * 转换PatiVisitDO
	 * 
	 * @param objs
	 * @return
	 */
	private PatiVisitDO[] essemly(Object[] objs){
		if(EnValidator.isEmpty(objs))
			return null;
		List<PatiVisitDO> list = new ArrayList<PatiVisitDO>(objs.length);
		for(Object obj : objs){
			if(obj instanceof PatiVisitDO)
				list.add((PatiVisitDO)obj);
		}
		return EnValidator.isEmpty(list) ? null : list.toArray(new PatiVisitDO[0]);
	}
	/**
	 * 字符串比较
	 * 
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	private boolean isSame(String oldStr, String newStr){
		if(EnValidator.isEmpty(oldStr)){
			return EnValidator.isEmpty(newStr);
		}
		return oldStr.equals(newStr);
	}
	/**
	 * 字符串比较
	 * 
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	private boolean isSame(FBoolean oldFg, FBoolean newFg){
		if(oldFg == null){
			return newFg == null;
		}
		return oldFg.equals(newFg);
	}
	/**
	 * 日期比较比较
	 * 
	 * @param oldDate
	 * @param newDate
	 * @return
	 */
	private boolean isSame(FDate oldDate, FDate newDate){
		if(oldDate == null && newDate == null)
			return true;
		if(oldDate == null || newDate == null)
			return false;
		return oldDate.asBegin().equals(newDate.asBegin());
	}
}
