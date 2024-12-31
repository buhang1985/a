package iih.bd.srv.mrelement.s;


import java.util.List;

import iih.bd.srv.dataspecilchar.d.DataSpecilCharDO;
import iih.bd.srv.mrelement.d.MrElementDO;
import iih.bd.srv.mrelement.i.IBdmrdeService;
import iih.mkr.std.commonde.d.DataElementDO;
import iih.mkr.std.commondeval.d.DataElementValDO;
import iih.mkr.std.dedg.d.DeDataGrpDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 组件自定义服务
 */
@Service(serviceInterfaces={IBdmrdeService.class}, binding=Binding.JSONRPC)
public class BdmrdeServiceImpl implements IBdmrdeService{
	
	public DeDataGrpDO[] getDataGroupList() throws BizException {
   	 String sql= "select id_dg, id_grp, id_org, code, name, des, wbcode, pycode, mnecode, id_parent, innercode, def1, def2, def3, def4, def5, def6, def7, def8, def9, def10,"
   	 		+ "id_applyto_dg, sd_applyto_dg, createdby, createdtime, modifiedby, modifiedtime, ds, sv "
   	 		+ " from bd_dg";
			
			List<DeDataGrpDO> list= (List<DeDataGrpDO>)new DAFacade().execQuery(sql, new BeanListHandler(DeDataGrpDO.class));
			if(list.size()>0) 
				return list.toArray(new DeDataGrpDO[0]);
		    return null;
   }
	public DataElementValDO[] getDataElementValDomain(String idDe) throws BizException {
	 String sql="select a.id_de_val, a.valdomaincode, a.valdomaincodename, a.code, a.name, a.wbcode, a.pycode, a.mnecode, a.des, a.id_grp, a.id_org, a.ds, a.sv, a.valtype, a.ver, a.val "
            +" from bd_de_val a "
            +" where a.valdomaincode in (select valdomaincode from bd_de where id_de='"+idDe+"')";
	        List<DataElementValDO> list= (List<DataElementValDO>)new DAFacade().execQuery(sql, new BeanListHandler(DataElementValDO.class));
	        if(list.size()>0) 
		        return list.toArray(new DataElementValDO[0]);
            return null;
	}
	public DataSpecilCharDO[] getSpecialChar() throws BizException{
	String sql="select id_sc,id_in,name,ds,sv from bd_sc where id_org='"+Context.get().getOrgId()+"'";
	DAFacade df = new DAFacade();
	List<DataSpecilCharDO> result =(List<DataSpecilCharDO>)df.execQuery(sql, new BeanListHandler(DataSpecilCharDO.class));
	if(result == null)
		return null;
	return result.toArray(new DataSpecilCharDO[0]);
	}
	public DataElementDO[] getDataElementList(String idDg) throws BizException{
		String sql="select id_de, id_grp, id_org, id_deca, ver, code, cd_std, name, wbcode, pycode, mnecode, des, id_detp, sd_detp, id_devalsrctp, sd_devalsrctp, devalsrc_sd, devalsrc_cls, "
					+" devalsrc_sql, devaldef, devallen, devalmax, devalmin, devalfmt, fg_null, destdvalmax, destdvalmin, d_pub, def1, def2, def3, def4, def5, def6, fg_active, createdby, "
					+" createdtime, modifiedby, modifiedtime, ds, sv, valtype, valformat, codesystem, codesystemname, allowvalue, valdomaincode, id_valtp, sd_valtp, sd_valtp_national, id_valtp_national" 
					+" from bd_de "
					+" ";
		//if(idDg!="")
		//	sql+=" where id_de in (select id_de from bd_dg_de where id_dg in "+idDg+")";
		sql+=idDg;
		DAFacade df = new DAFacade();
		List<DataElementDO> result =(List<DataElementDO>)df.execQuery(sql, new BeanListHandler(DataElementDO.class));
		if(result == null)
			return null;
		return result.toArray(new DataElementDO[0]);
	}
	@Override
	public String getElementCode() throws BizException {
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
    	String code = iBillcodeManage.getPreBillCode_RequiresNew(MrElementDO.class.getName());
    	return code;
	}
	@Override
	public void rollBackElementCode(String code) throws BizException {
		IBillcodeManage iBillcodeManage = ServiceFinder.find(IBillcodeManage.class);
		iBillcodeManage.rollbackPreBillCode(MrElementDO.class.getName(), code);
	}
}
