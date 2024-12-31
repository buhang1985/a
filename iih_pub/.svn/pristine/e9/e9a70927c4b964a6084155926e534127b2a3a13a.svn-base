package iih.bd.res.warehouse.i;

import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.orgfw.dept.d.DeptDO;

public interface IWarehouseService {

	/**
	 * 统计货位数量
	 */
	public abstract FArrayList findGoodsLoction() throws BizException;

	/**
	 * 根据仓库ID统计货位数量
	 */
	public abstract FBoolean findLocByWh(String whid) throws BizException;

	/**
	 * 根据仓库ID查找部门相关信息
	 */
	public abstract FArrayList findDeptParamset(String whid, String dpcode) throws BizException;

	/**
	 * 获取权限仓库
	 * 
	 * @param
	 */
	public WarehouseDO[] getLimitsWarehouse() throws BizException;

	/**
	 * 根据部门批量生成仓库
	 * 
	 * @param deptList    所选部门列表
	 * @param wareHouseDO 仓库模板
	 * @param startValue  仓库编码起始值
	 * @throws BizException
	 */
	public void initWareHouse(DeptDO[] deptList, WarehouseDO wareHouseDO, FDouble startValue) throws BizException;

	/**
	 * 根据科室主键查询所属仓库信息
	 * 
	 * @param depId 科室主键
	 * @return
	 */
	public WarehouseDO findOwerWhByDepId(String depId, FBoolean fg_mm) throws BizException;
	
	/**
	 * 获取静配中心药房
	 * 
	 * @param depId 科室主键
	 * @return
	 */
	public DeptDO getPivasDepInfo() throws BizException;
}
