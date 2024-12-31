package iih.bd.fc.s.bp.shortselect;

import iih.bd.fc.dto.shortselect.d.CardCondDTO;
import iih.bd.fc.dto.shortselect.d.SelectedDTO;
import iih.bd.fc.orwf.d.EnumAttr;
import iih.bd.fc.s.bp.shortselect.qry.GetDepSql;
import iih.bd.fc.s.bp.shortselect.qry.GetDocSql;
import iih.bd.fc.s.bp.shortselect.qry.GetMmSql;
import iih.bd.fc.s.bp.shortselect.qry.GetRouteSql;
import iih.bd.fc.s.bp.shortselect.qry.GetSrvCaSql;
import iih.bd.fc.s.bp.shortselect.qry.GetSrvSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.orm.utils.ITransQry;

/**
 * @Description:快捷录入数据获取
 * @author: xu_xing@founder.com.cn
 * @version：2019年3月14日 下午6:57:11 创建
 */
public class GetShortSelectListBp {

	/**
	 * 主入口
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<SelectedDTO> exec(PaginationInfo pg, CardCondDTO cond) throws BizException {

		//1、基础校验
		validation(cond);

		//2、查询服务信息
		if (EnumAttr.SRV == cond.getEu_datatp())
			return querySrv(pg, cond);

		//3、查询服务分类
		if (EnumAttr.SRVCA == cond.getEu_datatp())
			return querySrvCa(pg, cond);

		//4、剂型
		if (EnumAttr.DOSAGE == cond.getEu_datatp())
			return queryDosage(pg, cond);

		//5、毒麻
		if (EnumAttr.POSI == cond.getEu_datatp())
			return queryPosi(pg, cond);

		//6、物品
		if (EnumAttr.MM == cond.getEu_datatp())
			return queryMm(pg, cond);

		//6、草药制剂
		if (EnumAttr.HERBPERP == cond.getEu_datatp())
			return queryHerb(pg, cond);

		//7、用法
		if (EnumAttr.ROUTE == cond.getEu_datatp())
			return queryRoute(pg, cond);

		//8、部门
		if (EnumAttr.DEPOR == cond.getEu_datatp())
			return queryDep(pg, cond);

		//9、就诊科室
		if (EnumAttr.DEPPHY == cond.getEu_datatp())
			return queryDep(pg, cond);

		//10、护理单元
		if (EnumAttr.DEPNUR == cond.getEu_datatp())
			return queryDep(pg, cond);

		//11、星期
		if (EnumAttr.WEEK == cond.getEu_datatp())
			return queryWeek(pg, cond);
		
		//12、领药方式
		if (EnumAttr.MEDI == cond.getEu_datatp())
			return queryMedi(pg, cond);

		//13、年龄等级
		if (EnumAttr.AGELEVEL == cond.getEu_datatp())
			return queryAgeLevel(pg, cond);
		
		return null;
	}

	/**
	 * 基础校验
	 * @param cond
	 * @throws BizException
	 */
	private void validation(CardCondDTO cond) throws BizException {
		if (cond == null)
			throw new BizException("快捷选择查询：参数空异常！");
		if (cond.getEu_datatp() == null)
			throw new BizException("快捷选择查询：必须执行查询数据类型！");
		if(cond.getKey() != null && cond.getKey().matches("^[a-zA-Z]*"))
			cond.setKey(cond.getKey().toUpperCase());
	}

	/**
	 * 查询医疗服务信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> querySrv(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetSrvSql sql = new GetSrvSql(cond, this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询医疗服务分类信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> querySrvCa(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetSrvCaSql sql = new GetSrvCaSql(cond, this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询剂型信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryDosage(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_dosage(), "@@@@ZZ2000000000002R", this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询毒麻分类信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryPosi(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_pois(), "@@@@ZZ2000000000002T", this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询物品信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryMm(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetMmSql sql = new GetMmSql(cond, this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询草药制剂信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryHerb(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_herbperp(), "@@@@ZZ200000000000NK", this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询用法信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryRoute(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetRouteSql sql = new GetRouteSql(cond, this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询部门信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryDep(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDepSql sql = new GetDepSql(cond, this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查星期信息
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryWeek(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_week(), "@@@@ZZ200000000000AM", this.getIds(cond));
		return query(pg, cond, sql);
	}
	
	/**
	 * 查询领药方式
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SelectedDTO> queryMedi(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_drugdeliverymethod(), "@@@@GJ600000000000MJ", this.getIds(cond));
		return query(pg, cond, sql);
	}

	/**
	 * 查询年龄等级
	 * @param pg
	 * @param cond
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<SelectedDTO> queryAgeLevel(PaginationInfo pg, CardCondDTO cond) throws BizException {
		GetDocSql sql = new GetDocSql(cond, cond.getId_age_level(), "@@@@LL200000000001JK", this.getIds(cond));
		return query(pg, cond, sql);
	}
	
	/**
	 * 获取已经选择的ID集合
	 * @param cond
	 * @return
	 */
	private String[] getIds(CardCondDTO cond) {
		if (StringUtil.isEmptyWithTrim(cond.getId_keys()))
			return null;
		return cond.getId_keys().split("\\,");
	}

	/**
	 * 分页查询
	 * @param pg
	 * @param cond
	 * @param sql
	 * @return
	 * @throws BizException 
	 */
	private PagingRtnData<SelectedDTO> query(PaginationInfo pg, CardCondDTO cond, ITransQry sql) throws BizException {
		PagingServiceImpl<SelectedDTO> service = new PagingServiceImpl<SelectedDTO>();
		PagingRtnData<SelectedDTO> rtns = service.findByPageInfo(new SelectedDTO(), pg, sql.getQrySQLStr(), null, sql.getQryParameter(null));
		return rtns;
	}
}
