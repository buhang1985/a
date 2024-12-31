package iih.ci.mrfp.mrfpxml.i;

import xap.mw.core.data.BizException;
import iih.ci.mrfp.cimrfpdto.d.CimrfpdtoAggDTO;
import iih.ci.mrfp.mrfpxml.d.ClinicalDocument;

public interface ICiMrmMrfpXMLEntRService {
	
	/**
	 * 将病案首页信息转成医保xml对象格式数据
	 * @param cimrfpdata
	 * @return
	 */
	public abstract String convertData2XMLObj(String id_ent) throws BizException;
	
	/**
	 * 将对象数据转成xml字符串
	 * @param doc
	 * @return
	 */
	public abstract String getXML(ClinicalDocument doc);

}
