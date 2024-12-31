package iih.bd.mm.warehouseinfo.bp;

import com.enterprisewechat.cp.util.StringUtils;

import iih.bd.mm.comm.i.ICommService;
import iih.bd.mm.meterial.d.MMPackageUnitDO;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;

public class WhmmCuBeforeBp {

	public void exec(WarehouseInfoDO[] dos) throws BizException {

		// ■ 参数校验
		this.validaPara(dos);

		// ■ 库存数量转换
		this.convertNumberToBase(dos);

		// ■ 仓库关联字段设定
		this.setRelationValue(dos);
	}

	private void validaPara(WarehouseInfoDO[] dos) throws BizException {

		if (dos == null || dos.length <= 0) {

			throw new BizException("传入仓库物品关系数据为空。");
		}
	}

	private void setRelationValue(WarehouseInfoDO[] dos) throws BizException {

		IWarehouseRService iWarehouseRService = ServiceFinder.find(IWarehouseRService.class);
		ICommService commService = ServiceFinder.find(ICommService.class);
		WarehouseDO[] wareHouseDOS = iWarehouseRService.find("1=1", "", FBoolean.TRUE);
		PsndocAggDO psnAggDO = commService.getEmployeeInfoByUserId(Context.get().getUserId());
		if (wareHouseDOS == null || wareHouseDOS.length <= 0) {

			throw new BizException("获取仓库失败。");
		}

		for (WarehouseInfoDO mmWhDO : dos) {

			// 仓库不是基数药的场合
			if (mmWhDO.getFg_base() == null || !mmWhDO.getFg_base().booleanValue()) {

				WarehouseDO whDO = this.getWhInfo(mmWhDO.getId_wh(), wareHouseDOS);

				// 仓库所属部门设定
				mmWhDO.setId_dep(whDO.getId_dep_belong());
				mmWhDO.setDep_name(whDO.getDep_name());
			}
			
			//停发标识
			if(mmWhDO.getFg_out().booleanValue()) {
				if(StringUtils.isBlank(mmWhDO.getPsnout())) {
					mmWhDO.setPsnout(Context.get().getStuffId());
					mmWhDO.setPsn_code(psnAggDO.getParentDO().getCode());
					mmWhDO.setPsn_name(psnAggDO.getParentDO().getName());
				}
				if(mmWhDO.getOuttime() == null) {
					mmWhDO.setOuttime(new FDateTime());
				}
			} else {
				mmWhDO.setPsnout(null);
				mmWhDO.setPsn_code(null);
				mmWhDO.setPsn_name(null);
				mmWhDO.setOuttime(null);
			}
		}
	}

	private WarehouseDO getWhInfo(String id_wh, WarehouseDO[] wareHouseDOS) throws BizException {

		for (WarehouseDO whDO : wareHouseDOS) {

			if (id_wh.equals(whDO.getId_wh())) {

				return whDO;
			}
		}

		throw new BizException("获取仓库失败。");
	}

	private void convertNumberToBase(WarehouseInfoDO[] dos) throws BizException {

		IMeterialService mmSrv = ServiceFinder.find(IMeterialService.class);

		for (WarehouseInfoDO warehouseInfoDO : dos) {
			if(warehouseInfoDO.getStatus() == DOStatus.DELETED) {
				continue;
			}
			FDouble uiMaxStock = warehouseInfoDO.getMaxuinum();
			FDouble uiLowStock = warehouseInfoDO.getLowuinum();

			// 单位换算
			MMPackageUnitDO uiPkgDO = mmSrv.findPackageUnitById(warehouseInfoDO.getId_mmpkgu_ui());
			if (uiPkgDO == null) {
				String msg = String.format("获取物品包装单位信息失败,id_mm:%s,id_wh:%s,Id_mmpkgu_ui:%s", warehouseInfoDO.getId_mm(),
						warehouseInfoDO.getId_wh(), warehouseInfoDO.getId_mmpkgu_ui());
				throw new BizException(msg);
			}
			if (uiMaxStock == null) {
				String msg = String.format("界面最大库存量为空,id_mm:%s,id_wh:%s,Id_mmpkgu_ui:%s", warehouseInfoDO.getId_mm(),
						warehouseInfoDO.getId_wh(), warehouseInfoDO.getId_mmpkgu_ui());
				throw new BizException(msg);
			}
			if (uiPkgDO.getFactor() == null) {
				String msg = String.format("物品包装单位换算系数为空,id_mm:%s,id_wh:%s,Id_mmpkgu_ui:%s,id_mmpkgu:%s",
						warehouseInfoDO.getId_mm(), warehouseInfoDO.getId_wh(), warehouseInfoDO.getId_mmpkgu_ui(),
						uiPkgDO.getId_mmpkgu());
				throw new BizException(msg);
			}
			warehouseInfoDO.setMaxstnum(uiMaxStock.multiply(uiPkgDO.getFactor()));
			warehouseInfoDO.setLowstnum(uiLowStock.multiply(uiPkgDO.getFactor()));
		}
	}
}
