package iih.bl.hp.s.bp;

import java.util.List;

import iih.bl.hp.dto.d.BlOutDetailedDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetUploadDetailedDataOutBP {

	public BlOutDetailedDataDTO exec(String entId)throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空!");
		}
		
		BlOutDetailedDataDTO data = this.getEntAmtPat(entId);
		data.setId_ent(entId);
		
		return data;
	}
	/**
	 * 
	 * @Title: getEntAmtPat   
	 * @Description: 总金额、条数
	 * @return: FDouble
	 * @author: xy.zhou      
	 * @throws
	 */
	private BlOutDetailedDataDTO getEntAmtPat(String entId)throws BizException{
		StringBuilder  sql=new StringBuilder();
		SqlParam param=new SqlParam();


		sql.append(" select  NVL(SUM(AMT_RATIO*EU_DIRECT),0) AS AMT_TOTAL,NVL(COUNT(*),0) AS DETAILEDNUMS  from bl_cg_ip ");
		sql.append(" where id_ent=?");
		sql.append(" and fg_hp='Y' ");
		sql.append(" and fg_st='N' ");
		param.addParam(entId);

		@SuppressWarnings("unchecked")
		List<BlOutDetailedDataDTO> dataList = (List<BlOutDetailedDataDTO>) new DAFacade().execQuery(sql.toString(), param,new BeanListHandler(BlOutDetailedDataDTO.class));
		if(ListUtil.isEmpty(dataList)){
			throw new BizException("查询失败！未获取到数据库返回结果");
		}
		return dataList.get(0);
	}
}
