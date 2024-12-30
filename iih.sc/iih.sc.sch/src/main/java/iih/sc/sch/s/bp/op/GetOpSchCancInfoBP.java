package iih.sc.sch.s.bp.op;

import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.SchCancDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.scsch.d.ScSchDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取排班停诊排班信息BP
 * 
 * @author zhengcm
 * @date 2017-11-16 19:36:47
 *
 */
public class GetOpSchCancInfoBP {

	/**
	 * 获取排班停诊排班信息
	 * 
	 * @author zhengcm
	 * @date 2017-11-16 19:37:02
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	public SchCancDTO exec(String id_sch) throws BizException {
		ScValidator.validateParam("id_sch", id_sch);
		ScSchDO schDO = new SchEP().getById(id_sch);
		if (null == schDO) {
			throw new BizException("没有获取到对应的排班数据！");
		}
		return this.queryData(id_sch);
	}

	/**
	 * 查询数据
	 * 
	 * @author zhengcm
	 * @date 2017-11-16 19:49:11
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private SchCancDTO queryData(String id_sch) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.fg_active,");
		sb.append("pl.name as name_scpl,");
		sb.append("lot.name as name_dayslot ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("inner join sc_pl pl on pl.id_scpl = sch.id_scpl ");
		sb.append("inner join bd_dayslot lot on lot.id_dayslot = sch.id_dayslot ");
		sb.append("where ");
		sb.append("sch.id_sch = ? ");
		SqlParam params = new SqlParam();
		params.addParam(id_sch);
		List<SchCancDTO> list = (List<SchCancDTO>) new DAFacade().execQuery(sb.toString(), params, new BeanListHandler(
				SchCancDTO.class));
		if (!ListUtil.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
}
