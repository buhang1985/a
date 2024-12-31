package iih.ci.diag.s.external;


import iih.ci.diag.i.external.ICidiagExtQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 诊断对外接口实现
 * 
 * @author HUMS
 *
 */


public class CidiagExtQryServiceImpl implements ICidiagExtQryService {

	@Override
	public FMap2 ConvertDiagType(String code_ditp, String code_entp) throws BizException {
		FMap2 result = new FMap2();
		if (code_entp != null) {
			// 门诊就诊全部为集成平台门诊诊断
			if (code_entp.equals("00")||code_entp.equals("0101")||code_entp.equals("0102")) {
				result.put("code", "2");
				result.put("name", "门诊诊断");
			} else if (code_entp.equals("10")||code_entp.equals("0103")) {
				// 为住院类型诊断则查询诊断类型
				if (code_ditp != null) {
					//String sql = "select code from BD_UDIDOC where ID_UDIDOC  = '" + id_ditp + "'";
					//DAFacade dafacade = new DAFacade();
					//List<String> list = (List<String>) dafacade.execQuery(sql, new ColumnListHandler());
					//String code = "";
					//if (list != null && list.size() > 0) {
					//	for (String str : list) {
					//		code = str;
					//	}
					//}
					// 诊断类型为6出院诊断 16死亡诊断对应集成平台的出院诊断
					if (code_ditp.equals("15") || code_ditp.equals("16")) {
						result.put("code", "1");
						result.put("name", "出院诊断");
					} else if (code_ditp.equals("12")) {
						result.put("code", "3");
						result.put("name", "入院诊断");
					} else {
						result.put("code", "99");
						result.put("name", "其他");
					}
				}
				/*result.put("code", "2");
				result.put("name", "门诊诊断");*/
			}
		}
		return result;
	}

}
