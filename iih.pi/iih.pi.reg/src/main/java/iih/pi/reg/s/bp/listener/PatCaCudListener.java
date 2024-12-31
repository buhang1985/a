package iih.pi.reg.s.bp.listener;

import java.util.ArrayList;
import java.util.List;

import iih.pi.dic.dto.d.PiPatCaIEDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.d.desc.PiPatCaDODesc;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 患者身份字典变更监听器
 * @author hanjq
 */
public class PatCaCudListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		if(!event.getSourceID().equals(this.getSourceId())){
			return;
		}
		BDCommonEvent bdce=(BDCommonEvent)event;
		Object[] objs=bdce.getNewObjs();//XXX 为什么不是 bdce.getOldObjs();
		if(ArrayUtil.isEmpty(objs)){
			return;
		}
		List<PiPatCaDO> list=new ArrayList<>();
		for(Object o:objs){
			PiPatCaDO ca=(PiPatCaDO)o;
			if(ca!=null){
				list.add(ca);
			}
		}
		if(ListUtil.isEmpty(list)){
			return;
		}
		switch (event.getEventType()) {
		case IEventType.TYPE_UPDATE_AFTER:
			this.onUpdate(list);break;
		case IEventType.TYPE_INSERT_AFTER:
			this.onInsert(list);break;
		case IEventType.TYPE_DELETE_AFTER:
			this.onDelete(list);break;
		}
	}
 
	/**
	 * 删除后
	 * @param list
	 * @throws BizException 
	 */
	private void onDelete(List<PiPatCaDO> list) throws BizException{
		ArrayList<PiPatCaIEDTO> ieList = new ArrayList<>(list.size());
		for(PiPatCaDO ca:list){
			PiPatCaIEDTO dto=new PiPatCaIEDTO();
			dto.setAction("delete");
			dto.setCode(ca.getCode());
			dto.setName(ca.getName());
			dto.setPycode(ca.getPycode());
			dto.setItemversion(null);
			dto.setStopflag(null);
			ieList.add(dto);
		}
		this.invokeEvent(IEventType.TYPE_DELETE_AFTER, ieList);
	}
	 
	/**
	 * 插入后
	 * @param list
	 * @throws BizException 
	 */
	private void onInsert(List<PiPatCaDO> list) throws BizException{
		ArrayList<PiPatCaIEDTO> ieList = new ArrayList<>(list.size());
		for(PiPatCaDO ca:list){
			PiPatCaIEDTO dto=new PiPatCaIEDTO();
			dto.setAction("insert");
			dto.setCode(ca.getCode());
			dto.setName(ca.getName());
			dto.setPycode(ca.getPycode());
			dto.setItemversion(null);
			dto.setStopflag(null);
			ieList.add(dto);
		}
		this.invokeEvent(IEventType.TYPE_INSERT_AFTER, ieList);
	}

	/**
	 * 修改后
	 * @param list
	 * @throws BizException 
	 */
	private void onUpdate(List<PiPatCaDO> list) throws BizException{
		ArrayList<PiPatCaIEDTO> ieList = new ArrayList<>(list.size());
		for(PiPatCaDO ca:list){
			PiPatCaIEDTO dto=new PiPatCaIEDTO();
			dto.setAction("update");
			dto.setCode(ca.getCode());
			dto.setName(ca.getName());
			dto.setPycode(ca.getPycode());
			dto.setItemversion(null);
			dto.setStopflag(null);
			ieList.add(dto);
		}
		this.invokeEvent(IEventType.TYPE_UPDATE_AFTER, ieList);
	}
	
	/**
	 * 触发平台事件
	 * @param type
	 * @param list
	 * @throws BizException
	 */
	private void invokeEvent(String type,ArrayList<PiPatCaIEDTO> ieList) throws BizException{
		DomainBusinessUserObj buo = new DomainBusinessUserObj(ieList, BusiType.NO_CAT,"0","0");
		BusinessEvent event=new BusinessEvent(this.getSourceId(),type,buo);
		BusinessEventListener ipEventListener =ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(event);
	}
	
	/**
	 * 获取事件源id
	 * @return
	 */
	private String getSourceId(){
		return PiPatCaDODesc.CLASS_FULLNAME;
	}
}
