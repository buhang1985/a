package iih.ci.mr.mrserviceext.s;

import java.util.HashMap;
import java.util.Map;
import org.mvel2.MVEL;
import org.mvel2.ParserContext;
import com.ymer.designer.scripteditor.MvelExtMethod;
import iih.bd.srv.mrcompleterule.d.MrCompleteRuleDO;
import iih.bd.srv.mrcompleterule.i.IMrcompleteruleRService;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class MrSignMvelExtMethod implements MvelExtMethod{

	@Override
	public String getClazzDesc() {
		return "病案签收规则";
	}

	@Override
	public Map<String, String> getMethodParamsDesc() {
		Map<String, String> desclz = new HashMap<String, String>();
		desclz.put("isCompleteRule", String.class.getName());
		return desclz;
	}

	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> rtnTypes = new HashMap<String, String>();
		rtnTypes.put("isCompleteRule", String.class.getName());
		return rtnTypes;
	}

	@Override
	public void importMethod(ParserContext paramParserContext) {
		paramParserContext.addImport("isCompleteRule", MVEL.getStaticMethod(MrSignMvelExtMethod.class, "isCompleteRule", new Class[] { String.class }));
	}

	
	public static String isCompleteRule(String id_ent)  throws BizException{
		ICiemrRService emrRService = ServiceFinder.find(ICiemrRService.class);
		CiMrDO[] cimrDoArr = emrRService.find(" a0.id_ent = '" + id_ent + "' ", null, FBoolean.FALSE);
		// 此处验证完成书写规则节点传过来的数据
		IMrcompleteruleRService completeService = ServiceFinder.find(IMrcompleteruleRService.class);
		MrCompleteRuleDO[] ruleArr = completeService.find(" fg_active='Y'", "", FBoolean.FALSE);
		StringBuilder sb=new StringBuilder();
		if (ruleArr.length <= 0) {
			return sb.toString();
		}

		for (int i = 0; i < ruleArr.length; i++) {
			if (ruleArr[i].getFg_change() == FBoolean.TRUE) {
				String qry = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp() + "'";
				cimrDoArr = emrRService.find(qry, "", FBoolean.FALSE);

				if (cimrDoArr.length <= 0) {
					String mrtpsStr = "'" + ruleArr[i].getId_change_mrtps().replace(",", "','") + "'";
					String sqlwhere = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp in (" + mrtpsStr + ")";
					CiMrDO[] cimrDoChangeArr = emrRService.find(sqlwhere, "", FBoolean.FALSE);

					if ((null == cimrDoArr || cimrDoArr.length == 0) && null == cimrDoChangeArr
							|| cimrDoChangeArr.length == 0) {
						sb.append("该患者未建立" + ruleArr[i].getMrtp_name() + "\r\n");
					}
				}

			} else {
				String qryby = " a0.id_ent = '" + id_ent + "' and  a0.id_mrtp = '" + ruleArr[i].getId_mrtp() + "'";
				cimrDoArr = emrRService.find(qryby, "", FBoolean.FALSE);
				if (null == cimrDoArr || cimrDoArr.length == 0) {
					sb.append("该患者未建立" + ruleArr[i].getMrtp_name() + "\r\n");
				}
			}
		}
		return sb.toString();
	}
}
