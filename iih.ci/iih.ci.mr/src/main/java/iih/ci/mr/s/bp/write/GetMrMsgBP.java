/*
 * 扼要描述
     * 详细描述：〈描述〉
 * author：〈创建人/修改人〉
 */
package iih.ci.mr.s.bp.write;

import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 〈获取文书相关信息〉
 * 〈功能详细描述〉
 * @author    [邹海强]
 * @version   [版本号, YYYY-MM-DD]
 */
public class GetMrMsgBP {
	/**
	 * 获取文书引用
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public MrDocRefValueDO[] GetMrRefValueDoList(String id_ent) throws BizException{
		IMrdocrefvalueRService valueService =ServiceFinder.find(IMrdocrefvalueRService.class);
		StringBuilder sbSql=new StringBuilder();
		sbSql.append("a0.id_ent=");
		sbSql.append("'");
		sbSql.append(id_ent);
		sbSql.append("'");
		String sqlWhere=sbSql.toString();
		MrDocRefValueDO[] docDoArr=valueService.find(sqlWhere, "", FBoolean.FALSE);
		if (docDoArr.length>0) {
			return docDoArr;
		}else {
			return null;
		}
	}

}
