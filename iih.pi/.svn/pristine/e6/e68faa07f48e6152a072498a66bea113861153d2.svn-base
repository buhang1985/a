package iih.pi.reg.s.bp.listener;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidoclistRService;

public abstract class AbstractPiUdidocListener implements IBusinessListener {

	@Override
	public final void doAction(IBusinessEvent event) throws BizException {
		if(!event.getSourceID().equals(this.getSourceID())){
			return;
		}
		BDCommonEvent bdce=(BDCommonEvent)event;
		Object[] objs=bdce.getNewObjs();//XXX 为什么不是 bdce.getOldObjs();
		if(ArrayUtil.isEmpty(objs)){
			return;
		}
		List<UdidocDO> dolist=new ArrayList<>();
		for(Object o:objs){
			UdidocDO doc=(UdidocDO)o;
			if(this.isMeet(doc)){
				dolist.add(doc);
			}
		}
		if(!dolist.isEmpty()){
			this.doAction(event,dolist.toArray(new UdidocDO[0]));
		}
	}

	/**
	 * 是否为指定的自定义档案
	 * @param doc
	 * @return
	 * @throws BizException 
	 */
	private boolean isMeet(UdidocDO doc) throws BizException{
		if (doc == null) {
			return false;
		}
		UdidoclistDO doclist = this.getudidocListDo(doc);
		if(doclist == null)
			return false;
		if (doclist.getCode().equals(this.getSdDoclist())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 取得对应的UdidoclistDO
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	private UdidoclistDO getudidocListDo(UdidocDO ordo) throws BizException {
		IUdidoclistRService service =  ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO udidoclistDo = service.findById(ordo.getId_udidoclist());
		return udidoclistDo;
	}
	
	/**
	 * 事件源id
	 * @return
	 */
	protected String getSourceID(){
		return UdidocDODesc.CLASS_FULLNAME;
	}
	
	/**
	 * 执行相关业务操作
	 * @param dos
	 */
	protected abstract void doAction(IBusinessEvent event,UdidocDO[] dos)throws BizException;
	
	/**
	 * 自定义档案类型
	 * @return
	 */
	protected abstract String getSdDoclist();
}
