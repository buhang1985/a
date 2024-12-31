package iih.bl.hp.s.bp;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bl.hp.dto.d.EntBasicInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 获取患者的就诊记录
 * @author 
 *
 */
public class GetEntListBP {
	/**
	 * 获取患者的就诊记录
	 * @param pg 分页对象
	 * @param qryNode 查询面板对象
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EntBasicInfoDTO> exec(QryRootNodeDTO qryNode,PaginationInfo pg) 
			throws BizException
	{
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryNode);

		StringBuffer sql = new StringBuffer();
		sql.append(" select en_ent.id_ent, en_ent.id_pat, en_ent.code code_ent, ");
		sql.append(" en_ent.dt_entry, bd_dep.name name_dep_phy, ");
		sql.append(" en_ent.code_entp,bd_entp.name name_entp, en_ent.name_pat name_pat  ");		
		sql.append("  from en_ent       ");
		sql.append("   inner join en_ent_hp enthp  "); 
		sql.append("     on en_ent.id_ent = enthp.id_ent  ");
		sql.append("   inner join bd_hp hp  "); 
		sql.append("     on enthp.id_hp = hp.id_hp  ");
		sql.append("   inner join bd_dep  "); 
		sql.append("     on en_ent.id_dep_phy = bd_dep.id_dep  ");
		sql.append("   inner join en_ent_hp  ");
		sql.append("     on en_ent.id_ent=en_ent_hp.id_ent  ");
		sql.append("   inner join bd_entp   ");
		sql.append("      on en_ent.code_entp= bd_entp.code  ");
		sql.append("   inner join bl_hp_entcode_ah hpcode   ");
		sql.append("      on hpcode.id_ent = en_ent.id_ent  ");
		sql.append("     where  hpcode.fg_active = 'Y' ");//and hp.code = '").append(IBdPpCodeTypeConst.SD_HP_NEUSOFT).append("' ");
		if (whereStr == null) {
			sql.append(" and 1=1");
		} else {
			sql.append(" and ").append(whereStr);
		}
		
		EntBasicInfoDTO incdto = new EntBasicInfoDTO();
		PagingServiceImpl<EntBasicInfoDTO> pagingServiceImpl = new PagingServiceImpl<EntBasicInfoDTO>();

		PagingRtnData<EntBasicInfoDTO> prd = pagingServiceImpl.findByPageInfo(incdto, pg, sql.toString(), "en_ent.dt_entry desc", null);
		return prd;
	
	}
}
