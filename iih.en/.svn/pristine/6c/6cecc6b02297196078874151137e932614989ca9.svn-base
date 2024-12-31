package iih.en.pv.s.listener;

import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 监听：床位名称修改后修改en_ent_ip
 * 
 * @author lilei
 *
 */
public class EnIpBedNameChangedListener implements IBusinessListener {
	
	/**
	 * 执行
	 */
	public void doAction(IBusinessEvent event) throws BizException {
		EnLogUtil.getInstance().displayInfo("接收事件: " + event.getEventType());
		//1、校验事件是否匹配
		this.validate(event);
		//2、包装显示所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		Bdbed bdbed = (Bdbed)bizUserObj.getUserObj();
		
		this.updatePatState(bdbed,event.getEventType());
	}
	
	/***
	 * 修改患者的就诊状况
	 * @param nmrEventDTO
	 * @param eventType
	 * @throws BizException 
	 */
	private void updatePatState(Bdbed bdbed,String eventType) throws BizException{
		if(bdbed == null){
			return;
		}
		SqlParam param = new SqlParam();
		StringBuilder sb = new StringBuilder();
		sb.append(" update en_ent_ip ip set ip.name_bed = ? where ip.id_ent= ");
		sb.append(" (select ent.id_ent from en_ent ent inner join en_ent_ip ip2 on ip2.id_ent = ent.id_ent where ent.fg_ip = 'Y' and ip2.id_bed = ?)");
		param.addParam(bdbed.getName());
		param.addParam(bdbed.getId_bed());
		new DAFacade().execUpdate(sb.toString(), param);
	}
	
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!"iih.bd.res.bed.d.Bdbed".equalsIgnoreCase(event.getSourceID())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
}
