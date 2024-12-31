package iih.bd.srv.emrtpl.bp;

import iih.bd.srv.dto.d.PhySignDTO;
import iih.bd.srv.emrtpl.bp.qry.GetPhySignQry;
import iih.bd.srv.emrtpl.bp.qry.GetPreMrtplQry;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * 模板查询BP
 * @author yankan
 *
 */
public class MrtplQueryBP {	
	public MrtplQueryBP(){}
	/**
	 * 获取预检模板
	 * @param depId 部门id
	 * @param mrtpCode 模板类型编码
	 * @return
	 * @throws BizException
	 */
	public EmrTplDO[] getPreMrtpl(String depId, String mrtpCode)
			throws BizException {
		ITransQry qry = new GetPreMrtplQry(depId, mrtpCode);
		EmrTplDO[] rtn = (EmrTplDO[]) AppFwUtil.getDORstWithDao(qry,
				EmrTplDO.class);
		return rtn;
	}
	/**
	 * 获取体征采集项目列表
	 * @param mrtplId 模板id
	 * @return
	 * @throws BizException
	 */
	public PhySignDTO[] getPhySignDTOList(String mrtplId) throws BizException{
		
		ITransQry qry = new GetPhySignQry(mrtplId);
		PhySignDTO[] rtn = (PhySignDTO[]) AppFwUtil.getDORstWithDao(qry,
				PhySignDTO.class);
		return rtn;
	}
}
