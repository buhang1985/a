package iih.en.pv.msg;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.message.i.IGenerateMessageExtdService;
import xap.sys.message.message.i.IGenerateRouserMsg;

/**
 * 就诊信息改变事件,通知banner处理
 * 
 * @author liubin
 *
 */
public class EnPatInfoChg4BannerSender implements IGenerateRouserMsg {
	private static final String DOCSTATION_FUNCODE = "461020";
	@SuppressWarnings("unchecked")
	@Override
	public String getContent(Map<String, Object> map) throws BizException {
		if(map == null || map.isEmpty() || !map.containsKey(PatiVisitDO.class.getSimpleName()) || !map.containsKey("ChgList"))
			return null;
		PatiVisitDO pv = (PatiVisitDO) map.get(PatiVisitDO.class.getSimpleName());
		List<String> chgList = (List<String>) map.get("ChgList");
		String content = String.format("Id_Pat: %s;Id_Ent: %s;Content: %s", pv.getId_pat(), pv.getId_ent(), assemly(chgList));
		return content;
	}

	@Override
	public String getContents(BaseDO[] arg0, BaseDTO[] arg1)
			throws BizException {
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
		IGenerateMessageExtdService extdService = ServiceFinder.find(IGenerateMessageExtdService.class);
		List<Map> list = extdService.getOnlineUserByFuncode(new String[]{DOCSTATION_FUNCODE});
		if(EnValidator.isEmpty(list)){
			return null;
		}
		List<String> result = new ArrayList<>();
		for (Map map : list) {
			if(map.containsKey("id_user")){
				result.add((String)map.get("id_user"));
			}
		}
		return EnValidator.isEmpty(result) ? null : result.toArray(new String[0]);
	}

	@Override
	public String[] getRecipients(BaseDO[] arg0, BaseDTO[] arg1)
			throws BizException {
		
		return null;
	}

	@Override
	public String getTitle(Map<String, Object> arg0) throws BizException {
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
	
	/**
	 * 组装数据
	 * 
	 * @param list
	 * @return
	 */
	private String assemly(List<String> list){
		if(EnValidator.isEmpty(list))
			return null;
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("患者就诊信息[");
		boolean isFirst = true;
		for(String str : list){
			if(isFirst){
				strBuilder.append(str);
				isFirst = false;
				continue;
			}
			strBuilder.append(",").append(str);
		}
		strBuilder.append("]改变！");
		return strBuilder.toString();
	}

}
