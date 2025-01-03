package iih.ci.ord.s.external.provide.bp.bl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 根据就诊id查询当前就诊下 未作废 未退费 非药品 的ciorsrv的费用项 的特殊病标识是否有为true的
 * @author yzh
 * @param iden
 * @return
 */
public class CheckSpecialOrderBP {

	public FBoolean exec(String iden) throws BizException {
		if(StringUtils.isEmpty(iden)){//传参校验
			return FBoolean.FALSE;
		}
		DAFacade dafacade = new DAFacade();
		String sql = getSql();
		SqlParam param=new SqlParam();
		param.addParam(ICiDictCodeConst.SD_SU_BL_REFOUND);
		param.addParam(iden);
		List<String> list = (List<String>) dafacade.execQuery(sql, param,new ColumnListHandler());
		FBoolean check_result = FBoolean.FALSE;		
		if(!CiOrdUtils.isEmpty(list)){
			for (String str : list) {
				if(FBoolean.TRUE.equals(new FBoolean(str))){
					check_result = FBoolean.TRUE;
				}
			}
		}
		return check_result;
	}
	
	private String getSql(){
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select fg_specill from ci_or_srv where id_or in")
		.append(" (select id_or from ci_order where fg_canc = 'N' and sd_su_bl !=?")
		.append(" and sd_srvtp not like '01%' and id_en =?)")
		.append(" and fg_bl='Y'");
		return sqlb.toString();
	}
}
