package iih.ci.ord.i.external.provide;

import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;

/**
 * 提供给医保平台接口
 * 对应模块iih.mi
 * @author HUMS
 *
 */
public interface ICiOrdMiService {

	/**
	 * 根据指定时间查询患者有效医嘱
	 * @param id_pat 患者id
	 * @param begin 开始时间
	 * @param end 结束时间
	 * @throws DAException 
	 */
	public FMap getPatHistoryMmInfo(String id_pat , FDateTime begin , FDateTime end) throws DAException;
}
