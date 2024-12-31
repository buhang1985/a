package iih.bd.srv.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.s.MedsrvCrudServiceImpl;
import iih.bd.srv.medsrv.validate.BDErrorInfo;
import iih.bd.srv.medsrv.validate.BDSrvValidateTool;
import iih.bd.utils.log.BdSrvLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class BDSrvInfoCheckTask implements IBackgroundWorkPlugin {

	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		try {
			// ValidateCrudServiceImpl service = new ValidateCrudServiceImpl();

			BDSrvValidateTool tool = new BDSrvValidateTool();

			List<BDErrorInfo> errorList = new ArrayList<BDErrorInfo>();

			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();

			if (arg0.getKeyMap().containsKey("id_org")) {
				String id_org = arg0.getKeyMap().get("id_org").toString();
				Context.get().setGroupId(id_org);
			}
			if (arg0.getKeyMap().containsKey("id_grp")) {
				String id_grp = arg0.getKeyMap().get("id_grp").toString();
				Context.get().setGroupId(id_grp);
			}
			// 查询条件: 非药品 && 启用 && 医嘱 && 费用
			// String whereCondition = String.format(" %s = 'Y' and %s = 'Y' and
			// %s = 'Y' and %s like '01%%'", MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR,
			// MedSrvDO.FG_BL,MedSrvDO.SD_SRVTP);
			// String whereCondition = String.format("DS = 0 and %s like
			// '01%%'", MedSrvDO.SD_SRVTP);

			// 拼接 定时任务参数
			StringBuilder sb = new StringBuilder(
					" ds = 0 and sd_srvtp in (select code from bd_udidoc where id_udidoclist = '"
							+ IBdFcDictCodeConst.ID_CODE_SRVTP + "' and ctrl1='Y' and ds = 0 ) ");
			if (arg0 != null && arg0.getKeyMap() != null && arg0.getKeyMap().containsKey("where")) {
				sb.append(" and ").append(arg0.getKeyMap().get("where"));
			}
			// 查询基础服务数据
			String whereCondition = sb.toString();

			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("select * from bd_srv where ").append(whereCondition);
			// MedSrvDO[] szMedsrvAggDO = medsrvCrudServiceImpl.find(whereCondition,
			// MedSrvDO.SD_SRVTP, FBoolean.FALSE);

			DAFacade db = new DAFacade();
			List<MedSrvDO> lstMedsrvAgg = (List<MedSrvDO>) db.execQuery(sqlSb.toString(),
					new BeanListHandler(MedSrvDO.class));
			MedSrvDO[] szMedsrvAggDO = lstMedsrvAgg.toArray(new MedSrvDO[lstMedsrvAgg.size()]);
			// 执行基础数据校验
			String errorInfo = tool.CheckValidate(szMedsrvAggDO, errorList);
			BdSrvLogUtils.error(errorInfo);

			if (arg0 != null && arg0.getKeyMap() != null && arg0.getKeyMap().containsKey("IsUpdateDB")
					&& arg0.getKeyMap().get("IsUpdateDB").toString().equals("1")) {
				// 保存数据库
				FBoolean active = FBoolean.valueOf(arg0.getKeyMap().containsKey("IsActive")
						&& arg0.getKeyMap().get("IsActive").toString().equals("1")) == FBoolean.TRUE ? FBoolean.FALSE
								: FBoolean.FALSE;
				UpdateDatabaseForActive(szMedsrvAggDO, errorList, medsrvCrudServiceImpl, active);
			}

			// 执行物品基本信息校验
			this.mmCheckValidate(arg0);

		} catch (BizException e) {
			BdSrvLogUtils.logEx(e);
		}

		PreAlertObject obj = new PreAlertObject();
//		obj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return obj;
	}

	private void UpdateDatabaseForActive(MedSrvDO[] szMedSrv, List<BDErrorInfo> errorList,
			MedsrvCrudServiceImpl service, FBoolean active) throws BizException {
		if (szMedSrv == null || errorList.size() == 0) {
			return;
		}

		List<MedSrvDO> needUpdateDataList = new ArrayList<MedSrvDO>();
		// 分拣错误的 MedsrvAggDO 数据
		for (MedSrvDO srv : szMedSrv) {
			for (BDErrorInfo errorInfo : errorList) {
				if (srv.getId_srv().equals(errorInfo.getId_item())) {

					if (srv.getFg_active().booleanValue()) {
						needUpdateDataList.add(srv);
					}

					errorList.remove(errorInfo);
					break;
				}
			}
		}
		if (needUpdateDataList.size() > 0) {
			int ConstPageCount = 50;
			List<MedSrvDO> objList = new ArrayList<MedSrvDO>();
			for (MedSrvDO item : needUpdateDataList) {
				objList.add(item);

				if (objList.size() == ConstPageCount) {
					String sql = fromBdMedSrvList(objList, active.booleanValue());
					DAFacade daf = new DAFacade();
					daf.execUpdate(sql);
					objList.clear();
				}
			}

			if (objList.size() != 0) {
				String sql = fromBdMedSrvList(objList, active.booleanValue());
				DAFacade daf = new DAFacade();
				daf.execUpdate(sql);
				objList.clear();
			}
			// service.update(needUpdateDataList.toArray(new
			// MedsrvAggDO[needUpdateDataList.size()]));
		}
	}

	private String fromBdMedSrvList(List<MedSrvDO> objList, boolean isActive) {
		// 有效性判断
		if (objList.size() == 0) {
			return null;
		}

		// 预制固定更新sql片段
		StringBuilder sb = new StringBuilder(
				"update bd_srv set fg_active = '" + (isActive ? "Y" : "N") + "' where id_srv in (");

		// 拼接条件语句内容
		for (MedSrvDO item : objList) {
			sb.append("'").append(item.getId_srv()).append("',");
		}

		// 返回完整的sql 字符串
		return sb.deleteCharAt(sb.length() - 1).append(")").toString();
	}

	private void mmCheckValidate(BgWorkingContext arg0) throws BizException {

		// 物品基本信息校验
		Boolean fg_update = arg0 != null && arg0.getKeyMap() != null && arg0.getKeyMap().containsKey("IsUpdateDB")
				&& arg0.getKeyMap().get("IsUpdateDB").toString().equals("1");
		String errorInfo = ServiceFinder.find(IMeterialService.class).CheckValidate(fg_update);
		BdSrvLogUtils.error(errorInfo);
	}
}
