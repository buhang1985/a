package iih.sc.sch.s.bp;

import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import iih.sc.apt.i.IScAptQryService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDO;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.d.ScdeptparamAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预约检查BP：校验当前日期是否超过午别时间
 * 
 * @author yzh
 * @date 2019年3月6日 09:25:17
 *
 */
public class AptCheckPatHpEnBP {

	/**
	 * 预约检查BP：校验当前日期是否超过午别时间
	 * @param id_scca
	 * @param id_dep_mp
	 * @param sd_sctp
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String id_ent) throws BizException {
		// 检查参数 就诊id为空默认非医保患者
		if (StringUtil.isEmpty(id_ent)) {
			return FBoolean.FALSE;
		}
		int count = this.execSql(id_ent);
		if(count > 0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
	
	/**
	 * 获取查询sql
	 * @return
	 */
	private String getSql(){
		StringBuffer sqlQry = new StringBuffer();
		sqlQry.append(" select count(1)")
		.append(" from en_ent en")
		.append(" inner join en_ent_hp enthp on en.id_ent = enthp.id_ent")
		.append(" inner join bd_hp hp on enthp.id_hp = hp.id_hp")
		.append(" where")
		.append("  hp.sd_hptp like '1%' and enthp.fg_fundpay = 'Y'")
		.append(" and en.id_ent = ?");
		return sqlQry.toString();
	}
	/**
	 * sql 执行
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private int  execSql(String id_ent) throws BizException{
		String sql = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		DAFacade dafacade = new DAFacade();
		List<Integer> list = (List<Integer>) dafacade.execQuery(sql,param, new ColumnListHandler());
		int count = list.get(0);
		return count;
	}
}
