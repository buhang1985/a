package iih.en.que.s.bp;

import iih.en.comm.util.EnLogUtil;

import java.util.HashMap;
import java.util.Map;

import xap.lui.core.scriptrule.XapScriptAPI;
import xap.mw.core.data.BizException;

/***
 * 获取大屏姓名显示规则
 * @author fanlq
 * @date: 2019年9月5日 下午4:06:23
 */
public class GetBrdNameRulScripBP {
	/***
	 * @Description:获取大屏姓名显示规则
	 * @param fullName
	 * @return
	 * @throws BizException 
	 */
	public String exec(String fullName,String rulName,String nameTp) throws BizException{
		Map<String, Object> variable = new HashMap<String, Object>();
	    variable.put("fullName", fullName);
	    variable.put("nameTp", nameTp);
	    String showName = fullName;
	    try
        {
	    	showName = (String) XapScriptAPI.compileExeSingleRule(rulName, variable);
	    }
	    catch(Exception ex)
	    {
	    	EnLogUtil.getInstance().logInfo("脚本设计器["+rulName+"]维护错误！"+ex);
	    }
		return showName;
	}
}
