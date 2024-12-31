package iih.bd.mm.iemsg.qry;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;

import iih.bd.mm.iemsg.d.AidititemDTO;
import iih.bd.mm.iemsg.d.AuditEntryDTO;
import iih.bd.mm.iemsg.d.AuditEventDTO;
import iih.mm.st.stockpriceadjust.d.StockPriceAdjustDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

public class AuditEventSql {


	public AuditEntryDTO[] setByMmid(StockPriceAdjustDO[] dedos,String eventtype) throws BizException {
		ArrayList<AuditEntryDTO> rtn=new ArrayList<AuditEntryDTO>();
		
		//遍历
		for(StockPriceAdjustDO mmdo: dedos ){
		
			
			if(!(eventtype.equals("4150907") ||eventtype.equals(IEventType.TYPE_DELETE_AFTER)))continue;
			AuditEntryDTO auditDTO = new AuditEntryDTO();
			auditDTO.setName("price");
			auditDTO.setNewvalue(mmdo.getPri_new_sales());
			auditDTO.setOldvalue(mmdo.getPri_old_sales());
			auditDTO.setId_mm(mmdo.getId_mm());
			rtn.add(auditDTO);	
			
		}				
		return rtn.toArray(new AuditEntryDTO[0]);
	}

	@SuppressWarnings("unchecked")
	public AuditEventDTO converyArray2FArrayList(AuditEntryDTO[] mmdo,String eventtype) throws BizException {
				
		AuditEventDTO dto = new AuditEventDTO();	
		AidititemDTO items = setItem(mmdo,eventtype);
		
		FArrayList2 itemlist = new FArrayList2();
		itemlist.addAll(Arrays.asList(items)); 
		
		dto.setId_mm(itemlist);			
		
		dto.setOperuserid(Context.get().getStuffId());
		dto.setOperdatetime(new FDateTime());
		dto.setOperunitid(Context.get().getDeptId());
		
		OrgDO orgdo = getOrgById();
		if(orgdo != null){			
			dto.setHospitalcode(orgdo.getOrgcode());
			dto.setHospitalname(orgdo.getName());			
		}		
		dto.setAuditevent("001");
		dto.setAuditsystemid("S001");
		
		InetAddress addr = null;
		String ip = null;
		String address = null;
		try {
			addr=InetAddress.getLocalHost();
			ip=addr.getHostAddress().toString();//获得本机IP　　  
		    address=addr.getHostName().toString();//获得本
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}  
      

		dto.setIpaddress(ip);
		dto.setComputername(address);
		return dto;
	}

	private OrgDO getOrgById() throws BizException {
		IOrgRService iOrgRService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgdo = iOrgRService.findById(Context.get().getOrgId());
		return orgdo;
	}

	@SuppressWarnings("unchecked")
	private AidititemDTO setItem(AuditEntryDTO[] mmdo,String eventtype) {
		
		AidititemDTO items = new AidititemDTO();
		items.setName("BD_MM");
		if("4150907".equals(eventtype))
		{
			items.setMessagetype("update");								
		}else if(IEventType.TYPE_DELETE_AFTER.equals(eventtype)){	
			
			items.setMessagetype("delete");								
		}
		
		FArrayList2 list = new FArrayList2();
		list.addAll(Arrays.asList(mmdo)); 	
		
		items.setItem(list);
			
		return items;
	}

}
