package iih.en.pv.out.bp.qry;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取母婴就诊数据接口
 * 
 * @param entIds
 * @return
 * @throws BizException
 * @author lb
 * @version ly 2018/10/09 添加母亲就诊id空判断
 */
public class GetMomBabyInfosBP {
	/**
	 * 获取母婴就诊数据接口
	 * 
	 * @param entIds
	 * @return
	 * @throws BizException
	 * @author lb
	 */
	public EnMomBabyInfoDTO[] exec(String[] entIds)
			throws BizException {
		if(EnValidator.isEmpty(entIds))
			return null;
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT NB.ID_ENT_BB,NB.ID_ENT_MOM, NB.NO_BB ");
		builder.append(" FROM EN_ENT_NB NB ");
		builder.append(" WHERE (" + EnSqlUtils.getInSqlByIds("NB.ID_ENT_BB", entIds));
		builder.append(" OR " + EnSqlUtils.getInSqlByIds("NB.ID_ENT_MOM", entIds) + ")");
		builder.append(" AND NVL(NB.ID_ENT_MOM,'~') <> '~' ");
		
		List<EnMomBabyInfoDTO> list = (List<EnMomBabyInfoDTO>) new DAFacade().execQuery(builder.toString(), new BeanListHandler(EnMomBabyInfoDTO.class));
		return EnValidator.isEmpty(list) ? null : list.toArray(new EnMomBabyInfoDTO[0]);
	}
}
