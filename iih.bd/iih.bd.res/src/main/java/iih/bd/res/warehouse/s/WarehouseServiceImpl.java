package iih.bd.res.warehouse.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseCudService;
import iih.bd.res.warehouse.i.IWarehouseRService;
import iih.bd.res.warehouse.i.IWarehouseService;
import iih.bd.res.warehouse.s.bp.FindOwerWhByDepIdBp;
import iih.mm.comm.i.IUdiHelperService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;

public class WarehouseServiceImpl implements IWarehouseService {

	@Override
	public FArrayList findGoodsLoction() throws BizException {
		String sql = "select wh.name || '(' || (select count(1) "
				+ "from bd_location lo where lo.id_wh =wh.id_wh)|| ')'"
				+ "as name,wh.id_wh,wh.id_grp,wh.id_org,wh.id_dep_belong,"
				+ "wh.sd_whtp,wh.id_whtp,wh.code,wh.id_plc,wh.des,wh.wbcode,"
				+ "wh.pycode,wh.mnecode,wh.createdby,wh.createdtime,wh.modifiedby,"
				+ "wh.modifiedtime,wh.def1,wh.def2,wh.def3,wh.def4,wh.def5,wh.def6,"
				+ "wh.fg_active,wh.fg_acctunit,wh.id_parent,wh.innercode,"
				+ "wh.sd_cycleu,wh.id_cycleu,wh.ds,wh.sv,wh.fg_loc,wh.fg_last,wh.fg_use_op,wh.fg_use_er,wh.fg_use_ip,wh.fg_use_pe,wh.fg_use_fm from bd_wh wh";

		FArrayList rtn = AppFwUtil.getMapListWithDao(sql);
		if (rtn == null) {
			System.out.println("rows=0");
		} else {
			System.out.println("rows=" + rtn.size());
		}
		return rtn;
	}

	@Override
	public FBoolean findLocByWh(String whid) throws BizException {
		// TODO Auto-generated method stub

		String sql = "select 1 from bd_location loc where loc.id_wh='" + whid + "'";
		FArrayList rtn = AppFwUtil.getMapListWithDao(sql);
		if (rtn == null || rtn.size() == 0) {
			return FBoolean.FALSE;
		}
		return FBoolean.TRUE;
	}

	@Override
	public FArrayList findDeptParamset(String whid, String dpcode) throws BizException {
		String sql = "select paramv from bd_dept_paramset par where "
				+ "par.id_dept =(select id_dep from bd_dep where id_dep ="
				+ "(select wh.id_dep_belong from bd_wh wh where wh.id_wh = '" + whid + "'))" + "and code = '" + dpcode
				+ "'";
		FArrayList rtn = AppFwUtil.getMapListWithDao(sql);
		return rtn;
	}

	@Override
	public WarehouseDO[] getLimitsWarehouse() throws BizException {
		// 获取权限仓库
		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		StringBuffer whrStr = new StringBuffer();
		whrStr.append(" a0.id_org = '" + Context.get().getOrgId() + "' ");
		// whrStr.append(" and a0.id_dep_belong = '" + idDep + "' ");
		whrStr.append(" and a0.fg_active = 'Y'");
		whrStr.append(" and a0.fg_last = 'Y'");
		whrStr.append(" and a0.ds = 0");

		// 所有仓库列表单独走数据权限， 不与部门挂钩 TODO

		WarehouseDO[] wareHouseList = iWarehouseRService.find(whrStr.toString(), "a0.code", new FBoolean(false));
		return wareHouseList;
	}

	@Override
	public void initWareHouse(DeptDO[] deptList, WarehouseDO wareHouseDO, FDouble startValue) throws BizException {
		if (deptList == null || deptList.length <= 0) {
			return;
		}

		IWarehouseCudService iWarehouseCudService = ServiceFinder.find(IWarehouseCudService.class);
		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		List<FDouble> codeList = new ArrayList<FDouble>();
		for (int i = 0; i < deptList.length; i++) {
			codeList.add(startValue.add(new FDouble(i)));
			WarehouseDO[] wareHouseDOS = iWarehouseRService.find(
					" a0.code = '" + String.valueOf(startValue.add(new FDouble(i)).intValue()) + "'", "",
					new FBoolean(false));
			if (wareHouseDOS != null && wareHouseDOS.length > 0) {
				throw new BizException(
						"仓库编码:" + String.valueOf(startValue.add(new FDouble(i)).intValue()) + "重复，新增失败，请重新录入仓库编码初始值。");
			}
		}

		int i = 0;
		IUdiHelperService udiHelperService = ServiceFinder.find(IUdiHelperService.class);
		List<WarehouseDO> wareHouseList = new ArrayList<WarehouseDO>();
		FDouble[] whCodeList = codeList.toArray(new FDouble[codeList.size()]);
		for (DeptDO deptDO : deptList) {
			WarehouseDO currentDO = new WarehouseDO();
			currentDO.setStatus(DOStatus.NEW);

			// 机构
			currentDO.setId_org(Context.get().getOrgId());
			
			// 集团
			currentDO.setId_grp(Context.get().getGroupId());

			// 仓库所属部门
			currentDO.setId_dep_belong(deptDO.getId_dep());

			// 仓库所属部门名称
			currentDO.setDep_name(deptDO.getName());

			// 仓库类型
			currentDO.setId_whtp(wareHouseDO.getId_whtp());

			// 仓库类型编码
			UdidocDO udidocDO = udiHelperService.getUdidocById(wareHouseDO.getId_whtp());
			currentDO.setSd_whtp(udidocDO.getCode());

			// 仓库类型名称
			currentDO.setWhtp_name(wareHouseDO.getWhtp_name());

			// 仓库编码
			currentDO.setCode(String.valueOf(whCodeList[i].toDouble().intValue()));

			// 仓库名称
			currentDO.setName(deptDO.getName() + "仓库");

			// 五笔、拼音 TODO

			// 启用标志
			currentDO.setFg_active(wareHouseDO.getFg_active());

			// 是否按货位
			currentDO.setFg_loc(wareHouseDO.getFg_loc());

			// 是否末级节点
			currentDO.setFg_last(wareHouseDO.getFg_last());
			// 是否门诊标识
			currentDO.setFg_use_op(wareHouseDO.getFg_use_op());
			// 是否急诊标识
			currentDO.setFg_use_er(wareHouseDO.getFg_use_er());
			// 是否住院标识
			currentDO.setFg_use_ip(wareHouseDO.getFg_use_ip());
			// 是否体检标识
			currentDO.setFg_use_pe(wareHouseDO.getFg_use_pe());
			// 是否家床标识
			currentDO.setFg_use_fm(wareHouseDO.getFg_use_fm());
			// 上级
			currentDO.setId_parent(wareHouseDO.getId_parent());

			wareHouseList.add(currentDO);
			i = i + 1;
		}

		iWarehouseCudService.save(wareHouseList.toArray(new WarehouseDO[wareHouseList.size()]));
	}

	@Override
	public WarehouseDO findOwerWhByDepId(String depId, FBoolean fg_mm) throws BizException {
		FindOwerWhByDepIdBp bp = new FindOwerWhByDepIdBp();
		WarehouseDO result = bp.exec(depId, fg_mm);
		return result;
	}

	@Override
	public DeptDO getPivasDepInfo() throws BizException {
		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		IDeptRService deptRSrv = ServiceFinder.find(IDeptRService.class);
		//静配中心
		WarehouseDO[] whouseDOS = iWarehouseRService.find("fg_pivas = 'Y'", "", FBoolean.TRUE);
		if(whouseDOS == null || whouseDOS.length <= 0) {
			return null;
		}
		DeptDO deptDO = deptRSrv.findById(whouseDOS[0].getId_dep_belong());
		return deptDO;
	}
}
