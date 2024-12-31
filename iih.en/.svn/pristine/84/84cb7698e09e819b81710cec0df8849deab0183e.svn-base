package iih.en.comm.ep;

import iih.bd.base.utils.SqlUtils;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.PatTagDTO;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpRService;
import iih.en.pv.inpatient.dto.d.IpRegInfoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 就诊标签EP
 * @author fanlq
 *
 */
public class EnTagtpEP {

	/***
	 * 贫困患者编码常量
	 */
	private static String CODE_POOR_TAGETP = "003";
	
	/***
	 * 通过就诊id获取患者就诊标签类型名称
	 * @param entList
	 * @return
	 * @throws BizException
	 */
	public FMap getEntNameTagtp(List<String> entList) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select entag.id_ent,wm_concat(nvl(tagtp.shortname,tagtp.name)) Name_tagtp from en_ent_tagtp entag ");
		sql.append("inner join bd_tag_tp tagtp on tagtp.id_tagtp = entag.id_tagtp " );
		sql.append("where "+SqlUtils.getInSqlByBigIds("entag.id_ent", entList.toArray(new String[0])));
		sql.append("and tagtp.fg_active = 'Y' ");
		sql.append("and tagtp.fg_ip = 'Y' ");
		sql.append("group by entag.id_ent ");
		@SuppressWarnings("unchecked")
		List<IpRegInfoDTO> list = (List<IpRegInfoDTO>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(IpRegInfoDTO.class));
		FMap map = new FMap();
		if(list != null && list.size() > 0){
			for(IpRegInfoDTO ipRegInfoDTO : list){
				map.put(ipRegInfoDTO.getId_ent(), ipRegInfoDTO.getName_tagtp());
			}
		}
		return map;
	}

	/***
	 * 通过患者id获取患者标签类型名称
	 * @param patList
	 * @return
	 * @throws BizException
	 */
	public FMap getPatNameTagtp(List<String> patList) throws BizException{
		StringBuffer sql = new StringBuffer();
		sql.append("select patag.id_pat,wm_concat(nvl(tagtp.shortname,tagtp.name)) Name_tagtp from pi_pat_tag patag ");
		sql.append("inner join bd_tag_tp tagtp on tagtp.id_tagtp = patag.id_pattagtp " );
		sql.append("where "+SqlUtils.getInSqlByBigIds("patag.id_pat", patList.toArray(new String[0])));
		sql.append("and tagtp.fg_active = 'Y' ");
		sql.append("and tagtp.fg_ip = 'Y' ");
		sql.append("group by patag.id_pat; ");
		@SuppressWarnings("unchecked")
		List<IpRegInfoDTO> list = (List<IpRegInfoDTO>) new DAFacade().execQuery(sql.toString(),new BeanListHandler(IpRegInfoDTO.class));
		FMap map = new FMap();
		if(list != null && list.size() > 0){
			for(IpRegInfoDTO ipRegInfoDTO : list){
				map.put(ipRegInfoDTO.getId_pat(), ipRegInfoDTO.getName_tagtp());
			}
		}
		return map;
	}
	
	/***
	 * 通过患者就诊标签获取患者就诊标签类型名称
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String getEnNameTagtp(String id_ent) throws BizException{
		EnTagTpDO[] tagTps = rservice().findByAttrValString(EnTagTpDO.ID_ENT, id_ent);
		if(tagTps != null && tagTps.length > 0){
			for(EnTagTpDO tagTp : tagTps){
				return tagTp.getShortname() != null ? tagTp.getShortname() : tagTp.getName_tagtp();
			}
		}
		return null;
	}
	/**
	 * 获取患者标签Map,获取到每个患者标签拼接的字符串-zhangpp
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> getTagTpStr(String[] entIds) throws BizException {
		Map<String, String> map = new HashMap<String, String>();
		if(EnValidator.isEmpty(entIds)){
			return map;
		}
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
	 * @param entIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PatTagDTO[] getTagTps(String[] entIds) throws BizException{
		StringBuilder sqlBuilder  = new StringBuilder();
		sqlBuilder.append(" SELECT TAGTP.ID_ENT, ");
		sqlBuilder.append(" TP.CODE AS SD_TAGTP, ");
		sqlBuilder.append(" TP.NAME AS NAME_TAGTP, ");
		sqlBuilder.append(" TP.SHORTNAME AS SHORTNAME_TAGTP, ");
		sqlBuilder.append(" TP.COLOR_BACK AS COLOR_BACK, ");
		sqlBuilder.append(" TP.COLOR_FONT AS COLOR_FONT ");
		sqlBuilder.append(" FROM EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_TAGTP TAGTP ON ENT.ID_ENT = TAGTP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN BD_TAG_TP TP ON TAGTP.ID_TAGTP = TP.ID_TAGTP ");
		sqlBuilder.append(" WHERE TP.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND  ISNULL(TAGTP.DT_END, ?) >= ? ");
		sqlBuilder.append(" AND (TP.ID_DEP = ENT.ID_DEP_PHY OR TP.EU_RANG_VIS = 0) ");
		sqlBuilder.append(" AND ((TP.FG_OP = 'Y' AND ENT.CODE_ENTP = '00') OR (TP.FG_IP = 'Y' AND ENT.CODE_ENTP IN ('10','11')) OR (TP.FG_ER = 'Y' AND ENT.CODE_ENTP LIKE '01%'))");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("TAGTP.ID_ENT", entIds));
		sqlBuilder.append(" UNION ");
		sqlBuilder.append(" SELECT ENT.ID_ENT, ");
		sqlBuilder.append(" TP.CODE AS SD_TAGTP, ");
		sqlBuilder.append(" TP.NAME AS NAME_TAGTP, ");
		sqlBuilder.append(" TP.SHORTNAME AS SHORTNAME_TAGTP, ");
		sqlBuilder.append(" TP.COLOR_BACK AS COLOR_BACK, ");
		sqlBuilder.append(" TP.COLOR_FONT AS COLOR_FONT ");
		sqlBuilder.append(" FROM  EN_ENT ENT ");
		sqlBuilder.append(" INNER JOIN PI_PAT_TAG TAG ON ENT.ID_PAT = TAG.ID_PAT ");
		sqlBuilder.append(" INNER JOIN BD_TAG_TP TP ON TAG.ID_PATTAGTP = TP.ID_TAGTP ");
		sqlBuilder.append(" WHERE TP.FG_ACTIVE = 'Y' ");
		sqlBuilder.append(" AND (TP.ID_DEP = ENT.ID_DEP_PHY OR TP.EU_RANG_VIS = 0) ");
		sqlBuilder.append(" AND ((TP.FG_OP = 'Y' AND ENT.CODE_ENTP = '00') OR (TP.FG_IP = 'Y' AND ENT.CODE_ENTP IN ('10','11')) OR (TP.FG_ER = 'Y' AND ENT.CODE_ENTP LIKE '01%') )");
		sqlBuilder.append(" AND " + SqlUtils.getInSqlByIds("ENT.ID_ENT", entIds));
		SqlParam param = new SqlParam();
		FDateTime dateTime = EnAppUtils.getServerDateTime();
		param.addParam(dateTime);
		param.addParam(dateTime);
		List<PatTagDTO> list = (List<PatTagDTO>) new DAFacade().execQuery(sqlBuilder.toString(), param, new BeanListHandler(PatTagDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new PatTagDTO[0]);
	}
	
	/**
	 * 设置患者就诊标签的名称和编码的拼接串
	 * @param dos
	 * @param keyPropName
	 * @param codePropName
	 * @param namePropName
	 * @throws BizException
	 */
	public void essemly(BaseDO[] dos, String keyPropName, String codePropName, String namePropName) throws BizException{
		String[] entIds = EnAppUtils.getKeyPropArrayFromDO(keyPropName, dos);
		if(EnValidator.isEmpty(entIds)){
			return;
		}
		PatTagDTO[] TagTps = getTagTps(entIds);
		if(EnValidator.isEmpty(TagTps)){
			return;
		}
		Map<String, List<BaseDO>> map = EnFMapUtils.getMapList(keyPropName, dos);
		for(PatTagDTO tag : TagTps){
			if(EnValidator.isEmpty(tag.getShortname_tagtp())){
				continue;
			}
			if(map.containsKey(tag.getId_ent())){
				List<BaseDO> list = map.get(tag.getId_ent());
				if(codePropName != null && !ListUtil.isEmpty(list)){
					for (BaseDO value : list) {
						if(value.getAttrVal(codePropName) == null){
							value.setAttrVal(codePropName, tag.getSd_tagtp());
						}else{
							value.setAttrVal(codePropName, value.getAttrVal(codePropName) + "," + tag.getSd_tagtp());
						}
					}
				}
				if(namePropName != null && !ListUtil.isEmpty(list)){
					for (BaseDO value : list) {
						if(value.getAttrVal(namePropName) == null){
							value.setAttrVal(namePropName, tag.getShortname_tagtp());
						}else{
							value.setAttrVal(namePropName, value.getAttrVal(namePropName)  + "," +  tag.getShortname_tagtp());
						}
					}
				}
			}
		}
	}
	
	/***
	 * 此次就诊患者标签是否包含贫困
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	public FBoolean isPoorEnt(String id_ent) throws BizException{
		EnTagTpDO[] tagTps = rservice().findByAttrValString(EnTagTpDO.ID_ENT, id_ent);
		if(tagTps != null && tagTps.length > 0){
			for(EnTagTpDO tagTp : tagTps){
				if(!EnValidator.isEmpty(tagTp.getCode_tagtp()) && CODE_POOR_TAGETP.equals(tagTp.getCode_tagtp())){
					return FBoolean.TRUE;
				}
			}
		}
		return FBoolean.FALSE;
	}
	
	/***
	 * 就诊标签查询服务
	 * @return
	 */
	private IEntagtpRService rservice(){
		return ServiceFinder.find(IEntagtpRService.class);
	}
}
