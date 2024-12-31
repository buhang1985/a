package iih.en.pv.msg;

import iih.en.pv.dto.d.EnHosRegDTO;

import java.net.URI;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class IPSendeeDepMsgSender implements IGenerateRouserMsg{


    @Override
    public String getContent(Map<String, Object> arg0) throws BizException {
        
        return null;
    }

    @Override
    public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getDep(Map<String, Object> map) throws BizException {
        EnHosRegDTO dto =  (EnHosRegDTO) map.get("EnHosRegDTO");
        if (dto != null) {
            String id_dep_nuradm = dto.getId_dep_nuradm();
            return id_dep_nuradm;
        }
        return null;
    }

    @Override
    public String[] getRecipient(Map<String, Object> arg0) throws BizException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
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

}
