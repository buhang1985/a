package iih.bd.srv.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.srv.d.MmPriceDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.s.MedsrvCrudServiceImpl;
import iih.bd.srv.s.bp.GetOutlineSrvRefMmBP;
import iih.bd.utils.log.BdSrvLogUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

public class SyncBdSrvPriceExTask implements IBackgroundWorkPlugin {

	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		try {
			OrgDO[] szOrgDO = ServiceFinder.find(IOrgRServiceExt.class).queryAllOrgVOs();
			if (CiOrdUtils.isEmpty(szOrgDO)) {
				PreAlertObject obj = new PreAlertObject();
//				obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
				return obj;
			}
			if (!arg0.getKeyMap().containsKey("id_org")) {
				PreAlertObject obj = new PreAlertObject();
//				obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
				return obj;
			}
			if (arg0.getKeyMap().containsKey("id_grp")) {
				String id_grp = arg0.getKeyMap().get("id_grp").toString();
				Context.get().setGroupId(id_grp);
			}
			String operate = "";
			if (arg0.getKeyMap().containsKey("operate")) {
				operate = arg0.getKeyMap().get("operate").toString();
			}
			String id_org = arg0.getKeyMap().get("id_org").toString();
			Context.get().setOrgId(id_org);

			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();
			DAFacade dafacade = new DAFacade();
			StringBuffer sqlb1 = new StringBuffer();
			// 计算记录总数以此分页
			sqlb1.append(
					" select count(1) as c from bd_srv where sd_srvtp not like '01%%' and fg_or = 'Y' and fg_active = "
							+ "'Y' and sd_srvtp in (select code from bd_udidoc where id_udidoclist = '"
							+ IBdSrvDictCodeTypeConst.ID_SRVTP + "' and ctrl1='Y' and ds = 0 )");
			List<String> list = (List<String>) dafacade.execQuery(sqlb1.toString(), new ColumnListHandler());
			int total = 0;
			if (list != null && list.size() > 0) {
				Object o = list.get(0);
				total = Integer.parseInt(o.toString());
			}
			int pageSize = 800;

			int page = getTotalPage(total, pageSize);
			List<MedsrvAggDO> totalList = new ArrayList<MedsrvAggDO>();

			// 查询条件: 非药品 && 启用 && 医嘱 && 费用 && 套项目
			String whereCondition = String.format(" %s not like '01%%' and %s = 'Y' and %s = 'Y'  ", MedSrvDO.SD_SRVTP,
					MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR);

			whereCondition += " and sd_srvtp in (select code from bd_udidoc where id_udidoclist = '"
					+ IBdFcDictCodeConst.ID_CODE_SRVTP + "' and ctrl1='Y' and ds = 0 )";
			if (operate.equals("01")) {
				BdSrvLogUtils.info("=>患者价格分类模块:开始执行后台服务价格同步<=");
			} else if (operate.equals("02")) {
				BdSrvLogUtils.info("=>价表维护模块:开始执行后台服务价格同步<=");
			}

			for (int i = 0; i < page; i++) {
				PaginationInfo pg = new PaginationInfo();
				pg.setPageIndex(i);
				pg.setPageSize(pageSize);
				PagingRtnData<MedsrvAggDO> szMedsrvAggDO = medsrvCrudServiceImpl.findByPageInfo(pg, whereCondition,
						MedSrvDO.ID_SRV, FBoolean.FALSE);
				FArrayList resultList = szMedsrvAggDO.getPageData();

				if (resultList != null && resultList.size() > 0) {
					for (int j = 0; j < resultList.size(); j++) {
						totalList.add((MedsrvAggDO) resultList.get(j));
					}
				}
				// 第一次执行时清空bd_srv_price表
				if (i == 0) {
					syncSrvOrSetPrice4(medsrvCrudServiceImpl,
							(MedsrvAggDO[]) resultList.toArray(new MedsrvAggDO[resultList.size()]), true, operate);
				} else {
					syncSrvOrSetPrice4(medsrvCrudServiceImpl,
							(MedsrvAggDO[]) resultList.toArray(new MedsrvAggDO[resultList.size()]), false, operate);
				}
			}

			// 更新 服务表中的Pri字段
			{
				// 2017-07-26 19:29:35 by yzh 更新bd_srv.pri
				sqlb1.delete(0, sqlb1.length());
				sqlb1.append(" select distinct id_srv,price_std from bd_srv_price ");
				List<Map<String, Object>> result = (List<Map<String, Object>>) dafacade.execQuery(sqlb1.toString(),
						new MapListHandler());
				if (result != null && result.size() > 0) {
					String[] arrayFieldNames = { MedSrvDO.ID_SRV, MedSrvDO.PRI };
					MedSrvDO[] medSrvDOs = new MedSrvDO[result.size()];
					for (int i = 0; i < result.size(); i++) {
						MedSrvDO medSrv = new MedSrvDO();
						HashMap<String, Object> obj = (HashMap<String, Object>) result.get(i);
						String id_srv = (String) obj.get("id_srv");
						FDouble pri = new FDouble(obj.get("price_std").toString());
						medSrv.setId_srv(id_srv);
						medSrv.setPri(pri);
						medSrvDOs[i] = medSrv;
					}
					dafacade.updateDOArray(medSrvDOs, arrayFieldNames);
				}
//				String upSql = "update bd_srv set pri = (select price_std from (select distinct id_srv,price_std from bd_srv_price) a1  where bd_srv.id_srv=a1.id_srv)";

//				dafacade.execUpdate(upSql);
			}

			MedsrvAggDO[] szMedsrvAggDOResults = (MedsrvAggDO[]) totalList.toArray(new MedsrvAggDO[totalList.size()]);

			// 发送事件
			if (szMedsrvAggDOResults != null && szMedsrvAggDOResults.length > 0) {
				List<MedsrvAggDO> sentMedsrvAggDOList = new ArrayList<MedsrvAggDO>();
				for (MedsrvAggDO item : szMedsrvAggDOResults) {
					if (item.getParentDO().getSd_primd() != null
							&& item.getParentDO().getSd_primd().equals(IBdPrimdCodeConst.CODE_PRI_SRV)) {
						sentMedsrvAggDOList.add(item);
					}
				}

				sentUpdateSrvEvent(sentMedsrvAggDOList.toArray(new MedsrvAggDO[sentMedsrvAggDOList.size()]));
			}

			whereCondition = String.format(" %s = 'Y' and %s = 'Y' and %s = 'Y' and %s = 'Y'", MedSrvDO.FG_MM,
					MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR, MedSrvDO.FG_BL);

			MedsrvAggDO[] szMMMedsrvAggDO = medsrvCrudServiceImpl.find(whereCondition, MedSrvDO.ID_SRV, FBoolean.FALSE);
			syncSrvOrMmPrice2(medsrvCrudServiceImpl, szMMMedsrvAggDO);
//			String upSql = "update bd_pri_pat set fg_syncpri = 'N'";
//			dafacade.execUpdate(upSql);
		} catch (BizException e) {

			BdSrvLogUtils.logEx(e);
			e.printStackTrace();
		} finally {
			// 将bd_pri_pat.fg_syncpri置回N
			StringBuilder sqlBuilder = new StringBuilder();
			sqlBuilder.append("UPDATE BD_PRI_PAT SET FG_SYNCPRI = 'N'");

			StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
			wherePartBuilder.append(String.format(" AND ID_ORG = '%s'", Context.get().getOrgId()));
			wherePartBuilder.append(" AND (FG_SYNCPRI IS NULL OR FG_SYNCPRI = 'Y')");

			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePartBuilder.toString());
			DAFacade dafacade = new DAFacade();
			dafacade.execUpdate(sqlBuilder.toString());
		}
		BdSrvLogUtils.info("=>结束执行后台服务价格同步<=");
		PreAlertObject obj = new PreAlertObject();
		return obj;
	}

	/**
	 * yzh 从费用接口获取数据同步 srv 的参考价格
	 * 
	 * @param medsrvCrudServiceImpl
	 * @param szMedsrvAggDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedsrvAggDO[] syncSrvOrSetPrice4(MedsrvCrudServiceImpl medsrvCrudServiceImpl, MedsrvAggDO[] szMedsrvAggDO,
			boolean isDelete, String operate) throws BizException {

		// 待插入list
		List<MedSrvPriceDO> MedSrvPriceList = new ArrayList<MedSrvPriceDO>();
		// 2.检索所有价格分类
		String[] fields = { "id_pripat" };
		DAFacade dafacade = new DAFacade();
		List<PriPatDO> priPatDOLst = new ArrayList<PriPatDO>();
		if (operate.equals("01") || operate.equals("02")) {
			priPatDOLst = (List<PriPatDO>) dafacade.findByCond(PriPatDO.class, " fg_syncpri='Y' ", fields);
		} else {
			priPatDOLst = (List<PriPatDO>) dafacade.findByCond(PriPatDO.class, " 1=1", fields);
		}

		if (szMedsrvAggDO != null) {
			CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
			int pageSize = 100;
			int total = szMedsrvAggDO.length;
			// 分页
			int totalPage = getTotalPage(total, pageSize);
			// 循环 间隔100次
			int error = 0;
			for (int i = 0; i < totalPage; i++) {
				List<BdSrvPriCalParamDTO> bspList = new ArrayList<BdSrvPriCalParamDTO>();
				if (i == totalPage - 1) {
					for (int j = i * pageSize; j < total; j++) {
						MedSrvDO mdsDO = szMedsrvAggDO[j].getParentDO();
						MedSrvSetItemDO[] items = szMedsrvAggDO[j].getMedSrvSetItemDO();
						BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
						param.setId_srv(mdsDO.getId_srv());
						param.setId_primd(mdsDO.getId_primd());
						param.setName_srv(mdsDO.getName());
						doData(items, param);
						param.setNum(param.getSrvsetitms() == null ? 0 : param.getSrvsetitms().size());
						bspList.add(param);
					}
				} else {
					for (int j = i * pageSize; j < (i + 1) * pageSize; j++) {
						MedSrvDO mdsDO = szMedsrvAggDO[j].getParentDO();
						MedSrvSetItemDO[] items = szMedsrvAggDO[j].getMedSrvSetItemDO();
						BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
						param.setId_srv(mdsDO.getId_srv());
						param.setId_primd(mdsDO.getId_primd());
						param.setName_srv(mdsDO.getName());
						doData(items, param);
						param.setNum(param.getSrvsetitms() == null ? 0 : param.getSrvsetitms().size());
						bspList.add(param);
					}
				}
				// 3.循环计算每个价格分类下的服务折扣价
				for (PriPatDO priPatDO : priPatDOLst) {
					for (int j = 0; j < bspList.size(); j++) {
						try {
							BdSrvPriCalParamDTO bspcParam = objCopy(bspList.get(j));
							MedSrvPriceDO mspDO = bp.exec(bspcParam, priPatDO.getId_pripat());
							if (mspDO == null)
								continue;
							MedSrvPriceList.add(mspDO);
						} catch (Exception e) {
							error++;
							BdSrvLogUtils.logEx(e);
							continue;
						}
					}
				}
			}
			System.out.println("错误出现次数:" + error);
			// 先执行清空bd_srv_price表操作 再执行插入
			DAFacade daf = new DAFacade();
			if (isDelete) {
				String delViewSql = getDelViewSql();
				daf.execUpdate(delViewSql);
			}
			daf.insertDOList(MedSrvPriceList);

		}
		return szMedsrvAggDO;
	}

	/**
	 * copy对象
	 * 
	 * @param o1
	 * @param o2
	 */
	private BdSrvPriCalParamDTO objCopy(BdSrvPriCalParamDTO o1) {
		BdSrvPriCalParamDTO o2 = new BdSrvPriCalParamDTO();
		o2.setId_srv(o1.getId_srv());
		o2.setId_primd(o1.getId_primd());
		o2.setName_srv(o1.getName_srv());
		o2.setSrvsetitms(o1.getSrvsetitms());
		o2.setNum(o1.getNum());
		return o2;
	}

	/**
	 * 数据处理 剔除非临床项目
	 * 
	 * @param item
	 * @param param
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void doData(MedSrvSetItemDO[] item, BdSrvPriCalParamDTO param) throws BizException {

		int i = 0;
		List<MedSrvSetItemDO> itemList = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO medSrvSetItem : item) {
			if (medSrvSetItem.getFg_clinical() == FBoolean.TRUE) {
				itemList.add(medSrvSetItem);
			}

		}
		String[] id_srvs = new String[itemList.size()];
		for (MedSrvSetItemDO medSrvSetItemDO : itemList) {
			id_srvs[i] = medSrvSetItemDO.getId_srv_itm();
			i++;
		}
		MedsrvAggDO[] srvaggarray = CiOrdAppUtils.getMedsrvRService().findByIds(id_srvs, FBoolean.FALSE);
		if (null == srvaggarray || 0 == srvaggarray.length)
			return;

		FArrayList items = new FArrayList();
		for (MedsrvAggDO srvAgg : srvaggarray) {
			BdSrvPriCalParamDTO calparam = new BdSrvPriCalParamDTO();
			calparam.setId_srv(srvAgg.getParentDO().getId_srv());
			calparam.setId_primd(srvAgg.getParentDO().getId_primd());
			calparam.setName_srv(srvAgg.getParentDO().getName());
			calparam.setNum(1);
			items.add(calparam);
		}
		param.setSrvsetitms(items);
	}

	/**
	 * 获得sql串对应的Map
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private Map<String, Object> getRsMap(String sqlStr) throws BizException {
		try {
			return (Map<String, Object>) (new DAFacade().execQuery(sqlStr, new MapHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * 获得sql串对应的MapList
	 * 
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	private List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException {
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, new MapListHandler()));
		} catch (Exception e) {
			throw new BizException(e.getMessage());
		}
	}

	/**
	 * 获取删除bd_srv_price表的语句
	 * 
	 * @return
	 */
	private String getDelViewSql() {
		String sql = "delete from bd_srv_price ";
		return sql;
	}

	/**
	 * 获取总页数
	 * 
	 * @param total
	 * @param pageSize
	 * @return
	 */
	private int getTotalPage(int total, int pageSize) {
		int totalPage = (total + pageSize - 1) / pageSize;
		return totalPage;
	}

	/**
	 * 获取查count sql
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getPriceCountSql() {
		String sql = " select count(1) from view_price_ratio ";
		return sql;
	}

	/**
	 * 将物品价格同步到bd_srv_price表
	 * 
	 * @param medsrvCrudServiceImpl
	 * @param szMedsrvAggDO
	 * @return
	 * @throws BizException
	 */
	private String[] syncSrvOrMmPrice2(MedsrvCrudServiceImpl medsrvCrudServiceImpl, MedsrvAggDO[] szMedsrvAggDO)
			throws BizException {
		List<String> idSrvList = new ArrayList<String>();
		List<MedSrvPriceDO> mspList = new ArrayList<MedSrvPriceDO>();
		if (szMedsrvAggDO != null) {

			GetOutlineSrvRefMmBP bp = new GetOutlineSrvRefMmBP();

			for (int index = 0; index < szMedsrvAggDO.length; ++index) {
				MedSrvDO medSrvDO = szMedsrvAggDO[index].getParentDO();
				// 获取关联物品信息
				MmPriceDTO[] szRefMm = bp.exec(medSrvDO.getId_srv());
				if (null != szRefMm) {
					for (int i = 0; i < szRefMm.length; i++) {
						// System.out.println("index-->"+i+"
						// id_srv---->"+medSrvDO.getId_srv());
						MedSrvPriceDO mspDO = new MedSrvPriceDO();
						mspDO.setId_srv(medSrvDO.getId_srv());

						mspDO.setDes_pri(
								String.format("%s【%.2f元】", szRefMm[i].getSpec() == null ? "" : szRefMm[i].getSpec(),
										szRefMm[i].getPrice() == null ? new Double("0.00")
												: szRefMm[i].getPrice().doubleValue()));
						mspDO.setPrice_std(szRefMm[i].getPrice());
						mspDO.setPrice_ratio(szRefMm[i].getPrice());
						mspDO.setId_mm(szRefMm[i].getId_mm());
						mspDO.setName_mm(szRefMm[i].getName());
						mspDO.setRatio(FDouble.ONE_DBL);
						mspList.add(mspDO);
					}
					idSrvList.add(medSrvDO.getId_srv());
				}
			}
			if (mspList != null && mspList.size() > 0) {
				DAFacade daf = new DAFacade();
				daf.insertDOList(mspList);
			}
		}
		return idSrvList.toArray(new String[idSrvList.size()]);
	}

	/**
	 * 修改服务时候，将修改后的数据发送给集成平台
	 * 
	 * @param szMedSrvAggDO
	 * @throws BizException
	 */
	private void sentUpdateSrvEvent(MedsrvAggDO[] szMedSrvAggDO) {
		// 定义 srv 列表对象
		List<MedSrvEventDTO> medSrvDOList = new ArrayList<MedSrvEventDTO>();
		// 组织 srv 的数据结构
		for (MedsrvAggDO aggDO : szMedSrvAggDO) {
			medSrvDOList.add(getMedSrvDTO(aggDO.getParentDO()));
		}
		// 判空，有效后发送事件
		if (medSrvDOList.size() > 0) {
			BusinessEvent enterDeptEvent = new BusinessEvent(MedSrvDODesc.CLASS_FULLNAME, IEventType.TYPE_UPDATE_AFTER,
					medSrvDOList.toArray(new MedSrvEventDTO[medSrvDOList.size()]));
			try {
				EventDispatcher.fireEvent(enterDeptEvent);
			} catch (BizException e) {
				BdSrvLogUtils.logEx(e);
			}
		}

	}

	/**
	 * 将医疗服务DO转换为DTO
	 */
	public MedSrvEventDTO getMedSrvDTO(MedSrvDO medSrvDO) {

		MedSrvEventDTO medSrvEventDTO = new MedSrvEventDTO();
		medSrvEventDTO.setId_srv(medSrvDO.getId_srv());
		medSrvEventDTO.setId_grp(medSrvDO.getId_grp());
		medSrvEventDTO.setId_org(medSrvDO.getId_org());
		medSrvEventDTO.setName(medSrvDO.getName());
		medSrvEventDTO.setCode(medSrvDO.getCode());
		medSrvEventDTO.setId_srvtp(medSrvDO.getId_srvtp());
		medSrvEventDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
		medSrvEventDTO.setId_srvca(medSrvDO.getId_srvca());
		medSrvEventDTO.setPycode(medSrvDO.getPycode());
		medSrvEventDTO.setId_unit_med(medSrvDO.getId_unit_med());
		medSrvEventDTO.setQuan_med(medSrvDO.getQuan_med());
		medSrvEventDTO.setId_primd(medSrvDO.getId_primd());
		medSrvEventDTO.setSd_primd(medSrvDO.getSd_primd());
		medSrvEventDTO.setIncca_ip(medSrvDO.getIncca_ip());
		medSrvEventDTO.setIncca_op(medSrvDO.getIncca_op());
		medSrvEventDTO.setPri(medSrvDO.getPri());
		medSrvEventDTO.setFg_active(medSrvDO.getFg_active());
		medSrvEventDTO.setFg_or(medSrvDO.getFg_or());
		medSrvEventDTO.setFg_mm(medSrvDO.getFg_mm());
		medSrvEventDTO.setFg_bl(medSrvDO.getFg_bl());

		return medSrvEventDTO;
	}

}
