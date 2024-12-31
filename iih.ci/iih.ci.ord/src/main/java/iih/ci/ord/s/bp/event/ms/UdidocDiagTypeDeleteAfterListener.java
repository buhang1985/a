package iih.ci.ord.s.bp.event.ms;

import iih.ci.ord.ms.d.MSUdidocDiagTypeDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractUdidocDeleteAfterListener;
import iih.ci.ord.s.bp.event.ms.bp.UdidocDiagTypeBP;
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

public class UdidocDiagTypeDeleteAfterListener extends AbstractUdidocDeleteAfterListener{

	@Override
	protected void doYourActionAfter(Object[] newObjs) throws BizException {
		//根据字典编码过滤符合条件的数据   //CI.DI.0505
		UdidocDO[] diagTypeDos=super.getUdidocInfoByCode(newObjs,UdidocCodeTypeEnum.DIAG_TYPE.getValueString());
		UdidocDiagTypeBP udidocDiagTypeBP=new UdidocDiagTypeBP();
		//根据事件类型编码组装数据 delete
		MSUdidocDiagTypeDTO[] msUdidocDiagTypeDTOs=udidocDiagTypeBP.assemableDatabyState(diagTypeDos,EventTypeEnum.DELETE_AFTER.getValueString());
		if(CiOrdUtils.isEmpty(msUdidocDiagTypeDTOs)) {
			return;
		}
		int i=1;
		for(MSUdidocDiagTypeDTO dto:msUdidocDiagTypeDTOs) {
			if(dto != null) {
				OrdBizLogger.info(null, "MS016-删除后-MSUdidocDiagTypeDTO:"+"["+i+"]"+dto.serializeJson());
			}
			//构建对象，并发送给集成组
			DomainBusinessUserObj domainBusinessUserObj = new DomainBusinessUserObj(dto,BusiType.TY);//04
			MsgObj mbx=new MsgObj();
			mbx.setExtendSubId("0");//收费标识
			domainBusinessUserObj.setMsgObj(mbx);	
			CiOrdUtils.fireEvent(SourcesIdEnum.DIAG_TYPE_SOURCEID.getValueString(),//iih.ci.ord.ms.d.MSUdidocDiagTypeDTO
					IEventType.TYPE_DELETE_AFTER, new BaseDTO[] { domainBusinessUserObj });//1006
			if(domainBusinessUserObj != null) {
				OrdBizLogger.info(null, "MS016-删除后-发送数据DomainBusinessUserObj:"+"["+i+"]"+domainBusinessUserObj.serializeJson());
			}
			i++;
		}
		
	}

}
