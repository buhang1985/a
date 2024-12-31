package iih.mp.nr.common;

import java.util.List;

import iih.mp.nr.dto.wardprint.d.ParamQryDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询参数信息
 */
public class ParamQueryUtils {

	public ParamQueryUtils() {

	}

	@SuppressWarnings("unchecked")
	public static ParamQryDTO[] paramsqry(String id_org, String paramcode) {

		String sql = "select id_org, paramcode as param_code , value as param_value from sys_paramset where paramcode='" + paramcode + "' and id_org='" + id_org + "'";
		try {
			List<ParamQryDTO> list = (List<ParamQryDTO>) new DAFacade().execQuery(sql, null, new BeanListHandler(ParamQryDTO.class));
			return list.toArray(new ParamQryDTO[0]);
		} catch (DAException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
