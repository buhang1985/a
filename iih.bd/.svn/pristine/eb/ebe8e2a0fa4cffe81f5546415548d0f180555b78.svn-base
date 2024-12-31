package iih.bd.res.bed.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeTypeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedAggDO;
import iih.bd.res.bed.d.BedPatchDTO;
import iih.bd.res.bed.i.IBedCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.bd.utils.UdidocUtils;
import org.apache.commons.lang.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 批量添加床位业务逻辑
 * 
 * @author hao_wu 2018-11-21
 *
 */
public class PatchAddBedBp {

	public Bdbed[] exec(BedPatchDTO bedPatchDto, String id_dep) throws BizException {
		validateParam(bedPatchDto, id_dep);

		BedAggDO[] beds = createBeds(bedPatchDto, id_dep);

		checkRepeat(beds, id_dep);

		IBedCudService bedCudService = ServiceFinder.find(IBedCudService.class);
		BedAggDO[] result = bedCudService.insert(beds);

		Bdbed[] bedDoArray = getBedDoList(result);

		return bedDoArray;
	}

	/**
	 * 创建床位集合
	 * 
	 * @param bedPatchDto
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	private BedAggDO[] createBeds(BedPatchDTO bedPatchDto, String id_dep) throws BizException {
		Integer beginNo = bedPatchDto.getBedpreno();
		Integer endNo = bedPatchDto.getBedendno();
		// 如果为负数，取0
		if (beginNo < 0) {
			beginNo = 0;
		}
		if (endNo < 0) {
			endNo = 0;
		}
		// 取后三位
		beginNo = beginNo % 1000;
		endNo = endNo % 1000;

		ArrayList<BedAggDO> bedList = new ArrayList<BedAggDO>();
		for (int i = beginNo; i <= endNo; i++) {
			BedAggDO newBed = createNewBed(id_dep, bedPatchDto, i);
			bedList.add(newBed);
		}
		return bedList.toArray(new BedAggDO[0]);
	}

	/**
	 * 验证参数
	 * 
	 * @param bedPatchDto
	 * @param id_dep
	 * @throws BizException
	 */
	private void validateParam(BedPatchDTO bedPatchDto, String id_dep) throws BizException {
		if (bedPatchDto == null) {
			throw new BizException("床位批量操作DTO为空。");
		}
		if (StringUtils.isBlank(id_dep)) {
			throw new BizException("科室id为空。");
		}
		Integer beginNo = bedPatchDto.getBedpreno();
		if (beginNo == null) {
			throw new BizException("起始床位号为空。");
		}
		Integer endNo = bedPatchDto.getBedendno();
		if (endNo == null) {
			throw new BizException("结束床位号为空。");
		}
	}

	/**
	 * 唯一性校验
	 * 
	 * @param aggList 床位列表
	 * @throws BizException
	 */
	private void checkRepeat(BedAggDO[] beds, String id_dep) throws BizException {
		if (ArrayUtils.isEmpty(beds)) {
			return;
		}

		IBedMDORService bedMDORService = ServiceFinder.find(IBedMDORService.class);
		String whereStr = String.format("a0.id_grp = '%s' and a0.id_org = '%s' and a0.id_dep_belong = '%s'",
				Context.get().getGroupId(), Context.get().getOrgId(), id_dep);
		Bdbed[] bedList = bedMDORService.find(whereStr, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(bedList)) {
			return;
		}

		for (BedAggDO bedAggDO : beds) {
			Bdbed mData = bedAggDO.getParentDO();
			for (Bdbed bdbed : bedList) {
				if (mData.getCode().equals(bdbed.getCode()))
					throw new BizException(String.format("床位编码重复,重复编码:%s.", bdbed.getCode()));
				if (mData.getName().equals(bdbed.getName()))
					throw new BizException(String.format("床位名称重复,重复名称:%s.", bdbed.getName()));
			}
		}
	}

	/**
	 * Agg列表转主DO列表
	 * 
	 * @param result
	 * @return
	 */
	private Bdbed[] getBedDoList(BedAggDO[] result) {
		ArrayList<Bdbed> bdbedList = new ArrayList<Bdbed>();
		for (BedAggDO bedAggDO : result) {
			bdbedList.add(bedAggDO.getParentDO());
		}
		return bdbedList.toArray(new Bdbed[0]);
	}

	/**
	 * 创建新的床位信息
	 * 
	 * @param id_dep   科室id
	 * @param id_bedtp 床位类型id
	 * @param bednopre 床位前缀符
	 * @param bedno    床号
	 * @return 床位信息
	 * @throws BizException
	 */
	private BedAggDO createNewBed(String id_dep, BedPatchDTO bedPatchDto, int bedno) throws BizException {
		BedAggDO bedAggDO = new BedAggDO();
		Bdbed mData = bedAggDO.getParentDO();
		if (mData == null) {
			mData = new Bdbed();
			bedAggDO.setParentDO(mData);
		}

		mData.setStatus(DOStatus.NEW);
		// 集团
		mData.setId_grp(Context.get().getGroupId());
		// 机构
		mData.setId_org(Context.get().getOrgId());
		// 名称
		String name = String.format("%s%03d", bedPatchDto.getBednopre() == null ? "" : bedPatchDto.getBednopre(),
				bedno);
		mData.setName(name);
		// 编码
		mData.setCode(mData.getName());
		// 床位类型
		mData.setId_bedtp(bedPatchDto.getId_bedtp());
		mData.setSd_bedtp(bedPatchDto.getSd_bedtp());
		// 启用标识
		mData.setFg_act(FBoolean.TRUE);
		// 所属科室
		mData.setId_dep_belong(id_dep);
		// 床位费用
		mData.setId_bltpl(bedPatchDto.getId_bltpl());
		mData.setBltpl_name(bedPatchDto.getBltpl_name());
		// 包床费用
		mData.setId_bltpl_rent(bedPatchDto.getId_bltpl_rent());
		mData.setBltpl_rent_name(bedPatchDto.getBltpl_rent_name());
		// 床位状态
		UdidocDO bedStatus = UdidocUtils.getUdidocByCode(IBdResDictCodeTypeConst.SD_BEDSU,
				IBdResDictCodeConst.SD_BEDSU_EMPTY);
		mData.setId_bedsu(bedStatus.getId_udidoc());
		mData.setSd_bedsu(bedStatus.getCode());

		return bedAggDO;
	}
}
