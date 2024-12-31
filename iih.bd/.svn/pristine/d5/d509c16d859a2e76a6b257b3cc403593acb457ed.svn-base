package iih.bd.res.bizgrp.s.bp;

import iih.bd.res.bizgrp.d.BizGrpBedDO;
import iih.bd.res.bizgrp.s.bp.sql.GetBedSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 查询床位表并关联上相关属性BP(用业务组床位BizGrpBedDO来接收数据)
 * @author guoyang
 *
 */
public class GetBedBp {

	public PagingRtnData<BizGrpBedDO> exec(PaginationInfo pg, String wherePart, String orderByPart) throws BizException {
		GetBedSql sql = new GetBedSql(wherePart);
		PagingServiceImpl<BizGrpBedDO> pagingServiceImpl = new PagingServiceImpl<BizGrpBedDO>();
		PagingRtnData<BizGrpBedDO> bizGrpBed = pagingServiceImpl.findByPageInfo(new BizGrpBedDO(), pg, sql.getQrySQLStr(), orderByPart, null);
		return bedAttr(bizGrpBed);
	}

	/**
	 * 给查询出的床位赋上床位特征转字符串
	 * @param bizGrpBed
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private PagingRtnData<BizGrpBedDO> bedAttr(PagingRtnData<BizGrpBedDO> bizGrpBed) throws BizException {
		
		FArrayList bizGrpBedDOs = bizGrpBed.getPageData();
		if (bizGrpBedDOs == null || bizGrpBedDOs.size() <= 0) {
			return bizGrpBed;
		}
		BizGrpBedDO[] bizGrpBedDOArr = (BizGrpBedDO[])bizGrpBedDOs.toArray(new BizGrpBedDO[bizGrpBedDOs.size()]);
		String[] ids = getIdbed(bizGrpBedDOs);
		UpdateBedAttrsBp bp = new UpdateBedAttrsBp();
		bp.exec(ids, bizGrpBedDOArr);
		return bizGrpBed;
	}
	
	/**
	 * 获取业务组床位的集合的床位id
	 * @param bizGrpBedDOs
	 * @return
	 */
	private String[] getIdbed(FArrayList bizGrpBedDOs) {
		String[] ids = new String[bizGrpBedDOs.size()];
		for (int i = 0; i < bizGrpBedDOs.size(); i++) {
			BizGrpBedDO bizGrpBedDO = (BizGrpBedDO)bizGrpBedDOs.get(i);
			ids[i] = bizGrpBedDO.getId_bed();
		}
		return ids;
	}
}
