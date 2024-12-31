package iih.ci.ord.s.external.bp;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.i.external.provide.meta.bl.OrdOperInfo4BlDTO;
import iih.ci.ord.s.external.bp.qry.GetOrdOperInfo4BlDTOsQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 查询药品开单信息
 * @author Young
 *
 */
public class GetOrdOperInfo4BlDTOsBP {
	public OrdOperInfo4BlDTO[] exec(String id_ent, String[] id_ors, String... params) throws BizException {
		if (StringUtils.isNullOrEmpty(id_ent) && id_ors == null)
			return null;
		ITransQry qry = new GetOrdOperInfo4BlDTOsQry(id_ent, id_ors, params);
		return (OrdOperInfo4BlDTO[])AppFwUtil.getDORstWithDao(qry, OrdOperInfo4BlDTO.class);
	}
}
