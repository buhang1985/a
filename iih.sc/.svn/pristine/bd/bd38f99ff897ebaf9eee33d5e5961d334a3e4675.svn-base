package iih.sc.apt.s.bp;

import iih.sc.apt.dto.d.OpAptDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取预约渠道信息
 * 
 * @author yank
 *
 */
public class GetOpAptChlListBP {
	/**
	 * 获取本次就诊外部渠道预约信息
	 * 
	 * @param entIds 就诊ID集合
	 * @return 预约信息集合
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public OpAptDTO[] exec(String[] entIds) throws BizException {
		if (ArrayUtil.isEmpty(entIds)) {
			return null;
		}
		SqlBuildHelper sqlBuilder = new SqlBuildHelper();
		sqlBuilder.append("SELECT APT.ID_APT,APTOP.ID_EN AS ID_ENT,");
		sqlBuilder.append("APT.ID_SCCHL,CHL.NAME AS NAME_SCCHL FROM SC_APT APT ");
		sqlBuilder.append("INNER JOIN SC_APT_OP APTOP ON APT.ID_APT=APTOP.ID_APT ");
		sqlBuilder.append("INNER JOIN SC_CHL CHL ON APT.ID_SCCHL=CHL.ID_SCCHL ");
		sqlBuilder.append("WHERE ");
		sqlBuilder.append("APTOP.ID_EN", entIds);

		List<OpAptDTO> aptList = (List<OpAptDTO>) new DAFacade().execQuery(sqlBuilder.toString(), new BeanListHandler(
				OpAptDTO.class));
		if (ListUtil.isEmpty(aptList)) {
			return null;
		}
		return aptList.toArray(new OpAptDTO[0]);
	}
}
