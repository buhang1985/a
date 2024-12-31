package iih.bd.pp.hp.bp;

import java.util.List;

import iih.bd.pp.mpayratiodf.d.MPayRatioDfDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取服务的多支付比例集合
 * @author yankan
 *
 */
public class GetSrvPayRatioListBP {
	/**
	 * 获取服务的多支付比例集合
	 * @param hpId 医保计划ID
	 * @param srvId 服务ID或物品ID
	 * @param isMm 是否物品
	 * @throws BizException
	 * @author yankan
	 */
	public MPayRatioDfDO[] exec(String hpId,String srvId,FBoolean isMm) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT RATIO.ID_HPMPAYRATIODF,RATIO.ID_HP,RATIO.CODE,RATIO.NAME,RATIO.NOTE"); 
		sqlBuilder.append(" FROM BD_HP_SRV_MPAYRATIO SRVRATIO");
		sqlBuilder.append(" INNER JOIN BD_HP_MPAYRATIODF RATIO ON RATIO.ID_HPMPAYRATIODF = SRVRATIO.ID_HPMPAYRATIODF");
		sqlBuilder.append(" WHERE SRVRATIO.ID_HP=? ");
		
		SqlParam param = new SqlParam();
		param.addParam(hpId);		
		if(FBoolean.TRUE.equals(isMm)){
			sqlBuilder.append(" AND SRVRATIO.ID_MM=?");
			param.addParam(srvId);
		}else{
			sqlBuilder.append(" AND SRVRATIO.ID_SRV=?");
			param.addParam(srvId);
		}
		
		List<MPayRatioDfDO> ratioList = (List<MPayRatioDfDO>) new DAFacade().execQuery(sqlBuilder.toString(), param,new BeanListHandler(MPayRatioDfDO.class));
		if(!ListUtil.isEmpty(ratioList)){
			return ratioList.toArray(new MPayRatioDfDO[0]);
		}
		return null;
	}
}
