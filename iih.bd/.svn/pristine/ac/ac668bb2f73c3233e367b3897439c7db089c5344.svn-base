package iih.bd.mm.warehouseinfo.s.bp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mm.warehouseinfo.bp.WhmmReAfterBp;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.d.desc.WarehouseInfoDODesc;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 查询仓库物品关系分页数据</br>
 * 因排序中涉及参照表字段，索引单独写查询解决排序问题
 * 
 * @author hao_wu 2019-4-4
 *
 */
public class FindPagingDataByQCondBp {

	public PagingRtnData<WarehouseInfoDO> exec(PaginationInfo pgInfo, QryRootNodeDTO qryRootNodeDto, String wherePart,
			String orderPart) throws BizException {

		PagingRtnData<WarehouseInfoDO> pagingRtnData = findPagingData(pgInfo, qryRootNodeDto, wherePart, orderPart);

		updateCalField(pagingRtnData);

		return pagingRtnData;
	}

	/**
	 * 查询分页数据
	 * 
	 * @param pgInfo
	 * @param qryRootNodeDto
	 * @param wherePart
	 * @param orderPart
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<WarehouseInfoDO> findPagingData(PaginationInfo pgInfo, QryRootNodeDTO qryRootNodeDto,
			String wherePart, String orderPart) throws BizException {

		String qrySql = getQrySql(wherePart, qryRootNodeDto);

		PagingServiceImpl<WarehouseInfoDO> pagingServiceImpl = new PagingServiceImpl<WarehouseInfoDO>();
		PagingRtnData<WarehouseInfoDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new WarehouseInfoDO(), pgInfo,
				qrySql, orderPart, null);
		return pagingRtnData;
	}

	private String getQrySql(String wherePart, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT a0.ID_MMWH,"); // 医疗物品与仓库主键
		sqlBuilder.append("a0.ID_GRP,"); // 集团
		sqlBuilder.append("a0.ID_ORG,"); // 机构
		sqlBuilder.append("a0.ID_WH,"); // 仓库
		sqlBuilder.append("a0b1.NAME AS WH_NAME,"); // 仓库名称
		sqlBuilder.append("a0b1.FG_LOC AS FG_LOC,"); // 是否按货位
		sqlBuilder.append("a0.ID_MM,"); // 医疗物品
		sqlBuilder.append("a0b2.CODE AS MM_CODE,"); // 物品编码
		sqlBuilder.append("a0b2.SPEC AS MM_SPEC,"); // 物品规格
		sqlBuilder.append("a0b2.NAME AS MM_NAME,"); // 物品名称
		sqlBuilder.append("bdsrv.NAME AS NAMESRV,"); // 物品通用名
		sqlBuilder.append("SUP.NAME AS AS SUP_NAME,");//生产厂家
		sqlBuilder.append("a0.ID_LOC,"); // 货位
		sqlBuilder.append("a0b3.NAME AS LOC_NAME,"); // 货位名称
		sqlBuilder.append("a0b3.CODE AS LOC_CODE,"); // 货位编码
		sqlBuilder.append("a0.ID_CYCLEU,"); // 库存周期单位
		sqlBuilder.append("a0b4.NAME AS UDI_NAME,"); // 名称
		sqlBuilder.append("a0.SD_CYCLEU,"); // 库存周期单位编码
		sqlBuilder.append("a0.SD_CYCLENUM,"); // 库存周期数量
		sqlBuilder.append("a0.MAXSTNUM,"); // 最高库存_基本单位
		sqlBuilder.append("a0.LOWSTNUM,"); // 最低库存_基本单位
		sqlBuilder.append("a0.ID_MMPKGU_UI,"); // 界面包装单位
		sqlBuilder.append("a0b5.MMPKGUNAME AS MMPKGUNAME,"); // 包装单位名称
		sqlBuilder.append("a0.ID_WH_SRV,"); // 响应仓库
		sqlBuilder.append("a0b6.NAME AS SRV_NAME,"); // 仓库名称
		sqlBuilder.append("a0b6.SD_WHTP,"); // 仓库类型
		sqlBuilder.append("a0.FG_ACTIVE,"); // 启用状态
		sqlBuilder.append("a0.FG_OUT,"); // 停发标志
		sqlBuilder.append("a0.FG_ST_OUT,"); // 自动停发标志
		sqlBuilder.append("a0.ID_DEP,"); // 所属部门
		sqlBuilder.append("a0b7.NAME AS DEP_NAME,"); // 名称
		sqlBuilder.append("a0b7.CODE AS DEP_CODE,"); // 编码
		sqlBuilder.append("a0.FG_BASE,"); // 基数药
		sqlBuilder.append("a0.CREATEDBY,"); // 创建人
		sqlBuilder.append("a0.CREATEDTIME,"); // 创建时间
		sqlBuilder.append("a0.MODIFIEDBY,"); // 最后修改人
		sqlBuilder.append("a0.MODIFIEDTIME,"); // 最后修改时间
		sqlBuilder.append("a0.PSNOUT,"); // 停发人
		sqlBuilder.append("a0b12.CODE AS PSN_CODE,"); // 人员编码
		sqlBuilder.append("a0b12.NAME AS PSN_NAME,"); // 姓名
		sqlBuilder.append("a0.OUTTIME,"); // 停发时间
		sqlBuilder.append("a0.DS,");
		sqlBuilder.append("a0.SV ");
		sqlBuilder.append("FROM BD_MM_WH a0 ");
		sqlBuilder.append("LEFT JOIN bd_wh a0b1 ");
		sqlBuilder.append("ON a0.ID_WH = a0b1.ID_WH ");
		sqlBuilder.append("LEFT JOIN BD_MM a0b2 ");
		sqlBuilder.append("ON a0.ID_MM = a0b2.ID_MM ");
		sqlBuilder.append("LEFT JOIN BD_SRV bdsrv ");
		sqlBuilder.append("ON bdsrv.ID_SRV = a0b2.ID_SRV ");
		sqlBuilder.append("LEFT JOIN bd_location a0b3 ");
		sqlBuilder.append("ON a0.ID_LOC = a0b3.ID_LOC ");
		sqlBuilder.append("LEFT JOIN bd_udidoc a0b4 ");
		sqlBuilder.append("ON a0.ID_CYCLEU = a0b4.ID_UDIDOC ");
		sqlBuilder.append("LEFT JOIN BD_MM_PKGU a0b5 ");
		sqlBuilder.append("ON a0.ID_MMPKGU_UI = a0b5.ID_MMPKGU ");
		sqlBuilder.append("LEFT JOIN bd_wh a0b6 ");
		sqlBuilder.append("ON a0.ID_WH_SRV = a0b6.ID_WH ");
		sqlBuilder.append("LEFT JOIN bd_dep a0b7 ");
		sqlBuilder.append("ON a0.ID_DEP = a0b7.ID_DEP ");
		sqlBuilder.append("LEFT JOIN bd_psndoc a0b12 ");
		sqlBuilder.append("ON a0.PSNOUT = a0b12.ID_PSNDOC ");
		sqlBuilder.append("LEFT JOIN BD_SUP SUP ");
		sqlBuilder.append("ON SUP.ID_SUP = a0b2.ID_SUP ");
		sqlBuilder.append("WHERE 1 = 1 ");

		if (StringUtils.isNotBlank(wherePart)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, WarehouseInfoDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotBlank(wherePart)) {
			sqlBuilder.append(" and ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 更新计算字段
	 * 
	 * @param pagingRtnData
	 * @throws BizException
	 */
	private void updateCalField(PagingRtnData<WarehouseInfoDO> pagingRtnData) throws BizException {
		if (pagingRtnData != null && pagingRtnData.getPageData().size() > 0) {
			List<WarehouseInfoDO> result = new ArrayList<WarehouseInfoDO>();
			for (Object warehouseInfoDO : pagingRtnData.getPageData().toArray()) {
				result.add((WarehouseInfoDO) warehouseInfoDO);
			}

			WhmmReAfterBp bp = new WhmmReAfterBp();
			bp.exec(result.toArray(new WarehouseInfoDO[result.size()]));
		}
	}

}
