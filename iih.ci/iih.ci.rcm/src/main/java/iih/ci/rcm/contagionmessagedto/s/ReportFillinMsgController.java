package iih.ci.rcm.contagionmessagedto.s;

import java.net.URI;
import java.util.Map;
import iih.ci.rcm.contagion.dto.d.EntDto;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.sys.message.message.i.IGenerateRouserMsg;

public class ReportFillinMsgController implements IGenerateRouserMsg{

	@Override
	public String getContent(Map<String, Object> arg0) throws BizException {
		// 消息内容
		EntDto[] entArr = getMessageDataInfo(arg0);
		String msg="";	
		if (entArr != null && entArr.length>0) {
			for(EntDto entdto :entArr){
				String name = "";
				String diName ="";
				if(entdto.getName_pat()!=null)
				{
					if(entdto.getName_pat().length()>6)
						name = entdto.getName_pat().substring(0,4)+"...";
					else 
						name = entdto.getName_pat();
				}
				if(entdto.getName_didef_dis()!=null)
				{
					if(entdto.getName_didef_dis().length()>10)
						diName = entdto.getName_didef_dis().substring(0,8)+"...";
					else
						diName = entdto.getName_didef_dis();
				}
				msg +="患者："+name+" 就诊号: "+entdto.getCode_ent()+" 诊断名称："+diName
				    +" 报卡状态："+entdto.getName_con_cardsn()+"  未提交，请完成传染病报卡"+"<a funcode='46601607' ident='"+entdto.getId_ent()+"' >传染病报卡</a>"+"!\n";			
			}
			return msg;
		}
		return null;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDep(Map<String, Object> arg0) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getRecipient(Map<String, Object> arg0) throws BizException {
		// 消息接收用户
		EntDto[] entarr = getMessageDataInfo(arg0);
		if(entarr!=null && entarr.length>0){
			String[] recipients=new String[]{entarr[0].getId_user()};
			return recipients;
		}
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
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public  EntDto[] getMessageDataInfo(Map<String, Object> arg0) {		
		if (arg0 != null && arg0.size() > 0 && arg0.containsKey("CIMRCONTAGION")) {
			return   (EntDto[])arg0.get("CIMRCONTAGION");
		}
		return null;
	}
}
