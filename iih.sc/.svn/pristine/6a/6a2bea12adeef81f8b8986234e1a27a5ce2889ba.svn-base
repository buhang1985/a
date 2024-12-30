package iih.sc.sch.s.bp;

import java.util.List;

import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 批量获取排班服务关联服务集合
 * @author yank
 *
 */
public class BatchGetRelSrvListBP {
	/**
	 * 获取排班服务关联服务集合
	 * @param scSrvIds 排班服务id数组
	 * @return
	 * @throws BizException
	 */
	public RelSrvDTO[] exec(String[] scSrvIds) throws BizException{
		if(ArrayUtil.isEmpty(scSrvIds))return null;
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT REL.ID_SCSRV,REL.ID_MDSRV ID_SRV,SRV.NAME NAME_SRV,REL.FG_MAJ,SRV.ID_SRVTP,SRV.SD_SRVTP ");
		builder.append(" FROM SC_SRV_REL REL ");
		builder.append(" INNER JOIN BD_SRV SRV ON REL.ID_MDSRV = SRV.ID_SRV");		
		String ids = ScSqlUtils.arrayToStr(scSrvIds);	
		builder.append(" WHERE ID_SCSRV IN (").append(ids).append(")");
		
		List<RelSrvDTO> relSrvList =(List<RelSrvDTO>) new DAFacade().execQuery(builder.toString(), 
				new BeanListHandler(RelSrvDTO.class));
		
		return relSrvList==null ? null : relSrvList.toArray(new RelSrvDTO[0]);
	}
}
