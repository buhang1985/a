package iih.sc.apt.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.s.event.MakeOptAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 预约 修改后给 预约确认发事件
 * @author Administrator
 *
 */
public class SendChangeOptApt4OrBP {
	
	/**
	 * 预约 修改后给 预约确认发事件
	 * @param aptList
	 * @throws BizException 
	 */
	public void exec(String aptList) throws BizException
	{
		if (StringUtil.isEmpty(aptList)) {
			return ;
		}
		StringBuilder sql = new StringBuilder();
		sql.append(" select appl.id_or,");
		sql.append(" apt.dt_b,");
		sql.append(" apt.queno,");
		sql.append(" res.id_opt ");
		sql.append(" from sc_apt apt");
		sql.append(" inner join sc_apt_appl appl on appl.id_scapt = apt.id_apt");
		sql.append(" inner join sc_res res on res.id_scres = apt.id_scres");
		sql.append(" where apt.id_apt in (" + aptList + ")");
		List<OptApt4OrmDTO> list = (List<OptApt4OrmDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(
				OptApt4OrmDTO.class));
		new MakeOptAptEvent().invoke(list);
	}
	
	/**
	 * 拼接预约id串
	 * @param aptList
	 * @return
	 */
	public String buildIdStr(List<ScAptDO> aptList) {
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (ScAptDO aptDO : aptList) {
			//术前确认 才拼接预约id 发送事件使用 
			if(aptDO.getSd_status() != IScDictCodeConst.SD_APTSTATUS_BEF_CONF)
			{
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("'%s'", aptDO.getId_apt()));
		}
		return builder.toString();
	}

}
