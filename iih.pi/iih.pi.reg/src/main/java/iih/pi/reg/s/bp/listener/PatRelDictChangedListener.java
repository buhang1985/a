package iih.pi.reg.s.bp.listener;

import iih.bd.bc.event.pub.IPiEventConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.dto.d.PiUdidocDTO;
import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.udi.d.UdidocDO;

public class PatRelDictChangedListener extends AbstractPiUdidocListener {

	@Override
	protected void doAction(IBusinessEvent event, UdidocDO[] dos) throws BizException {
		//dos 的肯定大于0
		switch (event.getEventType()) {
		case IEventType.TYPE_INSERT_AFTER:
			this.onInsert(dos);break;
		case IEventType.TYPE_DELETE_AFTER:
			this.onDelete(dos);break;
		case IEventType.TYPE_UPDATE_AFTER:
			this.onUpdate(dos);break;
		}
	}
	
	/**
	 * 触发事件
	 * @param type
	 * @param list
	 * @throws BizException
	 */
	private void invokeEvent(String type,FArrayList2 list) throws BizException{
		DomainBusinessUserObj buo = new DomainBusinessUserObj(list, BusiType.MZ,"0","0");
		BusinessEvent bizEvent = new BusinessEvent(IPiEventConst.EVENT_IE_PATIENT_RELATION,type, buo);
		BusinessEventListener ipEventListener =ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);// x.i.p.xml.ObjectToXmlTransformer
	}

	/**
	 * 新增后
	 * @param dos
	 * @throws BizException 
	 */
	private void onInsert(UdidocDO[] dos) throws BizException{
		FArrayList2 list=new FArrayList2(); 
		for(UdidocDO ud:dos){
			PiUdidocDTO dto=new PiUdidocDTO();
//			dto.setAction(IEventType.TYPE_INSERT_AFTER);//"insert" ?
			dto.setAction("insert");
			dto.setName(ud.getName());
			dto.setCode(ud.getCode());
			dto.setFlag(FBoolean.FALSE);
			dto.setPy_code(ud.getPycode());
			list.append(dto);
		}
		this.invokeEvent(IEventType.TYPE_INSERT_AFTER, list);
	}
	
	/**
	 * 更新后
	 * @param dos
	 * @throws BizException 
	 */
	private void onUpdate(UdidocDO[] dos) throws BizException{
		FArrayList2 list=new FArrayList2(); 
		for(UdidocDO ud:dos){
			PiUdidocDTO dto=new PiUdidocDTO();
//			dto.setAction(IEventType.TYPE_UPDATE_AFTER);//"update" ?
			dto.setAction("update");
			dto.setName(ud.getName());
			dto.setCode(ud.getCode());
			dto.setFlag(FBoolean.FALSE);
			dto.setPy_code(ud.getPycode());
			list.append(dto);
		}
		this.invokeEvent(IEventType.TYPE_UPDATE_AFTER, list);
	}
	
	/**
	 * 删除后
	 * @param dos
	 * @throws BizException 
	 */
	private void onDelete(UdidocDO[] dos) throws BizException{
		FArrayList2 list=new FArrayList2(); 
		for(UdidocDO ud:dos){
			PiUdidocDTO dto=new PiUdidocDTO();
//			dto.setAction(IEventType.TYPE_DELETE_AFTER);//"delete" ?
			dto.setAction("delete");
			dto.setName(ud.getName());
			dto.setCode(ud.getCode());
			dto.setFlag(FBoolean.FALSE);
			dto.setPy_code(ud.getPycode());
			list.append(dto);
		}
		this.invokeEvent(IEventType.TYPE_DELETE_AFTER, list);
	}
	
	@Override
	protected String getSdDoclist() {
		return IPiDictCodeConst.SD_PAT_REL_TYPE_DOCLIST;//与患者关系
	}
}
