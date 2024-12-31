package iih.bd.srv.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.s.bp.qry.GetModuleInfoBPSql;
import xap.dp.dmengine.d.EnumValueDO;
import xap.dp.dmengine.d.PropertyDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetModuleInfoBP {

	public PropertyDO[] execQuerypropertyDO(String classId) throws BizException{
		
		GetModuleInfoBPSql modulSql = new GetModuleInfoBPSql();
		String sql = modulSql.getPropertySql();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(classId);
		
		List<PropertyDO> propertyDO = (ArrayList<PropertyDO>)new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(PropertyDO.class));
		return propertyDO.toArray(new PropertyDO[0]);
	} 
	
	public EnumValueDO[] execQueryEnumValueDO(String classId) throws BizException{
		
		GetModuleInfoBPSql modulSql = new GetModuleInfoBPSql();
		String sql = modulSql.getEnumValueDOSql();
		
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(classId);
		
		List<EnumValueDO> propertyDO = (ArrayList<EnumValueDO>)new DAFacade().execQuery(sql, sqlParam, new BeanListHandler(EnumValueDO.class));
		return propertyDO.toArray(new EnumValueDO[0]);
	} 
}
