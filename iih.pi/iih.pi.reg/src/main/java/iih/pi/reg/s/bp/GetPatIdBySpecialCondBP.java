package iih.pi.reg.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.ColumnListHandler;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.reg.s.bp.qry.PiGetPatIdBySpecialCondFuzzyQry;
import iih.pi.reg.s.bp.qry.PiGetPatIdBySpecialCondQry;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过特定条件查询患者id
 * @author ly
 *
 */
public class GetPatIdBySpecialCondBP {

	//类型范围
	private final String[] TYPES = new String[] {
			IPiDictCodeConst.PAT_CONDITION_TYPE_AUTO,
			IPiDictCodeConst.PAT_CONDITION_TYPE_PATCODE,
			IPiDictCodeConst.PAT_CONDITION_TYPE_CARDCODE,
			IPiDictCodeConst.PAT_CONDITION_TYPE_IDCODE,
			IPiDictCodeConst.PAT_CONDITION_TYPE_BEDNO };
	
	/**
	 * 通过特定条件查询患者ID
	 * @param condType 条件类型
	 * @param condValue 条件值
	 * @return 患者id
	 * @throws BizException 条件类型不在值范围内  code:1
	 * 						未查询到对应患者 code:2
	 */
	public String[] exec(String condType,String condValue,Boolean isFuzzy) throws BizException{
		
		if(!this.validate(condType, condValue))
			return null;
		
		this.logicValidate(condType);
		
		List<String> list = new ArrayList<String>();
		
		//模糊查询
		if(isFuzzy){
			List<String> patIds = this.getPatIds(condType, condValue);
			if(ListUtil.isEmpty(patIds)){
				throw new BizException("未查询到对应患者",2);
			}
			
			list.addAll(patIds);
		}
		else{
			//取得患者id
			String patId = this.getPatId(condType, condValue);
			if(StringUtil.isEmpty(patId)){
				throw new BizException("未查询到对应患者",2);
			}
			
			list.add(patId);
		}
		
		return list.toArray(new String[list.size()]);
	}
	
	/**
	 * 取得查询sql
	 * @param condType
	 * @param condValue
	 * @param isFuzzy
	 * @return
	 * @throws BizException
	 */
	public String getSql(String condType,String condValue,Boolean isFuzzy) throws BizException{
		
		if(!this.validate(condType, condValue))
			return null;
		
		this.logicValidate(condType);
		
		String sql = "";
		
		//模糊查询
		if(isFuzzy){
			PiGetPatIdBySpecialCondFuzzyQry qry = new PiGetPatIdBySpecialCondFuzzyQry(condType,condValue);
			sql = this.getSql(qry);
		}else{
			PiGetPatIdBySpecialCondQry qry = new PiGetPatIdBySpecialCondQry(condType,condValue);
			sql = this.getSql(qry);
		}
		
		return sql;
	}
	
	/**
	 * 简单校验
	 * @param condType
	 * @param condValue
	 * @return
	 */
	private boolean validate(String condType,String condValue){
		
		if(StringUtil.isEmpty(condType) || StringUtil.isEmpty(condValue)){
			return false;
		}
		
		return true;
	}
	
	/**
	 * 逻辑校验
	 * @param condType
	 */
	private void logicValidate(String condType) throws BizException{
		
		boolean contain = false;
		for (String str : TYPES) {
			if(str.equals(condType)){
				contain = true;
				break;
			}
		}
		
		if(!contain){
			throw new BizException("条件类型不在值范围内",1);
		}
	}

	/**
	 * 通过查询获取患者id
	 * @param condType
	 * @param condValue
	 * @return
	 * @throws BizException
	 */
	private String getPatId(String condType,String condValue) throws BizException{
		
		PiGetPatIdBySpecialCondQry qry = new PiGetPatIdBySpecialCondQry(condType,condValue);
		String mySql = qry.getQrySQLStr();
		StringBuffer sqlSb = new StringBuffer();
		SqlParam para = qry.getQryParameter(sqlSb);
		mySql += sqlSb.toString();
		
		String patId = (String)new DAFacade().execQuery(mySql, para, new ColumnHandler());
		
		return patId;
	}
	
	/**
	 * 通过模糊查询获取患者id列表
	 * @param condType
	 * @param condValue
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<String> getPatIds(String condType,String condValue) throws BizException{
	
		PiGetPatIdBySpecialCondFuzzyQry qry = new PiGetPatIdBySpecialCondFuzzyQry(condType,condValue);
		String mySql = qry.getQrySQLStr();
		StringBuffer sqlSb = new StringBuffer();
		SqlParam para = qry.getQryParameter(sqlSb);
		mySql += sqlSb.toString();
		
		List<String> patIds = (List<String>)new DAFacade().execQuery(mySql, para, new ColumnListHandler<String>());
		
		return patIds;
	}
	
	/**
	 * 通过查询类获取sql
	 * @param qry
	 * @return
	 */
	private String getSql(ITransQry qry){
		
		String mySql = qry.getQrySQLStr();
		StringBuffer sqlSb = new StringBuffer();
		SqlParam para = qry.getQryParameter(sqlSb);
		mySql += sqlSb.toString();
		
		mySql = mySql.replace("?", "'" + para.get(0).toString() + "'");
		
		return mySql;
	}
}
