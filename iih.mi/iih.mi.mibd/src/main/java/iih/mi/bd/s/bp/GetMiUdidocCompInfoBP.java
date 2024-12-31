package iih.mi.bd.s.bp;

import java.util.List;

import iih.mi.bd.miudidoccomp.d.MiUdidocCompDO;
import iih.mi.bd.miudidoclist.d.MiUdidoclistDO;
import iih.mi.bd.miudidoclist.i.IMiudidoclistRService;
import iih.mi.bd.miudidocuse.d.MiUdidoclistUseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 查询医保档案对照信息
 * @author wq.li
 *
 */
public class GetMiUdidocCompInfoBP {

	public MiUdidocCompDO[] exec(MiUdidoclistUseDO useDo) throws BizException{
		
		if(useDo==null){
			return null;
		}
		
		//查询档案类型信息
		IMiudidoclistRService listRService=ServiceFinder.find(IMiudidoclistRService.class);
		MiUdidoclistDO listDo=listRService.findById(useDo.getId_miudidoclist());
		
		
		if(listDo==null){
			throw new BizException("医保档案类型不存在");
		}
		
		if(StringUtil.isEmpty(listDo.getComp_tablename())){
			throw new BizException("医保档案类型的对照对照表名不能为空");
		}
		
		if(StringUtil.isEmpty(listDo.getComp_codecolumn())){
			throw new BizException("医保档案类型的对照编码不能为空");
		}
		
		if(StringUtil.isEmpty(listDo.getComp_codecolumn())){
			throw new BizException("医保档案类型的对照名称不能为空");
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select  ");
		sql.append(listDo.getComp_tablename()+"."+listDo.getComp_codecolumn()+" code_his , ");
		sql.append(listDo.getComp_tablename()+"."+listDo.getComp_namecolumn()+" name_his, ");
		sql.append(" comp.code_hp, ");
		sql.append(" comp.name_hp, ");
		sql.append(" comp.id_miudidoc_comp, ");
		sql.append("'"+Context.get().getGroupId()+"'");
		sql.append(" id_grp, ");
		sql.append("'"+Context.get().getOrgId()+"'");
		sql.append(" id_org, ");
		sql.append("'"+listDo.getId_miudidoclist()+"'");
		sql.append("  id_miudidoclist, ");
		sql.append(" comp.id_miudidoc, ");
		sql.append("'"+useDo.getId_hp()+"'");
		sql.append(" id_hp, ");
		sql.append(" comp.createdby, ");
		sql.append(" comp.createdtime, ");
		sql.append(" comp.modifiedby, ");
		sql.append(" comp.modifiedtime, ");
		sql.append(" comp.sv, ");
		sql.append(" comp.ds ");
		sql.append(" from ");
		sql.append(listDo.getComp_tablename());
		sql.append(" left join mi_udidoc_comp comp on "+listDo.getComp_tablename()+".");
		sql.append(listDo.getComp_codecolumn());
		sql.append("=comp.code_his ");
		sql.append(" and comp.id_miudidoclist= '");
		sql.append(useDo.getId_miudidoclist());
		sql.append("' and comp.id_hp = '");
		sql.append(useDo.getId_hp());
		sql.append("'");
		if(!StringUtil.isEmpty(listDo.getComp_condition())){
			sql.append(" where ");
			sql.append(listDo.getComp_condition());
		}
		sql.append(" order by "+listDo.getComp_tablename()+"."+"code ");
		
		List<MiUdidocCompDO> list =(List<MiUdidocCompDO>)new DAFacade().execQuery(sql.toString(), new BeanListHandler(MiUdidocCompDO.class));
		
		return list.toArray(new MiUdidocCompDO[0]);
	} 
}
