package iih.ci.mrm.s.mrmcatalog.bp;

import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrm.dto.mrmcatalog.d.MrmCatalogCheckResultDTO;

/**
 * 扼要说明
 * @author 张静波
 * @date 2018年9月5日 下午3:30:38
 */
public class MrmCatalogMainCheckDataBP {

	/**
	 * 核查编目数据
	 * @param sqlFixWhere 固定约束条件。
	 * @return
	 * @throws BizException
	 */
	public MrmCatalogCheckResultDTO[] checkCatalongData(String sqlFixWhere) throws BizException
	{
		
		MrmCatalogCheckResultDTO[] arrRules = getVerifyRules4MrmCata();
		if(arrRules!=null && arrRules.length>0)
		{
			DAFacade da = new DAFacade();
			
			for(MrmCatalogCheckResultDTO rule :arrRules)
			{
				String sql = "select count("+rule.getFieldname()+") as errorcount from "+rule.getTabname()+" and "+sqlFixWhere; 
				ArrayList<MrmCatalogCheckResultDTO> listRes = (ArrayList<MrmCatalogCheckResultDTO>)da.execQuery(sql, new BeanListHandler(MrmCatalogCheckResultDTO.class) );
				rule.setErrorcount(listRes.get(0).getErrorcount());
			}
		}
		//根据类型区分使用，目前按照sql处理
		return arrRules;
	}
	/**
	 * 获取病案编目核查规则
	 * @return
	 * @throws DAException
	 */
	private   MrmCatalogCheckResultDTO[] getVerifyRules4MrmCata() throws DAException
	{
		DAFacade da = new DAFacade();
		String sql = "select * from MR_CATALOG_VERIFY_RULES where code_range_apply ='"+ICiMrDictCodeConst.SD_AUDITSCOPE_CATALOGUE+"' and DS ='0'";
		
		//获取规则
		ArrayList<MrmCatalogCheckResultDTO> lstRule =  (ArrayList<MrmCatalogCheckResultDTO>)da.execQuery(sql.toString(), new BeanListHandler(MrmCatalogCheckResultDTO.class));
		if(lstRule!=null&&lstRule.size()>0)
		{
			MrmCatalogCheckResultDTO[] arrRule = new MrmCatalogCheckResultDTO[lstRule.size()];
			return lstRule.toArray(arrRule);
		}
		else
		{
			return new MrmCatalogCheckResultDTO[] {};
		}
	}
}
