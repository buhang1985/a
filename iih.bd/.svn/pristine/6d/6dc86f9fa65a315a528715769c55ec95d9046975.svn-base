package iih.bd.pp.service.bp;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 取得医保目录对照查询用医保计划
 * @author ly 2017/05/26
 *
 */
public class GetHpIdForHpCatalogBP {

	/**
	 * 取得医保目录对照查询用医保计划
	 * @param entIds 就诊id数组
	 * @return map key:就诊id value:医保计划id
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap exec(String[] entIds) throws BizException{
		
		if(ArrayUtil.isEmpty(entIds))
			return null;
		
		String inSql = "(";
		for (String str : entIds) {
			inSql += "'" + str + "',";
		}
		
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
		
		DAFacade daf = new DAFacade();
		//取得默认医保计划
		String sql = "select ent.id_ent,ent.id_hp,hp.sd_hptp from en_ent ent left join bd_hp hp "
				+ "on ent.id_hp = hp.id_hp "
				+ "where ent.id_ent in " + inSql;
		
		List<Map<String,Object>> enHpRlt =  (List<Map<String,Object>>)daf.
				execQuery(sql, new MapListHandler());
		
		if(ListUtil.isEmpty(enHpRlt))
			return null;
		
		//取得就诊用主医保计划
		String hpSql = "select id_hp from bd_hp where fg_default = 'Y' ";
		String defaultHpId = (String)daf.execQuery(hpSql, new ColumnHandler());
		
		//组织返回值
		FMap rlt = new FMap();
		for (Map<String, Object> map : enHpRlt) {
			
			String entId = (String)map.get("id_ent");
			String hpId = (String)map.get("id_hp");
			String sd_hptp = (String)map.get("sd_hptp");
			
			//存在医保计划并且医保计划类型是社保，使用就诊主医保计划
			//否则使用默认医保计划
			if(!StringUtil.isEmpty(sd_hptp) && sd_hptp.indexOf("1") == 0){
				rlt.put(entId, hpId);
			}else{
				rlt.put(entId, defaultHpId);
			}
		}
		
		return rlt;
	}
}
