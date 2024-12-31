package iih.bl.cg.s.provide.mbh;

import java.util.List;

import iih.bl.cg.dto.d.DayIpCgInfoDTO;
import iih.bl.params.BlParams;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 供移动护理，获取住院每日记账金额之和
 * @author liwq
 * @param id_ent
 * @return
 * @throws BizException
 * @since 2018年4月1日15:04:06
 */
public class GetIpDayAmtCgsBp {

	public DayIpCgInfoDTO[] exec (String id_ent) throws BizException {

		if(StringUtils.isEmptyWithTrim(id_ent)) {
			throw new BizException("查询患者每日记账金额时，患者的就诊id不能为空！");
		}		
		
		StringBuilder sb = new StringBuilder();
		sb.append(" select sum(amt_std) as amt_std,sum(amt_ratio) as amt_ratio, substr(dt_cg,0,10) as dt_cg from bl_cg_ip where 1=1 ");
		
		FBoolean isMerge = BlParams.BLSTIP0005();
		if(FBoolean.TRUE.equals(isMerge)) {
			sb.append(" and (id_ent = '").append(id_ent).append("' or ID_ENT_mom = '").append(id_ent).append("') ");			
		} else {
			sb.append(" and (id_ent = '").append(id_ent).append("') ");
		}
		
		sb.append(" group by substr(dt_cg,0,10)  order by substr(dt_cg,0,10) desc ");
		
		BeanListHandler beanlist_handler = new BeanListHandler(DayIpCgInfoDTO.class);
		List<DayIpCgInfoDTO> result = (List<DayIpCgInfoDTO>)new DAFacade().execQuery(sb.toString(), beanlist_handler);
		if(result != null && !result.isEmpty()) {
			return result.toArray(new DayIpCgInfoDTO[]{});
		} else {
			return new DayIpCgInfoDTO[]{};
		}
	}
}
