package iih.ci.ord.s.external.bp;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.ci.ord.s.external.bp.qry.GetOrdDrugInfo4BlDTOsQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 查询药品开单信息
 * @author Young
 *
 */
public class GetOrdDrugInfo4BlDTOsBP {

	public OrdDrugInfo4BlDTO[] exec(String id_ent, String[] id_ors, String[] id_orsrvs,FBoolean fg_cancel, String... params) throws BizException {
		if (StringUtils.isNullOrEmpty(id_ent) && id_ors == null && id_orsrvs == null)
			return null;
		ITransQry qry = new GetOrdDrugInfo4BlDTOsQry(id_ent, id_ors, id_orsrvs,fg_cancel, params);
		return (OrdDrugInfo4BlDTO[])AppFwUtil.getDORstWithDao(qry, OrdDrugInfo4BlDTO.class);
	}
}
