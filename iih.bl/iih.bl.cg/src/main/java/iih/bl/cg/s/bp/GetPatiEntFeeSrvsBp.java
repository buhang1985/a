package iih.bl.cg.s.bp;

import iih.bl.cg.dto.d.NurseCompFeeItmDTO;
import iih.bl.params.BlParams;

import java.util.List;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者已记账的收费项目(只获取name_srv和id_srv)
 * @param entId
 * @param condition 名称拼音过滤条件
 * @return NurseCompFeeItmDTO
 * @author liwq
 * @since 2018年3月28日8:50:07
 * @throws BizException
 */
public class GetPatiEntFeeSrvsBp {

	public NurseCompFeeItmDTO[] exec (String entId, String condition) throws BizException {
		
		if(StringUtils.isEmptyWithTrim(entId))  {
			throw new BizException("查询患者已记账收费项目时，就诊id不能为空！");
		}
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(" select distinct cg.id_ent, cg.id_srv, cg.name_srv from bl_cg_ip cg left join bd_srv srv on cg.id_srv = srv.id_srv ");
		sqlStr.append(" where (cg.name_srv like '%").append(condition).append("%' or srv.pycode like '%").append(condition.toUpperCase()).append("%' ) ");
		SqlParam param = new SqlParam();
		FBoolean isMerge = BlParams.BLSTIP0005();
		if (FBoolean.TRUE.equals(isMerge)) {
			sqlStr.append(" and (id_ent = ? ").append(" or id_ent_mom = ? ) ");
			param.addParam(entId);
			param.addParam(entId);
		} else {
			sqlStr.append(" and (id_ent = ? ) ");
			param.addParam(entId);
		}
		//参数是否配置
		sqlStr.append(" and id_dep_mp='").append(Context.get().getDeptId()).append("'");
		DAFacade df = new DAFacade();
		List<NurseCompFeeItmDTO> srvList = (List<NurseCompFeeItmDTO>)df.execQuery(sqlStr.toString(), param, new BeanListHandler(NurseCompFeeItmDTO.class));
		if(ListUtil.isEmpty(srvList))
			return null;
		
		return srvList.toArray(new NurseCompFeeItmDTO[]{});
	}
}
