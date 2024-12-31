package iih.bl.hp.Service.s.Bp;

import iih.bd.res.params.BdResParams;
import iih.bl.hp.viewmziihypshare.d.ViewMzIihYpShareDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Logger;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * CHIS中获取药品数据
 * @author ly 2017/05/12
 *
 */
public abstract class GetMzYpDataFromChisViewBp {
	
	/**
	 * 获取患者在CHIS中开的药品
	 * 
	 * @param patId 患者编码
	 * @return
	 * @throws BizException
	 */

	@SuppressWarnings("unchecked")
	protected ViewMzIihYpShareDTO[] getEBSBatchDTOs(String patId) throws BizException {
		
		//获取数据源名称
		String sourceName = new BdResParams().CHISDB();
		if(StringUtil.isEmpty(sourceName)){
			//throw new BizException(this.getClass().getName() + ":CHIS数据源未定义");
			return null;
		}
		
		List<ViewMzIihYpShareDTO> list = null;
		try {
			DAFacade daf = new DAFacade(sourceName);
			
			String sql = "select view_mz_iih_yp_share.*,'1' sys_src from view_mz_iih_yp_share where patient_id = ? ";
			SqlParam param = new SqlParam();
			param.addParam(patId);
			
			list = (List<ViewMzIihYpShareDTO>)daf.execQuery(
					sql, param,new BeanListHandler(ViewMzIihYpShareDTO.class));
		} catch (Exception e) {
			Logger.error(e.getMessage(),e);
			//不抛出异常
		}
		
		if(list == null)
			return null;
		
		return list.toArray(new ViewMzIihYpShareDTO[0]);
	}
}
