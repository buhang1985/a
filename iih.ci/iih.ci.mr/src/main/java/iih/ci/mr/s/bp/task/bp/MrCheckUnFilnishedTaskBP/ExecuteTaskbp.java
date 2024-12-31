package iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP;

import java.text.ParseException;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;

public class ExecuteTaskbp {

	public String executetaskBp(Map<String,Object> variableValueMap)throws BizException{
		String id_org = (String) variableValueMap.get("orgId");
		Context.get().setOrgId(id_org);
		String id_group = (String) variableValueMap.get("groupId");
		Context.get().setGroupId(id_group);
		GetpatListbp patlistbp = new GetpatListbp();
		try {
			patlistbp.Getpatlist(id_org);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
