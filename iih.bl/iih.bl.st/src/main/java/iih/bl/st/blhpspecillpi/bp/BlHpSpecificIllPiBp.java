package iih.bl.st.blhpspecillpi.bp;

import java.util.List;

import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDiDO;
import iih.mi.mc.mimcpatspec.d.MimcpatspecdiAggDO;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class BlHpSpecificIllPiBp {
	@SuppressWarnings("unchecked")
	public PagingRtnData<MiMcPatSpecDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		IQrySQLGeneratorService ser = (IQrySQLGeneratorService) ServiceFinder.find(IQrySQLGeneratorService.class);
		String whereStr = ser.getQueryStringWithoutDesc(qryRootNodeDTO);
		int pageSize = pg.getPageSize();
		int pageIndex = pg.getPageIndex();

		StringBuffer sql = new StringBuffer();
		sql.append("select *");
		sql.append("  from (select *");
		sql.append("          from (select x.code_pat, x.name_pat, x.no_hp, x.tel_pat, x.hp_name, x.id_mimcpatspec");
		sql.append("                  from (select a.id_mimcpatspec,");
		sql.append("                               a.id_org,");
		sql.append("                               a.id_grp,");
		sql.append("                               a.no_hp,");
		sql.append("                               w.name           as hp_name,");
		sql.append("                               d.id_dsdef,");
		sql.append("                               def.name         as name_di,");
		sql.append("                               def.code         as code_di,");
		sql.append("                               def1.name         as name_ds,");
		sql.append("                               def1.code         as code_ds,");
		sql.append("                               w.code           as hp_code,");
		sql.append("                               a.id_hp,");
		sql.append("                               a.tel_pat,");
		sql.append("                               c.code           as code_pat,");
		sql.append("                               a.name_pat,");
		sql.append("                               a.sv");
		sql.append("                          from mi_mc_pat_spec a");
		sql.append("                          left outer join pi_pat_hp b");
		sql.append("                            on a.no_hp = b.no_hp");
		sql.append("                          left outer join pi_pat c");
		sql.append("                            on a.id_pat = c.id_pat");
		sql.append("                          left outer join bd_hp w");
		sql.append("                            on w.id_hp = a.id_hp");
		sql.append("                          left join mi_mc_pat_spec_di d");
		sql.append("                            on a.id_mimcpatspec = d.id_mimcpatspec");
		sql.append("                          left join bd_di_def def");
		sql.append("                            on def.id_didef = d.id_didef");
		sql.append("                          left join bd_ds_def def1");
		sql.append("                            on def1.id_dsdef = d.id_dsdef");
		sql.append("                         order by a.no_hp desc) x");
		sql.append("                 where 1 = 1");
		sql.append(String.format("%s", whereStr == null ? "" : String.format(" and %s", whereStr)));
		sql.append("                 group by x.code_pat, x.name_pat, x.no_hp, x.tel_pat, x.hp_name, x.id_mimcpatspec) y");
		sql.append(String.format("         where rownum <= %s) z", (pageIndex + 1) * pageSize));
		sql.append(String.format(" where rownum >= %s", pageIndex * pageSize + 1));

		List<MiMcPatSpecDO> list = (List<MiMcPatSpecDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(MiMcPatSpecDO.class));
		FArrayList pageData = new FArrayList();
		pageData.addAll(list);

		if (list == null || list.size() == 0) {
			PagingRtnData<MiMcPatSpecDO> prdata = new PagingRtnData<MiMcPatSpecDO>();
			prdata.setPagingInfo(pg);
			return prdata;

		}

		int dataCount = list.size();
		pg.setPageCount(dataCount / pageSize);
		pg.setRecordsCount(dataCount);
		PagingRtnData<MiMcPatSpecDO> pagingRtnData = new PagingRtnData<MiMcPatSpecDO>();
		pagingRtnData.setPageData(pageData);
		pagingRtnData.setPagingInfo(pg);
		return pagingRtnData;
	}

	/**
	 * 通过医保号查询患者编码
	 * 
	 * @param NoHp
	 * @return
	 * @throws BizException
	 */
	public MiMcPatSpecDO findCodeByNoHp(String NoHp) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append(" select a.code code_pat, a.id_pat ");
		sql.append(" from pi_pat a ");
		sql.append(" left join pi_pat_hp b ");
		sql.append(" on a.id_pat = b.id_pat ");
		sql.append(" where ");
		sql.append(" b.no_hp = '" + NoHp + "' ");

		// SqlParam sp = new SqlParam();
		// sp.addParam(NoHp);

		@SuppressWarnings("unchecked")
		List<MiMcPatSpecDO> list = (List<MiMcPatSpecDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(MiMcPatSpecDO.class));

		if (ListUtil.isEmpty(list) || list == null) {
			return null;
		}

		return list.get(0);
	}

	public MiMcPatSpecDiDO[] getBlHpPatSpecDiItmsByIdhppat(MiMcPatSpecDO blhpPatSpecDO) throws BizException {
		MiMcPatSpecDiDO[] MiMcPatSpecDiDO = new MiMcPatSpecDiDO[] {};
		IMimcpatspecdiRService rservice = (IMimcpatspecdiRService) ServiceFinder.find(IMimcpatspecdiRService.class);
		if (blhpPatSpecDO != null) {
			String a = blhpPatSpecDO.getId_mimcpatspec();
			System.out.println(a + "是齐佳患者的特殊病主键");
			MimcpatspecdiAggDO[] mimcpatspecdiAggDOs = rservice.find("  id_hppatspec='" + a + "'", "", FBoolean.FALSE);
			for (MimcpatspecdiAggDO mimcpatspecdiAggDO : mimcpatspecdiAggDOs) {
				MiMcPatSpecDiDO = mimcpatspecdiAggDO.getMiMcPatSpecDiDO();
			}
			return MiMcPatSpecDiDO;
		}
		return null;
	}

}