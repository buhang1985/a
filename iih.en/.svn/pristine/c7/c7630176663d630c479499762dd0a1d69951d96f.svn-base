package iih.en.pv.s.bp.ippre.qry;

import java.util.List;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.pv.dto.d.IppreQryDTO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/***
 * 查询预住院在院患者信息
 * 
 * @author zhangpp
 *
 */
public class GetIppreConterPageListBP extends GetIpPreInfoAbstact {
	// 检查完成患者过滤
	private final static String CHECKEDPATS = "CHECKEDPATS";
	// 未检查完成患者过滤
	private final static String UNCHECKPATS = "UNCHECKPATS";
	// 麻醉评估患者过滤
	private final static String ASSESSPATS = "ASSESSPATS";
	// 入院审核通过患者
	private final static String IPCHECKEDPATS = "IPCHECKEDPATS";
	// 全部患者
	private final static String ALLPATS = "ALLPATS";

	/**
	 * 获取患者信息
	 * 
	 * @param str
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<EnIppreInfoDTO> exec(IppreQryDTO entQryDto, PaginationInfo pageInfo) throws BizException {
		String str = entQryDto.getSqlval();
		if (str != null && !str.equals("")) {
			String depId = EnContextUtils.getDeptId();
			String depstr = " and (ent.id_dep_phy = '" + depId + "'  or ent.id_dep_nur = '" + depId + "'"
					+ " or ippre.id_dep_phy = '" + depId + "'  or ippre.id_dep_ward = '" + depId + "')";
			str += depstr;
		}
		if (entQryDto.getPatstatusfilter() != null && !entQryDto.getPatstatusfilter().equals("")) {
			switch (entQryDto.getPatstatusfilter()) {
			case CHECKEDPATS:
				str += " and ippre.fg_done_mt = 'Y'";
				break;
			case UNCHECKPATS:
				str += " and ippre.fg_done_mt = 'N'";
				break;
			case ASSESSPATS:
				str += " and ippre.fg_done_anest = 'Y'";
				break;
			case IPCHECKEDPATS:
				str += " and ippre.fg_done_dep = 'Y'";
				break;
			default:
				break;
			}
		}
		PagingRtnData<EnIppreInfoDTO> pageDatas = getEntIds(str, pageInfo);
		String[] entIds = IpPreUtils.pageConvertEntIds(pageDatas);
		EnIppreInfoDTO[] ippreInfoDTO = getIpPreByEntIds(entIds);
		if (ArrayUtil.isEmpty(ippreInfoDTO)) {
			return pageDatas;
		}
		// 4.组装数据
		pageDatas.setPageData(EnAppUtils.doArray2List(ippreInfoDTO));
		return pageDatas;

	}

	/**
	 * 获取entIds
	 * 
	 * @param qrySchm
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private PagingRtnData<EnIppreInfoDTO> getEntIds(String str, PaginationInfo pageInfo) throws BizException {

		if (StringUtil.isEmptyWithTrim(str)) {
			return null;
		}
		PagingServiceImpl<EnIppreInfoDTO> pageQryService = new PagingServiceImpl<EnIppreInfoDTO>();
		return pageQryService.findByPageInfo(new EnIppreInfoDTO(), pageInfo, str, null, null);

		/*
		 * List<String> dtoList= (List<String>) new DAFacade().execQuery(str,new
		 * ColumnListHandler()); if (ListUtil.isEmpty(dtoList)) { return null; }
		 * 
		 * return dtoList.toArray(new String[0]);
		 */
	}

	/**
	 * 获取sql
	 * 
	 * @return
	 */
	private String getSql() {

		StringBuffer sql = new StringBuffer();
		sql.append("select distinct ippre.id_ent ");
		sql.append(" from en_ippre ippre ");
		sql.append(" inner join en_ent_ip ip on ip.id_ent = ippre.id_ent ");
		sql.append(" where ");
		sql.append(" ip.fg_ippre = 'Y' ");
		sql.append(" and ippre.sd_status = '2' ");

		return sql.toString();
	}
}
