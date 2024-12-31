package iih.bl.cg.service.s.bp;

import iih.bl.cg.d.BlIpFeeDTO;
import iih.bl.params.BlParams;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

public class BlIpFeeBp {
	public BlIpFeeDTO[] exec(String id_ent, String condition) throws BizException{
		if (StringUtils.isEmptyWithTrim(id_ent)) {
			throw new BizException("查询患者住院退费项目时，就诊id不能为空！");
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select distinct cg.id_ent, cg.id_srv, cg.name_srv, bm.name as srvu_name from bl_cg_ip cg inner join BD_MEASDOC bm on cg.srvu = bm.id_measdoc left join bd_srv srv on cg.id_srv = srv.id_srv ");
		sql.append(" where cg.fg_st='N' and (cg.name_srv like '%").append(condition).append("%' or srv.pycode like '%").append(condition.toUpperCase()).append("%' ) ");
		SqlParam sqlParam = new SqlParam();
		//判断是否是新生婴儿
		FBoolean isMerge = BlParams.BLSTIP0005();
		if (FBoolean.TRUE.equals(isMerge)) {
			sql.append(" and (id_ent = ? ").append(" or id_ent_mom = ? ) ");
			sqlParam.addParam(id_ent);
			sqlParam.addParam(id_ent);
		}else{
			sql.append(" and (id_ent = ? ) ");
			sqlParam.addParam(id_ent);
		}
		DAFacade df = new DAFacade();
		List<BlIpFeeDTO> list = (List<BlIpFeeDTO>)df.execQuery(sql.toString(), sqlParam, new BeanListHandler<>(BlIpFeeDTO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.toArray(new BlIpFeeDTO[]{});
	}
}
