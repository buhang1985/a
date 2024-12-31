package iih.bl.cg.bp.ip;


import iih.bl.cg.bp.ip.qry.GetIpCgListBySrvSumQry;
import iih.bl.cg.dto.d.BlIpCgDTO;
import iih.bl.cg.dto.d.BlIpCgSrvSumDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 
 * @author liwq
 * @since 2018年1月26日17:49:32
 */
public class GetIpCgListBySrvSumBP {
	/**
	 * 查询住院记账集合
	 * 
	 * @param entId 就诊id
	 * @param srvId 服务id
	 * @param qryNode 查询模板
	 * @return 住院记账信息集合
	 * @throws BizException
	 */
	public BlIpCgDTO[] exec(String entId, BlIpCgSrvSumDTO inIpCgSrvSumDto, QryRootNodeDTO qryNode) throws BizException{
		
    	BlIpCgDTO[] blIpCgDTOs = (BlIpCgDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpCgListBySrvSumQry(entId,inIpCgSrvSumDto,qryNode), BlIpCgDTO.class);
		return blIpCgDTOs;
	}
}
