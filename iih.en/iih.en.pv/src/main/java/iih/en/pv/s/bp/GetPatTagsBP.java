package iih.en.pv.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PatTagDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取患者标签
 * 
 * 
 * @author liubin
 * 
 * 上午10:09:34
 */
public class GetPatTagsBP {
	/**
	 * 获取患者标签Map
	 * key:患者id
	 * value:
	 * 
	 * @author liubin
	 * 
	 * @param patIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> exec(String[] entIds) throws BizException {
		Map<String, String> map = new HashMap<String, String>();
		if(EnValidator.isEmpty(entIds))
			return map;
		PatTagDTO[] TagTps = getTagTps(entIds);
		if(!EnValidator.isEmpty(TagTps)){
			for(PatTagDTO tag : TagTps){
				if(EnValidator.isEmpty(tag.getShortname_tagtp()))
					continue;
				if(map.containsKey(tag.getId_ent())){
					map.put(tag.getId_ent(), map.get(tag.getId_ent()) + "," + tag.getShortname_tagtp());
				}else
					map.put(tag.getId_ent(), tag.getShortname_tagtp());
			}
		}
		return map;
	}
	/**
	 * 获取患者标签
	 * 
	 * @author liubin
	 * 
	 * @param patIds
	 * @return
	 * @throws BizException
	 * 专SDLANLING0066 modified by lilei 2018-9-14
	 */
	private PatTagDTO[] getTagTps(String[] entIds) throws BizException{
		StringBuilder sqlBuilder  = new StringBuilder();
		sqlBuilder.append(" SELECT TAGTP.ID_ENT, ");
		sqlBuilder.append(" TP.CODE AS SD_TAGTP, ");
		sqlBuilder.append(" TP.NAME AS NAME_TAGTP, ");
		sqlBuilder.append(" TP.SHORTNAME AS SHORTNAME_TAGTP ");
		sqlBuilder.append(" FROM EN_ENT_TAGTP TAGTP ");
		sqlBuilder.append(" INNER JOIN BD_TAG_TP TP ON TAGTP.ID_TAGTP = TP.ID_TAGTP ");
		sqlBuilder.append(" WHERE TP.FG_ACTIVE = 'Y' AND " + SqlUtils.getInSqlByIds("TAGTP.ID_ENT", entIds));
		sqlBuilder.append(" UNION ALL ");
		sqlBuilder.append(" SELECT ENT.ID_ENT, ");
		sqlBuilder.append(" TP.CODE AS SD_TAGTP, ");
		sqlBuilder.append(" TP.NAME AS NAME_TAGTP, ");
		sqlBuilder.append(" TP.SHORTNAME AS SHORTNAME_TAGTP ");
		sqlBuilder.append(" FROM  EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN PI_PAT_TAG TAG ON ENT.ID_PAT = TAG.ID_PAT ");
		sqlBuilder.append(" INNER JOIN BD_TAG_TP TP ON TAG.ID_PATTAGTP = TP.ID_TAGTP ");
		sqlBuilder.append(" WHERE TP.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND (TP.ID_DEP = ENT.ID_DEP_PHY OR TP.EU_RANG_DEP = 0) ");
		sqlBuilder.append(" AND ((TP.FG_OP = 'Y' AND ENT.CODE_ENTP = '00') OR (TP.FG_IP = 'Y' AND ENT.CODE_ENTP = '10') OR (TP.FG_ER = 'Y' AND ENT.CODE_ENTP = '01'))");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
		List<PatTagDTO> list = (List<PatTagDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(PatTagDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new PatTagDTO[0]);
	}
	
}
