package iih.bd.pp.service.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获得票据信息
 * @author tcy
 *
 */
public class GetInccaInfoBp {
	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * @param code_enttp 就诊类型代码
	 * @param id_srv 服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	public IncCaItmDO getInccaitmCodeAndName(String code_enttp,String id_srv) throws  BizException
	{
		StringBuffer sql=new StringBuffer();
		sql.append("select b.code,b.name ");
		sql.append("  from bd_incca a");
		sql.append(" inner join bd_incca_itm b");
		sql.append("    on a.id_incca = b.id_incca");
		sql.append(" inner join bd_incca_itm_rel c");
		sql.append("    on b.id_inccaitm = c.id_inccaitm");
		sql.append("   and a.code = ?");
		sql.append("   and id_srv = ?");
		sql.append("   and a.ds = '0'");
		sql.append("   and b.ds = '0'");
		SqlParam sqlp=new SqlParam();
		if (code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
				|| code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
				|| code_enttp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) 
		{
			sqlp.addParam(IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE); //门诊发票
		}
		else
		{
			sqlp.addParam(IBdPpCodeTypeConst.SD_INHOS_INVOICE);//住院发票
		}
		sqlp.addParam(id_srv);
		DAFacade dafacade=new DAFacade();
		List<IncCaItmDO> incCaItmDOLst=(List<IncCaItmDO>)dafacade.execQuery(sql.toString(), sqlp,new BeanListHandler(IncCaItmDO.class));
		if(incCaItmDOLst!=null && incCaItmDOLst.size()>0)
		{
			return incCaItmDOLst.toArray(new IncCaItmDO[0])[0];
		}
		else
		{
			return null;
		}
	}

}
