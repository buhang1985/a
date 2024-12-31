package iih.ci.ord.s.external.bp;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.i.external.provide.meta.bl.EnDiInfo4BlDTO;
import iih.ci.ord.s.external.bp.qry.GetEnDiInfo4BlDTOsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 查询就诊有效诊断
 * @author Young
 *
 */
public class GetEnDiInfo4BlDTOsBP {

	public EnDiInfo4BlDTO[] exec(String id_ent, String... params) throws BizException {
		//根据就诊主键查询本次就诊的已签署未作废的诊断明细信息
		if (StringUtils.isNullOrEmpty(id_ent))
			return null;
		ITransQry qry = new GetEnDiInfo4BlDTOsQry(id_ent, params);
		return (EnDiInfo4BlDTO[]) AppFwUtil.getDORstWithDao(qry, EnDiInfo4BlDTO.class);
	}
}
