package iih.bd.srv.mrpsnpower2.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.mrpsnpower.d.MrPsnPowerDO;
import iih.bd.srv.mrpsnpower.i.IMrpsnpowerRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 人员权限列表查询
 */
public class GetPsnDos {

	/**
	* 人员权限列表的过滤查询
	 * @throws BizException 
	*/
	public MrPsnPowerDO[] getPsnDos() throws BizException {
		MrPsnPowerDO[] psnDo = null;
		IMrpsnpowerRService psnSer = ServiceFinder.find(IMrpsnpowerRService.class);
		MrPsnPowerDO[] psnDos = psnSer.find("ds='0'", "id_dept", FBoolean.FALSE);
		List<MrPsnPowerDO> list = Arrays.asList(psnDos);
		list = getList(list);
		psnDo = list.toArray(new MrPsnPowerDO[list.size()]);
		return psnDo;
	}

	/**
	* 人员权限列表的查询方案过滤查询
	 * @throws BizException 
	*/
	public PagingRtnData<MrPsnPowerDO> exec(QryRootNodeDTO qryRootNodeDto, String orderPart, String wherePart,
			PaginationInfo pg) throws BizException {

		String whereStr = getWherePart(wherePart, qryRootNodeDto);
			
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT   DISTINCT psn.ID_PSN AS ID_PSN,   ");
		sqlBuilder.append("         psn.Id_dept AS ID_DEPT,  ");
		sqlBuilder.append("         bd.NAME AS NAME_PSN,  ");
		sqlBuilder.append("         bd.CODE AS CODE_PSN,  ");
		sqlBuilder.append("         '0' AS IDMRPSNPOWER,  ");	
		sqlBuilder.append("         bd2.NAME AS NAME_DEPT   ");
		sqlBuilder.append(" FROM mr_psn_power  psn  "); 
		sqlBuilder.append(" LEFT JOIN bd_psndoc bd ");
		sqlBuilder.append(" ON   psn.ID_PSN = bd.ID_PSNDOC ");
		sqlBuilder.append(" LEFT JOIN bd_dep bd2 ");
		sqlBuilder.append(" ON   psn.ID_DEPT = bd2.ID_DEP ");
		sqlBuilder.append(" LEFT JOIN mr_pan_power_detail psn2 ");
		sqlBuilder.append(" ON   psn.IDMRPSNPOWER = psn2.IDMRPSNPOWER ");
		sqlBuilder.append(whereStr);
				
		PagingServiceImpl<MrPsnPowerDO> pagingServiceImpl = new PagingServiceImpl<MrPsnPowerDO>();
		PagingRtnData<MrPsnPowerDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new MrPsnPowerDO(), pg,
				sqlBuilder.toString(), "", null);

		return pagingRtnData;
	}
	
	/**
	 * 获取条件语句
	 * 
	 * @param wherePart
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String wherePart, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder(" WHERE 1 = 1 ");

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
	 * 相同人员只显示一条过滤
	 */
	public List<MrPsnPowerDO> getList(List<MrPsnPowerDO> list) {
		list = new ArrayList<>(list);
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(i).getId_psn().equals(list.get(j).getId_psn())) {
					list.remove(j);
				}
			}
		}
		return list;
	}
}
