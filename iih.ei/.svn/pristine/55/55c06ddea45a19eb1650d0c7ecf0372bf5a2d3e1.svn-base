package iih.ei.std.consis.v1.s;

import iih.ei.std.consis.v1.i.ICDMWebService;
import iih.ei.std.consis.v1.s.bp.CollDrugFinishBp;

/**
 * IIH提供给门诊配药机的WebService
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class CDMWebService implements ICDMWebService {

	public String collDrugFinish(String paramXml) {
		CollDrugFinishBp bp = new CollDrugFinishBp();
		String resultXml = bp.exec(paramXml);
		return resultXml;
	}
}
