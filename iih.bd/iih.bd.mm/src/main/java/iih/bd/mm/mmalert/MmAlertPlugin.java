package iih.bd.mm.mmalert;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import iih.bd.mm.mmexpialterdto.d.Mmexpialterdto;
import iih.bd.mm.mmquanalertdto.d.MmQuanAlertDTO;
import iih.bd.mm.mmunusabledto.d.Mmunusabledto;
import iih.bd.res.warehouse.util.WhDataperUtil;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

/**
 * 低库存预警插件。
 * @author shao_yuan
 *
 */
public class MmAlertPlugin implements IGenerateRouserMsg {
	
	
	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> map) throws BizException {
		
		BaseDTO value = null;
		if(map.containsKey("MmQuanAlertDTO")) {
			
			value = (MmQuanAlertDTO) map.get("MmQuanAlertDTO");
		} else if(map.containsKey("Mmexpialterdto")) {
			
			value = (Mmexpialterdto) map.get("Mmexpialterdto");
		} else if(map.containsKey("Mmunusabledto")) {
			
			value = (Mmunusabledto) map.get("Mmunusabledto");
		}
		if(map.containsKey("MMMSGALLOCATIONWAITCONFIRM")) {
			
			Map<String, String> whmap = (HashMap<String, String>) map.get("MMMSGALLOCATIONWAITCONFIRM");
			if(whmap != null) {
				
				return new String[] {whmap.get("id_dep_wh")};
			}
		}    
        if(value != null){
        	
        	return WhDataperUtil.getUSeridByWare(value.getAttrVal("Id_wh").toString());
        }
		return null;
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1)
			throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitles(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URI getURI() throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

}
