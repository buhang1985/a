package iih.bd.srv.mropgrouppower.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.mropgrouppower.d.MrOpGroupPowerDO;
import iih.bd.srv.mropgrouppower.i.IMropgrouppowerRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class findPowerListBp extends PagingServiceImpl<MrOpGroupPowerDO> {

	public MrOpGroupPowerDO[] getpowerlist()throws BizException{
		MrOpGroupPowerDO [] powerdo = null;
		IMropgrouppowerRService powerRService = ServiceFinder.find(IMropgrouppowerRService.class);
		MrOpGroupPowerDO[] power = powerRService.find("ds=0", "id_dept", FBoolean.FALSE);
		List<MrOpGroupPowerDO> list = Arrays.asList(power);
		list = getList(list);
		powerdo = list.toArray(new MrOpGroupPowerDO[list.size()]);
		return powerdo;
		
		
	}
	
	/**
	* 
	 * @throws BizException 
	*/
	public MrOpGroupPowerDO[] exec(String sqlWhere) throws BizException {

//		String whereStr = getWherePart( qryRootNodeDto);
			
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT DISTINCT mop.idmropgroup ,  ");
		sqlBuilder.append(" mop.idmropgrouplevel,  ");
		sqlBuilder.append(" bd2.name as name_dept,  ");
		sqlBuilder.append(" mop.name_pw as name_pw, ");	
		sqlBuilder.append(" mop.own_pw as own_pw, ");
		sqlBuilder.append(" mog.code as code_group,");
		sqlBuilder.append(" mog.name as name_group,  ");
		sqlBuilder.append(" mogl.code_level as code_level, ");
		sqlBuilder.append(" mogl.name_level as name_level ");
		sqlBuilder.append(" FROM mr_opgroup_power mop ");
		sqlBuilder.append(" LEFT JOIN bd_dep bd2 ");
		sqlBuilder.append(" ON mop.id_dept = bd2.ID_DEP ");
		sqlBuilder.append(" LEFT JOIN mr_opgroup_power_detail mopd ");
		sqlBuilder.append(" ON mop.idmropgrouppower = mopd.idmropgrouppower ");
		sqlBuilder.append(" left join mr_op_group mog ");
		sqlBuilder.append(" on mop.idmropgroup = mog.idmropgroup ");
		sqlBuilder.append(" left join mr_op_group_level mogl ");
		sqlBuilder.append(" on mop.idmropgrouplevel = mogl.idmropgrouplevel ");
		sqlBuilder.append(sqlWhere);
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<MrOpGroupPowerDO> listDto = (List<MrOpGroupPowerDO>) daf.execQuery(sqlBuilder.toString(),
				new BeanListHandler(MrOpGroupPowerDO.class));
		listDto = getList(listDto);
		return listDto.toArray(new MrOpGroupPowerDO[0]);
				
//		PagingServiceImpl<MrOpGroupPowerDO> pagingServiceImpl = new PagingServiceImpl<MrOpGroupPowerDO>();
//		PagingRtnData<MrOpGroupPowerDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new MrOpGroupPowerDO(), pg,
//				sqlBuilder.toString(), "", null);
//
//		return pagingRtnData;
	}
	
	/**
	 * 获取条件语句
	 * 
	 * @param wherePart
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart( QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder(" WHERE 1 = 1 ");
		String wherePart= null;
		if (qryRootNodeDto != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto);
			if (StringUtils.isNotBlank(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}
	
	/**
	 * 相同业务组只显示一条过滤
	 */
	public List<MrOpGroupPowerDO> getList(List<MrOpGroupPowerDO> list) {
		list = new ArrayList<>(list);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if(list.get(i).getIdmropgroup() != null && list.get(j).getIdmropgroup() != null && list.get(i).getIdmropgrouplevel()!= null && list.get(j).getIdmropgrouplevel()!=null){
					if (list.get(i).getIdmropgroup().equals(list.get(j).getIdmropgroup())&&list.get(i).getIdmropgrouplevel().equals(list.get(j).getIdmropgrouplevel())) {
						list.remove(j);
					}
				}
//				if(list.get(i).getIdmropgrouplevel() == null && list.get(j).getIdmropgrouplevel() == null &&((list.get(i).getIdmropgroup()!=null && list.get(j).getIdmropgrouplevel() != null)&& list.get(i).getIdmropgroup().equals(list.get(j).getIdmropgroup()))){
//					list.remove(j);
//				}
				
				
			}
		}
		for(int k = 0 ; k<list.size()-1 ; k++){
			for(int l = list.size() -1 ; l > k ; l--){
				if(list.get(k).getIdmropgroup() != null && list.get(l).getIdmropgroup()!= null){
					if(list.get(k).getIdmropgrouplevel() == null && list.get(l).getIdmropgrouplevel() == null){
						if(list.get(k).getIdmropgroup().equals(list.get(l).getIdmropgroup())){
							list.remove(l);
						}
					}
				}
			}
		}
		return list;
	}
	
	
}
