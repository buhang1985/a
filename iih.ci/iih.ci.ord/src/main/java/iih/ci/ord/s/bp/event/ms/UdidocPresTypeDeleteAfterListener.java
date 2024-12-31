package iih.ci.ord.s.bp.event.ms;

import iih.ci.ord.ms.d.MSUdidocPresTypeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractUdidocDeleteAfterListener;
import iih.ci.ord.s.bp.event.ms.bp.UdidocPresTypeBP;
import iih.ci.ord.s.bp.event.ms.enums.EventTypeEnum;
import iih.ci.ord.s.bp.event.ms.enums.SourcesIdEnum;
import iih.ci.ord.s.bp.event.ms.enums.UdidocCodeTypeEnum;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.xbd.udi.d.UdidocDO;

public class UdidocPresTypeDeleteAfterListener extends AbstractUdidocDeleteAfterListener{

	@Override
	protected void doYourActionAfter(Object[] newObjs) throws BizException {
		//根据字典编码过滤符合条件的数据   //CI.OR.0515
		UdidocDO[] PresTypeDos=super.getUdidocInfoByCode(newObjs,UdidocCodeTypeEnum.PRES_TYPE.getValueString());
		UdidocPresTypeBP udidocPresTypeBP=new UdidocPresTypeBP();
		//根据事件类型编码组装数据 delete
		MSUdidocPresTypeDTO[] msUdidocPresTypeDTOs=udidocPresTypeBP.assemableDatabyState(PresTypeDos,EventTypeEnum.DELETE_AFTER.getValueString());
		if(CiOrdUtils.isEmpty(msUdidocPresTypeDTOs)) {
			return;
		}
		int i=1;
		for(MSUdidocPresTypeDTO dto:msUdidocPresTypeDTOs) {
			if(dto != null) {
				OrdBizLogger.info(null, "MS095-删除后-MSUdidocPresTypeDTO:"+"["+i+"]"+dto.serializeJson());
			}
			//构建对象，并发送给集成组
			DomainBusinessUserObj domainBusinessUserObj = new DomainBusinessUserObj(dto,BusiType.TY);//04
			MsgObj mbx=new MsgObj();
			mbx.setExtendSubId("0");//收费标识
			domainBusinessUserObj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(SourcesIdEnum.PRES_TYPE_SOURCEID.getValueString(),//iih.ci.ord.ms.d.MSUdidocPresTypeDTO
					IEventType.TYPE_DELETE_AFTER, new BaseDTO[] { domainBusinessUserObj });//1006
			if(domainBusinessUserObj != null) {
				OrdBizLogger.info(null, "MS095-删除后-发送数据DomainBusinessUserObj:"+"["+i+"]"+domainBusinessUserObj.serializeJson());
			}
			i++;
		}
		
	}

}
