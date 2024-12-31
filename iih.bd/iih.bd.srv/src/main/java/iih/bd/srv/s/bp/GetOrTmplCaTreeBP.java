package iih.bd.srv.s.bp;

import iih.bd.srv.ortmplquerydto.d.OrTmplQueryDTO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.bd.srv.s.bp.qry.GetOrTmplCaTreeByEntpQry;
import iih.bd.srv.s.bp.qry.GetOrTmplCaTreeQry;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取医嘱模板分类树数据BP
 */
public class GetOrTmplCaTreeBP {

	/**
	 * 获取 医嘱模板分类
	 * 
	 * @param emrTermCa
	 */
	public OrTmplDTO[] exec(String code_entp, String id_grp,String id_org,String id_srvorrt,String id_dep,String id_emp,String id_ortmplca, FBoolean bFgactive) throws BizException {

		if (StringUtils.isBlank(id_grp) || StringUtils.isBlank(id_org)) {
			return new OrTmplDTO[0];
		}
		GetOrTmplCaTreeQry qry = new GetOrTmplCaTreeQry(code_entp, id_grp, id_org, id_srvorrt, id_dep, id_emp, id_ortmplca, bFgactive);
		OrTmplDTO[] rtn = (OrTmplDTO[]) AppFwUtil.getDORstWithDao(qry, OrTmplDTO.class);
		return rtn;
	}
	
	/**
	 * 查询模板
	 * @param querydto
	 * @return
	 * @throws BizException
	 */
	public OrTmplDTO[] exec(OrTmplQueryDTO querydto) throws BizException {
		if (StringUtils.isBlank(querydto.getId_grp()) || StringUtils.isBlank(querydto.getId_org()) 
				|| StringUtils.isBlank(querydto.getId_srvorrt())) {
			return new OrTmplDTO[0];
		}
		GetOrTmplCaTreeByEntpQry qry = new GetOrTmplCaTreeByEntpQry(querydto);
		OrTmplDTO[] rtn = (OrTmplDTO[]) AppFwUtil.getDORstWithDao(qry, OrTmplDTO.class);
		return rtn;
	}
}
